package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.core.app.FrameMetricsAggregator;
import com.mpl.androidapp.utils.Constant;

/* compiled from: TypeMappingMode.kt */
public final class TypeMappingMode {
    public static final TypeMappingMode DEFAULT;
    public static final TypeMappingMode GENERIC_ARGUMENT;
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST;
    public final TypeMappingMode genericArgumentMode;
    public final TypeMappingMode genericContravariantArgumentMode;
    public final TypeMappingMode genericInvariantArgumentMode;
    public final boolean isForAnnotationParameter;
    public final boolean kotlinCollectionsToJavaCollections;
    public final boolean mapTypeAliases;
    public final boolean needInlineClassWrapping;
    public final boolean needPrimitiveBoxing;
    public final boolean skipDeclarationSiteWildcards;
    public final boolean skipDeclarationSiteWildcardsIfPossible;

    static {
        TypeMappingMode typeMappingMode = new TypeMappingMode(false, false, false, false, false, null, false, null, null, false, Constant.PERMISSIONS_REQUEST_AUDIO);
        GENERIC_ARGUMENT = typeMappingMode;
        TypeMappingMode typeMappingMode2 = new TypeMappingMode(false, false, false, false, false, null, false, null, null, true, FrameMetricsAggregator.EVERY_DURATION);
        GENERIC_ARGUMENT_UAST = typeMappingMode2;
        TypeMappingMode typeMappingMode3 = new TypeMappingMode(false, false, false, false, false, GENERIC_ARGUMENT, false, null, null, false, 988);
        DEFAULT = typeMappingMode3;
    }

    public TypeMappingMode(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, TypeMappingMode typeMappingMode, boolean z6, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z7, int i) {
        z = (i & 1) != 0 ? true : z;
        z2 = (i & 2) != 0 ? true : z2;
        z3 = (i & 4) != 0 ? false : z3;
        z4 = (i & 8) != 0 ? false : z4;
        z5 = (i & 16) != 0 ? false : z5;
        typeMappingMode = (i & 32) != 0 ? null : typeMappingMode;
        z6 = (i & 64) != 0 ? true : z6;
        typeMappingMode2 = (i & 128) != 0 ? typeMappingMode : typeMappingMode2;
        typeMappingMode3 = (i & 256) != 0 ? typeMappingMode : typeMappingMode3;
        z7 = (i & 512) != 0 ? false : z7;
        this.needPrimitiveBoxing = z;
        this.needInlineClassWrapping = z2;
        this.isForAnnotationParameter = z3;
        this.skipDeclarationSiteWildcards = z4;
        this.skipDeclarationSiteWildcardsIfPossible = z5;
        this.genericArgumentMode = typeMappingMode;
        this.kotlinCollectionsToJavaCollections = z6;
        this.genericContravariantArgumentMode = typeMappingMode2;
        this.genericInvariantArgumentMode = typeMappingMode3;
        this.mapTypeAliases = z7;
    }
}
