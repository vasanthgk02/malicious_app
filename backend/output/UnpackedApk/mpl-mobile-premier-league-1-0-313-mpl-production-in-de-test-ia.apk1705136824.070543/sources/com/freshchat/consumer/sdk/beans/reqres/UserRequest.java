package com.freshchat.consumer.sdk.beans.reqres;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.User;
import com.google.gson.annotations.SerializedName;
import org.apache.fontbox.cmap.CMapParser;

public class UserRequest {
    @SerializedName("jwtAuthToken")
    public String jwtIdToken;
    public User user;

    public String getJwtIdToken() {
        return this.jwtIdToken;
    }

    public User getUser() {
        return this.user;
    }

    public void setJwtIdToken(String str) {
        this.jwtIdToken = str;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UserRequest [user=");
        outline73.append(this.user);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
