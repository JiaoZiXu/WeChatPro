package com.wechat.demo.utils;
/**
 * 微信测试账号
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public class WeChatTestAccountUtil {
    //URL验证时使用的token
    public static final String TOKEN_TEST = "token_xxc";
    //appId
    public static final String APP_ID_TEST = "wx2aea8c208da76808";
    //appSecret
    public static final String SECRET_TEST = "4da5d96b12e533484e6be247bd40c470";
    //创建菜单接口的地址
    public static final String CREATE_MENU_URL_TEST = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    //获取access_token的接口地址
    public static final String GET_ACCESS_TOKEN_URL_TEST = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    //缓存的access_token
    private static String accessToken;
    //access_token的失效时间
    private  static  long expiresTime;

    /**
     * 获取access_token
     * @return
     */
    public static String getAccessTokenTest(){
        //判断access_token是否过期，如果过期则重新获取
        if(accessToken==null || expiresTime < new Date().getTime()){
            //发起请求获取accessToken
            String result = HttpUtil.getHttp(GET_ACCESS_TOKEN_URL_TEST.replace("APPID",APP_ID_TEST).replace("APPSECRET",SECRET_TEST));
            JSONObject json = JSON.parseObject(result);
            //缓存access_token
            accessToken = json.getString("access_token");
            //设置accessToken失效时间
            long expires_in = json.getLong("expires_in");
            //失效时间 = 当前时间+有效期(提前一分钟)
            expiresTime = new Date().getTime() + (expires_in-60) * 1000;
        }
        return accessToken;
    }

    /**
     * 创建自定义菜单
     * @param menu
     * @return
     */
    public String createMenu(String menu){
        String result = HttpUtil.postData(CREATE_MENU_URL_TEST.replace("accessToken",getAccessTokenTest()),menu);
        return null;
    }


}
