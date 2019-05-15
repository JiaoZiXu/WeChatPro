package com.wechat.demo.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 公众号回复消息实体类
 *     微信服务器传过来的xml数据包中的xml元素都是大写开头的,故以下变量都对应大写
 *     @XmlRootElement 是一个类级别注解,主要属性为name,意为指定根节点的名字.微信传过来的xml数据，里面的根节点就是"xml",直接设置name="xml"
 *     @XmlAccessorType 用于定义这个类中的何种类型需要映射到XML中.
 *      XmlAccessType.PROPERTY:代表映射这个类中的属性（get/set方法）到XML.
 *      XmlAccessType.FIELD:代表映射这个类中的所有字段到XML(字段名与xml中大小写一致)
 *     @XmlElementWrapper 注解可以在原xml结点上再包装一层xml,但仅允许出现在数组或集合属性上.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutMsgEntity {
    //开发者微信号(公众号)
    private String FromUserName;
    //消息发送方的OpenId
    private String ToUserName;
    //消息创建时间(1348831860)
    private long CreateTime;
    /**
     * 消息类型
     * text 文本消息
     * image 图片消息
     * voice 语音消息
     * video 视频消息
     * music 音乐消息
     */
    private String MsgType;
    //消息id
    private Long MsgId;
    //文本消息内容
    private String Content;
    //图片Url
    private String PicUrl;
    //图片消息媒体id，可以调用多媒体文件下载接口拉取数据
    @XmlElementWrapper(name="Image")
    private String[] MediaId ;

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String[] getMediaId() {
        return MediaId;
    }

    public void setMediaId(String[] mediaId) {
        MediaId = mediaId;
    }
}
