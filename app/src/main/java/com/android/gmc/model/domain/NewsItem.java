package com.android.gmc.model.domain;

import com.google.gson.annotations.SerializedName;

public class NewsItem {
    @SerializedName("title") private String title;
    @SerializedName("description") private String description;
    @SerializedName("image_url") private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
