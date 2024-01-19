package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: ProtoBasedClassDataFinder.kt */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    public final Map<ClassId, ProtoBuf$Class> classIdToProto;
    public final Function1<ClassId, SourceElement> classSource;
    public final BinaryVersion metadataVersion;
    public final NameResolver nameResolver;

    public ProtoBasedClassDataFinder(ProtoBuf$PackageFragment protoBuf$PackageFragment, NameResolver nameResolver2, BinaryVersion binaryVersion, Function1<? super ClassId, ? extends SourceElement> function1) {
        Intrinsics.checkNotNullParameter(protoBuf$PackageFragment, "proto");
        Intrinsics.checkNotNullParameter(nameResolver2, "nameResolver");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(function1, "classSource");
        this.nameResolver = nameResolver2;
        this.metadataVersion = binaryVersion;
        this.classSource = function1;
        List<ProtoBuf$Class> list = protoBuf$PackageFragment.class__;
        Intrinsics.checkNotNullExpressionValue(list, "proto.class_List");
        LinkedHashMap linkedHashMap = new LinkedHashMap(TweetUtils.mapCapacity(TweetUtils.collectionSizeOrDefault(list, 10)) < 16 ? 16 : TweetUtils.mapCapacity(TweetUtils.collectionSizeOrDefault(list, 10)));
        for (T next : list) {
            linkedHashMap.put(TweetUtils.getClassId(this.nameResolver, ((ProtoBuf$Class) next).fqName_), next);
        }
        this.classIdToProto = linkedHashMap;
    }

    public ClassData findClassData(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        ProtoBuf$Class protoBuf$Class = this.classIdToProto.get(classId);
        if (protoBuf$Class == null) {
            return null;
        }
        return new ClassData(this.nameResolver, protoBuf$Class, this.metadataVersion, (SourceElement) this.classSource.invoke(classId));
    }
}
