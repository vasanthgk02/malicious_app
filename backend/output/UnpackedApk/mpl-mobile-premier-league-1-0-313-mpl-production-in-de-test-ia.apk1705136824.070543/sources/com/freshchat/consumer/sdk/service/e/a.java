package com.freshchat.consumer.sdk.service.e;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.j.ab.b;
import org.apache.fontbox.cmap.CMapParser;

public class a implements j {
    public boolean fE;
    public boolean fF;
    @b
    public User user;

    public boolean cN() {
        return this.fE;
    }

    public boolean cY() {
        return this.fF;
    }

    public User getUser() {
        return this.user;
    }

    public void n(boolean z) {
        this.fE = z;
    }

    public void o(boolean z) {
        this.fF = z;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CreateOrUpdateUserRequest [user=");
        outline73.append(this.user);
        outline73.append(", forceUserCreate = ");
        return GeneratedOutlineSupport.outline66(outline73, this.fE, CMapParser.MARK_END_OF_ARRAY);
    }
}
