package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.mipush.sdk.PushMessageHandler.a;
import java.util.ArrayList;
import java.util.List;

public class MiPushCommandMessage implements a {
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_COMMAND = "command";
    public static final String KEY_COMMAND_ARGUMENTS = "commandArguments";
    public static final String KEY_REASON = "reason";
    public static final String KEY_RESULT_CODE = "resultCode";
    public static final long serialVersionUID = 1;
    public String category;
    public String command;
    public List<String> commandArguments;
    public String reason;
    public long resultCode;

    public static MiPushCommandMessage fromBundle(Bundle bundle) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.command = bundle.getString(KEY_COMMAND);
        miPushCommandMessage.resultCode = bundle.getLong(KEY_RESULT_CODE);
        miPushCommandMessage.reason = bundle.getString("reason");
        miPushCommandMessage.commandArguments = bundle.getStringArrayList(KEY_COMMAND_ARGUMENTS);
        miPushCommandMessage.category = bundle.getString("category");
        return miPushCommandMessage;
    }

    public String getCategory() {
        return this.category;
    }

    public String getCommand() {
        return this.command;
    }

    public List<String> getCommandArguments() {
        return this.commandArguments;
    }

    public String getReason() {
        return this.reason;
    }

    public long getResultCode() {
        return this.resultCode;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void setCommandArguments(List<String> list) {
        this.commandArguments = list;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setResultCode(long j) {
        this.resultCode = j;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_COMMAND, this.command);
        bundle.putLong(KEY_RESULT_CODE, this.resultCode);
        bundle.putString("reason", this.reason);
        List<String> list = this.commandArguments;
        if (list != null) {
            bundle.putStringArrayList(KEY_COMMAND_ARGUMENTS, (ArrayList) list);
        }
        bundle.putString("category", this.category);
        return bundle;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("command={");
        outline73.append(this.command);
        outline73.append("}, resultCode={");
        outline73.append(this.resultCode);
        outline73.append("}, reason={");
        outline73.append(this.reason);
        outline73.append("}, category={");
        outline73.append(this.category);
        outline73.append("}, commandArguments={");
        return GeneratedOutlineSupport.outline64(outline73, this.commandArguments, "}");
    }
}
