package com.malin.rxjava.model;

/**
 * 类描述::GitHub API 中的Contributor
 * 创建人:malin.myemail@gmail.com
 * 创建时间:16-1-24
 * 备注:https://github.com/kaushikgopal/RxJava-Android-Samples
 * 使用:http://www.jsonschema2pojo.org/这个网站就Json自动转换为POJO
 */

public class Contributor {
    public String login;
    public Integer id;
    public String avatarUrl;
    public String gravatarId;
    public String url;
    public String htmlUrl;
    public String followersUrl;
    public String followingUrl;
    public String gistsUrl;
    public String starredUrl;
    public String subscriptionsUrl;
    public String organizationsUrl;
    public String reposUrl;
    public String eventsUrl;
    public String receivedEventsUrl;
    public String type;
    public Boolean siteAdmin;
    public Integer contributions;

    @Override
    public String toString() {
        return "Contributor{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gravatarId='" + gravatarId + '\'' +
                ", url='" + url + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                ", followersUrl='" + followersUrl + '\'' +
                ", followingUrl='" + followingUrl + '\'' +
                ", gistsUrl='" + gistsUrl + '\'' +
                ", starredUrl='" + starredUrl + '\'' +
                ", subscriptionsUrl='" + subscriptionsUrl + '\'' +
                ", organizationsUrl='" + organizationsUrl + '\'' +
                ", reposUrl='" + reposUrl + '\'' +
                ", eventsUrl='" + eventsUrl + '\'' +
                ", receivedEventsUrl='" + receivedEventsUrl + '\'' +
                ", type='" + type + '\'' +
                ", siteAdmin=" + siteAdmin +
                ", contributions=" + contributions +
                '}';
    }
}

