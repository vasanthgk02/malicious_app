package com.freshchat.consumer.sdk.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.freshchat.consumer.sdk.ConversationOptions;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.j.z;
import java.util.ArrayList;
import java.util.Collection;

public abstract class c<T extends z> {
    public Context context;
    public T hm;
    public Class hn;
    public String[] lE;

    public static c a(Context context2, z zVar) {
        if (context2 != null) {
            c cVar = null;
            Collection arrayList = new ArrayList();
            if (zVar instanceof FaqOptions) {
                cVar = new v();
                arrayList = ((FaqOptions) zVar).getTags();
            } else if (zVar instanceof ConversationOptions) {
                cVar = new m();
                arrayList = ((ConversationOptions) zVar).getTags();
            }
            cVar.a((T) zVar);
            cVar.setContext(context2);
            if (k.a(arrayList)) {
                cVar.d((String[]) arrayList.toArray(new String[0]));
            }
            return cVar;
        }
        throw new IllegalArgumentException("A valid Context is required for the view launcher");
    }

    private void d(String[] strArr) {
        this.lE = strArr;
    }

    public c a(Class cls) {
        this.hn = cls;
        return this;
    }

    public void a(T t) {
        this.hm = t;
    }

    public void b(Bundle bundle) {
        try {
            if (ed() != null) {
                Intent intent = new Intent(this.context, ed());
                if (!(this.context instanceof Activity)) {
                    intent.setFlags(335544320);
                }
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                intent.putExtras(eb());
                if (as.f(this.lE)) {
                    intent.putExtra("INPUT_TAGS", this.lE);
                }
                this.context.startActivity(intent);
            }
        } catch (Exception e2) {
            String string = getContext().getString(R.string.freshchat_error_message_failed_to_launch_support_section);
            ai.e("FRESHCHAT", string, e2);
            i.e(getContext(), string);
        }
    }

    public abstract void ea();

    public abstract Bundle eb();

    public T ec() {
        return this.hm;
    }

    public Class ed() {
        return this.hn;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context2) {
        this.context = context2;
    }
}
