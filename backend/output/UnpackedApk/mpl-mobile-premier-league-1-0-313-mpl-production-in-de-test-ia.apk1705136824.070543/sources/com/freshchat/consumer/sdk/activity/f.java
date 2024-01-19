package com.freshchat.consumer.sdk.activity;

import android.os.Bundle;
import androidx.loader.app.LoaderManager.LoaderCallbacks;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.BatchingListUpdateCallback;
import androidx.recyclerview.widget.DiffUtil.Diagonal;
import androidx.recyclerview.widget.DiffUtil.DiffResult;
import androidx.recyclerview.widget.DiffUtil.PostponedUpdate;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.g.i;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;
import com.mpl.payment.paytm.PaytmRequestConstants;
import java.util.ArrayDeque;
import java.util.List;

public class f implements LoaderCallbacks<List<Message>> {
    public final /* synthetic */ ConversationDetailActivity be;

    public f(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    /* renamed from: a */
    public void onLoadFinished(Loader<List<Message>> loader, List<Message> list) {
        BatchingListUpdateCallback batchingListUpdateCallback;
        int i;
        Loader<List<Message>> loader2 = loader;
        List<Message> list2 = list;
        DiffResult b2 = this.be.lz.b(this.be.aM, list2);
        this.be.aM.clear();
        this.be.aM.addAll(list2);
        this.be.aN.clear();
        i iVar = (i) loader2;
        List<Participant> participants = iVar.getParticipants();
        if (k.a(participants)) {
            for (Participant next : participants) {
                this.be.aN.put(next.getAlias(), next);
            }
        }
        r rVar = new r(this, this.be.aQ);
        if (b2 != null) {
            if (rVar instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) rVar;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(rVar);
            }
            int i2 = b2.mOldListSize;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i3 = b2.mOldListSize;
            int i4 = b2.mNewListSize;
            for (int size = b2.mDiagonals.size() - 1; size >= 0; size--) {
                Diagonal diagonal = b2.mDiagonals.get(size);
                int i5 = diagonal.x;
                int i6 = diagonal.size;
                int i7 = i5 + i6;
                int i8 = diagonal.y + i6;
                while (i3 > i7) {
                    i3--;
                    int i9 = b2.mOldItemStatuses[i3];
                    if ((i9 & 12) != 0) {
                        int i10 = i9 >> 4;
                        PostponedUpdate postponedUpdate = DiffResult.getPostponedUpdate(arrayDeque, i10, false);
                        if (postponedUpdate != null) {
                            i = i4;
                            int i11 = (i2 - postponedUpdate.currentPos) - 1;
                            batchingListUpdateCallback.onMoved(i3, i11);
                            if ((i9 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i11, 1, b2.mCallback.getChangePayload(i3, i10));
                            }
                        } else {
                            i = i4;
                            arrayDeque.add(new PostponedUpdate(i3, (i2 - i3) - 1, true));
                        }
                    } else {
                        i = i4;
                        batchingListUpdateCallback.onRemoved(i3, 1);
                        i2--;
                    }
                    i4 = i;
                }
                int i12 = i4;
                while (i4 > i8) {
                    i4--;
                    int i13 = b2.mNewItemStatuses[i4];
                    if ((i13 & 12) != 0) {
                        int i14 = i13 >> 4;
                        PostponedUpdate postponedUpdate2 = DiffResult.getPostponedUpdate(arrayDeque, i14, true);
                        if (postponedUpdate2 == null) {
                            arrayDeque.add(new PostponedUpdate(i4, i2 - i3, false));
                        } else {
                            batchingListUpdateCallback.onMoved((i2 - postponedUpdate2.currentPos) - 1, i3);
                            if ((i13 & 4) != 0) {
                                batchingListUpdateCallback.onChanged(i3, 1, b2.mCallback.getChangePayload(i14, i4));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.onInserted(i3, 1);
                        i2++;
                    }
                }
                int i15 = diagonal.x;
                int i16 = diagonal.y;
                for (int i17 = 0; i17 < diagonal.size; i17++) {
                    if ((b2.mOldItemStatuses[i15] & 15) == 2) {
                        batchingListUpdateCallback.onChanged(i15, 1, b2.mCallback.getChangePayload(i15, i16));
                    }
                    i15++;
                    i16++;
                }
                i3 = diagonal.x;
                i4 = diagonal.y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
            boolean w = this.be.av();
            this.be.I().x(w);
            this.be.K();
            if (loader2 instanceof i) {
                this.be.aO = iVar.di();
            }
            this.be.aj();
            ConversationDetailActivity conversationDetailActivity = this.be;
            if (w) {
                conversationDetailActivity.ap();
                this.be.an();
                this.be.aq();
                this.be.as();
                this.be.gC();
                this.be.gS();
                bg.k(this.be.getContext(), this.be.channelId);
            } else {
                conversationDetailActivity.aX();
                this.be.ko();
            }
            this.be.lz.a(this.be.channelId, this.be.cW);
            this.be.kA();
            return;
        }
        throw null;
    }

    public Loader<List<Message>> onCreateLoader(int i, Bundle bundle) {
        i iVar = new i(this.be.getApplicationContext(), bundle.getLong(PaytmRequestConstants.PARAMS_CHANNEL_ID), this.be.aM, this.be.ff());
        return iVar;
    }

    public void onLoaderReset(Loader<List<Message>> loader) {
        this.be.aM.clear();
        this.be.aN.clear();
        this.be.I().notifyDataSetChanged();
        this.be.aO = false;
    }
}
