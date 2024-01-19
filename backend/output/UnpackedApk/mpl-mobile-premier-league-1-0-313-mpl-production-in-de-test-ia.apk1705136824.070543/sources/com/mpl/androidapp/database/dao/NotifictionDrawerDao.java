package com.mpl.androidapp.database.dao;

import com.mpl.androidapp.database.entity.Notification;
import java.util.List;

public interface NotifictionDrawerDao {
    void addevent(Notification notification);

    int deleteAllDataFromDB();

    int deleteDataBasedOnIndexFromDB(long j);

    int deleteSingleFromDB(int i);

    List<Notification> getAllEvents();

    List<Notification> getNotificationDataInDescendginOrderPagination(long j, long j2);

    List<Notification> getNotificationEntityInAscendingOrder(int i);

    List<Notification> getNotificationEntityInDescendingOrder(int i);

    List<Notification> getNotificationEntityInDescendingOrderByCount(int i, int i2);

    List<Notification> getSingleNOtificationDataEvent(int i);

    int getTotalElementINDB();

    void update(boolean z, int i);
}
