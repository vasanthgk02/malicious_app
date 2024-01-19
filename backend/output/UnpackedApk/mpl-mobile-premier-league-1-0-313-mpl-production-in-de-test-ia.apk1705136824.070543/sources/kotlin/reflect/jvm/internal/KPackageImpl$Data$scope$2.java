package kotlin.reflect.jvm.internal;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KPackageImpl.Data;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.PackagePartScopeCache;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KPackageImpl.kt */
public final class KPackageImpl$Data$scope$2 extends Lambda implements Function0<MemberScope> {
    public final /* synthetic */ Data this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KPackageImpl$Data$scope$2(Data data) {
        // this.this$0 = data;
        super(0);
    }

    public Object invoke() {
        Iterable<KotlinJvmBinaryClass> iterable;
        ReflectKotlinClass access$getKotlinClass$p = Data.access$getKotlinClass$p(this.this$0);
        if (access$getKotlinClass$p == null) {
            return Empty.INSTANCE;
        }
        ReflectProperties$LazySoftVal reflectProperties$LazySoftVal = this.this$0.moduleData$delegate;
        boolean z = false;
        KProperty kProperty = KDeclarationContainerImpl.Data.$$delegatedProperties[0];
        PackagePartScopeCache packagePartScopeCache = ((RuntimeModuleData) reflectProperties$LazySoftVal.invoke()).packagePartScopeCache;
        List<String> list = null;
        if (packagePartScopeCache != null) {
            Intrinsics.checkNotNullParameter(access$getKotlinClass$p, "fileClass");
            ConcurrentHashMap concurrentHashMap = packagePartScopeCache.cache;
            ClassId classId = access$getKotlinClass$p.getClassId();
            Object obj = concurrentHashMap.get(classId);
            if (obj == null) {
                FqName packageFqName = access$getKotlinClass$p.getClassId().getPackageFqName();
                Intrinsics.checkNotNullExpressionValue(packageFqName, "fileClass.classId.packageFqName");
                KotlinClassHeader kotlinClassHeader = access$getKotlinClass$p.classHeader;
                Kind kind = kotlinClassHeader.kind;
                Kind kind2 = Kind.MULTIFILE_CLASS;
                if (kind == kind2) {
                    String[] strArr = kotlinClassHeader.data;
                    if (kind == kind2) {
                        z = true;
                    }
                    if (!z) {
                        strArr = null;
                    }
                    if (strArr != null) {
                        list = ArraysKt___ArraysJvmKt.asList(strArr);
                    }
                    if (list == null) {
                        list = EmptyList.INSTANCE;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (String byInternalName : list) {
                        ClassId classId2 = ClassId.topLevel(new FqName(JvmClassName.byInternalName(byInternalName).internalName.replace('/', '.')));
                        Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)");
                        KotlinJvmBinaryClass findKotlinClass = TweetUtils.findKotlinClass(packagePartScopeCache.kotlinClassFinder, classId2);
                        if (findKotlinClass != null) {
                            arrayList.add(findKotlinClass);
                        }
                    }
                    iterable = arrayList;
                } else {
                    iterable = TweetUtils.listOf(access$getKotlinClass$p);
                }
                EmptyPackageFragmentDescriptor emptyPackageFragmentDescriptor = new EmptyPackageFragmentDescriptor(packagePartScopeCache.resolver.getComponents().moduleDescriptor, packageFqName);
                ArrayList arrayList2 = new ArrayList();
                for (KotlinJvmBinaryClass createKotlinPackagePartScope : iterable) {
                    MemberScope createKotlinPackagePartScope2 = packagePartScopeCache.resolver.createKotlinPackagePartScope(emptyPackageFragmentDescriptor, createKotlinPackagePartScope);
                    if (createKotlinPackagePartScope2 != null) {
                        arrayList2.add(createKotlinPackagePartScope2);
                    }
                }
                obj = ChainedMemberScope.create("package " + packageFqName + " (" + access$getKotlinClass$p + ')', ArraysKt___ArraysJvmKt.toList(arrayList2));
                Object putIfAbsent = concurrentHashMap.putIfAbsent(classId, obj);
                if (putIfAbsent != null) {
                    obj = putIfAbsent;
                }
            }
            Intrinsics.checkNotNullExpressionValue(obj, "cache.getOrPut(fileClass.classId) {\n        val fqName = fileClass.classId.packageFqName\n\n        val parts =\n            if (fileClass.classHeader.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS)\n                fileClass.classHeader.multifilePartNames.mapNotNull { partName ->\n                    val classId = ClassId.topLevel(JvmClassName.byInternalName(partName).fqNameForTopLevelClassMaybeWithDollars)\n                    kotlinClassFinder.findKotlinClass(classId)\n                }\n            else listOf(fileClass)\n\n        val packageFragment = EmptyPackageFragmentDescriptor(resolver.components.moduleDescriptor, fqName)\n\n        val scopes = parts.mapNotNull { part ->\n            resolver.createKotlinPackagePartScope(packageFragment, part)\n        }.toList()\n\n        ChainedMemberScope.create(\"package $fqName ($fileClass)\", scopes)\n    }");
            return (MemberScope) obj;
        }
        throw null;
    }
}
