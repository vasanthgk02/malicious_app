package com.mpl.androidapp.smartfox;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.MLogger;
import java.util.ArrayList;

public class KnockOutPlayerListAdapter extends Adapter<PlayerViewHolder> {
    public static final int HEADER = 0;
    public static final int ITEM = 1;
    public static final String TAG = "PlayerListAdapter";
    public final Context mContext;
    public ArrayList<PlayerItem> mPlayerItems;

    public static class PlayerViewHolder extends ViewHolder {
        public final SimpleDraweeView mPlayerItemAvatar;
        public final TextView mPlayerItemName;

        public PlayerViewHolder(ConstraintLayout constraintLayout) {
            super(constraintLayout);
            this.mPlayerItemAvatar = (SimpleDraweeView) constraintLayout.findViewById(R.id.currentPlayerAvatar);
            this.mPlayerItemName = (TextView) constraintLayout.findViewById(R.id.currentPlayerName);
        }
    }

    public KnockOutPlayerListAdapter(Context context, ArrayList<PlayerItem> arrayList) {
        this.mPlayerItems = arrayList;
        this.mContext = context;
    }

    public void addPlayer(PlayerItem playerItem) {
        try {
            this.mPlayerItems.add(playerItem);
            notifyDataSetChanged();
        } catch (Exception unused) {
        }
    }

    public boolean containsItem(PlayerItem playerItem) {
        return this.mPlayerItems.contains(playerItem);
    }

    public int getItemCount() {
        ArrayList<PlayerItem> arrayList = this.mPlayerItems;
        int size = arrayList != null ? arrayList.size() : 0;
        MLogger.d("PlayerListAdapter", "getItemCount: ", Integer.valueOf(size));
        return size;
    }

    public int getItemViewType(int i) {
        return 1;
    }

    public PlayerItem getPlayer(int i) {
        ArrayList<PlayerItem> arrayList = this.mPlayerItems;
        if (arrayList == null || arrayList.size() <= i) {
            return null;
        }
        return this.mPlayerItems.get(i);
    }

    public void removePlayer(PlayerItem playerItem) {
        try {
            this.mPlayerItems.remove(playerItem);
            notifyDataSetChanged();
        } catch (Exception unused) {
        }
    }

    public void swapItems(ArrayList<PlayerItem> arrayList) {
        this.mPlayerItems = arrayList;
        MLogger.d("PlayerListAdapter", "swapItems: ", Integer.valueOf(arrayList.size()));
        notifyDataSetChanged();
    }

    public void swapPlayers(ArrayList<PlayerItem> arrayList) {
        MLogger.d("PlayerListAdapter", "swapPlayers: ");
        try {
            this.mPlayerItems = arrayList;
            notifyDataSetChanged();
        } catch (Exception e2) {
            MLogger.e("PlayerListAdapter", "swapPlayers: ", e2);
        }
    }

    public void onBindViewHolder(PlayerViewHolder playerViewHolder, int i) {
        PlayerItem player = getPlayer(i);
        if (player != null) {
            if (getItemViewType(i) == 0) {
                ((LinearLayout) playerViewHolder.itemView).setGravity(17);
                playerViewHolder.mPlayerItemAvatar.setVisibility(8);
                playerViewHolder.mPlayerItemName.setGravity(17);
                playerViewHolder.mPlayerItemName.setTextSize(2, 20.0f);
            } else {
                String playerAvatar = player.getPlayerAvatar();
                if (TextUtils.isEmpty(playerAvatar) || ".circlevtw".equalsIgnoreCase(playerAvatar) || !URLUtil.isValidUrl(playerAvatar)) {
                    playerViewHolder.mPlayerItemAvatar.invalidate();
                    playerViewHolder.mPlayerItemAvatar.setImageURI(Uri.EMPTY);
                } else {
                    playerViewHolder.mPlayerItemAvatar.setImageURI(Uri.parse(this.mPlayerItems.get(i).getPlayerAvatar() + ".circlevtw"));
                }
            }
            if (!TextUtils.isEmpty(player.getPlayerName())) {
                playerViewHolder.mPlayerItemName.setText(player.getPlayerName());
            } else {
                playerViewHolder.mPlayerItemName.setText(R.string.player_name);
            }
        }
    }

    public PlayerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PlayerViewHolder((ConstraintLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.battle_player_layout_item, viewGroup, false));
    }
}
