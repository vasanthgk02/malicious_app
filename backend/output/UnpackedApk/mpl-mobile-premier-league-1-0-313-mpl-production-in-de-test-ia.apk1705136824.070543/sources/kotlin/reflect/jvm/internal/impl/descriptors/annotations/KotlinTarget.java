package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.facebook.react.bridge.PromiseImpl;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KotlinTarget.kt */
public enum KotlinTarget {
    CLASS(PromiseImpl.STACK_FRAME_KEY_CLASS, false, 2, null),
    ANNOTATION_CLASS("annotation class", false, 2, null),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property", false, 2, null),
    FIELD(HSLCriteriaBuilder.FIELD, false, 2, null),
    LOCAL_VARIABLE("local variable", false, 2, null),
    VALUE_PARAMETER("value parameter", false, 2, null),
    CONSTRUCTOR("constructor", false, 2, null),
    FUNCTION("function", false, 2, null),
    PROPERTY_GETTER("getter", false, 2, null),
    PROPERTY_SETTER("setter", false, 2, null),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY(PromiseImpl.STACK_FRAME_KEY_CLASS, false),
    OBJECT("object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);
    
    public static final Set<KotlinTarget> ALL_TARGET_SET = null;
    public static final Companion Companion = null;
    public static final Set<KotlinTarget> DEFAULT_TARGET_SET = null;
    public static final Map<AnnotationUseSiteTarget, KotlinTarget> USE_SITE_MAPPING = null;
    public static final HashMap<String, KotlinTarget> map = null;
    public final String description;
    public final boolean isDefault;

    /* compiled from: KotlinTarget.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion(null);
        map = new HashMap<>();
        KotlinTarget[] values = values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            KotlinTarget kotlinTarget = values[i];
            i++;
            map.put(kotlinTarget.name(), kotlinTarget);
        }
        KotlinTarget[] values2 = values();
        ArrayList arrayList = new ArrayList();
        for (KotlinTarget kotlinTarget2 : values2) {
            if (kotlinTarget2.isDefault()) {
                arrayList.add(kotlinTarget2);
            }
        }
        DEFAULT_TARGET_SET = ArraysKt___ArraysJvmKt.toSet(arrayList);
        ALL_TARGET_SET = TweetUtils.toSet(values());
        USE_SITE_MAPPING = ArraysKt___ArraysJvmKt.mapOf(new Pair(AnnotationUseSiteTarget.CONSTRUCTOR_PARAMETER, VALUE_PARAMETER), new Pair(AnnotationUseSiteTarget.FIELD, FIELD), new Pair(AnnotationUseSiteTarget.PROPERTY, PROPERTY), new Pair(AnnotationUseSiteTarget.FILE, FILE), new Pair(AnnotationUseSiteTarget.PROPERTY_GETTER, PROPERTY_GETTER), new Pair(AnnotationUseSiteTarget.PROPERTY_SETTER, PROPERTY_SETTER), new Pair(AnnotationUseSiteTarget.RECEIVER, VALUE_PARAMETER), new Pair(AnnotationUseSiteTarget.SETTER_PARAMETER, VALUE_PARAMETER), new Pair(AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD, FIELD));
    }

    /* access modifiers changed from: public */
    KotlinTarget(String str, boolean z) {
        this.description = str;
        this.isDefault = z;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }
}
