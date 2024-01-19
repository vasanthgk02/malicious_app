package com.mpl.androidapp.database.repo;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.MPLApplication;
import com.mpl.androidapp.database.AppDatabase;
import com.mpl.androidapp.database.model.MutedChannel;
import com.mpl.androidapp.utils.MLogger;
import java.util.List;

public class MutedChannelRepo {
    public static final String TAG = "MutedChannelRepo";
    public AppDatabase db = MPLApplication.getDatabaseClient().getAppDatabase();

    public void deleteAll() {
        MLogger.d(TAG, "deleteAll");
        this.db.mutedChannelDao().deleteAll();
    }

    public List<MutedChannel> getMutedChannels() {
        MLogger.d(TAG, "getMutedChannels");
        return this.db.mutedChannelDao().getMutedChannels();
    }

    public void insertMutedChannels(List<MutedChannel> list) {
        Object[] objArr = new Object[1];
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("insertMutedChannels -> Size : ");
        outline73.append(list != null ? list.size() : 0);
        objArr[0] = outline73.toString();
        MLogger.d(TAG, objArr);
        this.db.mutedChannelDao().insertMutedChannels(list);
    }

    public boolean isChannelMuted(String str) {
        try {
            MLogger.d(TAG, "isChannelMuted");
            return this.db.mutedChannelDao().isChannelMuted(str);
        } catch (Exception e2) {
            MLogger.e(TAG, GeneratedOutlineSupport.outline39(e2, GeneratedOutlineSupport.outline73("Error in isChannelMuted : ")));
            return false;
        }
    }
}
