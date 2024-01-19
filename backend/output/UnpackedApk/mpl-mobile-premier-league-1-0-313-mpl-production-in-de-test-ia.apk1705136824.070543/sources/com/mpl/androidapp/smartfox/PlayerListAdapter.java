package com.mpl.androidapp.smartfox;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.MLogger;
import java.util.ArrayList;

public class PlayerListAdapter extends Adapter<PlayerViewHolder> {
    public static final int HEADER = 0;
    public static final int ITEM = 1;
    public static final String TAG = "PlayerListAdapter";
    public boolean isKnockOutTournament;
    public final Context mContext;
    public ArrayList<PlayerItem> mPlayerItems;

    public static class PlayerViewHolder extends ViewHolder {
        public final View mPlayerAvatarOverlay;
        public final ProgressBar mPlayerAvatarProgress;
        public final SimpleDraweeView mPlayerItemAvatar;
        public final TextView mPlayerItemName;

        public PlayerViewHolder(ConstraintLayout constraintLayout) {
            super(constraintLayout);
            this.mPlayerItemAvatar = (SimpleDraweeView) constraintLayout.findViewById(R.id.currentPlayerAvatar);
            this.mPlayerItemName = (TextView) constraintLayout.findViewById(R.id.currentPlayerName);
            this.mPlayerAvatarOverlay = constraintLayout.findViewById(R.id.avatarOverlay);
            this.mPlayerAvatarProgress = (ProgressBar) constraintLayout.findViewById(R.id.avatarProgress);
        }
    }

    public PlayerListAdapter(Context context, ArrayList<PlayerItem> arrayList, boolean z) {
        this.mContext = context;
        this.mPlayerItems = arrayList;
        this.isKnockOutTournament = z;
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
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
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

    public void updatePlayerStatus(PlayerItem playerItem) {
        try {
            int indexOf = this.mPlayerItems.indexOf(playerItem);
            MLogger.d("PlayerListAdapter", "updatePlayerStatus: ", Integer.valueOf(indexOf));
            this.mPlayerItems.set(indexOf, playerItem);
            notifyItemChanged(indexOf);
        } catch (Exception e2) {
            MLogger.e("PlayerListAdapter", "updatePlayerStatus: ", e2);
        }
    }

    public void updatePlayersStatus(ArrayList<PlayerItem> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            int indexOf = this.mPlayerItems.indexOf(arrayList.get(i));
            MLogger.d("PlayerListAdapter", "updatePlayersStatus: ", Integer.valueOf(indexOf));
            this.mPlayerItems.set(indexOf, arrayList.get(i));
            notifyItemChanged(indexOf);
        }
    }

    public void onBindViewHolder(PlayerViewHolder playerViewHolder, int i) {
        PlayerItem player = getPlayer(i);
        if (player != null) {
            int i2 = 8;
            if (getItemViewType(i) == 0) {
                ((LinearLayout) playerViewHolder.itemView).setGravity(17);
                playerViewHolder.mPlayerItemAvatar.setVisibility(8);
                playerViewHolder.mPlayerItemName.setGravity(17);
                playerViewHolder.mPlayerItemName.setTextSize(2, 20.0f);
            } else {
                String playerAvatar = player.getPlayerAvatar();
                if (TextUtils.isEmpty(playerAvatar) || ".circlevtw".equalsIgnoreCase(playerAvatar) || !URLUtil.isValidUrl(playerAvatar)) {
                    playerViewHolder.mPlayerItemAvatar.invalidate();
                    if (this.isKnockOutTournament) {
                        playerViewHolder.mPlayerItemAvatar.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.ic_user_empty));
                    }
                    playerViewHolder.mPlayerItemAvatar.setImageURI(Uri.EMPTY);
                } else {
                    Uri parse = Uri.parse(this.mPlayerItems.get(i).getPlayerAvatar() + ".circlevtw");
                    if (this.isKnockOutTournament) {
                        parse = Uri.parse(this.mPlayerItems.get(i).getPlayerAvatar());
                    }
                    playerViewHolder.mPlayerItemAvatar.setImageURI(parse);
                }
            }
            if (!TextUtils.isEmpty(player.getPlayerName())) {
                playerViewHolder.mPlayerItemName.setText(player.getPlayerName());
            } else {
                playerViewHolder.mPlayerItemName.setText(R.string.player_name);
            }
            if (this.isKnockOutTournament) {
                playerViewHolder.mPlayerItemAvatar.setScaleType(ScaleType.FIT_XY);
                playerViewHolder.mPlayerItemName.setTextColor(-1);
                playerViewHolder.mPlayerAvatarOverlay.setVisibility(player.isJoined() ? 8 : 0);
                ProgressBar progressBar = playerViewHolder.mPlayerAvatarProgress;
                if (!player.isJoined()) {
                    i2 = 0;
                }
                progressBar.setVisibility(i2);
                return;
            }
            playerViewHolder.itemView.setBackground(ContextCompat.getDrawable(this.mContext, R.drawable.facebook_failed_dialog_border));
            playerViewHolder.mPlayerItemAvatar.setScaleType(ScaleType.CENTER_INSIDE);
            playerViewHolder.mPlayerItemName.setTextColor(ContextCompat.getColor(this.mContext, R.color.greyish_brown_three));
            playerViewHolder.mPlayerAvatarOverlay.setVisibility(8);
            playerViewHolder.mPlayerAvatarProgress.setVisibility(8);
        }
    }

    public PlayerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new PlayerViewHolder((ConstraintLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.battle_player_layout_item, viewGroup, false));
    }
}
