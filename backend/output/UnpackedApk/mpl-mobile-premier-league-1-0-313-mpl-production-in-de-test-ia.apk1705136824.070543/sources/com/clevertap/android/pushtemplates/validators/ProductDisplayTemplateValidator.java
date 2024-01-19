package com.clevertap.android.pushtemplates.validators;

import com.clevertap.android.pushtemplates.checkers.Checker;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/clevertap/android/pushtemplates/validators/ProductDisplayTemplateValidator;", "Lcom/clevertap/android/pushtemplates/validators/TemplateValidator;", "validator", "Lcom/clevertap/android/pushtemplates/validators/Validator;", "(Lcom/clevertap/android/pushtemplates/validators/Validator;)V", "loadKeys", "", "Lcom/clevertap/android/pushtemplates/checkers/Checker;", "", "validate", "", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ProductDisplayTemplateValidator.kt */
public final class ProductDisplayTemplateValidator extends TemplateValidator {
    public Validator validator;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ProductDisplayTemplateValidator(Validator validator2) {
        // Intrinsics.checkNotNullParameter(validator2, "validator");
        super(validator2.keys);
        this.validator = validator2;
    }

    public List<Checker<? extends Object>> loadKeys() {
        Checker<? extends Object> checker = this.keys.get("PT_THREE_DEEPLINK_LIST");
        Intrinsics.checkNotNull(checker);
        Checker<? extends Object> checker2 = this.keys.get("PT_BIG_TEXT_LIST");
        Intrinsics.checkNotNull(checker2);
        Checker<? extends Object> checker3 = this.keys.get("PT_SMALL_TEXT_LIST");
        Intrinsics.checkNotNull(checker3);
        Checker<? extends Object> checker4 = this.keys.get("PT_PRODUCT_DISPLAY_ACTION");
        Intrinsics.checkNotNull(checker4);
        Checker<? extends Object> checker5 = this.keys.get("PT_PRODUCT_DISPLAY_ACTION_CLR");
        Intrinsics.checkNotNull(checker5);
        Checker<? extends Object> checker6 = this.keys.get("PT_PRODUCT_THREE_IMAGE_LIST");
        Intrinsics.checkNotNull(checker6);
        return TweetUtils.listOf((T[]) new Checker[]{checker, checker2, checker3, checker4, checker5, checker6});
    }

    public boolean validate() {
        return this.validator.validate() && super.validateKeys();
    }
}
