package com.wechat.demo.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 公众号接收消息实体类
 *     微信服务器传过来的xml数据包中的xml元素都是大写开头的,故以下变量都对应大写
 *     @XmlRootElement 是一个类级别注解,主要属性为name,意为指定根节点的名字.微信传过来的xml数据，里面的根节点就是"xml",直接设置name="xml"
 *     @XmlAccessorType 用于定义这个类中的何种类型需要映射到XML中.
 *      XmlAccessType.PROPERTY:代表映射这个类中的属性（get/set方法）到XML.
 *      XmlAccessType.FIELD:代表映射这个类中的所有字段到XML(字段名与xml中大小写一致)
 *
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class InMsgEntity {
    //开发者微信号(公众号)
    @XmlElement(name="FromUserName")
    private String fromUserName;
    //消息发送方的OpenId
    @XmlElement(name="ToUserName")
    private String toUserName;
    //消息创建时间(1348831860)
    @XmlElement(name="CreateTime")
    private long createTime;
    /**
     * 消息类型
     * text 文本消息
     * image 图片消息
     * voice 语音消息
     * video 视频消息
     * music 音乐消息
     */
    @XmlElement(name="MsgType")
    private String msgType;
    //消息id
    @XmlElement(name="MsgId")
    private Long msgId;
    //文本消息内容
    @XmlElement(name="Content")
    private String content;
    //图片Url
    @XmlElement(name="PicUrl")
    private String picUrl;
    //图片消息媒体id，可以调用多媒体文件下载接口拉取数据
    @XmlElement(name="MediaId")
    private String mediaId;
    /**
     * 事件类型
     * subscribe(订阅)
     * unsubscribe(取消订阅)
     * LOCATION(上报地理位置)
     * CLICK(点击普通的菜单)
     * VIEW(点击跳转链接的菜单)
     */
    @XmlElement(name="Event")
    private String event;
    //菜单按钮的key值
    @XmlElement(name="EventKey")
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
