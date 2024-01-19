package com.mpl.androidapp.spacemanagment;

public interface OnInstalledAppsActivityCallback {
    void isSortingUIEnabled(boolean z);

    void setActionBarMenuTitleAndSubtitle(boolean z, String str, String str2);

    void setGameNoFoundUIVisibility(int i);

    void setProgressBarVisibility(int i);

    void setSortByLayoutVisibility(boolean z);

    void setToolBarColor(int i);

    void setUninstallLayoutVisibility(String str, int i);
}
