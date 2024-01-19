package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.Picasso.Priority;
import com.squareup.picasso.Utils.PicassoThreadFactory;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PicassoExecutorService extends ThreadPoolExecutor {
    public static final int DEFAULT_THREAD_COUNT = 3;

    public static final class PicassoFutureTask extends FutureTask<BitmapHunter> implements Comparable<PicassoFutureTask> {
        public final BitmapHunter hunter;

        public PicassoFutureTask(BitmapHunter bitmapHunter) {
            super(bitmapHunter, null);
            this.hunter = bitmapHunter;
        }

        public int compareTo(PicassoFutureTask picassoFutureTask) {
            Priority priority = this.hunter.getPriority();
            Priority priority2 = picassoFutureTask.hunter.getPriority();
            return priority == priority2 ? this.hunter.sequence - picassoFutureTask.hunter.sequence : priority2.ordinal() - priority.ordinal();
        }
    }

    public PicassoExecutorService() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new PicassoThreadFactory());
    }

    private void setThreadCount(int i) {
        setCorePoolSize(i);
        setMaximumPoolSize(i);
    }

    public void adjustThreadCount(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            setThreadCount(3);
            return;
        }
        int type = networkInfo.getType();
        if (type == 0) {
            int subtype = networkInfo.getSubtype();
            switch (subtype) {
                case 1:
                case 2:
                    setThreadCount(1);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    setThreadCount(2);
                    break;
                default:
                    switch (subtype) {
                        case 12:
                            break;
                        case 13:
                        case 14:
                        case 15:
                            setThreadCount(3);
                            break;
                        default:
                            setThreadCount(3);
                            break;
                    }
                    setThreadCount(2);
                    break;
            }
        } else if (type == 1 || type == 6 || type == 9) {
            setThreadCount(4);
        } else {
            setThreadCount(3);
        }
    }

    public Future<?> submit(Runnable runnable) {
        PicassoFutureTask picassoFutureTask = new PicassoFutureTask((BitmapHunter) runnable);
        execute(picassoFutureTask);
        return picassoFutureTask;
    }
}
