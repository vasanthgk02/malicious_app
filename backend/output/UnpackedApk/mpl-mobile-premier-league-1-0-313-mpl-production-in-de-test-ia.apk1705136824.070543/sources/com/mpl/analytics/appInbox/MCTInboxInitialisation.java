package com.mpl.analytics.appInbox;

import com.clevertap.android.sdk.inbox.CTInboxMessage;
import java.util.ArrayList;

public interface MCTInboxInitialisation {
    void deleteInboxMessage(CTInboxMessage cTInboxMessage);

    ArrayList<CTInboxMessage> getAllInboxMessages();

    int getInboxMessageCount();

    CTInboxMessage getInboxMessageForId(String str);

    int getInboxMessageUnreadCount();

    ArrayList<CTInboxMessage> getUnreadInboxMessages();

    void initializeInbox();

    void markReadInboxMessage(CTInboxMessage cTInboxMessage);

    void setCTNotificationInboxListener(MPLCTInboxListener mPLCTInboxListener);

    void showAppInbox();

    void showAppInbox(MCTInboxStyleConfig mCTInboxStyleConfig);
}
