package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.workflow.WorkflowActivity;

@SuppressLint({"Registered"})
/* renamed from: m  reason: default package */
public class m extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3319a = m.class.getName();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        cp.a(f3319a, (String) "onCreate");
        try {
            WorkflowActivity.a(getIntent().getData(), this, e.a(getIntent().getData()), f3319a);
        } catch (AuthError e2) {
            cp.a(f3319a, "Could not fetch request ID from the response uri", getIntent().getData().toString(), e2);
        }
        finish();
    }
}
