package io.sentry;

import io.sentry.hints.Cached;
import io.sentry.hints.Flushable;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DirectoryProcessor {
    public final long flushTimeoutMillis;
    public final ILogger logger;

    public static final class SendCachedEnvelopeHint implements Cached, Retryable, SubmissionResult, Flushable {
        public final long flushTimeoutMillis;
        public final CountDownLatch latch;
        public final ILogger logger;
        public boolean retry = false;
        public boolean succeeded = false;

        public SendCachedEnvelopeHint(long j, ILogger iLogger) {
            this.flushTimeoutMillis = j;
            this.latch = new CountDownLatch(1);
            this.logger = iLogger;
        }

        public boolean isRetry() {
            return this.retry;
        }

        public boolean isSuccess() {
            return this.succeeded;
        }

        public void setResult(boolean z) {
            this.succeeded = z;
            this.latch.countDown();
        }

        public void setRetry(boolean z) {
            this.retry = z;
        }

        public boolean waitFlush() {
            try {
                return this.latch.await(this.flushTimeoutMillis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                this.logger.log(SentryLevel.ERROR, (String) "Exception while awaiting on lock.", (Throwable) e2);
                return false;
            }
        }
    }

    public DirectoryProcessor(ILogger iLogger, long j) {
        this.logger = iLogger;
        this.flushTimeoutMillis = j;
    }

    public abstract boolean isRelevantFileName(String str);

    public /* synthetic */ boolean lambda$processDirectory$0$DirectoryProcessor(File file, String str) {
        return isRelevantFileName(str);
    }

    public void processDirectory(File file) {
        try {
            this.logger.log(SentryLevel.DEBUG, (String) "Processing dir. %s", file.getAbsolutePath());
            if (!file.exists()) {
                this.logger.log(SentryLevel.WARNING, (String) "Directory '%s' doesn't exist. No cached events to send.", file.getAbsolutePath());
            } else if (!file.isDirectory()) {
                this.logger.log(SentryLevel.ERROR, (String) "Cache dir %s is not a directory.", file.getAbsolutePath());
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    this.logger.log(SentryLevel.ERROR, (String) "Cache dir %s is null.", file.getAbsolutePath());
                    return;
                }
                File[] listFiles2 = file.listFiles(new FilenameFilter() {
                    public final boolean accept(File file, String str) {
                        return DirectoryProcessor.this.lambda$processDirectory$0$DirectoryProcessor(file, str);
                    }
                });
                ILogger iLogger = this.logger;
                SentryLevel sentryLevel = SentryLevel.DEBUG;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(listFiles2 != null ? listFiles2.length : 0);
                objArr[1] = file.getAbsolutePath();
                iLogger.log(sentryLevel, (String) "Processing %d items from cache dir %s", objArr);
                for (File file2 : listFiles) {
                    if (!file2.isFile()) {
                        this.logger.log(SentryLevel.DEBUG, (String) "File %s is not a File.", file2.getAbsolutePath());
                    } else {
                        this.logger.log(SentryLevel.DEBUG, (String) "Processing file: %s", file2.getAbsolutePath());
                        processFile(file2, new SendCachedEnvelopeHint(this.flushTimeoutMillis, this.logger));
                    }
                }
            }
        } catch (Exception e2) {
            this.logger.log(SentryLevel.ERROR, e2, "Failed processing '%s'", file.getAbsolutePath());
        }
    }

    public abstract void processFile(File file, Object obj);
}
