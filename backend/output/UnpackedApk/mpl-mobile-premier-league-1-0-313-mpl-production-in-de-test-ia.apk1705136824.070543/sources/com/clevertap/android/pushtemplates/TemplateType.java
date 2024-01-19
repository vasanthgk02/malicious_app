package com.clevertap.android.pushtemplates;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/clevertap/android/pushtemplates/TemplateType;", "", "templateType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "BASIC", "AUTO_CAROUSEL", "MANUAL_CAROUSEL", "RATING", "FIVE_ICONS", "PRODUCT_DISPLAY", "ZERO_BEZEL", "TIMER", "INPUT_BOX", "VIDEO", "CANCEL", "Companion", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TemplateType.kt */
public enum TemplateType {
    BASIC("pt_basic"),
    AUTO_CAROUSEL("pt_carousel"),
    MANUAL_CAROUSEL("pt_manual_carousel"),
    RATING("pt_rating"),
    FIVE_ICONS("pt_five_icons"),
    PRODUCT_DISPLAY("pt_product_display"),
    ZERO_BEZEL("pt_zero_bezel"),
    TIMER("pt_timer"),
    INPUT_BOX("pt_input"),
    VIDEO("pt_video"),
    CANCEL("pt_cancel");
    
    public static final Companion Companion = null;
    public final String templateType;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/clevertap/android/pushtemplates/TemplateType$Companion;", "", "()V", "fromString", "Lcom/clevertap/android/pushtemplates/TemplateType;", "type", "", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TemplateType.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final TemplateType fromString(String str) {
            if (str != null) {
                switch (str.hashCode()) {
                    case -1726683778:
                        if (str.equals("pt_manual_carousel")) {
                            return TemplateType.MANUAL_CAROUSEL;
                        }
                        break;
                    case -1531478936:
                        if (str.equals("pt_five_icons")) {
                            return TemplateType.FIVE_ICONS;
                        }
                        break;
                    case -629497790:
                        if (str.equals("pt_zero_bezel")) {
                            return TemplateType.ZERO_BEZEL;
                        }
                        break;
                    case -622393029:
                        if (str.equals("pt_carousel")) {
                            return TemplateType.AUTO_CAROUSEL;
                        }
                        break;
                    case 310751795:
                        if (str.equals("pt_basic")) {
                            return TemplateType.BASIC;
                        }
                        break;
                    case 317601231:
                        if (str.equals("pt_input")) {
                            return TemplateType.INPUT_BOX;
                        }
                        break;
                    case 327607626:
                        if (str.equals("pt_timer")) {
                            return TemplateType.TIMER;
                        }
                        break;
                    case 329446016:
                        if (str.equals("pt_video")) {
                            return TemplateType.VIDEO;
                        }
                        break;
                    case 923207991:
                        if (str.equals("pt_product_display")) {
                            return TemplateType.PRODUCT_DISPLAY;
                        }
                        break;
                    case 1071845653:
                        if (str.equals("pt_cancel")) {
                            return TemplateType.CANCEL;
                        }
                        break;
                    case 1501467704:
                        if (str.equals("pt_rating")) {
                            return TemplateType.RATING;
                        }
                        break;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion(null);
    }

    /* access modifiers changed from: public */
    TemplateType(String str) {
        this.templateType = str;
    }

    public static final TemplateType fromString(String str) {
        return Companion.fromString(str);
    }

    public String toString() {
        return this.templateType;
    }
}
