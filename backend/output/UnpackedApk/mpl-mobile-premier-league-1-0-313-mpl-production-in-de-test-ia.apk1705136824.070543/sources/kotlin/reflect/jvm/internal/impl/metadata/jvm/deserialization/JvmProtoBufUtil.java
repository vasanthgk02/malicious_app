package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: JvmProtoBufUtil.kt */
public final class JvmProtoBufUtil {
    public static final ExtensionRegistryLite EXTENSION_REGISTRY;
    public static final JvmProtoBufUtil INSTANCE = new JvmProtoBufUtil();

    static {
        ExtensionRegistryLite extensionRegistryLite = new ExtensionRegistryLite();
        extensionRegistryLite.add(JvmProtoBuf.constructorSignature);
        extensionRegistryLite.add(JvmProtoBuf.methodSignature);
        extensionRegistryLite.add(JvmProtoBuf.lambdaClassOriginName);
        extensionRegistryLite.add(JvmProtoBuf.propertySignature);
        extensionRegistryLite.add(JvmProtoBuf.flags);
        extensionRegistryLite.add(JvmProtoBuf.typeAnnotation);
        extensionRegistryLite.add(JvmProtoBuf.isRaw);
        extensionRegistryLite.add(JvmProtoBuf.typeParameterAnnotation);
        extensionRegistryLite.add(JvmProtoBuf.classModuleName);
        extensionRegistryLite.add(JvmProtoBuf.classLocalVariable);
        extensionRegistryLite.add(JvmProtoBuf.anonymousObjectOriginName);
        extensionRegistryLite.add(JvmProtoBuf.jvmClassFlags);
        extensionRegistryLite.add(JvmProtoBuf.packageModuleName);
        extensionRegistryLite.add(JvmProtoBuf.packageLocalVariable);
        Intrinsics.checkNotNullExpressionValue(extensionRegistryLite, "newInstance().apply(JvmProtoBuf::registerAllExtensions)");
        EXTENSION_REGISTRY = extensionRegistryLite;
    }

    public static final boolean isMovedFromInterfaceCompanion(ProtoBuf$Property protoBuf$Property) {
        Intrinsics.checkNotNullParameter(protoBuf$Property, "proto");
        JvmFlags jvmFlags = JvmFlags.INSTANCE;
        BooleanFlagField booleanFlagField = JvmFlags.IS_MOVED_FROM_INTERFACE_COMPANION;
        Object extension = protoBuf$Property.getExtension(JvmProtoBuf.flags);
        Intrinsics.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean bool = booleanFlagField.get(((Number) extension).intValue());
        Intrinsics.checkNotNullExpressionValue(bool, "JvmFlags.IS_MOVED_FROM_INTERFACE_COMPANION.get(proto.getExtension(JvmProtoBuf.flags))");
        return bool.booleanValue();
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Class> readClassDataFrom(String[] strArr, String[] strArr2) {
        Intrinsics.checkNotNullParameter(strArr, "data");
        Intrinsics.checkNotNullParameter(strArr2, "strings");
        byte[] decodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "decodeBytes(data)");
        Intrinsics.checkNotNullParameter(decodeBytes, "bytes");
        Intrinsics.checkNotNullParameter(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decodeBytes);
        StringTableTypes stringTableTypes = (StringTableTypes) ((AbstractParser) StringTableTypes.PARSER).parseDelimitedFrom(byteArrayInputStream, EXTENSION_REGISTRY);
        Intrinsics.checkNotNullExpressionValue(stringTableTypes, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        JvmNameResolver jvmNameResolver = new JvmNameResolver(stringTableTypes, strArr2);
        ExtensionRegistryLite extensionRegistryLite = EXTENSION_REGISTRY;
        AbstractParser abstractParser = (AbstractParser) ProtoBuf$Class.PARSER;
        MessageLite parsePartialFrom = abstractParser.parsePartialFrom(byteArrayInputStream, extensionRegistryLite);
        abstractParser.checkMessageInitialized(parsePartialFrom);
        return new Pair<>(jvmNameResolver, (ProtoBuf$Class) parsePartialFrom);
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Function> readFunctionDataFrom(String[] strArr, String[] strArr2) {
        Intrinsics.checkNotNullParameter(strArr, "data");
        Intrinsics.checkNotNullParameter(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(BitEncoding.decodeBytes(strArr));
        StringTableTypes stringTableTypes = (StringTableTypes) ((AbstractParser) StringTableTypes.PARSER).parseDelimitedFrom(byteArrayInputStream, EXTENSION_REGISTRY);
        Intrinsics.checkNotNullExpressionValue(stringTableTypes, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        JvmNameResolver jvmNameResolver = new JvmNameResolver(stringTableTypes, strArr2);
        ExtensionRegistryLite extensionRegistryLite = EXTENSION_REGISTRY;
        AbstractParser abstractParser = (AbstractParser) ProtoBuf$Function.PARSER;
        MessageLite parsePartialFrom = abstractParser.parsePartialFrom(byteArrayInputStream, extensionRegistryLite);
        abstractParser.checkMessageInitialized(parsePartialFrom);
        return new Pair<>(jvmNameResolver, (ProtoBuf$Function) parsePartialFrom);
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Package> readPackageDataFrom(String[] strArr, String[] strArr2) {
        Intrinsics.checkNotNullParameter(strArr, "data");
        Intrinsics.checkNotNullParameter(strArr2, "strings");
        byte[] decodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "decodeBytes(data)");
        Intrinsics.checkNotNullParameter(decodeBytes, "bytes");
        Intrinsics.checkNotNullParameter(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decodeBytes);
        StringTableTypes stringTableTypes = (StringTableTypes) ((AbstractParser) StringTableTypes.PARSER).parseDelimitedFrom(byteArrayInputStream, EXTENSION_REGISTRY);
        Intrinsics.checkNotNullExpressionValue(stringTableTypes, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        JvmNameResolver jvmNameResolver = new JvmNameResolver(stringTableTypes, strArr2);
        ExtensionRegistryLite extensionRegistryLite = EXTENSION_REGISTRY;
        AbstractParser abstractParser = (AbstractParser) ProtoBuf$Package.PARSER;
        MessageLite parsePartialFrom = abstractParser.parsePartialFrom(byteArrayInputStream, extensionRegistryLite);
        abstractParser.checkMessageInitialized(parsePartialFrom);
        return new Pair<>(jvmNameResolver, (ProtoBuf$Package) parsePartialFrom);
    }

    public final Method getJvmConstructorSignature(ProtoBuf$Constructor protoBuf$Constructor, NameResolver nameResolver, TypeTable typeTable) {
        String str;
        Intrinsics.checkNotNullParameter(protoBuf$Constructor, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedExtension<ProtoBuf$Constructor, JvmMethodSignature> generatedExtension = JvmProtoBuf.constructorSignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "constructorSignature");
        JvmMethodSignature jvmMethodSignature = (JvmMethodSignature) TweetUtils.getExtensionOrNull(protoBuf$Constructor, generatedExtension);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? "<init>" : nameResolver.getString(jvmMethodSignature.name_);
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            List<ProtoBuf$ValueParameter> list = protoBuf$Constructor.valueParameter_;
            Intrinsics.checkNotNullExpressionValue(list, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list) {
                Intrinsics.checkNotNullExpressionValue(protoBuf$ValueParameter, "it");
                String mapTypeDefault = mapTypeDefault(TweetUtils.type(protoBuf$ValueParameter, typeTable), nameResolver);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList.add(mapTypeDefault);
            }
            str = ArraysKt___ArraysJvmKt.joinToString$default(arrayList, "", "(", ")V", 0, null, null, 56);
        } else {
            str = nameResolver.getString(jvmMethodSignature.desc_);
        }
        return new Method(string, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0064 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field getJvmFieldSignature(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r7, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r8, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r9, boolean r10) {
        /*
            r6 = this;
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature> r0 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.propertySignature
            java.lang.String r1 = "propertySignature"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object r0 = com.twitter.sdk.android.tweetui.TweetUtils.getExtensionOrNull(r7, r0)
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r0 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r0
            r1 = 0
            if (r0 != 0) goto L_0x0021
            return r1
        L_0x0021:
            int r2 = r0.bitField0_
            r3 = 1
            r2 = r2 & r3
            r4 = 0
            if (r2 != r3) goto L_0x002a
            r2 = 1
            goto L_0x002b
        L_0x002a:
            r2 = 0
        L_0x002b:
            if (r2 == 0) goto L_0x0030
            kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r0 = r0.field_
            goto L_0x0031
        L_0x0030:
            r0 = r1
        L_0x0031:
            if (r0 != 0) goto L_0x0036
            if (r10 == 0) goto L_0x0036
            return r1
        L_0x0036:
            if (r0 == 0) goto L_0x0045
            int r10 = r0.bitField0_
            r10 = r10 & r3
            if (r10 != r3) goto L_0x003f
            r10 = 1
            goto L_0x0040
        L_0x003f:
            r10 = 0
        L_0x0040:
            if (r10 == 0) goto L_0x0045
            int r10 = r0.name_
            goto L_0x0047
        L_0x0045:
            int r10 = r7.name_
        L_0x0047:
            if (r0 == 0) goto L_0x005a
            int r2 = r0.bitField0_
            r5 = 2
            r2 = r2 & r5
            if (r2 != r5) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r3 = 0
        L_0x0051:
            if (r3 == 0) goto L_0x005a
            int r7 = r0.desc_
            java.lang.String r7 = r8.getString(r7)
            goto L_0x0065
        L_0x005a:
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r7 = com.twitter.sdk.android.tweetui.TweetUtils.returnType(r7, r9)
            java.lang.String r7 = r6.mapTypeDefault(r7, r8)
            if (r7 != 0) goto L_0x0065
            return r1
        L_0x0065:
            kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Field r9 = new kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Field
            java.lang.String r8 = r8.getString(r10)
            r9.<init>(r8, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.getJvmFieldSignature(kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable, boolean):kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature$Field");
    }

    public final Method getJvmMethodSignature(ProtoBuf$Function protoBuf$Function, NameResolver nameResolver, TypeTable typeTable) {
        int i;
        String str;
        ProtoBuf$Function protoBuf$Function2 = protoBuf$Function;
        NameResolver nameResolver2 = nameResolver;
        TypeTable typeTable2 = typeTable;
        Intrinsics.checkNotNullParameter(protoBuf$Function2, "proto");
        Intrinsics.checkNotNullParameter(nameResolver2, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable2, "typeTable");
        GeneratedExtension<ProtoBuf$Function, JvmMethodSignature> generatedExtension = JvmProtoBuf.methodSignature;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "methodSignature");
        JvmMethodSignature jvmMethodSignature = (JvmMethodSignature) TweetUtils.getExtensionOrNull(protoBuf$Function2, generatedExtension);
        if (jvmMethodSignature == null || !jvmMethodSignature.hasName()) {
            i = protoBuf$Function2.name_;
        } else {
            i = jvmMethodSignature.name_;
        }
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            List listOfNotNull = TweetUtils.listOfNotNull(TweetUtils.receiverType(protoBuf$Function2, typeTable2));
            List<ProtoBuf$ValueParameter> list = protoBuf$Function2.valueParameter_;
            Intrinsics.checkNotNullExpressionValue(list, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list) {
                Intrinsics.checkNotNullExpressionValue(protoBuf$ValueParameter, "it");
                arrayList.add(TweetUtils.type(protoBuf$ValueParameter, typeTable2));
            }
            List plus = ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) listOfNotNull, (Iterable<? extends T>) arrayList);
            ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(plus, 10));
            Iterator it = ((ArrayList) plus).iterator();
            while (it.hasNext()) {
                String mapTypeDefault = mapTypeDefault((ProtoBuf$Type) it.next(), nameResolver2);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList2.add(mapTypeDefault);
            }
            String mapTypeDefault2 = mapTypeDefault(TweetUtils.returnType(protoBuf$Function2, typeTable2), nameResolver2);
            if (mapTypeDefault2 == null) {
                return null;
            }
            str = Intrinsics.stringPlus(ArraysKt___ArraysJvmKt.joinToString$default(arrayList2, "", "(", ")", 0, null, null, 56), mapTypeDefault2);
        } else {
            str = nameResolver2.getString(jvmMethodSignature.desc_);
        }
        return new Method(nameResolver2.getString(i), str);
    }

    public final String mapTypeDefault(ProtoBuf$Type protoBuf$Type, NameResolver nameResolver) {
        if (!protoBuf$Type.hasClassName()) {
            return null;
        }
        ClassMapperLite classMapperLite = ClassMapperLite.INSTANCE;
        return ClassMapperLite.mapClass(nameResolver.getQualifiedClassName(protoBuf$Type.className_));
    }
}
