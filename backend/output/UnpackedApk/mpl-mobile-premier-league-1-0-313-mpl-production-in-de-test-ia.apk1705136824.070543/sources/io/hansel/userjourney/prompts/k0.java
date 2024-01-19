package io.hansel.userjourney.prompts;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;

public class k0 implements OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    public Activity f5568a;

    /* renamed from: b  reason: collision with root package name */
    public View f5569b;

    /* renamed from: c  reason: collision with root package name */
    public int f5570c;

    /* renamed from: d  reason: collision with root package name */
    public l0 f5571d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5572e = false;

    /* renamed from: f  reason: collision with root package name */
    public EditText f5573f;
    public boolean g;

    public k0(Activity activity, l0 l0Var, EditText editText) {
        this.f5568a = activity;
        this.f5569b = a(activity);
        this.f5571d = l0Var;
        a();
        Rect rect = new Rect();
        this.f5569b.getWindowVisibleDisplayFrame(rect);
        this.f5570c = rect.height();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SoftKeyboardListener: Initial window height is ");
        outline73.append(this.f5570c);
        HSLLogger.d(outline73.toString(), LogGroup.PT);
        this.f5573f = editText;
    }

    private View a(Activity activity) {
        return ((ViewGroup) activity.getWindow().getDecorView()).getChildAt(0);
    }

    private void a() {
        LogGroup logGroup = LogGroup.PT;
        HSLLogger.d("SoftKeyboardListener: Hide keyboard method called.", logGroup);
        InputMethodManager inputMethodManager = (InputMethodManager) this.f5568a.getSystemService("input_method");
        if (inputMethodManager.isAcceptingText()) {
            try {
                HSLLogger.d("SoftKeyboardListener: Hiding the keyboard.", logGroup);
                this.g = true;
                inputMethodManager.hideSoftInputFromWindow(this.f5568a.getCurrentFocus().getWindowToken(), 0);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th, "Unable to hide keyboard", LogGroup.PT);
            }
        }
    }

    public void onGlobalLayout() {
        boolean z;
        Rect rect = new Rect();
        this.f5569b.getWindowVisibleDisplayFrame(rect);
        int height = this.f5570c - rect.height();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SoftKeyboardListener: The windowHeight is ");
        outline73.append(this.f5570c);
        outline73.append(" and current rect height is ");
        outline73.append(rect.height());
        HSLLogger.d(outline73.toString(), LogGroup.PT);
        if (height > 0 && !this.f5572e && this.f5573f.isFocused()) {
            this.f5571d.a(height);
            z = true;
        } else if (height == 0 && this.f5572e) {
            this.f5571d.a(height);
            z = false;
        } else if (this.g && height < 0) {
            this.f5570c = rect.height();
            return;
        } else {
            return;
        }
        this.f5572e = z;
    }
}
