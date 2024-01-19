package co.hyperverge.hypersnapsdk.f;

import android.app.Activity;
import android.os.Build.VERSION;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import co.hyperverge.hypersnapsdk.c.n;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PermissionManager */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Activity f3180a;

    /* compiled from: PermissionManager */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f3181a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f3182b;

        public a(f fVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
            this.f3182b = arrayList2;
            this.f3181a = arrayList;
        }
    }

    public boolean a(Activity activity, List<String> list) {
        this.f3180a = activity;
        if (VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            for (String next : list) {
                if (ContextCompat.checkSelfPermission(activity.getApplicationContext(), next) != 0) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                if (arrayList.contains("android.permission.CAMERA") && n.m().o) {
                    n.m().a(activity.getApplicationContext()).m();
                }
                ActivityCompat.requestPermissions(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), 1212);
                return false;
            }
        }
        return true;
    }

    public a b(Activity activity, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String next : list) {
            if (ContextCompat.checkSelfPermission(activity.getApplicationContext(), next) == 0) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        return new a(this, arrayList, arrayList2);
    }
}
