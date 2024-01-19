package com.facebook.react.bridge.queue;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Pair;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.futures.SimpleSettableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.fontbox.cmap.CMap;

@DoNotStrip
public class MessageQueueThreadImpl implements MessageQueueThread {
    public final String mAssertionErrorMessage;
    public final MessageQueueThreadHandler mHandler;
    public volatile boolean mIsFinished;
    public final Looper mLooper;
    public final String mName;
    public MessageQueueThreadPerfStats mPerfStats;

    /* renamed from: com.facebook.react.bridge.queue.MessageQueueThreadImpl$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        public static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.facebook.react.bridge.queue.MessageQueueThreadSpec$ThreadType[] r0 = com.facebook.react.bridge.queue.MessageQueueThreadSpec.ThreadType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType = r0
                r1 = 1
                com.facebook.react.bridge.queue.MessageQueueThreadSpec$ThreadType r2 = com.facebook.react.bridge.queue.MessageQueueThreadSpec.ThreadType.MAIN_UI     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$queue$MessageQueueThreadSpec$ThreadType     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.facebook.react.bridge.queue.MessageQueueThreadSpec$ThreadType r2 = com.facebook.react.bridge.queue.MessageQueueThreadSpec.ThreadType.NEW_BACKGROUND     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.queue.MessageQueueThreadImpl.AnonymousClass5.<clinit>():void");
        }
    }

    public MessageQueueThreadImpl(String str, Looper looper, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        this(str, looper, queueThreadExceptionHandler, null);
    }

    public static void assignToPerfStats(MessageQueueThreadPerfStats messageQueueThreadPerfStats, long j, long j2) {
        messageQueueThreadPerfStats.wallTime = j;
        messageQueueThreadPerfStats.cpuTime = j2;
    }

    public static MessageQueueThreadImpl create(MessageQueueThreadSpec messageQueueThreadSpec, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        int ordinal = messageQueueThreadSpec.getThreadType().ordinal();
        if (ordinal == 0) {
            return createForMainThread(messageQueueThreadSpec.getName(), queueThreadExceptionHandler);
        }
        if (ordinal == 1) {
            return startNewBackgroundThread(messageQueueThreadSpec.getName(), messageQueueThreadSpec.getStackSize(), queueThreadExceptionHandler);
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unknown thread type: ");
        outline73.append(messageQueueThreadSpec.getThreadType());
        throw new RuntimeException(outline73.toString());
    }

    public static MessageQueueThreadImpl createForMainThread(String str, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        MessageQueueThreadImpl messageQueueThreadImpl = new MessageQueueThreadImpl(str, Looper.getMainLooper(), queueThreadExceptionHandler);
        if (UiThreadUtil.isOnUiThread()) {
            Process.setThreadPriority(-4);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    Process.setThreadPriority(-4);
                }
            });
        }
        return messageQueueThreadImpl;
    }

    public static MessageQueueThreadImpl startNewBackgroundThread(String str, long j, QueueThreadExceptionHandler queueThreadExceptionHandler) {
        final SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        Thread thread = new Thread(null, new Runnable() {
            public void run() {
                Process.setThreadPriority(-4);
                Looper.prepare();
                MessageQueueThreadPerfStats messageQueueThreadPerfStats = new MessageQueueThreadPerfStats();
                MessageQueueThreadImpl.assignToPerfStats(messageQueueThreadPerfStats, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis());
                SimpleSettableFuture simpleSettableFuture = simpleSettableFuture;
                T pair = new Pair(Looper.myLooper(), messageQueueThreadPerfStats);
                simpleSettableFuture.checkNotSet();
                simpleSettableFuture.mResult = pair;
                simpleSettableFuture.mReadyLatch.countDown();
                Looper.loop();
            }
        }, GeneratedOutlineSupport.outline50("mqt_", str), j);
        thread.start();
        try {
            Pair pair = (Pair) simpleSettableFuture.get();
            return new MessageQueueThreadImpl(str, (Looper) pair.first, queueThreadExceptionHandler, (MessageQueueThreadPerfStats) pair.second);
        } catch (InterruptedException | ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    @DoNotStrip
    public void assertIsOnThread() {
        SoftAssertions.assertCondition(isOnThread(), this.mAssertionErrorMessage);
    }

    @DoNotStrip
    public <T> Future<T> callOnQueue(final Callable<T> callable) {
        final SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
        runOnQueue(new Runnable() {
            public void run() {
                try {
                    SimpleSettableFuture simpleSettableFuture = simpleSettableFuture;
                    T call = callable.call();
                    simpleSettableFuture.checkNotSet();
                    simpleSettableFuture.mResult = call;
                    simpleSettableFuture.mReadyLatch.countDown();
                } catch (Exception e2) {
                    SimpleSettableFuture simpleSettableFuture2 = simpleSettableFuture;
                    simpleSettableFuture2.checkNotSet();
                    simpleSettableFuture2.mException = e2;
                    simpleSettableFuture2.mReadyLatch.countDown();
                }
            }
        });
        return simpleSettableFuture;
    }

    public Looper getLooper() {
        return this.mLooper;
    }

    public String getName() {
        return this.mName;
    }

    @DoNotStrip
    public MessageQueueThreadPerfStats getPerfStats() {
        return this.mPerfStats;
    }

    @DoNotStrip
    public boolean isOnThread() {
        return this.mLooper.getThread() == Thread.currentThread();
    }

    @DoNotStrip
    public void quitSynchronous() {
        this.mIsFinished = true;
        this.mLooper.quit();
        if (this.mLooper.getThread() != Thread.currentThread()) {
            try {
                this.mLooper.getThread().join();
            } catch (InterruptedException unused) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Got interrupted waiting to join thread ");
                outline73.append(this.mName);
                throw new RuntimeException(outline73.toString());
            }
        }
    }

    @DoNotStrip
    public void resetPerfStats() {
        assignToPerfStats(this.mPerfStats, -1, -1);
        runOnQueue(new Runnable() {
            public void run() {
                MessageQueueThreadImpl.assignToPerfStats(MessageQueueThreadImpl.this.mPerfStats, SystemClock.uptimeMillis(), SystemClock.currentThreadTimeMillis());
            }
        });
    }

    @DoNotStrip
    public void runOnQueue(Runnable runnable) {
        if (this.mIsFinished) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Tried to enqueue runnable on already finished thread: '");
            outline73.append(getName());
            outline73.append("... dropping Runnable.");
            FLog.w((String) "ReactNative", outline73.toString());
        }
        this.mHandler.post(runnable);
    }

    public MessageQueueThreadImpl(String str, Looper looper, QueueThreadExceptionHandler queueThreadExceptionHandler, MessageQueueThreadPerfStats messageQueueThreadPerfStats) {
        this.mIsFinished = false;
        this.mName = str;
        this.mLooper = looper;
        this.mHandler = new MessageQueueThreadHandler(looper, queueThreadExceptionHandler);
        this.mPerfStats = messageQueueThreadPerfStats;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Expected to be called from the '");
        outline73.append(getName());
        outline73.append("' thread!");
        this.mAssertionErrorMessage = outline73.toString();
    }

    @DoNotStrip
    public void assertIsOnThread(String str) {
        boolean isOnThread = isOnThread();
        SoftAssertions.assertCondition(isOnThread, this.mAssertionErrorMessage + CMap.SPACE + str);
    }
}
