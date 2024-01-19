package com.mpl.androidapp.database.dao;

import com.mpl.androidapp.database.entity.Events;
import java.util.List;

public interface EventDao {
    void addevent(Events events);

    int deleteAllDataFromDB();

    List<Events> getAllEvents();
}
