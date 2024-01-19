package com.android.tools.r8;

import a.a.j.c;
import a.a.j.d;
import a.a.j.e;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.cfg.utilities.a;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.pushnotification.CTPushProvider;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzh;
import com.google.firebase.perf.config.DeviceCacheManager;
import com.google.firebase.perf.util.Optional;
import com.netcore.android.logger.SMTLogger;
import com.paynimo.android.payment.CardFragment;
import com.paynimo.android.payment.DigitalMandateActivity;
import com.paynimo.android.payment.NetBankingFragment;
import com.paynimo.android.payment.PaymentModesActivity;
import com.paynimo.android.payment.model.Checkout;
import com.userexperior.utilities.b;
import java.lang.reflect.Type;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.Builder;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.json.JSONException;
import org.objectweb.asm.AnnotationWriter;
import org.spongycastle.crypto.digests.MD5Digest;
import org.xmlpull.v1.XmlPullParser;
import sfs2x.client.ISmartFox;
import sfs2x.client.core.SFSEvent;

/* compiled from: outline */
public class GeneratedOutlineSupport {
    public static double outline0(double d2, double d3, double d4, double d5) {
        return ((d2 * d3) + d4) / d5;
    }

    public static double outline1(double d2, double d3, double d4, double d5) {
        return (d4 - (d2 * d3)) / d5;
    }

    public static int outline10(int i, int i2, int i3, MD5Digest mD5Digest, int i4, int i5) {
        return mD5Digest.rotateLeft(i + i2 + i3, i4) + i5;
    }

    public static void outline100(StringBuilder sb, String str, SQLiteStatement sQLiteStatement) {
        sb.append(str);
        Logger.v(sb.toString());
        sQLiteStatement.execute();
    }

    public static void outline101(StringBuilder sb, String str, String str2, Logger logger, String str3) {
        sb.append(str);
        sb.append(str2);
        logger.verbose(sb.toString(), str3);
    }

    public static void outline102(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
    }

    public static void outline103(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static void outline104(HashSet hashSet, String str, String str2, String str3, String str4) {
        hashSet.add(str);
        hashSet.add(str2);
        hashSet.add(str3);
        hashSet.add(str4);
    }

    public static void outline105(JSONException jSONException, StringBuilder sb) {
        sb.append(jSONException.getLocalizedMessage());
        Logger.v(sb.toString());
    }

    public static boolean outline106(Context context, Intent intent, int i) {
        return context.getPackageManager().queryIntentActivities(intent, i).isEmpty();
    }

    public static boolean outline107(Checkout checkout, String str) {
        return checkout.getMerchantRequestPayload().getPayment().getInstruction().getAction().equalsIgnoreCase(str);
    }

    public static boolean outline108(BooleanFlagField booleanFlagField, int i, String str) {
        Boolean bool = booleanFlagField.get(i);
        Intrinsics.checkNotNullExpressionValue(bool, str);
        return bool.booleanValue();
    }

    public static int outline11(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    public static int outline12(AnnotationWriter annotationWriter, int i, int i2) {
        return annotationWriter.a() + i + i2;
    }

    public static long outline13() {
        return new Date().getTime();
    }

    public static Bundle outline14(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    public static View outline15(CardFragment cardFragment, Resources resources, String str, String str2, Dialog dialog) {
        return dialog.findViewById(resources.getIdentifier(str, str2, cardFragment.getActivity().getPackageName()));
    }

    public static View outline16(CardFragment cardFragment, Resources resources, String str, String str2, View view) {
        return view.findViewById(resources.getIdentifier(str, str2, cardFragment.getActivity().getPackageName()));
    }

    public static View outline17(DigitalMandateActivity digitalMandateActivity, Resources resources, String str, String str2) {
        return digitalMandateActivity.findViewById(resources.getIdentifier(str, str2, digitalMandateActivity.getPackageName()));
    }

    public static View outline18(DigitalMandateActivity digitalMandateActivity, Resources resources, String str, String str2, View view) {
        return view.findViewById(resources.getIdentifier(str, str2, digitalMandateActivity.getPackageName()));
    }

    public static View outline19(NetBankingFragment netBankingFragment, Resources resources, String str, String str2, Dialog dialog) {
        return dialog.findViewById(resources.getIdentifier(str, str2, netBankingFragment.getActivity().getPackageName()));
    }

    public static double outline2(double d2, double d3, double d4, double d5) {
        return (d2 * d3 * d4) + d5;
    }

    public static View outline20(PaymentModesActivity paymentModesActivity, Resources resources, String str, String str2, Dialog dialog) {
        return dialog.findViewById(resources.getIdentifier(str, str2, paymentModesActivity.getApplicationContext().getPackageName()));
    }

    public static FileHandle outline21(StringBuilder sb, String str, String str2, a aVar) {
        sb.append(str);
        sb.append(str2);
        return aVar.a(sb.toString());
    }

    public static Image outline22(Texture texture, TextureFilter textureFilter, TextureFilter textureFilter2, Texture texture2) {
        texture.setFilter(textureFilter, textureFilter2);
        return new Image(texture2);
    }

    public static LabelStyle outline23(c cVar, Image image, Label label) {
        cVar.addActorAfter(image, label);
        return new LabelStyle();
    }

    public static LabelStyle outline24(d dVar, Image image, Label label) {
        dVar.addActorAfter(image, label);
        return new LabelStyle();
    }

    public static LabelStyle outline25(e eVar, Image image, Label label) {
        eVar.addActorAfter(image, label);
        return new LabelStyle();
    }

    public static Integer outline26(HashMap hashMap, String str, Integer num, Cursor cursor, String str2) {
        hashMap.put(str, num);
        return Integer.valueOf(cursor.getColumnIndex(str2));
    }

    public static Object outline27(zzbl zzbl, int i, List list, int i2) {
        zzh.zzh(zzbl.name(), i, list);
        return list.get(i2);
    }

    public static Object outline28(Long l, DeviceCacheManager deviceCacheManager, String str, Optional optional) {
        deviceCacheManager.setValue(str, l.longValue());
        return optional.get();
    }

    public static Object outline29(List list, int i) {
        return list.get(list.size() + i);
    }

    public static float outline3(float f2, float f3, float f4, float f5) {
        return ((f2 - f3) * f4) + f5;
    }

    public static Object outline30(List list, int i) {
        return list.get(list.size() - i);
    }

    public static String outline31(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static String outline32(Context context, Resources resources, String str, String str2, Resources resources2) {
        return resources2.getString(resources.getIdentifier(str, str2, context.getPackageName()));
    }

    public static String outline33(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String outline34(CTPushProvider cTPushProvider, StringBuilder sb) {
        sb.append(cTPushProvider.getClass());
        return sb.toString();
    }

    public static String outline35(Class cls, StringBuilder sb) {
        sb.append(cls.getName());
        return sb.toString();
    }

    public static String outline36(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
        return sb.toString();
    }

    public static String outline37(Class cls, StringBuilder sb, String str, String str2) {
        sb.append(cls.getSimpleName());
        sb.append(str);
        sb.append(cls.getSimpleName());
        sb.append(str2);
        return sb.toString();
    }

    public static String outline38(Exception exc, StringBuilder sb) {
        sb.append(exc.getLocalizedMessage());
        return sb.toString();
    }

    public static String outline39(Exception exc, StringBuilder sb) {
        sb.append(exc.getMessage());
        return sb.toString();
    }

    public static float outline4(float f2, float f3, float f4, float f5) {
        return (f2 * f3) + f4 + f5;
    }

    public static String outline40(String str, int i) {
        return str + i;
    }

    public static String outline41(String str, int i) {
        return str + i;
    }

    public static String outline42(String str, int i, String str2) {
        return str + i + str2;
    }

    public static String outline43(String str, int i, String str2, int i2) {
        return str + i + str2 + i2;
    }

    public static String outline44(String str, int i, String str2, int i2, String str3) {
        return str + i + str2 + i2 + str3;
    }

    public static String outline45(String str, long j) {
        return str + j;
    }

    public static String outline46(String str, Uri uri) {
        return str + uri;
    }

    public static String outline47(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String outline48(String str, Object obj) {
        return str + obj;
    }

    public static String outline49(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public static float outline5(ScaledNumericValue scaledNumericValue, float f2, float f3, float f4) {
        return (scaledNumericValue.getScale(f2) * f3) + f4;
    }

    public static String outline50(String str, String str2) {
        return str + str2;
    }

    public static String outline51(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String outline52(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String outline53(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String outline54(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String outline55(String str, Type type) {
        return str + type;
    }

    public static String outline56(StringBuilder sb, int i, char c2) {
        sb.append(i);
        sb.append(c2);
        return sb.toString();
    }

    public static String outline57(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String outline58(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static String outline59(StringBuilder sb, String str, char c2) {
        sb.append(str);
        sb.append(c2);
        return sb.toString();
    }

    public static int outline6(int i, int i2, int i3, int i4) {
        return i + i2 + i3 + i4;
    }

    public static String outline60(StringBuilder sb, String str, char c2, char c3) {
        sb.append(str);
        sb.append(c2);
        sb.append(c3);
        return sb.toString();
    }

    public static String outline61(StringBuilder sb, String str, int i) {
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    public static String outline62(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String outline63(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String outline64(StringBuilder sb, List list, String str) {
        sb.append(list);
        sb.append(str);
        return sb.toString();
    }

    public static String outline65(StringBuilder sb, boolean z, char c2) {
        sb.append(z);
        sb.append(c2);
        return sb.toString();
    }

    public static String outline66(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        sb.append(str);
        return sb.toString();
    }

    public static String outline67(GeneralSecurityException generalSecurityException, StringBuilder sb) {
        sb.append(generalSecurityException.getMessage());
        return sb.toString();
    }

    public static String outline68(TypeConstructorMarker typeConstructorMarker, StringBuilder sb) {
        sb.append(Reflection.getOrCreateKotlinClass(typeConstructorMarker.getClass()));
        return sb.toString();
    }

    public static String outline69(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    public static int outline7(int i, int i2, int i3, int i4) {
        return (i * i2) + i3 + i4;
    }

    public static String outline70(Object[] objArr, int i, String str, String str2) {
        String format = String.format(str, Arrays.copyOf(objArr, i));
        Intrinsics.checkNotNullExpressionValue(format, str2);
        return format;
    }

    public static StringBuffer outline71(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer;
    }

    public static StringBuilder outline72(char c2) {
        StringBuilder sb = new StringBuilder();
        sb.append(c2);
        return sb;
    }

    public static StringBuilder outline73(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder outline74(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder outline75(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder outline76(String str, long j, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(j);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder outline77(String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder outline78(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder outline79(String str, String str2, String str3) {
        Intrinsics.checkNotNullExpressionValue(str, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        return sb;
    }

    public static int outline8(int i, int i2, int i3, int i4) {
        return ((i * i2) / i3) + i4;
    }

    public static StringBuilder outline80(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder outline81(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    public static StringBuilder outline82(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static StringBuilder outline83(String str, SimpleTypeMarker simpleTypeMarker, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(simpleTypeMarker);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder outline84(String str, TypeConstructorMarker typeConstructorMarker, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(typeConstructorMarker);
        sb.append(str2);
        return sb;
    }

    public static ArrayList outline85(int i, HashMap hashMap, ArrayList arrayList, int i2, String str) {
        hashMap.put(Integer.valueOf(i), arrayList);
        ArrayList arrayList2 = new ArrayList(i2);
        arrayList2.add(str);
        return arrayList2;
    }

    public static ArrayList outline86(ArrayList arrayList, String str, int i, HashMap hashMap, ArrayList arrayList2, int i2) {
        arrayList.add(str);
        hashMap.put(Integer.valueOf(i), arrayList2);
        return new ArrayList(i2);
    }

    public static HashMap outline87(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        return hashMap;
    }

    public static HashMap outline88(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        hashMap.put(str3, str4);
        return hashMap;
    }

    public static Map outline89(HashMap hashMap) {
        return Collections.unmodifiableMap(new HashMap(hashMap));
    }

    public static int outline9(int i, int i2, int i3, int i4) {
        return ((i / i2) * i3) + i4;
    }

    public static ProtoBuf$Type outline90(ProtoBuf$Type protoBuf$Type, ProtoBuf$Type protoBuf$Type2) {
        Builder newBuilder = ProtoBuf$Type.newBuilder(protoBuf$Type);
        newBuilder.mergeFrom(protoBuf$Type2);
        return newBuilder.buildPartial();
    }

    public static void outline91(float f2, COSArray cOSArray) {
        cOSArray.add((COSBase) new COSFloat(f2));
    }

    public static void outline92(Activity activity, Resources resources, String str, String str2, ImageView imageView) {
        imageView.setImageResource(resources.getIdentifier(str, str2, activity.getPackageName()));
    }

    public static void outline93(SharedPreferences sharedPreferences, String str) {
        sharedPreferences.edit().remove(str).apply();
    }

    public static void outline94(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
    }

    public static void outline95(Exception exc, StringBuilder sb, Level level) {
        sb.append(exc.getMessage());
        b.a(level, sb.toString());
    }

    public static void outline96(String str, String str2, Exception exc, SMTLogger sMTLogger, String str3) {
        Intrinsics.checkNotNullExpressionValue(str, str2);
        sMTLogger.e(str3, String.valueOf(exc.getMessage()));
    }

    public static void outline97(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, str2);
        Intrinsics.checkNotNullParameter(str3, str4);
        Intrinsics.checkNotNullParameter(str5, str6);
    }

    public static void outline98(String str, HashMap hashMap, ISmartFox iSmartFox) {
        iSmartFox.dispatchEvent(new SFSEvent(str, hashMap));
    }

    public static void outline99(StringBuilder sb, String str, char c2, String str2) {
        sb.append(str);
        sb.append(c2);
        sb.append(str2);
    }
}
