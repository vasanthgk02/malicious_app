package com.squareup.picasso;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Global;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import okio.BufferedSource;
import okio.ByteString;

public final class Utils {
    public static final int KEY_PADDING = 50;
    public static final char KEY_SEPARATOR = '\n';
    public static final StringBuilder MAIN_THREAD_KEY_BUILDER = new StringBuilder();
    public static final int MAX_DISK_CACHE_SIZE = 52428800;
    public static final int MIN_DISK_CACHE_SIZE = 5242880;
    public static final String OWNER_DISPATCHER = "Dispatcher";
    public static final String OWNER_HUNTER = "Hunter";
    public static final String OWNER_MAIN = "Main";
    public static final String PICASSO_CACHE = "picasso-cache";
    public static final String THREAD_IDLE_NAME = "Picasso-Idle";
    public static final int THREAD_LEAK_CLEANING_MS = 1000;
    public static final String THREAD_PREFIX = "Picasso-";
    public static final String VERB_BATCHED = "batched";
    public static final String VERB_CANCELED = "canceled";
    public static final String VERB_CHANGED = "changed";
    public static final String VERB_COMPLETED = "completed";
    public static final String VERB_CREATED = "created";
    public static final String VERB_DECODED = "decoded";
    public static final String VERB_DELIVERED = "delivered";
    public static final String VERB_ENQUEUED = "enqueued";
    public static final String VERB_ERRORED = "errored";
    public static final String VERB_EXECUTING = "executing";
    public static final String VERB_IGNORED = "ignored";
    public static final String VERB_JOINED = "joined";
    public static final String VERB_PAUSED = "paused";
    public static final String VERB_REMOVED = "removed";
    public static final String VERB_REPLAYING = "replaying";
    public static final String VERB_RESUMED = "resumed";
    public static final String VERB_RETRYING = "retrying";
    public static final String VERB_TRANSFORMED = "transformed";
    public static final ByteString WEBP_FILE_HEADER_RIFF = ByteString.encodeUtf8("RIFF");
    public static final ByteString WEBP_FILE_HEADER_WEBP = ByteString.encodeUtf8("WEBP");

    public static class PicassoThread extends Thread {
        public PicassoThread(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public static class PicassoThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            return new PicassoThread(runnable);
        }
    }

    @TargetApi(18)
    public static long calculateDiskCacheSize(File file) {
        long j;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
        } catch (IllegalArgumentException unused) {
            j = 5242880;
        }
        return Math.max(Math.min(j, 52428800), 5242880);
    }

    public static int calculateMemoryCacheSize(Context context) {
        ActivityManager activityManager = (ActivityManager) getService(context, "activity");
        return (int) ((((long) ((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass())) * 1048576) / 7);
    }

    public static void checkMain() {
        if (!isMain()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    public static void checkNotMain() {
        if (isMain()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static File createDefaultCacheDir(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), PICASSO_CACHE);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String createKey(Request request) {
        String createKey = createKey(request, MAIN_THREAD_KEY_BUILDER);
        MAIN_THREAD_KEY_BUILDER.setLength(0);
        return createKey;
    }

    public static void flushStackLocalLeaks(Looper looper) {
        AnonymousClass1 r0 = new Handler(looper) {
            public void handleMessage(Message message) {
                sendMessageDelayed(obtainMessage(), 1000);
            }
        };
        r0.sendMessageDelayed(r0.obtainMessage(), 1000);
    }

    public static int getBitmapBytes(Bitmap bitmap) {
        int allocationByteCount = bitmap.getAllocationByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    public static String getLogIdsForHunter(BitmapHunter bitmapHunter) {
        return getLogIdsForHunter(bitmapHunter, "");
    }

    public static int getResourceId(Resources resources, Request request) throws FileNotFoundException {
        int i;
        if (request.resourceId == 0) {
            Uri uri = request.uri;
            if (uri != null) {
                String authority = uri.getAuthority();
                if (authority != null) {
                    List<String> pathSegments = request.uri.getPathSegments();
                    if (pathSegments == null || pathSegments.isEmpty()) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("No path segments: ");
                        outline73.append(request.uri);
                        throw new FileNotFoundException(outline73.toString());
                    }
                    if (pathSegments.size() == 1) {
                        try {
                            i = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Last path segment is not a resource ID: ");
                            outline732.append(request.uri);
                            throw new FileNotFoundException(outline732.toString());
                        }
                    } else if (pathSegments.size() == 2) {
                        i = resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        StringBuilder outline733 = GeneratedOutlineSupport.outline73("More than two path segments: ");
                        outline733.append(request.uri);
                        throw new FileNotFoundException(outline733.toString());
                    }
                    return i;
                }
                StringBuilder outline734 = GeneratedOutlineSupport.outline73("No package provided: ");
                outline734.append(request.uri);
                throw new FileNotFoundException(outline734.toString());
            }
        }
        return request.resourceId;
    }

    public static Resources getResources(Context context, Request request) throws FileNotFoundException {
        if (request.resourceId == 0) {
            Uri uri = request.uri;
            if (uri != null) {
                String authority = uri.getAuthority();
                if (authority != null) {
                    try {
                        return context.getPackageManager().getResourcesForApplication(authority);
                    } catch (NameNotFoundException unused) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unable to obtain resources for package: ");
                        outline73.append(request.uri);
                        throw new FileNotFoundException(outline73.toString());
                    }
                } else {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("No package provided: ");
                    outline732.append(request.uri);
                    throw new FileNotFoundException(outline732.toString());
                }
            }
        }
        return context.getResources();
    }

    public static <T> T getService(Context context, String str) {
        return context.getSystemService(str);
    }

    public static boolean hasPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean isAirplaneModeOn(Context context) {
        try {
            if (Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
                return true;
            }
            return false;
        } catch (NullPointerException | SecurityException unused) {
            return false;
        }
    }

    public static boolean isMain() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean isWebPFile(BufferedSource bufferedSource) throws IOException {
        return bufferedSource.rangeEquals(0, WEBP_FILE_HEADER_RIFF) && bufferedSource.rangeEquals(8, WEBP_FILE_HEADER_WEBP);
    }

    public static void log(String str, String str2, String str3) {
        log(str, str2, str3, "");
    }

    public static String getLogIdsForHunter(BitmapHunter bitmapHunter, String str) {
        StringBuilder sb = new StringBuilder(str);
        Action action = bitmapHunter.getAction();
        if (action != null) {
            sb.append(action.request.logId());
        }
        List<Action> actions = bitmapHunter.getActions();
        if (actions != null) {
            int size = actions.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || action != null) {
                    sb.append(", ");
                }
                sb.append(actions.get(i).request.logId());
            }
        }
        return sb.toString();
    }

    public static void log(String str, String str2, String str3, String str4) {
        String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4});
    }

    public static String createKey(Request request, StringBuilder sb) {
        String str = request.stableKey;
        if (str != null) {
            sb.ensureCapacity(str.length() + 50);
            sb.append(request.stableKey);
        } else {
            Uri uri = request.uri;
            if (uri != null) {
                String uri2 = uri.toString();
                sb.ensureCapacity(uri2.length() + 50);
                sb.append(uri2);
            } else {
                sb.ensureCapacity(50);
                sb.append(request.resourceId);
            }
        }
        sb.append(10);
        if (request.rotationDegrees != 0.0f) {
            sb.append("rotation:");
            sb.append(request.rotationDegrees);
            if (request.hasRotationPivot) {
                sb.append('@');
                sb.append(request.rotationPivotX);
                sb.append('x');
                sb.append(request.rotationPivotY);
            }
            sb.append(10);
        }
        if (request.hasSize()) {
            sb.append("resize:");
            sb.append(request.targetWidth);
            sb.append('x');
            sb.append(request.targetHeight);
            sb.append(10);
        }
        if (request.centerCrop) {
            sb.append("centerCrop:");
            sb.append(request.centerCropGravity);
            sb.append(10);
        } else if (request.centerInside) {
            sb.append("centerInside");
            sb.append(10);
        }
        List<Transformation> list = request.transformations;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(request.transformations.get(i).key());
                sb.append(10);
            }
        }
        return sb.toString();
    }
}
