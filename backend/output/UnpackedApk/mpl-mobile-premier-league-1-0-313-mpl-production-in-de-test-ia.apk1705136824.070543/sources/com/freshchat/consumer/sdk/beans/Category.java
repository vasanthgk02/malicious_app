package com.freshchat.consumer.sdk.beans;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class Category implements ICategory {
    public static final String JSON_TAG_CATEGORY_ALIAS = "categoryAlias";
    public static final String JSON_TAG_CATEGORY_ID = "categoryId";
    public static final String JSON_TAG_DESCRIPTION = "description";
    public static final String JSON_TAG_POSITION = "position";
    public static final String JSON_TAG_TITLE = "title";
    public static final String JSON_TAG_UPDATED_AT = "lastUpdatedAt";
    public static final String JSON_TAG_URL = "icon";
    public String categoryAlias;
    public String description;
    public String iconUrl;
    public String id;
    public int position;
    public String title;
    public long updatedAt;

    public static Category getCategory(JSONObject jSONObject) throws JSONException {
        Category updatedAt2 = new Category().setId(jSONObject.getString("categoryId")).setTitle(jSONObject.getString("title")).setDescription(jSONObject.optString("description")).setIconUrl(jSONObject.optString("icon")).setPosition(jSONObject.getInt("position")).setUpdatedAt(jSONObject.getLong("lastUpdatedAt"));
        if (jSONObject.has(JSON_TAG_CATEGORY_ALIAS)) {
            updatedAt2.setCategoryAlias(jSONObject.getString(JSON_TAG_CATEGORY_ALIAS));
        }
        return updatedAt2;
    }

    public String getCategoryAlias() {
        return this.categoryAlias;
    }

    public String getCategoryId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public int getPosition() {
        return this.position;
    }

    public String getTitle() {
        return this.title;
    }

    public long getUpdatedAt() {
        return this.updatedAt;
    }

    public Category setCategoryAlias(String str) {
        this.categoryAlias = str;
        return this;
    }

    public Category setDescription(String str) {
        this.description = str;
        return this;
    }

    public Category setIconUrl(String str) {
        this.iconUrl = str;
        return this;
    }

    public Category setId(String str) {
        this.id = str;
        return this;
    }

    public Category setPosition(int i) {
        this.position = i;
        return this;
    }

    public Category setTitle(String str) {
        this.title = str;
        return this;
    }

    public Category setUpdatedAt(long j) {
        this.updatedAt = j;
        return this;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("Category{", "id='");
        GeneratedOutlineSupport.outline99(outline77, this.id, ExtendedMessageFormat.QUOTE, ", title='");
        GeneratedOutlineSupport.outline99(outline77, this.title, ExtendedMessageFormat.QUOTE, ", description='");
        GeneratedOutlineSupport.outline99(outline77, this.description, ExtendedMessageFormat.QUOTE, ", iconUrl='");
        GeneratedOutlineSupport.outline99(outline77, this.iconUrl, ExtendedMessageFormat.QUOTE, ", position='");
        outline77.append(this.position);
        outline77.append(ExtendedMessageFormat.QUOTE);
        outline77.append(", categoryAlias='");
        outline77.append(this.categoryAlias);
        outline77.append(ExtendedMessageFormat.QUOTE);
        outline77.append(", updatedAt=");
        outline77.append('}');
        return outline77.toString();
    }
}
