
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 malin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.malin.rengwuxianrxjava.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 类描述:GitHub API 中的User
 * 创建人:malin.myemail@gmail.com
 * 创建时间:16-1-24
 * 备注:使用:http://www.jsonschema2pojo.org/这个网站就Json自动转换为POJO
 */
public class User {

    @SerializedName("login")
    @Expose
    public String login;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("avatar_url")
    @Expose
    public String avatarUrl;
    @SerializedName("gravatar_id")
    @Expose
    public String gravatarId;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("html_url")
    @Expose
    public String htmlUrl;
    @SerializedName("followers_url")
    @Expose
    public String followersUrl;
    @SerializedName("following_url")
    @Expose
    public String followingUrl;
    @SerializedName("gists_url")
    @Expose
    public String gistsUrl;
    @SerializedName("starred_url")
    @Expose
    public String starredUrl;
    @SerializedName("subscriptions_url")
    @Expose
    public String subscriptionsUrl;
    @SerializedName("organizations_url")
    @Expose
    public String organizationsUrl;
    @SerializedName("repos_url")
    @Expose
    public String reposUrl;
    @SerializedName("events_url")
    @Expose
    public String eventsUrl;
    @SerializedName("received_events_url")
    @Expose
    public String receivedEventsUrl;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("site_admin")
    @Expose
    public Boolean siteAdmin;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("company")
    @Expose
    public String company;
    @SerializedName("blog")
    @Expose
    public String blog;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("hireable")
    @Expose
    public Boolean hireable;
    @SerializedName("bio")
    @Expose
    public Object bio;
    @SerializedName("public_repos")
    @Expose
    public Integer publicRepos;
    @SerializedName("public_gists")
    @Expose
    public Integer publicGists;
    @SerializedName("followers")
    @Expose
    public Integer followers;
    @SerializedName("following")
    @Expose
    public Integer following;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;


    @Override
    public String toString() {
        return "User{" +
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
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", blog='" + blog + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                ", hireable=" + hireable +
                ", bio=" + bio +
                ", publicRepos=" + publicRepos +
                ", publicGists=" + publicGists +
                ", followers=" + followers +
                ", following=" + following +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
