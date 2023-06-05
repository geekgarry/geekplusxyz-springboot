/**
 * author     : geekplus
 * email      : geekcjj@gmail.com
 * date       : 2/18/23 21:28
 * description: 做什么的？
 */
package com.maike.webapp.function.domain;

import java.io.Serializable;

public class ChatPrompt implements Serializable {
    //聊天用户
    private String userId;
    //聊天用户
    private String username;
    //聊天内容
    private String data;
    //聊天代码
    private String code;

    private String openAiKey;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenAiKey() {
        return openAiKey;
    }

    public void setOpenAiKey(String openAiKey) {
        this.openAiKey = openAiKey;
    }
}
