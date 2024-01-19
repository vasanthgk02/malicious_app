package com.freshchat.consumer.sdk.activity;

import android.os.Bundle;
import androidx.loader.app.LoaderManager.LoaderCallbacks;
import androidx.loader.content.Loader;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.y;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.g.g;
import com.freshchat.consumer.sdk.j.dd;
import com.mpl.payment.paytm.PaytmRequestConstants;

public class n implements LoaderCallbacks<Channel> {
    public final /* synthetic */ ConversationDetailActivity be;

    public n(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    /* renamed from: a */
    public void onLoadFinished(Loader<Channel> loader, Channel channel) {
        if (channel == null) {
            this.be.finish();
            i.a(this.be.getContext(), c.CHANNEL_INFO_INVALID);
        } else if (channel.isHidden()) {
            i.a(this.be.getContext(), R.string.freshchat_channel_disabled);
            this.be.finish();
        } else {
            this.be.channelId = channel.getId();
            this.be.aK = channel.getName();
            this.be.channelType = channel.getChannelType();
            this.be.quickActions = channel.getQuickActions();
            ConversationDetailActivity conversationDetailActivity = this.be;
            conversationDetailActivity.quickActionsMenuList = conversationDetailActivity.quickActions.getQuickActionsMenuList();
            ConversationDetailActivity conversationDetailActivity2 = this.be;
            conversationDetailActivity2.quickActionsSlashCommandList = conversationDetailActivity2.quickActions.getQuickActionsSlashCommandList();
            if (!this.be.quickActionsSlashCommandList.isEmpty()) {
                ConversationDetailActivity conversationDetailActivity3 = this.be;
                y yVar = new y(this.be.getContext(), R.layout.freshchat_quick_actions_slash_command_items, R.id.freshchat_slash_command_actions, this.be.quickActionsSlashCommandList, true);
                conversationDetailActivity3.jp = yVar;
                ConversationDetailActivity conversationDetailActivity4 = this.be;
                conversationDetailActivity4.js = new dd(conversationDetailActivity4.getContext(), this.be.jp);
                this.be.kk();
                this.be.kg();
            }
            ConversationDetailActivity.aS = this.be.channelId;
            if (this.be.getSupportActionBar() != null) {
                this.be.getSupportActionBar().setTitle((CharSequence) this.be.aK);
                this.be.ae();
            }
            if (this.be.ag()) {
                this.be.ah();
            }
            if (loader instanceof g) {
                this.be.aL = ((g) loader).dg();
            }
            this.be.et();
            this.be.U();
        }
    }

    public Loader<Channel> onCreateLoader(int i, Bundle bundle) {
        g gVar;
        if (bundle != null) {
            gVar = new g(this.be.getApplicationContext(), bundle.getBoolean("EXTRA_FORCE_CLEAN_UP_EXPIRED_CSAT"), bundle.getLong(PaytmRequestConstants.PARAMS_CHANNEL_ID));
            return gVar;
        }
        gVar = new g(this.be.getApplicationContext(), false);
        return gVar;
    }

    public void onLoaderReset(Loader<Channel> loader) {
        this.be.channelId = 0;
        this.be.aK = "";
        this.be.channelType = null;
        this.be.aL = null;
    }
}
