package com.mpl.network.modules.listeners;

import androidx.annotation.Keep;
import com.google.gson.internal.C$Gson$Types;
import com.mpl.MLog;
import com.mpl.network.modules.engine.MHeader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

@Keep
public abstract class IResponseListener<E> {
    public static final String TAG = "NetworkLib: IResponseListener";
    public Type mType = getSuperclassTypeParameter(getClass());

    static {
        new IResponseListener<String>() {
            public void onProcessHeader(ArrayList<MHeader> arrayList) {
            }

            public void onResponseFail(Exception exc) {
            }

            public void onResponseSuccess(String str) {
            }

            public void progressResponse(long j, long j2, boolean z) {
            }
        };
    }

    public static Type getSuperclassTypeParameter(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            genericSuperclass = String.class.getGenericSuperclass();
        }
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        MLog.i(TAG, "parameterized: ", parameterizedType);
        return C$Gson$Types.canonicalize(parameterizedType.getActualTypeArguments()[0]);
    }

    public void calculateResponse(long j) {
    }

    public void onProcessHeader(ArrayList<MHeader> arrayList) {
    }

    public abstract void onResponseFail(Exception exc);

    public abstract void onResponseSuccess(E e2);

    public abstract void progressResponse(long j, long j2, boolean z);
}
