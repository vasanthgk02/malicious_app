package com.mpl.androidapp.database.dao;

import com.mpl.androidapp.database.model.Asset;
import java.util.List;

public interface AssetDao {
    void deleteAll();

    Asset getAsset(int i);

    List<Asset> getAssets();

    void insertAsset(Asset asset);

    void insertAssets(List<Asset> list);
}
