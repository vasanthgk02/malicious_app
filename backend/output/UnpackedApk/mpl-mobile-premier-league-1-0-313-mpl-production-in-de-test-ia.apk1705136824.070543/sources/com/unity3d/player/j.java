package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.views.textinput.ReactTextInputManager;

public final class j extends Dialog implements TextWatcher, OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static int f3505c = 1627389952;

    /* renamed from: d  reason: collision with root package name */
    public static int f3506d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static int f3507e = 134217728;

    /* renamed from: f  reason: collision with root package name */
    public static int f3508f = 67108864;

    /* renamed from: a  reason: collision with root package name */
    public Context f3509a = null;

    /* renamed from: b  reason: collision with root package name */
    public UnityPlayer f3510b = null;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public j(Context context, UnityPlayer unityPlayer, String str, int i, boolean z, boolean z2, boolean z3, String str2, int i2, boolean z4) {
        super(context);
        this.f3509a = context;
        this.f3510b = unityPlayer;
        a(z4);
        getWindow().requestFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        final View createSoftInputView = createSoftInputView();
        setContentView(createSoftInputView);
        getWindow().setLayout(-1, -2);
        getWindow().clearFlags(2);
        if (i.f3500a) {
            getWindow().clearFlags(f3507e);
            getWindow().clearFlags(f3508f);
        }
        EditText editText = (EditText) findViewById(1057292289);
        a(editText, str, i, z, z2, z3, str2, i2);
        ((Button) findViewById(1057292290)).setOnClickListener(this);
        this.f3510b.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                if (createSoftInputView.isShown()) {
                    Rect rect = new Rect();
                    j.this.f3510b.getWindowVisibleDisplayFrame(rect);
                    int[] iArr = new int[2];
                    j.this.f3510b.getLocationOnScreen(iArr);
                    Point point = new Point(rect.left - iArr[0], rect.height() - createSoftInputView.getHeight());
                    Point point2 = new Point();
                    j.this.getWindow().getWindowManager().getDefaultDisplay().getSize(point2);
                    int height = j.this.f3510b.getHeight() - point2.y;
                    int height2 = j.this.f3510b.getHeight() - point.y;
                    int height3 = createSoftInputView.getHeight() + height;
                    UnityPlayer a2 = j.this.f3510b;
                    if (height2 != height3) {
                        a2.reportSoftInputIsVisible(true);
                    } else {
                        a2.reportSoftInputIsVisible(false);
                    }
                    j.this.f3510b.reportSoftInputArea(new Rect(point.x, point.y, createSoftInputView.getWidth(), height2));
                }
            }
        });
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    j.this.getWindow().setSoftInputMode(5);
                }
            }
        });
        editText.requestFocus();
    }

    public static int a(int i, boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z ? 32768 : 524288) | (z2 ? 131072 : 0);
        if (z3) {
            i2 = 128;
        }
        int i4 = i3 | i2;
        if (i < 0 || i > 11) {
            return i4;
        }
        int[] iArr = {1, 16385, ReactTextInputManager.INPUT_TYPE_KEYBOARD_NUMBERED, 17, 2, 3, 8289, 33, 1, 16417, 17, 8194};
        return (iArr[i] & 2) != 0 ? iArr[i] : iArr[i] | i4;
    }

    /* access modifiers changed from: private */
    public String a() {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText == null) {
            return null;
        }
        return editText.getText().toString().trim();
    }

    private void a(EditText editText, String str, int i, boolean z, boolean z2, boolean z3, String str2, int i2) {
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setHint(str2);
        editText.setHintTextColor(f3505c);
        editText.setInputType(a(i, z, z2, z3));
        editText.setImeOptions(33554432);
        if (i2 > 0) {
            editText.setFilters(new InputFilter[]{new LengthFilter(i2)});
        }
        editText.addTextChangedListener(this);
        editText.setSelection(editText.getText().length());
        editText.setClickable(true);
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z) {
        ((EditText) findViewById(1057292289)).setSelection(0, 0);
        this.f3510b.reportSoftInputStr(str, 1, z);
    }

    public final void a(int i) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            if (i > 0) {
                editText.setFilters(new InputFilter[]{new LengthFilter(i)});
                return;
            }
            editText.setFilters(new InputFilter[0]);
        }
    }

    public final void a(int i, int i2) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            int i3 = i2 + i;
            if (editText.getText().length() >= i3) {
                editText.setSelection(i, i3);
            }
        }
    }

    public final void a(String str) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            editText.setText(str);
            editText.setSelection(str.length());
        }
    }

    public final void a(boolean z) {
        int i;
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        if (z) {
            attributes.gravity = 8;
            i = 20000;
        } else {
            attributes.gravity = 80;
            i = 0;
        }
        attributes.x = i;
        attributes.y = i;
        window.setAttributes(attributes);
    }

    public final void afterTextChanged(Editable editable) {
        this.f3510b.reportSoftInputStr(editable.toString(), 0, false);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final View createSoftInputView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f3509a);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(f3506d);
        AnonymousClass3 r1 = new EditText(this.f3509a) {
            public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
                if (i == 4) {
                    j jVar = j.this;
                    jVar.a(jVar.a(), true);
                    return true;
                } else if (i == 84) {
                    return true;
                } else {
                    return super.onKeyPreIme(i, keyEvent);
                }
            }

            public final void onSelectionChanged(int i, int i2) {
                j.this.f3510b.reportSoftInputSelection(i, i2 - i);
            }

            public final void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (z) {
                    ((InputMethodManager) j.this.f3509a.getSystemService("input_method")).showSoftInput(this, 0);
                }
            }
        };
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, 1057292290);
        r1.setLayoutParams(layoutParams);
        r1.setId(1057292289);
        relativeLayout.addView(r1);
        Button button = new Button(this.f3509a);
        button.setText(this.f3509a.getResources().getIdentifier("ok", NetworkingModule.REQUEST_BODY_KEY_STRING, "android"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        button.setLayoutParams(layoutParams2);
        button.setId(1057292290);
        button.setBackgroundColor(0);
        relativeLayout.addView(button);
        ((EditText) relativeLayout.findViewById(1057292289)).setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    j jVar = j.this;
                    jVar.a(jVar.a(), false);
                }
                return false;
            }
        });
        relativeLayout.setPadding(16, 16, 16, 16);
        return relativeLayout;
    }

    public final void onBackPressed() {
        a(a(), true);
    }

    public final void onClick(View view) {
        a(a(), false);
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
