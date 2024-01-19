package com.mpl.androidapp.database.dao;

import com.mpl.androidapp.database.model.MutedChannel;
import java.util.List;

public interface MutedChannelDao {
    void deleteAll();

    List<MutedChannel> getMutedChannels();

    void insertMutedChannels(List<MutedChannel> list);

    boolean isChannelMuted(String str);
}
