package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ProtoContainer.kt */
public abstract class ProtoContainer {
    public final NameResolver nameResolver;
    public final SourceElement source;
    public final TypeTable typeTable;

    /* compiled from: ProtoContainer.kt */
    public static final class Class extends ProtoContainer {
        public final ClassId classId;
        public final ProtoBuf$Class classProto;
        public final boolean isInner;
        public final Kind kind;
        public final Class outerClass;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public Class(ProtoBuf$Class protoBuf$Class, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement, Class classR) {
            // Intrinsics.checkNotNullParameter(protoBuf$Class, "classProto");
            // Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            // Intrinsics.checkNotNullParameter(typeTable, "typeTable");
            super(nameResolver, typeTable, sourceElement, null);
            this.classProto = protoBuf$Class;
            this.outerClass = classR;
            this.classId = TweetUtils.getClassId(nameResolver, protoBuf$Class.fqName_);
            this.kind = ((Kind) Flags.CLASS_KIND.get(this.classProto.flags_)) == null ? Kind.CLASS : (Kind) Flags.CLASS_KIND.get(this.classProto.flags_);
            this.isInner = GeneratedOutlineSupport.outline108(Flags.IS_INNER, this.classProto.flags_, "IS_INNER.get(classProto.flags)");
        }

        public FqName debugFqName() {
            FqName asSingleFqName = this.classId.asSingleFqName();
            Intrinsics.checkNotNullExpressionValue(asSingleFqName, "classId.asSingleFqName()");
            return asSingleFqName;
        }
    }

    /* compiled from: ProtoContainer.kt */
    public static final class Package extends ProtoContainer {
        public final FqName fqName;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public Package(FqName fqName2, NameResolver nameResolver, TypeTable typeTable, SourceElement sourceElement) {
            // Intrinsics.checkNotNullParameter(fqName2, "fqName");
            // Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            // Intrinsics.checkNotNullParameter(typeTable, "typeTable");
            super(nameResolver, typeTable, sourceElement, null);
            this.fqName = fqName2;
        }

        public FqName debugFqName() {
            return this.fqName;
        }
    }

    public ProtoContainer(NameResolver nameResolver2, TypeTable typeTable2, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this.nameResolver = nameResolver2;
        this.typeTable = typeTable2;
        this.source = sourceElement;
    }

    public abstract FqName debugFqName();

    public String toString() {
        return getClass().getSimpleName() + ": " + debugFqName();
    }
}
