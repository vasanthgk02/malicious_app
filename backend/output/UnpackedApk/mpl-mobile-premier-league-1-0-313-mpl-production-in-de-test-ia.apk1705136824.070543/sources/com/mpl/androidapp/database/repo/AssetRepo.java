package com.mpl.androidapp.database.repo;

import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.database.AppDatabase;
import com.mpl.androidapp.database.model.Asset;
import com.mpl.androidapp.utils.MLogger;
import java.util.List;

public class AssetRepo {
    public static final String TAG = "AssetRepo";
    public AppDatabase db = MPLApplication.getDatabaseClient().getAppDatabase();

    public void deleteAll() {
        MLogger.d(TAG, "deleteAll");
        this.db.assetDao().deleteAll();
    }

    public Asset getAsset(int i) {
        MLogger.d(TAG, "getAsset");
        return this.db.assetDao().getAsset(i);
    }

    public List<Asset> getAssets() {
        MLogger.d(TAG, "getAssets");
        return this.db.assetDao().getAssets();
    }

    public void insertAsset(Asset asset) {
        MLogger.d(TAG, "insertAsset");
        this.db.assetDao().insertAsset(asset);
    }

    public void insertAssets(List<Asset> list) {
        MLogger.d(TAG, "insertAssets");
        this.db.assetDao().insertAssets(list);
    }
}
