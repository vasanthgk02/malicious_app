package com.amazon.identity.auth.device;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;

public class AuthError extends Exception implements Parcelable, IInterface {
    public static final String AUTH_ERROR_EXECEPTION = "AUTH_ERROR_EXECEPTION";
    public static final Creator<AuthError> CREATOR = new Creator<AuthError>() {
        /* renamed from: a */
        public AuthError createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            Throwable th = (Throwable) parcel.readValue(Throwable.class.getClassLoader());
            ERROR_TYPE error_type = (ERROR_TYPE) parcel.readSerializable();
            if (error_type == ERROR_TYPE.ERROR_UNKNOWN) {
                error_type = ERROR_TYPE.fromValue(parcel.readInt());
            }
            return new AuthError(readString, th, error_type);
        }

        /* renamed from: a */
        public AuthError[] newArray(int i) {
            return new AuthError[i];
        }
    };
    public static final int RESULT_AUTH_ERROR = 1;

    /* renamed from: a  reason: collision with root package name */
    public static final String f3262a = AuthError.class.getName();

    /* renamed from: a  reason: collision with other field name */
    public final ERROR_TYPE f95a;

    public enum ERROR_CATEGORY {
        ACTION,
        BAD_REQUEST,
        NETWORK,
        INTERNAL,
        UNKNOWN
    }

    public enum ERROR_TYPE {
        ERROR_INVALID_TOKEN(ERROR_CATEGORY.ACTION, 1),
        ERROR_INVALID_GRANT(ERROR_CATEGORY.ACTION, 2),
        ERROR_INVALID_CLIENT(ERROR_CATEGORY.ACTION, 3),
        ERROR_INVALID_SCOPE(ERROR_CATEGORY.ACTION, 4),
        ERROR_UNAUTHORIZED_CLIENT(ERROR_CATEGORY.ACTION, 5),
        ERROR_WEBVIEW_SSL(ERROR_CATEGORY.ACTION, 6),
        ERROR_ACCESS_DENIED(ERROR_CATEGORY.ACTION, 7),
        ERROR_COM(ERROR_CATEGORY.NETWORK, 8),
        ERROR_IO(ERROR_CATEGORY.NETWORK, 9),
        ERROR_BAD_PARAM(ERROR_CATEGORY.INTERNAL, 10),
        ERROR_JSON(ERROR_CATEGORY.INTERNAL, 11),
        ERROR_PARSE(ERROR_CATEGORY.INTERNAL, 12),
        ERROR_SERVER_REPSONSE(ERROR_CATEGORY.INTERNAL, 13),
        ERROR_DATA_STORAGE(ERROR_CATEGORY.INTERNAL, 14),
        ERROR_THREAD(ERROR_CATEGORY.INTERNAL, 15),
        ERROR_DCP_DMS(ERROR_CATEGORY.ACTION, 16),
        ERROR_FORCE_UPDATE(ERROR_CATEGORY.ACTION, 17),
        ERROR_REVOKE_AUTH(ERROR_CATEGORY.INTERNAL, 18),
        ERROR_AUTH_DIALOG(ERROR_CATEGORY.INTERNAL, 19),
        ERROR_BAD_API_PARAM(ERROR_CATEGORY.BAD_REQUEST, 20),
        ERROR_INIT(ERROR_CATEGORY.BAD_REQUEST, 21),
        ERROR_RESOURCES(ERROR_CATEGORY.BAD_REQUEST, 22),
        ERROR_DIRECTED_ID_NOT_FOUND(ERROR_CATEGORY.BAD_REQUEST, 23),
        ERROR_INVALID_API(ERROR_CATEGORY.BAD_REQUEST, 24),
        ERROR_SECURITY(ERROR_CATEGORY.BAD_REQUEST, 25),
        ERROR_UNKNOWN(ERROR_CATEGORY.UNKNOWN, 26),
        ERROR_REGISTRATION(ERROR_CATEGORY.ACTION, 27),
        ERROR_MISSING_CODE_CHALLENGE(ERROR_CATEGORY.BAD_REQUEST, 28),
        ERROR_MISSING_TOKEN_FOR_REQUIRED_SCOPES(ERROR_CATEGORY.BAD_REQUEST, 29);
        

        /* renamed from: a  reason: collision with root package name */
        public static int f3264a;

        /* renamed from: a  reason: collision with other field name */
        public final ERROR_CATEGORY f97a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3265b;

        /* access modifiers changed from: public */
        static {
            f3264a = 27;
        }

        /* access modifiers changed from: public */
        ERROR_TYPE(ERROR_CATEGORY error_category, int i) {
            this.f97a = error_category;
            this.f3265b = i;
        }

        public static ERROR_TYPE fromValue(int i) {
            for (ERROR_TYPE error_type : values()) {
                if (error_type.value() == i) {
                    return error_type;
                }
            }
            return ERROR_UNKNOWN;
        }

        public ERROR_CATEGORY getCategory() {
            return this.f97a;
        }

        public int value() {
            return this.f3265b;
        }
    }

    public AuthError(Parcel parcel) {
        this(parcel.readString(), (Throwable) parcel.readValue(Throwable.class.getClassLoader()), (ERROR_TYPE) parcel.readSerializable());
    }

    public AuthError(String str, ERROR_TYPE error_type) {
        super(str);
        this.f95a = error_type;
    }

    public AuthError(String str, Throwable th, ERROR_TYPE error_type) {
        super(str, th);
        this.f95a = error_type;
    }

    public static AuthError extractError(Intent intent) {
        try {
            return (AuthError) intent.getParcelableExtra(AUTH_ERROR_EXECEPTION);
        } catch (Exception unused) {
            cp.b(f3262a, "Error Extracting AuthError");
            return null;
        }
    }

    public static AuthError extractError(Bundle bundle) {
        try {
            return (AuthError) bundle.getParcelable(AUTH_ERROR_EXECEPTION);
        } catch (Exception unused) {
            cp.b(f3262a, "Error Extracting AuthError");
            return null;
        }
    }

    public static <T> AuthError getAuthError(Throwable th, Class<T> cls) {
        return getAuthError(th, cls, ERROR_TYPE.ERROR_UNKNOWN);
    }

    public static <T> AuthError getAuthError(Throwable th, Class<T> cls, ERROR_TYPE error_type) {
        return new AuthError(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Unexpected error in ")), th, error_type);
    }

    public static Bundle getErrorBundle(Intent intent) {
        return getErrorBundle(extractError(intent));
    }

    public static Bundle getErrorBundle(AuthError authError) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(AUTH_ERROR_EXECEPTION, authError);
        return bundle;
    }

    public static <T> Bundle getErrorBundle(Throwable th, Class<T> cls, ERROR_TYPE error_type) {
        return getErrorBundle(getAuthError(th, cls, error_type));
    }

    public IBinder asBinder() {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public ERROR_CATEGORY getCategory() {
        return this.f95a.getCategory();
    }

    public ERROR_TYPE getType() {
        return this.f95a;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AuthError cat= ");
        outline73.append(this.f95a.getCategory());
        outline73.append(" type=");
        outline73.append(this.f95a);
        outline73.append(" - ");
        outline73.append(super.toString());
        return outline73.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getMessage());
        parcel.writeValue(getCause() != null ? getCause() : null);
        parcel.writeSerializable(this.f95a.value() < ERROR_TYPE.f3264a ? this.f95a : ERROR_TYPE.ERROR_UNKNOWN);
        parcel.writeInt(this.f95a.value());
    }
}
