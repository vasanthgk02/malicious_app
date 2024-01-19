package timber.log;

import android.os.Build.VERSION;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.platform.android.AndroidLog;

public final class Timber {
    public static final List<Tree> FOREST = new ArrayList();
    public static final Tree[] TREE_ARRAY_EMPTY = new Tree[0];
    public static final Tree TREE_OF_SOULS = new Tree() {
        public void d(String str, Object... objArr) {
            for (Tree d2 : Timber.forestAsArray) {
                d2.d(str, objArr);
            }
        }

        public void e(String str, Object... objArr) {
            for (Tree e2 : Timber.forestAsArray) {
                e2.e(str, objArr);
            }
        }

        public void i(String str, Object... objArr) {
            for (Tree i : Timber.forestAsArray) {
                i.i(str, objArr);
            }
        }

        public void log(int i, String str, Object... objArr) {
            for (Tree log : Timber.forestAsArray) {
                log.log(i, str, objArr);
            }
        }

        public void v(String str, Object... objArr) {
            for (Tree v : Timber.forestAsArray) {
                v.v(str, objArr);
            }
        }

        public void w(String str, Object... objArr) {
            for (Tree w : Timber.forestAsArray) {
                w.w(str, objArr);
            }
        }

        public void wtf(String str, Object... objArr) {
            for (Tree wtf : Timber.forestAsArray) {
                wtf.wtf(str, objArr);
            }
        }

        public void d(Throwable th, String str, Object... objArr) {
            for (Tree d2 : Timber.forestAsArray) {
                d2.d(th, str, objArr);
            }
        }

        public void e(Throwable th, String str, Object... objArr) {
            for (Tree e2 : Timber.forestAsArray) {
                e2.e(th, str, objArr);
            }
        }

        public void i(Throwable th, String str, Object... objArr) {
            for (Tree i : Timber.forestAsArray) {
                i.i(th, str, objArr);
            }
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            for (Tree log : Timber.forestAsArray) {
                log.log(i, th, str, objArr);
            }
        }

        public void v(Throwable th, String str, Object... objArr) {
            for (Tree v : Timber.forestAsArray) {
                v.v(th, str, objArr);
            }
        }

        public void w(Throwable th, String str, Object... objArr) {
            for (Tree w : Timber.forestAsArray) {
                w.w(th, str, objArr);
            }
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            for (Tree wtf : Timber.forestAsArray) {
                wtf.wtf(th, str, objArr);
            }
        }

        public void d(Throwable th) {
            for (Tree d2 : Timber.forestAsArray) {
                d2.d(th);
            }
        }

        public void e(Throwable th) {
            for (Tree e2 : Timber.forestAsArray) {
                e2.e(th);
            }
        }

        public void i(Throwable th) {
            for (Tree i : Timber.forestAsArray) {
                i.i(th);
            }
        }

        public void log(int i, Throwable th) {
            for (Tree log : Timber.forestAsArray) {
                log.log(i, th);
            }
        }

        public void v(Throwable th) {
            for (Tree v : Timber.forestAsArray) {
                v.v(th);
            }
        }

        public void w(Throwable th) {
            for (Tree w : Timber.forestAsArray) {
                w.w(th);
            }
        }

        public void wtf(Throwable th) {
            for (Tree wtf : Timber.forestAsArray) {
                wtf.wtf(th);
            }
        }

        public void log(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }
    };
    public static volatile Tree[] forestAsArray = TREE_ARRAY_EMPTY;

    public static class DebugTree extends Tree {
        public static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");

        public final String getTag() {
            String tag = super.getTag();
            if (tag != null) {
                return tag;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 5) {
                String className = stackTrace[5].getClassName();
                Matcher matcher = ANONYMOUS_CLASS.matcher(className);
                if (matcher.find()) {
                    className = matcher.replaceAll("");
                }
                String substring = className.substring(className.lastIndexOf(46) + 1);
                if (substring.length() > 23 && VERSION.SDK_INT < 24) {
                    substring = substring.substring(0, 23);
                }
                return substring;
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        public void log(int i, String str, String str2, Throwable th) {
            int min;
            if (str2.length() < 4000) {
                if (i == 7) {
                    Log.wtf(str, str2);
                } else {
                    Log.println(i, str, str2);
                }
                return;
            }
            int i2 = 0;
            int length = str2.length();
            while (i2 < length) {
                int indexOf = str2.indexOf(10, i2);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i2 + AndroidLog.MAX_LOG_LENGTH);
                    String substring = str2.substring(i2, min);
                    if (i == 7) {
                        Log.wtf(str, substring);
                    } else {
                        Log.println(i, str, substring);
                    }
                    if (min >= indexOf) {
                        break;
                    }
                    i2 = min;
                }
                i2 = min + 1;
            }
        }
    }

    public static abstract class Tree {
        public final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        private String getStackTraceString(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private void prepareLog(int i, Throwable th, String str, Object... objArr) {
            String tag = getTag();
            if (isLoggable(tag, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = formatMessage(str, objArr);
                    }
                    if (th != null) {
                        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str, "\n");
                        outline78.append(getStackTraceString(th));
                        str = outline78.toString();
                    }
                } else if (th != null) {
                    str = getStackTraceString(th);
                } else {
                    return;
                }
                log(i, tag, str, th);
            }
        }

        public void d(String str, Object... objArr) {
            prepareLog(3, null, str, objArr);
        }

        public void e(String str, Object... objArr) {
            prepareLog(6, null, str, objArr);
        }

        public String formatMessage(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        public String getTag() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        public void i(String str, Object... objArr) {
            prepareLog(4, null, str, objArr);
        }

        @Deprecated
        public boolean isLoggable(int i) {
            return true;
        }

        public boolean isLoggable(String str, int i) {
            return isLoggable(i);
        }

        public abstract void log(int i, String str, String str2, Throwable th);

        public void log(int i, String str, Object... objArr) {
            prepareLog(i, null, str, objArr);
        }

        public void v(String str, Object... objArr) {
            prepareLog(2, null, str, objArr);
        }

        public void w(String str, Object... objArr) {
            prepareLog(5, null, str, objArr);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, null, str, objArr);
        }

        public void d(Throwable th, String str, Object... objArr) {
            prepareLog(3, th, str, objArr);
        }

        public void e(Throwable th, String str, Object... objArr) {
            prepareLog(6, th, str, objArr);
        }

        public void i(Throwable th, String str, Object... objArr) {
            prepareLog(4, th, str, objArr);
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            prepareLog(i, th, str, objArr);
        }

        public void v(Throwable th, String str, Object... objArr) {
            prepareLog(2, th, str, objArr);
        }

        public void w(Throwable th, String str, Object... objArr) {
            prepareLog(5, th, str, objArr);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            prepareLog(7, th, str, objArr);
        }

        public void d(Throwable th) {
            prepareLog(3, th, null, new Object[0]);
        }

        public void e(Throwable th) {
            prepareLog(6, th, null, new Object[0]);
        }

        public void i(Throwable th) {
            prepareLog(4, th, null, new Object[0]);
        }

        public void log(int i, Throwable th) {
            prepareLog(i, th, null, new Object[0]);
        }

        public void v(Throwable th) {
            prepareLog(2, th, null, new Object[0]);
        }

        public void w(Throwable th) {
            prepareLog(5, th, null, new Object[0]);
        }

        public void wtf(Throwable th) {
            prepareLog(7, th, null, new Object[0]);
        }
    }

    public static void plant(Tree tree) {
        if (tree != TREE_OF_SOULS) {
            synchronized (FOREST) {
                FOREST.add(tree);
                forestAsArray = (Tree[]) FOREST.toArray(new Tree[FOREST.size()]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot plant Timber into itself.");
    }
}
