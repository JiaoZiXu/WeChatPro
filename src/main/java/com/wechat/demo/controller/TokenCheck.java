package com.wechat.demo.controller;

import com.wechat.demo.domain.InMsgEntity;
import com.wechat.demo.domain.OutMsgEntity;
import com.wechat.demo.utils.SHA1;
import com.wechat.demo.utils.WeChatUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

@RestController
public class TokenCheck {
    private static Logger logger = LoggerFactory.getLogger(TokenCheck.class);

    @RequestMapping("index")
    public String indexTest(){
        return "index";
    }

    /**
     * 微信URL接入校验
     * @return
     */
    @RequestMapping(value = "/weChat",method = RequestMethod.GET)
    @ResponseBody
    public String tokenCheck(String signature,String timestamp,String nonce,String echostr){
        String[] arr = {WeChatUtil.TOKEN,timestamp,nonce};
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(String str : arr){
            sb.append(str);
        }
        String mySignature = SHA1.encode(sb.toString());
        if (mySignature.equals(signature)){
            logger.info("token validation success !");
            return echostr;
        }
        logger.info("token validation fialed !");
        return null;
    }

    /**
     * 微信消息处理
     * @return
     */
    @RequestMapping(value = "/weChat",method = RequestMethod.POST,produces= {MediaType.TEXT_XML_VALUE})
    @ResponseBody
    public Object handleMsg(@RequestBody InMsgEntity msg){
        OutMsgEntity outMsg = new OutMsgEntity();
        outMsg.setFromUserName(msg.getToUserName());
        outMsg.setToUserName(msg.getFromUserName());
        String msgType = msg.getMsgType();
        outMsg.setMsgType(msgType);
        String outContent = null;
        if("text".equals(msgType)){
            String inContent = msg.getContent();
            if(inContent.contains("sb")){
                outContent = "你TM才sb呢! 你全家都sb!";
            }else if(inContent.contains("许晓晨")){
                outContent = "许晓晨是个帅b!";
            }else if(inContent.contains("冒小伟")){
                outContent = "冒小伟是个帅b!";
            }else if(inContent.contains("杨建")){
                outContent = "杨建是个帅b!";
            }else if(inContent.contains("朱霞")){
                outContent = "朱霞真漂亮!";
            }else {
                outContent = inContent;
            }
            outMsg.setContent(outContent);
        }else if("image".equals(msgType)){
            outMsg.setMediaId(new String[]{msg.getMediaId()});
//            outContent = "图片任你发,回复图片算我输! [猪头]";
//            outMsg.setMsgType("text");
//            outMsg.setContent(outContent);
        }else if("event".equals(msgType)){
            if("subscribe".equals(msg.getEvent())){
                //订阅
                outMsg.setContent("你好，欢迎关注雷喵喵尔！[愉快]");
                outMsg.setMsgType("text");
            }else if("click".equals(msg.getEvent())){
                ///获取所点击菜单的key值
                String key = msg.getEventKey();
                //配合具体菜单内容测试
                if("".equals(key)){
                    outContent="";
                }else if("".equals(key)){
                    outContent="";
                }else if("".equals(key)){
                    outContent="";
                }
                //设置消息的响应类型
                outMsg.setMsgType("text");
                outMsg.setContent(outContent);
            }

        }

        outMsg.setCreateTime(new Date().getTime());
        System.out.println(outMsg.toString());
        return outMsg;
    }

}
