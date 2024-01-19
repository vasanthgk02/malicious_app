package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatActionListener;
import com.freshchat.consumer.sdk.FreshchatUserInteractionListener;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.f;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.ao;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.n;
import com.freshchat.consumer.sdk.j.q;

public class a extends AppCompatActivity {
    public long ly;

    private String a(View view) {
        if (view == null || view.getId() == -1) {
            return "";
        }
        return view.getClass() + " with id '" + view.getContext().getResources().getResourceEntryName(view.getId()) + "'";
    }

    public static boolean a(Context context) {
        try {
            String b2 = b(context);
            int identifier = context.getResources().getIdentifier("freshchatDisableFrame", NetworkingModule.REQUEST_BODY_KEY_STRING, context.getPackageName());
            return identifier == 0 || !b2.equalsIgnoreCase(context.getResources().getString(identifier));
        } catch (Exception unused) {
            return true;
        }
    }

    public static String b(Context context) {
        e i = e.i(context);
        StringBuilder sb = new StringBuilder();
        sb.append(i.getAppId() + "73463f9d-70de-41f8-857a-58590bdd5903" + i.getAppKey());
        sb.reverse();
        return aa.aA(sb.toString());
    }

    private boolean f(long j, long j2) {
        return j2 > 0 && j > 0 && j < j2;
    }

    private FreshchatUserInteractionListener getFreshchatUserInteractionListener() {
        return Freshchat.getInstance(getContext()).getFreshchatUserInteractionListener();
    }

    private LinearLayout kr() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LayoutParams layoutParams = new LayoutParams(-1, -2, 81);
        layoutParams.setMargins(0, 0, 0, 0);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setLayoutParams(layoutParams);
        int b2 = af.b(this, 0.5f);
        View view = new View(getContext());
        LayoutParams layoutParams2 = new LayoutParams(-1, b2, 81);
        view.setBackgroundColor(Color.parseColor("#EBEFF3"));
        view.setLayoutParams(layoutParams2);
        int b3 = af.b(this, 2.0f);
        int b4 = af.b(this, 3.0f);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        LayoutParams layoutParams3 = new LayoutParams(-1, -2, 81);
        layoutParams3.setMargins(0, 0, 0, 0);
        linearLayout2.setPadding(0, b4, 0, b3);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout2.setGravity(17);
        if (aw.eX()) {
            linearLayout2.setLayoutDirection(0);
        }
        TextView textView = new TextView(this);
        textView.setTextColor(Color.parseColor("#475867"));
        textView.setTextSize(12.0f);
        textView.setText("Powered by");
        textView.setGravity(17);
        int b5 = af.b(getContext(), 4.0f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMargins(0, 0, b5, 0);
        textView.setLayoutParams(layoutParams4);
        ImageView imageView = new ImageView(this);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_freshworks));
        linearLayout2.addView(textView);
        linearLayout2.addView(imageView);
        linearLayout.addView(view);
        linearLayout.addView(linearLayout2);
        if (aw.eZ()) {
            Window window = getWindow();
            if (window != null) {
                View decorView = window.getDecorView();
                if (decorView != null) {
                    window.setNavigationBarColor(-1);
                    decorView.setSystemUiVisibility(16);
                }
            }
        }
        return linearLayout;
    }

    public void C() {
        if (a(getContext())) {
            LinearLayout linearLayout = null;
            try {
                LinearLayout kr = kr();
                View findViewById = findViewById(16908290);
                if (findViewById instanceof FrameLayout) {
                    FrameLayout frameLayout = (FrameLayout) findViewById;
                    frameLayout.addView(kr);
                    int b2 = af.b(this, (float) 22);
                    View childAt = frameLayout.getChildAt(0);
                    if (childAt != null) {
                        int paddingLeft = childAt.getPaddingLeft();
                        int paddingRight = childAt.getPaddingRight();
                        i.a(getContext(), childAt, paddingLeft, childAt.getPaddingTop(), paddingRight, childAt.getPaddingBottom() + b2);
                    }
                }
            } catch (Exception e2) {
                if (linearLayout != null) {
                    ViewGroup viewGroup = (ViewGroup) linearLayout.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(linearLayout);
                    }
                }
                q.a(e2);
            }
        }
    }

    public void al() {
        i.a(getContext(), R.string.freshchat_error_message_token_failed);
        gs();
    }

    public boolean bM() {
        return (this instanceof CategoryListActivity) || (this instanceof ArticleListActivity) || (this instanceof ArticleDetailActivity) || (this instanceof ah);
    }

    public boolean dH() {
        return getFreshchatUserInteractionListener() != null;
    }

    public void e(String str) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            supportActionBar = f.j(this);
        }
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            if (!TextUtils.isEmpty(str)) {
                supportActionBar.setTitle((CharSequence) str);
                return;
            }
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to set ActionBar for ");
        outline73.append(getClass().getSimpleName());
        ai.e("FRESHCHAT_WARNING", outline73.toString());
    }

    public void freshchatOnClickProxy(View view) {
        String str = view.getTag() != null ? (String) view.getTag() : null;
        try {
            Class u = ao.u(view.getContext(), str);
            if (u == null) {
                if (!as.isEmpty(str)) {
                    boolean startsWith = str.startsWith(getPackageName());
                }
                a(view);
            }
            Object newInstance = u.newInstance();
            if (newInstance instanceof FreshchatActionListener) {
                ((FreshchatActionListener) newInstance).onClick(view);
            } else {
                a(view);
            }
        } catch (Exception unused) {
        }
    }

    public Context getContext() {
        return this;
    }

    public void gs() {
        e.i((Context) this).gu();
        finish();
    }

    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e2) {
            q.a(e2);
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        long j;
        super.onCreate(bundle);
        if (bundle == null) {
            j = n.fP();
        } else if (bundle.containsKey("EXTRA_CREATED_AT")) {
            j = bundle.getLong("EXTRA_CREATED_AT");
        } else {
            return;
        }
        this.ly = j;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (NavUtils.getParentActivityName(this) == null) {
            onBackPressed();
        } else {
            NavUtils.navigateUpFromSameTask(this);
        }
        return true;
    }

    public void onResume() {
        super.onResume();
        if (f(this.ly, e.i((Context) this).gt())) {
            finish();
            return;
        }
        long iN = e.i((Context) this).iN();
        if (!bM() || !f(this.ly, iN)) {
            e i = e.i(getApplicationContext());
            if (i != null && !i.isAccountActive()) {
                finish();
            }
            return;
        }
        finish();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putLong("EXTRA_CREATED_AT", this.ly);
        super.onSaveInstanceState(bundle);
    }

    public void onUserInteraction() {
        super.onUserInteraction();
        try {
            if (dH() && getFreshchatUserInteractionListener() != null) {
                getFreshchatUserInteractionListener().onUserInteraction();
            }
        } catch (Exception unused) {
        }
    }

    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            if (dH() && getFreshchatUserInteractionListener() != null) {
                getFreshchatUserInteractionListener().onUserLeaveHint();
            }
        } catch (Exception unused) {
        }
    }
}
