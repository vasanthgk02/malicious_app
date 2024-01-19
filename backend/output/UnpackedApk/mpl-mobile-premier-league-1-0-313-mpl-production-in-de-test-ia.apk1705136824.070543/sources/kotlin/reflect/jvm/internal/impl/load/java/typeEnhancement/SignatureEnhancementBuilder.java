package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.smartfoxserver.v2.protocol.serialization.DefaultSFSDataSerializer;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.IndexingIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents$jvmDescriptor$1;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: predefinedEnhancementInfo.kt */
public final class SignatureEnhancementBuilder {
    public final Map<String, PredefinedFunctionEnhancementInfo> signatures = new LinkedHashMap();

    /* compiled from: predefinedEnhancementInfo.kt */
    public final class ClassEnhancementBuilder {
        public final String className;
        public final /* synthetic */ SignatureEnhancementBuilder this$0;

        /* compiled from: predefinedEnhancementInfo.kt */
        public final class FunctionEnhancementBuilder {
            public final String functionName;
            public final List<Pair<String, TypeEnhancementInfo>> parameters = new ArrayList();
            public Pair<String, TypeEnhancementInfo> returnType = new Pair<>(DefaultSFSDataSerializer.FIELD_VALUE_KEY, null);
            public final /* synthetic */ ClassEnhancementBuilder this$0;

            public FunctionEnhancementBuilder(ClassEnhancementBuilder classEnhancementBuilder, String str) {
                Intrinsics.checkNotNullParameter(classEnhancementBuilder, "this$0");
                Intrinsics.checkNotNullParameter(str, "functionName");
                this.this$0 = classEnhancementBuilder;
                this.functionName = str;
            }

            public final void parameter(String str, JavaTypeQualifiers... javaTypeQualifiersArr) {
                TypeEnhancementInfo typeEnhancementInfo;
                Intrinsics.checkNotNullParameter(str, "type");
                Intrinsics.checkNotNullParameter(javaTypeQualifiersArr, "qualifiers");
                List<Pair<String, TypeEnhancementInfo>> list = this.parameters;
                if (javaTypeQualifiersArr.length == 0) {
                    typeEnhancementInfo = null;
                } else {
                    Iterable withIndex = TweetUtils.withIndex(javaTypeQualifiersArr);
                    int mapCapacity = TweetUtils.mapCapacity(TweetUtils.collectionSizeOrDefault(withIndex, 10));
                    if (mapCapacity < 16) {
                        mapCapacity = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
                    Iterator it = ((IndexingIterable) withIndex).iterator();
                    while (true) {
                        IndexingIterator indexingIterator = (IndexingIterator) it;
                        if (!indexingIterator.hasNext()) {
                            break;
                        }
                        IndexedValue indexedValue = (IndexedValue) indexingIterator.next();
                        linkedHashMap.put(Integer.valueOf(indexedValue.index), (JavaTypeQualifiers) indexedValue.value);
                    }
                    typeEnhancementInfo = new TypeEnhancementInfo(linkedHashMap);
                }
                list.add(new Pair(str, typeEnhancementInfo));
            }

            public final void returns(String str, JavaTypeQualifiers... javaTypeQualifiersArr) {
                Intrinsics.checkNotNullParameter(str, "type");
                Intrinsics.checkNotNullParameter(javaTypeQualifiersArr, "qualifiers");
                Iterable withIndex = TweetUtils.withIndex(javaTypeQualifiersArr);
                int mapCapacity = TweetUtils.mapCapacity(TweetUtils.collectionSizeOrDefault(withIndex, 10));
                if (mapCapacity < 16) {
                    mapCapacity = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
                Iterator it = ((IndexingIterable) withIndex).iterator();
                while (true) {
                    IndexingIterator indexingIterator = (IndexingIterator) it;
                    if (indexingIterator.hasNext()) {
                        IndexedValue indexedValue = (IndexedValue) indexingIterator.next();
                        linkedHashMap.put(Integer.valueOf(indexedValue.index), (JavaTypeQualifiers) indexedValue.value);
                    } else {
                        this.returnType = new Pair<>(str, new TypeEnhancementInfo(linkedHashMap));
                        return;
                    }
                }
            }

            public final void returns(JvmPrimitiveType jvmPrimitiveType) {
                Intrinsics.checkNotNullParameter(jvmPrimitiveType, "type");
                String desc = jvmPrimitiveType.getDesc();
                Intrinsics.checkNotNullExpressionValue(desc, "type.desc");
                this.returnType = new Pair<>(desc, null);
            }
        }

        public ClassEnhancementBuilder(SignatureEnhancementBuilder signatureEnhancementBuilder, String str) {
            Intrinsics.checkNotNullParameter(signatureEnhancementBuilder, "this$0");
            Intrinsics.checkNotNullParameter(str, "className");
            this.this$0 = signatureEnhancementBuilder;
            this.className = str;
        }

        public final void function(String str, Function1<? super FunctionEnhancementBuilder, Unit> function1) {
            String str2 = str;
            Function1<? super FunctionEnhancementBuilder, Unit> function12 = function1;
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(function12, "block");
            Map<String, PredefinedFunctionEnhancementInfo> map = this.this$0.signatures;
            FunctionEnhancementBuilder functionEnhancementBuilder = new FunctionEnhancementBuilder(this, str2);
            function12.invoke(functionEnhancementBuilder);
            SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            String str3 = functionEnhancementBuilder.this$0.className;
            String str4 = functionEnhancementBuilder.functionName;
            List<Pair<String, TypeEnhancementInfo>> list = functionEnhancementBuilder.parameters;
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
            for (Pair pair : list) {
                arrayList.add((String) pair.first);
            }
            String str5 = (String) functionEnhancementBuilder.returnType.first;
            Intrinsics.checkNotNullParameter(str4, "name");
            Intrinsics.checkNotNullParameter(arrayList, BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY);
            Intrinsics.checkNotNullParameter(str5, "ret");
            String signature = signatureBuildingComponents.signature(str3, str4 + '(' + ArraysKt___ArraysJvmKt.joinToString$default(arrayList, "", null, null, 0, null, new SignatureBuildingComponents$jvmDescriptor$1(signatureBuildingComponents), 30) + ')' + signatureBuildingComponents.escapeClassName(str5));
            TypeEnhancementInfo typeEnhancementInfo = (TypeEnhancementInfo) functionEnhancementBuilder.returnType.second;
            List<Pair<String, TypeEnhancementInfo>> list2 = functionEnhancementBuilder.parameters;
            ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(list2, 10));
            for (Pair pair2 : list2) {
                arrayList2.add((TypeEnhancementInfo) pair2.second);
            }
            map.put(signature, new PredefinedFunctionEnhancementInfo(typeEnhancementInfo, arrayList2));
        }
    }
}
