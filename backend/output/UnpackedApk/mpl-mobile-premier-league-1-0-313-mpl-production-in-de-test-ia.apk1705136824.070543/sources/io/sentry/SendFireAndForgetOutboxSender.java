package io.sentry;

import io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForget;
import io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetDirPath;
import io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory;
import io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory.CC;
import io.sentry.util.Objects;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SendFireAndForgetOutboxSender implements SendFireAndForgetFactory {
    public final SendFireAndForgetDirPath sendFireAndForgetDirPath;

    public SendFireAndForgetOutboxSender(SendFireAndForgetDirPath sendFireAndForgetDirPath2) {
        this.sendFireAndForgetDirPath = (SendFireAndForgetDirPath) Objects.requireNonNull(sendFireAndForgetDirPath2, "SendFireAndForgetDirPath is required");
    }

    public SendFireAndForget create(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        String dirPath = this.sendFireAndForgetDirPath.getDirPath();
        if (dirPath == null || !hasValidPath(dirPath, sentryOptions.getLogger())) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, (String) "No outbox dir path is defined in options.", new Object[0]);
            return null;
        }
        OutboxSender outboxSender = new OutboxSender(iHub, sentryOptions.getEnvelopeReader(), sentryOptions.getSerializer(), sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis());
        return processDir(outboxSender, dirPath, sentryOptions.getLogger());
    }

    public /* synthetic */ boolean hasValidPath(String str, ILogger iLogger) {
        return CC.$default$hasValidPath(this, str, iLogger);
    }

    public /* synthetic */ SendFireAndForget processDir(DirectoryProcessor directoryProcessor, String str, ILogger iLogger) {
        return CC.$default$processDir(this, directoryProcessor, str, iLogger);
    }
}
