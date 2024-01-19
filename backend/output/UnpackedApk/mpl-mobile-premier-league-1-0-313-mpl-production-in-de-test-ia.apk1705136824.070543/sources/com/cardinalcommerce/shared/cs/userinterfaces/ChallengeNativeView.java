package com.cardinalcommerce.shared.cs.userinterfaces;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.cardinalcommerce.cardinalmobilesdk.R$color;
import com.cardinalcommerce.cardinalmobilesdk.a.c.d;
import com.cardinalcommerce.shared.cs.c.c;
import com.cardinalcommerce.shared.cs.e.b;
import com.cardinalcommerce.shared.cs.e.f;
import com.cardinalcommerce.shared.cs.e.h;
import com.cardinalcommerce.shared.cs.f.m;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAButton;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAEditText;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAImageView;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCARadioGroup;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView;
import com.cardinalcommerce.shared.cs.userinterfaces.uielements.a;
import com.cardinalcommerce.shared.cs.utils.ThreeDSStrings;
import com.cardinalcommerce.shared.cs.utils.i;
import com.cardinalcommerce.shared.models.enums.ButtonType;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import com.inca.security.Proxy.iIiIiIiIii;
import java.util.ArrayList;
import java.util.List;

public class ChallengeNativeView extends AppCompatActivity implements c {
    public String A;
    public Context B;

    /* renamed from: a  reason: collision with root package name */
    public BroadcastReceiver f2188a = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("finish_activity")) {
                m a2 = m.a(ChallengeNativeView.this.getApplicationContext());
                com.cardinalcommerce.emvco.a.e.c cVar = a2.m;
                if (cVar != null) {
                    cVar.cancel(true);
                }
                d dVar = a2.n;
                if (dVar != null) {
                    dVar.cancel(true);
                }
                ChallengeNativeView.this.finish();
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public Toolbar f2189b;

    /* renamed from: c  reason: collision with root package name */
    public CCAImageView f2190c;

    /* renamed from: d  reason: collision with root package name */
    public CCAImageView f2191d;

    /* renamed from: e  reason: collision with root package name */
    public CCAImageView f2192e;

    /* renamed from: f  reason: collision with root package name */
    public CCATextView f2193f;
    public CCATextView g;
    public CCATextView h;
    public CCAEditText i;
    public CCAButton j;
    public CCAButton k;
    public CCATextView l;
    public CCATextView m;
    public CCATextView n;
    public CCATextView o;
    public CCATextView p;
    public a q;
    public ProgressBar r;
    public com.cardinalcommerce.shared.cs.e.a s;
    public b t;
    public UiCustomization u;
    public String v = "";
    public ArrayList<h> w;
    public CCARadioGroup x;
    public List<a> y;
    public boolean z = false;

    public static boolean d(ChallengeNativeView challengeNativeView) {
        return challengeNativeView.t.t.equalsIgnoreCase("2.2.0");
    }

    public static String h(ChallengeNativeView challengeNativeView) {
        StringBuilder sb = new StringBuilder();
        for (a next : challengeNativeView.y) {
            if (next.getCheckState() == 1) {
                if (!sb.toString().isEmpty()) {
                    sb.append(",");
                    sb.append(challengeNativeView.w.get(next.getCCAId()).f2107a);
                } else {
                    sb = new StringBuilder(challengeNativeView.w.get(next.getCCAId()).f2107a);
                }
            }
        }
        return sb.toString();
    }

    public static void l(ChallengeNativeView challengeNativeView) {
        if (challengeNativeView != null) {
            com.cardinalcommerce.shared.cs.e.c cVar = new com.cardinalcommerce.shared.cs.e.c();
            cVar.f2091a = ThreeDSStrings.CHALLENGE_CANCEL_CHAR;
            com.cardinalcommerce.shared.cs.e.a aVar = new com.cardinalcommerce.shared.cs.e.a(challengeNativeView.t, cVar);
            challengeNativeView.s = aVar;
            challengeNativeView.a(aVar);
            return;
        }
        throw null;
    }

    public void a() {
        runOnUiThread(new Runnable() {
            public void run() {
                ChallengeNativeView challengeNativeView = ChallengeNativeView.this;
                if (challengeNativeView.k != null && challengeNativeView.j()) {
                    ChallengeNativeView.this.k.setEnabled(true);
                }
                if (ChallengeNativeView.this.A.equals("01")) {
                    ChallengeNativeView.this.i.setFocusable(true);
                }
                ChallengeNativeView.this.r.setVisibility(8);
                ChallengeNativeView.this.j.setEnabled(true);
            }
        });
        finish();
    }

    public void a(final b bVar) {
        runOnUiThread(new Runnable() {
            public void run() {
                ChallengeNativeView.this.b(bVar);
                ChallengeNativeView challengeNativeView = ChallengeNativeView.this;
                challengeNativeView.runOnUiThread(new Runnable() {
                    public void run() {
                        ChallengeNativeView challengeNativeView = ChallengeNativeView.this;
                        if (challengeNativeView.k != null && challengeNativeView.j()) {
                            ChallengeNativeView.this.k.setEnabled(true);
                        }
                        if (ChallengeNativeView.this.A.equals("01")) {
                            ChallengeNativeView.this.i.setFocusable(true);
                        }
                        ChallengeNativeView.this.r.setVisibility(8);
                        ChallengeNativeView.this.j.setEnabled(true);
                    }
                });
            }
        });
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.cardinalcommerce.shared.cs.e.b r10) {
        /*
            r9 = this;
            java.lang.String r0 = r10.g
            int r1 = r0.hashCode()
            r2 = 2
            r3 = 0
            r4 = 1
            java.lang.String r5 = "04"
            switch(r1) {
                case 1537: goto L_0x002b;
                case 1538: goto L_0x0021;
                case 1539: goto L_0x0017;
                case 1540: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0035
        L_0x000f:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0035
            r0 = 3
            goto L_0x0036
        L_0x0017:
            java.lang.String r1 = "03"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
            r0 = 2
            goto L_0x0036
        L_0x0021:
            java.lang.String r1 = "02"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
            r0 = 1
            goto L_0x0036
        L_0x002b:
            java.lang.String r1 = "01"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
            r0 = 0
            goto L_0x0036
        L_0x0035:
            r0 = -1
        L_0x0036:
            if (r0 == 0) goto L_0x00d1
            if (r0 == r4) goto L_0x0090
            if (r0 == r2) goto L_0x003e
            goto L_0x00e7
        L_0x003e:
            java.util.ArrayList<com.cardinalcommerce.shared.cs.e.h> r0 = r10.n
            r9.w = r0
            int r1 = com.cardinalcommerce.cardinalmobilesdk.R$id.multiSelectgroup
            android.view.View r1 = r9.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r1.removeAllViews()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r9.y = r2
            r2 = 0
        L_0x0055:
            if (r2 >= r4) goto L_0x00e7
            r6 = 0
        L_0x0058:
            int r7 = r0.size()
            if (r6 >= r7) goto L_0x008d
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.a r7 = new com.cardinalcommerce.shared.cs.userinterfaces.uielements.a
            r7.<init>(r9)
            java.util.ArrayList<com.cardinalcommerce.shared.cs.e.h> r8 = r9.w
            java.lang.Object r8 = r8.get(r6)
            com.cardinalcommerce.shared.cs.e.h r8 = (com.cardinalcommerce.shared.cs.e.h) r8
            java.lang.String r8 = r8.f2108b
            r7.setCCAText(r8)
            r7.setCCAId(r6)
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r8 = r9.u
            if (r8 == 0) goto L_0x007a
            com.cardinalcommerce.shared.cs.utils.i.a(r7, r8, r9)
        L_0x007a:
            java.util.List<com.cardinalcommerce.shared.cs.userinterfaces.uielements.a> r8 = r9.y
            r8.add(r7)
            com.cardinalcommerce.shared.cs.userinterfaces.ChallengeNativeView$5 r8 = new com.cardinalcommerce.shared.cs.userinterfaces.ChallengeNativeView$5
            r8.<init>()
            r7.setCCAOnClickListener(r8)
            r1.addView(r7)
            int r6 = r6 + 1
            goto L_0x0058
        L_0x008d:
            int r2 = r2 + 1
            goto L_0x0055
        L_0x0090:
            java.util.ArrayList<com.cardinalcommerce.shared.cs.e.h> r0 = r10.n
            int r1 = com.cardinalcommerce.cardinalmobilesdk.R$id.selectradiogroup
            android.view.View r1 = r9.findViewById(r1)
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCARadioGroup r1 = (com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCARadioGroup) r1
            r9.x = r1
            r1.removeAllViews()
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCARadioGroup r1 = r9.x
            r1.setOrientation(r4)
            r9.w = r0
            r0 = 0
        L_0x00a7:
            java.util.ArrayList<com.cardinalcommerce.shared.cs.e.h> r1 = r9.w
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x00e7
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.b r1 = new com.cardinalcommerce.shared.cs.userinterfaces.uielements.b
            r1.<init>(r9)
            r1.setId(r0)
            java.util.ArrayList<com.cardinalcommerce.shared.cs.e.h> r2 = r9.w
            java.lang.Object r2 = r2.get(r0)
            com.cardinalcommerce.shared.cs.e.h r2 = (com.cardinalcommerce.shared.cs.e.h) r2
            java.lang.String r2 = r2.f2108b
            r1.setCCAText(r2)
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r2 = r9.u
            com.cardinalcommerce.shared.cs.utils.i.a(r1, r2, r9)
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCARadioGroup r2 = r9.x
            r2.a(r1)
            int r0 = r0 + 1
            goto L_0x00a7
        L_0x00d1:
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAEditText r0 = r9.i
            java.lang.String r1 = ""
            r0.setCCAText(r1)
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAEditText r0 = r9.i
            r0.setCCAFocusableInTouchMode(r4)
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAEditText r0 = r9.i
            com.cardinalcommerce.shared.cs.userinterfaces.ChallengeNativeView$4 r1 = new com.cardinalcommerce.shared.cs.userinterfaces.ChallengeNativeView$4
            r1.<init>()
            r0.setCCAOnFocusChangeListener(r1)
        L_0x00e7:
            com.cardinalcommerce.shared.cs.e.f r0 = r10.q
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAImageView r1 = r9.f2190c
            r9.a(r0, r1)
            com.cardinalcommerce.shared.cs.e.f r0 = r10.x
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAImageView r1 = r9.f2191d
            r9.a(r0, r1)
            java.lang.String r0 = r10.F
            if (r0 == 0) goto L_0x012f
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x012f
            int r0 = com.cardinalcommerce.cardinalmobilesdk.R$id.whiteListCheckboxHolder
            android.view.View r0 = r9.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r0.removeAllViews()
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.a r1 = new com.cardinalcommerce.shared.cs.userinterfaces.uielements.a
            r1.<init>(r9)
            r9.q = r1
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r2 = r9.u
            if (r2 == 0) goto L_0x0118
            com.cardinalcommerce.shared.cs.utils.i.a(r1, r2, r9)
        L_0x0118:
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.a r1 = r9.q
            java.lang.String r2 = r10.F
            r1.setCCAText(r2)
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.a r1 = r9.q
            com.cardinalcommerce.shared.cs.userinterfaces.ChallengeNativeView$5 r2 = new com.cardinalcommerce.shared.cs.userinterfaces.ChallengeNativeView$5
            r2.<init>()
            r1.setCCAOnClickListener(r2)
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.a r1 = r9.q
            r0.addView(r1)
            goto L_0x013d
        L_0x012f:
            int r0 = com.cardinalcommerce.cardinalmobilesdk.R$id.whiteListCheckboxHolder
            android.view.View r0 = r9.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r0.removeAllViews()
            r0.setPadding(r3, r3, r3, r3)
        L_0x013d:
            java.lang.String r0 = r9.A
            boolean r0 = r0.equals(r5)
            r1 = 8
            if (r0 != 0) goto L_0x0179
            java.lang.String r0 = r10.k
            if (r0 == 0) goto L_0x0159
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0159
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r0 = r9.h
            java.lang.String r2 = r10.k
            r0.setCCAText(r2)
            goto L_0x015e
        L_0x0159:
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r0 = r9.h
            r0.setVisibility(r1)
        L_0x015e:
            boolean r0 = r9.j()
            if (r0 == 0) goto L_0x0170
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAButton r0 = r9.k
            r0.setCCAVisibility(r3)
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAButton r0 = r9.k
            java.lang.String r2 = r10.y
            r0.setCCAText(r2)
        L_0x0170:
            java.lang.String r0 = r10.A
            if (r0 == 0) goto L_0x0179
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAButton r2 = r9.j
            r2.setCCAText(r0)
        L_0x0179:
            java.lang.String r0 = r10.w
            if (r0 == 0) goto L_0x018c
            java.lang.String r0 = r9.A
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x018c
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAButton r0 = r9.j
            java.lang.String r2 = r10.w
            r0.setCCAText(r2)
        L_0x018c:
            java.lang.String r0 = r10.j
            if (r0 == 0) goto L_0x0196
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r2 = r9.f2193f
            r2.setCCAText(r0)
            goto L_0x019b
        L_0x0196:
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r0 = r9.f2193f
            r0.setVisibility(r1)
        L_0x019b:
            java.lang.String r0 = r10.l
            r2 = 4
            if (r0 == 0) goto L_0x01a6
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r4 = r9.g
            r4.setCCAText(r0)
            goto L_0x01ab
        L_0x01a6:
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r0 = r9.g
            r0.setVisibility(r2)
        L_0x01ab:
            java.lang.String r0 = r10.m
            if (r0 == 0) goto L_0x01c4
            java.lang.String r4 = "Y"
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x01c4
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAImageView r0 = r9.f2192e
            int r1 = com.cardinalcommerce.cardinalmobilesdk.R$drawable.warning
            r0.setCCAImageResource(r1)
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAImageView r0 = r9.f2192e
            r0.setVisibility(r3)
            goto L_0x01c9
        L_0x01c4:
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCAImageView r0 = r9.f2192e
            r0.setVisibility(r1)
        L_0x01c9:
            java.lang.String r0 = r10.C
            if (r0 == 0) goto L_0x01ee
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x01ee
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r0 = r9.l
            java.lang.String r1 = r10.C
            r0.setCCAText(r1)
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r0 = r9.l
            int r1 = com.cardinalcommerce.cardinalmobilesdk.R$drawable.plus
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r3, r3, r1, r3)
            java.lang.String r0 = r10.D
            if (r0 == 0) goto L_0x01eb
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r1 = r9.m
            r1.setCCAText(r0)
            goto L_0x01f3
        L_0x01eb:
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r0 = r9.m
            goto L_0x01f0
        L_0x01ee:
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r0 = r9.l
        L_0x01f0:
            r0.setVisibility(r2)
        L_0x01f3:
            java.lang.String r0 = r10.o
            if (r0 == 0) goto L_0x021a
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x021a
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r0 = r9.n
            java.lang.String r1 = r10.o
            r0.setCCAText(r1)
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r0 = r9.n
            int r1 = com.cardinalcommerce.cardinalmobilesdk.R$drawable.plus
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r3, r3, r1, r3)
            java.lang.String r0 = r10.D
            if (r0 == 0) goto L_0x0217
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r0 = r9.o
            java.lang.String r10 = r10.p
            r0.setCCAText(r10)
            goto L_0x021f
        L_0x0217:
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r10 = r9.o
            goto L_0x021c
        L_0x021a:
            com.cardinalcommerce.shared.cs.userinterfaces.uielements.CCATextView r10 = r9.n
        L_0x021c:
            r10.setVisibility(r2)
        L_0x021f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.shared.cs.userinterfaces.ChallengeNativeView.b(com.cardinalcommerce.shared.cs.e.b):void");
    }

    public final void b(UiCustomization uiCustomization) {
        if (this.k == null) {
            return;
        }
        if (uiCustomization.getButtonCustomization(ButtonType.RESEND) == null) {
            this.k.setTextColor(getResources().getColor(R$color.blue));
        } else {
            i.a(this.k, uiCustomization.getButtonCustomization(ButtonType.RESEND), (Activity) this);
        }
    }

    public final boolean j() {
        return this.A.equals("01") && !this.t.y.equals("");
    }

    public void onBackPressed() {
        super.onBackPressed();
        com.cardinalcommerce.shared.cs.e.c cVar = new com.cardinalcommerce.shared.cs.e.c();
        cVar.f2091a = ThreeDSStrings.CHALLENGE_CANCEL_CHAR;
        com.cardinalcommerce.shared.cs.e.a aVar = new com.cardinalcommerce.shared.cs.e.a(this.t, cVar);
        this.s = aVar;
        a(aVar);
    }

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 483137116, bundle);
    }

    public void onDestroy() {
        iIiIiIiIii.IiiiIiiiII(this, 1302064428, new Object[0]);
    }

    public void onPause() {
        iIiIiIiIii.IiiiIiiiII(this, -1386932418, new Object[0]);
    }

    public void onResume() {
        iIiIiIiIii.IiiiIiiiII(this, -1194005656, new Object[0]);
    }

    public final void a(com.cardinalcommerce.shared.cs.e.a aVar) {
        runOnUiThread(new Runnable() {
            public void run() {
                ChallengeNativeView challengeNativeView = ChallengeNativeView.this;
                if (challengeNativeView.k != null && challengeNativeView.j()) {
                    ChallengeNativeView.this.k.setEnabled(false);
                }
                if (ChallengeNativeView.this.A.equals("01")) {
                    ChallengeNativeView.this.i.setFocusable(false);
                }
                ChallengeNativeView.this.j.setEnabled(false);
                ChallengeNativeView.this.r.setVisibility(0);
            }
        });
        m.a(getApplicationContext()).a(aVar, this, this.A);
    }

    public final void a(f fVar, CCAImageView cCAImageView) {
        if (fVar != null) {
            int i2 = getResources().getConfiguration().screenLayout & 15;
            String str = i2 != 1 ? (i2 == 3 || i2 == 4) ? fVar.f2106d : fVar.f2105c : fVar.f2104b;
            if (str == null) {
                str = fVar.f2105c;
                if (str == null) {
                    str = fVar.f2104b;
                    if (str == null) {
                        str = fVar.f2106d;
                    }
                }
            }
            if (str != null && str.trim().length() > 0) {
                new com.cardinalcommerce.shared.cs.g.a(cCAImageView, str).execute(new String[0]);
                return;
            }
            return;
        }
        cCAImageView.setVisibility(4);
    }
}
