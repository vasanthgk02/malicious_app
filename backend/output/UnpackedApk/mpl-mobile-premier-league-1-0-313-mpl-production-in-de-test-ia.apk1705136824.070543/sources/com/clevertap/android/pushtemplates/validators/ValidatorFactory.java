package com.clevertap.android.pushtemplates.validators;

import com.clevertap.android.pushtemplates.TemplateRenderer;
import com.clevertap.android.pushtemplates.TemplateType;
import com.clevertap.android.pushtemplates.checkers.Checker;
import com.clevertap.android.pushtemplates.checkers.IntSizeChecker;
import com.clevertap.android.pushtemplates.checkers.JsonArraySizeChecker;
import com.clevertap.android.pushtemplates.checkers.ListEqualSizeChecker;
import com.clevertap.android.pushtemplates.checkers.ListSizeChecker;
import com.clevertap.android.pushtemplates.checkers.StringSizeChecker;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/clevertap/android/pushtemplates/validators/ValidatorFactory;", "", "()V", "Companion", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ValidatorFactory.kt */
public final class ValidatorFactory {
    public static Map<String, ? extends Checker<? extends Object>> keys;

    public static final Validator getValidator(TemplateType templateType, TemplateRenderer templateRenderer) {
        Validator validator;
        Intrinsics.checkNotNullParameter(templateType, "templateType");
        Intrinsics.checkNotNullParameter(templateRenderer, "templateRenderer");
        HashMap hashMap = new HashMap();
        hashMap.put("PT_TITLE", new StringSizeChecker(templateRenderer.pt_title, 0, "Title is missing or empty"));
        hashMap.put("PT_MSG", new StringSizeChecker(templateRenderer.pt_msg, 0, "Message is missing or empty"));
        hashMap.put("PT_BG", new StringSizeChecker(templateRenderer.pt_bg, 0, "Background colour is missing or empty"));
        hashMap.put("PT_DEEPLINK_LIST", new ListSizeChecker(templateRenderer.deepLinkList, 1, "Deeplink is missing or empty"));
        hashMap.put("PT_IMAGE_LIST", new ListSizeChecker(templateRenderer.imageList, 3, "Three required images not present"));
        hashMap.put("PT_RATING_DEFAULT_DL", new StringSizeChecker(templateRenderer.pt_rating_default_dl, 0, "Default deeplink is missing or empty"));
        hashMap.put("PT_FIVE_DEEPLINK_LIST", new ListSizeChecker(templateRenderer.deepLinkList, 3, "Three required deeplinks not present"));
        hashMap.put("PT_FIVE_IMAGE_LIST", new ListSizeChecker(templateRenderer.imageList, 3, "Three required images not present"));
        hashMap.put("PT_PRODUCT_THREE_IMAGE_LIST", new ListEqualSizeChecker(templateRenderer.imageList, 3, "Only three images are required"));
        hashMap.put("PT_THREE_DEEPLINK_LIST", new ListEqualSizeChecker(templateRenderer.deepLinkList, 3, "Three required deeplinks not present"));
        hashMap.put("PT_BIG_TEXT_LIST", new ListEqualSizeChecker(templateRenderer.bigTextList, 3, "Three required product titles not present"));
        hashMap.put("PT_SMALL_TEXT_LIST", new ListEqualSizeChecker(templateRenderer.smallTextList, 3, "Three required product descriptions not present"));
        hashMap.put("PT_PRODUCT_DISPLAY_ACTION", new StringSizeChecker(templateRenderer.pt_product_display_action, 0, "Button label is missing or empty"));
        hashMap.put("PT_PRODUCT_DISPLAY_ACTION_CLR", new StringSizeChecker(templateRenderer.pt_product_display_action_clr, 0, "Button colour is missing or empty"));
        hashMap.put("PT_BIG_IMG", new StringSizeChecker(templateRenderer.pt_big_img, 0, "Display Image is missing or empty"));
        hashMap.put("PT_TIMER_THRESHOLD", new IntSizeChecker(templateRenderer.pt_timer_threshold, -1, "Timer threshold not defined"));
        hashMap.put("PT_TIMER_END", new IntSizeChecker(templateRenderer.pt_timer_end, -1, "Not rendering notification Timer End value lesser than threshold (10 seconds) from current time"));
        hashMap.put("PT_INPUT_FEEDBACK", new StringSizeChecker(templateRenderer.pt_input_feedback, 0, "Feedback Text or Actions is missing or empty"));
        hashMap.put("PT_ACTIONS", new JsonArraySizeChecker(templateRenderer.actions, 0, "Feedback Text or Actions is missing or empty"));
        keys = hashMap;
        switch (templateType.ordinal()) {
            case 0:
                Map<String, ? extends Checker<? extends Object>> map = keys;
                if (map != null) {
                    new BasicTemplateValidator(new ContentValidator(map));
                    break;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException(UserMetadata.KEYDATA_FILENAME);
                    throw null;
                }
            case 1:
            case 2:
                Map<String, ? extends Checker<? extends Object>> map2 = keys;
                if (map2 != null) {
                    new CarouselTemplateValidator(new BasicTemplateValidator(new ContentValidator(map2)));
                    break;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException(UserMetadata.KEYDATA_FILENAME);
                    throw null;
                }
            case 3:
                Map<String, ? extends Checker<? extends Object>> map3 = keys;
                if (map3 != null) {
                    new RatingTemplateValidator(new BasicTemplateValidator(new ContentValidator(map3)));
                    break;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException(UserMetadata.KEYDATA_FILENAME);
                    throw null;
                }
            case 4:
                Map<String, ? extends Checker<? extends Object>> map4 = keys;
                if (map4 != null) {
                    new FiveIconsTemplateValidator(new BackgroundValidator(map4));
                    break;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException(UserMetadata.KEYDATA_FILENAME);
                    throw null;
                }
            case 5:
                Map<String, ? extends Checker<? extends Object>> map5 = keys;
                if (map5 != null) {
                    new ProductDisplayTemplateValidator(new BasicTemplateValidator(new ContentValidator(map5)));
                    break;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException(UserMetadata.KEYDATA_FILENAME);
                    throw null;
                }
            case 6:
                Map<String, ? extends Checker<? extends Object>> map6 = keys;
                if (map6 != null) {
                    new ZeroBezelTemplateValidator(new ContentValidator(map6));
                    break;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException(UserMetadata.KEYDATA_FILENAME);
                    throw null;
                }
            case 7:
                Map<String, ? extends Checker<? extends Object>> map7 = keys;
                if (map7 != null) {
                    new TimerTemplateValidator(new BasicTemplateValidator(new ContentValidator(map7)));
                    break;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException(UserMetadata.KEYDATA_FILENAME);
                    throw null;
                }
            case 8:
                Map<String, ? extends Checker<? extends Object>> map8 = keys;
                if (map8 != null) {
                    new InputBoxTemplateValidator(new ContentValidator(map8));
                    break;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException(UserMetadata.KEYDATA_FILENAME);
                    throw null;
                }
            default:
                return null;
        }
        return validator;
    }
}
