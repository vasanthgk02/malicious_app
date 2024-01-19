package com.freshchat.consumer.sdk.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.IBinder;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.widget.SearchView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.p;
import com.freshchat.consumer.sdk.j.q;

public class i {
    public static View a(Window window) {
        if (window == null || window.getDecorView() == null) {
            return null;
        }
        return window.getDecorView().getRootView();
    }

    public static void a(Context context, int i) {
        if (context != null && i != 0) {
            e(context, context.getString(i));
        }
    }

    public static void a(Context context, IBinder iBinder) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(iBinder, 0);
    }

    public static void a(Context context, View view) {
        if (view != null) {
            a(context, view.getWindowToken());
        }
    }

    public static void a(Context context, View view, int i, int i2) {
        if (view != null) {
            a(context, view, i, view.getPaddingTop(), i2, view.getPaddingBottom());
        }
    }

    public static void a(Context context, View view, int i, int i2, int i3, int i4) {
        if (view != null) {
            if (p.aD(context)) {
                int i5 = i3;
                i3 = i;
                i = i5;
            }
            view.setPadding(i, i2, i3, i4);
        }
    }

    @TargetApi(12)
    public static void a(Context context, final View view, final View view2) {
        if (context != null) {
            int integer = context.getResources().getInteger(17694720);
            view2.setAlpha(0.0f);
            view2.setVisibility(0);
            long j = (long) integer;
            view2.animate().alpha(1.0f).setDuration(j).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    view2.setVisibility(0);
                }
            });
            view.animate().alpha(0.0f).setDuration(j).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(8);
                }
            });
        }
    }

    public static void a(Context context, EditText editText) {
        int i;
        int i2;
        if (editText != null && !aw.fH()) {
            String obj = editText.getText().toString();
            boolean a2 = as.a(obj);
            if (a2) {
                i = 0;
                editText.setTextAlignment(0);
            } else {
                editText.setTextAlignment(5);
                i = ah.getTextDirection();
            }
            editText.setTextDirection(i);
            if (a2) {
                boolean c2 = as.c(obj, true);
                boolean aD = p.aD(context);
                if (c2) {
                    if (!aD) {
                        i2 = 8388629;
                        editText.setGravity(i2);
                    }
                } else if (!aD) {
                    i2 = 8388627;
                    editText.setGravity(i2);
                }
                editText.setGravity(8388631);
            }
        }
    }

    @TargetApi(23)
    public static void a(Context context, TextView textView, int i) {
        if (context != null && textView != null && i != 0) {
            int j = aq.j(context, i);
            if (j <= 0) {
                return;
            }
            if (aw.fa()) {
                textView.setTextAppearance(j);
            } else {
                textView.setTextAppearance(context, j);
            }
        }
    }

    public static void a(Context context, c cVar) {
        if (context != null && cVar != null) {
            Toast.makeText(context, cVar.toString(), 1).show();
        }
    }

    public static void a(View view, int i, int i2) {
        if (view != null) {
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public static void a(SearchView searchView, ActionBar actionBar) {
        if (!(searchView == null || actionBar == null)) {
            try {
                TypedArray obtainStyledAttributes = actionBar.getThemedContext().getTheme().obtainStyledAttributes(new int[]{R.attr.actionBarItemBackground});
                if (obtainStyledAttributes != null) {
                    if (obtainStyledAttributes.getIndexCount() != 0) {
                        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
                        if (resourceId > 0) {
                            searchView.setBackgroundResource(resourceId);
                        }
                        obtainStyledAttributes.recycle();
                    }
                }
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    public static boolean a(View view, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2).contains((int) rawX, (int) rawY);
    }

    public static Builder b(Context context, int i) {
        if (i == 0) {
            i = R.attr.freshchatAlertDialog;
        }
        return aw.eS() ? new Builder(context, aq.j(context, i)) : new Builder(context);
    }

    public static void b(View view) {
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public static void b(View view, int i) {
        if (view != null) {
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public static void c(View view) {
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public static int ca(Context context) {
        int i = 0;
        if (context == null) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i = aq.o(context, identifier);
        }
        if (i <= 0) {
            i = aq.o(context, R.dimen.freshchat_status_bar_height);
        }
        return i;
    }

    public static int cb(Context context) {
        int i = 0;
        if (context == null) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R$attr.actionBarSize, typedValue, true)) {
            i = TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        if (i <= 0) {
            i = aq.o(context, R.dimen.freshchat_action_bar_height);
        }
        return i;
    }

    public static void e(Context context, String str) {
        if (context != null && !as.isEmpty(str)) {
            Toast.makeText(context, str, 1).show();
        }
    }

    public static void e(View view) {
        if (f(view)) {
            view.requestFocus();
        }
    }

    public static boolean f(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean k(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int height = view.getHeight();
        return ((double) (height - rect.bottom)) > ((double) height) * 0.15d;
    }

    public static Builder m(Context context) {
        return b(context, 0);
    }
}
