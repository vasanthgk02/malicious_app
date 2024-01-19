package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

@KeepName
/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public class SignInHubActivity extends FragmentActivity {
    public static boolean zba;
    public boolean zbb = false;
    public SignInConfiguration zbc;
    public boolean zbd;
    public int zbe;
    public Intent zbf;

    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (!this.zbb) {
            setResult(0);
            if (i == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
                    if (signInAccount != null) {
                        GoogleSignInAccount googleSignInAccount = signInAccount.zbc;
                        if (googleSignInAccount != null) {
                            zbn zbc2 = zbn.zbc(this);
                            GoogleSignInOptions googleSignInOptions = this.zbc.zbb;
                            synchronized (zbc2) {
                                zbc2.zba.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
                                zbc2.zbb = googleSignInAccount;
                                zbc2.zbc = googleSignInOptions;
                            }
                            intent.removeExtra("signInAccount");
                            intent.putExtra("googleSignInAccount", googleSignInAccount);
                            this.zbd = true;
                            this.zbe = i2;
                            this.zbf = intent;
                            getSupportLoaderManager().initLoader(0, null, new zbw(this));
                            zba = false;
                            return;
                        }
                    }
                    if (intent.hasExtra("errorCode")) {
                        int intExtra = intent.getIntExtra("errorCode", 8);
                        if (intExtra == 13) {
                            intExtra = 12501;
                        }
                        zbd(intExtra);
                        return;
                    }
                }
                zbd(8);
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null) {
            throw null;
        } else if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zbd(12500);
        } else if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Bundle bundleExtra = intent.getBundleExtra("config");
            if (bundleExtra != null) {
                SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable("config");
                if (signInConfiguration == null) {
                    setResult(0);
                    finish();
                    return;
                }
                this.zbc = signInConfiguration;
                if (bundle != null) {
                    boolean z = bundle.getBoolean("signingInGoogleApiClients");
                    this.zbd = z;
                    if (z) {
                        this.zbe = bundle.getInt("signInResultCode");
                        Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                        if (intent2 != null) {
                            this.zbf = intent2;
                            getSupportLoaderManager().initLoader(0, null, new zbw(this));
                            zba = false;
                            return;
                        }
                        throw null;
                    }
                } else if (zba) {
                    setResult(0);
                    zbd(12502);
                } else {
                    zba = true;
                    Intent intent3 = new Intent(action);
                    if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                        intent3.setPackage("com.google.android.gms");
                    } else {
                        intent3.setPackage(getPackageName());
                    }
                    intent3.putExtra("config", this.zbc);
                    try {
                        startActivityForResult(intent3, 40962);
                    } catch (ActivityNotFoundException unused) {
                        this.zbb = true;
                        zbd(17);
                    }
                }
            } else {
                throw null;
            }
        } else {
            String valueOf = String.valueOf(intent.getAction());
            if (valueOf.length() != 0) {
                "Unknown action: ".concat(valueOf);
            } else {
                new String("Unknown action: ");
            }
            finish();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        zba = false;
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zbd);
        if (this.zbd) {
            bundle.putInt("signInResultCode", this.zbe);
            bundle.putParcelable("signInResultData", this.zbf);
        }
    }

    public final void zbd(int i) {
        Status status = new Status(i, null);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zba = false;
    }
}
