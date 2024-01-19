package com.clevertap.android.pushtemplates.validators;

import com.clevertap.android.pushtemplates.checkers.Checker;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B!\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00050\nH&J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\fH\u0016J\u0006\u0010\u000f\u001a\u00020\fR%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/clevertap/android/pushtemplates/validators/Validator;", "", "keys", "", "", "Lcom/clevertap/android/pushtemplates/checkers/Checker;", "(Ljava/util/Map;)V", "getKeys", "()Ljava/util/Map;", "loadKeys", "", "validate", "", "validateKeys", "validateOR", "validateORKeys", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Validator.kt */
public abstract class Validator {
    public final Map<String, Checker<? extends Object>> keys;

    public Validator(Map<String, ? extends Checker<? extends Object>> map) {
        Intrinsics.checkNotNullParameter(map, UserMetadata.KEYDATA_FILENAME);
        this.keys = map;
    }

    public abstract List<Checker<? extends Object>> loadKeys();

    public boolean validate() {
        return validateKeys();
    }

    public final boolean validateKeys() {
        List<Checker<? extends Object>> loadKeys = loadKeys();
        Intrinsics.checkNotNullParameter(loadKeys, "<this>");
        Iterator<T> it = loadKeys.iterator();
        while (true) {
            boolean z = true;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                if (!((Checker) it.next()).check() || !z) {
                    z = false;
                }
            }
        }
    }
}
