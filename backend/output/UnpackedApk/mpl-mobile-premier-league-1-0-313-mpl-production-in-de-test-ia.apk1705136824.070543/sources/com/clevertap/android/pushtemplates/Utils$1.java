package com.clevertap.android.pushtemplates;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.concurrent.Callable;

public class Utils$1 implements Callable<Void> {
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ String val$message;

    public Utils$1(String str, Context context) {
        this.val$message = str;
        this.val$context = context;
    }

    public Object call() throws Exception {
        if (!TextUtils.isEmpty(this.val$message)) {
            Toast.makeText(this.val$context, this.val$message, 0).show();
        }
        return null;
    }
}
