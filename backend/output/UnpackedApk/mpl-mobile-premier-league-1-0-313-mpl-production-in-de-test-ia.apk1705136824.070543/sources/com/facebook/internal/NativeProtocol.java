package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginTargetApp;
import com.mpl.androidapp.share.utils.Keys.SocialPkgName;
import com.razorpay.AnalyticsConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;
import org.apache.pdfbox.pdfparser.BaseParser;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b;\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b;\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u000eÕ\u0001Ö\u0001×\u0001Ø\u0001Ù\u0001Ú\u0001Û\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u000200~0}H\u0002J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~H\u0002J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020H\u0002J.\u0010\u0001\u001a\u00020A2\u0010\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020A\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020A2\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u0018\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0001\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00042\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0007\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00042\u0007\u0010¢\u0001\u001a\u00020\u00042\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010¤\u0001\u001a\u00030\u00012\b\u0010¥\u0001\u001a\u00030\u00012\b\u0010¦\u0001\u001a\u00030\u0001H\u0007J½\u0001\u0010§\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u000202\u0007\u0010\u0001\u001a\u00020\u00042\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0007\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00042\u0007\u0010¢\u0001\u001a\u00020\u00042\b\u0010¨\u0001\u001a\u00030\u00012\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010¤\u0001\u001a\u00030\u00012\b\u0010©\u0001\u001a\u00030ª\u00012\b\u0010¥\u0001\u001a\u00030\u00012\b\u0010¦\u0001\u001a\u00030\u00012\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010­\u0001\u001a\u0004\u0018\u00010\u0004H\u0002JD\u0010®\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010°\u0001\u001a\u0004\u0018\u00010\u00042\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u00012\n\u0010³\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0016\u0010´\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0007J.\u0010µ\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010¶\u0001\u001a\u00030\u00012\n\u0010·\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010\u0001H\u0007JÆ\u0001\u0010¹\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010~2\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u00042\u0010\u0010\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0007\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020\u00042\u0007\u0010¢\u0001\u001a\u00020\u00042\b\u0010¨\u0001\u001a\u00030\u00012\t\u0010£\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010¤\u0001\u001a\u00030\u00012\b\u0010¥\u0001\u001a\u00030\u00012\b\u0010¦\u0001\u001a\u00030\u00012\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u00042\u000b\b\u0002\u0010­\u0001\u001a\u0004\u0018\u00010\u0004H\u0007J\u0019\u0010º\u0001\u001a\t\u0012\u0004\u0012\u00020A0\u00012\u0007\u0010\u0001\u001a\u00020H\u0002J\u0016\u0010»\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010¼\u0001\u001a\u00030\u0001H\u0007J\u0018\u0010½\u0001\u001a\u0005\u0018\u00010¾\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u0016\u0010¿\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010À\u0001\u001a\u00030\u0001H\u0007J\u0018\u0010Á\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010Â\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\u001d\u0010Ã\u0001\u001a\u00030²\u00012\u0007\u0010°\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001H\u0007J%\u0010Ä\u0001\u001a\u00030²\u00012\u000f\u0010Å\u0001\u001a\n\u0012\u0004\u0012\u00020\u0018\u00010~2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010Æ\u0001\u001a\u00020A2\u0007\u0010Ç\u0001\u001a\u00020AH\u0007J\t\u0010È\u0001\u001a\u00020AH\u0007J\u0016\u0010É\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010¼\u0001\u001a\u00030\u0001H\u0007J\u0013\u0010Ê\u0001\u001a\u00020A2\b\u0010¼\u0001\u001a\u00030\u0001H\u0007J\u0016\u0010Ë\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010À\u0001\u001a\u00030\u0001H\u0007J\u0014\u0010Ì\u0001\u001a\u00030\u00012\b\u0010À\u0001\u001a\u00030\u0001H\u0007J\u0013\u0010Í\u0001\u001a\u00030\u00012\u0007\u0010Î\u0001\u001a\u00020AH\u0007J?\u0010Ï\u0001\u001a\u00030Ð\u00012\b\u0010¼\u0001\u001a\u00030\u00012\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u00042\t\u0010°\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010Î\u0001\u001a\u00020A2\n\u0010Ñ\u0001\u001a\u0005\u0018\u00010\u0001H\u0007J\n\u0010Ò\u0001\u001a\u00030Ð\u0001H\u0007J-\u0010Ó\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0007J-\u0010Ô\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X\u0004¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010C\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020AXT¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010v\u001a\n w*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R \u0010|\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u000200~0}X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0001\u001a\b\u0012\u0004\u0012\u000200~X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006Ü\u0001"}, d2 = {"Lcom/facebook/internal/NativeProtocol;", "", "()V", "ACTION_APPINVITE_DIALOG", "", "ACTION_CAMERA_EFFECT", "ACTION_FEED_DIALOG", "ACTION_LIKE_DIALOG", "ACTION_MESSAGE_DIALOG", "ACTION_OGACTIONPUBLISH_DIALOG", "ACTION_OGMESSAGEPUBLISH_DIALOG", "ACTION_SHARE_STORY", "AUDIENCE_EVERYONE", "AUDIENCE_FRIENDS", "AUDIENCE_ME", "BRIDGE_ARG_ACTION_ID_STRING", "BRIDGE_ARG_APP_NAME_STRING", "BRIDGE_ARG_ERROR_BUNDLE", "BRIDGE_ARG_ERROR_CODE", "BRIDGE_ARG_ERROR_DESCRIPTION", "BRIDGE_ARG_ERROR_JSON", "BRIDGE_ARG_ERROR_SUBCODE", "BRIDGE_ARG_ERROR_TYPE", "CONTENT_SCHEME", "ERROR_APPLICATION_ERROR", "ERROR_NETWORK_ERROR", "ERROR_PERMISSION_DENIED", "ERROR_PROTOCOL_ERROR", "ERROR_SERVICE_DISABLED", "ERROR_UNKNOWN_ERROR", "ERROR_USER_CANCELED", "EXTRA_ACCESS_TOKEN", "EXTRA_APPLICATION_ID", "EXTRA_APPLICATION_NAME", "EXTRA_AUTHENTICATION_TOKEN", "EXTRA_DATA_ACCESS_EXPIRATION_TIME", "EXTRA_DIALOG_COMPLETE_KEY", "EXTRA_DIALOG_COMPLETION_GESTURE_KEY", "EXTRA_EXPIRES_SECONDS_SINCE_EPOCH", "EXTRA_GET_INSTALL_DATA_PACKAGE", "EXTRA_GRAPH_API_VERSION", "EXTRA_LOGGER_REF", "EXTRA_NONCE", "EXTRA_PERMISSIONS", "EXTRA_PROTOCOL_ACTION", "EXTRA_PROTOCOL_BRIDGE_ARGS", "EXTRA_PROTOCOL_CALL_ID", "EXTRA_PROTOCOL_METHOD_ARGS", "EXTRA_PROTOCOL_METHOD_RESULTS", "EXTRA_PROTOCOL_VERSION", "EXTRA_PROTOCOL_VERSIONS", "EXTRA_TOAST_DURATION_MS", "EXTRA_USER_ID", "FACEBOOK_PROXY_AUTH_ACTIVITY", "FACEBOOK_PROXY_AUTH_APP_ID_KEY", "FACEBOOK_PROXY_AUTH_E2E_KEY", "FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY", "FACEBOOK_SDK_VERSION_KEY", "FACEBOOK_TOKEN_REFRESH_ACTIVITY", "IMAGE_URL_KEY", "IMAGE_USER_GENERATED_KEY", "INTENT_ACTION_PLATFORM_ACTIVITY", "INTENT_ACTION_PLATFORM_SERVICE", "KNOWN_PROTOCOL_VERSIONS", "", "", "[Ljava/lang/Integer;", "MESSAGE_GET_ACCESS_TOKEN_REPLY", "MESSAGE_GET_ACCESS_TOKEN_REQUEST", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY", "MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST", "MESSAGE_GET_INSTALL_DATA_REPLY", "MESSAGE_GET_INSTALL_DATA_REQUEST", "MESSAGE_GET_LIKE_STATUS_REPLY", "MESSAGE_GET_LIKE_STATUS_REQUEST", "MESSAGE_GET_LOGIN_STATUS_REPLY", "MESSAGE_GET_LOGIN_STATUS_REQUEST", "MESSAGE_GET_PROTOCOL_VERSIONS_REPLY", "MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST", "NO_PROTOCOL_AVAILABLE", "OPEN_GRAPH_CREATE_OBJECT_KEY", "PLATFORM_PROVIDER", "PLATFORM_PROVIDER_VERSIONS", "PLATFORM_PROVIDER_VERSION_COLUMN", "PROTOCOL_VERSION_20121101", "PROTOCOL_VERSION_20130502", "PROTOCOL_VERSION_20130618", "PROTOCOL_VERSION_20131024", "PROTOCOL_VERSION_20131107", "PROTOCOL_VERSION_20140204", "PROTOCOL_VERSION_20140313", "PROTOCOL_VERSION_20140324", "PROTOCOL_VERSION_20140701", "PROTOCOL_VERSION_20141001", "PROTOCOL_VERSION_20141028", "PROTOCOL_VERSION_20141107", "PROTOCOL_VERSION_20141218", "PROTOCOL_VERSION_20150401", "PROTOCOL_VERSION_20150702", "PROTOCOL_VERSION_20160327", "PROTOCOL_VERSION_20161017", "PROTOCOL_VERSION_20170213", "PROTOCOL_VERSION_20170411", "PROTOCOL_VERSION_20170417", "PROTOCOL_VERSION_20171115", "PROTOCOL_VERSION_20210906", "RESULT_ARGS_ACCESS_TOKEN", "RESULT_ARGS_DIALOG_COMPLETE_KEY", "RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY", "RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH", "RESULT_ARGS_GRAPH_DOMAIN", "RESULT_ARGS_PERMISSIONS", "RESULT_ARGS_SIGNED_REQUEST", "STATUS_ERROR_CODE", "STATUS_ERROR_DESCRIPTION", "STATUS_ERROR_JSON", "STATUS_ERROR_SUBCODE", "STATUS_ERROR_TYPE", "TAG", "kotlin.jvm.PlatformType", "WEB_DIALOG_ACTION", "WEB_DIALOG_IS_FALLBACK", "WEB_DIALOG_PARAMS", "WEB_DIALOG_URL", "actionToAppInfoMap", "", "", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "effectCameraAppInfoList", "facebookAppInfoList", "protocolVersionsAsyncUpdating", "Ljava/util/concurrent/atomic/AtomicBoolean;", "buildActionToAppInfoMap", "buildEffectCameraAppInfoList", "buildFacebookAppList", "buildPlatformProviderVersionURI", "Landroid/net/Uri;", "appInfo", "computeLatestAvailableVersionFromVersionSpec", "allAvailableFacebookAppVersions", "Ljava/util/TreeSet;", "latestSdkVersion", "versionSpec", "", "createBundleForException", "Landroid/os/Bundle;", "e", "Lcom/facebook/FacebookException;", "createInstagramIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "applicationId", "permissions", "", "e2e", "isRerequest", "", "isForPublish", "defaultAudience", "Lcom/facebook/login/DefaultAudience;", "clientState", "authType", "messengerPageId", "resetMessengerState", "isFamilyLogin", "shouldSkipAccountDedupe", "createNativeAppIntent", "ignoreAppSwitchToLoggedOut", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "nonce", "codeChallenge", "codeChallengeMethod", "createPlatformActivityIntent", "callId", "action", "versionResult", "Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "extras", "createPlatformServiceIntent", "createProtocolResultIntent", "requestIntent", "results", "error", "createProxyAuthIntents", "fetchAllAvailableProtocolVersionsForAppInfo", "getBridgeArgumentsFromIntent", "intent", "getCallIdFromIntent", "Ljava/util/UUID;", "getErrorDataFromResultIntent", "resultIntent", "getExceptionFromErrorData", "errorData", "getLatestAvailableProtocolVersionForAction", "getLatestAvailableProtocolVersionForAppInfoList", "appInfoList", "getLatestAvailableProtocolVersionForService", "minimumVersion", "getLatestKnownVersion", "getMethodArgumentsFromIntent", "getProtocolVersionFromIntent", "getSuccessResultsFromIntent", "isErrorResult", "isVersionCompatibleWithBucketedIntent", "version", "setupProtocolRequestIntent", "", "params", "updateAllAvailableProtocolVersionsAsync", "validateActivityIntent", "validateServiceIntent", "EffectTestAppInfo", "InstagramAppInfo", "KatanaAppInfo", "MessengerAppInfo", "NativeAppInfo", "ProtocolVersionQueryResult", "WakizashiAppInfo", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: NativeProtocol.kt */
public final class NativeProtocol {
    public static final NativeProtocol INSTANCE = new NativeProtocol();
    public static final Integer[] KNOWN_PROTOCOL_VERSIONS = {Integer.valueOf(20210906), Integer.valueOf(20171115), Integer.valueOf(20170417), Integer.valueOf(20170411), Integer.valueOf(20170213), Integer.valueOf(20161017), Integer.valueOf(20160327), Integer.valueOf(20150702), Integer.valueOf(20150401), Integer.valueOf(20141218), Integer.valueOf(20141107), Integer.valueOf(20141028), Integer.valueOf(20141001), Integer.valueOf(20140701), Integer.valueOf(20140324), Integer.valueOf(20140313), Integer.valueOf(20140204), Integer.valueOf(20131107), Integer.valueOf(20131024), Integer.valueOf(20130618), Integer.valueOf(20130502), Integer.valueOf(20121101)};
    public static final Map<String, List<NativeAppInfo>> actionToAppInfoMap;
    public static final List<NativeAppInfo> effectCameraAppInfoList;
    public static final List<NativeAppInfo> facebookAppInfoList = INSTANCE.buildFacebookAppList();
    public static final AtomicBoolean protocolVersionsAsyncUpdating = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$EffectTestAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: NativeProtocol.kt */
    public static final class EffectTestAppInfo extends NativeAppInfo {
        public String getLoginActivity() {
            return null;
        }

        public String getPackage() {
            return "com.facebook.arstudio.player";
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$InstagramAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "getResponseType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: NativeProtocol.kt */
    public static final class InstagramAppInfo extends NativeAppInfo {
        public String getLoginActivity() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        public String getPackage() {
            return SocialPkgName.INSTAGRAM_PACKAGE_NAME;
        }

        public String getResponseType() {
            return "token,signed_request,graph_domain,granted_scopes";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/facebook/internal/NativeProtocol$KatanaAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "isAndroidAPIVersionNotLessThan30", "", "onAvailableVersionsNullOrEmpty", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: NativeProtocol.kt */
    public static final class KatanaAppInfo extends NativeAppInfo {
        public String getLoginActivity() {
            return "com.facebook.katana.ProxyAuth";
        }

        public String getPackage() {
            return "com.facebook.katana";
        }

        public void onAvailableVersionsNullOrEmpty() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.getApplicationContext().getApplicationInfo().targetSdkVersion >= 30) {
                boolean isObjectCrashing = CrashShieldHandler.isObjectCrashing(NativeProtocol.class);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/NativeProtocol$MessengerAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: NativeProtocol.kt */
    public static final class MessengerAppInfo extends NativeAppInfo {
        public String getLoginActivity() {
            return null;
        }

        public String getPackage() {
            return "com.facebook.orca";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "()V", "availableVersions", "Ljava/util/TreeSet;", "", "fetchAvailableVersions", "", "force", "", "getAvailableVersions", "getLoginActivity", "", "getPackage", "getResponseType", "onAvailableVersionsNullOrEmpty", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: NativeProtocol.kt */
    public static abstract class NativeAppInfo {
        public TreeSet<Integer> availableVersions;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r4 == null ? null : java.lang.Boolean.valueOf(r4.isEmpty()), java.lang.Boolean.FALSE) == false) goto L_0x001e;
         */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0044 A[Catch:{ all -> 0x002e }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized void fetchAvailableVersions(boolean r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                r0 = 0
                if (r4 != 0) goto L_0x001e
                java.util.TreeSet<java.lang.Integer> r4 = r3.availableVersions     // Catch:{ all -> 0x0049 }
                if (r4 == 0) goto L_0x001e
                java.util.TreeSet<java.lang.Integer> r4 = r3.availableVersions     // Catch:{ all -> 0x0049 }
                if (r4 != 0) goto L_0x000e
                r4 = r0
                goto L_0x0016
            L_0x000e:
                boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0049 }
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0049 }
            L_0x0016:
                java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0049 }
                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)     // Catch:{ all -> 0x0049 }
                if (r4 != 0) goto L_0x0034
            L_0x001e:
                com.facebook.internal.NativeProtocol r4 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch:{ all -> 0x0049 }
                java.lang.Class<com.facebook.internal.NativeProtocol> r1 = com.facebook.internal.NativeProtocol.class
                boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ all -> 0x0049 }
                if (r2 == 0) goto L_0x0029
                goto L_0x0032
            L_0x0029:
                java.util.TreeSet r0 = r4.fetchAllAvailableProtocolVersionsForAppInfo(r3)     // Catch:{ all -> 0x002e }
                goto L_0x0032
            L_0x002e:
                r4 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r1)     // Catch:{ all -> 0x0049 }
            L_0x0032:
                r3.availableVersions = r0     // Catch:{ all -> 0x0049 }
            L_0x0034:
                java.util.TreeSet<java.lang.Integer> r4 = r3.availableVersions     // Catch:{ all -> 0x0049 }
                if (r4 == 0) goto L_0x0041
                boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0049 }
                if (r4 == 0) goto L_0x003f
                goto L_0x0041
            L_0x003f:
                r4 = 0
                goto L_0x0042
            L_0x0041:
                r4 = 1
            L_0x0042:
                if (r4 == 0) goto L_0x0047
                r3.onAvailableVersionsNullOrEmpty()     // Catch:{ all -> 0x0049 }
            L_0x0047:
                monitor-exit(r3)
                return
            L_0x0049:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.fetchAvailableVersions(boolean):void");
        }

        public abstract String getLoginActivity();

        public abstract String getPackage();

        public String getResponseType() {
            return "id_token,token,signed_request,graph_domain";
        }

        public void onAvailableVersionsNullOrEmpty() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/facebook/internal/NativeProtocol$ProtocolVersionQueryResult;", "", "()V", "<set-?>", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "appInfo", "getAppInfo", "()Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "", "protocolVersion", "getProtocolVersion", "()I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: NativeProtocol.kt */
    public static final class ProtocolVersionQueryResult {
        public NativeAppInfo appInfo;
        public int protocolVersion;

        public ProtocolVersionQueryResult(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/NativeProtocol$WakizashiAppInfo;", "Lcom/facebook/internal/NativeProtocol$NativeAppInfo;", "()V", "getLoginActivity", "", "getPackage", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: NativeProtocol.kt */
    public static final class WakizashiAppInfo extends NativeAppInfo {
        public String getLoginActivity() {
            return "com.facebook.katana.ProxyAuth";
        }

        public String getPackage() {
            return "com.facebook.wakizashi";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0189  */
    static {
        /*
            com.facebook.internal.NativeProtocol r0 = new com.facebook.internal.NativeProtocol
            r0.<init>()
            INSTANCE = r0
            com.facebook.internal.NativeProtocol r0 = INSTANCE
            java.util.List r0 = r0.buildFacebookAppList()
            facebookAppInfoList = r0
            com.facebook.internal.NativeProtocol r0 = INSTANCE
            r1 = 0
            if (r0 == 0) goto L_0x018a
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x001e
        L_0x001c:
            r2 = r1
            goto L_0x0038
        L_0x001e:
            com.facebook.internal.NativeProtocol$NativeAppInfo[] r2 = new com.facebook.internal.NativeProtocol.NativeAppInfo[r3]     // Catch:{ all -> 0x0033 }
            com.facebook.internal.NativeProtocol$EffectTestAppInfo r5 = new com.facebook.internal.NativeProtocol$EffectTestAppInfo     // Catch:{ all -> 0x0033 }
            r5.<init>()     // Catch:{ all -> 0x0033 }
            r2[r4] = r5     // Catch:{ all -> 0x0033 }
            java.util.ArrayList r2 = com.twitter.sdk.android.tweetui.TweetUtils.arrayListOf(r2)     // Catch:{ all -> 0x0033 }
            java.util.List r5 = r0.buildFacebookAppList()     // Catch:{ all -> 0x0033 }
            r2.addAll(r5)     // Catch:{ all -> 0x0033 }
            goto L_0x0038
        L_0x0033:
            r2 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r2, r0)
            goto L_0x001c
        L_0x0038:
            effectCameraAppInfoList = r2
            com.facebook.internal.NativeProtocol r0 = INSTANCE
            if (r0 == 0) goto L_0x0189
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            if (r2 == 0) goto L_0x0045
            goto L_0x0091
        L_0x0045:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x008d }
            r2.<init>()     // Catch:{ all -> 0x008d }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x008d }
            r5.<init>()     // Catch:{ all -> 0x008d }
            com.facebook.internal.NativeProtocol$MessengerAppInfo r6 = new com.facebook.internal.NativeProtocol$MessengerAppInfo     // Catch:{ all -> 0x008d }
            r6.<init>()     // Catch:{ all -> 0x008d }
            r5.add(r6)     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG"
            java.util.List<com.facebook.internal.NativeProtocol$NativeAppInfo> r7 = facebookAppInfoList     // Catch:{ all -> 0x008d }
            r2.put(r6, r7)     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "com.facebook.platform.action.request.FEED_DIALOG"
            java.util.List<com.facebook.internal.NativeProtocol$NativeAppInfo> r7 = facebookAppInfoList     // Catch:{ all -> 0x008d }
            r2.put(r6, r7)     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "com.facebook.platform.action.request.LIKE_DIALOG"
            java.util.List<com.facebook.internal.NativeProtocol$NativeAppInfo> r7 = facebookAppInfoList     // Catch:{ all -> 0x008d }
            r2.put(r6, r7)     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "com.facebook.platform.action.request.APPINVITES_DIALOG"
            java.util.List<com.facebook.internal.NativeProtocol$NativeAppInfo> r7 = facebookAppInfoList     // Catch:{ all -> 0x008d }
            r2.put(r6, r7)     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "com.facebook.platform.action.request.MESSAGE_DIALOG"
            r2.put(r6, r5)     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG"
            r2.put(r6, r5)     // Catch:{ all -> 0x008d }
            java.lang.String r5 = "com.facebook.platform.action.request.CAMERA_EFFECT"
            java.util.List<com.facebook.internal.NativeProtocol$NativeAppInfo> r6 = effectCameraAppInfoList     // Catch:{ all -> 0x008d }
            r2.put(r5, r6)     // Catch:{ all -> 0x008d }
            java.lang.String r5 = "com.facebook.platform.action.request.SHARE_STORY"
            java.util.List<com.facebook.internal.NativeProtocol$NativeAppInfo> r6 = facebookAppInfoList     // Catch:{ all -> 0x008d }
            r2.put(r5, r6)     // Catch:{ all -> 0x008d }
            r1 = r2
            goto L_0x0091
        L_0x008d:
            r2 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r2, r0)
        L_0x0091:
            actionToAppInfoMap = r1
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r0.<init>(r4)
            protocolVersionsAsyncUpdating = r0
            r0 = 22
            java.lang.Integer[] r0 = new java.lang.Integer[r0]
            r1 = 20210906(0x13464da, float:3.3133136E-38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r4] = r1
            r1 = 20171115(0x133c96b, float:3.3021618E-38)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0[r3] = r1
            r1 = 2
            r2 = 20170417(0x133c6b1, float:3.3019662E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 3
            r2 = 20170411(0x133c6ab, float:3.3019645E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 4
            r2 = 20170213(0x133c5e5, float:3.301909E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 5
            r2 = 20161017(0x133a1f9, float:3.2993317E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 6
            r2 = 20160327(0x1339f47, float:3.2991384E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 7
            r2 = 20150702(0x13379ae, float:3.2964409E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 8
            r2 = 20150401(0x1337881, float:3.2963565E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 9
            r2 = 20141218(0x13354a2, float:3.293783E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 10
            r2 = 20141107(0x1335433, float:3.2937518E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 11
            r2 = 20141028(0x13353e4, float:3.2937296E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 12
            r2 = 20141001(0x13353c9, float:3.293722E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 13
            r2 = 20140701(0x133529d, float:3.293638E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 14
            r2 = 20140324(0x1335124, float:3.2935323E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 15
            r2 = 20140313(0x1335119, float:3.2935292E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 16
            r2 = 20140204(0x13350ac, float:3.2934987E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 17
            r2 = 20131107(0x1332d23, float:3.2909492E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 18
            r2 = 20131024(0x1332cd0, float:3.290926E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 19
            r2 = 20130618(0x1332b3a, float:3.290812E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 20
            r2 = 20130502(0x1332ac6, float:3.2907796E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            r1 = 21
            r2 = 20121101(0x133060d, float:3.288145E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0[r1] = r2
            KNOWN_PROTOCOL_VERSIONS = r0
            return
        L_0x0189:
            throw r1
        L_0x018a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.<clinit>():void");
    }

    public static final int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> treeSet, int i, int[] iArr) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(iArr, "versionSpec");
            int i2 = -1;
            if (treeSet == null) {
                return -1;
            }
            int length = iArr.length - 1;
            Iterator<Integer> descendingIterator = treeSet.descendingIterator();
            int i3 = -1;
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                Integer next = descendingIterator.next();
                Intrinsics.checkNotNullExpressionValue(next, "fbAppVersion");
                i3 = Math.max(i3, next.intValue());
                while (length >= 0 && iArr[length] > next.intValue()) {
                    length--;
                }
                if (length < 0) {
                    return -1;
                }
                if (iArr[length] == next.intValue()) {
                    if (length % 2 == 0) {
                        i2 = Math.min(i3, i);
                    }
                }
            }
            return i2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return 0;
        }
    }

    public static final Bundle createBundleForException(FacebookException facebookException) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("error_description", facebookException.toString());
            if (facebookException instanceof FacebookOperationCanceledException) {
                bundle.putString(PushMessageHelper.ERROR_TYPE, "UserCanceled");
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.content.Intent createPlatformServiceIntent(android.content.Context r7) {
        /*
            java.lang.String r0 = "context"
            java.lang.Class<com.facebook.internal.NativeProtocol> r1 = com.facebook.internal.NativeProtocol.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)     // Catch:{ all -> 0x006a }
            java.util.List<com.facebook.internal.NativeProtocol$NativeAppInfo> r2 = facebookAppInfoList     // Catch:{ all -> 0x006a }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x006a }
        L_0x0015:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x006a }
            if (r4 == 0) goto L_0x0069
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x006a }
            com.facebook.internal.NativeProtocol$NativeAppInfo r4 = (com.facebook.internal.NativeProtocol.NativeAppInfo) r4     // Catch:{ all -> 0x006a }
            android.content.Intent r5 = new android.content.Intent     // Catch:{ all -> 0x006a }
            java.lang.String r6 = "com.facebook.platform.PLATFORM_SERVICE"
            r5.<init>(r6)     // Catch:{ all -> 0x006a }
            java.lang.String r4 = r4.getPackage()     // Catch:{ all -> 0x006a }
            android.content.Intent r4 = r5.setPackage(r4)     // Catch:{ all -> 0x006a }
            java.lang.String r5 = "android.intent.category.DEFAULT"
            android.content.Intent r4 = r4.addCategory(r5)     // Catch:{ all -> 0x006a }
            boolean r5 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ all -> 0x006a }
            if (r5 == 0) goto L_0x003d
            goto L_0x0065
        L_0x003d:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)     // Catch:{ all -> 0x0061 }
            if (r4 != 0) goto L_0x0043
            goto L_0x0065
        L_0x0043:
            android.content.pm.PackageManager r5 = r7.getPackageManager()     // Catch:{ all -> 0x0061 }
            r6 = 0
            android.content.pm.ResolveInfo r5 = r5.resolveService(r4, r6)     // Catch:{ all -> 0x0061 }
            if (r5 != 0) goto L_0x004f
            goto L_0x0065
        L_0x004f:
            com.facebook.internal.FacebookSignatureValidator r6 = com.facebook.internal.FacebookSignatureValidator.INSTANCE     // Catch:{ all -> 0x0061 }
            android.content.pm.ServiceInfo r5 = r5.serviceInfo     // Catch:{ all -> 0x0061 }
            java.lang.String r5 = r5.packageName     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = "resolveInfo.serviceInfo.packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x0061 }
            boolean r5 = com.facebook.internal.FacebookSignatureValidator.validateSignature(r7, r5)     // Catch:{ all -> 0x0061 }
            if (r5 != 0) goto L_0x0066
            goto L_0x0065
        L_0x0061:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r1)     // Catch:{ all -> 0x006a }
        L_0x0065:
            r4 = r3
        L_0x0066:
            if (r4 == 0) goto L_0x0015
            return r4
        L_0x0069:
            return r3
        L_0x006a:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.createPlatformServiceIntent(android.content.Context):android.content.Intent");
    }

    public static final Intent createProtocolResultIntent(Intent intent, Bundle bundle, FacebookException facebookException) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, "requestIntent");
            UUID callIdFromIntent = getCallIdFromIntent(intent);
            if (callIdFromIntent == null) {
                return null;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", getProtocolVersionFromIntent(intent));
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", callIdFromIntent.toString());
            if (facebookException != null) {
                bundle2.putBundle("error", createBundleForException(facebookException));
            }
            intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
            if (bundle != null) {
                intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
            }
            return intent2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final Bundle getBridgeArgumentsFromIntent(Intent intent) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        Bundle bundle = null;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                bundle = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final UUID getCallIdFromIntent(Intent intent) {
        String str;
        Class<NativeProtocol> cls = NativeProtocol.class;
        UUID uuid = null;
        if (CrashShieldHandler.isObjectCrashing(cls) || intent == null) {
            return null;
        }
        try {
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
                str = bundleExtra != null ? bundleExtra.getString("action_id") : null;
            } else {
                str = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
            }
            if (str != null) {
                try {
                    uuid = UUID.fromString(str);
                } catch (IllegalArgumentException unused) {
                }
            }
            return uuid;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final FacebookException getExceptionFromErrorData(Bundle bundle) {
        FacebookException facebookException;
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls) || bundle == null) {
            return null;
        }
        try {
            String string = bundle.getString(PushMessageHelper.ERROR_TYPE);
            if (string == null) {
                string = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
            }
            String string2 = bundle.getString("error_description");
            if (string2 == null) {
                string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
            }
            if (string == null || !CharsKt__CharKt.equals(string, (String) "UserCanceled", true)) {
                facebookException = new FacebookException(string2);
            } else {
                facebookException = new FacebookOperationCanceledException(string2);
            }
            return facebookException;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final int getLatestKnownVersion() {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            return KNOWN_PROTOCOL_VERSIONS[0].intValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return 0;
        }
    }

    public static final Bundle getMethodArgumentsFromIntent(Intent intent) {
        Bundle bundle;
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
            if (!isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                bundle = intent.getExtras();
            } else {
                bundle = intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
            }
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public static final int getProtocolVersionFromIntent(Intent intent) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
            return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return 0;
        }
    }

    public static final boolean isErrorResult(Intent intent) {
        Boolean bool;
        boolean z;
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, "resultIntent");
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
            if (bridgeArgumentsFromIntent == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(bridgeArgumentsFromIntent.containsKey("error"));
            }
            if (bool == null) {
                z = intent.hasExtra("com.facebook.platform.status.ERROR_TYPE");
            } else {
                z = bool.booleanValue();
            }
            return z;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final boolean isVersionCompatibleWithBucketedIntent(int i) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        boolean z = false;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (TweetUtils.contains(KNOWN_PROTOCOL_VERSIONS, Integer.valueOf(i)) && i >= 20140701) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public static final void setupProtocolRequestIntent(Intent intent, String str, String str2, int i, Bundle bundle) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                String applicationId = FacebookSdk.getApplicationId();
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                Validate.sdkInitialized();
                String str3 = FacebookSdk.applicationName;
                intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", i).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", str2).putExtra("com.facebook.platform.extra.APPLICATION_ID", applicationId);
                if (isVersionCompatibleWithBucketedIntent(i)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("action_id", str);
                    Utility.putNonEmptyString(bundle2, "app_name", str3);
                    intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle);
                } else {
                    intent.putExtra("com.facebook.platform.protocol.CALL_ID", str);
                    if (!Utility.isNullOrEmpty(str3)) {
                        intent.putExtra("com.facebook.platform.extra.APPLICATION_NAME", str3);
                    }
                    if (bundle != null) {
                        intent.putExtras(bundle);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final void updateAllAvailableProtocolVersionsAsync() {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    FacebookSdk.getExecutor().execute($$Lambda$zPYoJqodmd1JFixHd0alDrwtRVk.INSTANCE);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* renamed from: updateAllAvailableProtocolVersionsAsync$lambda-1  reason: not valid java name */
    public static final void m204updateAllAvailableProtocolVersionsAsync$lambda1() {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                for (NativeAppInfo fetchAvailableVersions : facebookAppInfoList) {
                    fetchAvailableVersions.fetchAvailableVersions(true);
                }
                protocolVersionsAsyncUpdating.set(false);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public static final Intent validateActivityIntent(Context context, Intent intent) {
        Class<NativeProtocol> cls = NativeProtocol.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            if (intent == null) {
                return null;
            }
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity == null) {
                return null;
            }
            FacebookSignatureValidator facebookSignatureValidator = FacebookSignatureValidator.INSTANCE;
            String str = resolveActivity.activityInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "resolveInfo.activityInfo.packageName");
            if (!FacebookSignatureValidator.validateSignature(context, str)) {
                intent = null;
            }
            return intent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    public final List<NativeAppInfo> buildFacebookAppList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return TweetUtils.arrayListOf(new KatanaAppInfo(), new WakizashiAppInfo());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final Intent createNativeAppIntent(NativeAppInfo nativeAppInfo, String str, Collection collection, String str2, boolean z, DefaultAudience defaultAudience, String str3, String str4, boolean z2, String str5, boolean z3, LoginTargetApp loginTargetApp, boolean z4, boolean z5, String str6) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String loginActivity = nativeAppInfo.getLoginActivity();
            if (loginActivity == null) {
                return null;
            }
            String str7 = str;
            Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), loginActivity).putExtra(PaymentConstants.CLIENT_ID, str);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent()\n            .setClassName(appInfo.getPackage(), activityName)\n            .putExtra(FACEBOOK_PROXY_AUTH_APP_ID_KEY, applicationId)");
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            putExtra.putExtra("facebook_sdk_version", "16.0.1");
            if (!Utility.isNullOrEmpty(collection)) {
                Collection collection2 = collection;
                putExtra.putExtra("scope", TextUtils.join(",", collection));
            }
            if (!Utility.isNullOrEmpty(str2)) {
                String str8 = str2;
                putExtra.putExtra("e2e", str2);
            }
            String str9 = str3;
            putExtra.putExtra("state", str3);
            putExtra.putExtra("response_type", nativeAppInfo.getResponseType());
            putExtra.putExtra("nonce", str6);
            putExtra.putExtra("return_scopes", BaseParser.TRUE);
            if (z) {
                putExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
            }
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            putExtra.putExtra("legacy_override", FacebookSdk.getGraphApiVersion());
            String str10 = str4;
            putExtra.putExtra("auth_type", str4);
            if (z2) {
                putExtra.putExtra("fail_on_logged_out", true);
            }
            String str11 = str5;
            putExtra.putExtra("messenger_page_id", str5);
            putExtra.putExtra("reset_messenger_state", z3);
            if (z4) {
                putExtra.putExtra("fx_app", loginTargetApp.toString());
            }
            if (z5) {
                putExtra.putExtra("skip_dedupe", true);
            }
            return putExtra;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0096 A[SYNTHETIC, Splitter:B:35:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e A[Catch:{ all -> 0x004a, all -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009f A[Catch:{ all -> 0x004a, all -> 0x00a3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.TreeSet<java.lang.Integer> fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol.NativeAppInfo r12) {
        /*
            r11 = this;
            java.lang.String r0 = "version"
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r11)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            java.util.TreeSet r1 = new java.util.TreeSet     // Catch:{ all -> 0x00a3 }
            r1.<init>()     // Catch:{ all -> 0x00a3 }
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x00a3 }
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x00a3 }
            android.content.ContentResolver r4 = r3.getContentResolver()     // Catch:{ all -> 0x00a3 }
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch:{ all -> 0x00a3 }
            boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r11)     // Catch:{ all -> 0x00a3 }
            if (r3 == 0) goto L_0x0025
        L_0x0023:
            r5 = r2
            goto L_0x004f
        L_0x0025:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r3.<init>()     // Catch:{ all -> 0x004a }
            java.lang.String r5 = "content://"
            r3.append(r5)     // Catch:{ all -> 0x004a }
            java.lang.String r5 = r12.getPackage()     // Catch:{ all -> 0x004a }
            r3.append(r5)     // Catch:{ all -> 0x004a }
            java.lang.String r5 = ".provider.PlatformProvider/versions"
            r3.append(r5)     // Catch:{ all -> 0x004a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x004a }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ all -> 0x004a }
            java.lang.String r5 = "parse(CONTENT_SCHEME + appInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ all -> 0x004a }
            r5 = r3
            goto L_0x004f
        L_0x004a:
            r3 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r11)     // Catch:{ all -> 0x00a3 }
            goto L_0x0023
        L_0x004f:
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x009a }
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x009a }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ all -> 0x009a }
            java.lang.String r12 = r12.getPackage()     // Catch:{ all -> 0x009a }
            java.lang.String r7 = ".provider.PlatformProvider"
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r7)     // Catch:{ all -> 0x009a }
            r7 = 0
            android.content.pm.ProviderInfo r12 = r3.resolveContentProvider(r12, r7)     // Catch:{ RuntimeException -> 0x0069 }
            goto L_0x006a
        L_0x0069:
            r12 = r2
        L_0x006a:
            if (r12 == 0) goto L_0x0092
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ IllegalArgumentException | NullPointerException | SecurityException -> 0x0074 }
            goto L_0x0075
        L_0x0074:
            r12 = r2
        L_0x0075:
            if (r12 == 0) goto L_0x0093
        L_0x0077:
            boolean r3 = r12.moveToNext()     // Catch:{ all -> 0x008d }
            if (r3 == 0) goto L_0x0093
            int r3 = r12.getColumnIndex(r0)     // Catch:{ all -> 0x008d }
            int r3 = r12.getInt(r3)     // Catch:{ all -> 0x008d }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x008d }
            r1.add(r3)     // Catch:{ all -> 0x008d }
            goto L_0x0077
        L_0x008d:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
            goto L_0x009c
        L_0x0092:
            r12 = r2
        L_0x0093:
            if (r12 != 0) goto L_0x0096
            goto L_0x0099
        L_0x0096:
            r12.close()     // Catch:{ all -> 0x00a3 }
        L_0x0099:
            return r1
        L_0x009a:
            r12 = move-exception
            r0 = r2
        L_0x009c:
            if (r0 != 0) goto L_0x009f
            goto L_0x00a2
        L_0x009f:
            r0.close()     // Catch:{ all -> 0x00a3 }
        L_0x00a2:
            throw r12     // Catch:{ all -> 0x00a3 }
        L_0x00a3:
            r12 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r12, r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol$NativeAppInfo):java.util.TreeSet");
    }

    public final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<? extends NativeAppInfo> list, int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            updateAllAvailableProtocolVersionsAsync();
            if (list == null) {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.protocolVersion = -1;
                return protocolVersionQueryResult;
            }
            for (NativeAppInfo nativeAppInfo : list) {
                TreeSet<Integer> treeSet = nativeAppInfo.availableVersions;
                if (treeSet == null || !Intrinsics.areEqual(Boolean.valueOf(treeSet.isEmpty()), Boolean.FALSE)) {
                    nativeAppInfo.fetchAvailableVersions(false);
                }
                int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.availableVersions, getLatestKnownVersion(), iArr);
                if (computeLatestAvailableVersionFromVersionSpec != -1) {
                    ProtocolVersionQueryResult protocolVersionQueryResult2 = new ProtocolVersionQueryResult(null);
                    protocolVersionQueryResult2.appInfo = nativeAppInfo;
                    protocolVersionQueryResult2.protocolVersion = computeLatestAvailableVersionFromVersionSpec;
                    return protocolVersionQueryResult2;
                }
            }
            ProtocolVersionQueryResult protocolVersionQueryResult3 = new ProtocolVersionQueryResult(null);
            protocolVersionQueryResult3.protocolVersion = -1;
            return protocolVersionQueryResult3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
