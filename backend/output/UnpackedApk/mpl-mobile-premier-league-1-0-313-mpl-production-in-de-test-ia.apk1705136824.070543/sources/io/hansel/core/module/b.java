package io.hansel.core.module;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.base.task.HSLTaskHandler;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import java.util.ArrayList;
import java.util.HashMap;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public HSLTaskHandler f5181a = new HSLTaskHandler();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, ArrayList<a>> f5182b = new HashMap<>();

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f5183a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f5184b;

        /* renamed from: io.hansel.core.module.b$a$a  reason: collision with other inner class name */
        public class C0076a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f5186a;

            public C0076a(a aVar) {
                this.f5186a = aVar;
            }

            public void run() {
                try {
                    a aVar = this.f5186a;
                    a aVar2 = a.this;
                    aVar.handleEventData(aVar2.f5183a, aVar2.f5184b);
                } catch (Throwable th) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Something went wrong while handling non-blocking event ");
                    outline73.append(a.this.f5183a);
                    HSLLogger.printStackTrace(th, outline73.toString(), LogGroup.PT);
                }
            }
        }

        public a(String str, Object obj) {
            this.f5183a = str;
            this.f5184b = obj;
        }

        public void run() {
            ArrayList arrayList = b.this.f5182b.get(this.f5183a);
            if (arrayList != null) {
                int i = 0;
                while (i < arrayList.size()) {
                    try {
                        b.this.f5181a.schedule(new C0076a((a) arrayList.get(i)));
                        i++;
                    } catch (Throwable th) {
                        HSLLogger.e("Something went wrong in publishing event");
                        HSLLogger.printStackTrace(th, "Something went wrong while publishing non-blocking event: " + this.f5183a, LogGroup.PT);
                        return;
                    }
                }
            }
        }
    }

    public void a(Runnable runnable) {
        this.f5181a.schedule(runnable);
    }

    public void a(String str, a aVar) {
        ArrayList arrayList = this.f5182b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f5182b.put(str, arrayList);
        }
        arrayList.add(aVar);
    }

    public void a(String str, Object obj) {
        ArrayList arrayList = this.f5182b.get(str);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                try {
                    ((a) arrayList.get(i)).handleEventData(str, obj);
                } catch (Throwable th) {
                    HSLLogger.printStackTrace(th, GeneratedOutlineSupport.outline50("Something went wrong while publishing blocking event: ", str), LogGroup.PT);
                }
            }
        }
    }

    public Object b(String str, Object obj) {
        ArrayList arrayList = this.f5182b.get(str);
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                try {
                    return ((a) arrayList.get(i)).returnEventData(str, obj);
                } catch (Throwable th) {
                    HSLLogger.printStackTrace(th, GeneratedOutlineSupport.outline50("Something went wrong while publishing blocking event for return: ", str), LogGroup.PT);
                    i++;
                }
            }
        }
        return null;
    }

    public void c(String str, Object obj) {
        this.f5181a.schedule(new a(str, obj));
    }
}
