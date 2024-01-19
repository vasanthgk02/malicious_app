package com.mpl.androidapp.spacemanagment;

import java.util.List;

public interface OnGamesSpaceAdapterListener {
    void uninstallMplGame(GamesModel gamesModel);

    void updateGameAPK(GamesModel gamesModel);

    void updateSelectedAppsForUninstall(List<GamesModel> list);
}
