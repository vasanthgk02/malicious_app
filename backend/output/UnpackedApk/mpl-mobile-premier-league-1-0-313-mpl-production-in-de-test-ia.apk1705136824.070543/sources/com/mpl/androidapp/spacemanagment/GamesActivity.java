package com.mpl.androidapp.spacemanagment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.Gson;
import com.inca.security.Proxy.iIiIiIiIii;
import com.mpl.androidapp.MPLBaseActivity;
import com.mpl.androidapp.R;
import com.mpl.androidapp.databinding.ActivityGamesManagementBinding;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.utils.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import org.apache.fontbox.cmap.CMapParser;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;
import org.json.JSONArray;
import org.json.JSONObject;

public class GamesActivity extends MPLBaseActivity implements OnInstalledAppsActivityCallback {
    public static final String TAG = "GameSpaceManagement";
    public ActivityGamesManagementBinding activityGamesManagementBinding;
    public boolean isMplGames;
    public boolean isSingleMPLGame;
    public boolean isSortingUIEnabled = false;
    public NavController navController;
    public BroadcastReceiver removedBroadCastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("android.intent.action.PACKAGE_REMOVED") && intent.getData() != null && !TextUtils.isEmpty(intent.getData().getSchemeSpecificPart())) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                MLogger.d("GameSpaceManagement", GeneratedOutlineSupport.outline50("pkg removed: ", schemeSpecificPart));
                GamesFragment access$000 = GamesActivity.this.getCurrentFragment();
                if (access$000 != null) {
                    access$000.updateUninstalledApps(schemeSpecificPart);
                }
            }
        }
    };
    public Typeface robotoBoldFont;
    public Typeface robotoMediumFont;
    public Typeface robotoRegularFont;

    /* access modifiers changed from: 0000 */
    public GamesFragment getCurrentFragment() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            return (GamesFragment) navHostFragment.getChildFragmentManager().getFragments().get(0);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void initActionBar() {
        setSupportActionBar(this.activityGamesManagementBinding.toolbar);
        if (getSupportActionBar() != null) {
            this.activityGamesManagementBinding.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            this.activityGamesManagementBinding.tvPrimaryTitle.setTypeface(this.robotoMediumFont);
            this.activityGamesManagementBinding.tvSubtitle.setTypeface(this.robotoRegularFont);
        }
        setActionBarMenuTitleAndSubtitle(true, getString(R.string.manage_games), getString(R.string.total_storage_size));
    }

    /* access modifiers changed from: 0000 */
    public void initCallback() {
        this.activityGamesManagementBinding.ivBack.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                GamesActivity.this.lambda$initCallback$0$GamesActivity(view);
            }
        });
        this.activityGamesManagementBinding.lvName.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                GamesActivity.this.lambda$initCallback$1$GamesActivity(view);
            }
        });
        this.activityGamesManagementBinding.lvSize.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                GamesActivity.this.lambda$initCallback$2$GamesActivity(view);
            }
        });
        this.activityGamesManagementBinding.btnUninstall.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                GamesActivity.this.lambda$initCallback$3$GamesActivity(view);
            }
        });
        this.activityGamesManagementBinding.btnCancel.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                GamesActivity.this.lambda$initCallback$4$GamesActivity(view);
            }
        });
        this.activityGamesManagementBinding.cvUninstall.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                GamesActivity.this.lambda$initCallback$5$GamesActivity(view);
            }
        });
        this.activityGamesManagementBinding.cvSort.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                GamesActivity.this.lambda$initCallback$6$GamesActivity(view);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void initFont() {
        this.activityGamesManagementBinding.tvSortBy.setTypeface(this.robotoBoldFont);
        this.activityGamesManagementBinding.tvSize.setTypeface(this.robotoRegularFont);
        this.activityGamesManagementBinding.tvName.setTypeface(this.robotoRegularFont);
        this.activityGamesManagementBinding.btnCancel.setTypeface(this.robotoRegularFont);
        this.activityGamesManagementBinding.btnUninstall.setTypeface(this.robotoRegularFont);
        this.activityGamesManagementBinding.tvTitle.setTypeface(this.robotoBoldFont);
        this.activityGamesManagementBinding.tvMessage.setTypeface(this.robotoRegularFont);
        this.activityGamesManagementBinding.tvScanning.setTypeface(this.robotoRegularFont);
    }

    /* access modifiers changed from: 0000 */
    public String initGamesModelDataFromReact(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                String optString = optJSONObject.optString("gameInfo");
                if (optString != null && !TextUtils.isEmpty(optString) && optString.length() > 3) {
                    MLogger.d("GameSpaceManagement", "gameInfoJsonObject");
                    GamesModel gamesModel = new GamesModel();
                    JSONObject jSONObject = (JSONObject) Objects.requireNonNull(optJSONObject.optJSONObject("icons"));
                    String optString2 = new JSONObject(optString).optString("apkInfo");
                    if (optString2 != null && !TextUtils.isEmpty(optString2) && optString2.length() > 3) {
                        JSONObject jSONObject2 = new JSONObject(optString2);
                        if (Util.appInstalledOrNot(getApplicationContext(), jSONObject2.optString("packageName"))) {
                            MLogger.d("GameSpaceManagement", "apkJsonObject");
                            gamesModel.setVersionNo(jSONObject2.optString("gameVersion"));
                            gamesModel.setImageUrl(jSONObject.optString("normalShortCut"));
                            gamesModel.setGameId(optJSONObject.optInt("id"));
                            gamesModel.setAppName(optJSONObject.optString("name", "Game Name"));
                            gamesModel.setSize(SpaceUtils.getApkSizeInLong(jSONObject2.optString(Response.SIZE)));
                            gamesModel.setPackageName(jSONObject2.optString("packageName"));
                            gamesModel.setLastUpdatedTime(new Date().getTime());
                            arrayList.add(gamesModel);
                        }
                    }
                }
            }
            return new Gson().toJson((Object) arrayList);
        } catch (Exception e2) {
            MLogger.d("GameSpaceManagement", e2.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void initNavigationGraph() {
        this.isSingleMPLGame = getIntent().getBooleanExtra(SpaceUtils.INTENT_IS_SINGLE_MPL_GAME, false);
        Bundle bundle = new Bundle();
        if (this.isSingleMPLGame) {
            bundle.putBoolean(SpaceUtils.INTENT_IS_SINGLE_MPL_GAME, true);
            bundle.putString(SpaceUtils.INTENT_MPL_GAME, initSingleGamesModelDataFromReact(getIntent().getStringExtra(SpaceUtils.INTENT_MPL_GAME)));
            this.activityGamesManagementBinding.tvSubtitle.setVisibility(8);
        } else {
            bundle.putBoolean(SpaceUtils.INTENT_IS_SINGLE_MPL_GAME, false);
            String stringExtra = getIntent().getStringExtra(SpaceUtils.INTENT_ALL_MPL_GAMES);
            bundle.putString(SpaceUtils.INTENT_ALL_MPL_GAMES, (stringExtra == null || TextUtils.isEmpty(stringExtra)) ? "" : initGamesModelDataFromReact(stringExtra));
            this.activityGamesManagementBinding.tvSubtitle.setVisibility(0);
        }
        this.navController.setGraph(R.navigation.nav_graph, bundle);
    }

    /* access modifiers changed from: 0000 */
    public String initSingleGamesModelDataFromReact(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("gameInfo");
            GamesModel gamesModel = new GamesModel();
            if (optString != null && !TextUtils.isEmpty(optString) && optString.length() > 3) {
                MLogger.d("GameSpaceManagement", "gameInfoJsonObject");
                JSONObject jSONObject2 = (JSONObject) Objects.requireNonNull(jSONObject.optJSONObject("icons"));
                String optString2 = new JSONObject(optString).optString("apkInfo");
                if (optString2 != null && !TextUtils.isEmpty(optString2) && optString2.length() > 3) {
                    JSONObject jSONObject3 = new JSONObject(optString2);
                    MLogger.d("GameSpaceManagement", "apkJsonObject");
                    gamesModel.setVersionNo(jSONObject3.optString("gameVersion"));
                    gamesModel.setImageUrl(jSONObject2.optString("normalShortCut"));
                    gamesModel.setGameId(jSONObject.optInt("id"));
                    gamesModel.setSize(SpaceUtils.getApkSizeInLong(jSONObject3.optString(Response.SIZE)));
                    gamesModel.setAppName(jSONObject.optString("name", "Game Name"));
                    gamesModel.setPackageName(jSONObject3.optString("packageName"));
                    gamesModel.setLastUpdatedTime(new Date().getTime());
                }
            }
            return new Gson().toJson((Object) gamesModel);
        } catch (Exception e2) {
            MLogger.d("GameSpaceManagement", e2.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public void initStatusBar() {
        Window window = getWindow();
        window.clearFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
        window.addFlags(LinearLayoutManager.INVALID_OFFSET);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
    }

    public void isSortingUIEnabled(boolean z) {
        this.isSortingUIEnabled = z;
    }

    public /* synthetic */ void lambda$initCallback$0$GamesActivity(View view) {
        onBackPressed();
    }

    public /* synthetic */ void lambda$initCallback$1$GamesActivity(View view) {
        GamesFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            currentFragment.enableSortByName();
            this.activityGamesManagementBinding.cvSort.setVisibility(8);
            isSortingUIEnabled(false);
        }
    }

    public /* synthetic */ void lambda$initCallback$2$GamesActivity(View view) {
        GamesFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            currentFragment.enableSortBySize();
            this.activityGamesManagementBinding.cvSort.setVisibility(8);
            isSortingUIEnabled(false);
        }
    }

    public /* synthetic */ void lambda$initCallback$3$GamesActivity(View view) {
        GamesFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            currentFragment.enableUninstallApps();
            this.activityGamesManagementBinding.cvUninstall.setVisibility(8);
        }
    }

    public /* synthetic */ void lambda$initCallback$4$GamesActivity(View view) {
        this.activityGamesManagementBinding.cvUninstall.setVisibility(8);
    }

    public /* synthetic */ void lambda$initCallback$5$GamesActivity(View view) {
        onBackPressed();
    }

    public /* synthetic */ void lambda$initCallback$6$GamesActivity(View view) {
        onBackPressed();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == SpaceUtils.UNINSTALL_REQUEST_CODE) {
            GamesFragment currentFragment = getCurrentFragment();
            if (currentFragment == null) {
                return;
            }
            if (i2 == -1) {
                MLogger.d("GameSpaceManagement", "onActivityResult: user accepted the (un)install" + intent);
                currentFragment.updateUninstalledStatus(true);
            } else if (i2 == 0) {
                currentFragment.updateUninstalledStatus(false);
                MLogger.d("GameSpaceManagement", "onActivityResult: user canceled the (un)install");
            } else if (i2 == 1) {
                currentFragment.updateUninstalledStatus(false);
                MLogger.d("GameSpaceManagement", "onActivityResult: failed to (un)install");
            }
        }
    }

    public void onBackPressed() {
        if (this.isSortingUIEnabled) {
            if (getCurrentFragment() != null) {
                if (this.activityGamesManagementBinding.cvSort.getVisibility() == 0) {
                    this.activityGamesManagementBinding.cvSort.setVisibility(8);
                } else if (this.activityGamesManagementBinding.cvUninstall.getVisibility() == 0) {
                    this.activityGamesManagementBinding.cvUninstall.setVisibility(8);
                }
                this.isSortingUIEnabled = false;
            }
        } else if (this.isMplGames || this.isSingleMPLGame) {
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 1558308780, bundle);
    }

    public void onDestroy() {
        iIiIiIiIii.IiiiIiiiII(this, -757932836, new Object[0]);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MLogger.d("GameSpaceManagement", "onDetachedFromWindow() called");
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        MLogger.d("GameSpaceManagement", "onUserInteraction() called");
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        MLogger.d("GameSpaceManagement", "onWindowFocusChanged() called with: hasFocus = [" + z + CMapParser.MARK_END_OF_ARRAY);
    }

    /* access modifiers changed from: 0000 */
    public void registerPackageUninstallReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        registerReceiver(this.removedBroadCastReceiver, intentFilter);
    }

    public void setActionBarMenuTitleAndSubtitle(boolean z, String str, String str2) {
        this.isMplGames = z;
        this.activityGamesManagementBinding.tvPrimaryTitle.setText(str);
        if (!this.isSingleMPLGame) {
            this.activityGamesManagementBinding.tvSubtitle.setText(str2);
        }
    }

    public void setGameNoFoundUIVisibility(int i) {
    }

    public void setProgressBarVisibility(int i) {
        ActivityGamesManagementBinding activityGamesManagementBinding2 = this.activityGamesManagementBinding;
        if (activityGamesManagementBinding2 != null) {
            activityGamesManagementBinding2.cvProgress.setVisibility(i);
        }
    }

    public void setSortByLayoutVisibility(boolean z) {
        this.activityGamesManagementBinding.cvSort.setVisibility(0);
        isSortingUIEnabled(true);
    }

    public void setToolBarColor(int i) {
        this.activityGamesManagementBinding.toolbar.setBackgroundColor(i);
    }

    public void setUninstallLayoutVisibility(String str, int i) {
        this.activityGamesManagementBinding.btnUninstall.setText(str);
        this.activityGamesManagementBinding.cvUninstall.setVisibility(0);
        isSortingUIEnabled(true);
        if (i > 1) {
            this.activityGamesManagementBinding.tvMessage.setText(getString(R.string.uninstall_apps_msg));
        } else {
            this.activityGamesManagementBinding.tvMessage.setText(getString(R.string.uninstall_app_msg));
        }
    }
}
