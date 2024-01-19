package com.clevertap.android.sdk.inbox;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R$layout;
import java.util.ArrayList;
import java.util.Date;

public class CTInboxMessageAdapter extends Adapter {
    public CTInboxListViewFragment fragment;
    public ArrayList<CTInboxMessage> inboxMessages;

    public CTInboxMessageAdapter(ArrayList<CTInboxMessage> arrayList, CTInboxListViewFragment cTInboxListViewFragment) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CTInboxMessageAdapter:  called at ");
        outline73.append(new Date());
        Logger.v(outline73.toString());
        Logger.v("CTInboxMessageAdapter: messages=" + arrayList);
        this.inboxMessages = arrayList;
        this.fragment = cTInboxListViewFragment;
    }

    public int getItemCount() {
        return this.inboxMessages.size();
    }

    public int getItemViewType(int i) {
        int ordinal = this.inboxMessages.get(i).type.ordinal();
        if (ordinal == 0) {
            return 0;
        }
        int i2 = 1;
        if (ordinal != 1) {
            i2 = 2;
            if (ordinal != 2) {
                i2 = 3;
                if (ordinal != 3) {
                    return -1;
                }
            }
        }
        return i2;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ((CTInboxBaseMessageViewHolder) viewHolder).configureWithMessage(this.inboxMessages.get(i), this.fragment, i);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder viewHolder;
        if (i == 0) {
            viewHolder = new CTSimpleMessageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.inbox_simple_message_layout, viewGroup, false));
        } else if (i == 1) {
            viewHolder = new CTIconMessageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.inbox_icon_message_layout, viewGroup, false));
        } else if (i == 2) {
            viewHolder = new CTCarouselMessageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.inbox_carousel_text_layout, viewGroup, false));
        } else if (i != 3) {
            return null;
        } else {
            viewHolder = new CTCarouselImageViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.inbox_carousel_layout, viewGroup, false));
        }
        return viewHolder;
    }
}
