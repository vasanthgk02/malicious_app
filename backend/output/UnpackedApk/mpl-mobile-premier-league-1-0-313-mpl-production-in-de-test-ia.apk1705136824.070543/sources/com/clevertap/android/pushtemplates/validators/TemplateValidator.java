package com.clevertap.android.pushtemplates.validators;

import com.clevertap.android.pushtemplates.checkers.Checker;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B!\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/clevertap/android/pushtemplates/validators/TemplateValidator;", "Lcom/clevertap/android/pushtemplates/validators/Validator;", "keys", "", "", "Lcom/clevertap/android/pushtemplates/checkers/Checker;", "", "(Ljava/util/Map;)V", "validate", "", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TemplateValidator.kt */
public abstract class TemplateValidator extends Validator {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TemplateValidator(Map<String, ? extends Checker<? extends Object>> map) {
        // Intrinsics.checkNotNullParameter(map, UserMetadata.KEYDATA_FILENAME);
        super(map);
    }
}
