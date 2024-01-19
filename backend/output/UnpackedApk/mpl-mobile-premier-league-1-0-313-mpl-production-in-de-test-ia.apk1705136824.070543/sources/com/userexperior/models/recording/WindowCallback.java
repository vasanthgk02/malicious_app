package com.userexperior.models.recording;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.ActionMode;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.userexperior.interfaces.recording.e;
import com.userexperior.interfaces.recording.f;
import com.userexperior.interfaces.recording.g;
import com.userexperior.models.recording.enums.h;
import com.userexperior.utilities.b;
import java.util.logging.Level;

public class WindowCallback implements OnDoubleTapListener, OnGestureListener, OnScaleGestureListener, Callback {

    /* renamed from: b  reason: collision with root package name */
    public static final String f4037b = WindowCallback.class.getSimpleName();
    public static String i = "";
    public static MotionEvent j;
    public static boolean k;
    public static boolean l;
    public static MotionEvent m;
    public static MotionEvent n;

    /* renamed from: a  reason: collision with root package name */
    public final Callback f4038a;

    /* renamed from: c  reason: collision with root package name */
    public final Activity f4039c;

    /* renamed from: d  reason: collision with root package name */
    public final GestureDetector f4040d;

    /* renamed from: e  reason: collision with root package name */
    public final d f4041e;

    /* renamed from: f  reason: collision with root package name */
    public final e f4042f;
    public final String g;
    public final CountDownTimer h;
    public boolean o = false;
    public final boolean p;

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0058, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WindowCallback(android.view.Window.Callback r3, android.app.Activity r4, com.userexperior.interfaces.recording.e r5, android.os.CountDownTimer r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.o = r0
            r2.f4039c = r4
            r2.f4038a = r3
            android.view.GestureDetector r3 = new android.view.GestureDetector
            android.content.Context r1 = r4.getBaseContext()
            r3.<init>(r1, r2)
            r2.f4040d = r3
            com.userexperior.models.recording.d r3 = new com.userexperior.models.recording.d
            android.content.Context r1 = r4.getBaseContext()
            r3.<init>(r1, r2)
            r2.f4041e = r3
            r2.f4042f = r5
            java.lang.Class r3 = r4.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.g = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r1 = "WindowCallback created.."
            r3.<init>(r1)
            java.lang.String r1 = r2.toString()
            r3.append(r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r1 = "notification send to "
            r3.<init>(r1)
            java.lang.String r5 = r5.toString()
            r3.append(r5)
            r2.h = r6
            android.content.Context r3 = r4.getApplicationContext()
            com.userexperior.c.b.a r3 = com.userexperior.utilities.l.e(r3)
            if (r3 == 0) goto L_0x0059
            boolean r3 = r3.l
            if (r3 == 0) goto L_0x0059
            r0 = 1
        L_0x0059:
            r2.p = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.models.recording.WindowCallback.<init>(android.view.Window$Callback, android.app.Activity, com.userexperior.interfaces.recording.e, android.os.CountDownTimer):void");
    }

    public static String a() {
        return i;
    }

    @SuppressLint({"ResourceType"})
    public static String a(EditText editText) {
        String str;
        Exception e2;
        if (editText == null) {
            return null;
        }
        try {
            if (editText.getId() == -1) {
                return null;
            }
            str = editText.getResources().getResourceName(editText.getId());
            try {
                str = str.substring(str.indexOf(":id/") + 4);
            } catch (Exception e3) {
                e2 = e3;
                e2.printStackTrace();
                return str;
            }
            return str;
        } catch (Exception e4) {
            e2 = e4;
            str = null;
            e2.printStackTrace();
            return str;
        }
    }

    private void a(final h hVar, final InputEvent inputEvent) {
        e eVar = this.f4042f;
        if (eVar != null) {
            eVar.a(new Runnable() {
                public final void run() {
                    boolean z;
                    try {
                        String h = a.h();
                        WindowCallback.i = "";
                        WindowCallback.this.n();
                        WindowCallback.f4037b;
                        StringBuilder sb = new StringBuilder("objectName: ");
                        sb.append(WindowCallback.i);
                        sb.append(" type: ");
                        sb.append(hVar.toString());
                        e c2 = WindowCallback.this.f4042f;
                        h hVar = hVar;
                        if (h == null) {
                            h = WindowCallback.this.g;
                        }
                        InputEvent inputEvent = inputEvent;
                        String i = WindowCallback.i;
                        if (inputEvent instanceof KeyEvent) {
                            if (WindowCallback.this.o) {
                                z = false;
                                c2.a(hVar, h, inputEvent, (g) new f(i, z));
                                WindowCallback.i = "";
                                WindowCallback.this.o = false;
                            }
                        }
                        z = true;
                        c2.a(hVar, h, inputEvent, (g) new f(i, z));
                        WindowCallback.i = "";
                        WindowCallback.this.o = false;
                    } catch (Exception e2) {
                        Level level = Level.SEVERE;
                        b.a(level, "ex : WC - notifyEventAndResetObjectName : " + e2.getMessage());
                        WindowCallback.f4037b;
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public static MotionEvent b() {
        return j;
    }

    public static void b(h hVar, MotionEvent motionEvent) {
        new StringBuilder("event type ").append(hVar.toString());
        new StringBuilder("current uptime:").append(SystemClock.uptimeMillis());
        if (motionEvent != null) {
            new StringBuilder("event downTime:").append(motionEvent.getDownTime());
        }
    }

    public static boolean c() {
        return k;
    }

    public static boolean d() {
        return l;
    }

    public static MotionEvent e() {
        return m;
    }

    public static MotionEvent f() {
        return n;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0078, code lost:
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007c, code lost:
        i = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String n() {
        /*
            r3 = this;
            boolean r0 = r3.p
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            android.app.Activity r0 = r3.f4039c
            android.view.Window r0 = r0.getWindow()
            android.view.View r0 = r0.getDecorView()
            android.view.View r0 = r0.getRootView()
            java.util.ArrayList r0 = r0.getTouchables()
            java.util.Iterator r0 = r0.iterator()
        L_0x001c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007e
            java.lang.Object r1 = r0.next()
            android.view.View r1 = (android.view.View) r1
            boolean r2 = r1.isPressed()
            if (r2 != 0) goto L_0x003a
            boolean r2 = r1.isSelected()
            if (r2 != 0) goto L_0x003a
            boolean r2 = r1.isHovered()
            if (r2 == 0) goto L_0x001c
        L_0x003a:
            boolean r2 = r1 instanceof android.widget.TextView
            if (r2 == 0) goto L_0x006a
            boolean r0 = r1 instanceof android.widget.EditText
            if (r0 == 0) goto L_0x005d
            android.widget.EditText r1 = (android.widget.EditText) r1
            java.lang.CharSequence r0 = r1.getHint()
            if (r0 == 0) goto L_0x004f
            java.lang.CharSequence r0 = r1.getHint()
            goto L_0x0078
        L_0x004f:
            java.lang.String r0 = a(r1)
            if (r0 == 0) goto L_0x005a
            java.lang.String r0 = a(r1)
            goto L_0x007c
        L_0x005a:
            java.lang.String r0 = "Edit Box"
            goto L_0x007c
        L_0x005d:
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.CharSequence r0 = r1.getText()
            if (r0 == 0) goto L_0x007e
            java.lang.CharSequence r0 = r1.getText()
            goto L_0x0078
        L_0x006a:
            boolean r2 = r1 instanceof android.widget.ImageView
            if (r2 == 0) goto L_0x001c
            java.lang.CharSequence r2 = r1.getContentDescription()
            if (r2 == 0) goto L_0x001c
            java.lang.CharSequence r0 = r1.getContentDescription()
        L_0x0078:
            java.lang.String r0 = r0.toString()
        L_0x007c:
            i = r0
        L_0x007e:
            java.lang.String r0 = i
            if (r0 == 0) goto L_0x00a2
            int r0 = r0.length()
            r1 = 90
            if (r0 <= r1) goto L_0x00a2
            java.lang.String r0 = i
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r1)
            i = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = i
            java.lang.String r2 = "..."
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r0, r1, r2)
            i = r0
        L_0x00a2:
            java.lang.String r0 = i
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.userexperior.models.recording.WindowCallback.n():java.lang.String");
    }

    private void o() {
        CountDownTimer countDownTimer = this.h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.h.start();
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        o();
        if (VERSION.SDK_INT >= 23) {
            this.f4040d.onGenericMotionEvent(motionEvent);
        }
        try {
            return this.f4038a.dispatchGenericMotionEvent(motionEvent);
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "ex : WC - dGME : " + e2.getMessage());
            e2.getMessage();
            return false;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        o();
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            a(h.BACK_BUTTON_PRESSED, (InputEvent) keyEvent);
        }
        return this.f4038a.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        o();
        try {
            return this.f4038a.dispatchKeyShortcutEvent(keyEvent);
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "ex : WC - dKSE : " + e2.getMessage());
            new StringBuilder("dispatchKeyShortcutEvent. ").append(e2.getMessage());
            return false;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        try {
            return this.f4038a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "ex : WC - dPAE : " + e2.getMessage());
            new StringBuilder("dispatchPopulateAccessibilityEvent. ").append(e2.getMessage());
            return false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        o();
        try {
            this.o = this.f4038a.dispatchTouchEvent(motionEvent);
            this.f4040d.onTouchEvent(motionEvent);
            this.f4041e.onTouchEvent(motionEvent);
            return this.o;
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "ex : WC - dTE : " + e2.getMessage());
            new StringBuilder("dispatchTouchEvent. ").append(e2.getMessage());
            return false;
        }
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        o();
        try {
            return this.f4038a.dispatchTrackballEvent(motionEvent);
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "ex : WC - dTrackE : " + e2.getMessage());
            new StringBuilder("dispatchTrackballEvent. ").append(e2.getMessage());
            return false;
        }
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f4038a.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f4038a.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f4038a.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f4038a.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        return this.f4038a.onCreatePanelMenu(i2, menu);
    }

    public View onCreatePanelView(int i2) {
        return this.f4038a.onCreatePanelView(i2);
    }

    public void onDetachedFromWindow() {
        this.f4038a.onDetachedFromWindow();
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        b(h.DOUBLE_TAP, motionEvent);
        a(h.DOUBLE_TAP, (InputEvent) motionEvent);
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, float f2, float f3) {
        e eVar = this.f4042f;
        if (eVar != null) {
            eVar.a(new Runnable() {
                public final void run() {
                    try {
                        String h = a.h();
                        WindowCallback.l = false;
                        WindowCallback.m = null;
                        WindowCallback.n = null;
                        e c2 = WindowCallback.this.f4042f;
                        h hVar = h.SWIPE;
                        if (h == null) {
                            h = WindowCallback.this.g;
                        }
                        c2.a(hVar, h, motionEvent, motionEvent2);
                    } catch (Exception e2) {
                        Level level = Level.SEVERE;
                        b.a(level, "ex : WC - onFl : " + e2.getMessage());
                        WindowCallback.f4037b;
                        e2.printStackTrace();
                    }
                }
            });
        }
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        b(h.LONG_PRESS, motionEvent);
        a(h.LONG_PRESS, (InputEvent) motionEvent);
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        return this.f4038a.onMenuItemSelected(i2, menuItem);
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return this.f4038a.onMenuOpened(i2, menu);
    }

    public void onPanelClosed(int i2, Menu menu) {
        this.f4038a.onPanelClosed(i2, menu);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        return this.f4038a.onPreparePanel(i2, view, menu);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        return false;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(final ScaleGestureDetector scaleGestureDetector) {
        e eVar = this.f4042f;
        if (eVar != null) {
            eVar.a(new Runnable() {
                public final void run() {
                    try {
                        String h = a.h();
                        MotionEvent motionEvent = WindowCallback.this.f4041e.f4077a;
                        MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), motionEvent.getEventTime(), motionEvent.getAction(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), motionEvent.getMetaState());
                        if (scaleGestureDetector.getScaleFactor() < 1.0f) {
                            WindowCallback.b(h.PINCH, obtain);
                            e c2 = WindowCallback.this.f4042f;
                            h hVar = h.PINCH;
                            if (h == null) {
                                h = WindowCallback.this.g;
                            }
                            c2.a(hVar, h, obtain);
                            return;
                        }
                        WindowCallback.b(h.ZOOM, obtain);
                        e c3 = WindowCallback.this.f4042f;
                        h hVar2 = h.ZOOM;
                        if (h == null) {
                            h = WindowCallback.this.g;
                        }
                        c3.a(hVar2, h, obtain);
                    } catch (Exception e2) {
                        Level level = Level.SEVERE;
                        b.a(level, "ex : WC - onScEn : " + e2.getMessage());
                        WindowCallback.f4037b;
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        e eVar = this.f4042f;
        if (eVar != null) {
            eVar.d();
        }
        l = true;
        m = motionEvent;
        n = motionEvent2;
        return false;
    }

    public boolean onSearchRequested() {
        return this.f4038a.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        if (VERSION.SDK_INT >= 23) {
            return this.f4038a.onSearchRequested(searchEvent);
        }
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapConfirmed(final MotionEvent motionEvent) {
        e eVar = this.f4042f;
        if (eVar != null) {
            eVar.a(new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:10:0x0046 A[Catch:{ Exception -> 0x0070 }] */
                /* JADX WARNING: Removed duplicated region for block: B:13:0x005c A[Catch:{ Exception -> 0x0070 }] */
                /* JADX WARNING: Removed duplicated region for block: B:14:0x005e A[Catch:{ Exception -> 0x0070 }] */
                /* JADX WARNING: Removed duplicated region for block: B:9:0x0045 A[Catch:{ Exception -> 0x0070 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r7 = this;
                        long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0070 }
                        long r2 = com.userexperior.services.recording.i.c()     // Catch:{ Exception -> 0x0070 }
                        r4 = 0
                        int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                        if (r6 == 0) goto L_0x0026
                        long r2 = com.userexperior.services.recording.i.c()     // Catch:{ Exception -> 0x0070 }
                        java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0070 }
                        long r0 = com.userexperior.e.h.a(r2, r0, r4)     // Catch:{ Exception -> 0x0070 }
                        com.userexperior.services.recording.i.d()     // Catch:{ Exception -> 0x0070 }
                        r2 = 300(0x12c, double:1.48E-321)
                        int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                        if (r4 >= 0) goto L_0x0026
                        java.lang.String r0 = com.userexperior.models.recording.a.i()     // Catch:{ Exception -> 0x0070 }
                        goto L_0x002a
                    L_0x0026:
                        java.lang.String r0 = com.userexperior.models.recording.a.h()     // Catch:{ Exception -> 0x0070 }
                    L_0x002a:
                        r1 = 0
                        com.userexperior.models.recording.a.b(r1)     // Catch:{ Exception -> 0x0070 }
                        com.userexperior.models.recording.WindowCallback.k = true     // Catch:{ Exception -> 0x0070 }
                        com.userexperior.models.recording.WindowCallback.j = null     // Catch:{ Exception -> 0x0070 }
                        com.userexperior.models.recording.enums.h r1 = com.userexperior.models.recording.enums.h.TAP     // Catch:{ Exception -> 0x0070 }
                        android.view.MotionEvent r2 = r3     // Catch:{ Exception -> 0x0070 }
                        com.userexperior.models.recording.WindowCallback.b(r1, r2)     // Catch:{ Exception -> 0x0070 }
                        com.userexperior.models.recording.WindowCallback r1 = com.userexperior.models.recording.WindowCallback.this     // Catch:{ Exception -> 0x0070 }
                        com.userexperior.interfaces.recording.e r1 = r1.f4042f     // Catch:{ Exception -> 0x0070 }
                        com.userexperior.models.recording.enums.h r2 = com.userexperior.models.recording.enums.h.TAP     // Catch:{ Exception -> 0x0070 }
                        if (r0 == 0) goto L_0x0046
                        goto L_0x004c
                    L_0x0046:
                        com.userexperior.models.recording.WindowCallback r0 = com.userexperior.models.recording.WindowCallback.this     // Catch:{ Exception -> 0x0070 }
                        java.lang.String r0 = r0.g     // Catch:{ Exception -> 0x0070 }
                    L_0x004c:
                        android.view.MotionEvent r3 = r3     // Catch:{ Exception -> 0x0070 }
                        com.userexperior.interfaces.recording.f r4 = new com.userexperior.interfaces.recording.f     // Catch:{ Exception -> 0x0070 }
                        java.lang.String r5 = com.userexperior.models.recording.WindowCallback.i     // Catch:{ Exception -> 0x0070 }
                        com.userexperior.models.recording.WindowCallback r6 = com.userexperior.models.recording.WindowCallback.this     // Catch:{ Exception -> 0x0070 }
                        boolean r6 = r6.o     // Catch:{ Exception -> 0x0070 }
                        if (r6 != 0) goto L_0x005e
                        r6 = 1
                        goto L_0x005f
                    L_0x005e:
                        r6 = 0
                    L_0x005f:
                        r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0070 }
                        r1.a(r2, r0, r3, r4)     // Catch:{ Exception -> 0x0070 }
                        java.lang.String r0 = ""
                        com.userexperior.models.recording.WindowCallback.i = r0     // Catch:{ Exception -> 0x0070 }
                        com.userexperior.models.recording.WindowCallback r0 = com.userexperior.models.recording.WindowCallback.this     // Catch:{ Exception -> 0x0070 }
                        r0.o = false     // Catch:{ Exception -> 0x0070 }
                        return
                    L_0x0070:
                        r0 = move-exception
                        java.util.logging.Level r1 = java.util.logging.Level.SEVERE
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        java.lang.String r3 = "ex : WC - oSTapC : "
                        r2.<init>(r3)
                        java.lang.String r3 = r0.getMessage()
                        r2.append(r3)
                        java.lang.String r2 = r2.toString()
                        com.userexperior.utilities.b.a(r1, r2)
                        com.userexperior.models.recording.WindowCallback.f4037b
                        r0.printStackTrace()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.userexperior.models.recording.WindowCallback.AnonymousClass1.run():void");
                }
            });
        }
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        try {
            this.f4042f.c();
            k = false;
            n();
            j = motionEvent;
        } catch (Exception e2) {
            Level level = Level.SEVERE;
            b.a(level, "ex : WC - oSTapUp : " + e2.getMessage());
            e2.printStackTrace();
        }
        return false;
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.f4038a.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.f4038a.onWindowFocusChanged(z);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f4038a.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
        if (VERSION.SDK_INT >= 23) {
            return this.f4038a.onWindowStartingActionMode(callback, i2);
        }
        return null;
    }
}
