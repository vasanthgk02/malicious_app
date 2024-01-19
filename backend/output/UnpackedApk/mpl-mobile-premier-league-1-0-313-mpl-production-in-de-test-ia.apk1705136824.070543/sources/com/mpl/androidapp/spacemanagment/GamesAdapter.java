package com.mpl.androidapp.spacemanagment;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.Util;
import java.util.ArrayList;
import java.util.List;

public class GamesAdapter extends Adapter<ViewHolder> {
    public Context context;
    public List<GamesModel> gameList;
    public boolean isMPlGames;
    public OnGamesSpaceAdapterListener onGamesSpaceAdapterListener;
    public final Typeface robotoBoldFont;
    public final Typeface robotoMediumFont;
    public final Typeface robotoRegularFont;
    public List<GamesModel> selectedGamesForUninstall = new ArrayList();

    public class VHItem extends ViewHolder {
        public final CheckBox cvGames;
        public final SimpleDraweeView ivGames;
        public final LinearLayout lvUninstall;
        public final LinearLayout lvUpdate;
        public final TextView tvGameDesc;
        public final TextView tvName;
        public final TextView tvUninstall;
        public final TextView tvUpdate;

        public VHItem(ConstraintLayout constraintLayout) {
            super(constraintLayout);
            this.ivGames = (SimpleDraweeView) constraintLayout.findViewById(R.id.iv_games);
            this.tvName = (TextView) constraintLayout.findViewById(R.id.tv_name);
            this.tvGameDesc = (TextView) constraintLayout.findViewById(R.id.tv_game_desc);
            this.tvUninstall = (TextView) constraintLayout.findViewById(R.id.tv_uninstall);
            this.tvUpdate = (TextView) constraintLayout.findViewById(R.id.tv_update);
            this.cvGames = (CheckBox) constraintLayout.findViewById(R.id.cv_games);
            this.lvUninstall = (LinearLayout) constraintLayout.findViewById(R.id.lv_uninstall);
            this.lvUpdate = (LinearLayout) constraintLayout.findViewById(R.id.lv_update);
        }
    }

    public GamesAdapter(Context context2, List<GamesModel> list, boolean z, OnGamesSpaceAdapterListener onGamesSpaceAdapterListener2) {
        Fresco.initialize(MPLApplication.getInstance(), null, null);
        this.gameList = list;
        this.robotoRegularFont = Typeface.createFromAsset(MPLApplication.getInstance().getAssets(), "fonts/Roboto-Regular.ttf");
        this.robotoBoldFont = Typeface.createFromAsset(MPLApplication.getInstance().getAssets(), "fonts/Roboto-Bold.ttf");
        this.robotoMediumFont = Typeface.createFromAsset(MPLApplication.getInstance().getAssets(), "fonts/Roboto-Medium.ttf");
        this.context = context2;
        this.isMPlGames = z;
        this.onGamesSpaceAdapterListener = onGamesSpaceAdapterListener2;
    }

    public void clearSelectedGameListForUninstall() {
        List<GamesModel> list = this.selectedGamesForUninstall;
        if (list != null && !list.isEmpty()) {
            this.selectedGamesForUninstall = null;
            this.selectedGamesForUninstall = new ArrayList();
        }
    }

    public List<GamesModel> getGameList() {
        return this.gameList;
    }

    public int getItemCount() {
        List<GamesModel> list = this.gameList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<GamesModel> getSelectedGamesForUninstall() {
        return this.selectedGamesForUninstall;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        long j;
        final VHItem vHItem = (VHItem) viewHolder;
        vHItem.tvName.setTypeface(this.robotoMediumFont);
        vHItem.tvGameDesc.setTypeface(this.robotoRegularFont);
        vHItem.tvUninstall.setTypeface(this.robotoRegularFont);
        vHItem.tvUpdate.setTypeface(this.robotoRegularFont);
        final GamesModel gamesModel = this.gameList.get(i);
        if (gamesModel.getIcon() != null) {
            vHItem.ivGames.setImageDrawable(gamesModel.getIcon());
        } else if (!TextUtils.isEmpty(gamesModel.getImageUrl())) {
            vHItem.ivGames.setImageURI(Uri.parse(gamesModel.getImageUrl()));
        } else {
            vHItem.ivGames.setBackgroundResource(R.drawable.allgames);
        }
        vHItem.tvName.setText(gamesModel.getAppName());
        String sizeInReadable = SpaceUtils.getSizeInReadable(gamesModel.getSize().longValue());
        if (gamesModel.getVersionNo() != null) {
            TextView textView = vHItem.tvGameDesc;
            StringBuilder outline80 = GeneratedOutlineSupport.outline80(sizeInReadable, " • ", "Ver ");
            outline80.append(gamesModel.getVersionNo());
            textView.setText(outline80.toString());
        }
        vHItem.cvGames.setOnCheckedChangeListener(null);
        vHItem.cvGames.setChecked(gamesModel.isUninstall());
        vHItem.cvGames.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gamesModel.setUninstall(z);
                if (z) {
                    GamesAdapter.this.selectedGamesForUninstall.add(gamesModel);
                    vHItem.cvGames.setChecked(true);
                } else {
                    GamesAdapter.this.selectedGamesForUninstall.remove(gamesModel);
                    vHItem.cvGames.setChecked(false);
                }
                GamesAdapter.this.onGamesSpaceAdapterListener.updateSelectedAppsForUninstall(GamesAdapter.this.selectedGamesForUninstall);
            }
        });
        vHItem.lvUpdate.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                GamesAdapter.this.onGamesSpaceAdapterListener.updateGameAPK(gamesModel);
            }
        });
        if (this.isMPlGames) {
            vHItem.lvUninstall.setVisibility(0);
            vHItem.cvGames.setVisibility(8);
            long installedApkVersion = Util.getInstalledApkVersion(this.context, gamesModel.getPackageName());
            if (gamesModel.getVersionNo() != null && !gamesModel.getVersionNo().equalsIgnoreCase("")) {
                try {
                    j = Long.parseLong(gamesModel.getVersionNo().trim());
                } catch (NumberFormatException unused) {
                    j = (long) Double.parseDouble(gamesModel.getVersionNo().trim());
                }
                if (installedApkVersion == 0 || j == installedApkVersion) {
                    vHItem.lvUpdate.setVisibility(8);
                } else {
                    vHItem.lvUpdate.setVisibility(0);
                }
            }
        } else {
            vHItem.lvUninstall.setVisibility(8);
            vHItem.lvUpdate.setVisibility(8);
            vHItem.cvGames.setVisibility(0);
        }
        vHItem.lvUpdate.setVisibility(8);
        vHItem.lvUninstall.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                GamesAdapter.this.onGamesSpaceAdapterListener.uninstallMplGame(gamesModel);
            }
        });
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new VHItem((ConstraintLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.holder_games, viewGroup, false));
    }

    public int totApkToUninstall() {
        List<GamesModel> list = this.selectedGamesForUninstall;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.selectedGamesForUninstall.size();
    }

    public void updateGamesList(List<GamesModel> list, boolean z) {
        this.gameList = list;
        this.isMPlGames = z;
        notifyDataSetChanged();
    }

    public void updateSelectedGamesForUnInstall(GamesModel gamesModel) {
        List<GamesModel> list = this.selectedGamesForUninstall;
        if (list != null && !list.isEmpty() && this.selectedGamesForUninstall.contains(gamesModel)) {
            this.selectedGamesForUninstall.remove(gamesModel);
        }
    }
}
