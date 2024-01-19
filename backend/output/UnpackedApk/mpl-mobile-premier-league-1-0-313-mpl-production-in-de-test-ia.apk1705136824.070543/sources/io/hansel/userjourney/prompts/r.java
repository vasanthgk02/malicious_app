package io.hansel.userjourney.prompts;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.RatingCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.core.app.NotificationCompat.WearableExtender;
import androidx.core.content.ContextCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.mpl.androidapp.miniprofile.ct.C.PlaybackControl;
import com.netcore.android.SMTEventParamKeys;
import com.razorpay.AnalyticsConstants;
import io.hansel.R;
import io.hansel.core.HSLBuildConfig;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.json.CoreJSONException;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import io.hansel.core.module.IMessageBroker;
import io.hansel.core.utils.HSLUtils;
import io.hansel.userjourney.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdfparser.BaseParser;

public class r implements l0, h {
    public static HashSet<String> t0 = new HashSet<>();
    public static HashMap<String, String> u0 = new HashMap<>();
    public List<TextView> A = new ArrayList();
    public List<EditText> B = new ArrayList();
    public String C = null;
    public String D = null;
    public k E;
    public Set<String> F = new HashSet();
    public Set<String> G = new HashSet();
    public View H;
    public Handler I = new Handler(Looper.getMainLooper());
    public RelativeLayout J;
    public k0 K;
    public LayoutParams L;
    public String M;
    public Boolean N = null;
    public String O;
    public long P;
    public long Q;
    public c0 R;
    public CoreJSONObject S;
    public String T;
    public String U;
    public i V;
    public int W = 0;
    public int X;
    public int Y;
    public boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f5630a = (!HSLBuildConfig.isProdBuild());
    public boolean a0;

    /* renamed from: b  reason: collision with root package name */
    public int f5631b = HSLUtils.dpToPx(12);
    public boolean b0;

    /* renamed from: c  reason: collision with root package name */
    public int f5632c = HSLUtils.dpToPx(12);
    public q c0 = new q();

    /* renamed from: d  reason: collision with root package name */
    public io.hansel.segments.b f5633d;
    public m0 d0;

    /* renamed from: e  reason: collision with root package name */
    public io.hansel.segments.c f5634e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public Context f5635f;
    public boolean f0;
    public String g;
    public boolean g0;
    public int h;
    public Activity h0;
    public int i;
    public q0 i0;
    public int j;
    public final Runnable j0 = new h();
    public int k;
    public boolean k0 = false;
    public int l;
    public boolean l0;
    public int m;
    public Bitmap m0 = Bitmap.createBitmap(this.f5631b, this.f5632c, Config.ARGB_8888);
    public int n;
    public Bitmap n0 = Bitmap.createBitmap(this.f5631b, this.f5632c, Config.ARGB_8888);
    public int o;
    public io.hansel.userjourney.prompts.d.e o0;
    public int p;
    public io.hansel.userjourney.prompts.d.d p0;
    public int q;
    public io.hansel.userjourney.prompts.d.c q0;
    public int r = 0;
    public io.hansel.userjourney.prompts.d.a r0;
    public int s = 0;
    public OnGlobalLayoutListener s0 = new i();
    public boolean t = true;
    public boolean u = false;
    public boolean v = true;
    public HashMap<String, Object> w = new HashMap<>();
    public HashMap<String, String> x = new HashMap<>();
    public HashMap<String, Object> y = new HashMap<>();
    public HashMap<String, Object> z = new HashMap<>();

    public class a implements OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f5636a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView[] f5637b;

        public a(int i, ImageView[] imageViewArr) {
            this.f5636a = i;
            this.f5637b = imageViewArr;
        }

        public void onClick(View view) {
            try {
                r.this.F.remove("prompt_rating");
                r.this.g();
                int intValue = ((Integer) view.getTag()).intValue();
                int i = 0;
                while (true) {
                    boolean z = true;
                    if (i < this.f5636a) {
                        ImageView imageView = this.f5637b[i];
                        if (i > intValue) {
                            z = false;
                        }
                        imageView.setSelected(z);
                        i++;
                    } else {
                        HashMap d2 = r.u0;
                        StringBuilder sb = new StringBuilder();
                        int i2 = intValue + 1;
                        sb.append(i2);
                        sb.append("");
                        d2.put("prompt_rating", sb.toString());
                        HashMap d3 = r.this.w;
                        d3.put("prompt_rating", i2 + "");
                        HashMap e2 = r.this.y;
                        e2.put("Rating_Value", i2 + "");
                        r.this.G.add("prompt_rating,Rating_Value");
                        return;
                    }
                }
            } catch (Throwable th) {
                r.this.a(th, (String) RatingCompat.TAG);
            }
        }
    }

    public class b implements OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GradientDrawable f5639a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GradientDrawable f5640b;

        public b(GradientDrawable gradientDrawable, GradientDrawable gradientDrawable2) {
            this.f5639a = gradientDrawable;
            this.f5640b = gradientDrawable2;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            GradientDrawable gradientDrawable;
            if (z) {
                try {
                    r.u0.put("prompt_nps", compoundButton.getTag().toString());
                    r.this.w.put("prompt_nps", compoundButton.getTag());
                    r.this.y.put("NPS_Value", compoundButton.getTag());
                    r.this.G.add("prompt_nps,NPS_Value");
                    r.this.F.remove("prompt_nps");
                    r.this.g();
                    gradientDrawable = this.f5639a;
                } catch (Throwable th) {
                    r.this.a(th, (String) "NpsClick");
                    return;
                }
            } else {
                gradientDrawable = this.f5640b;
            }
            compoundButton.setBackground(gradientDrawable);
        }
    }

    public class c implements OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RadioButton[] f5642a;

        public c(RadioButton[] radioButtonArr) {
            this.f5642a = radioButtonArr;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            try {
                this.f5642a[i].setChecked(true);
                HashMap d2 = r.u0;
                d2.put("prompt_nps", i + "");
                HashMap d3 = r.this.w;
                d3.put("prompt_nps", i + "");
                HashMap e2 = r.this.y;
                e2.put("NPS_Value", i + "");
                r.this.G.add("prompt_nps,NPS_Value");
                r.this.F.remove("prompt_nps");
                r.this.g();
            } catch (Throwable th) {
                r.this.a(th, (String) PlaybackControl.PLAYBACK_CONTROL_SEEK);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public class d implements OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FrameLayout f5644a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f5645b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ImageView f5646c;

        public d(FrameLayout frameLayout, ImageView imageView, ImageView imageView2) {
            this.f5644a = frameLayout;
            this.f5645b = imageView;
            this.f5646c = imageView2;
        }

        public void onClick(View view) {
            ImageView imageView;
            if (!r.this.V.d() && r.this.V.c()) {
                if (r.this.W > 0) {
                    this.f5644a.setVisibility(0);
                    if (r.this.E.y() == d0.BOTTOM) {
                        imageView = this.f5645b;
                    } else if (r.this.E.y() == d0.TOP) {
                        imageView = this.f5646c;
                    }
                    imageView.setVisibility(0);
                }
                r.this.V.e();
                r.this.v();
                r.this.H.getViewTreeObserver().addOnGlobalLayoutListener(r.this.s0);
                r.this.H.requestLayout();
            }
        }
    }

    public class e extends ViewOutlineProvider {
        public e() {
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), (float) r.this.n);
        }
    }

    public class f implements OnKeyListener {
        public f() {
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            try {
                HSLLogger.d("Prompt KeyEvent Detected:     ");
                if (keyEvent.getAction() == 0 && i == 4) {
                    HSLLogger.d("Prompt props onBackPressed Detected:     ");
                    r.this.p();
                    return true;
                }
            } catch (Throwable th) {
                r.this.a(th, (String) "KeyList");
            }
            return false;
        }
    }

    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5650a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f5651b;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|16) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002b */
        static {
            /*
                io.hansel.userjourney.prompts.p[] r0 = io.hansel.userjourney.prompts.p.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5651b = r0
                r1 = 3
                r2 = 1
                io.hansel.userjourney.prompts.p r3 = io.hansel.userjourney.prompts.p.SPOTLIGHT_CIRCLE     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r3 = f5651b     // Catch:{ NoSuchFieldError -> 0x0017 }
                io.hansel.userjourney.prompts.p r4 = io.hansel.userjourney.prompts.p.SPOTLIGHT_RECTANGLE     // Catch:{ NoSuchFieldError -> 0x0017 }
                r4 = 4
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                io.hansel.userjourney.prompts.d0[] r3 = io.hansel.userjourney.prompts.d0.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f5650a = r3
                io.hansel.userjourney.prompts.d0 r4 = io.hansel.userjourney.prompts.d0.TOP     // Catch:{ NoSuchFieldError -> 0x0025 }
                r4 = 0
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0025 }
            L_0x0025:
                int[] r3 = f5650a     // Catch:{ NoSuchFieldError -> 0x002b }
                io.hansel.userjourney.prompts.d0 r4 = io.hansel.userjourney.prompts.d0.BOTTOM     // Catch:{ NoSuchFieldError -> 0x002b }
                r3[r2] = r0     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                int[] r2 = f5650a     // Catch:{ NoSuchFieldError -> 0x0031 }
                io.hansel.userjourney.prompts.d0 r3 = io.hansel.userjourney.prompts.d0.AUTO     // Catch:{ NoSuchFieldError -> 0x0031 }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x0031 }
            L_0x0031:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r.g.<clinit>():void");
        }
    }

    public class h implements Runnable {
        public h() {
        }

        public void run() {
            try {
                r rVar = r.this;
                rVar.a((String) "prompt_selfDestruct,Nudge_autodismiss", rVar.C, true);
            } catch (Throwable th) {
                r.this.a(th, (String) "SelfDestruct");
            }
        }
    }

    public class i implements OnGlobalLayoutListener {

        public class a implements OnGlobalLayoutListener {
            public a() {
            }

            public void onGlobalLayout() {
                try {
                    r.this.J.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    r rVar = r.this;
                    rVar.b(rVar.S, x.UPDATE);
                    r.this.q();
                } catch (Throwable th) {
                    r.this.a(th, (String) "Global2");
                }
            }
        }

        public i() {
        }

        public void onGlobalLayout() {
            try {
                r.this.H.getViewTreeObserver().removeOnGlobalLayoutListener(r.this.s0);
                r.this.r();
                FrameLayout frameLayout = (FrameLayout) r.this.H.findViewById(R.id.p_shadow_container);
                if (r.this.E.F() == l.HOTSPOT && frameLayout.getVisibility() == 8) {
                    r.this.q();
                } else {
                    r.this.J.getViewTreeObserver().addOnGlobalLayoutListener(new a());
                }
            } catch (Throwable th) {
                r.this.a(th, (String) "Global1");
            }
        }
    }

    public class j implements OnGlobalLayoutListener {
        public j() {
        }

        public void onGlobalLayout() {
            r.this.J.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            r.this.J.setVisibility(0);
        }
    }

    public class k implements OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f5656a;

        public k(boolean z) {
            this.f5656a = z;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (r.this.e0 || !this.f5656a) {
                    return !r.this.e0;
                }
                boolean b2 = r.this.u;
                r.this.u = true;
                if (!b2) {
                    r.this.a((String) "prompt_backdrop,Nudge_backdrop_clicked", (String) null, true);
                }
                return true;
            } catch (Throwable th) {
                r.this.a(th, (String) "Touch");
                return false;
            }
        }
    }

    public class l implements OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f5658a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5659b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5660c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5661d;

        public l(boolean z, String str, String str2, String str3) {
            this.f5658a = z;
            this.f5659b = str;
            this.f5660c = str2;
            this.f5661d = str3;
        }

        public void onClick(View view) {
            try {
                int i = 0;
                if (!this.f5658a) {
                    ArrayList arrayList = new ArrayList(r.this.G);
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String[] split = ((String) arrayList.get(i2)).split(",");
                        r.this.w.remove(split[0]);
                        r.this.y.remove(split[1]);
                    }
                } else if (!r.this.u()) {
                    ArrayList arrayList2 = new ArrayList(r.t0);
                    int size2 = arrayList2.size();
                    StringBuilder sb = new StringBuilder();
                    while (i < size2) {
                        sb.append((String) arrayList2.get(i));
                        sb.append(i == size2 + -1 ? "" : ",");
                        i++;
                    }
                    if (size2 > 0) {
                        r.this.w.put("prompt_multichoice", sb.toString());
                        r.this.y.put("Multichoice_value", sb.toString());
                    }
                } else {
                    return;
                }
                HSLLogger.d("triggerAction");
                r.this.a(this.f5659b, (String) "link");
                r.this.a(this.f5660c, (String) "signal");
                r.this.a((String) view.getTag(), this.f5658a ? AnalyticsConstants.SUBMIT : this.f5661d);
            } catch (Throwable th) {
                r.this.a(th, (String) "BtnClick");
            }
        }
    }

    public class m implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditText f5663a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f5664b;

        public m(EditText editText, TextView textView) {
            this.f5663a = editText;
            this.f5664b = textView;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            try {
                String str = (String) this.f5663a.getTag();
                this.f5664b.setText("");
                this.f5664b.setVisibility(8);
                if (TextUtils.isEmpty(charSequence)) {
                    String[] split = str.split(",");
                    r.this.w.remove(split[0]);
                    r.this.y.remove(split[1]);
                    r.this.G.remove(str);
                    if (r.this.v) {
                        r.this.F.add(str);
                    }
                } else {
                    String[] split2 = str.split(",");
                    r.this.w.put(split2[0], charSequence.toString());
                    r.this.y.put(split2[1], charSequence.toString());
                    r.this.G.add(str);
                    r.this.F.remove(str);
                }
                r.this.g();
            } catch (Exception e2) {
                HSLLogger.printStackTrace(e2);
            }
        }
    }

    public class n implements OnEditorActionListener {
        public n() {
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return i == 6 || i == 5;
        }
    }

    public class o implements OnCheckedChangeListener {
        public o() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            try {
                String str = (String) compoundButton.getTag();
                if (z) {
                    r.t0.add(str);
                } else {
                    r.t0.remove(str);
                }
                if (r.t0.isEmpty()) {
                    r.this.F.add("prompt_multichoice");
                } else {
                    r.this.F.remove("prompt_multichoice");
                }
                r.this.g();
            } catch (Throwable th) {
                r.this.a(th, (String) "Check");
            }
        }
    }

    public class p implements OnCheckedChangeListener {
        public p() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                try {
                    r.this.F.remove("prompt_multichoice");
                    r.this.g();
                    r.u0.put("prompt_multichoice", compoundButton.getTag().toString());
                    r.this.w.put("prompt_multichoice", compoundButton.getTag());
                    r.this.y.put("Multichoice_value", compoundButton.getTag());
                    r.this.G.add("prompt_multichoice,Multichoice_value");
                } catch (Throwable th) {
                    r.this.a(th, (String) "Radio");
                }
            }
        }
    }

    public r(CoreJSONObject coreJSONObject, IMessageBroker iMessageBroker, q0 q0Var, String str) {
        try {
            this.O = Long.toString(System.currentTimeMillis());
            this.M = str;
            this.S = coreJSONObject;
            this.R = null;
            this.t = true;
            n();
            this.i0 = q0Var;
        } catch (Throwable th) {
            a(th, (String) "CREATE");
        }
    }

    private int a(int i2, int i3, int i4) {
        int i5 = i2 - i3;
        return i5 >= i4 * 2 ? i4 : i5 / 2;
    }

    private int a(int i2, d0 d0Var, int i3) {
        int i4;
        if (this.E.F() == l.SPOTLIGHT) {
            i3 = HSLUtils.dpToPx(10);
            if (i().C() == p.SPOTLIGHT_CIRCLE) {
                i2 = Math.max(i().i(), i2);
            }
            int i5 = i2 / 2;
            if (d0Var == d0.TOP) {
                i3 = HSLUtils.dpToPx(2) + i5 + i3 + this.X;
                HSLLogger.d("margin issue yOffset is " + i3);
                return i3;
            }
            i4 = i5 + this.X;
        } else if (this.E.F() == l.HOTSPOT) {
            i4 = HSLUtils.dpToPx(this.E.r().optInt(t.f5693a, 16)) / 2;
        } else {
            if (this.E.F() != l.TOOLTIP) {
                l F2 = this.E.F();
                l lVar = l.TAG;
                i3 = 0;
            }
            HSLLogger.d("margin issue yOffset is " + i3);
            return i3;
        }
        i3 += i4;
        HSLLogger.d("margin issue yOffset is " + i3);
        return i3;
    }

    private StateListDrawable a(String str, int i2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Resources resources = this.f5635f.getResources();
        stateListDrawable.addState(new int[]{16842913}, io.hansel.userjourney.n.a(resources, e.a(str + "_f"), i2));
        stateListDrawable.addState(new int[0], io.hansel.userjourney.n.a(this.f5635f.getResources(), e.a(str), i2));
        return stateListDrawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r8.equals(org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes.TR) == false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ab, code lost:
        r9.topMargin = r12;
        r10.topMargin = 0;
        r8 = io.hansel.userjourney.prompts.c0.TOP;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c4, code lost:
        r8 = io.hansel.userjourney.prompts.c0.CENTER;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00d9, code lost:
        r9.bottomMargin = r12;
        r10.bottomMargin = 0;
        r8 = io.hansel.userjourney.prompts.c0.BOTTOM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00df, code lost:
        r7.R = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00e1, code lost:
        return r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.widget.FrameLayout.LayoutParams a(java.lang.String r8, android.widget.FrameLayout.LayoutParams r9, android.widget.FrameLayout.LayoutParams r10, int r11, boolean r12) {
        /*
            r7 = this;
            r0 = 8
            r1 = 0
            if (r12 == 0) goto L_0x0007
            r12 = 0
            goto L_0x000b
        L_0x0007:
            int r12 = io.hansel.core.utils.HSLUtils.dpToPx(r0)
        L_0x000b:
            r8.hashCode()
            r2 = -1
            int r3 = r8.hashCode()
            r4 = 2113(0x841, float:2.961E-42)
            r5 = 5
            r6 = 1
            if (r3 == r4) goto L_0x0091
            r4 = 2122(0x84a, float:2.974E-42)
            if (r3 == r4) goto L_0x0086
            r4 = 2128(0x850, float:2.982E-42)
            if (r3 == r4) goto L_0x007b
            r4 = 2454(0x996, float:3.439E-42)
            if (r3 == r4) goto L_0x0070
            r4 = 2463(0x99f, float:3.451E-42)
            if (r3 == r4) goto L_0x0065
            r4 = 2469(0x9a5, float:3.46E-42)
            if (r3 == r4) goto L_0x005a
            r4 = 2671(0xa6f, float:3.743E-42)
            if (r3 == r4) goto L_0x004f
            r4 = 2680(0xa78, float:3.755E-42)
            if (r3 == r4) goto L_0x0044
            r4 = 2686(0xa7e, float:3.764E-42)
            if (r3 == r4) goto L_0x003b
            goto L_0x0099
        L_0x003b:
            java.lang.String r3 = "TR"
            boolean r8 = r8.equals(r3)
            if (r8 != 0) goto L_0x009c
            goto L_0x0099
        L_0x0044:
            java.lang.String r0 = "TL"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x004d
            goto L_0x0099
        L_0x004d:
            r0 = 7
            goto L_0x009c
        L_0x004f:
            java.lang.String r0 = "TC"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0058
            goto L_0x0099
        L_0x0058:
            r0 = 6
            goto L_0x009c
        L_0x005a:
            java.lang.String r0 = "MR"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0063
            goto L_0x0099
        L_0x0063:
            r0 = 5
            goto L_0x009c
        L_0x0065:
            java.lang.String r0 = "ML"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x006e
            goto L_0x0099
        L_0x006e:
            r0 = 4
            goto L_0x009c
        L_0x0070:
            java.lang.String r0 = "MC"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0079
            goto L_0x0099
        L_0x0079:
            r0 = 3
            goto L_0x009c
        L_0x007b:
            java.lang.String r0 = "BR"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0084
            goto L_0x0099
        L_0x0084:
            r0 = 2
            goto L_0x009c
        L_0x0086:
            java.lang.String r0 = "BL"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x008f
            goto L_0x0099
        L_0x008f:
            r0 = 1
            goto L_0x009c
        L_0x0091:
            java.lang.String r0 = "BC"
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x009b
        L_0x0099:
            r0 = -1
            goto L_0x009c
        L_0x009b:
            r0 = 0
        L_0x009c:
            switch(r0) {
                case 0: goto L_0x00d5;
                case 1: goto L_0x00ce;
                case 2: goto L_0x00c7;
                case 3: goto L_0x00c0;
                case 4: goto L_0x00b9;
                case 5: goto L_0x00b2;
                case 6: goto L_0x00a9;
                case 7: goto L_0x00a6;
                case 8: goto L_0x00a1;
                default: goto L_0x009f;
            }
        L_0x009f:
            r8 = 0
            return r8
        L_0x00a1:
            r9.gravity = r5
            r9.rightMargin = r11
            goto L_0x00ab
        L_0x00a6:
            r9.leftMargin = r11
            goto L_0x00ab
        L_0x00a9:
            r9.gravity = r6
        L_0x00ab:
            r9.topMargin = r12
            r10.topMargin = r1
            io.hansel.userjourney.prompts.c0 r8 = io.hansel.userjourney.prompts.c0.TOP
            goto L_0x00df
        L_0x00b2:
            r8 = 21
            r9.gravity = r8
            r9.rightMargin = r11
            goto L_0x00c4
        L_0x00b9:
            r8 = 16
            r9.gravity = r8
            r9.leftMargin = r11
            goto L_0x00c4
        L_0x00c0:
            r8 = 17
            r9.gravity = r8
        L_0x00c4:
            io.hansel.userjourney.prompts.c0 r8 = io.hansel.userjourney.prompts.c0.CENTER
            goto L_0x00df
        L_0x00c7:
            r8 = 85
            r9.gravity = r8
            r9.rightMargin = r11
            goto L_0x00d9
        L_0x00ce:
            r8 = 80
            r9.gravity = r8
            r9.leftMargin = r11
            goto L_0x00d9
        L_0x00d5:
            r8 = 81
            r9.gravity = r8
        L_0x00d9:
            r9.bottomMargin = r12
            r10.bottomMargin = r1
            io.hansel.userjourney.prompts.c0 r8 = io.hansel.userjourney.prompts.c0.BOTTOM
        L_0x00df:
            r7.R = r8
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r.a(java.lang.String, android.widget.FrameLayout$LayoutParams, android.widget.FrameLayout$LayoutParams, int, boolean):android.widget.FrameLayout$LayoutParams");
    }

    private d0 a(a aVar) {
        return (aVar == a.TOP_LEFT || aVar == a.TOP_RIGHT) ? d0.BOTTOM : d0.TOP;
    }

    private String a(View view, String str) {
        String str2 = "";
        if (view.getVisibility() == 0) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (!(width == 0 || height == 0)) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                if (view instanceof TextView) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("  , TextSize:   ");
                    outline73.append(HSLUtils.pxToSp(((TextView) view).getTextSize()));
                    str2 = outline73.toString();
                }
                StringBuilder outline80 = GeneratedOutlineSupport.outline80("\n\n", str, " width: ");
                outline80.append(HSLUtils.pxToDp((float) width));
                outline80.append(" , height: ");
                outline80.append(HSLUtils.pxToDp((float) height));
                outline80.append(str2);
                outline80.append("  , Distance (LTRB) ");
                outline80.append(HSLUtils.pxToDp((float) (view.getPaddingLeft() + marginLayoutParams.leftMargin)));
                outline80.append(" , ");
                outline80.append(HSLUtils.pxToDp((float) (view.getPaddingTop() + marginLayoutParams.topMargin)));
                outline80.append(" , ");
                outline80.append(HSLUtils.pxToDp((float) (view.getPaddingRight() + marginLayoutParams.rightMargin)));
                outline80.append(" , ");
                outline80.append(HSLUtils.pxToDp((float) (view.getPaddingBottom() + marginLayoutParams.bottomMargin)));
                return outline80.toString();
            }
        }
        return str2;
    }

    private void a(int i2, int i3, int i4, int i5) {
        int i6 = (i4 / 2) + i2;
        int i7 = (i5 / 2) + i3;
        int i8 = g.f5651b[this.E.C().ordinal()];
        if (i8 == 1) {
            int a2 = io.hansel.userjourney.n.a(i4, i5, HSLUtils.dpToPx(10), true);
            m0 m0Var = new m0(this.f5635f, i0.CIRCLE, (RelativeLayout) this.H.findViewById(R.id.rippleContainer), a2, a2);
            this.d0 = m0Var;
            m0.a(i6, i7, (RelativeLayout) this.H.findViewById(R.id.rippleContainer), a2);
        } else if (i8 == 2) {
            int a3 = io.hansel.userjourney.n.a(i4, i5, HSLUtils.dpToPx(10), false);
            int a4 = io.hansel.userjourney.n.a(i4, HSLUtils.dpToPx(10));
            m0 m0Var2 = new m0(this.f5635f, i0.RECTANGLE, (RelativeLayout) this.H.findViewById(R.id.rippleContainer), a4, a3);
            this.d0 = m0Var2;
            m0.a(i6, i7, a4, a3, (RelativeLayout) this.H.findViewById(R.id.rippleContainer));
        }
        this.d0.b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.widget.FrameLayout.LayoutParams r19, int r20, int r21, io.hansel.core.json.CoreJSONObject r22, android.widget.FrameLayout r23, io.hansel.userjourney.prompts.x r24) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r23
            r3 = r24
            android.view.View r4 = r0.H
            int r5 = io.hansel.R.id.iv_arrow_top
            android.view.View r4 = r4.findViewById(r5)
            r7 = r4
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            android.view.View r4 = r0.H
            int r5 = io.hansel.R.id.iv_arrow_bottom
            android.view.View r4 = r4.findViewById(r5)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.view.View r5 = r0.H
            int r6 = io.hansel.R.id.iv_hotspot_top
            android.view.View r5 = r5.findViewById(r6)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            android.view.View r6 = r0.H
            int r8 = io.hansel.R.id.iv_hotspot_bottom
            android.view.View r6 = r6.findViewById(r8)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            io.hansel.userjourney.prompts.i r8 = r0.V
            if (r8 != 0) goto L_0x003e
            io.hansel.userjourney.prompts.i r8 = new io.hansel.userjourney.prompts.i
            r9 = r22
            r8.<init>(r9)
            r0.V = r8
        L_0x003e:
            io.hansel.userjourney.prompts.r$d r8 = new io.hansel.userjourney.prompts.r$d
            r8.<init>(r2, r7, r4)
            io.hansel.userjourney.prompts.k r9 = r0.E
            io.hansel.userjourney.prompts.l r9 = r9.F()
            io.hansel.userjourney.prompts.l r10 = io.hansel.userjourney.prompts.l.HOTSPOT
            if (r9 != r10) goto L_0x008f
            io.hansel.userjourney.prompts.k r9 = r0.E
            io.hansel.core.json.CoreJSONObject r9 = r9.r()
            if (r9 == 0) goto L_0x008f
            io.hansel.userjourney.prompts.k r9 = r0.E
            io.hansel.core.json.CoreJSONObject r9 = r9.r()
            int r11 = r0.l
            java.lang.String r12 = "color"
            int r9 = io.hansel.userjourney.n.a(r9, r12, r11)
            io.hansel.userjourney.prompts.k r11 = r0.E
            io.hansel.core.json.CoreJSONObject r11 = r11.r()
            java.lang.String r12 = "style"
            java.lang.String r11 = r11.optString(r12)
            io.hansel.userjourney.prompts.k r12 = r0.E
            java.lang.String r11 = io.hansel.userjourney.prompts.h0.a(r11, r12)
            android.content.Context r12 = r0.f5635f
            android.content.res.Resources r12 = r12.getResources()
            int r11 = io.hansel.userjourney.prompts.e.a(r11)
            android.graphics.drawable.Drawable r9 = io.hansel.userjourney.n.a(r12, r11, r9)
            io.hansel.userjourney.prompts.k r11 = r0.E
            r0.a(r5, r9, r11, r3)
            io.hansel.userjourney.prompts.k r11 = r0.E
            r0.a(r6, r9, r11, r3)
            goto L_0x0090
        L_0x008f:
            r9 = 0
        L_0x0090:
            r11 = 2
            int r12 = io.hansel.core.utils.HSLUtils.dpToPx(r11)
            android.view.ViewGroup$LayoutParams r13 = r7.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r13 = (android.widget.RelativeLayout.LayoutParams) r13
            io.hansel.userjourney.prompts.k r14 = r0.E
            int r14 = r14.s()
            r13.leftMargin = r14
            r14 = r20
            int r15 = -r14
            int r11 = r15 - r12
            r13.bottomMargin = r11
            r7.setLayoutParams(r13)
            android.view.ViewGroup$LayoutParams r11 = r4.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r11 = (android.widget.RelativeLayout.LayoutParams) r11
            io.hansel.userjourney.prompts.k r13 = r0.E
            int r13 = r13.s()
            r11.leftMargin = r13
            r13 = 2
            int r12 = r12 * 2
            int r15 = r15 - r12
            r11.topMargin = r15
            r4.setLayoutParams(r11)
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            io.hansel.userjourney.prompts.k r13 = r0.E
            io.hansel.userjourney.prompts.l r13 = r13.F()
            r15 = 8
            if (r13 != r10) goto L_0x00f0
            io.hansel.userjourney.prompts.i r13 = r0.V
            boolean r13 = r13.d()
            if (r13 != 0) goto L_0x00f0
            io.hansel.userjourney.prompts.i r13 = r0.V
            boolean r13 = r13.b()
            if (r13 == 0) goto L_0x00ed
            r13 = 0
            r2.setVisibility(r13)
            goto L_0x00f0
        L_0x00ed:
            r2.setVisibility(r15)
        L_0x00f0:
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.d0 r2 = r2.y()
            io.hansel.userjourney.prompts.d0 r13 = io.hansel.userjourney.prompts.d0.BOTTOM
            r16 = 12
            r17 = 10
            if (r2 != r13) goto L_0x01c1
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.l r2 = r2.F()
            if (r2 != r10) goto L_0x0127
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.core.json.CoreJSONObject r2 = r2.r()
            java.lang.String r13 = io.hansel.userjourney.prompts.t.f5693a
            r15 = 16
            int r2 = r2.optInt(r13, r15)
            io.hansel.userjourney.prompts.k r13 = r0.E
            int r13 = r13.x()
            int r15 = io.hansel.core.utils.HSLUtils.dpToPx(r16)
            int r13 = r13 - r15
            int r2 = io.hansel.core.utils.HSLUtils.dpToPx(r2)
            int r13 = r13 - r2
        L_0x0124:
            r1.topMargin = r13
            goto L_0x015d
        L_0x0127:
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.l r2 = r2.F()
            io.hansel.userjourney.prompts.l r13 = io.hansel.userjourney.prompts.l.TOOLTIP
            if (r2 != r13) goto L_0x013f
            io.hansel.userjourney.prompts.k r2 = r0.E
            int r2 = r2.x()
            int r13 = io.hansel.core.utils.HSLUtils.dpToPx(r16)
            int r2 = r2 - r13
            r1.topMargin = r2
            goto L_0x015d
        L_0x013f:
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.l r2 = r2.F()
            io.hansel.userjourney.prompts.l r13 = io.hansel.userjourney.prompts.l.SPOTLIGHT
            if (r2 != r13) goto L_0x015d
            int r2 = io.hansel.core.utils.HSLUtils.dpToPx(r17)
            io.hansel.userjourney.prompts.k r13 = r0.E
            int r13 = r13.x()
            int r15 = r0.X
            int r13 = r13 - r15
            int r13 = r13 + r2
            boolean r15 = r0.a0
            if (r15 != 0) goto L_0x0124
            int r13 = r13 + r2
            goto L_0x0124
        L_0x015d:
            if (r9 != 0) goto L_0x0165
            r1 = 8
            r5.setVisibility(r1)
            goto L_0x017c
        L_0x0165:
            r1 = 0
            r5.setVisibility(r1)
            io.hansel.userjourney.prompts.i r1 = r0.V
            boolean r1 = r1.d()
            if (r1 != 0) goto L_0x017c
            io.hansel.userjourney.prompts.i r1 = r0.V
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x017c
            r5.setOnClickListener(r8)
        L_0x017c:
            int r1 = r0.W
            if (r1 > 0) goto L_0x0188
            io.hansel.userjourney.prompts.x r1 = io.hansel.userjourney.prompts.x.INIT
            if (r3 != r1) goto L_0x0185
            goto L_0x0188
        L_0x0185:
            r2 = 8
            goto L_0x01ba
        L_0x0188:
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.l r1 = r1.F()
            if (r1 != r10) goto L_0x01a1
            io.hansel.userjourney.prompts.i r1 = r0.V
            boolean r1 = r1.b()
            if (r1 != 0) goto L_0x01b5
            io.hansel.userjourney.prompts.i r1 = r0.V
            boolean r1 = r1.d()
            if (r1 == 0) goto L_0x0185
            goto L_0x01b5
        L_0x01a1:
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.l r1 = r1.F()
            io.hansel.userjourney.prompts.l r2 = io.hansel.userjourney.prompts.l.SPOTLIGHT
            if (r1 == r2) goto L_0x01b5
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.l r1 = r1.F()
            io.hansel.userjourney.prompts.l r2 = io.hansel.userjourney.prompts.l.TOOLTIP
            if (r1 != r2) goto L_0x0185
        L_0x01b5:
            r1 = 0
            r7.setVisibility(r1)
            goto L_0x0185
        L_0x01ba:
            r4.setVisibility(r2)
            r6.setVisibility(r2)
            goto L_0x0224
        L_0x01c1:
            r1 = 0
            r2 = 8
            if (r9 != 0) goto L_0x01ca
            r6.setVisibility(r2)
            goto L_0x01e0
        L_0x01ca:
            r6.setVisibility(r1)
            io.hansel.userjourney.prompts.i r1 = r0.V
            boolean r1 = r1.d()
            if (r1 != 0) goto L_0x01e0
            io.hansel.userjourney.prompts.i r1 = r0.V
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x01e0
            r6.setOnClickListener(r8)
        L_0x01e0:
            int r1 = r0.W
            if (r1 > 0) goto L_0x01ec
            io.hansel.userjourney.prompts.x r1 = io.hansel.userjourney.prompts.x.INIT
            if (r3 != r1) goto L_0x01e9
            goto L_0x01ec
        L_0x01e9:
            r1 = 8
            goto L_0x021e
        L_0x01ec:
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.l r1 = r1.F()
            if (r1 != r10) goto L_0x0205
            io.hansel.userjourney.prompts.i r1 = r0.V
            boolean r1 = r1.b()
            if (r1 != 0) goto L_0x0219
            io.hansel.userjourney.prompts.i r1 = r0.V
            boolean r1 = r1.d()
            if (r1 == 0) goto L_0x01e9
            goto L_0x0219
        L_0x0205:
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.l r1 = r1.F()
            io.hansel.userjourney.prompts.l r2 = io.hansel.userjourney.prompts.l.SPOTLIGHT
            if (r1 == r2) goto L_0x0219
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.l r1 = r1.F()
            io.hansel.userjourney.prompts.l r2 = io.hansel.userjourney.prompts.l.TOOLTIP
            if (r1 != r2) goto L_0x01e9
        L_0x0219:
            r1 = 0
            r4.setVisibility(r1)
            goto L_0x01e9
        L_0x021e:
            r7.setVisibility(r1)
            r5.setVisibility(r1)
        L_0x0224:
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.l r1 = r1.F()
            io.hansel.userjourney.prompts.l r2 = io.hansel.userjourney.prompts.l.SPOTLIGHT
            if (r1 != r2) goto L_0x02de
            boolean r1 = r0.a0
            if (r1 == 0) goto L_0x02d5
            int r1 = r0.Y
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "SPOTLIGHT_ARROW_COLOR"
            r12.put(r2, r1)
            java.lang.String r1 = r0.g
            java.lang.String r2 = "SPOTLIGHT_POINTER_TYPE"
            r12.put(r2, r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r16)
            java.lang.String r2 = "SPOTLIGHT_ARROW_CIRCLE_SCALE"
            r12.put(r2, r1)
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.p r1 = r1.C()
            io.hansel.userjourney.prompts.p r2 = io.hansel.userjourney.prompts.p.SPOTLIGHT_CIRCLE
            java.lang.String r3 = "ARROW_BOTTOM_PADDING"
            java.lang.String r5 = "ARROW_TOP_PADDING"
            java.lang.String r6 = "ARROW_BODY_WIDTH"
            r8 = 3
            java.lang.String r9 = "ARROW_BODY_HEIGHT"
            java.lang.String r10 = "ARROW_TIP_HEIGHT"
            java.lang.String r13 = "ARROW_BASE_WIDTH"
            if (r1 != r2) goto L_0x027d
            int r1 = io.hansel.core.utils.HSLUtils.dpToPx(r16)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.put(r13, r1)
            int r1 = io.hansel.core.utils.HSLUtils.dpToPx(r17)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.put(r10, r1)
            r1 = 30
            goto L_0x0297
        L_0x027d:
            int r1 = io.hansel.core.utils.HSLUtils.dpToPx(r16)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.put(r13, r1)
            r1 = 15
            int r1 = io.hansel.core.utils.HSLUtils.dpToPx(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.put(r10, r1)
            r1 = 40
        L_0x0297:
            int r1 = io.hansel.core.utils.HSLUtils.dpToPx(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.put(r9, r1)
            int r1 = io.hansel.core.utils.HSLUtils.dpToPx(r8)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.put(r6, r1)
            int r1 = io.hansel.core.utils.HSLUtils.dpToPx(r17)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.put(r5, r1)
            int r1 = io.hansel.core.utils.HSLUtils.dpToPx(r17)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11.put(r3, r1)
            io.hansel.userjourney.prompts.n r1 = new io.hansel.userjourney.prompts.n
            android.content.Context r2 = r0.f5635f
            android.content.res.Resources r2 = r2.getResources()
            r1.<init>(r2, r11, r12)
            r1.b(r7)
            r1.a(r4)
            goto L_0x0313
        L_0x02d5:
            r1 = 8
            r7.setVisibility(r1)
            r4.setVisibility(r1)
            goto L_0x0313
        L_0x02de:
            int r1 = r7.getVisibility()
            if (r1 != 0) goto L_0x02f8
            io.hansel.userjourney.prompts.q r5 = r0.c0
            android.content.Context r1 = r0.f5635f
            android.content.res.Resources r6 = r1.getResources()
            int r8 = r0.l
            android.graphics.Bitmap r12 = r0.m0
            r9 = 1
            r10 = r20
            r11 = r21
            r5.a(r6, r7, r8, r9, r10, r11, r12)
        L_0x02f8:
            int r1 = r4.getVisibility()
            if (r1 != 0) goto L_0x0313
            io.hansel.userjourney.prompts.q r8 = r0.c0
            android.content.Context r1 = r0.f5635f
            android.content.res.Resources r9 = r1.getResources()
            int r11 = r0.l
            android.graphics.Bitmap r15 = r0.n0
            r12 = 0
            r10 = r4
            r13 = r20
            r14 = r21
            r8.a(r9, r10, r11, r12, r13, r14, r15)
        L_0x0313:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r.a(android.widget.FrameLayout$LayoutParams, int, int, io.hansel.core.json.CoreJSONObject, android.widget.FrameLayout, io.hansel.userjourney.prompts.x):void");
    }

    private void a(ImageView imageView, Drawable drawable, k kVar, x xVar) {
        LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
        layoutParams.leftMargin = kVar.t();
        imageView.setLayoutParams(layoutParams);
        if (xVar == x.INIT) {
            int optInt = kVar.r().optInt(t.f5693a, 16);
            q.b(imageView, HSLUtils.dpToPx(optInt));
            q.a((View) imageView, HSLUtils.dpToPx(optInt));
            q.a((View) imageView, (float) kVar.r().optDouble(t.f5694b, 1.0d));
            imageView.setImageDrawable(drawable);
            if (kVar.C() != p.HOTSPOT_QUESTION && kVar.C() != p.HOTSPOT_STAR) {
                io.hansel.userjourney.n.a(imageView);
            }
        }
    }

    private void a(CoreJSONObject coreJSONObject, View view, String str) {
        String str2;
        boolean equals = AnalyticsConstants.SUBMIT.equals(str);
        CoreJSONObject coreJSONObject2 = new CoreJSONObject();
        String str3 = null;
        try {
            CoreJSONArray jSONArray = coreJSONObject.getJSONObject(WearableExtender.KEY_ACTIONS).getJSONArray("onClick");
            int length = jSONArray == null ? 0 : jSONArray.length();
            str2 = null;
            int i2 = 0;
            while (i2 < length) {
                try {
                    CoreJSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString("type");
                    if ("link".equals(string)) {
                        str3 = jSONObject.getString("url");
                        coreJSONObject2 = jSONObject;
                    }
                    if ("signal".equals(string)) {
                        str2 = jSONObject.getString("action");
                    }
                    i2++;
                } catch (CoreJSONException e2) {
                    e = e2;
                    HSLLogger.printStackTrace(e);
                    l lVar = new l(equals, f0.a(this.f5635f, str3, coreJSONObject2, this.f5634e), str2, str);
                    view.setOnClickListener(lVar);
                }
            }
        } catch (CoreJSONException e3) {
            e = e3;
            str2 = null;
            HSLLogger.printStackTrace(e);
            l lVar2 = new l(equals, f0.a(this.f5635f, str3, coreJSONObject2, this.f5634e), str2, str);
            view.setOnClickListener(lVar2);
        }
        l lVar22 = new l(equals, f0.a(this.f5635f, str3, coreJSONObject2, this.f5634e), str2, str);
        view.setOnClickListener(lVar22);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.Boolean r11, float[] r12, android.widget.FrameLayout r13) {
        /*
            r10 = this;
            io.hansel.core.json.CoreJSONObject r0 = r10.S
            java.lang.String r1 = "prompt"
            io.hansel.core.json.CoreJSONObject r0 = r0.optJSONObject(r1)
            java.lang.String r2 = "props"
            io.hansel.core.json.CoreJSONObject r0 = r0.optJSONObject(r2)
            java.lang.String r3 = "bgFill"
            io.hansel.core.json.CoreJSONObject r6 = r0.optJSONObject(r3)
            io.hansel.core.json.CoreJSONObject r0 = r10.S
            io.hansel.core.json.CoreJSONObject r0 = r0.optJSONObject(r1)
            io.hansel.core.json.CoreJSONObject r0 = r0.optJSONObject(r2)
            java.lang.String r1 = "spacing"
            java.lang.String r9 = r0.optString(r1)
            android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
            r0.<init>()
            java.lang.String r1 = r10.U
            r1.hashCode()
            int r2 = r1.hashCode()
            r3 = 89650992(0x557f730, float:1.01546526E-35)
            r4 = 2
            r5 = 1
            r7 = 0
            if (r2 == r3) goto L_0x005d
            r3 = 100313435(0x5faa95b, float:2.3572098E-35)
            if (r2 == r3) goto L_0x0052
            r3 = 109618859(0x688a6ab, float:5.140241E-35)
            if (r2 == r3) goto L_0x0046
            goto L_0x0065
        L_0x0046:
            java.lang.String r2 = "solid"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0050
            goto L_0x0065
        L_0x0050:
            r1 = 2
            goto L_0x0068
        L_0x0052:
            java.lang.String r2 = "image"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x005b
            goto L_0x0065
        L_0x005b:
            r1 = 1
            goto L_0x0068
        L_0x005d:
            java.lang.String r2 = "gradient"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0067
        L_0x0065:
            r1 = -1
            goto L_0x0068
        L_0x0067:
            r1 = 0
        L_0x0068:
            if (r1 == 0) goto L_0x008d
            if (r1 == r5) goto L_0x0081
            if (r1 == r4) goto L_0x006f
            goto L_0x00cf
        L_0x006f:
            r0.setShape(r7)
            int r1 = r10.l
            r0.setColor(r1)
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x00cc
            r0.setCornerRadii(r12)
            goto L_0x00cc
        L_0x0081:
            io.hansel.userjourney.prompts.d.d r4 = r10.p0
            android.view.View r5 = r10.H
            int r7 = r10.j
            io.hansel.userjourney.prompts.v r8 = io.hansel.userjourney.prompts.v.bgImage
            r4.a(r5, r6, r7, r8, r9)
            goto L_0x00cf
        L_0x008d:
            java.lang.String r11 = "gradientType"
            java.lang.String r11 = r6.optString(r11)
            int r12 = r10.l
            java.lang.String r1 = "gradientColor1"
            int r12 = io.hansel.userjourney.n.b(r6, r1, r12)
            r10.p = r12
            int r12 = r10.l
            java.lang.String r1 = "gradientColor2"
            int r12 = io.hansel.userjourney.n.b(r6, r1, r12)
            r10.q = r12
            java.lang.String r12 = "linear"
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x00cf
            r0.setGradientType(r7)
            int[] r11 = new int[r4]
            int r12 = r10.p
            r11[r7] = r12
            int r12 = r10.q
            r11[r5] = r12
            r0.setColors(r11)
            java.lang.String r11 = "gradientAngle"
            int r11 = r6.optInt(r11)
            android.graphics.drawable.GradientDrawable$Orientation r11 = r10.b(r11)
            r0.setOrientation(r11)
        L_0x00cc:
            r13.setBackground(r0)
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r.a(java.lang.Boolean, float[], android.widget.FrameLayout):void");
    }

    private void a(String str) {
        HSLLogger.w(str, LogGroup.PT);
        a((String) null, (String) null, true);
    }

    /* access modifiers changed from: private */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            int r0 = r8.hashCode()
            r1 = 3
            r2 = 2
            java.lang.String r3 = "submit"
            java.lang.String r4 = "cancel"
            r5 = 1
            switch(r0) {
                case -1367724422: goto L_0x0037;
                case -902467928: goto L_0x002c;
                case -891535336: goto L_0x0024;
                case -80148009: goto L_0x001a;
                case 3321850: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x003f
        L_0x0010:
            java.lang.String r0 = "link"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 0
            goto L_0x0040
        L_0x001a:
            java.lang.String r0 = "generic"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 4
            goto L_0x0040
        L_0x0024:
            boolean r0 = r8.equals(r3)
            if (r0 == 0) goto L_0x003f
            r0 = 2
            goto L_0x0040
        L_0x002c:
            java.lang.String r0 = "signal"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x003f
            r0 = 1
            goto L_0x0040
        L_0x0037:
            boolean r0 = r8.equals(r4)
            if (r0 == 0) goto L_0x003f
            r0 = 3
            goto L_0x0040
        L_0x003f:
            r0 = -1
        L_0x0040:
            if (r0 == 0) goto L_0x005d
            if (r0 == r5) goto L_0x0054
            if (r0 == r2) goto L_0x0050
            if (r0 == r1) goto L_0x004c
            r6.a(r7, r8, r5)
            goto L_0x0068
        L_0x004c:
            r6.a(r7, r4, r5)
            goto L_0x0068
        L_0x0050:
            r6.a(r7, r3, r5)
            goto L_0x0068
        L_0x0054:
            boolean r8 = io.hansel.core.utils.HSLUtils.isSet(r7)
            if (r8 == 0) goto L_0x0068
            r6.D = r7
            goto L_0x0068
        L_0x005d:
            boolean r8 = io.hansel.core.utils.HSLUtils.isSet(r7)
            if (r8 == 0) goto L_0x0068
            android.content.Context r8 = r6.f5635f
            io.hansel.userjourney.n.a(r8, r7)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r.a(java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void a(Throwable th, String str) {
        HSLLogger.printStackTrace(th);
        HSLLogger.w("onPromptError-> " + str + "  " + th.getMessage(), LogGroup.PT);
        a((String) null, (String) null, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x011a, code lost:
        if (r3 != 3) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x012d, code lost:
        if (r3 == io.hansel.userjourney.prompts.d0.TOP) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0136, code lost:
        if (r3 == io.hansel.userjourney.prompts.d0.BOTTOM) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01dd, code lost:
        if (((r12 + r1) + r10) > r0.E.A().b()) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0210, code lost:
        if (r7 >= 0) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0216, code lost:
        if (r7 >= 0) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0240, code lost:
        if (r9 < r12) goto L_0x0250;
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r26, io.hansel.userjourney.prompts.x r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            io.hansel.userjourney.prompts.o0 r2 = io.hansel.userjourney.prompts.o0.TOP_CENTER
            io.hansel.userjourney.prompts.n0 r3 = io.hansel.userjourney.prompts.n0.ALIGN_WITH_VIEW
            io.hansel.userjourney.prompts.k r4 = r0.E
            io.hansel.userjourney.prompts.l r4 = r4.F()
            io.hansel.userjourney.prompts.l r5 = io.hansel.userjourney.prompts.l.TAG
            if (r4 != r5) goto L_0x001f
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.o0 r2 = r2.E()
            io.hansel.userjourney.prompts.k r4 = r0.E
            io.hansel.userjourney.prompts.n0 r4 = r4.D()
            goto L_0x0020
        L_0x001f:
            r4 = r3
        L_0x0020:
            r6 = 12
            int r7 = io.hansel.core.utils.HSLUtils.dpToPx(r6)
            int r8 = io.hansel.core.utils.HSLUtils.dpToPx(r6)
            r9 = 2
            int r10 = io.hansel.core.utils.HSLUtils.dpToPx(r9)
            r11 = 8
            int r11 = io.hansel.core.utils.HSLUtils.dpToPx(r11)
            io.hansel.userjourney.prompts.k r12 = r0.E
            io.hansel.userjourney.prompts.l r12 = r12.F()
            io.hansel.userjourney.prompts.l r13 = io.hansel.userjourney.prompts.l.SPOTLIGHT
            if (r12 != r13) goto L_0x006b
            io.hansel.userjourney.prompts.k r12 = r0.E
            io.hansel.userjourney.prompts.p r12 = r12.C()
            io.hansel.userjourney.prompts.p r14 = io.hansel.userjourney.prompts.p.SPOTLIGHT_CIRCLE
            r15 = 10
            if (r12 != r14) goto L_0x0052
            int r12 = io.hansel.core.utils.HSLUtils.dpToPx(r15)
            r14 = 30
            goto L_0x005a
        L_0x0052:
            r12 = 15
            int r12 = io.hansel.core.utils.HSLUtils.dpToPx(r12)
            r14 = 40
        L_0x005a:
            int r14 = io.hansel.core.utils.HSLUtils.dpToPx(r14)
            int r14 = r14 + r12
            int r12 = io.hansel.core.utils.HSLUtils.dpToPx(r15)
            int r12 = r12 + r14
            int r14 = io.hansel.core.utils.HSLUtils.dpToPx(r15)
            int r14 = r14 + r12
            r0.X = r14
        L_0x006b:
            io.hansel.userjourney.prompts.k r12 = r0.E
            int r12 = r12.j()
            io.hansel.userjourney.prompts.k r14 = r0.E
            r14.k()
            io.hansel.userjourney.prompts.k r14 = r0.E
            int r14 = r14.i()
            io.hansel.userjourney.prompts.k r15 = r0.E
            int r15 = r15.h()
            r16 = 0
            io.hansel.userjourney.prompts.k r6 = r0.E
            int r6 = r6.d()
            io.hansel.userjourney.prompts.k r9 = r0.E
            int r9 = r9.e()
            r17 = r13
            io.hansel.userjourney.prompts.k r13 = r0.E
            io.hansel.userjourney.prompts.a r13 = r13.b()
            r18 = r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r19 = r7
            java.lang.String r7 = "The anchor point position quadrant is "
            r10.append(r7)
            r10.append(r13)
            java.lang.String r7 = r10.toString()
            io.hansel.core.logger.HSLLogger.d(r7)
            io.hansel.userjourney.prompts.k r7 = r0.E
            io.hansel.userjourney.prompts.l r7 = r7.F()
            if (r7 != r5) goto L_0x00e1
            io.hansel.userjourney.prompts.o0 r7 = io.hansel.userjourney.prompts.o0.BOTTOM_CENTER
            if (r2 == r7) goto L_0x00d8
            io.hansel.userjourney.prompts.o0 r7 = io.hansel.userjourney.prompts.o0.BOTTOM_LEFT
            if (r2 == r7) goto L_0x00d8
            io.hansel.userjourney.prompts.o0 r7 = io.hansel.userjourney.prompts.o0.BOTTOM_RIGHT
            if (r2 != r7) goto L_0x00c5
            goto L_0x00d8
        L_0x00c5:
            io.hansel.userjourney.prompts.o0 r7 = io.hansel.userjourney.prompts.o0.MIDDLE_CENTER
            if (r2 == r7) goto L_0x00d5
            io.hansel.userjourney.prompts.o0 r7 = io.hansel.userjourney.prompts.o0.MIDDLE_LEFT
            if (r2 == r7) goto L_0x00d5
            io.hansel.userjourney.prompts.o0 r7 = io.hansel.userjourney.prompts.o0.MIDDLE_RIGHT
            if (r2 != r7) goto L_0x00d2
            goto L_0x00d5
        L_0x00d2:
            io.hansel.userjourney.prompts.d0 r16 = io.hansel.userjourney.prompts.d0.TOP
            goto L_0x00da
        L_0x00d5:
            io.hansel.userjourney.prompts.d0 r16 = io.hansel.userjourney.prompts.d0.AUTO
            goto L_0x00da
        L_0x00d8:
            io.hansel.userjourney.prompts.d0 r16 = io.hansel.userjourney.prompts.d0.BOTTOM
        L_0x00da:
            r21 = r3
            r22 = r4
            r20 = r6
            goto L_0x0144
        L_0x00e1:
            android.view.View r7 = r0.H
            int r10 = io.hansel.R.id.prompt_pnc
            android.view.View r7 = r7.findViewById(r10)
            int r7 = r7.getHeight()
            io.hansel.userjourney.prompts.k r10 = r0.E
            int r10 = r10.h()
            r20 = r6
            io.hansel.userjourney.prompts.k r6 = r0.E
            int r6 = r6.k()
            r21 = r3
            io.hansel.userjourney.prompts.x r3 = io.hansel.userjourney.prompts.x.UPDATE
            r22 = r4
            r4 = r27
            if (r4 != r3) goto L_0x0140
            int[] r3 = io.hansel.userjourney.prompts.r.g.f5650a
            io.hansel.userjourney.prompts.k r4 = r0.E
            io.hansel.userjourney.prompts.d0 r4 = r4.G()
            int r4 = r4.ordinal()
            r3 = r3[r4]
            r4 = 1
            if (r3 == r4) goto L_0x0130
            r4 = 2
            if (r3 == r4) goto L_0x011d
            r4 = 3
            if (r3 == r4) goto L_0x0140
            goto L_0x0144
        L_0x011d:
            io.hansel.userjourney.prompts.k r3 = r0.E
            io.hansel.userjourney.prompts.j0 r3 = r3.A()
            int r3 = r3.c()
            io.hansel.userjourney.prompts.d0 r3 = r0.b(r9, r7, r3)
            io.hansel.userjourney.prompts.d0 r4 = io.hansel.userjourney.prompts.d0.TOP
            if (r3 != r4) goto L_0x0146
            goto L_0x0138
        L_0x0130:
            io.hansel.userjourney.prompts.d0 r3 = r0.a(r9, r7)
            io.hansel.userjourney.prompts.d0 r4 = io.hansel.userjourney.prompts.d0.BOTTOM
            if (r3 != r4) goto L_0x0146
        L_0x0138:
            r16 = r3
            int r10 = r10 + r6
            int r9 = r0.c(r6, r10, r9)
            goto L_0x0144
        L_0x0140:
            io.hansel.userjourney.prompts.d0 r16 = r0.a(r13)
        L_0x0144:
            r3 = r16
        L_0x0146:
            int r4 = r0.a(r15, r3, r8)
            io.hansel.userjourney.prompts.k r6 = r0.E
            r6.h(r4)
            io.hansel.userjourney.prompts.d0 r6 = io.hansel.userjourney.prompts.d0.BOTTOM
            if (r3 != r6) goto L_0x0155
            int r4 = r4 + r9
            goto L_0x0157
        L_0x0155:
            int r4 = r9 - r4
        L_0x0157:
            int r6 = r1 / 2
            io.hansel.userjourney.prompts.k r7 = r0.E
            io.hansel.userjourney.prompts.j0 r7 = r7.A()
            int r7 = r7.b()
            int r7 = r0.a(r7, r1, r11)
            int r8 = r14 / 2
            int r8 = r8 + r12
            io.hansel.userjourney.prompts.k r10 = r0.E
            io.hansel.userjourney.prompts.l r10 = r10.F()
            if (r10 != r5) goto L_0x021d
            r10 = 0
            int r10 = io.hansel.core.utils.HSLUtils.dpToPx(r10)
            io.hansel.userjourney.prompts.k r15 = r0.E
            io.hansel.userjourney.prompts.j0 r15 = r15.A()
            int r15 = r15.b()
            int r15 = r15 - r8
            r16 = r14
            double r13 = (double) r15
            r15 = r3
            r23 = r4
            double r3 = (double) r8
            r24 = r15
            io.hansel.userjourney.prompts.o0 r15 = io.hansel.userjourney.prompts.o0.TOP_LEFT
            if (r2 == r15) goto L_0x01fe
            io.hansel.userjourney.prompts.o0 r15 = io.hansel.userjourney.prompts.o0.MIDDLE_LEFT
            if (r2 == r15) goto L_0x01fe
            io.hansel.userjourney.prompts.o0 r15 = io.hansel.userjourney.prompts.o0.BOTTOM_LEFT
            if (r2 != r15) goto L_0x0199
            goto L_0x01fe
        L_0x0199:
            io.hansel.userjourney.prompts.o0 r15 = io.hansel.userjourney.prompts.o0.TOP_RIGHT
            if (r2 == r15) goto L_0x01bd
            io.hansel.userjourney.prompts.o0 r15 = io.hansel.userjourney.prompts.o0.BOTTOM_RIGHT
            if (r2 == r15) goto L_0x01bd
            io.hansel.userjourney.prompts.o0 r15 = io.hansel.userjourney.prompts.o0.MIDDLE_RIGHT
            if (r2 != r15) goto L_0x01a6
            goto L_0x01bd
        L_0x01a6:
            r2 = r9
            double r9 = (double) r6
            int r12 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r12 < 0) goto L_0x01b3
            int r12 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r12 < 0) goto L_0x01b3
            int r7 = r8 - r6
            goto L_0x0207
        L_0x01b3:
            int r6 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r6 >= 0) goto L_0x01b9
            goto L_0x0218
        L_0x01b9:
            r8 = r20
            goto L_0x0243
        L_0x01bd:
            r2 = r9
            io.hansel.userjourney.prompts.n0 r3 = io.hansel.userjourney.prompts.n0.INSIDE_VIEW
            r4 = r22
            if (r4 != r3) goto L_0x01ca
            int r12 = r12 + r16
            int r12 = r12 - r1
            int r7 = r12 - r10
            goto L_0x0207
        L_0x01ca:
            io.hansel.userjourney.prompts.n0 r3 = io.hansel.userjourney.prompts.n0.OUTSIDE_VIEW
            int r12 = r12 + r16
            if (r4 != r3) goto L_0x01e0
            int r3 = r12 + r1
            int r3 = r3 + r10
            io.hansel.userjourney.prompts.k r4 = r0.E
            io.hansel.userjourney.prompts.j0 r4 = r4.A()
            int r4 = r4.b()
            if (r3 <= r4) goto L_0x0205
            goto L_0x01ee
        L_0x01e0:
            int r3 = r12 + r6
            io.hansel.userjourney.prompts.k r4 = r0.E
            io.hansel.userjourney.prompts.j0 r4 = r4.A()
            int r4 = r4.b()
            if (r3 <= r4) goto L_0x01fb
        L_0x01ee:
            io.hansel.userjourney.prompts.k r3 = r0.E
            io.hansel.userjourney.prompts.j0 r3 = r3.A()
            int r3 = r3.b()
            int r7 = r3 - r1
            goto L_0x0207
        L_0x01fb:
            int r7 = r12 - r6
            goto L_0x0207
        L_0x01fe:
            r2 = r9
            r4 = r22
            io.hansel.userjourney.prompts.n0 r3 = io.hansel.userjourney.prompts.n0.INSIDE_VIEW
            if (r4 != r3) goto L_0x020a
        L_0x0205:
            int r7 = r12 + r10
        L_0x0207:
            r8 = r20
            goto L_0x0250
        L_0x020a:
            r3 = r21
            if (r4 != r3) goto L_0x0213
            int r7 = r12 - r6
            if (r7 < 0) goto L_0x0219
            goto L_0x0218
        L_0x0213:
            int r12 = r12 - r1
            int r7 = r12 - r10
            if (r7 < 0) goto L_0x0219
        L_0x0218:
            goto L_0x0207
        L_0x0219:
            r8 = r20
            r7 = 0
            goto L_0x0250
        L_0x021d:
            r24 = r3
            r23 = r4
            r2 = r9
            io.hansel.userjourney.prompts.k r3 = r0.E
            io.hansel.userjourney.prompts.j0 r3 = r3.A()
            int r3 = r3.b()
            int r3 = r3 - r20
            double r3 = (double) r3
            r8 = r20
            double r9 = (double) r8
            double r12 = (double) r6
            int r14 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x023e
            int r14 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x023e
            int r7 = r8 - r6
            goto L_0x0250
        L_0x023e:
            int r3 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r3 >= 0) goto L_0x0243
            goto L_0x0250
        L_0x0243:
            io.hansel.userjourney.prompts.k r3 = r0.E
            io.hansel.userjourney.prompts.j0 r3 = r3.A()
            int r3 = r3.b()
            int r3 = r3 - r1
            int r7 = r3 - r7
        L_0x0250:
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.j0 r1 = r1.A()
            int r1 = r1.a()
            int r1 = r1 - r11
            r4 = r23
            if (r4 >= r11) goto L_0x0261
            r4 = r11
            goto L_0x0264
        L_0x0261:
            if (r4 <= r1) goto L_0x0264
            r4 = r1
        L_0x0264:
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.core.json.CoreJSONObject r1 = r1.r()
            java.lang.String r3 = io.hansel.userjourney.prompts.t.f5693a
            r6 = 16
            int r1 = r1.optInt(r3, r6)
            int r1 = io.hansel.core.utils.HSLUtils.dpToPx(r1)
            int r1 = r19 - r1
            r3 = 2
            int r1 = r1 / r3
            int r10 = r18 + r11
            int r6 = r19 / 2
            int r10 = r10 + r6
            io.hansel.userjourney.prompts.k r3 = r0.E
            io.hansel.userjourney.prompts.l r3 = r3.F()
            if (r3 != r5) goto L_0x0288
            r10 = 0
        L_0x0288:
            io.hansel.userjourney.prompts.k r3 = r0.E
            io.hansel.userjourney.prompts.j0 r3 = r3.A()
            int r3 = r3.b()
            int r3 = r3 - r10
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r9 = "The value of anchorPointX is "
            r5.append(r9)
            r5.append(r8)
            java.lang.String r9 = " and the value of anchorPointY is "
            r5.append(r9)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            io.hansel.core.logger.HSLLogger.d(r2)
            if (r8 >= r10) goto L_0x02b8
            java.lang.String r1 = "Failed in getPromptPosition method because anchorPointX is less then extra Margin."
            io.hansel.core.logger.HSLLogger.d(r1)
            r2 = 0
            return r2
        L_0x02b8:
            r2 = 0
            if (r8 <= r3) goto L_0x02c1
            java.lang.String r1 = "Failed in getPromptPosition method because anchorPointX is greater then max arrow X."
            io.hansel.core.logger.HSLLogger.d(r1)
            return r2
        L_0x02c1:
            int r2 = r8 - r6
            int r2 = r2 - r7
            io.hansel.userjourney.prompts.k r3 = r0.E
            io.hansel.userjourney.prompts.l r3 = r3.F()
            r5 = r17
            if (r3 != r5) goto L_0x02e1
            io.hansel.userjourney.prompts.k r2 = r0.E
            r2.C()
            io.hansel.userjourney.prompts.p r2 = io.hansel.userjourney.prompts.p.SPOTLIGHT_CIRCLE
            int r2 = r0.j
            r3 = 2
            int r2 = r2 / r3
            r9 = 12
            int r9 = io.hansel.core.utils.HSLUtils.dpToPx(r9)
            int r9 = r9 / r3
            int r2 = r2 - r9
        L_0x02e1:
            io.hansel.userjourney.prompts.k r3 = r0.E
            r9 = r24
            r3.a(r9)
            io.hansel.userjourney.prompts.k r3 = r0.E
            r3.d(r2)
            io.hansel.userjourney.prompts.k r3 = r0.E
            int r2 = r2 + r1
            r3.e(r2)
            io.hansel.userjourney.prompts.k r1 = r0.E
            r1.f(r7)
            io.hansel.userjourney.prompts.k r1 = r0.E
            r1.g(r4)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "margin issue promptOriginY at 2032 is "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            io.hansel.core.logger.HSLLogger.d(r1)
            io.hansel.userjourney.prompts.u r1 = io.hansel.userjourney.prompts.u.NONE
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.l r2 = r2.F()
            io.hansel.userjourney.prompts.l r3 = io.hansel.userjourney.prompts.l.TOOLTIP
            if (r2 == r3) goto L_0x0325
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.l r2 = r2.F()
            if (r2 != r5) goto L_0x0347
        L_0x0325:
            int r2 = r8 - r7
            int r3 = r0.j
            int r3 = r3 + r7
            int r3 = r3 - r8
            int r4 = java.lang.Math.min(r2, r3)
            int r5 = r0.n
            int r6 = r6 + r5
            if (r4 >= r6) goto L_0x0347
            io.hansel.userjourney.prompts.d0 r1 = io.hansel.userjourney.prompts.d0.TOP
            if (r2 >= r3) goto L_0x0340
            if (r9 != r1) goto L_0x033d
            io.hansel.userjourney.prompts.u r1 = io.hansel.userjourney.prompts.u.BOTTOM_LEFT
            goto L_0x0347
        L_0x033d:
            io.hansel.userjourney.prompts.u r1 = io.hansel.userjourney.prompts.u.TOP_LEFT
            goto L_0x0347
        L_0x0340:
            if (r9 != r1) goto L_0x0345
            io.hansel.userjourney.prompts.u r1 = io.hansel.userjourney.prompts.u.BOTTOM_RIGHT
            goto L_0x0347
        L_0x0345:
            io.hansel.userjourney.prompts.u r1 = io.hansel.userjourney.prompts.u.TOP_RIGHT
        L_0x0347:
            io.hansel.userjourney.prompts.k r2 = r0.E
            r2.a(r1)
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r.a(int, io.hansel.userjourney.prompts.x):boolean");
    }

    private boolean a(View view, CoreJSONObject coreJSONObject) {
        int i2;
        int i3;
        int i4;
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("props");
        String optString = optJSONObject.optString("selectionType");
        if (!"checkbox".equals(optString) && !SMTEventParamKeys.SMT_RADIO.equals(optString)) {
            return false;
        }
        boolean equals = "checkbox".equals(optString);
        CoreJSONArray coreJSONArray = new CoreJSONArray(optJSONObject.getString("options"));
        int length = coreJSONArray.length();
        String[] split = optJSONObject.optString("optionSpacing").split(CMap.SPACE);
        int dpToPx = HSLUtils.dpToPx(8);
        if (split.length == 4) {
            int dpToPx2 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split[0]));
            int dpToPx3 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split[1]));
            int dpToPx4 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split[2]));
            i4 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split[3]));
            int i5 = dpToPx3;
            i3 = dpToPx2;
            dpToPx = dpToPx4;
            i2 = i5;
        } else {
            i3 = dpToPx;
            i4 = 0;
            i2 = 0;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = i4;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = i2;
        layoutParams.bottomMargin = dpToPx;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.leftMargin = i4;
        layoutParams2.topMargin = i3;
        layoutParams2.rightMargin = i2;
        layoutParams2.bottomMargin = dpToPx;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = i4;
        layoutParams3.topMargin = i3;
        layoutParams3.rightMargin = i2;
        layoutParams3.bottomMargin = 0;
        int c2 = io.hansel.userjourney.n.c("#808080");
        int dpToPx5 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(optJSONObject.optString("labelGap", "16px")));
        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.multichoice);
        int i6 = 0;
        boolean z2 = false;
        while (i6 < length) {
            int i7 = i6;
            LinearLayout.LayoutParams layoutParams4 = layoutParams3;
            LinearLayout.LayoutParams layoutParams5 = layoutParams2;
            z2 = a(radioGroup, optJSONObject, coreJSONArray, i6, c2, equals, dpToPx5, i6 == 0 ? layoutParams : i6 == length + -1 ? layoutParams3 : layoutParams2) || z2;
            i6 = i7 + 1;
            layoutParams3 = layoutParams4;
            layoutParams2 = layoutParams5;
        }
        if (!z2) {
            return false;
        }
        b0.a().a(optJSONObject, radioGroup, 0, HSLUtils.dpToPx(24), 0, 0);
        return true;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.view.View r19, io.hansel.core.json.CoreJSONObject r20, io.hansel.userjourney.prompts.y r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r21
            java.lang.String r3 = "props"
            r4 = r20
            io.hansel.core.json.CoreJSONObject r3 = r4.optJSONObject(r3)
            io.hansel.userjourney.prompts.y r4 = io.hansel.userjourney.prompts.y.input1
            r11 = 8
            r12 = 0
            if (r2 != r4) goto L_0x0033
            int r2 = io.hansel.R.id.input1
            android.view.View r2 = r1.findViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            int r4 = io.hansel.R.id.input_err1
            android.view.View r4 = r1.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r5 = "prompt_input1,Input_text1"
            r2.setTag(r5)
            r5 = 24
            int r5 = io.hansel.core.utils.HSLUtils.dpToPx(r5)
        L_0x0030:
            r13 = r4
            r14 = r5
            goto L_0x0051
        L_0x0033:
            io.hansel.userjourney.prompts.y r4 = io.hansel.userjourney.prompts.y.input2
            if (r2 != r4) goto L_0x015e
            int r2 = io.hansel.R.id.input2
            android.view.View r2 = r1.findViewById(r2)
            android.widget.EditText r2 = (android.widget.EditText) r2
            int r4 = io.hansel.R.id.input_err2
            android.view.View r4 = r1.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r5 = "prompt_input2,Input_text2"
            r2.setTag(r5)
            int r5 = io.hansel.core.utils.HSLUtils.dpToPx(r11)
            goto L_0x0030
        L_0x0051:
            io.hansel.userjourney.prompts.k0 r4 = new io.hansel.userjourney.prompts.k0
            android.app.Activity r5 = r0.h0
            r4.<init>(r5, r0, r2)
            r0.K = r4
            android.view.ViewTreeObserver r1 = r19.getViewTreeObserver()
            io.hansel.userjourney.prompts.k0 r4 = r0.K
            r1.addOnGlobalLayoutListener(r4)
            r1 = 1094713344(0x41400000, float:12.0)
            r13.setTextSize(r1)
            java.util.List<android.widget.EditText> r1 = r0.B
            r1.add(r2)
            java.lang.String r1 = "#808080"
            int r1 = io.hansel.userjourney.n.c(r1)
            java.lang.String r4 = "hint"
            java.lang.String r15 = r3.optString(r4)
            java.lang.String r4 = "hintColor"
            int r10 = io.hansel.userjourney.n.a(r3, r4, r1)
            android.content.Context r4 = r0.f5635f
            io.hansel.userjourney.prompts.p0 r8 = io.hansel.userjourney.prompts.p0.TEXT
            io.hansel.segments.c r9 = r0.f5634e
            r7 = 0
            r16 = 0
            r5 = r2
            r6 = r3
            r17 = r9
            r9 = r16
            r11 = r10
            r10 = r17
            boolean r4 = io.hansel.userjourney.prompts.f0.a(r4, r5, r6, r7, r8, r9, r10)
            if (r4 != 0) goto L_0x0098
            return r12
        L_0x0098:
            java.lang.String r4 = "type"
            java.lang.String r5 = "text"
            java.lang.String r4 = r3.optString(r4, r5)
            r6 = 100
            java.lang.String r7 = "charCount"
            int r6 = r3.optInt(r7, r6)
            java.lang.String r8 = "numLines"
            r10 = 1
            int r8 = r3.optInt(r8, r10)
            r2.setHint(r15)
            r2.setHintTextColor(r11)
            r4.hashCode()
            int r11 = r4.hashCode()
            r15 = 2
            r9 = 4
            r12 = 3
            switch(r11) {
                case -1034364087: goto L_0x00f0;
                case 114715: goto L_0x00e4;
                case 3556653: goto L_0x00db;
                case 96619420: goto L_0x00d0;
                case 1216985755: goto L_0x00c5;
                default: goto L_0x00c4;
            }
        L_0x00c4:
            goto L_0x00fb
        L_0x00c5:
            java.lang.String r5 = "password"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00ce
            goto L_0x00fb
        L_0x00ce:
            r4 = 4
            goto L_0x00fc
        L_0x00d0:
            java.lang.String r5 = "email"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00d9
            goto L_0x00fb
        L_0x00d9:
            r4 = 3
            goto L_0x00fc
        L_0x00db:
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00e2
            goto L_0x00fb
        L_0x00e2:
            r4 = 2
            goto L_0x00fc
        L_0x00e4:
            java.lang.String r5 = "tel"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00ee
            goto L_0x00fb
        L_0x00ee:
            r4 = 1
            goto L_0x00fc
        L_0x00f0:
            java.lang.String r5 = "number"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x00f9
            goto L_0x00fb
        L_0x00f9:
            r4 = 0
            goto L_0x00fc
        L_0x00fb:
            r4 = -1
        L_0x00fc:
            if (r4 == 0) goto L_0x011c
            if (r4 == r10) goto L_0x011c
            if (r4 == r15) goto L_0x0110
            if (r4 == r12) goto L_0x010a
            if (r4 == r9) goto L_0x0107
            goto L_0x0122
        L_0x0107:
            r4 = 129(0x81, float:1.81E-43)
            goto L_0x010c
        L_0x010a:
            r4 = 33
        L_0x010c:
            r2.setInputType(r4)
            goto L_0x011f
        L_0x0110:
            r2.setMaxLines(r8)
            if (r8 <= r10) goto L_0x0122
            r4 = 300(0x12c, float:4.2E-43)
            int r6 = r3.optInt(r7, r4)
            goto L_0x0122
        L_0x011c:
            r2.setInputType(r12)
        L_0x011f:
            r2.setMaxLines(r10)
        L_0x0122:
            r2.setMaxEms(r6)
            io.hansel.userjourney.n.a(r2, r1)
            io.hansel.userjourney.prompts.r$m r1 = new io.hansel.userjourney.prompts.r$m
            r1.<init>(r2, r13)
            r2.addTextChangedListener(r1)
            int r1 = io.hansel.core.utils.HSLUtils.dpToPx(r9)
            r4 = 16
            int r4 = io.hansel.core.utils.HSLUtils.dpToPx(r4)
            r5 = 0
            r2.setPadding(r1, r5, r1, r4)
            r13.setPadding(r1, r5, r1, r5)
            r1 = 8
            r13.setVisibility(r1)
            io.hansel.userjourney.prompts.b0 r4 = io.hansel.userjourney.prompts.b0.a()
            r7 = 0
            r9 = 0
            r1 = 0
            r5 = r3
            r6 = r2
            r8 = r14
            r3 = 1
            r10 = r1
            r4.a(r5, r6, r7, r8, r9, r10)
            io.hansel.userjourney.prompts.r$n r1 = new io.hansel.userjourney.prompts.r$n
            r1.<init>()
            r2.setOnEditorActionListener(r1)
            return r3
        L_0x015e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r.a(android.view.View, io.hansel.core.json.CoreJSONObject, io.hansel.userjourney.prompts.y):boolean");
    }

    private boolean a(FrameLayout.LayoutParams layoutParams, CoreJSONObject coreJSONObject, FrameLayout frameLayout, x xVar) {
        k kVar = this.E;
        if (kVar == null) {
            a((String) "onPromptInitialize-> nudge blue print null");
            return false;
        }
        if (kVar.F() != l.NONE) {
            if (!a(this.j, xVar)) {
                return false;
            }
            layoutParams.leftMargin = this.E.w();
            a(layoutParams, this.r, this.o, coreJSONObject, frameLayout, xVar);
        }
        return true;
    }

    private boolean a(RadioGroup radioGroup, CoreJSONObject coreJSONObject, CoreJSONArray coreJSONArray, int i2, int i3, boolean z2, int i4, LinearLayout.LayoutParams layoutParams) {
        boolean z3;
        RadioGroup radioGroup2 = radioGroup;
        int i5 = i3;
        int i6 = i4;
        LinearLayout.LayoutParams layoutParams2 = layoutParams;
        CoreJSONObject coreJSONObject2 = new CoreJSONObject(coreJSONArray.optString(i2));
        String optString = coreJSONObject2.optString(HSLCriteriaBuilder.VALUE);
        String str = u0.get("prompt_multichoice");
        if (HSLUtils.isSet(optString)) {
            if (z2) {
                CheckBox checkBox = new CheckBox(this.f5635f);
                io.hansel.userjourney.n.a((CompoundButton) checkBox, false, i5, this.m);
                if (!f0.a(this.f5635f, checkBox, coreJSONObject, false, p0.MULTICHOICE, coreJSONObject2, this.f5634e)) {
                    return false;
                }
                checkBox.setTag(optString);
                if (t0.contains(optString)) {
                    checkBox.setChecked(true);
                }
                checkBox.setLayoutParams(layoutParams2);
                checkBox.setPadding(i6, 0, 0, 0);
                radioGroup2.addView(checkBox);
                checkBox.setOnCheckedChangeListener(new o());
            } else {
                RadioButton radioButton = new RadioButton(this.f5635f);
                io.hansel.userjourney.n.a((CompoundButton) radioButton, true, i5, this.m);
                RadioButton radioButton2 = radioButton;
                if (!f0.a(this.f5635f, radioButton, coreJSONObject, false, p0.MULTICHOICE, coreJSONObject2, this.f5634e)) {
                    return false;
                }
                radioButton2.setTag(optString);
                radioGroup2.addView(radioButton2);
                if (optString.equals(str)) {
                    z3 = true;
                    radioButton2.setChecked(true);
                } else {
                    z3 = true;
                }
                radioButton2.setLayoutParams(layoutParams2);
                radioButton2.setPadding(i6, 0, 0, 0);
                radioButton2.setOnCheckedChangeListener(new p());
                return z3;
            }
        }
        z3 = true;
        return z3;
    }

    private boolean a(CoreJSONObject coreJSONObject, CoreJSONObject coreJSONObject2) {
        String optString = coreJSONObject.optString("maxHeight", "0%");
        int parseInt = (optString != null && '%' == optString.charAt(optString.length() - 1)) ? Integer.parseInt(optString.substring(0, optString.length() - 1)) : 0;
        if (parseInt == 0) {
            HSLLogger.w("onPromptInitialize-> height issue", LogGroup.PT);
            return false;
        }
        this.i = parseInt == 100 ? this.E.A().a() : (this.E.A().a() * parseInt) / 100;
        Pair<Integer, Boolean> a2 = h0.a(this.f5635f, this.E, this.o0, coreJSONObject, coreJSONObject2.optJSONObject("label1"), w.label1);
        int intValue = ((Integer) a2.first).intValue();
        boolean booleanValue = ((Boolean) a2.second).booleanValue();
        this.l0 = booleanValue;
        if (booleanValue) {
            intValue = this.E.A().b();
        }
        if (intValue > 1000 && !this.l0) {
            intValue = 1000;
        }
        this.j = intValue;
        return true;
    }

    private boolean a(CoreJSONObject coreJSONObject, x xVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        CoreJSONObject coreJSONObject2 = coreJSONObject;
        FrameLayout frameLayout = (FrameLayout) this.H.findViewById(R.id.p_shadow_container);
        FrameLayout frameLayout2 = (FrameLayout) this.H.findViewById(R.id.prompt);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.J.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout2.getLayoutParams();
        if (!a(layoutParams, coreJSONObject2, frameLayout, xVar)) {
            return false;
        }
        String optString = coreJSONObject2.optString("spacing");
        String optString2 = coreJSONObject2.optString("btnContainerSpacing");
        String optString3 = coreJSONObject2.optString("prompt_template", "");
        int dpToPx = HSLUtils.dpToPx(24);
        if ("important_information".equals(optString3) || "important_information_2".equals(optString3)) {
            dpToPx = HSLUtils.dpToPx(36);
        }
        String[] split = optString.split(CMap.SPACE);
        if (split.length == 4) {
            int dpToPx2 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split[0]));
            int dpToPx3 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split[1]));
            i3 = dpToPx3;
            i2 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split[2]));
            int i14 = dpToPx2;
            i4 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split[3]));
            i5 = i14;
        } else {
            i4 = dpToPx;
            i3 = i4;
            i2 = i3;
            i5 = 0;
        }
        String[] split2 = optString2.split(CMap.SPACE);
        if (split2.length == 4) {
            int dpToPx4 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split2[0]));
            int dpToPx5 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split2[1]));
            i7 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split2[2]));
            i8 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split2[3]));
            i6 = dpToPx5;
            i9 = dpToPx4;
        } else {
            i8 = dpToPx;
            i7 = i8;
            i6 = i7;
            i9 = 0;
        }
        if (layoutParams != null) {
            layoutParams.width = this.j;
            frameLayout.setPadding(0, 0, 0, 0);
            layoutParams2.width = this.j;
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.height = -2;
        }
        int i15 = i3;
        int i16 = this.j;
        int i17 = this.r;
        this.k = (i16 - (i4 + i15)) - i17;
        frameLayout2.setPadding(i17, i17, i17, i17);
        if (this.j == 0 || this.i == 0) {
            HSLLogger.w("onPromptInitialize-> nudge height or width issue", LogGroup.PT);
            return false;
        }
        if (this.E.F() != l.NONE || layoutParams == null) {
            i12 = i5;
            i10 = i7;
            i11 = i15;
        } else {
            String optString4 = coreJSONObject2.optString("position", "");
            if (!this.l0) {
                int dpToPx6 = HSLUtils.dpToPx(8);
                if (this.E.A().b() - this.j < dpToPx6 * 2) {
                    dpToPx6 = (this.E.A().b() - this.j) / 2;
                }
                i13 = dpToPx6;
            } else {
                i13 = 0;
            }
            i12 = i5;
            i10 = i7;
            i11 = i15;
            layoutParams = a(optString4, layoutParams, layoutParams2, i13, this.l0);
        }
        this.J.setLayoutParams(layoutParams);
        frameLayout2.setLayoutParams(layoutParams2);
        ((TextView) this.H.findViewById(R.id.label0)).setPadding(i4, i12, i11, 0);
        LinearLayout linearLayout = (LinearLayout) this.H.findViewById(R.id.prompt_inner);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams3.leftMargin = i4;
        layoutParams3.topMargin = i12;
        layoutParams3.rightMargin = i11;
        layoutParams3.bottomMargin = i2;
        linearLayout.setLayoutParams(layoutParams3);
        LinearLayout linearLayout2 = (LinearLayout) this.H.findViewById(R.id.layout_bottom_btn);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) linearLayout2.getLayoutParams();
        layoutParams4.leftMargin = i8;
        layoutParams4.topMargin = i9;
        layoutParams4.rightMargin = i6;
        int i18 = i10;
        layoutParams4.bottomMargin = i18;
        linearLayout2.setLayoutParams(layoutParams4);
        this.s = i9 + i18;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("shadow issue bottomBtnLayoutMargin in initializePrompt is ");
        outline73.append(this.s);
        HSLLogger.d(outline73.toString());
        int dpToPx7 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(coreJSONObject.optString("btnGap", "16px")));
        View findViewById = this.H.findViewById(R.id.line_btn1);
        ViewGroup.LayoutParams layoutParams5 = findViewById.getLayoutParams();
        layoutParams5.width = dpToPx7;
        findViewById.setLayoutParams(layoutParams5);
        View findViewById2 = this.H.findViewById(R.id.line_btn2);
        ViewGroup.LayoutParams layoutParams6 = findViewById2.getLayoutParams();
        layoutParams6.width = dpToPx7;
        findViewById2.setLayoutParams(layoutParams6);
        return true;
    }

    private Orientation b(int i2) {
        int i3 = (i2 + 270) % JpegTranscoderUtils.FULL_ROUND;
        return i3 != 45 ? i3 != 90 ? i3 != 135 ? i3 != 180 ? i3 != 225 ? i3 != 270 ? i3 != 315 ? Orientation.LEFT_RIGHT : Orientation.BL_TR : Orientation.BOTTOM_TOP : Orientation.BR_TL : Orientation.RIGHT_LEFT : Orientation.TR_BL : Orientation.TOP_BOTTOM : Orientation.TL_BR;
    }

    private boolean b(View view, CoreJSONObject coreJSONObject) {
        RelativeLayout relativeLayout;
        View view2 = view;
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("props");
        String optString = optJSONObject.optString("npsType", "");
        boolean equals = "click".equals(optString);
        int optInt = optJSONObject.optInt("maxNumber");
        String optString2 = optJSONObject.optString("leftText", "");
        String optString3 = optJSONObject.optString("rightText", "");
        int c2 = io.hansel.userjourney.n.c("#757575");
        int c3 = io.hansel.userjourney.n.c("#757575");
        int c4 = io.hansel.userjourney.n.c("#038BC8");
        int c5 = io.hansel.userjourney.n.c("#B3757575");
        int c6 = io.hansel.userjourney.n.c("#B3038BC8");
        int a2 = io.hansel.userjourney.n.a(optJSONObject, (String) "helpTextColor", c3);
        int i2 = c6;
        int i3 = c5;
        String str = optString;
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{16842912}, new int[0]}, new int[]{io.hansel.userjourney.n.a(optJSONObject, (String) "selectedNumberColor", c2), io.hansel.userjourney.n.a(optJSONObject, (String) "unselectedNumberColor", c3)});
        RadioGroup radioGroup = (RadioGroup) view2.findViewById(R.id.nps_click);
        SeekBar seekBar = (SeekBar) view2.findViewById(R.id.nps_seek_bar);
        TextView textView = (TextView) view2.findViewById(R.id.nps_left);
        TextView textView2 = (TextView) view2.findViewById(R.id.nps_right);
        int i4 = (optInt < 3 || optInt > 11) ? 11 : optInt;
        TextView textView3 = textView2;
        CoreJSONObject coreJSONObject2 = optJSONObject;
        ColorStateList colorStateList2 = colorStateList;
        String str2 = "";
        int i5 = a2;
        SeekBar seekBar2 = seekBar;
        int i6 = i2;
        f0.a(this.f5635f, textView, coreJSONObject2, optString2, 12, "fontSizeLabel");
        TextView textView4 = textView3;
        f0.a(this.f5635f, textView4, coreJSONObject2, optString3, 12, "fontSizeLabel");
        textView.setTextColor(i5);
        textView4.setTextColor(i5);
        int i7 = i4;
        int i8 = this.k / i7;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.k, -2);
        layoutParams.gravity = 17;
        RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.layout_nps);
        relativeLayout2.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.k, -2);
        layoutParams2.gravity = 17;
        radioGroup.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i8 - (HSLUtils.dpToPx(0.5f) * 2), HSLUtils.dpToPx(10) + i8);
        layoutParams3.gravity = 17;
        String str3 = u0.get("prompt_nps");
        int parseInt = str3 == null ? -1 : Integer.parseInt(str3);
        if (equals) {
            int a3 = io.hansel.userjourney.n.a(optJSONObject, (String) "selectedBoxColor", c4);
            int a4 = io.hansel.userjourney.n.a(optJSONObject, (String) "borderBoxColor", c3);
            GradientDrawable gradientDrawable = new GradientDrawable();
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(a3);
            gradientDrawable.setStroke(0, 0);
            gradientDrawable2.setShape(0);
            gradientDrawable2.setColor(ContextCompat.getColor(this.f5635f, R.color.hansel_transparent));
            gradientDrawable2.setStroke(HSLUtils.dpToPx(0.5f), a4);
            seekBar2.setVisibility(8);
            int i9 = 0;
            while (i9 < i7) {
                RadioButton radioButton = new RadioButton(this.f5635f);
                ColorStateList colorStateList3 = colorStateList2;
                radioButton.setTextColor(colorStateList3);
                String str4 = str2;
                ColorStateList colorStateList4 = colorStateList3;
                RadioButton radioButton2 = radioButton;
                RelativeLayout relativeLayout3 = relativeLayout2;
                int i10 = parseInt;
                f0.a(this.f5635f, radioButton, optJSONObject, GeneratedOutlineSupport.outline41(str4, i9), 14, null);
                radioButton2.setButtonDrawable(new ColorDrawable(ContextCompat.getColor(this.f5635f, R.color.hansel_transparent)));
                radioButton2.setLayoutParams(layoutParams3);
                radioButton2.setBackground(gradientDrawable2);
                radioButton2.setGravity(17);
                StringBuilder sb = new StringBuilder();
                sb.append(i9);
                String str5 = str4;
                sb.append(str5);
                radioButton2.setTag(sb.toString());
                radioGroup.addView(radioButton2);
                if (i10 == i9) {
                    radioButton2.setChecked(true);
                }
                radioButton2.setOnCheckedChangeListener(new b(gradientDrawable, gradientDrawable2));
                i9++;
                View view3 = view;
                str2 = str5;
                parseInt = i10;
                colorStateList2 = colorStateList4;
                relativeLayout2 = relativeLayout3;
            }
            relativeLayout = relativeLayout2;
        } else {
            SeekBar seekBar3 = seekBar2;
            relativeLayout = relativeLayout2;
            ColorStateList colorStateList5 = colorStateList2;
            int i11 = parseInt;
            String str6 = str2;
            if (!"slide".equals(str)) {
                return false;
            }
            int a5 = io.hansel.userjourney.n.a(optJSONObject, (String) "sliderCircleColor", c4);
            int dpToPx = HSLUtils.dpToPx(io.hansel.userjourney.n.b(optJSONObject.optString("height", "20px")));
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(a5);
            gradientDrawable3.setSize(dpToPx, dpToPx);
            gradientDrawable3.setShape(1);
            seekBar3.setThumb(gradientDrawable3);
            float a6 = io.hansel.userjourney.n.a(optJSONObject, (String) "sliderOpacity", 0.7f);
            int a7 = io.hansel.userjourney.n.a(optJSONObject, (String) "unselectedSliderColor", a6, i3);
            int a8 = io.hansel.userjourney.n.a(optJSONObject, (String) "selectedSliderColor", a6, i6);
            LayerDrawable layerDrawable = (LayerDrawable) this.f5635f.getResources().getDrawable(R.drawable.hansel_custom_seekbar);
            GradientDrawable gradientDrawable4 = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.item_bg);
            gradientDrawable4.setColor(a7);
            layerDrawable.setDrawableByLayerId(R.id.item_bg, gradientDrawable4);
            ScaleDrawable scaleDrawable = (ScaleDrawable) layerDrawable.findDrawableByLayerId(R.id.item_prog);
            scaleDrawable.setColorFilter(a8, Mode.SRC);
            layerDrawable.setDrawableByLayerId(R.id.item_prog, scaleDrawable);
            seekBar3.setProgressDrawable(layerDrawable);
            Object obj = this.w.get("prompt_nps");
            seekBar3.setProgress(obj == null ? 0 : Integer.parseInt(obj.toString()));
            RadioButton[] radioButtonArr = new RadioButton[i7];
            int i12 = 0;
            while (i12 < i7) {
                RadioButton radioButton3 = new RadioButton(this.f5635f);
                ColorStateList colorStateList6 = colorStateList5;
                radioButton3.setTextColor(colorStateList6);
                int i13 = i7;
                SeekBar seekBar4 = seekBar3;
                String str7 = str6;
                f0.a(this.f5635f, radioButton3, optJSONObject, GeneratedOutlineSupport.outline41(str6, i12), 14, null);
                radioButton3.setButtonDrawable(R.color.hansel_transparent);
                radioButton3.setLayoutParams(layoutParams3);
                radioButton3.setBackgroundColor(ContextCompat.getColor(this.f5635f, R.color.hansel_transparent));
                radioButton3.setGravity(17);
                radioButton3.setEnabled(false);
                radioButtonArr[i12] = radioButton3;
                radioGroup.addView(radioButton3);
                if (i11 == i12) {
                    radioButton3.setChecked(true);
                }
                i12++;
                seekBar3 = seekBar4;
                colorStateList5 = colorStateList6;
                str6 = str7;
                i7 = i13;
            }
            seekBar3.setOnSeekBarChangeListener(new c(radioButtonArr));
        }
        b0.a().a(optJSONObject, relativeLayout, 0, HSLUtils.dpToPx(24), 0, 0);
        View findViewById = view.findViewById(R.id.layout_nps_hint);
        LayoutParams layoutParams4 = (LayoutParams) findViewById.getLayoutParams();
        layoutParams4.topMargin = HSLUtils.dpToPx(4);
        layoutParams4.bottomMargin = 0;
        layoutParams4.leftMargin = 0;
        layoutParams4.rightMargin = 0;
        findViewById.setLayoutParams(layoutParams4);
        return true;
    }

    /* access modifiers changed from: private */
    public boolean b(CoreJSONObject coreJSONObject, x xVar) {
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("prompt");
        if (optJSONObject != null) {
            CoreJSONObject optJSONObject2 = optJSONObject.optJSONObject("props");
            float a2 = io.hansel.userjourney.n.a(optJSONObject2, (String) "bgOpacity", 1.0f);
            float a3 = io.hansel.userjourney.n.a(optJSONObject2, (String) "borderOpacity", 1.0f);
            this.h = io.hansel.userjourney.n.a(optJSONObject2, (String) "backDropColor", io.hansel.userjourney.n.a(optJSONObject2, (String) "backDropOpacity", 0.8f), 1711276032);
            this.l = io.hansel.userjourney.n.a(optJSONObject2, (String) "bgColor", a2, io.hansel.userjourney.n.c("#FFFFFF"));
            this.U = io.hansel.userjourney.n.a(optJSONObject2, (String) "bgFill", (String) "type");
            this.o = io.hansel.userjourney.n.a(optJSONObject2, (String) "borderColor", a3, this.l);
            this.r = HSLUtils.dpToPx(optJSONObject2.optInt("borderThickness", 0));
            this.Z = optJSONObject2.optBoolean("showShadow", true);
            this.n = HSLUtils.dpToPx(optJSONObject2.optInt("cornerRadius", 0));
            int optInt = optJSONObject2.optInt("selfDestructTimeout", -1);
            if (!a(optJSONObject2, coreJSONObject) || !a(optJSONObject2, xVar)) {
                return false;
            }
            if (optInt != -1) {
                this.I.postDelayed(this.j0, (long) optInt);
            }
            return true;
        }
        HSLLogger.d("could not retrieve prompt object");
        return false;
    }

    private boolean c(View view, CoreJSONObject coreJSONObject) {
        int i2;
        CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("props");
        String optString = optJSONObject.optString("ratingImg");
        if (!HSLUtils.isSet(optString)) {
            return false;
        }
        int optInt = optJSONObject.optInt("maxCount");
        if (optInt < 3) {
            optInt = 3;
        }
        if (optInt > 7) {
            optInt = 7;
        }
        int a2 = io.hansel.userjourney.n.a(optJSONObject, (String) "selectedColor", 0);
        if (a2 == 0) {
            return false;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.rating_layout);
        ImageView[] imageViewArr = new ImageView[optInt];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.k, -2);
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        int dpToPx = HSLUtils.dpToPx(io.hansel.userjourney.n.b(optJSONObject.optString("gap", "4px")));
        int i3 = (this.k / optInt) - ((dpToPx * 2) * optInt);
        int dpToPx2 = HSLUtils.dpToPx(32);
        String[] split = optJSONObject.optString("dimension", "32px 32px").split(CMap.SPACE);
        if (split.length == 2) {
            dpToPx2 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split[0]));
            i2 = HSLUtils.dpToPx(io.hansel.userjourney.n.b(split[1]));
        } else {
            i2 = dpToPx2;
        }
        if (dpToPx2 > i3) {
            i2 = i3;
        } else {
            i3 = dpToPx2;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i3, i2);
        layoutParams2.gravity = 17;
        String str = u0.get("prompt_rating");
        int parseInt = str == null ? -1 : Integer.parseInt(str);
        for (int i4 = 0; i4 < optInt; i4++) {
            ImageView imageView = new ImageView(this.f5635f);
            imageView.setImageDrawable(a(optString, a2));
            imageView.setTag(Integer.valueOf(i4));
            imageView.setPadding(dpToPx, 0, dpToPx, 0);
            imageView.setLayoutParams(layoutParams2);
            if (parseInt > i4) {
                imageView.setSelected(true);
            }
            imageView.setOnClickListener(new a(optInt, imageViewArr));
            linearLayout.addView(imageView);
            imageViewArr[i4] = imageView;
        }
        b0.a().a(optJSONObject, linearLayout, 0, HSLUtils.dpToPx(24), 0, 0);
        return true;
    }

    private void e() {
        View findViewById = this.H.findViewById(R.id.prompt);
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        int[] iArr = new int[2];
        findViewById.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Dimensions are:\nPrompt id: ");
        outline73.append(this.w.get("hsl_data"));
        outline73.append("Prompt width: ");
        outline73.append(HSLUtils.pxToDp((float) width));
        outline73.append(" , Prompt height: ");
        outline73.append(HSLUtils.pxToDp((float) height));
        outline73.append("  , PromptX: ");
        outline73.append(HSLUtils.pxToDp((float) i2));
        outline73.append(" , PromptY: ");
        outline73.append(HSLUtils.pxToDp((float) i3));
        outline73.append(a(this.H.findViewById(R.id.label0), (String) "label0"));
        outline73.append(a(this.H.findViewById(R.id.img1), (String) "img1"));
        outline73.append(a(this.H.findViewById(R.id.card_ha), (String) "card_ha"));
        outline73.append(a(this.H.findViewById(R.id.label1), (String) "label1"));
        outline73.append(a(this.H.findViewById(R.id.label2), (String) "label2"));
        outline73.append(a(this.H.findViewById(R.id.label3), (String) "label3"));
        outline73.append(a(this.H.findViewById(R.id.rating_layout), (String) "rating_layout"));
        outline73.append(a(this.H.findViewById(R.id.nps_click), (String) "nps_click"));
        outline73.append(a(this.H.findViewById(R.id.nps_seek_bar), (String) "nps_seek_bar"));
        outline73.append(a(this.H.findViewById(R.id.nps_left), (String) "nps_left"));
        outline73.append(a(this.H.findViewById(R.id.nps_right), (String) "nps_right"));
        outline73.append(a(this.H.findViewById(R.id.label4), (String) "label4"));
        outline73.append(a(this.H.findViewById(R.id.multichoice), (String) "multichoice"));
        outline73.append(a(this.H.findViewById(R.id.input1), (String) "input1"));
        outline73.append(a(this.H.findViewById(R.id.input_err1), (String) "input_err1"));
        outline73.append(a(this.H.findViewById(R.id.input2), (String) "input2"));
        outline73.append(a(this.H.findViewById(R.id.input_err2), (String) "input_err2"));
        outline73.append(a(this.H.findViewById(R.id.prompt_inner), (String) "prompt_inner"));
        outline73.append(a(this.H.findViewById(R.id.layout_bottom_btn), (String) "layout_bottom_btn"));
        outline73.append(a(this.H.findViewById(R.id.btn1), (String) "btn1"));
        outline73.append(a(this.H.findViewById(R.id.btn2), (String) "btn2"));
        outline73.append(a(this.H.findViewById(R.id.btn3), (String) "btn3"));
        outline73.append(a(this.H.findViewById(R.id.container_btnX), (String) "container_btnX"));
        outline73.append(a(this.H.findViewById(R.id.btnX), (String) "btnX"));
        String sb = outline73.toString();
        SharedPreferences sharedPreferences = this.f5635f.getSharedPreferences("HanselTempDimenSP", 0);
        Editor edit = sharedPreferences.edit();
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("");
        outline732.append(sharedPreferences.getAll().keySet().size());
        edit.putString(outline732.toString(), sb);
        edit.apply();
        HSLLogger.d(sb);
    }

    /* access modifiers changed from: private */
    public void g() {
        boolean z2 = this.F.size() == 0;
        int size = this.A.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.A.get(i2).setEnabled(z2);
        }
    }

    private int h() {
        if (this.e0 || !this.f0) {
            return 0;
        }
        return this.h;
    }

    private void l() {
        if (this.E.K()) {
            this.H.setOnKeyListener(new f());
        }
    }

    private void n() {
        HashMap<String, Object> hashMap;
        StringBuilder sb;
        this.Q = 0;
        if (this.w != null) {
            sb = GeneratedOutlineSupport.outline73("onCreate method: ");
            sb.append(this.M);
            sb.append(" with timestamp ");
            sb.append(this.O);
            sb.append(" promptForDismissEvent is ");
            hashMap = this.w;
        } else {
            sb = GeneratedOutlineSupport.outline73("onCreate method: ");
            sb.append(this.M);
            sb.append(" with timestamp ");
            sb.append(this.O);
            sb.append(" promptForDismissEvent is ");
            hashMap = null;
        }
        sb.append(hashMap);
        HSLLogger.d(sb.toString(), LogGroup.PT);
        if (this.w.containsKey("time_spent")) {
            this.t = false;
            return;
        }
        HashMap<String, Object> hashMap2 = this.w;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("");
        outline73.append(System.currentTimeMillis());
        hashMap2.put("time_spent", outline73.toString());
        HashMap<String, Object> hashMap3 = this.y;
        StringBuilder outline732 = GeneratedOutlineSupport.outline73("");
        outline732.append(System.currentTimeMillis());
        hashMap3.put("Time_spent_nudge", outline732.toString());
    }

    private boolean o() {
        Boolean bool = this.N;
        return bool != null && bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public void q() {
        String str;
        if (!this.k0) {
            this.P = System.currentTimeMillis();
            this.k0 = true;
            String l2 = Long.toString(System.currentTimeMillis());
            this.T = l2;
            this.x.put("prompt_unique_id_key", l2);
            this.w.put("prompt_unique_id_key", this.T);
            this.z.put("prompt_unique_id_key", this.T);
            this.y.put("prompt_unique_id_key", this.T);
            q0 q0Var = this.i0;
            if (q0Var != null) {
                q0Var.a(this.x, this.z);
            } else {
                this.f5633d.a(this.x, this.z, this);
            }
            if (this.E.G() == d0.AUTO) {
                this.J.setVisibility(0);
            } else {
                this.J.getViewTreeObserver().addOnGlobalLayoutListener(new j());
                t();
            }
            if (this.w == null) {
                str = "Prompt is not shown ";
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Prompt is shown for:   ");
                outline73.append(this.w.get("hsl_data"));
                str = outline73.toString();
            }
            HSLLogger.d(str, LogGroup.PT);
            if (this.f5630a) {
                e();
            }
        }
    }

    private boolean s() {
        CoreJSONObject optJSONObject = this.S.optJSONObject("prompt");
        if (optJSONObject != null) {
            CoreJSONObject optJSONObject2 = optJSONObject.optJSONObject("props");
            if (optJSONObject2 != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.J.getLayoutParams();
                if (a(layoutParams, optJSONObject2, (FrameLayout) this.H.findViewById(R.id.p_shadow_container), x.UPDATE)) {
                    this.J.setLayoutParams(layoutParams);
                    return true;
                }
            }
        }
        return false;
    }

    private void t() {
        if (s()) {
            HSLLogger.d("Nudge moved.", LogGroup.PT);
            r();
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("onPromptDismiss-> Failed on update for promptid ");
        outline73.append(this.M);
        a(outline73.toString());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean u() {
        /*
            r7 = this;
            java.util.List<android.widget.EditText> r0 = r7.B
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x0008:
            if (r2 >= r0) goto L_0x0072
            java.util.List<android.widget.EditText> r3 = r7.B
            java.lang.Object r3 = r3.get(r2)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.Object r4 = r3.getTag()
            java.lang.String r4 = r4.toString()
            r5 = 0
            java.lang.String r6 = "1"
            boolean r6 = r4.endsWith(r6)
            if (r6 == 0) goto L_0x002f
            android.view.View r4 = r7.H
            int r5 = io.hansel.R.id.input_err1
        L_0x0027:
            android.view.View r4 = r4.findViewById(r5)
            r5 = r4
            android.widget.TextView r5 = (android.widget.TextView) r5
            goto L_0x003c
        L_0x002f:
            java.lang.String r6 = "2"
            boolean r4 = r4.endsWith(r6)
            if (r4 == 0) goto L_0x003c
            android.view.View r4 = r7.H
            int r5 = io.hansel.R.id.input_err2
            goto L_0x0027
        L_0x003c:
            int r4 = r3.getInputType()
            r6 = 33
            if (r4 != r6) goto L_0x0068
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            boolean r3 = io.hansel.userjourney.n.d(r3)
            if (r3 != 0) goto L_0x0068
            if (r5 == 0) goto L_0x0066
            android.content.Context r0 = r7.f5635f
            android.content.res.Resources r0 = r0.getResources()
            int r2 = io.hansel.R.string.err_hsl_email
            java.lang.String r0 = r0.getString(r2)
            r5.setText(r0)
            r5.setVisibility(r1)
        L_0x0066:
            r0 = 1
            return r0
        L_0x0068:
            if (r5 == 0) goto L_0x006f
            r3 = 8
            r5.setVisibility(r3)
        L_0x006f:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x0072:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r.u():boolean");
    }

    /* access modifiers changed from: private */
    public void v() {
        boolean z2;
        if (this.g0) {
            w();
        }
        FrameLayout frameLayout = (FrameLayout) this.H.findViewById(R.id.prompt);
        FrameLayout frameLayout2 = (FrameLayout) this.H.findViewById(R.id.prompt_content_view);
        if (u.NONE == this.E.g()) {
            frameLayout2.setOutlineProvider(new e());
            frameLayout2.setClipToOutline(true);
            z2 = true;
        } else {
            z2 = false;
        }
        float[] fArr = new float[8];
        u g2 = this.E.g();
        u uVar = u.TOP_LEFT;
        fArr[0] = g2 == uVar ? 0.0f : (float) (this.n + this.r);
        fArr[1] = this.E.g() == uVar ? 0.0f : (float) (this.n + this.r);
        u g3 = this.E.g();
        u uVar2 = u.TOP_RIGHT;
        fArr[2] = g3 == uVar2 ? 0.0f : (float) (this.n + this.r);
        fArr[3] = this.E.g() == uVar2 ? 0.0f : (float) (this.n + this.r);
        u g4 = this.E.g();
        u uVar3 = u.BOTTOM_RIGHT;
        fArr[4] = g4 == uVar3 ? 0.0f : (float) (this.n + this.r);
        fArr[5] = this.E.g() == uVar3 ? 0.0f : (float) (this.n + this.r);
        u g5 = this.E.g();
        u uVar4 = u.BOTTOM_LEFT;
        fArr[6] = g5 == uVar4 ? 0.0f : (float) (this.n + this.r);
        fArr[7] = this.E.g() == uVar4 ? 0.0f : (float) (this.n + this.r);
        float[] fArr2 = new float[8];
        fArr2[0] = this.E.g() == uVar ? 0.0f : (float) this.n;
        fArr2[1] = this.E.g() == uVar ? 0.0f : (float) this.n;
        fArr2[2] = this.E.g() == uVar2 ? 0.0f : (float) this.n;
        fArr2[3] = this.E.g() == uVar2 ? 0.0f : (float) this.n;
        fArr2[4] = this.E.g() == uVar3 ? 0.0f : (float) this.n;
        fArr2[5] = this.E.g() == uVar3 ? 0.0f : (float) this.n;
        fArr2[6] = this.E.g() == uVar4 ? 0.0f : (float) this.n;
        fArr2[7] = this.E.g() == uVar4 ? 0.0f : (float) this.n;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(this.r, this.o);
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadii(fArr);
        frameLayout.setBackground(gradientDrawable);
        a(Boolean.valueOf(z2), fArr2, frameLayout2);
        View findViewById = this.H.findViewById(R.id.prompt_shadow);
        if (this.Z) {
            int dpToPx = HSLUtils.dpToPx(2);
            Rect rect = new Rect();
            rect.left = dpToPx;
            rect.right = dpToPx;
            rect.top = dpToPx;
            rect.bottom = dpToPx;
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(io.hansel.userjourney.n.c("#10333333"));
            gradientDrawable2.getPadding(rect);
            gradientDrawable2.setCornerRadii(fArr);
            findViewById.setBackground(gradientDrawable2);
            return;
        }
        findViewById.setVisibility(8);
    }

    private void w() {
        ImageView imageView = (ImageView) this.H.findViewById(R.id.view_opaque);
        try {
            View rootView = this.h0.getWindow().getDecorView().getRootView();
            byte[] decode = Base64.decode(io.hansel.userjourney.n.a(rootView, rootView.getLeft(), rootView.getTop(), rootView.getWidth(), rootView.getHeight()), 0);
            imageView.setImageBitmap(io.hansel.userjourney.n.a(this.f5635f, BitmapFactory.decodeByteArray(decode, 0, decode.length)));
        } catch (Exception e2) {
            HSLLogger.e(e2.getMessage());
        }
    }

    private void x() {
        View view;
        CoreJSONObject optJSONObject = this.S.optJSONObject("prompt");
        if (optJSONObject != null) {
            CoreJSONObject optJSONObject2 = optJSONObject.optJSONObject("props");
            if (optJSONObject2 != null) {
                this.e0 = optJSONObject2.optBoolean("allowAppInteraction", true);
                this.f0 = optJSONObject2.optBoolean("showBackdrop", true);
                this.g0 = optJSONObject2.optBoolean("blurBackdrop", true);
                boolean optBoolean = optJSONObject2.optBoolean("backdropDismiss", true);
                View findViewById = this.H.findViewById(R.id.view_opaque);
                findViewById.setOnTouchListener(new k(optBoolean));
                if (this.E.F() != l.TOOLTIP || this.E.r() == null || !this.f0) {
                    view = findViewById;
                } else {
                    int i2 = this.E.i();
                    int h2 = this.E.h();
                    int j2 = this.E.j();
                    int k2 = this.E.k();
                    int l2 = this.E.l();
                    p C2 = this.E.C();
                    o B2 = this.E.B();
                    Resources resources = this.f5635f.getResources();
                    int dpToPx = HSLUtils.dpToPx(10);
                    int d2 = this.E.A().d();
                    int i3 = j2;
                    int i4 = k2;
                    view = findViewById;
                    int i5 = k2;
                    int i6 = d2;
                    int i7 = i2;
                    int i8 = j2;
                    int c2 = this.E.A().c();
                    int i9 = i8;
                    int i10 = h2;
                    io.hansel.userjourney.n.a(resources, (ImageView) this.H.findViewById(R.id.view_opaque), C2, B2, l2, i2, h2, dpToPx, i3, i4, i6, c2, h());
                    if (this.b0) {
                        a(i9, i5, i7, i10);
                    }
                }
                if (this.e0) {
                    view.setVisibility(8);
                } else {
                    View view2 = view;
                    view2.setVisibility(0);
                    if (!this.f0) {
                        view2.setBackgroundColor(0);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x03dc A[SYNTHETIC, Splitter:B:126:0x03dc] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0453 A[Catch:{ all -> 0x0687 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x04ca A[Catch:{ all -> 0x0687 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0541 A[Catch:{ all -> 0x0687 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x055a A[Catch:{ all -> 0x0687 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x055b A[Catch:{ all -> 0x0687 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x058d A[Catch:{ all -> 0x0687 }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x05a7 A[Catch:{ all -> 0x0687 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x05bd A[Catch:{ all -> 0x0687 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05d1 A[Catch:{ all -> 0x0687 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x05fc A[Catch:{ all -> 0x0687 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0104 A[Catch:{ all -> 0x0687 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.Boolean, android.view.View> a(android.view.LayoutInflater r39, android.view.ViewGroup r40) {
        /*
            r38 = this;
            r1 = r38
            java.lang.String r0 = "multiChoice"
            java.lang.String r2 = "ratingInputLabel"
            java.lang.String r3 = "npsInputLabel"
            java.lang.String r4 = "label3"
            java.lang.String r5 = "label2"
            java.lang.String r6 = "label1"
            java.lang.String r7 = "label0"
            java.lang.String r8 = "bgFill"
            java.lang.String r9 = "img1"
            java.lang.String r10 = "prompt"
            java.lang.String r11 = "btnX-new"
            java.lang.String r12 = "btn3"
            java.lang.String r13 = "btn2"
            java.lang.String r14 = "btn1"
            r15 = 0
            r1.k0 = r15
            java.lang.Boolean r15 = java.lang.Boolean.FALSE
            r1.N = r15
            java.lang.String r15 = "OnCreateView method invoked for prompt "
            java.lang.StringBuilder r15 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r15)
            r16 = r11
            java.lang.String r11 = r1.M
            r15.append(r11)
            java.lang.String r11 = " with timestamp "
            r15.append(r11)
            java.lang.String r11 = r1.O
            r15.append(r11)
            java.lang.String r11 = r15.toString()
            io.hansel.core.logger.LogGroup r15 = io.hansel.core.logger.LogGroup.PT
            io.hansel.core.logger.HSLLogger.d(r11, r15)
            io.hansel.core.json.CoreJSONObject r11 = r1.S
            if (r11 == 0) goto L_0x068e
            android.content.Context r11 = r1.f5635f
            if (r11 == 0) goto L_0x068e
            int r11 = io.hansel.R.layout.hansel_trigger_dialog
            r17 = r12
            r12 = 0
            r18 = r13
            r19 = r14
            r13 = r39
            r14 = r40
            android.view.View r11 = r13.inflate(r11, r14, r12)
            r1.H = r11
            int r12 = io.hansel.R.id.hansel_nudge_view
            java.lang.Boolean r13 = java.lang.Boolean.TRUE
            r11.setTag(r12, r13)
            android.view.View r11 = r1.H
            int r12 = io.hansel.R.id.prompt_pnc
            android.view.View r11 = r11.findViewById(r12)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            r1.J = r11
            android.view.View r11 = r1.H
            r12 = 4
            r11.setVisibility(r12)
            android.view.View r11 = r1.H
            int r13 = io.hansel.R.id.prompt_main
            android.view.View r11 = r11.findViewById(r13)
            r11.setVisibility(r12)
            android.content.Context r11 = r1.f5635f
            android.content.res.Resources r11 = r11.getResources()
            int r12 = io.hansel.R.color.hansel_blue_default
            int r11 = r11.getColor(r12)
            r1.m = r11
            io.hansel.core.json.CoreJSONObject r11 = r1.S     // Catch:{ all -> 0x0687 }
            boolean r12 = r11.has(r10)     // Catch:{ all -> 0x0687 }
            if (r12 == 0) goto L_0x0675
            io.hansel.userjourney.prompts.x r12 = io.hansel.userjourney.prompts.x.INIT     // Catch:{ all -> 0x0687 }
            boolean r12 = r1.b(r11, r12)     // Catch:{ all -> 0x0687 }
            if (r12 == 0) goto L_0x0675
            r38.x()     // Catch:{ all -> 0x0687 }
            java.lang.String r12 = "OnCreateView method reached after initialize prompt."
            io.hansel.core.logger.HSLLogger.d(r12, r15)     // Catch:{ all -> 0x0687 }
            java.util.HashSet r12 = new java.util.HashSet     // Catch:{ all -> 0x0687 }
            r12.<init>()     // Catch:{ all -> 0x0687 }
            r1.F = r12     // Catch:{ all -> 0x0687 }
            boolean r12 = r11.has(r9)     // Catch:{ all -> 0x0687 }
            java.lang.String r13 = "spacing"
            java.lang.String r14 = "props"
            if (r12 == 0) goto L_0x00ed
            io.hansel.userjourney.prompts.d.d r12 = r1.p0     // Catch:{ all -> 0x0687 }
            r26 = r15
            android.view.View r15 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r22 = r11.getJSONObject(r9)     // Catch:{ all -> 0x0687 }
            int r9 = r1.j     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.v r24 = io.hansel.userjourney.prompts.v.img1     // Catch:{ all -> 0x0687 }
            r27 = r0
            io.hansel.core.json.CoreJSONObject r0 = r1.S     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r0 = r0.getJSONObject(r10)     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r0 = r0.getJSONObject(r14)     // Catch:{ all -> 0x0687 }
            java.lang.String r25 = r0.optString(r13)     // Catch:{ all -> 0x0687 }
            r20 = r12
            r21 = r15
            r23 = r9
            boolean r0 = r20.a(r21, r22, r23, r24, r25)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x00f1
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            goto L_0x00fe
        L_0x00ed:
            r27 = r0
            r26 = r15
        L_0x00f1:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r9 = io.hansel.R.id.img1     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r9)     // Catch:{ all -> 0x0687 }
            r9 = 8
            r0.setVisibility(r9)     // Catch:{ all -> 0x0687 }
        L_0x00fe:
            boolean r0 = r11.has(r8)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x011d
            io.hansel.userjourney.prompts.d.d r0 = r1.p0     // Catch:{ all -> 0x0687 }
            android.view.View r9 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r22 = r11.getJSONObject(r8)     // Catch:{ all -> 0x0687 }
            int r8 = r1.j     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.v r24 = io.hansel.userjourney.prompts.v.bgImage     // Catch:{ all -> 0x0687 }
            java.lang.String r25 = r11.optString(r13)     // Catch:{ all -> 0x0687 }
            r20 = r0
            r21 = r9
            r23 = r8
            r20.a(r21, r22, r23, r24, r25)     // Catch:{ all -> 0x0687 }
        L_0x011d:
            boolean r0 = r11.has(r7)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x0150
            io.hansel.userjourney.prompts.d.e r0 = r1.o0     // Catch:{ all -> 0x0687 }
            android.view.View r8 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r7 = r11.getJSONObject(r7)     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.w r9 = io.hansel.userjourney.prompts.w.label0     // Catch:{ all -> 0x0687 }
            boolean r0 = r0.a(r8, r7, r9)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x0150
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r7 = io.hansel.R.id.prompt_inner     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r7)     // Catch:{ all -> 0x0687 }
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ all -> 0x0687 }
            android.view.ViewGroup$LayoutParams r7 = r0.getLayoutParams()     // Catch:{ all -> 0x0687 }
            android.widget.LinearLayout$LayoutParams r7 = (android.widget.LinearLayout.LayoutParams) r7     // Catch:{ all -> 0x0687 }
            r8 = 0
            r7.topMargin = r8     // Catch:{ all -> 0x0687 }
            r0.setLayoutParams(r7)     // Catch:{ all -> 0x0687 }
            goto L_0x015d
        L_0x0150:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r7 = io.hansel.R.id.label0     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r7)     // Catch:{ all -> 0x0687 }
            r7 = 8
            r0.setVisibility(r7)     // Catch:{ all -> 0x0687 }
        L_0x015d:
            boolean r0 = r11.has(r6)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x017a
            io.hansel.userjourney.prompts.d.e r0 = r1.o0     // Catch:{ all -> 0x0687 }
            android.view.View r7 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r6 = r11.getJSONObject(r6)     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.w r8 = io.hansel.userjourney.prompts.w.label1     // Catch:{ all -> 0x0687 }
            boolean r0 = r0.a(r7, r6, r8)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x017a
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            goto L_0x0187
        L_0x017a:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r6 = io.hansel.R.id.label1     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r6)     // Catch:{ all -> 0x0687 }
            r6 = 8
            r0.setVisibility(r6)     // Catch:{ all -> 0x0687 }
        L_0x0187:
            boolean r0 = r11.has(r5)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x01a4
            io.hansel.userjourney.prompts.d.e r0 = r1.o0     // Catch:{ all -> 0x0687 }
            android.view.View r6 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r5 = r11.getJSONObject(r5)     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.w r7 = io.hansel.userjourney.prompts.w.label2     // Catch:{ all -> 0x0687 }
            boolean r0 = r0.a(r6, r5, r7)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x01a4
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            goto L_0x01b1
        L_0x01a4:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r5 = io.hansel.R.id.label2     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ all -> 0x0687 }
            r5 = 8
            r0.setVisibility(r5)     // Catch:{ all -> 0x0687 }
        L_0x01b1:
            boolean r0 = r11.has(r4)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x01ce
            io.hansel.userjourney.prompts.d.e r0 = r1.o0     // Catch:{ all -> 0x0687 }
            android.view.View r5 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r4 = r11.getJSONObject(r4)     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.w r6 = io.hansel.userjourney.prompts.w.label3     // Catch:{ all -> 0x0687 }
            boolean r0 = r0.a(r5, r4, r6)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x01ce
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            goto L_0x01db
        L_0x01ce:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r4 = io.hansel.R.id.label3     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r4)     // Catch:{ all -> 0x0687 }
            r4 = 8
            r0.setVisibility(r4)     // Catch:{ all -> 0x0687 }
        L_0x01db:
            boolean r0 = r11.has(r3)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x01f8
            io.hansel.userjourney.prompts.d.e r0 = r1.o0     // Catch:{ all -> 0x0687 }
            android.view.View r4 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r3 = r11.getJSONObject(r3)     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.w r5 = io.hansel.userjourney.prompts.w.npsInputLabel     // Catch:{ all -> 0x0687 }
            boolean r0 = r0.a(r4, r3, r5)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x01f8
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            goto L_0x0205
        L_0x01f8:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r3 = io.hansel.R.id.npsInputLabel     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r3)     // Catch:{ all -> 0x0687 }
            r3 = 8
            r0.setVisibility(r3)     // Catch:{ all -> 0x0687 }
        L_0x0205:
            boolean r0 = r11.has(r2)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x0222
            io.hansel.userjourney.prompts.d.e r0 = r1.o0     // Catch:{ all -> 0x0687 }
            android.view.View r3 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r2 = r11.getJSONObject(r2)     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.w r4 = io.hansel.userjourney.prompts.w.label5     // Catch:{ all -> 0x0687 }
            boolean r0 = r0.a(r3, r2, r4)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x0222
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            goto L_0x022f
        L_0x0222:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r2 = io.hansel.R.id.label5     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0687 }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
        L_0x022f:
            r0 = r27
            boolean r2 = r11.has(r0)     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x0259
            android.view.View r2 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r0 = r11.getJSONObject(r0)     // Catch:{ all -> 0x0687 }
            boolean r0 = r1.a(r2, r0)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x0259
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            java.util.HashSet<java.lang.String> r0 = t0     // Catch:{ all -> 0x0687 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x0266
            java.util.Set<java.lang.String> r0 = r1.F     // Catch:{ all -> 0x0687 }
            java.lang.String r2 = "prompt_multichoice"
            r0.add(r2)     // Catch:{ all -> 0x0687 }
            goto L_0x0266
        L_0x0259:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r2 = io.hansel.R.id.multichoice     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0687 }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
        L_0x0266:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r2 = io.hansel.R.id.rating_layout     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0687 }
            java.lang.String r2 = "rating"
            boolean r2 = r11.has(r2)     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x0296
            android.view.View r2 = r1.H     // Catch:{ all -> 0x0687 }
            java.lang.String r3 = "rating"
            io.hansel.core.json.CoreJSONObject r3 = r11.getJSONObject(r3)     // Catch:{ all -> 0x0687 }
            boolean r2 = r1.c(r2, r3)     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x0296
            int r2 = r1.W     // Catch:{ all -> 0x0687 }
            int r2 = r2 + 1
            r1.W = r2     // Catch:{ all -> 0x0687 }
            boolean r2 = r1.t     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x029b
            java.util.Set<java.lang.String> r2 = r1.F     // Catch:{ all -> 0x0687 }
            java.lang.String r3 = "prompt_rating"
            r2.add(r3)     // Catch:{ all -> 0x0687 }
            goto L_0x029b
        L_0x0296:
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
        L_0x029b:
            android.view.View r2 = r1.H     // Catch:{ all -> 0x0687 }
            int r3 = io.hansel.R.id.layout_nps     // Catch:{ all -> 0x0687 }
            android.view.View r2 = r2.findViewById(r3)     // Catch:{ all -> 0x0687 }
            java.lang.String r3 = "nps"
            boolean r3 = r11.has(r3)     // Catch:{ all -> 0x0687 }
            if (r3 == 0) goto L_0x02cb
            android.view.View r3 = r1.H     // Catch:{ all -> 0x0687 }
            java.lang.String r4 = "nps"
            io.hansel.core.json.CoreJSONObject r4 = r11.getJSONObject(r4)     // Catch:{ all -> 0x0687 }
            boolean r3 = r1.b(r3, r4)     // Catch:{ all -> 0x0687 }
            if (r3 == 0) goto L_0x02cb
            int r3 = r1.W     // Catch:{ all -> 0x0687 }
            int r3 = r3 + 1
            r1.W = r3     // Catch:{ all -> 0x0687 }
            boolean r3 = r1.t     // Catch:{ all -> 0x0687 }
            if (r3 == 0) goto L_0x02d0
            java.util.Set<java.lang.String> r3 = r1.F     // Catch:{ all -> 0x0687 }
            java.lang.String r4 = "prompt_nps"
            r3.add(r4)     // Catch:{ all -> 0x0687 }
            goto L_0x02d0
        L_0x02cb:
            r3 = 8
            r2.setVisibility(r3)     // Catch:{ all -> 0x0687 }
        L_0x02d0:
            int r2 = r2.getVisibility()     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x02de
            int r0 = r0.getVisibility()     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x02de
            r0 = 1
            goto L_0x02df
        L_0x02de:
            r0 = 0
        L_0x02df:
            r1.v = r0     // Catch:{ all -> 0x0687 }
            java.lang.String r0 = "input1"
            boolean r0 = r11.has(r0)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x030f
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            java.lang.String r2 = "input1"
            io.hansel.core.json.CoreJSONObject r2 = r11.getJSONObject(r2)     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.y r3 = io.hansel.userjourney.prompts.y.input1     // Catch:{ all -> 0x0687 }
            boolean r0 = r1.a(r0, r2, r3)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x030f
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            boolean r0 = r1.v     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x0327
            boolean r0 = r1.t     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x0327
            java.util.Set<java.lang.String> r0 = r1.F     // Catch:{ all -> 0x0687 }
            java.lang.String r2 = "prompt_input1,Input_text1"
            r0.add(r2)     // Catch:{ all -> 0x0687 }
            goto L_0x0327
        L_0x030f:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r2 = io.hansel.R.id.input1     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0687 }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r3 = io.hansel.R.id.input_err1     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r3)     // Catch:{ all -> 0x0687 }
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
        L_0x0327:
            java.lang.String r0 = "input2"
            boolean r0 = r11.has(r0)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x0355
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            java.lang.String r2 = "input2"
            io.hansel.core.json.CoreJSONObject r2 = r11.getJSONObject(r2)     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.y r3 = io.hansel.userjourney.prompts.y.input2     // Catch:{ all -> 0x0687 }
            boolean r0 = r1.a(r0, r2, r3)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x0355
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            boolean r0 = r1.v     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x036d
            boolean r0 = r1.t     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x036d
            java.util.Set<java.lang.String> r0 = r1.F     // Catch:{ all -> 0x0687 }
            java.lang.String r2 = "prompt_input2,Input_text2"
            r0.add(r2)     // Catch:{ all -> 0x0687 }
            goto L_0x036d
        L_0x0355:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r2 = io.hansel.R.id.input2     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0687 }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r3 = io.hansel.R.id.input_err2     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r3)     // Catch:{ all -> 0x0687 }
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
        L_0x036d:
            java.lang.String r0 = "h_card"
            boolean r0 = r11.has(r0)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x038e
            io.hansel.userjourney.prompts.d.c r0 = r1.q0     // Catch:{ all -> 0x0687 }
            android.view.View r2 = r1.H     // Catch:{ all -> 0x0687 }
            java.lang.String r3 = "h_card"
            io.hansel.core.json.CoreJSONObject r3 = r11.getJSONObject(r3)     // Catch:{ all -> 0x0687 }
            int r4 = r1.j     // Catch:{ all -> 0x0687 }
            boolean r0 = r0.a(r2, r3, r4)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x038e
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            goto L_0x039b
        L_0x038e:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r2 = io.hansel.R.id.card_ha     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0687 }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
        L_0x039b:
            java.lang.String r0 = "stepper"
            boolean r0 = r11.has(r0)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x03c3
            io.hansel.userjourney.prompts.d.a r0 = r1.r0     // Catch:{ all -> 0x0687 }
            android.view.View r2 = r1.H     // Catch:{ all -> 0x0687 }
            java.lang.String r3 = "stepper"
            io.hansel.core.json.CoreJSONObject r3 = r11.getJSONObject(r3)     // Catch:{ all -> 0x0687 }
            int r4 = r1.j     // Catch:{ all -> 0x0687 }
            boolean r0 = r0.a(r2, r3, r4)     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x03c3
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            r2 = 1
            int r0 = r0 + r2
            r1.W = r0     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.d.a r0 = r1.r0     // Catch:{ all -> 0x0687 }
            r0.a(r2)     // Catch:{ all -> 0x0687 }
            goto L_0x03d0
        L_0x03c3:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r2 = io.hansel.R.id.stepper     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0687 }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
        L_0x03d0:
            r0 = r19
            boolean r2 = r11.has(r0)     // Catch:{ all -> 0x0687 }
            java.lang.String r3 = "cancel"
            java.lang.String r4 = "actionType"
            if (r2 == 0) goto L_0x0433
            io.hansel.userjourney.prompts.d.a r2 = r1.r0     // Catch:{ all -> 0x0687 }
            android.view.View r5 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r29 = r11.getJSONObject(r0)     // Catch:{ all -> 0x0687 }
            r30 = 1
            io.hansel.segments.c r6 = r1.f5634e     // Catch:{ all -> 0x0687 }
            int r7 = r1.r     // Catch:{ all -> 0x0687 }
            int r8 = r1.j     // Catch:{ all -> 0x0687 }
            int r9 = r1.l     // Catch:{ all -> 0x0687 }
            java.util.List<android.widget.TextView> r10 = r1.A     // Catch:{ all -> 0x0687 }
            java.util.Set<java.lang.String> r12 = r1.F     // Catch:{ all -> 0x0687 }
            java.util.HashMap<java.lang.String, java.lang.Object> r13 = r1.y     // Catch:{ all -> 0x0687 }
            r27 = r2
            r28 = r5
            r31 = r6
            r32 = r7
            r33 = r8
            r34 = r9
            r35 = r10
            r36 = r12
            r37 = r13
            boolean r2 = r27.a(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x0433
            io.hansel.core.json.CoreJSONObject r2 = r11.getJSONObject(r0)     // Catch:{ all -> 0x0687 }
            android.view.View r5 = r1.H     // Catch:{ all -> 0x0687 }
            int r6 = io.hansel.R.id.btn1     // Catch:{ all -> 0x0687 }
            android.view.View r5 = r5.findViewById(r6)     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r0 = r11.getJSONObject(r0)     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r0 = r0.optJSONObject(r14)     // Catch:{ all -> 0x0687 }
            java.lang.String r0 = r0.optString(r4, r3)     // Catch:{ all -> 0x0687 }
            r1.a(r2, r5, r0)     // Catch:{ all -> 0x0687 }
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.d.a r0 = r1.r0     // Catch:{ all -> 0x0687 }
            r0.a()     // Catch:{ all -> 0x0687 }
            goto L_0x044b
        L_0x0433:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r2 = io.hansel.R.id.btn1     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0687 }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r5 = io.hansel.R.id.line_btn1     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ all -> 0x0687 }
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
        L_0x044b:
            r0 = r18
            boolean r2 = r11.has(r0)     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x04aa
            io.hansel.userjourney.prompts.d.a r2 = r1.r0     // Catch:{ all -> 0x0687 }
            android.view.View r5 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r29 = r11.getJSONObject(r0)     // Catch:{ all -> 0x0687 }
            r30 = 2
            io.hansel.segments.c r6 = r1.f5634e     // Catch:{ all -> 0x0687 }
            int r7 = r1.r     // Catch:{ all -> 0x0687 }
            int r8 = r1.j     // Catch:{ all -> 0x0687 }
            int r9 = r1.l     // Catch:{ all -> 0x0687 }
            java.util.List<android.widget.TextView> r10 = r1.A     // Catch:{ all -> 0x0687 }
            java.util.Set<java.lang.String> r12 = r1.F     // Catch:{ all -> 0x0687 }
            java.util.HashMap<java.lang.String, java.lang.Object> r13 = r1.y     // Catch:{ all -> 0x0687 }
            r27 = r2
            r28 = r5
            r31 = r6
            r32 = r7
            r33 = r8
            r34 = r9
            r35 = r10
            r36 = r12
            r37 = r13
            boolean r2 = r27.a(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x04aa
            io.hansel.core.json.CoreJSONObject r2 = r11.getJSONObject(r0)     // Catch:{ all -> 0x0687 }
            android.view.View r5 = r1.H     // Catch:{ all -> 0x0687 }
            int r6 = io.hansel.R.id.btn2     // Catch:{ all -> 0x0687 }
            android.view.View r5 = r5.findViewById(r6)     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r0 = r11.getJSONObject(r0)     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r0 = r0.optJSONObject(r14)     // Catch:{ all -> 0x0687 }
            java.lang.String r0 = r0.optString(r4, r3)     // Catch:{ all -> 0x0687 }
            r1.a(r2, r5, r0)     // Catch:{ all -> 0x0687 }
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.d.a r0 = r1.r0     // Catch:{ all -> 0x0687 }
            r0.a()     // Catch:{ all -> 0x0687 }
            goto L_0x04c2
        L_0x04aa:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r2 = io.hansel.R.id.btn2     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0687 }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r5 = io.hansel.R.id.line_btn1     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ all -> 0x0687 }
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
        L_0x04c2:
            r0 = r17
            boolean r2 = r11.has(r0)     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x0521
            io.hansel.userjourney.prompts.d.a r2 = r1.r0     // Catch:{ all -> 0x0687 }
            android.view.View r5 = r1.H     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r29 = r11.getJSONObject(r0)     // Catch:{ all -> 0x0687 }
            r30 = 3
            io.hansel.segments.c r6 = r1.f5634e     // Catch:{ all -> 0x0687 }
            int r7 = r1.r     // Catch:{ all -> 0x0687 }
            int r8 = r1.j     // Catch:{ all -> 0x0687 }
            int r9 = r1.l     // Catch:{ all -> 0x0687 }
            java.util.List<android.widget.TextView> r10 = r1.A     // Catch:{ all -> 0x0687 }
            java.util.Set<java.lang.String> r12 = r1.F     // Catch:{ all -> 0x0687 }
            java.util.HashMap<java.lang.String, java.lang.Object> r13 = r1.y     // Catch:{ all -> 0x0687 }
            r27 = r2
            r28 = r5
            r31 = r6
            r32 = r7
            r33 = r8
            r34 = r9
            r35 = r10
            r36 = r12
            r37 = r13
            boolean r2 = r27.a(r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x0521
            io.hansel.core.json.CoreJSONObject r2 = r11.getJSONObject(r0)     // Catch:{ all -> 0x0687 }
            android.view.View r5 = r1.H     // Catch:{ all -> 0x0687 }
            int r6 = io.hansel.R.id.btn3     // Catch:{ all -> 0x0687 }
            android.view.View r5 = r5.findViewById(r6)     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r0 = r11.getJSONObject(r0)     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r0 = r0.optJSONObject(r14)     // Catch:{ all -> 0x0687 }
            java.lang.String r0 = r0.optString(r4, r3)     // Catch:{ all -> 0x0687 }
            r1.a(r2, r5, r0)     // Catch:{ all -> 0x0687 }
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            int r0 = r0 + 1
            r1.W = r0     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.d.a r0 = r1.r0     // Catch:{ all -> 0x0687 }
            r0.a()     // Catch:{ all -> 0x0687 }
            goto L_0x0539
        L_0x0521:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r2 = io.hansel.R.id.btn3     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0687 }
            r2 = 8
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r5 = io.hansel.R.id.line_btn2     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ all -> 0x0687 }
            r0.setVisibility(r2)     // Catch:{ all -> 0x0687 }
        L_0x0539:
            r0 = r16
            boolean r2 = r11.has(r0)     // Catch:{ all -> 0x0687 }
            if (r2 != 0) goto L_0x0554
            java.lang.String r2 = "btnX"
            boolean r2 = r11.has(r2)     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x054a
            goto L_0x0554
        L_0x054a:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r2 = io.hansel.R.id.container_btnX     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ all -> 0x0687 }
            r2 = 1
            goto L_0x05b0
        L_0x0554:
            boolean r2 = r11.has(r0)     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x055b
            goto L_0x055d
        L_0x055b:
            java.lang.String r0 = "btnX"
        L_0x055d:
            io.hansel.core.json.CoreJSONObject r0 = r11.getJSONObject(r0)     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.d.a r15 = r1.r0     // Catch:{ all -> 0x0687 }
            android.view.View r2 = r1.H     // Catch:{ all -> 0x0687 }
            r18 = -1
            io.hansel.segments.c r5 = r1.f5634e     // Catch:{ all -> 0x0687 }
            int r6 = r1.r     // Catch:{ all -> 0x0687 }
            int r7 = r1.j     // Catch:{ all -> 0x0687 }
            int r8 = r1.l     // Catch:{ all -> 0x0687 }
            java.util.List<android.widget.TextView> r9 = r1.A     // Catch:{ all -> 0x0687 }
            java.util.Set<java.lang.String> r10 = r1.F     // Catch:{ all -> 0x0687 }
            java.util.HashMap<java.lang.String, java.lang.Object> r11 = r1.y     // Catch:{ all -> 0x0687 }
            r16 = r2
            r17 = r0
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            boolean r2 = r15.a(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x0687 }
            if (r2 == 0) goto L_0x05a7
            android.view.View r2 = r1.H     // Catch:{ all -> 0x0687 }
            int r5 = io.hansel.R.id.btnX     // Catch:{ all -> 0x0687 }
            android.view.View r2 = r2.findViewById(r5)     // Catch:{ all -> 0x0687 }
            io.hansel.core.json.CoreJSONObject r5 = r0.optJSONObject(r14)     // Catch:{ all -> 0x0687 }
            java.lang.String r3 = r5.optString(r4, r3)     // Catch:{ all -> 0x0687 }
            r1.a(r0, r2, r3)     // Catch:{ all -> 0x0687 }
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            r2 = 1
            int r0 = r0 + r2
            r1.W = r0     // Catch:{ all -> 0x0687 }
            goto L_0x05b5
        L_0x05a7:
            r2 = 1
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r3 = io.hansel.R.id.container_btnX     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r3)     // Catch:{ all -> 0x0687 }
        L_0x05b0:
            r3 = 8
            r0.setVisibility(r3)     // Catch:{ all -> 0x0687 }
        L_0x05b5:
            io.hansel.userjourney.prompts.d.a r0 = r1.r0     // Catch:{ all -> 0x0687 }
            int r0 = r0.b()     // Catch:{ all -> 0x0687 }
            if (r0 != 0) goto L_0x05cd
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r3 = io.hansel.R.id.layout_bottom_btn     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r3)     // Catch:{ all -> 0x0687 }
            r3 = 8
            r0.setVisibility(r3)     // Catch:{ all -> 0x0687 }
            r0 = 0
            r1.s = r0     // Catch:{ all -> 0x0687 }
        L_0x05cd:
            int r0 = r1.W     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x05eb
            io.hansel.userjourney.prompts.k r0 = r1.E     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.l r0 = r0.F()     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.l r3 = io.hansel.userjourney.prompts.l.HOTSPOT     // Catch:{ all -> 0x0687 }
            if (r0 != r3) goto L_0x05e6
            io.hansel.userjourney.prompts.i r0 = r1.V     // Catch:{ all -> 0x0687 }
            if (r0 == 0) goto L_0x05e6
            boolean r0 = r0.b()     // Catch:{ all -> 0x0687 }
            if (r0 != 0) goto L_0x05e6
            goto L_0x05eb
        L_0x05e6:
            r38.v()     // Catch:{ all -> 0x0687 }
            goto L_0x067b
        L_0x05eb:
            java.lang.String r0 = "OnCreateView method reached where callout is not visible."
            r3 = r26
            io.hansel.core.logger.HSLLogger.d(r0, r3)     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.k r0 = r1.E     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.l r0 = r0.F()     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.l r3 = io.hansel.userjourney.prompts.l.HOTSPOT     // Catch:{ all -> 0x0687 }
            if (r0 == r3) goto L_0x060a
            io.hansel.userjourney.prompts.k r0 = r1.E     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.l r0 = r0.F()     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.l r4 = io.hansel.userjourney.prompts.l.SPOTLIGHT     // Catch:{ all -> 0x0687 }
            if (r0 != r4) goto L_0x0607
            goto L_0x060a
        L_0x0607:
            java.lang.String r0 = "onPromptDismiss->No elements to dismiss"
            goto L_0x0677
        L_0x060a:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r4 = io.hansel.R.id.p_shadow_container     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r4)     // Catch:{ all -> 0x0687 }
            r4 = 8
            r0.setVisibility(r4)     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r5 = io.hansel.R.id.iv_arrow_top     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ all -> 0x0687 }
            r0.setVisibility(r4)     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            int r5 = io.hansel.R.id.iv_arrow_bottom     // Catch:{ all -> 0x0687 }
            android.view.View r0 = r0.findViewById(r5)     // Catch:{ all -> 0x0687 }
            r0.setVisibility(r4)     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.k r0 = r1.E     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.d0 r0 = r0.y()     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.d0 r4 = io.hansel.userjourney.prompts.d0.TOP     // Catch:{ all -> 0x0687 }
            if (r0 != r4) goto L_0x067b
            io.hansel.userjourney.prompts.k r0 = r1.E     // Catch:{ all -> 0x0687 }
            io.hansel.userjourney.prompts.l r0 = r0.F()     // Catch:{ all -> 0x0687 }
            if (r0 != r3) goto L_0x067b
            io.hansel.userjourney.prompts.k r0 = r1.E     // Catch:{ all -> 0x0687 }
            int r0 = r0.x()     // Catch:{ all -> 0x0687 }
            r3 = 12
            int r3 = io.hansel.core.utils.HSLUtils.dpToPx(r3)     // Catch:{ all -> 0x0687 }
            int r0 = r0 + r3
            io.hansel.userjourney.prompts.k r3 = r1.E     // Catch:{ all -> 0x0687 }
            r3.g(r0)     // Catch:{ all -> 0x0687 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0687 }
            r3.<init>()     // Catch:{ all -> 0x0687 }
            java.lang.String r4 = "margin issue promptOriginY at 517 is "
            r3.append(r4)     // Catch:{ all -> 0x0687 }
            r3.append(r0)     // Catch:{ all -> 0x0687 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0687 }
            io.hansel.core.logger.HSLLogger.d(r3)     // Catch:{ all -> 0x0687 }
            android.widget.RelativeLayout r3 = r1.J     // Catch:{ all -> 0x0687 }
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()     // Catch:{ all -> 0x0687 }
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3     // Catch:{ all -> 0x0687 }
            r3.topMargin = r0     // Catch:{ all -> 0x0687 }
            android.widget.RelativeLayout r0 = r1.J     // Catch:{ all -> 0x0687 }
            r0.setLayoutParams(r3)     // Catch:{ all -> 0x0687 }
            goto L_0x067b
        L_0x0675:
            java.lang.String r0 = "onPromptDismiss-> Invalid prompt"
        L_0x0677:
            r1.a(r0)     // Catch:{ all -> 0x0687 }
            r2 = 0
        L_0x067b:
            android.view.View r0 = r1.H     // Catch:{ all -> 0x0687 }
            android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()     // Catch:{ all -> 0x0687 }
            android.view.ViewTreeObserver$OnGlobalLayoutListener r3 = r1.s0     // Catch:{ all -> 0x0687 }
            r0.addOnGlobalLayoutListener(r3)     // Catch:{ all -> 0x0687 }
            goto L_0x0694
        L_0x0687:
            r0 = move-exception
            java.lang.String r2 = "CreateView"
            r1.a(r0, r2)
            goto L_0x0693
        L_0x068e:
            java.lang.String r0 = "onPromptDismiss-> No trigger json"
            r1.a(r0)
        L_0x0693:
            r2 = 0
        L_0x0694:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            android.view.View r2 = r1.H
            android.util.Pair r0 = android.util.Pair.create(r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r.a(android.view.LayoutInflater, android.view.ViewGroup):android.util.Pair");
    }

    public d0 a(int i2, int i3) {
        return i2 > i3 ? d0.TOP : d0.BOTTOM;
    }

    public void a() {
        this.E.O();
        try {
            LogGroup logGroup = LogGroup.PT;
            HSLLogger.d("Update Prompt position.", logGroup);
            if (!this.E.H()) {
                HSLLogger.d("Anchor point is not visible in updatePromptPosition", logGroup);
                a((String) "prompt_screen_nav,Nudge_screen_nav", (String) null, true);
            } else if (this.E.a()) {
                t();
            }
        } catch (Throwable th) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception caught in updatePromptPosition for promptid ");
            outline73.append(this.M);
            HSLLogger.d(outline73.toString(), LogGroup.PT);
            HSLLogger.printStackTrace(th);
            a((String) "onPromptDismiss-> Failed on update.");
        }
    }

    public void a(int i2) {
        StringBuilder sb;
        int i3;
        FrameLayout frameLayout = (FrameLayout) this.H.findViewById(R.id.p_shadow_container);
        if (i2 > 0) {
            LayoutParams layoutParams = new LayoutParams(this.L);
            c0 c0Var = this.R;
            if (c0Var == c0.TOP) {
                HSLLogger.d("SoftKeyboardListener: Vertical margin type is TOP");
                int a2 = this.E.A().a();
                StringBuilder outline74 = GeneratedOutlineSupport.outline74("SoftKeyboardListener: Window height is ", a2, " and topMargin is ");
                outline74.append(layoutParams.topMargin);
                outline74.append(" and Height is ");
                outline74.append(layoutParams.height);
                HSLLogger.d(outline74.toString());
                int i4 = ((a2 - layoutParams.topMargin) - layoutParams.height) - i2;
                HSLLogger.d("SoftKeyboardListener: Keyboard height is " + i2 + " difference is " + i4);
                if (i4 < 0) {
                    layoutParams.topMargin += i4;
                }
                sb = GeneratedOutlineSupport.outline73("SoftKeyboardListener: Final topMargin is ");
                i3 = layoutParams.topMargin;
            } else {
                if (c0Var == c0.CENTER) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("SoftKeyboardListener: Vertical margin type is CENTER and bottomMargin is ");
                    outline73.append(layoutParams.bottomMargin);
                    HSLLogger.d(outline73.toString());
                    layoutParams.bottomMargin += i2;
                    sb = new StringBuilder();
                } else {
                    if (c0Var == c0.BOTTOM) {
                        HSLLogger.d("SoftKeyboardListener: Vertical margin type is BOTTOM");
                        HSLLogger.d("SoftKeyboardListener: layoutParams.bottomMargin is " + layoutParams.bottomMargin + " keyboard height is " + i2);
                        layoutParams.bottomMargin = layoutParams.bottomMargin + i2;
                        sb = new StringBuilder();
                    }
                    frameLayout.setLayoutParams(layoutParams);
                    return;
                }
                sb.append("SoftKeyboardListener: Final bottom margin is ");
                i3 = layoutParams.bottomMargin;
            }
            sb.append(i3);
            HSLLogger.d(sb.toString());
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        frameLayout.setLayoutParams(this.L);
    }

    public void a(Activity activity) {
        this.h0 = activity;
        this.f5635f = activity;
        io.hansel.userjourney.prompts.d.e eVar = new io.hansel.userjourney.prompts.d.e(activity, this.f5634e);
        this.o0 = eVar;
        io.hansel.userjourney.prompts.d.d dVar = new io.hansel.userjourney.prompts.d.d(activity);
        this.p0 = dVar;
        this.q0 = new io.hansel.userjourney.prompts.d.c(activity, eVar, dVar);
        this.r0 = new io.hansel.userjourney.prompts.d.a(activity, this.S);
    }

    public void a(CoreJSONObject coreJSONObject, k kVar) {
        if (coreJSONObject.has("nudge_props")) {
            CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("nudge_props");
            String optString = optJSONObject.optString("spotlightArrowColor", null);
            this.Y = optString != null ? Color.parseColor(optString) : -1;
            this.a0 = optJSONObject.optBoolean("showSpotlightArrow", true);
            this.b0 = optJSONObject.optBoolean("showSpotlightAnimation", false);
            this.g = optJSONObject.optString("spotlightPointerType", z.ARROW.f5721a);
        }
        this.E = kVar;
    }

    public void a(io.hansel.segments.b bVar, io.hansel.segments.c cVar) {
        this.f5633d = bVar;
        this.f5634e = cVar;
    }

    public void a(String str, String str2, boolean z2) {
        StringBuilder sb;
        try {
            this.I.removeCallbacks(this.j0);
            Boolean bool = this.N;
            if (bool == null || !bool.booleanValue()) {
                LogGroup logGroup = LogGroup.PT;
                HSLLogger.d("onPromptDismiss method invoked. " + this.M + " with timestamp " + this.O, logGroup);
                HSLLogger.d("onPromptDismiss method: show next nudge is " + z2 + " for promptId " + this.M + " with timestamp " + this.O, logGroup);
                if (str == null) {
                    sb = new StringBuilder();
                    sb.append("onPromptDismiss method: dismissType is null for prompt");
                    sb.append(this.M);
                    sb.append(" with timestamp ");
                    sb.append(this.O);
                } else {
                    sb = new StringBuilder();
                    sb.append("onPromptDismiss method: dismissType is ");
                    sb.append(str);
                    sb.append(" for prompt");
                    sb.append(this.M);
                    sb.append(" with timestamp ");
                    sb.append(this.O);
                }
                HSLLogger.d(sb.toString(), logGroup);
                this.C = str2;
                boolean z3 = !"rotate".equals(str);
                if (!(str == null || this.w == null)) {
                    String[] split = str.split(",");
                    this.w.remove("rotate");
                    this.w.put(split[0], BaseParser.TRUE);
                    if (split.length > 1) {
                        this.y.put(split[1], BaseParser.TRUE);
                    }
                    if (str2 != null) {
                        this.w.put("type", str2);
                        this.w.put("action", "click");
                    }
                    String str3 = this.D;
                    if (str3 != null) {
                        this.w.put("signal_prompt", str3);
                    }
                    this.Q = (this.Q + System.currentTimeMillis()) - this.P;
                    this.w.put("time_spent", "" + this.Q);
                    this.y.put("Time_spent_nudge", "" + this.Q);
                }
                if (z3) {
                    if (this.K != null) {
                        this.H.getViewTreeObserver().removeOnGlobalLayoutListener(this.K);
                        this.K = null;
                    }
                    m0 m0Var = this.d0;
                    if (m0Var != null) {
                        m0Var.c();
                    }
                    View view = this.H;
                    if (view != null) {
                        ViewParent parent = view.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(this.H);
                        }
                    }
                    q0 q0Var = this.i0;
                    if (q0Var != null) {
                        q0Var.getFragmentManager().beginTransaction().remove(this.i0).commitAllowingStateLoss();
                    }
                    if (this.f5633d != null) {
                        if (str == null || o()) {
                            HSLLogger.d("onPromptDismiss method: invoking onDialogError" + this.M + " with timestamp " + this.O, logGroup);
                            this.f5633d.a(z2, this);
                        } else {
                            HSLLogger.d("onPromptDismiss method: invoking onDialogResult" + this.M + " with timestamp " + this.O, logGroup);
                            this.f5633d.a(this.w, this.y, z2, this);
                        }
                    }
                }
                this.N = Boolean.TRUE;
            }
        } catch (Throwable th) {
            HSLLogger.printStackTrace(th);
        }
    }

    public void a(HashMap<String, String> hashMap, HashMap<String, Object> hashMap2, HashMap<String, Object> hashMap3, HashMap<String, Object> hashMap4) {
        this.x = hashMap;
        this.w = hashMap2;
        this.y = hashMap4;
        this.z = hashMap3;
    }

    public void a(String[] strArr) {
        int i2;
        View view;
        ImageView imageView = (ImageView) this.H.findViewById(R.id.img1);
        Object tag = imageView.getTag();
        if (tag == null) {
            imageView = (ImageView) this.H.findViewById(R.id.img_h_left);
            tag = imageView.getTag();
            if (tag == null) {
                imageView = (ImageView) this.H.findViewById(R.id.img_h_right);
                tag = imageView.getTag();
                if (tag != null) {
                    view = this.H;
                    i2 = R.id.img_h_spinner_right;
                } else {
                    return;
                }
            } else {
                view = this.H;
                i2 = R.id.img_h_spinner_left;
            }
        } else {
            view = this.H;
            i2 = R.id.img1_spinner;
        }
        ProgressBar progressBar = (ProgressBar) view.findViewById(i2);
        String[] split = tag.toString().split("::::_");
        if (strArr[0].split("\\.")[0].equals(split[1].replace("_hsl_img: ", ""))) {
            io.hansel.userjourney.n.a(strArr[1], Integer.parseInt(split[0].replace("_hsl_width: ", "")), imageView);
        }
        progressBar.setVisibility(8);
    }

    public d0 b(int i2, int i3, int i4) {
        return i2 + i3 < i4 ? d0.BOTTOM : d0.TOP;
    }

    public String b() {
        return this.M;
    }

    public int c(int i2, int i3, int i4) {
        int i5 = (i2 + i3) / 2;
        return i4 > i5 ? i4 - ((i4 - i5) * 2) : ((i5 - i4) * 2) + i4;
    }

    public void f() {
        t0.clear();
        u0.clear();
    }

    public k i() {
        return this.E;
    }

    public HashMap<String, Object> j() {
        return this.w;
    }

    public HashMap<String, Object> k() {
        return this.y;
    }

    public void m() {
        Boolean bool = this.N;
        if (bool != null && !bool.booleanValue() && this.E.A() != null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("React check: Prompt dismiss is not tracked. ");
            outline73.append(this.M);
            outline73.append(" with timestamp ");
            outline73.append(this.O);
            HSLLogger.d(outline73.toString(), LogGroup.PT);
            a((String) "prompt_screen_nav,Nudge_screen_nav", (String) null, true);
        }
    }

    public void p() {
        HSLLogger.d("onBackPressed method invoked.");
        a((String) "prompt_screen_nav,Nudge_screen_nav", (String) null, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r() {
        /*
            r26 = this;
            r0 = r26
            android.view.View r1 = r0.H
            int r2 = io.hansel.R.id.btn1
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.view.View r2 = r0.H
            int r3 = io.hansel.R.id.btn2
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.view.View r3 = r0.H
            int r4 = io.hansel.R.id.btn3
            android.view.View r3 = r3.findViewById(r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.view.View r4 = r0.H
            int r5 = io.hansel.R.id.content_scroll
            android.view.View r4 = r4.findViewById(r5)
            android.widget.ScrollView r4 = (android.widget.ScrollView) r4
            r5 = 0
            int r5 = io.hansel.core.utils.HSLUtils.dpToPx(r5)
            io.hansel.userjourney.prompts.d.a r6 = r0.r0
            int r6 = r6.c()
            int r7 = r0.s
            int r6 = r6 + r7
            java.lang.String r7 = "shadow issue bottomBtnLayoutMargin in positionNudge is "
            java.lang.StringBuilder r7 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r7)
            int r8 = r0.s
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            io.hansel.core.logger.HSLLogger.d(r7)
            int r1 = r1.getVisibility()
            r7 = 0
            if (r1 == 0) goto L_0x005d
            int r1 = r2.getVisibility()
            if (r1 == 0) goto L_0x005d
            int r1 = r3.getVisibility()
            if (r1 != 0) goto L_0x0069
        L_0x005d:
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            r1.setMargins(r7, r7, r7, r6)
            r4.setLayoutParams(r1)
        L_0x0069:
            android.view.View r1 = r0.H
            int r2 = io.hansel.R.id.p_shadow_container
            android.view.View r1 = r1.findViewById(r2)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            int r2 = r1.getVisibility()
            r3 = 1
            if (r2 != 0) goto L_0x0110
            int r2 = r4.getMeasuredHeight()
            if (r2 != 0) goto L_0x009e
            int r4 = r0.W
            if (r4 <= 0) goto L_0x009e
            java.lang.String r4 = "The scrollHeight is 0 for nudge "
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            java.lang.String r8 = r26.b()
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            io.hansel.core.logger.HSLLogger.d(r4)
            r4 = 0
            java.lang.String r8 = "prompt_screen_nav,Nudge_screen_nav"
            r0.a(r8, r4, r3)
        L_0x009e:
            android.view.View r4 = r0.H
            int r8 = io.hansel.R.id.container_btnX
            android.view.View r4 = r4.findViewById(r8)
            android.view.ViewGroup$LayoutParams r8 = r4.getLayoutParams()
            int r9 = r8.height
            if (r9 <= r2) goto L_0x00b0
            r8.height = r2
        L_0x00b0:
            r4.setLayoutParams(r8)
            if (r6 <= 0) goto L_0x00b8
            int r4 = r2 + r6
            goto L_0x00b9
        L_0x00b8:
            r4 = r2
        L_0x00b9:
            java.lang.String r8 = "shadow issue Container height in line 2528 is "
            java.lang.String r9 = " scrollHeight is "
            java.lang.String r10 = " bottomBtnLayoutHeight "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline75(r8, r4, r9, r2, r10)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            io.hansel.core.logger.HSLLogger.d(r2)
            int r2 = r0.i
            io.hansel.userjourney.prompts.k r6 = r0.E
            io.hansel.userjourney.prompts.d0 r6 = r6.y()
            io.hansel.userjourney.prompts.d0 r8 = io.hansel.userjourney.prompts.d0.TOP
            if (r6 != r8) goto L_0x00e7
            io.hansel.userjourney.prompts.k r6 = r0.E
            int r6 = r6.e()
            if (r2 <= r6) goto L_0x00e7
            io.hansel.userjourney.prompts.k r2 = r0.E
            int r2 = r2.e()
        L_0x00e7:
            if (r4 <= r2) goto L_0x0111
            io.hansel.userjourney.prompts.k r6 = r0.E
            boolean r6 = r6.L()
            if (r6 != 0) goto L_0x0111
            android.view.ViewGroup$LayoutParams r4 = r1.getLayoutParams()
            r4.height = r2
            r1.setLayoutParams(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "Container height in line 2539 is "
            r4.append(r6)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            io.hansel.core.logger.HSLLogger.d(r4)
            r4 = r2
            goto L_0x0111
        L_0x0110:
            r4 = 0
        L_0x0111:
            r2 = 2
            int r6 = io.hansel.core.utils.HSLUtils.dpToPx(r2)
            io.hansel.userjourney.prompts.k r8 = r0.E
            io.hansel.userjourney.prompts.d0 r8 = r8.y()
            io.hansel.userjourney.prompts.d0 r9 = io.hansel.userjourney.prompts.d0.TOP
            java.lang.String r10 = "Container height in line 2552 is "
            java.lang.String r11 = "Container height in line 2557 is "
            r12 = 10
            java.lang.String r13 = "margin issue promptOriginY at 2574 is "
            if (r8 != r9) goto L_0x01f5
            android.widget.RelativeLayout r8 = r0.J
            android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r8 = (android.widget.FrameLayout.LayoutParams) r8
            io.hansel.userjourney.prompts.k r9 = r0.E
            int r9 = r9.k()
            io.hansel.userjourney.prompts.k r14 = r0.E
            io.hansel.userjourney.prompts.l r14 = r14.F()
            io.hansel.userjourney.prompts.l r15 = io.hansel.userjourney.prompts.l.TAG
            if (r14 != r15) goto L_0x0169
            io.hansel.userjourney.prompts.k r14 = r0.E
            io.hansel.userjourney.prompts.n0 r14 = r14.D()
            io.hansel.userjourney.prompts.n0 r15 = io.hansel.userjourney.prompts.n0.INSIDE_VIEW
            if (r14 != r15) goto L_0x0152
            io.hansel.userjourney.prompts.k r9 = r0.E
            int r9 = r9.x()
            int r9 = r9 + r5
            goto L_0x017f
        L_0x0152:
            io.hansel.userjourney.prompts.k r14 = r0.E
            io.hansel.userjourney.prompts.n0 r14 = r14.D()
            io.hansel.userjourney.prompts.n0 r15 = io.hansel.userjourney.prompts.n0.ALIGN_WITH_VIEW
            if (r14 != r15) goto L_0x0167
            io.hansel.userjourney.prompts.k r5 = r0.E
            int r5 = r5.x()
            int r9 = r4 / 2
            int r9 = r5 - r9
            goto L_0x017f
        L_0x0167:
            int r9 = r9 - r4
            goto L_0x017e
        L_0x0169:
            io.hansel.userjourney.prompts.k r5 = r0.E
            int r5 = r5.x()
            int r9 = r5 - r4
            int r5 = io.hansel.core.utils.HSLUtils.dpToPx(r12)
            boolean r14 = r0.a0
            if (r14 != 0) goto L_0x017f
            int r14 = r0.X
            int r9 = r9 + r14
            int r5 = r5 * 2
        L_0x017e:
            int r9 = r9 - r5
        L_0x017f:
            if (r9 >= 0) goto L_0x01d5
            io.hansel.userjourney.prompts.k r5 = r0.E
            boolean r5 = r5.L()
            if (r5 != 0) goto L_0x01d5
            io.hansel.userjourney.prompts.k r5 = r0.E
            io.hansel.userjourney.prompts.l r5 = r5.F()
            io.hansel.userjourney.prompts.l r14 = io.hansel.userjourney.prompts.l.SPOTLIGHT
            if (r5 != r14) goto L_0x01b4
            io.hansel.userjourney.prompts.k r5 = r0.E
            io.hansel.userjourney.prompts.j0 r5 = r5.A()
            int r5 = r5.a()
            int r5 = r5 / r2
            if (r4 <= r5) goto L_0x01cb
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            io.hansel.core.logger.HSLLogger.d(r2)
            r4 = r5
            goto L_0x01cb
        L_0x01b4:
            r2 = 6
            int r4 = com.android.tools.r8.GeneratedOutlineSupport.outline7(r6, r2, r9, r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            io.hansel.core.logger.HSLLogger.d(r2)
        L_0x01cb:
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            r2.height = r4
            r1.setLayoutParams(r2)
            r9 = 0
        L_0x01d5:
            r8.topMargin = r9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r13)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            io.hansel.core.logger.HSLLogger.d(r1)
            io.hansel.userjourney.prompts.k r1 = r0.E
            r1.g(r9)
            android.widget.RelativeLayout r1 = r0.J
            r1.setLayoutParams(r8)
            goto L_0x034c
        L_0x01f5:
            io.hansel.userjourney.prompts.k r8 = r0.E
            io.hansel.userjourney.prompts.d0 r8 = r8.y()
            io.hansel.userjourney.prompts.d0 r9 = io.hansel.userjourney.prompts.d0.AUTO
            if (r8 != r9) goto L_0x027e
            android.widget.RelativeLayout r5 = r0.J
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r5 = (android.widget.FrameLayout.LayoutParams) r5
            io.hansel.userjourney.prompts.k r8 = r0.E
            int r8 = r8.x()
            int r9 = r4 / 2
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x025e
            io.hansel.userjourney.prompts.k r9 = r0.E
            io.hansel.userjourney.prompts.l r9 = r9.F()
            io.hansel.userjourney.prompts.l r14 = io.hansel.userjourney.prompts.l.SPOTLIGHT
            if (r9 != r14) goto L_0x023d
            io.hansel.userjourney.prompts.k r8 = r0.E
            io.hansel.userjourney.prompts.j0 r8 = r8.A()
            int r8 = r8.a()
            int r8 = r8 / r2
            if (r4 <= r8) goto L_0x0254
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            io.hansel.core.logger.HSLLogger.d(r2)
            r4 = r8
            goto L_0x0254
        L_0x023d:
            r2 = 6
            int r4 = com.android.tools.r8.GeneratedOutlineSupport.outline7(r6, r2, r8, r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            io.hansel.core.logger.HSLLogger.d(r2)
        L_0x0254:
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            r2.height = r4
            r1.setLayoutParams(r2)
            r8 = 0
        L_0x025e:
            r5.topMargin = r8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r13)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            io.hansel.core.logger.HSLLogger.d(r1)
            io.hansel.userjourney.prompts.k r1 = r0.E
            r1.g(r8)
            android.widget.RelativeLayout r1 = r0.J
            r1.setLayoutParams(r5)
            goto L_0x034c
        L_0x027e:
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.d0 r2 = r2.y()
            io.hansel.userjourney.prompts.d0 r8 = io.hansel.userjourney.prompts.d0.BOTTOM
            if (r2 != r8) goto L_0x034c
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.l r2 = r2.F()
            io.hansel.userjourney.prompts.l r8 = io.hansel.userjourney.prompts.l.SPOTLIGHT
            if (r2 != r8) goto L_0x02f3
            android.widget.RelativeLayout r2 = r0.J
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            io.hansel.userjourney.prompts.k r5 = r0.E
            int r5 = r5.x()
            io.hansel.userjourney.prompts.k r8 = r0.E
            io.hansel.userjourney.prompts.j0 r8 = r8.A()
            int r8 = r8.a()
            int r9 = r5 + r4
            if (r9 <= r8) goto L_0x02d4
            int r5 = r8 / 2
            if (r4 <= r5) goto L_0x02c7
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r9 = "Container height in line 2576 is "
            r4.append(r9)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            io.hansel.core.logger.HSLLogger.d(r4)
            r4 = r5
        L_0x02c7:
            android.view.ViewGroup$LayoutParams r5 = r1.getLayoutParams()
            r5.height = r4
            r1.setLayoutParams(r5)
            int r5 = r8 - r4
            r2.topMargin = r5
        L_0x02d4:
            io.hansel.userjourney.prompts.k r1 = r0.E
            r1.g(r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r8 = "margin issue promptOriginY at 2596 is "
            r1.append(r8)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            io.hansel.core.logger.HSLLogger.d(r1)
            android.widget.RelativeLayout r1 = r0.J
            r1.setLayoutParams(r2)
            goto L_0x034c
        L_0x02f3:
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.l r1 = r1.F()
            io.hansel.userjourney.prompts.l r2 = io.hansel.userjourney.prompts.l.TAG
            if (r1 != r2) goto L_0x034c
            android.widget.RelativeLayout r1 = r0.J
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
            io.hansel.userjourney.prompts.k r2 = r0.E
            int r2 = r2.k()
            io.hansel.userjourney.prompts.k r8 = r0.E
            int r8 = r8.h()
            int r8 = r8 + r2
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.n0 r2 = r2.D()
            io.hansel.userjourney.prompts.n0 r9 = io.hansel.userjourney.prompts.n0.INSIDE_VIEW
            if (r2 != r9) goto L_0x031f
            int r8 = r8 - r4
            int r8 = r8 - r5
            goto L_0x032e
        L_0x031f:
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.n0 r2 = r2.D()
            io.hansel.userjourney.prompts.n0 r9 = io.hansel.userjourney.prompts.n0.ALIGN_WITH_VIEW
            if (r2 != r9) goto L_0x032d
            int r2 = r4 / 2
            int r8 = r8 - r2
            goto L_0x032e
        L_0x032d:
            int r8 = r8 + r5
        L_0x032e:
            r1.topMargin = r8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r13)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            io.hansel.core.logger.HSLLogger.d(r2)
            io.hansel.userjourney.prompts.k r2 = r0.E
            r2.g(r8)
            android.widget.RelativeLayout r2 = r0.J
            r2.setLayoutParams(r1)
        L_0x034c:
            io.hansel.userjourney.prompts.k r1 = r0.E
            boolean r1 = r1.L()
            if (r1 == 0) goto L_0x0391
            io.hansel.userjourney.prompts.k r1 = r0.E
            int r1 = r1.w()
            android.widget.RelativeLayout r2 = r0.J
            r2.measure(r7, r7)
            android.widget.RelativeLayout r2 = r0.J
            int r2 = r2.getMeasuredWidth()
            int r1 = r1 + r2
            io.hansel.userjourney.prompts.k r5 = r0.E
            io.hansel.userjourney.prompts.j0 r5 = r5.A()
            int r5 = r5.d()
            if (r1 <= r5) goto L_0x0391
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.j0 r1 = r1.A()
            int r1 = r1.d()
            int r1 = r1 - r2
            io.hansel.userjourney.prompts.k r2 = r0.E
            r2.f(r1)
            android.widget.RelativeLayout r2 = r0.J
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            r2.leftMargin = r1
            android.widget.RelativeLayout r1 = r0.J
            r1.setLayoutParams(r2)
        L_0x0391:
            android.view.View r1 = r0.H
            int r2 = io.hansel.R.id.prompt_shadow
            android.view.View r1 = r1.findViewById(r2)
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
            int r5 = r6 * 3
            int r5 = r5 + r4
            r2.height = r5
            r1.setLayoutParams(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "Container height in line 2592 is "
            r1.append(r5)
            r1.append(r4)
            java.lang.String r5 = " and size of shadow is "
            r1.append(r5)
            r1.append(r6)
            java.lang.String r5 = " and height of shadow view is "
            r1.append(r5)
            int r2 = r2.height
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            io.hansel.core.logger.LogGroup r2 = io.hansel.core.logger.LogGroup.PT
            io.hansel.core.logger.HSLLogger.d(r1, r2)
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.l r1 = r1.F()
            io.hansel.userjourney.prompts.l r2 = io.hansel.userjourney.prompts.l.SPOTLIGHT
            if (r1 != r2) goto L_0x044a
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.core.json.CoreJSONObject r1 = r1.r()
            if (r1 == 0) goto L_0x044a
            io.hansel.userjourney.prompts.k r1 = r0.E
            int r1 = r1.i()
            io.hansel.userjourney.prompts.k r5 = r0.E
            int r5 = r5.h()
            io.hansel.userjourney.prompts.k r6 = r0.E
            int r6 = r6.j()
            io.hansel.userjourney.prompts.k r8 = r0.E
            int r8 = r8.k()
            io.hansel.userjourney.prompts.k r9 = r0.E
            int r17 = r9.l()
            io.hansel.userjourney.prompts.k r9 = r0.E
            io.hansel.userjourney.prompts.p r15 = r9.C()
            io.hansel.userjourney.prompts.k r9 = r0.E
            io.hansel.userjourney.prompts.o r16 = r9.B()
            android.view.View r9 = r0.H
            int r10 = io.hansel.R.id.view_opaque
            android.view.View r9 = r9.findViewById(r10)
            r14 = r9
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            android.content.Context r9 = r0.f5635f
            android.content.res.Resources r13 = r9.getResources()
            int r20 = io.hansel.core.utils.HSLUtils.dpToPx(r12)
            io.hansel.userjourney.prompts.k r9 = r0.E
            io.hansel.userjourney.prompts.j0 r9 = r9.A()
            int r23 = r9.d()
            io.hansel.userjourney.prompts.k r9 = r0.E
            io.hansel.userjourney.prompts.j0 r9 = r9.A()
            int r24 = r9.c()
            int r25 = r26.h()
            r18 = r1
            r19 = r5
            r21 = r6
            r22 = r8
            io.hansel.userjourney.n.a(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            boolean r9 = r0.b0
            if (r9 == 0) goto L_0x044a
            r0.a(r6, r8, r1, r5)
        L_0x044a:
            android.view.View r1 = r0.H
            int r5 = io.hansel.R.id.p_shadow_container
            android.view.View r1 = r1.findViewById(r5)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r1 = (android.widget.RelativeLayout.LayoutParams) r1
            r0.L = r1
            io.hansel.userjourney.prompts.k r1 = r0.E
            io.hansel.userjourney.prompts.l r1 = r1.F()
            if (r1 != r2) goto L_0x0487
            io.hansel.userjourney.prompts.k r1 = r0.E
            int r2 = r0.j
            double r1 = r1.a(r2, r4)
            float r1 = (float) r1
            io.hansel.userjourney.prompts.k r2 = r0.E
            io.hansel.userjourney.prompts.d0 r2 = r2.y()
            io.hansel.userjourney.prompts.d0 r4 = io.hansel.userjourney.prompts.d0.BOTTOM
            if (r2 != r4) goto L_0x047c
            android.view.View r2 = r0.H
            int r4 = io.hansel.R.id.iv_arrow_top
            goto L_0x0480
        L_0x047c:
            android.view.View r2 = r0.H
            int r4 = io.hansel.R.id.iv_arrow_bottom
        L_0x0480:
            android.view.View r2 = r2.findViewById(r4)
            r2.setRotation(r1)
        L_0x0487:
            android.view.View r1 = r0.H
            r1.setVisibility(r7)
            android.view.View r1 = r0.H
            int r2 = io.hansel.R.id.prompt_main
            android.view.View r1 = r1.findViewById(r2)
            r1.setVisibility(r7)
            android.view.View r1 = r0.H
            int r2 = io.hansel.R.id.prompt_shadow
            android.view.View r1 = r1.findViewById(r2)
            r1.setVisibility(r7)
            android.view.View r1 = r0.H
            r1.setFocusableInTouchMode(r3)
            android.view.View r1 = r0.H
            r1.requestFocus()
            r26.l()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.hansel.userjourney.prompts.r.r():void");
    }
}
