package a;

import android.app.Activity;
import androidx.core.widget.CompoundButtonCompat;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.OneTimeWorkRequest.Builder;
import com.amazon.apay.hardened.worker.RecordPublishWorker;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;
import timber.log.Timber;

public class a implements UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f2379a;

    public a(Activity activity) {
        this.f2379a = activity;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null && th.toString().contains("com.amazon.apay.hardened")) {
            Timber.TREE_OF_SOULS.e(th, "ExceptionHandler:uncaughtException invoked", new Object[0]);
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            CompoundButtonCompat.f956a = true;
            Builder builder = new Builder(RecordPublishWorker.class);
            HashMap hashMap = new HashMap();
            hashMap.put("STACK_TRACE", stringWriter.toString());
            Data data = new Data((Map<String, ?>) hashMap);
            Data.toByteArrayInternal(data);
            builder.mWorkSpec.input = data;
            CompoundButtonCompat.f958c.enqueue((OneTimeWorkRequest) builder.build());
        }
        this.f2379a.finish();
    }
}
