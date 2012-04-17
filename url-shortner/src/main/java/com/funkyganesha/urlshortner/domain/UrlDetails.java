package com.funkyganesha.urlshortner.domain;

import com.google.code.morphia.AbstractMongoEntity;
import com.google.code.morphia.annotations.MongoID;

public class UrlDetails extends AbstractMongoEntity {


    private String id;
    private String longUrl;
    private String shorturl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShorturl() {
        return shorturl;
    }

    public void setShorturl(String shorturl) {
        this.shorturl = shorturl;
    }

    @Override
    public String toString() {
        return "UrlDetails{" +
                "id=" + id +
                ", longUrl='" + longUrl + '\'' +
                ", shorturl='" + shorturl + '\'' +
                '}';
    }
}
