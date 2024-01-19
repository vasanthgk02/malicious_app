package io.hansel.userjourney.prompts;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.IMessageBroker;
import io.hansel.segments.b;
import io.hansel.segments.c;
import java.util.HashMap;

public class q0 extends Fragment implements h {

    /* renamed from: a  reason: collision with root package name */
    public r f5628a;

    /* renamed from: b  reason: collision with root package name */
    public b f5629b;

    public static q0 a(CoreJSONObject coreJSONObject, IMessageBroker iMessageBroker, String str) {
        q0 q0Var = new q0();
        q0Var.f5628a = new r(coreJSONObject, iMessageBroker, q0Var, str);
        return q0Var;
    }

    public void a() {
        try {
            this.f5628a.a();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in updatePromptPosition method of TriggerDialogFragment", LogGroup.PT);
        }
    }

    public void a(Activity activity) {
        this.f5628a.a(activity);
    }

    public void a(CoreJSONObject coreJSONObject, k kVar) {
        try {
            this.f5628a.a(coreJSONObject, kVar);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in setNudgeType method of TriggerDialogFragment", LogGroup.PT);
        }
    }

    public void a(b bVar, c cVar) {
        try {
            this.f5629b = bVar;
            this.f5628a.a(bVar, cVar);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in setmCallback method of TriggerDialogFragment", LogGroup.PT);
        }
    }

    public void a(String str, String str2, boolean z) {
        try {
            this.f5628a.a(str, str2, z);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in onPromptDismiss method of TriggerDialogFragment", LogGroup.PT);
        }
    }

    public void a(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2) {
        try {
            this.f5629b.a(hashMap, hashMap2, this);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in onNudgeShow method of TriggerDialogFragment", LogGroup.PT);
        }
    }

    public void a(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, HashMap<String, Object> hashMap3, HashMap<String, Object> hashMap4) {
        try {
            this.f5628a.a(hashMap, hashMap2, hashMap3, hashMap4);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in setmPropSend method of TriggerDialogFragment", LogGroup.PT);
        }
    }

    public void a(String[] strArr) {
        try {
            this.f5628a.a(strArr);
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in onImageLoaded method of TriggerDialogFragment", LogGroup.PT);
        }
    }

    public String b() {
        try {
            return this.f5628a.b();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in getPromptId method of TriggerDialogFragment", LogGroup.PT);
            return null;
        }
    }

    public k c() {
        try {
            return this.f5628a.i();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in getNudgeBluePrint method of TriggerDialogFragment", LogGroup.PT);
            return null;
        }
    }

    public void d() {
        try {
            this.f5628a.p();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in onBackPressed method of TriggerDialogFragment", LogGroup.PT);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            r rVar = this.f5628a;
            if (rVar != null) {
                return (View) rVar.a(layoutInflater, viewGroup).second;
            }
            return null;
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in onCreateView method of the TriggerDialogFragment", LogGroup.PT);
            return null;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStop() {
        LogGroup logGroup;
        String str;
        try {
            if (this.f5628a != null) {
                str = "React check: onStop method invoked. " + this.f5628a.b();
                logGroup = LogGroup.PT;
            } else {
                logGroup = LogGroup.PT;
                str = "NudgeViewManager is null in onStop method of triggerDialogFragment";
            }
            HSLLogger.d(str, logGroup);
            this.f5628a.m();
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th, "Exception caught in onStop method of the triggerDialogFragment", LogGroup.PT);
        }
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
