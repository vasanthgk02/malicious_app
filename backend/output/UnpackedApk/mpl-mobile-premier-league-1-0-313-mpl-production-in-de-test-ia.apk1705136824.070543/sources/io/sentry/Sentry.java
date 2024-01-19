package io.sentry;

import io.sentry.cache.EnvelopeCache;
import io.sentry.config.PropertiesProviderFactory;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import org.jetbrains.annotations.ApiStatus.Internal;

public final class Sentry {
    public static final boolean GLOBAL_HUB_DEFAULT_MODE = false;
    public static final ThreadLocal<IHub> currentHub = new ThreadLocal<>();
    public static volatile boolean globalHubMode = false;
    public static volatile IHub mainHub = NoOpHub.getInstance();

    public interface OptionsConfiguration<T extends SentryOptions> {
        void configure(T t);
    }

    public static void addBreadcrumb(Breadcrumb breadcrumb, Object obj) {
        getCurrentHub().addBreadcrumb(breadcrumb, obj);
    }

    public static void bindClient(ISentryClient iSentryClient) {
        getCurrentHub().bindClient(iSentryClient);
    }

    public static SentryId captureEvent(SentryEvent sentryEvent) {
        return getCurrentHub().captureEvent(sentryEvent);
    }

    public static SentryId captureException(Throwable th) {
        return getCurrentHub().captureException(th);
    }

    public static SentryId captureMessage(String str) {
        return getCurrentHub().captureMessage(str);
    }

    public static void captureUserFeedback(UserFeedback userFeedback) {
        getCurrentHub().captureUserFeedback(userFeedback);
    }

    public static void clearBreadcrumbs() {
        getCurrentHub().clearBreadcrumbs();
    }

    public static synchronized void close() {
        synchronized (Sentry.class) {
            IHub currentHub2 = getCurrentHub();
            mainHub = NoOpHub.getInstance();
            currentHub2.close();
        }
    }

    public static void configureScope(ScopeCallback scopeCallback) {
        getCurrentHub().configureScope(scopeCallback);
    }

    public static void endSession() {
        getCurrentHub().endSession();
    }

    public static void flush(long j) {
        getCurrentHub().flush(j);
    }

    @Internal
    public static IHub getCurrentHub() {
        if (globalHubMode) {
            return mainHub;
        }
        IHub iHub = currentHub.get();
        if (iHub == null) {
            iHub = mainHub.clone();
            currentHub.set(iHub);
        }
        return iHub;
    }

    public static SentryId getLastEventId() {
        return getCurrentHub().getLastEventId();
    }

    public static ISpan getSpan() {
        return getCurrentHub().getSpan();
    }

    public static void init() {
        init((OptionsConfiguration<SentryOptions>) $$Lambda$Sentry$NECzGTNdEG1rkjO4iWgcQQzKvU.INSTANCE, false);
    }

    public static boolean initConfigurations(SentryOptions sentryOptions) {
        if (sentryOptions.isEnableExternalConfiguration()) {
            sentryOptions.merge(SentryOptions.from(PropertiesProviderFactory.create(), sentryOptions.getLogger()));
        }
        String dsn = sentryOptions.getDsn();
        if (dsn == null) {
            throw new IllegalArgumentException("DSN is required. Use empty string to disable SDK.");
        } else if (dsn.isEmpty()) {
            close();
            return false;
        } else {
            new Dsn(dsn);
            ILogger logger = sentryOptions.getLogger();
            if (sentryOptions.isDebug() && (logger instanceof NoOpLogger)) {
                sentryOptions.setLogger(new SystemOutLogger());
                logger = sentryOptions.getLogger();
            }
            logger.log(SentryLevel.INFO, (String) "Initializing SDK with DSN: '%s'", sentryOptions.getDsn());
            if (sentryOptions.getOutboxPath() != null) {
                new File(sentryOptions.getOutboxPath()).mkdirs();
            } else {
                logger.log(SentryLevel.INFO, (String) "No outbox dir path is defined in options.", new Object[0]);
            }
            if (sentryOptions.getCacheDirPath() != null && !sentryOptions.getCacheDirPath().isEmpty()) {
                new File(sentryOptions.getCacheDirPath()).mkdirs();
                sentryOptions.setEnvelopeDiskCache(EnvelopeCache.create(sentryOptions));
            }
            return true;
        }
    }

    public static boolean isEnabled() {
        return getCurrentHub().isEnabled();
    }

    public static void popScope() {
        if (!globalHubMode) {
            getCurrentHub().popScope();
        }
    }

    public static void pushScope() {
        if (!globalHubMode) {
            getCurrentHub().pushScope();
        }
    }

    public static void removeExtra(String str) {
        getCurrentHub().removeExtra(str);
    }

    public static void removeTag(String str) {
        getCurrentHub().removeTag(str);
    }

    @Internal
    public static void setCurrentHub(IHub iHub) {
        currentHub.set(iHub);
    }

    public static void setExtra(String str, String str2) {
        getCurrentHub().setExtra(str, str2);
    }

    public static void setFingerprint(List<String> list) {
        getCurrentHub().setFingerprint(list);
    }

    public static void setLevel(SentryLevel sentryLevel) {
        getCurrentHub().setLevel(sentryLevel);
    }

    public static void setTag(String str, String str2) {
        getCurrentHub().setTag(str, str2);
    }

    public static void setTransaction(String str) {
        getCurrentHub().setTransaction(str);
    }

    public static void setUser(User user) {
        getCurrentHub().setUser(user);
    }

    public static void startSession() {
        getCurrentHub().startSession();
    }

    public static ITransaction startTransaction(String str, String str2) {
        return getCurrentHub().startTransaction(str, str2);
    }

    public static SentryTraceHeader traceHeaders() {
        return getCurrentHub().traceHeaders();
    }

    public static void withScope(ScopeCallback scopeCallback) {
        getCurrentHub().withScope(scopeCallback);
    }

    public static void addBreadcrumb(Breadcrumb breadcrumb) {
        getCurrentHub().addBreadcrumb(breadcrumb);
    }

    public static SentryId captureEvent(SentryEvent sentryEvent, Object obj) {
        return getCurrentHub().captureEvent(sentryEvent, obj);
    }

    public static SentryId captureException(Throwable th, Object obj) {
        return getCurrentHub().captureException(th, obj);
    }

    public static SentryId captureMessage(String str, SentryLevel sentryLevel) {
        return getCurrentHub().captureMessage(str, sentryLevel);
    }

    public static void init(String str) {
        init((OptionsConfiguration<SentryOptions>) new OptionsConfiguration(str) {
            public final /* synthetic */ String f$0;

            {
                this.f$0 = r1;
            }

            public final void configure(SentryOptions sentryOptions) {
                sentryOptions.setDsn(this.f$0);
            }
        });
    }

    public static ITransaction startTransaction(String str, String str2, boolean z) {
        return getCurrentHub().startTransaction(str, str2, z);
    }

    public static void addBreadcrumb(String str) {
        getCurrentHub().addBreadcrumb(str);
    }

    public static <T extends SentryOptions> void init(OptionsContainer<T> optionsContainer, OptionsConfiguration<T> optionsConfiguration) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        init(optionsContainer, optionsConfiguration, false);
    }

    public static ITransaction startTransaction(String str, String str2, String str3) {
        return startTransaction(str, str2, str3, false);
    }

    public static void addBreadcrumb(String str, String str2) {
        getCurrentHub().addBreadcrumb(str, str2);
    }

    public static <T extends SentryOptions> void init(OptionsContainer<T> optionsContainer, OptionsConfiguration<T> optionsConfiguration, boolean z) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        SentryOptions sentryOptions = (SentryOptions) optionsContainer.createInstance();
        optionsConfiguration.configure(sentryOptions);
        init(sentryOptions, z);
    }

    public static ITransaction startTransaction(String str, String str2, String str3, boolean z) {
        ITransaction startTransaction = getCurrentHub().startTransaction(str, str2, z);
        startTransaction.setDescription(str3);
        return startTransaction;
    }

    public static ITransaction startTransaction(TransactionContext transactionContext) {
        return getCurrentHub().startTransaction(transactionContext);
    }

    public static void init(OptionsConfiguration<SentryOptions> optionsConfiguration) {
        init(optionsConfiguration, false);
    }

    public static ITransaction startTransaction(TransactionContext transactionContext, boolean z) {
        return getCurrentHub().startTransaction(transactionContext, z);
    }

    public static void init(OptionsConfiguration<SentryOptions> optionsConfiguration, boolean z) {
        SentryOptions sentryOptions = new SentryOptions();
        optionsConfiguration.configure(sentryOptions);
        init(sentryOptions, z);
    }

    public static ITransaction startTransaction(String str, String str2, CustomSamplingContext customSamplingContext) {
        return getCurrentHub().startTransaction(str, str2, customSamplingContext);
    }

    public static ITransaction startTransaction(String str, String str2, CustomSamplingContext customSamplingContext, boolean z) {
        return getCurrentHub().startTransaction(str, str2, customSamplingContext, z);
    }

    public static ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext) {
        return getCurrentHub().startTransaction(transactionContext, customSamplingContext);
    }

    @Internal
    public static void init(SentryOptions sentryOptions) {
        init(sentryOptions, false);
    }

    public static ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z) {
        return getCurrentHub().startTransaction(transactionContext, customSamplingContext, z);
    }

    public static synchronized void init(SentryOptions sentryOptions, boolean z) {
        synchronized (Sentry.class) {
            if (isEnabled()) {
                sentryOptions.getLogger().log(SentryLevel.WARNING, (String) "Sentry has been already initialized. Previous configuration will be overwritten.", new Object[0]);
            }
            if (initConfigurations(sentryOptions)) {
                sentryOptions.getLogger().log(SentryLevel.INFO, (String) "GlobalHubMode: '%s'", String.valueOf(z));
                globalHubMode = z;
                IHub currentHub2 = getCurrentHub();
                mainHub = new Hub(sentryOptions);
                currentHub.set(mainHub);
                currentHub2.close();
                for (Integration register : sentryOptions.getIntegrations()) {
                    register.register(HubAdapter.getInstance(), sentryOptions);
                }
            }
        }
    }

    @Internal
    public static ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z, Date date) {
        return getCurrentHub().startTransaction(transactionContext, customSamplingContext, z, date);
    }

    @Internal
    public static ITransaction startTransaction(TransactionContext transactionContext, CustomSamplingContext customSamplingContext, boolean z, Date date, boolean z2) {
        return getCurrentHub().startTransaction(transactionContext, customSamplingContext, z, date, z2);
    }
}
