package com.amazon.apay.hardened.external.model;

import android.content.Intent;
import androidx.core.widget.CompoundButtonCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import timber.log.Timber;

public class APayAuthResponse {

    /* renamed from: a  reason: collision with root package name */
    public Status f3243a;

    /* renamed from: b  reason: collision with root package name */
    public String f3244b;

    /* renamed from: c  reason: collision with root package name */
    public String f3245c;

    /* renamed from: d  reason: collision with root package name */
    public String f3246d;

    public enum Status {
        GRANTED,
        DENIED
    }

    public APayAuthResponse(Status status, String str, String str2, String str3) {
        this.f3243a = status;
        this.f3244b = str;
        this.f3245c = str2;
        this.f3246d = str3;
    }

    public static APayAuthResponse fromIntent(Intent intent) {
        Timber.TREE_OF_SOULS.i("fromIntent called", new Object[0]);
        if (intent != null) {
            try {
                if (intent.getExtras() != null && intent.getExtras().containsKey("AUTH_STATUS")) {
                    Timber.TREE_OF_SOULS.i("Intent contains AUTH_STATUS extra", new Object[0]);
                    return new APayAuthResponse((Status) intent.getExtras().getSerializable("AUTH_STATUS"), intent.getExtras().getString("authCode"), intent.getExtras().getString("lwaClientId"), intent.getExtras().getString("redirectUri"));
                }
            } catch (Exception e2) {
                Timber.TREE_OF_SOULS.e(e2, "Error while reading authorization result", new Object[0]);
                CompoundButtonCompat.a("AuthResponseParsingError");
            }
        }
        Timber.TREE_OF_SOULS.i("Intent does not contain AUTH_STATUS extra", new Object[0]);
        return null;
    }

    public String getAuthCode() {
        return this.f3244b;
    }

    public String getClientId() {
        return this.f3245c;
    }

    public String getRedirectUri() {
        return this.f3246d;
    }

    public Status getStatus() {
        return this.f3243a;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AuthorizationResponse{status=");
        outline73.append(this.f3243a.name());
        outline73.append(", authCode='");
        GeneratedOutlineSupport.outline99(outline73, this.f3244b, ExtendedMessageFormat.QUOTE, ", clientId='");
        GeneratedOutlineSupport.outline99(outline73, this.f3245c, ExtendedMessageFormat.QUOTE, ", redirectUri='");
        return GeneratedOutlineSupport.outline60(outline73, this.f3246d, ExtendedMessageFormat.QUOTE, '}');
    }
}
