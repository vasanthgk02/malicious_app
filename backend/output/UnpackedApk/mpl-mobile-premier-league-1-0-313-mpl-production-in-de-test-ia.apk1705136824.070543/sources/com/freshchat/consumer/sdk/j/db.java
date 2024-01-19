package com.freshchat.consumer.sdk.j;

import android.content.Intent;
import android.view.View;
import com.freshchat.consumer.sdk.a.w.b;
import com.freshchat.consumer.sdk.activity.BotFaqDetailsActivity;
import com.freshchat.consumer.sdk.beans.fragment.StaticTemplateFragment;

public class db implements b {
    public final /* synthetic */ ak iC;

    public db(ak akVar) {
        this.iC = akVar;
    }

    public void a(View view, StaticTemplateFragment staticTemplateFragment, String str) {
        Intent intent = new Intent(this.iC.context, BotFaqDetailsActivity.class);
        intent.putExtra("MESSAGE_ALIAS", str);
        intent.putExtra("EXTRA_TITLE", staticTemplateFragment.getLabel());
        intent.putExtra("REFERENCE_ID", staticTemplateFragment.getReferenceId());
        intent.putExtra("PLACEOLDER_REFERENCE_ID", staticTemplateFragment.getPlaceholderReferenceId());
        this.iC.context.startActivity(intent);
    }
}
