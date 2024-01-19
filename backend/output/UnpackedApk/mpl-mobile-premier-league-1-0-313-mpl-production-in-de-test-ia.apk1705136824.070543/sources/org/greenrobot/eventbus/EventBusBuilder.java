package org.greenrobot.eventbus;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

public class EventBusBuilder {
    public static final ExecutorService DEFAULT_EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    public boolean eventInheritance = true;
    public ExecutorService executorService = DEFAULT_EXECUTOR_SERVICE;
    public boolean ignoreGeneratedIndex;
    public boolean logNoSubscriberMessages = true;
    public boolean logSubscriberExceptions = true;
    public boolean sendNoSubscriberEvent = true;
    public boolean sendSubscriberExceptionEvent = true;
    public boolean strictMethodVerification;
    public List<SubscriberInfoIndex> subscriberInfoIndexes;
    public boolean throwSubscriberException;
}
