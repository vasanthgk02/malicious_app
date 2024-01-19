package com.facebook.appevents.ml;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.internal.FileDownloadTask.Callback;
import com.facebook.appevents.suggestedevents.$$Lambda$bPTNKB1roqNzalSpP7WmTIMErc;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.netcore.android.notification.SMTNotificationConstants;
import com.rudderstack.android.sdk.core.RudderTraits;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.CharsKt__CharKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u000278B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0007J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0002J\u0014\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001bH\u0002J9\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\u0006\u0010!\u001a\u00020\"2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020'0-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040-H\u0007¢\u0006\u0002\u00100J%\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020'H\u0002¢\u0006\u0002\u00105J%\u00106\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020'H\u0002¢\u0006\u0002\u00105R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u001c\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager;", "", "()V", "ASSET_URI_KEY", "", "CACHE_KEY_MODELS", "CACHE_KEY_REQUEST_TIMESTAMP", "MODEL_ASSERT_STORE", "MODEL_REQUEST_INTERVAL_MILLISECONDS", "", "MTML_INTEGRITY_DETECT_PREDICTION", "", "MTML_SUGGESTED_EVENTS_PREDICTION", "MTML_USE_CASE", "RULES_URI_KEY", "THRESHOLD_KEY", "USE_CASE_KEY", "VERSION_ID_KEY", "isLocaleEnglish", "", "()Z", "taskHandlers", "", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "addModels", "", "models", "Lorg/json/JSONObject;", "enable", "enableMTML", "fetchModels", "getRuleFile", "Ljava/io/File;", "task", "Lcom/facebook/appevents/ml/ModelManager$Task;", "isValidTimestamp", "timestamp", "", "parseJsonArray", "", "jsonArray", "Lorg/json/JSONArray;", "parseRawJsonObject", "jsonObject", "predict", "", "denses", "texts", "(Lcom/facebook/appevents/ml/ModelManager$Task;[[F[Ljava/lang/String;)[Ljava/lang/String;", "processIntegrityDetectionResult", "res", "Lcom/facebook/appevents/ml/MTensor;", "thresholds", "(Lcom/facebook/appevents/ml/MTensor;[F)[Ljava/lang/String;", "processSuggestedEventResult", "Task", "TaskHandler", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ModelManager.kt */
public final class ModelManager {
    public static final ModelManager INSTANCE = new ModelManager();
    public static final List<String> MTML_INTEGRITY_DETECT_PREDICTION = TweetUtils.listOf((T[]) new String[]{"none", RudderTraits.ADDRESS_KEY, "health"});
    public static final List<String> MTML_SUGGESTED_EVENTS_PREDICTION = TweetUtils.listOf((T[]) new String[]{SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER, "fb_mobile_complete_registration", "fb_mobile_add_to_cart", "fb_mobile_purchase", "fb_mobile_initiated_checkout"});
    public static final Map<String, TaskHandler> taskHandlers = new ConcurrentHashMap();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$Task;", "", "(Ljava/lang/String;I)V", "toKey", "", "toUseCase", "MTML_INTEGRITY_DETECT", "MTML_APP_EVENT_PREDICTION", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ModelManager.kt */
    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        public final String toKey() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "integrity_detect";
            }
            if (ordinal == 1) {
                return "app_event_pred";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String toUseCase() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (ordinal == 1) {
                return "MTML_APP_EVENT_PRED";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 *2\u00020\u0001:\u0001*B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010)\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "", "useCase", "", "assetUri", "ruleUri", "versionId", "", "thresholds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[F)V", "getAssetUri", "()Ljava/lang/String;", "setAssetUri", "(Ljava/lang/String;)V", "model", "Lcom/facebook/appevents/ml/Model;", "getModel", "()Lcom/facebook/appevents/ml/Model;", "setModel", "(Lcom/facebook/appevents/ml/Model;)V", "onPostExecute", "Ljava/lang/Runnable;", "ruleFile", "Ljava/io/File;", "getRuleFile", "()Ljava/io/File;", "setRuleFile", "(Ljava/io/File;)V", "getRuleUri", "setRuleUri", "getThresholds", "()[F", "setThresholds", "([F)V", "getUseCase", "setUseCase", "getVersionId", "()I", "setVersionId", "(I)V", "setOnPostExecute", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ModelManager.kt */
    public static final class TaskHandler {
        public String assetUri;
        public Model model;
        public Runnable onPostExecute;
        public File ruleFile;
        public String ruleUri;
        public float[] thresholds;
        public String useCase;
        public int versionId;

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004J\u001c\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler$Companion;", "", "()V", "build", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "json", "Lorg/json/JSONObject;", "deleteOldFiles", "", "useCase", "", "versionId", "", "download", "uri", "name", "onComplete", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "execute", "handler", "master", "slaves", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: ModelManager.kt */
        public static final class Companion {
            public static final TaskHandler build(JSONObject jSONObject) {
                float[] fArr;
                if (jSONObject == null) {
                    return null;
                }
                try {
                    String string = jSONObject.getString("use_case");
                    String string2 = jSONObject.getString("asset_uri");
                    String optString = jSONObject.optString("rules_uri", null);
                    int i = jSONObject.getInt("version_id");
                    ModelManager modelManager = ModelManager.INSTANCE;
                    JSONArray jSONArray = jSONObject.getJSONArray("thresholds");
                    Class<ModelManager> cls = ModelManager.class;
                    if (!CrashShieldHandler.isObjectCrashing(cls)) {
                        try {
                            if (!CrashShieldHandler.isObjectCrashing(modelManager) && jSONArray != null) {
                                fArr = new float[jSONArray.length()];
                                int i2 = 0;
                                int length = jSONArray.length();
                                if (length > 0) {
                                    while (true) {
                                        int i3 = i2 + 1;
                                        try {
                                            String string3 = jSONArray.getString(i2);
                                            Intrinsics.checkNotNullExpressionValue(string3, "jsonArray.getString(i)");
                                            fArr[i2] = Float.parseFloat(string3);
                                        } catch (JSONException unused) {
                                        }
                                        if (i3 >= length) {
                                            break;
                                        }
                                        i2 = i3;
                                    }
                                }
                                Intrinsics.checkNotNullExpressionValue(string, "useCase");
                                Intrinsics.checkNotNullExpressionValue(string2, "assetUri");
                                TaskHandler taskHandler = new TaskHandler(string, string2, optString, i, fArr);
                                return taskHandler;
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, cls);
                        }
                    }
                    fArr = null;
                    Intrinsics.checkNotNullExpressionValue(string, "useCase");
                    Intrinsics.checkNotNullExpressionValue(string2, "assetUri");
                    TaskHandler taskHandler2 = new TaskHandler(string, string2, optString, i, fArr);
                    return taskHandler2;
                } catch (Exception unused2) {
                    return null;
                }
            }

            public static final void download(String str, String str2, Callback callback) {
                File file = new File(Utils.getMlDir(), str2);
                if (str == null || file.exists()) {
                    callback.onComplete(file);
                } else {
                    new FileDownloadTask(str, file, callback).execute(new String[0]);
                }
            }

            public static final void execute(TaskHandler taskHandler, List<TaskHandler> list) {
                Intrinsics.checkNotNullParameter(taskHandler, "master");
                Intrinsics.checkNotNullParameter(list, "slaves");
                String str = taskHandler.useCase;
                int i = taskHandler.versionId;
                File mlDir = Utils.getMlDir();
                if (mlDir != null) {
                    File[] listFiles = mlDir.listFiles();
                    if (listFiles != null) {
                        if (!(listFiles.length == 0)) {
                            String str2 = str + '_' + i;
                            int length = listFiles.length;
                            int i2 = 0;
                            while (i2 < length) {
                                File file = listFiles[i2];
                                i2++;
                                String name = file.getName();
                                Intrinsics.checkNotNullExpressionValue(name, "name");
                                if (CharsKt__CharKt.startsWith$default(name, str, false, 2) && !CharsKt__CharKt.startsWith$default(name, str2, false, 2)) {
                                    file.delete();
                                }
                            }
                        }
                    }
                }
                download(taskHandler.assetUri, taskHandler.useCase + '_' + taskHandler.versionId, new Callback(list) {
                    public final /* synthetic */ List f$0;

                    public final 
/*
Method generation error in method: com.facebook.appevents.ml.-$$Lambda$tuOAgqtZTdthPCm1H_2rgX2tsR0.onComplete(java.io.File):null, dex: classes2.dex
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
                    	at jadx.core.codegen.ClassGen.useType(ClassGen.java:441)
                    	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:109)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:310)
                    	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:261)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:657)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:591)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:349)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:216)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:769)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:709)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:353)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:235)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:206)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:315)
                    	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:261)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:109)
                    	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:223)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:109)
                    	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:223)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:109)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                    
*/
                });
            }

            /* JADX WARNING: Removed duplicated region for block: B:54:0x0107  */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x0142  */
            /* JADX WARNING: Removed duplicated region for block: B:87:0x0133 A[EDGE_INSN: B:87:0x0133->B:60:0x0133 ?: BREAK  , SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:95:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
            /* renamed from: execute$lambda-1  reason: not valid java name */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public static final void m180execute$lambda1(java.util.List<com.facebook.appevents.ml.ModelManager.TaskHandler> r17, java.io.File r18) {
                /*
                    r0 = r18
                    java.lang.String r1 = "$slaves"
                    r2 = r17
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
                    java.lang.String r1 = "file"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                    com.facebook.appevents.ml.Model r3 = com.facebook.appevents.ml.Model.Companion
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                    java.lang.Class<com.facebook.appevents.ml.Utils> r3 = com.facebook.appevents.ml.Utils.class
                    boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r3)
                    r5 = 0
                    if (r4 == 0) goto L_0x001e
                    goto L_0x00df
                L_0x001e:
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)     // Catch:{ all -> 0x00db }
                    java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00df }
                    r1.<init>(r0)     // Catch:{ Exception -> 0x00df }
                    int r0 = r1.available()     // Catch:{ Exception -> 0x00df }
                    java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ Exception -> 0x00df }
                    r4.<init>(r1)     // Catch:{ Exception -> 0x00df }
                    byte[] r1 = new byte[r0]     // Catch:{ Exception -> 0x00df }
                    r4.readFully(r1)     // Catch:{ Exception -> 0x00df }
                    r4.close()     // Catch:{ Exception -> 0x00df }
                    r4 = 4
                    if (r0 >= r4) goto L_0x003c
                    goto L_0x00df
                L_0x003c:
                    java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r1, r5, r4)     // Catch:{ Exception -> 0x00df }
                    java.nio.ByteOrder r6 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x00df }
                    r5.order(r6)     // Catch:{ Exception -> 0x00df }
                    int r5 = r5.getInt()     // Catch:{ Exception -> 0x00df }
                    int r6 = r5 + 4
                    if (r0 >= r6) goto L_0x004f
                    goto L_0x00df
                L_0x004f:
                    java.lang.String r7 = new java.lang.String     // Catch:{ Exception -> 0x00df }
                    java.nio.charset.Charset r8 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x00df }
                    r7.<init>(r1, r4, r5, r8)     // Catch:{ Exception -> 0x00df }
                    org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00df }
                    r4.<init>(r7)     // Catch:{ Exception -> 0x00df }
                    org.json.JSONArray r5 = r4.names()     // Catch:{ Exception -> 0x00df }
                    int r7 = r5.length()     // Catch:{ Exception -> 0x00df }
                    java.lang.String[] r8 = new java.lang.String[r7]     // Catch:{ Exception -> 0x00df }
                    int r9 = r7 + -1
                    if (r9 < 0) goto L_0x0077
                    r10 = 0
                L_0x006a:
                    int r11 = r10 + 1
                    java.lang.String r12 = r5.getString(r10)     // Catch:{ Exception -> 0x00df }
                    r8[r10] = r12     // Catch:{ Exception -> 0x00df }
                    if (r11 <= r9) goto L_0x0075
                    goto L_0x0077
                L_0x0075:
                    r10 = r11
                    goto L_0x006a
                L_0x0077:
                    java.lang.String r5 = "<this>"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r5)     // Catch:{ Exception -> 0x00df }
                    r5 = 1
                    if (r7 <= r5) goto L_0x0082
                    java.util.Arrays.sort(r8)     // Catch:{ Exception -> 0x00df }
                L_0x0082:
                    java.util.HashMap r5 = new java.util.HashMap     // Catch:{ Exception -> 0x00df }
                    r5.<init>()     // Catch:{ Exception -> 0x00df }
                    r9 = 0
                L_0x0088:
                    if (r9 >= r7) goto L_0x00e0
                    r10 = r8[r9]     // Catch:{ Exception -> 0x00df }
                    int r9 = r9 + 1
                    if (r10 != 0) goto L_0x0091
                    goto L_0x0088
                L_0x0091:
                    org.json.JSONArray r11 = r4.getJSONArray(r10)     // Catch:{ Exception -> 0x00df }
                    int r12 = r11.length()     // Catch:{ Exception -> 0x00df }
                    int[] r13 = new int[r12]     // Catch:{ Exception -> 0x00df }
                    int r12 = r12 + -1
                    if (r12 < 0) goto L_0x00b4
                    r14 = 0
                    r15 = 1
                L_0x00a1:
                    int r2 = r14 + 1
                    int r16 = r11.getInt(r14)     // Catch:{ Exception -> 0x00df }
                    r13[r14] = r16     // Catch:{ Exception -> 0x00df }
                    r14 = r13[r14]     // Catch:{ Exception -> 0x00df }
                    int r15 = r15 * r14
                    if (r2 <= r12) goto L_0x00b0
                    goto L_0x00b5
                L_0x00b0:
                    r14 = r2
                    r2 = r17
                    goto L_0x00a1
                L_0x00b4:
                    r15 = 1
                L_0x00b5:
                    int r2 = r15 * 4
                    int r11 = r6 + r2
                    if (r11 <= r0) goto L_0x00bc
                    goto L_0x00df
                L_0x00bc:
                    java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r1, r6, r2)     // Catch:{ Exception -> 0x00df }
                    java.nio.ByteOrder r6 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x00df }
                    r2.order(r6)     // Catch:{ Exception -> 0x00df }
                    com.facebook.appevents.ml.MTensor r6 = new com.facebook.appevents.ml.MTensor     // Catch:{ Exception -> 0x00df }
                    r6.<init>(r13)     // Catch:{ Exception -> 0x00df }
                    java.nio.FloatBuffer r2 = r2.asFloatBuffer()     // Catch:{ Exception -> 0x00df }
                    float[] r12 = r6.data     // Catch:{ Exception -> 0x00df }
                    r13 = 0
                    r2.get(r12, r13, r15)     // Catch:{ Exception -> 0x00df }
                    r5.put(r10, r6)     // Catch:{ Exception -> 0x00df }
                    r2 = r17
                    r6 = r11
                    goto L_0x0088
                L_0x00db:
                    r0 = move-exception
                    com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r3)
                L_0x00df:
                    r5 = 0
                L_0x00e0:
                    if (r5 == 0) goto L_0x0132
                    java.util.HashMap r1 = new java.util.HashMap
                    r1.<init>()
                    java.lang.Class<com.facebook.appevents.ml.Model> r2 = com.facebook.appevents.ml.Model.class
                    boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)
                    if (r0 == 0) goto L_0x00f0
                    goto L_0x00f8
                L_0x00f0:
                    java.util.Map<java.lang.String, java.lang.String> r0 = com.facebook.appevents.ml.Model.mapping     // Catch:{ all -> 0x00f3 }
                    goto L_0x00f9
                L_0x00f3:
                    r0 = move-exception
                    r3 = r0
                    com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r2)
                L_0x00f8:
                    r0 = 0
                L_0x00f9:
                    java.util.Set r2 = r5.entrySet()
                    java.util.Iterator r2 = r2.iterator()
                L_0x0101:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto L_0x0133
                    java.lang.Object r3 = r2.next()
                    java.util.Map$Entry r3 = (java.util.Map.Entry) r3
                    java.lang.Object r4 = r3.getKey()
                    java.lang.String r4 = (java.lang.String) r4
                    java.lang.Object r5 = r3.getKey()
                    boolean r5 = r0.containsKey(r5)
                    if (r5 == 0) goto L_0x012a
                    java.lang.Object r4 = r3.getKey()
                    java.lang.Object r4 = r0.get(r4)
                    java.lang.String r4 = (java.lang.String) r4
                    if (r4 != 0) goto L_0x012a
                    goto L_0x0132
                L_0x012a:
                    java.lang.Object r3 = r3.getValue()
                    r1.put(r4, r3)
                    goto L_0x0101
                L_0x0132:
                    r1 = 0
                L_0x0133:
                    if (r1 != 0) goto L_0x0136
                    goto L_0x013f
                L_0x0136:
                    com.facebook.appevents.ml.Model r0 = new com.facebook.appevents.ml.Model     // Catch:{ Exception -> 0x013f }
                    r2 = 0
                    r0.<init>(r1, r2)     // Catch:{ Exception -> 0x013d }
                    goto L_0x0140
                L_0x013d:
                    r0 = r2
                    goto L_0x0140
                L_0x013f:
                    r0 = 0
                L_0x0140:
                    if (r0 == 0) goto L_0x0192
                    java.util.Iterator r1 = r17.iterator()
                L_0x0146:
                    boolean r2 = r1.hasNext()
                    if (r2 == 0) goto L_0x0192
                    java.lang.Object r2 = r1.next()
                    com.facebook.appevents.ml.ModelManager$TaskHandler r2 = (com.facebook.appevents.ml.ModelManager.TaskHandler) r2
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = r2.useCase
                    r3.append(r4)
                    r4 = 95
                    r3.append(r4)
                    int r4 = r2.versionId
                    java.lang.String r5 = "_rule"
                    java.lang.String r3 = com.android.tools.r8.GeneratedOutlineSupport.outline57(r3, r4, r5)
                    java.lang.String r4 = r2.ruleUri
                    com.facebook.appevents.ml.-$$Lambda$RiKUFcSTGa2hv93aQw_DYc3SLEI r5 = new com.facebook.appevents.ml.-$$Lambda$RiKUFcSTGa2hv93aQw_DYc3SLEI
                    r5.<init>(r2, r0)
                    java.io.File r2 = new java.io.File
                    java.io.File r6 = com.facebook.appevents.ml.Utils.getMlDir()
                    r2.<init>(r6, r3)
                    if (r4 == 0) goto L_0x018e
                    boolean r3 = r2.exists()
                    if (r3 == 0) goto L_0x0182
                    goto L_0x018e
                L_0x0182:
                    com.facebook.appevents.internal.FileDownloadTask r3 = new com.facebook.appevents.internal.FileDownloadTask
                    r3.<init>(r4, r2, r5)
                    r2 = 0
                    java.lang.String[] r2 = new java.lang.String[r2]
                    r3.execute(r2)
                    goto L_0x0146
                L_0x018e:
                    r5.onComplete(r2)
                    goto L_0x0146
                L_0x0192:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.TaskHandler.Companion.m180execute$lambda1(java.util.List, java.io.File):void");
            }

            /* renamed from: execute$lambda-1$lambda-0  reason: not valid java name */
            public static final void m181execute$lambda1$lambda0(TaskHandler taskHandler, Model model, File file) {
                Intrinsics.checkNotNullParameter(taskHandler, "$slave");
                Intrinsics.checkNotNullParameter(file, "file");
                taskHandler.model = model;
                taskHandler.ruleFile = file;
                Runnable runnable = taskHandler.onPostExecute;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        public TaskHandler(String str, String str2, String str3, int i, float[] fArr) {
            Intrinsics.checkNotNullParameter(str, "useCase");
            Intrinsics.checkNotNullParameter(str2, "assetUri");
            this.useCase = str;
            this.assetUri = str2;
            this.ruleUri = str3;
            this.versionId = i;
            this.thresholds = fArr;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        if (r5 == false) goto L_0x0071;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069  */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m177enable$lambda0() {
        /*
            java.lang.String r0 = "model_request_timestamp"
            java.lang.String r1 = "models"
            java.lang.Class<com.facebook.appevents.ml.ModelManager> r2 = com.facebook.appevents.ml.ModelManager.class
            boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)
            if (r3 == 0) goto L_0x000d
            return
        L_0x000d:
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            java.lang.String r4 = "com.facebook.internal.MODEL_STORE"
            r5 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r5)     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            r4 = 0
            java.lang.String r4 = r3.getString(r1, r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            r6 = 1
            if (r4 == 0) goto L_0x0034
            int r7 = r4.length()     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            if (r7 != 0) goto L_0x002a
            r7 = 1
            goto L_0x002b
        L_0x002a:
            r7 = 0
        L_0x002b:
            if (r7 == 0) goto L_0x002e
            goto L_0x0034
        L_0x002e:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            r7.<init>(r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            goto L_0x0039
        L_0x0034:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            r7.<init>()     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
        L_0x0039:
            r8 = 0
            long r10 = r3.getLong(r0, r8)     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            com.facebook.internal.FeatureManager r4 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            com.facebook.internal.FeatureManager$Feature r4 = com.facebook.internal.FeatureManager.Feature.ModelRequest     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            boolean r4 = com.facebook.internal.FeatureManager.isEnabled(r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            if (r4 == 0) goto L_0x0071
            int r4 = r7.length()     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            if (r4 == 0) goto L_0x0071
            com.facebook.appevents.ml.ModelManager r4 = INSTANCE     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            boolean r12 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            if (r12 == 0) goto L_0x0058
            goto L_0x006f
        L_0x0058:
            int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r12 != 0) goto L_0x005d
            goto L_0x006f
        L_0x005d:
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x006b }
            long r8 = r8 - r10
            r10 = 259200000(0xf731400, double:1.280618154E-315)
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 >= 0) goto L_0x006f
            r5 = 1
            goto L_0x006f
        L_0x006b:
            r6 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r6, r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
        L_0x006f:
            if (r5 != 0) goto L_0x0091
        L_0x0071:
            com.facebook.appevents.ml.ModelManager r4 = INSTANCE     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            org.json.JSONObject r7 = r4.fetchModels()     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            if (r7 != 0) goto L_0x007a
            return
        L_0x007a:
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            android.content.SharedPreferences$Editor r1 = r3.putString(r1, r4)     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r3)     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            r0.apply()     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
        L_0x0091:
            com.facebook.appevents.ml.ModelManager r0 = INSTANCE     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            r0.addModels(r7)     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            com.facebook.appevents.ml.ModelManager r0 = INSTANCE     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            r0.enableMTML()     // Catch:{ Exception -> 0x00a0, all -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r2)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.m177enable$lambda0():void");
    }

    /* renamed from: enableMTML$lambda-1  reason: not valid java name */
    public static final void m178enableMTML$lambda1() {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                SuggestedEventsManager suggestedEventsManager = SuggestedEventsManager.INSTANCE;
                Class<SuggestedEventsManager> cls2 = SuggestedEventsManager.class;
                synchronized (cls2) {
                    if (!CrashShieldHandler.isObjectCrashing(cls2)) {
                        try {
                            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                            FacebookSdk.getExecutor().execute($$Lambda$bPTNKB1roqNzalSpP7WmTIMErc.INSTANCE);
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, cls2);
                        }
                    }
                }
                return;
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
                return;
            }
        } else {
            return;
        }
    }

    /* renamed from: enableMTML$lambda-2  reason: not valid java name */
    public static final void m179enableMTML$lambda2() {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            Class<IntegrityManager> cls2 = IntegrityManager.class;
            try {
                if (!CrashShieldHandler.isObjectCrashing(cls2)) {
                    IntegrityManager.enabled = true;
                    FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    IntegrityManager.isSampleEnabled = FetchedAppGateKeepersManager.getGateKeeperForKey("FBSDKFeatureIntegritySample", FacebookSdk.getApplicationId(), false);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final File getRuleFile(Task task) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(task, "task");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                return null;
            }
            return taskHandler.ruleFile;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final String[] predict(Task task, float[][] fArr, String[] strArr) {
        Model model;
        Class<ModelManager> cls = ModelManager.class;
        String[] strArr2 = null;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(fArr, "denses");
            Intrinsics.checkNotNullParameter(strArr, "texts");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                model = null;
            } else {
                model = taskHandler.model;
            }
            if (model == null) {
                return null;
            }
            float[] fArr2 = taskHandler.thresholds;
            int length = strArr.length;
            boolean z = false;
            int length2 = fArr[0].length;
            MTensor mTensor = new MTensor(new int[]{length, length2});
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    System.arraycopy(fArr[i], 0, mTensor.data, i * length2, length2);
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            MTensor predictOnMTML = model.predictOnMTML(mTensor, strArr, task.toKey());
            if (!(predictOnMTML == null || fArr2 == null)) {
                if (!(predictOnMTML.data.length == 0)) {
                    if (fArr2.length == 0) {
                        z = true;
                    }
                    if (!z) {
                        int ordinal = task.ordinal();
                        if (ordinal == 0) {
                            strArr2 = INSTANCE.processIntegrityDetectionResult(predictOnMTML, fArr2);
                        } else if (ordinal == 1) {
                            strArr2 = INSTANCE.processSuggestedEventResult(predictOnMTML, fArr2);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            }
            return strArr2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public final void addModels(JSONObject jSONObject) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        TaskHandler build = Companion.build(jSONObject.getJSONObject(keys.next()));
                        if (build != null) {
                            taskHandlers.put(build.useCase, build);
                        }
                    } catch (JSONException unused) {
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006e, code lost:
        if (kotlin.text.CharsKt__CharKt.contains$default((java.lang.CharSequence) r7, (java.lang.CharSequence) com.mpl.androidapp.imagepicker.HyperVergeKycCapture.EN, false, 2) != false) goto L_0x0070;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079 A[Catch:{ all -> 0x0072, all -> 0x00c1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void enableMTML() {
        /*
            r11 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r11)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00c1 }
            r0.<init>()     // Catch:{ all -> 0x00c1 }
            r1 = 0
            java.util.Map<java.lang.String, com.facebook.appevents.ml.ModelManager$TaskHandler> r2 = taskHandlers     // Catch:{ all -> 0x00c1 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x00c1 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00c1 }
            r3 = 0
            r4 = 0
            r7 = r1
            r9 = 0
        L_0x001b:
            boolean r1 = r2.hasNext()     // Catch:{ all -> 0x00c1 }
            if (r1 == 0) goto L_0x00a9
            java.lang.Object r1 = r2.next()     // Catch:{ all -> 0x00c1 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x00c1 }
            java.lang.Object r4 = r1.getKey()     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x00c1 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x00c1 }
            com.facebook.appevents.ml.ModelManager$TaskHandler r1 = (com.facebook.appevents.ml.ModelManager.TaskHandler) r1     // Catch:{ all -> 0x00c1 }
            com.facebook.appevents.ml.ModelManager$Task r5 = com.facebook.appevents.ml.ModelManager.Task.MTML_APP_EVENT_PREDICTION     // Catch:{ all -> 0x00c1 }
            java.lang.String r5 = r5.toUseCase()     // Catch:{ all -> 0x00c1 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ all -> 0x00c1 }
            if (r5 == 0) goto L_0x0082
            java.lang.String r5 = r1.assetUri     // Catch:{ all -> 0x00c1 }
            int r6 = r1.versionId     // Catch:{ all -> 0x00c1 }
            int r6 = java.lang.Math.max(r9, r6)     // Catch:{ all -> 0x00c1 }
            com.facebook.internal.FeatureManager r7 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x00c1 }
            com.facebook.internal.FeatureManager$Feature r7 = com.facebook.internal.FeatureManager.Feature.SuggestedEvents     // Catch:{ all -> 0x00c1 }
            boolean r7 = com.facebook.internal.FeatureManager.isEnabled(r7)     // Catch:{ all -> 0x00c1 }
            if (r7 == 0) goto L_0x0080
            boolean r7 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r11)     // Catch:{ all -> 0x00c1 }
            if (r7 == 0) goto L_0x0058
            goto L_0x0076
        L_0x0058:
            java.util.Locale r7 = com.facebook.internal.Utility.getResourceLocale()     // Catch:{ all -> 0x0072 }
            if (r7 == 0) goto L_0x0070
            java.lang.String r7 = r7.getLanguage()     // Catch:{ all -> 0x0072 }
            java.lang.String r8 = "locale.language"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)     // Catch:{ all -> 0x0072 }
            java.lang.String r8 = "en"
            r9 = 2
            boolean r7 = kotlin.text.CharsKt__CharKt.contains$default(r7, r8, r3, r9)     // Catch:{ all -> 0x0072 }
            if (r7 == 0) goto L_0x0076
        L_0x0070:
            r7 = 1
            goto L_0x0077
        L_0x0072:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r11)     // Catch:{ all -> 0x00c1 }
        L_0x0076:
            r7 = 0
        L_0x0077:
            if (r7 == 0) goto L_0x0080
            com.facebook.appevents.ml.-$$Lambda$b9HGJdS7rH7dtnacHJy1lAJYPTY r7 = com.facebook.appevents.ml.$$Lambda$b9HGJdS7rH7dtnacHJy1lAJYPTY.INSTANCE     // Catch:{ all -> 0x00c1 }
            r1.onPostExecute = r7     // Catch:{ all -> 0x00c1 }
            r0.add(r1)     // Catch:{ all -> 0x00c1 }
        L_0x0080:
            r7 = r5
            r9 = r6
        L_0x0082:
            com.facebook.appevents.ml.ModelManager$Task r5 = com.facebook.appevents.ml.ModelManager.Task.MTML_INTEGRITY_DETECT     // Catch:{ all -> 0x00c1 }
            java.lang.String r5 = r5.toUseCase()     // Catch:{ all -> 0x00c1 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)     // Catch:{ all -> 0x00c1 }
            if (r4 == 0) goto L_0x001b
            java.lang.String r7 = r1.assetUri     // Catch:{ all -> 0x00c1 }
            int r4 = r1.versionId     // Catch:{ all -> 0x00c1 }
            int r9 = java.lang.Math.max(r9, r4)     // Catch:{ all -> 0x00c1 }
            com.facebook.internal.FeatureManager r4 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x00c1 }
            com.facebook.internal.FeatureManager$Feature r4 = com.facebook.internal.FeatureManager.Feature.IntelligentIntegrity     // Catch:{ all -> 0x00c1 }
            boolean r4 = com.facebook.internal.FeatureManager.isEnabled(r4)     // Catch:{ all -> 0x00c1 }
            if (r4 == 0) goto L_0x001b
            com.facebook.appevents.ml.-$$Lambda$hezzgqVvKqPN9xHTZB2MDRWPuaY r4 = com.facebook.appevents.ml.$$Lambda$hezzgqVvKqPN9xHTZB2MDRWPuaY.INSTANCE     // Catch:{ all -> 0x00c1 }
            r1.onPostExecute = r4     // Catch:{ all -> 0x00c1 }
            r0.add(r1)     // Catch:{ all -> 0x00c1 }
            goto L_0x001b
        L_0x00a9:
            if (r7 == 0) goto L_0x00c0
            if (r9 <= 0) goto L_0x00c0
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x00c1 }
            if (r1 != 0) goto L_0x00c0
            com.facebook.appevents.ml.ModelManager$TaskHandler r1 = new com.facebook.appevents.ml.ModelManager$TaskHandler     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = "MTML"
            r8 = 0
            r10 = 0
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00c1 }
            com.facebook.appevents.ml.ModelManager.TaskHandler.Companion.execute(r1, r0)     // Catch:{ all -> 0x00c1 }
        L_0x00c0:
            return
        L_0x00c1:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.enableMTML():void");
    }

    public final JSONObject fetchModels() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("fields", TextUtils.join(",", new String[]{"use_case", "version_id", "asset_uri", "rules_uri", "thresholds"}));
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "app/model_asset", null);
            newGraphPathRequest.setParameters(bundle);
            JSONObject jSONObject = newGraphPathRequest.executeAndWait().graphObject;
            if (jSONObject == null) {
                return null;
            }
            return parseRawJsonObject(jSONObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r5 = new org.json.JSONObject();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0064 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject parseRawJsonObject(org.json.JSONObject r13) {
        /*
            r12 = this;
            java.lang.String r0 = "asset_uri"
            java.lang.String r1 = "thresholds"
            java.lang.String r2 = "version_id"
            java.lang.String r3 = "rules_uri"
            java.lang.String r4 = "use_case"
            boolean r5 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r6 = 0
            if (r5 == 0) goto L_0x0012
            return r6
        L_0x0012:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x006a }
            r5.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r7 = "data"
            org.json.JSONArray r13 = r13.getJSONArray(r7)     // Catch:{ JSONException -> 0x0064 }
            r7 = 0
            int r8 = r13.length()     // Catch:{ JSONException -> 0x0064 }
            if (r8 <= 0) goto L_0x0069
        L_0x0024:
            int r9 = r7 + 1
            org.json.JSONObject r7 = r13.getJSONObject(r7)     // Catch:{ JSONException -> 0x0064 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0064 }
            r10.<init>()     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r11 = r7.getString(r2)     // Catch:{ JSONException -> 0x0064 }
            r10.put(r2, r11)     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r11 = r7.getString(r4)     // Catch:{ JSONException -> 0x0064 }
            r10.put(r4, r11)     // Catch:{ JSONException -> 0x0064 }
            org.json.JSONArray r11 = r7.getJSONArray(r1)     // Catch:{ JSONException -> 0x0064 }
            r10.put(r1, r11)     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r11 = r7.getString(r0)     // Catch:{ JSONException -> 0x0064 }
            r10.put(r0, r11)     // Catch:{ JSONException -> 0x0064 }
            boolean r11 = r7.has(r3)     // Catch:{ JSONException -> 0x0064 }
            if (r11 == 0) goto L_0x0058
            java.lang.String r11 = r7.getString(r3)     // Catch:{ JSONException -> 0x0064 }
            r10.put(r3, r11)     // Catch:{ JSONException -> 0x0064 }
        L_0x0058:
            java.lang.String r7 = r7.getString(r4)     // Catch:{ JSONException -> 0x0064 }
            r5.put(r7, r10)     // Catch:{ JSONException -> 0x0064 }
            if (r9 < r8) goto L_0x0062
            goto L_0x0069
        L_0x0062:
            r7 = r9
            goto L_0x0024
        L_0x0064:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x006a }
            r5.<init>()     // Catch:{ all -> 0x006a }
        L_0x0069:
            return r5
        L_0x006a:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.parseRawJsonObject(org.json.JSONObject):org.json.JSONObject");
    }

    public final String[] processIntegrityDetectionResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int i = mTensor.shape[0];
            int i2 = mTensor.shape[1];
            float[] fArr2 = mTensor.data;
            if (i2 != fArr.length) {
                return null;
            }
            IntRange until = RangesKt___RangesKt.until(0, i);
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(until, 10));
            IntIterator it = until.iterator();
            while (((IntProgressionIterator) it).hasNext) {
                int nextInt = it.nextInt();
                String str = "none";
                int length = fArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    int i5 = i4 + 1;
                    if (fArr2[(nextInt * i2) + i4] >= fArr[i3]) {
                        str = MTML_INTEGRITY_DETECT_PREDICTION.get(i4);
                    }
                    i3++;
                    i4 = i5;
                }
                arrayList.add(str);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String[] processSuggestedEventResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int i = mTensor.shape[0];
            int i2 = mTensor.shape[1];
            float[] fArr2 = mTensor.data;
            if (i2 != fArr.length) {
                return null;
            }
            IntRange until = RangesKt___RangesKt.until(0, i);
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(until, 10));
            IntIterator it = until.iterator();
            while (((IntProgressionIterator) it).hasNext) {
                int nextInt = it.nextInt();
                String str = SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER;
                int length = fArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    int i5 = i4 + 1;
                    if (fArr2[(nextInt * i2) + i4] >= fArr[i3]) {
                        str = MTML_SUGGESTED_EVENTS_PREDICTION.get(i4);
                    }
                    i3++;
                    i4 = i5;
                }
                arrayList.add(str);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
