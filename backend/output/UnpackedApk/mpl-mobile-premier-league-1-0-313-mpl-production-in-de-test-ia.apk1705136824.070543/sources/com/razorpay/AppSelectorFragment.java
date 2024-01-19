package com.razorpay;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import java.util.ArrayList;
import java.util.HashMap;

public class AppSelectorFragment extends Fragment {
    public ArrayList<String> B$$W$;
    public OnGlobalLayoutListener D$_X_ = new OnGlobalLayoutListener() {
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00ab  */
        /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onGlobalLayout() {
            /*
                r12 = this;
                com.razorpay.AppSelectorFragment r0 = com.razorpay.AppSelectorFragment.this
                android.app.Activity r0 = r0.getActivity()
                int r1 = com.razorpay.R.id.ll_curtain_container
                android.view.View r1 = r0.findViewById(r1)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                int r2 = com.razorpay.BaseUtils.getDisplayHeight(r0)
                int r3 = com.razorpay.R.id.dark_background
                android.view.View r0 = r0.findViewById(r3)
                r3 = 2
                int[] r4 = new int[r3]
                r0.getLocationInWindow(r4)
                r5 = 1
                r4 = r4[r5]
                com.razorpay.AppSelectorFragment r6 = com.razorpay.AppSelectorFragment.this
                java.util.ArrayList<java.lang.String> r6 = r6.d__1_
                r7 = -1
                r8 = 0
                if (r6 == 0) goto L_0x0091
                int r6 = r6.size()
                if (r6 <= 0) goto L_0x0091
                com.razorpay.AppSelectorFragment r6 = com.razorpay.AppSelectorFragment.this
                java.util.ArrayList<java.lang.String> r6 = r6.a_$P$
                if (r6 == 0) goto L_0x0091
                int r6 = r6.size()
                if (r6 <= 0) goto L_0x0091
                android.view.View r6 = r1.getChildAt(r3)
                boolean r9 = r6 instanceof android.widget.LinearLayout
                if (r9 == 0) goto L_0x00a9
                android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
                int r9 = r6.getChildCount()
                if (r9 < r3) goto L_0x00a9
                android.view.View r6 = r6.getChildAt(r5)
                int[] r9 = new int[r3]
                r1.getLocationInWindow(r9)
                r9 = r9[r5]
                int[] r10 = new int[r3]
                r6.getLocationInWindow(r10)
                r10 = r10[r5]
                if (r10 == 0) goto L_0x0061
                r11 = 1
                goto L_0x0062
            L_0x0061:
                r11 = 0
            L_0x0062:
                int r6 = r6.getHeight()
                int r6 = r6 / r3
                int r10 = r10 - r9
                int r2 = r2 - r10
                int r2 = r2 - r4
                int r2 = r2 - r6
                if (r2 >= 0) goto L_0x006e
                r2 = 0
            L_0x006e:
                android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
                r3.<init>(r7, r2)
                r0.setLayoutParams(r3)
                r1.setVisibility(r8)
                android.view.animation.TranslateAnimation r0 = new android.view.animation.TranslateAnimation
                int r2 = r1.getHeight()
                float r2 = (float) r2
                r3 = 0
                r0.<init>(r3, r3, r2, r3)
                r2 = 500(0x1f4, double:2.47E-321)
                r0.setDuration(r2)
                r0.setFillAfter(r5)
                r1.startAnimation(r0)
                r8 = r11
                goto L_0x00a9
            L_0x0091:
                int r1 = r1.getHeight()
                if (r1 == 0) goto L_0x0098
                goto L_0x0099
            L_0x0098:
                r5 = 0
            L_0x0099:
                int r2 = r2 - r4
                int r3 = r2 / 2
                int r2 = r2 - r1
                if (r2 <= r3) goto L_0x00a0
                r3 = r2
            L_0x00a0:
                android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams
                r1.<init>(r7, r3)
                r0.setLayoutParams(r1)
                r8 = r5
            L_0x00a9:
                if (r8 == 0) goto L_0x00b6
                com.razorpay.AppSelectorFragment r0 = com.razorpay.AppSelectorFragment.this
                android.view.View r0 = r0.R$$r_
                android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()
                r0.removeGlobalOnLayoutListener(r12)
            L_0x00b6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.razorpay.AppSelectorFragment.AnonymousClass2.onGlobalLayout():void");
        }
    };
    public ArrayList<String> E$_j$;
    public String G__G_;
    public OnAppSelectedListener Q_$2$;
    public View R$$r_;
    public ArrayList<String> a_$P$;
    public OnClickListener b__J_ = new AnonymousClass3();
    public ArrayList<String> d__1_;
    public HashMap<String, ApplicationDetails> r$_Y_;

    /* renamed from: com.razorpay.AppSelectorFragment$3  reason: invalid class name */
    public class AnonymousClass3 implements OnClickListener {
        public AnonymousClass3() {
        }

        public final void onClick(View view) {
            String str = (String) view.getTag();
            AppSelectorFragment appSelectorFragment = AppSelectorFragment.this;
            OnAppSelectedListener onAppSelectedListener = appSelectorFragment.Q_$2$;
            if (onAppSelectedListener != null) {
                onAppSelectedListener.onUpiAppLaunched(str, appSelectorFragment.G__G_);
            }
            AppSelectorFragment appSelectorFragment2 = AppSelectorFragment.this;
            appSelectorFragment2.Q_$2$.openUpiApp(str, appSelectorFragment2.G__G_);
        }
    }

    private ArrayList<ApplicationDetails> R$$r_(ArrayList<String> arrayList) {
        int size = arrayList.size();
        ArrayList<ApplicationDetails> arrayList2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ApplicationDetails applicationDetails = this.r$_Y_.get(arrayList.get(i));
            if (applicationDetails != null) {
                String appName = applicationDetails.getAppName();
                String iconBase64 = applicationDetails.getIconBase64();
                if (!(appName == null || iconBase64 == null)) {
                    arrayList2.add(applicationDetails);
                }
            }
        }
        return arrayList2;
    }

    private View a_$P$() {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.upi_intent_no_apps_found, null);
        ((Button) inflate.findViewById(R.id.btn_go_back)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppSelectorFragment.this.getActivity().onBackPressed();
            }
        });
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.Q_$2$ = (OnAppSelectedListener) getActivity();
        } catch (Exception unused) {
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.G__G_ = arguments.getString("url_data");
            this.d__1_ = arguments.getStringArrayList("merchant_preferred_upi_apps_order");
            this.B$$W$ = arguments.getStringArrayList("merchant_other_upi_apps_order");
            this.E$_j$ = arguments.getStringArrayList("list_remaining_apps");
            this.r$_Y_ = (HashMap) arguments.getSerializable("upi_package_to_app_details");
        }
        if (this.d__1_ == null) {
            this.d__1_ = new ArrayList<>();
        }
        if (this.B$$W$ == null) {
            this.B$$W$ = new ArrayList<>();
        }
        if (this.E$_j$ == null) {
            this.E$_j$ = new ArrayList<>();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onCreateView(android.view.LayoutInflater r8, android.view.ViewGroup r9, android.os.Bundle r10) {
        /*
            r7 = this;
            android.app.Activity r0 = r7.getActivity()
            int r10 = com.razorpay.R.layout.upi_intent_activity_selector
            r1 = 0
            android.view.View r8 = r8.inflate(r10, r9, r1)
            int r9 = com.razorpay.R.id.ll_curtain_container
            android.view.View r9 = r8.findViewById(r9)
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            java.util.ArrayList<java.lang.String> r10 = r7.d__1_
            int r10 = r10.size()
            if (r10 != 0) goto L_0x0030
            java.util.ArrayList<java.lang.String> r10 = r7.B$$W$
            int r10 = r10.size()
            if (r10 != 0) goto L_0x0030
            java.util.ArrayList<java.lang.String> r10 = r7.E$_j$
            int r10 = r10.size()
            if (r10 != 0) goto L_0x0030
            android.view.View r8 = r7.a_$P$()
            return r8
        L_0x0030:
            java.lang.String r10 = r7.G__G_
            if (r10 == 0) goto L_0x00f5
            java.util.HashMap<java.lang.String, com.razorpay.ApplicationDetails> r10 = r7.r$_Y_
            if (r10 == 0) goto L_0x00f5
            int r10 = r10.size()
            if (r10 != 0) goto L_0x0040
            goto L_0x00f5
        L_0x0040:
            int r3 = com.razorpay.BaseUtils.getDisplayWidth(r0)
            java.util.ArrayList<java.lang.String> r10 = r7.d__1_
            int r10 = r10.size()
            r6 = 1
            if (r10 == 0) goto L_0x0080
            java.util.ArrayList<java.lang.String> r10 = r7.d__1_
            java.util.ArrayList r10 = r7.R$$r_(r10)
            int r2 = r10.size()
            if (r2 <= 0) goto L_0x005b
            r2 = 1
            goto L_0x005c
        L_0x005b:
            r2 = 0
        L_0x005c:
            int r4 = r10.size()
            if (r4 <= r6) goto L_0x006e
            android.view.View$OnClickListener r1 = r7.b__J_
            android.view.View r10 = com.razorpay.E$_6$.Q_$2$(r0, r10, r6, r3, r1)
            if (r10 == 0) goto L_0x007f
            r9.addView(r10)
            goto L_0x007f
        L_0x006e:
            int r4 = r10.size()
            if (r4 <= 0) goto L_0x007f
            android.view.View$OnClickListener r4 = r7.b__J_
            android.view.View r10 = com.razorpay.E$_6$.Q_$2$(r0, r10, r1, r3, r4)
            if (r10 == 0) goto L_0x007f
            r9.addView(r10)
        L_0x007f:
            r1 = r2
        L_0x0080:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r7.a_$P$ = r10
            java.util.ArrayList<java.lang.String> r10 = r7.B$$W$
            int r10 = r10.size()
            if (r10 == 0) goto L_0x00a0
            java.util.ArrayList<java.lang.String> r10 = r7.a_$P$
            java.util.ArrayList<java.lang.String> r2 = r7.B$$W$
            r10.addAll(r2)
            java.util.ArrayList<java.lang.String> r10 = r7.E$_j$
            if (r10 == 0) goto L_0x00af
            java.util.ArrayList<java.lang.String> r2 = r7.a_$P$
            r2.addAll(r10)
            goto L_0x00af
        L_0x00a0:
            java.util.ArrayList<java.lang.String> r10 = r7.E$_j$
            int r10 = r10.size()
            if (r10 == 0) goto L_0x00af
            java.util.ArrayList<java.lang.String> r10 = r7.a_$P$
            java.util.ArrayList<java.lang.String> r2 = r7.E$_j$
            r10.addAll(r2)
        L_0x00af:
            java.util.ArrayList<java.lang.String> r10 = r7.d__1_
            if (r10 == 0) goto L_0x00bc
            int r10 = r10.size()
            if (r10 == 0) goto L_0x00bc
            java.lang.String r10 = "OTHER APPS"
            goto L_0x00be
        L_0x00bc:
            java.lang.String r10 = ""
        L_0x00be:
            r5 = r10
            java.util.ArrayList<java.lang.String> r10 = r7.a_$P$
            int r10 = r10.size()
            if (r10 == 0) goto L_0x00e1
            java.util.ArrayList<java.lang.String> r10 = r7.a_$P$
            java.util.ArrayList r10 = r7.R$$r_(r10)
            int r2 = r10.size()
            if (r2 <= 0) goto L_0x00e1
            r2 = 0
            android.view.View$OnClickListener r4 = r7.b__J_
            r1 = r10
            android.view.View r10 = com.razorpay.E$_6$.R$$r_(r0, r1, r2, r3, r4, r5)
            if (r10 == 0) goto L_0x00e2
            r9.addView(r10)
            goto L_0x00e2
        L_0x00e1:
            r6 = r1
        L_0x00e2:
            if (r6 != 0) goto L_0x00e9
            android.view.View r8 = r7.a_$P$()
            return r8
        L_0x00e9:
            android.view.ViewTreeObserver r9 = r8.getViewTreeObserver()
            android.view.ViewTreeObserver$OnGlobalLayoutListener r10 = r7.D$_X_
            r9.addOnGlobalLayoutListener(r10)
            r7.R$$r_ = r8
            return r8
        L_0x00f5:
            android.view.View r8 = r7.a_$P$()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.razorpay.AppSelectorFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }
}
