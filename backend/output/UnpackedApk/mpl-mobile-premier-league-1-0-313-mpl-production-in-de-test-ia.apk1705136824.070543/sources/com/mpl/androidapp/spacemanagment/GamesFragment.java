package com.mpl.androidapp.spacemanagment;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.R;
import com.mpl.androidapp.databinding.FragmentGamesManagementBinding;
import com.mpl.androidapp.utils.MLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.fontbox.cmap.CMap;

public class GamesFragment extends Fragment implements OnGamesSpaceAdapterListener {
    public static final String TAG = "GameSpaceManagement";
    public FragmentGamesManagementBinding fragmentGamesManagementBinding;
    public List<GamesModel> gameList = new ArrayList();
    public GamesAdapter gamesAdapter;
    public GamesViewModel gamesViewModel;
    public boolean isMPLGames = true;
    public boolean isSingleMPLGame = false;
    public OnInstalledAppsActivityCallback mCallBack;
    public Typeface robotoBoldFont;
    public Typeface robotoMediumFont;
    public Typeface robotoRegularFont;
    public GamesModel singleMPLGameModel;
    public long totRemovedSize = 0;
    public int uninstalledCounter = 0;

    private boolean checkForPermission(Context context) {
        return ((AppOpsManager) context.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName()) == 0;
    }

    private void concurrentUpdateForUninstalledStatus(boolean z) {
        try {
            List<GamesModel> selectedGamesForUninstall = this.gamesAdapter.getSelectedGamesForUninstall();
            if (selectedGamesForUninstall == null) {
                return;
            }
            if (this.isSingleMPLGame) {
                if (this.totRemovedSize == 0) {
                    return;
                }
                if (this.singleMPLGameModel.getSize().longValue() - this.totRemovedSize > 0) {
                    enableBtnFreeSpace(true, getString(R.string.uninstall) + CMap.SPACE + SpaceUtils.getSizeInReadable(getTotSizeFromList(selectedGamesForUninstall)));
                    this.fragmentGamesManagementBinding.tvSpaceInfo.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_verified), null, null, null);
                    this.fragmentGamesManagementBinding.tvSpaceInfo.setCompoundDrawablePadding(6);
                    return;
                }
                getActivity().finish();
            } else if (this.totRemovedSize != 0 && !z) {
                CustomToast customToast = new CustomToast();
                FragmentActivity activity = getActivity();
                customToast.showToast(activity, "You have successfully cleaned " + SpaceUtils.getSizeInReadable(this.totRemovedSize));
                this.totRemovedSize = 0;
            }
        } catch (Exception e2) {
            MLogger.d("GameSpaceManagement", GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("error in updateUninstalledStatus")));
        }
    }

    private void enableBtnFreeSpace(boolean z, String str) {
        this.fragmentGamesManagementBinding.btnFreeUpSpace.setEnabled(z);
        if (z) {
            this.fragmentGamesManagementBinding.btnFreeUpSpace.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_bg));
        } else {
            this.fragmentGamesManagementBinding.btnFreeUpSpace.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_bg_uninstall));
        }
        if (str != null && !TextUtils.isEmpty(str)) {
            this.fragmentGamesManagementBinding.btnFreeUpSpace.setText(str);
        }
    }

    private long getTotSizeFromList(List<GamesModel> list) {
        long j = 0;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                j += list.get(i).getSize().longValue();
            }
        }
        return j;
    }

    private void initCallback() {
        this.fragmentGamesManagementBinding.tvSort.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                GamesFragment.this.lambda$initCallback$0$GamesFragment(view);
            }
        });
        this.fragmentGamesManagementBinding.ivSort.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                GamesFragment.this.lambda$initCallback$1$GamesFragment(view);
            }
        });
        this.fragmentGamesManagementBinding.btnFreeUpSpace.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                GamesFragment.this.lambda$initCallback$2$GamesFragment(view);
            }
        });
        this.fragmentGamesManagementBinding.btnFreeUpSpaceNoGame.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                GamesFragment.this.onActionButtonClick();
            }
        });
    }

    private void initData() {
        if (getArguments() != null) {
            boolean z = getArguments().getBoolean(SpaceUtils.INTENT_IS_SINGLE_MPL_GAME);
            this.isSingleMPLGame = z;
            if (z) {
                this.fragmentGamesManagementBinding.cvGame.setVisibility(0);
                String string = getArguments().getString(SpaceUtils.INTENT_MPL_GAME);
                this.isMPLGames = false;
                if (string != null && !string.isEmpty()) {
                    this.singleMPLGameModel = (GamesModel) new Gson().fromJson(string, GamesModel.class);
                    this.mCallBack.setProgressBarVisibility(0);
                    this.gamesViewModel.getAllInstalledAppsInDevice(getContext());
                    showSingleMPLGame();
                    return;
                }
                return;
            }
            this.fragmentGamesManagementBinding.cvGame.setVisibility(8);
            String string2 = getArguments().getString(SpaceUtils.INTENT_ALL_MPL_GAMES);
            if (string2 == null || TextUtils.isEmpty(string2)) {
                this.mCallBack.setProgressBarVisibility(0);
                this.isMPLGames = false;
                this.gamesViewModel.getAllInstalledAppsInDevice(getContext());
                TextView textView = this.fragmentGamesManagementBinding.tvSort;
                textView.setText(getString(R.string.sort_by) + CMap.SPACE + getString(R.string.size));
                return;
            }
            this.gamesViewModel.getAllMPLGames(string2);
        }
    }

    private void initFont() {
        this.fragmentGamesManagementBinding.tvGameName.setTypeface(this.robotoBoldFont);
        this.fragmentGamesManagementBinding.tvMplGameVerified.setTypeface(this.robotoRegularFont);
        this.fragmentGamesManagementBinding.tvGameInstallMsg.setTypeface(this.robotoRegularFont);
        this.fragmentGamesManagementBinding.tvSpaceInfo.setTypeface(this.robotoRegularFont);
        this.fragmentGamesManagementBinding.tvNoGameFound.setTypeface(this.robotoRegularFont);
        this.fragmentGamesManagementBinding.tvNoGameMsg.setTypeface(this.robotoRegularFont);
        this.fragmentGamesManagementBinding.tvHeader.setTypeface(this.robotoMediumFont);
    }

    private void initObserver() {
        this.gamesViewModel.getAppsLiveData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                GamesFragment.this.lambda$initObserver$3$GamesFragment((List) obj);
            }
        });
        this.gamesViewModel.getTotInstalledAppSizeLiveData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                GamesFragment.this.lambda$initObserver$4$GamesFragment((Long) obj);
            }
        });
    }

    private void initRecyclerViewAdapter() {
        RecyclerView recyclerView = this.fragmentGamesManagementBinding.rvGames;
        boolean z = recyclerView.mHasFixedSize;
        recyclerView.setNestedScrollingEnabled(true);
        this.fragmentGamesManagementBinding.rvGames.setLayoutManager(new LinearLayoutManager(getActivity()));
        GamesAdapter gamesAdapter2 = new GamesAdapter(getActivity(), this.gameList, this.isMPLGames, this);
        this.gamesAdapter = gamesAdapter2;
        this.fragmentGamesManagementBinding.rvGames.setAdapter(gamesAdapter2);
    }

    /* access modifiers changed from: private */
    public void onActionButtonClick() {
        if (this.isMPLGames) {
            this.mCallBack.setProgressBarVisibility(0);
            this.isMPLGames = false;
            this.gamesViewModel.getAllInstalledAppsInDevice(getContext());
            this.fragmentGamesManagementBinding.tvSort.setText(getString(R.string.sort_by) + CMap.SPACE + getString(R.string.size));
            return;
        }
        long j = 0;
        int i = 0;
        for (GamesModel next : this.gamesAdapter.getGameList()) {
            if (next.isUninstall()) {
                j += next.getSize().longValue();
                i++;
            }
        }
        if (j == 0) {
            Toast.makeText(getContext(), getString(R.string.uninstall_not_sel_msg), 0).show();
            return;
        }
        this.mCallBack.setUninstallLayoutVisibility(getString(R.string.uninstall) + CMap.SPACE + SpaceUtils.getSizeInReadable(j), i);
    }

    private void openSettings() {
        startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
    }

    private void setReadyToUninstallStateVisibleForSingleMPLGame(long j) {
        enableBtnFreeSpace(true, getString(R.string.uninstall) + CMap.SPACE + SpaceUtils.getSizeInReadable(j));
        this.fragmentGamesManagementBinding.progress.setProgress(100);
        this.fragmentGamesManagementBinding.tvSpaceInfo.setText(getString(R.string.ready));
        this.fragmentGamesManagementBinding.tvSpaceInfo.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_verified), null, null, null);
        this.fragmentGamesManagementBinding.tvSpaceInfo.setCompoundDrawablePadding(6);
    }

    private void setRemainingSizeNeededToUninstallStateForSingleMPLGame(int i, long j) {
        enableBtnFreeSpace(false, getString(R.string.game_continue));
        this.fragmentGamesManagementBinding.progress.setProgress(i);
        TextView textView = this.fragmentGamesManagementBinding.tvSpaceInfo;
        textView.setText(SpaceUtils.getSizeInReadable(j) + CMap.SPACE + getString(R.string.needed));
        this.fragmentGamesManagementBinding.tvSpaceInfo.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }

    private void showSingleMPLGame() {
        this.fragmentGamesManagementBinding.tvMplGameVerified.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_verified), null, null, null);
        this.fragmentGamesManagementBinding.tvMplGameVerified.setCompoundDrawablePadding(6);
        this.fragmentGamesManagementBinding.tvGameName.setText(SpaceUtils.toFirstLtrUprCase(this.singleMPLGameModel.getAppName()));
        TextView textView = this.fragmentGamesManagementBinding.tvSpaceInfo;
        textView.setText(SpaceUtils.getSizeInReadable(this.singleMPLGameModel.getSize().longValue()) + CMap.SPACE + getString(R.string.needed));
        this.mCallBack.setActionBarMenuTitleAndSubtitle(this.isMPLGames, getString(R.string.free_up_space), "");
        if (!TextUtils.isEmpty(this.singleMPLGameModel.getImageUrl())) {
            this.fragmentGamesManagementBinding.ivGame.setImageURI(Uri.parse(this.singleMPLGameModel.getImageUrl()));
        } else {
            this.fragmentGamesManagementBinding.ivGame.setBackgroundResource(R.drawable.allgames);
        }
        this.fragmentGamesManagementBinding.btnFreeUpSpace.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.button_bg_uninstall));
    }

    public void enableSortByName() {
        Collections.sort(this.gameList, new Comparator<GamesModel>() {
            public int compare(GamesModel gamesModel, GamesModel gamesModel2) {
                return gamesModel.getAppName().compareTo(gamesModel2.getAppName());
            }
        });
        this.gamesAdapter.updateGamesList(this.gameList, this.isMPLGames);
        TextView textView = this.fragmentGamesManagementBinding.tvSort;
        textView.setText(getString(R.string.sort_by) + CMap.SPACE + getString(R.string.name));
    }

    public void enableSortBySize() {
        Collections.sort(this.gameList, new Comparator<GamesModel>() {
            public int compare(GamesModel gamesModel, GamesModel gamesModel2) {
                return Long.compare(gamesModel2.getSize().longValue(), gamesModel.getSize().longValue());
            }
        });
        this.gamesAdapter.updateGamesList(this.gameList, this.isMPLGames);
        TextView textView = this.fragmentGamesManagementBinding.tvSort;
        textView.setText(getString(R.string.sort_by) + CMap.SPACE + getString(R.string.size));
    }

    public void enableUninstallApps() {
        List<GamesModel> gameList2 = this.gamesAdapter.getGameList();
        if (gameList2 != null) {
            this.uninstalledCounter = this.gamesAdapter.totApkToUninstall();
            for (GamesModel next : gameList2) {
                if (next.isUninstall()) {
                    SpaceUtils.uninstallAppWithCallback(getActivity(), next.getPackageName());
                }
            }
        }
    }

    public /* synthetic */ void lambda$initCallback$0$GamesFragment(View view) {
        this.mCallBack.setSortByLayoutVisibility(true);
    }

    public /* synthetic */ void lambda$initCallback$1$GamesFragment(View view) {
        this.mCallBack.setSortByLayoutVisibility(true);
    }

    public /* synthetic */ void lambda$initCallback$2$GamesFragment(View view) {
        onActionButtonClick();
    }

    public /* synthetic */ void lambda$initObserver$3$GamesFragment(List list) {
        if (this.isMPLGames) {
            enableBtnFreeSpace(true, getString(R.string.free_up_space));
            this.fragmentGamesManagementBinding.tvHeader.setText(getString(R.string.installed_game));
            this.gameList = list;
            this.gamesAdapter.updateGamesList(list, this.isMPLGames);
            if (list == null || !list.isEmpty()) {
                this.fragmentGamesManagementBinding.cvGameNoFound.setVisibility(8);
            } else {
                this.fragmentGamesManagementBinding.cvGameNoFound.setVisibility(0);
            }
        } else {
            this.fragmentGamesManagementBinding.cvGameNoFound.setVisibility(8);
            this.mCallBack.setProgressBarVisibility(8);
            if (this.isSingleMPLGame) {
                enableBtnFreeSpace(false, getString(R.string.game_continue));
            } else {
                enableBtnFreeSpace(false, getString(R.string.uninstall));
            }
            this.fragmentGamesManagementBinding.tvHeader.setText(getString(R.string.all_apps));
            this.gameList = list;
            this.gamesAdapter.updateGamesList(list, this.isMPLGames);
        }
    }

    public /* synthetic */ void lambda$initObserver$4$GamesFragment(Long l) {
        if (this.isMPLGames) {
            OnInstalledAppsActivityCallback onInstalledAppsActivityCallback = this.mCallBack;
            String string = getString(R.string.manage_games);
            onInstalledAppsActivityCallback.setActionBarMenuTitleAndSubtitle(true, string, getString(R.string.total_storage_size) + ": " + SpaceUtils.getSizeInReadable(l.longValue()));
            return;
        }
        OnInstalledAppsActivityCallback onInstalledAppsActivityCallback2 = this.mCallBack;
        String string2 = getString(R.string.free_up_space);
        onInstalledAppsActivityCallback2.setActionBarMenuTitleAndSubtitle(false, string2, getString(R.string.total_storage_size) + ": " + SpaceUtils.getSizeInReadable(l.longValue()));
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.mCallBack = (OnInstalledAppsActivityCallback) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement OnGamesActivityCallback");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.robotoRegularFont = Typeface.createFromAsset(MPLApplication.getInstance().getAssets(), "fonts/Roboto-Regular.ttf");
        this.robotoBoldFont = Typeface.createFromAsset(MPLApplication.getInstance().getAssets(), "fonts/Roboto-Bold.ttf");
        this.robotoMediumFont = Typeface.createFromAsset(MPLApplication.getInstance().getAssets(), "fonts/Roboto-Medium.ttf");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.fragmentGamesManagementBinding = (FragmentGamesManagementBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_games_management, viewGroup, false);
        this.gamesViewModel = (GamesViewModel) new ViewModelProvider(this).get(GamesViewModel.class);
        TextView textView = this.fragmentGamesManagementBinding.tvSort;
        textView.setText(getString(R.string.sort_by) + CMap.SPACE + getString(R.string.size));
        initFont();
        initCallback();
        initObserver();
        initRecyclerViewAdapter();
        initData();
        return this.fragmentGamesManagementBinding.getRoot();
    }

    public void onDetach() {
        super.onDetach();
        this.mCallBack = null;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1001 && iArr.length > 0) {
            int i2 = iArr[0];
        }
    }

    public void uninstallMplGame(GamesModel gamesModel) {
        SpaceUtils.uninstallAppWithCallback(getActivity(), gamesModel.getPackageName());
    }

    public void updateGameAPK(GamesModel gamesModel) {
        new Bundle().putInt("gameId", gamesModel.getGameId());
        getActivity().finish();
    }

    public void updateSelectedAppsForUninstall(List<GamesModel> list) {
        if (list == null) {
            return;
        }
        if (list.isEmpty()) {
            enableBtnFreeSpace(false, getString(R.string.uninstall));
            if (!this.isSingleMPLGame) {
                return;
            }
            if (this.totRemovedSize != 0) {
                long longValue = this.singleMPLGameModel.getSize().longValue() - this.totRemovedSize;
                if (longValue < 0) {
                    this.fragmentGamesManagementBinding.progress.setProgress(100);
                    return;
                }
                this.fragmentGamesManagementBinding.progress.setProgress(0);
                TextView textView = this.fragmentGamesManagementBinding.tvSpaceInfo;
                textView.setText(SpaceUtils.getSizeInReadable(longValue) + CMap.SPACE + getString(R.string.needed));
                return;
            }
            this.fragmentGamesManagementBinding.progress.setProgress(0);
            TextView textView2 = this.fragmentGamesManagementBinding.tvSpaceInfo;
            textView2.setText(SpaceUtils.getSizeInReadable(this.singleMPLGameModel.getSize().longValue()) + CMap.SPACE + getString(R.string.needed));
        } else if (this.isSingleMPLGame) {
            long longValue2 = this.singleMPLGameModel.getSize().longValue();
            long j = this.totRemovedSize;
            if (j != 0) {
                longValue2 -= j;
            }
            long totSizeFromList = getTotSizeFromList(list);
            long j2 = longValue2 - totSizeFromList;
            if (j2 <= 0) {
                setReadyToUninstallStateVisibleForSingleMPLGame(totSizeFromList);
            } else {
                setRemainingSizeNeededToUninstallStateForSingleMPLGame((int) ((totSizeFromList * 100) / longValue2), j2);
            }
        } else {
            long totSizeFromList2 = getTotSizeFromList(list);
            enableBtnFreeSpace(true, getString(R.string.uninstall) + CMap.SPACE + SpaceUtils.getSizeInReadable(totSizeFromList2));
        }
    }

    public void updateUI() {
        MLogger.d("GameSpaceManagement", "update UI");
        GamesAdapter gamesAdapter2 = this.gamesAdapter;
        if (gamesAdapter2 != null) {
            gamesAdapter2.clearSelectedGameListForUninstall();
        }
        this.isMPLGames = true;
        initData();
        TextView textView = this.fragmentGamesManagementBinding.tvSort;
        textView.setText(getString(R.string.sort_by) + CMap.SPACE + getString(R.string.size));
    }

    public void updateUninstalledApps(String str) {
        try {
            MLogger.d("GameSpaceManagement", "uninstalled app: " + str);
            for (int i = 0; i < this.gameList.size(); i++) {
                GamesModel gamesModel = this.gameList.get(i);
                if (gamesModel.getPackageName().equalsIgnoreCase(str)) {
                    long longValue = gamesModel.getSize().longValue();
                    this.gameList.remove(gamesModel);
                    this.gamesAdapter.updateGamesList(this.gameList, this.isMPLGames);
                    this.gamesAdapter.updateSelectedGamesForUnInstall(gamesModel);
                    if (this.isSingleMPLGame || !this.isMPLGames) {
                        this.totRemovedSize += longValue;
                    }
                }
            }
            List<GamesModel> selectedGamesForUninstall = this.gamesAdapter.getSelectedGamesForUninstall();
            if (selectedGamesForUninstall == null || !selectedGamesForUninstall.isEmpty()) {
                if (selectedGamesForUninstall != null) {
                    long totSizeFromList = getTotSizeFromList(selectedGamesForUninstall);
                    if (this.isSingleMPLGame) {
                        if (this.uninstalledCounter <= 0 && this.totRemovedSize != 0) {
                            concurrentUpdateForUninstalledStatus(false);
                        }
                    } else if (!this.isMPLGames) {
                        if (this.uninstalledCounter <= 0 && this.totRemovedSize != 0) {
                            concurrentUpdateForUninstalledStatus(false);
                        }
                        this.fragmentGamesManagementBinding.btnFreeUpSpace.setText(getString(R.string.uninstall) + CMap.SPACE + SpaceUtils.getSizeInReadable(totSizeFromList));
                    }
                }
            } else if (this.isSingleMPLGame) {
                this.totRemovedSize = 0;
                getActivity().finish();
            } else if (!this.isMPLGames) {
                enableBtnFreeSpace(false, getString(R.string.uninstall));
                if (this.totRemovedSize != 0) {
                    new CustomToast().showToast(getActivity(), "You have successfully cleaned " + SpaceUtils.getSizeInReadable(this.totRemovedSize));
                    this.totRemovedSize = 0;
                }
            }
            if (this.isMPLGames && this.gameList != null && this.gameList.isEmpty()) {
                this.fragmentGamesManagementBinding.cvGameNoFound.setVisibility(0);
            }
            this.gamesViewModel.getTotSize(this.gameList);
        } catch (Exception e2) {
            MLogger.d("GameSpaceManagement", GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("error in updateUninstalledApps ")));
        }
    }

    public void updateUninstalledStatus(boolean z) {
        this.uninstalledCounter--;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("count: ");
        outline73.append(this.uninstalledCounter);
        MLogger.d("GameSpaceManagement", outline73.toString());
        if (this.uninstalledCounter <= 0) {
            concurrentUpdateForUninstalledStatus(z);
        }
    }
}
