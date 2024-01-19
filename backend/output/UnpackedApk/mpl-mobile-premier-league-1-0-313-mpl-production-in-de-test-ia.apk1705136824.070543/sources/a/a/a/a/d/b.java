package a.a.a.a.d;

import a.a.c.c;
import a.a.c.d;
import a.a.f.b$a;
import a.a.f.b$b;
import a.a.h.c$a;
import a.a.h.c$b;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.LongSparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.appcompat.widget.WithHint;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.R$styleable;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.graphics.drawable.WrappedDrawableApi21;
import androidx.core.provider.FontRequest;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.android.AndroidAudio;
import com.badlogic.gdx.backends.android.DefaultAndroidAudio;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.cfg.utilities.Handle;
import com.cfg.utilities.a;
import com.facebook.react.bridge.ColorPropConverter;
import com.mpl.MLog;
import com.xiaomi.mipush.sdk.Constants;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static a f2411a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f6a;

    /* renamed from: b  reason: collision with root package name */
    public static d<String, Texture> f2412b;

    /* renamed from: b  reason: collision with other field name */
    public static PublishSubject<a.a.f.a> f7b;
    public static PublishSubject<a.a.h.b> b1;

    /* renamed from: c  reason: collision with root package name */
    public static c<String, Sound> f2413c;

    /* renamed from: c  reason: collision with other field name */
    public static a.a.f.c f8c;

    /* renamed from: c  reason: collision with other field name */
    public static a.a.h.a f9c;

    /* renamed from: d  reason: collision with root package name */
    public static a.a.c.b<String, BitmapFont> f2414d;

    /* renamed from: d  reason: collision with other field name */
    public static Scheduler f10d;
    public static Scheduler d1;

    /* renamed from: e  reason: collision with root package name */
    public static int f2415e;

    /* renamed from: f  reason: collision with root package name */
    public static int f2416f;
    public static Field sDrawableCacheField;
    public static boolean sDrawableCacheFieldFetched;
    public static Method sGetLayoutDirectionMethod;
    public static boolean sGetLayoutDirectionMethodFetched;
    public static Field sResourcesImplField;
    public static boolean sResourcesImplFieldFetched;
    public static Method sSetLayoutDirectionMethod;
    public static boolean sSetLayoutDirectionMethodFetched;
    public static Class<?> sThemedResourceCacheClazz;
    public static boolean sThemedResourceCacheClazzFetched;
    public static Field sThemedResourceCache_mUnthemedEntriesField;
    public static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    public static int a(String str, long j, TimeUnit timeUnit) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline50(str, " < 0"));
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50(str, " too large."));
            } else if (millis != 0 || i <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50(str, " too small."));
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public static ah a(a aVar) {
        int i = ai$1.f2727a[aVar.ordinal()];
        if (i == 1) {
            return new cb();
        }
        if (i == 2) {
            return new cc();
        }
        throw new IllegalArgumentException("Unknown token type for factory " + aVar);
    }

    public static void a(Handle handle) {
        f2411a = new a(handle);
        g();
        c<String, Sound> cVar = new c<>(20);
        f2413c = cVar;
        AndroidAudio androidAudio = k.audio;
        DefaultAndroidAudio defaultAndroidAudio = (DefaultAndroidAudio) androidAudio;
        cVar.a(NotificationCompat.CATEGORY_ALARM, defaultAndroidAudio.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "alarm1.mp3", f2411a)));
        c<String, Sound> cVar2 = f2413c;
        AndroidAudio androidAudio2 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio2 = (DefaultAndroidAudio) androidAudio2;
        cVar2.a("sound_myturn", defaultAndroidAudio2.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "sound_myturn.mp3", f2411a)));
        c<String, Sound> cVar3 = f2413c;
        AndroidAudio androidAudio3 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio3 = (DefaultAndroidAudio) androidAudio3;
        cVar3.a("cardSlide5", defaultAndroidAudio3.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "cardSlide5.mp3", f2411a)));
        c<String, Sound> cVar4 = f2413c;
        AndroidAudio androidAudio4 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio4 = (DefaultAndroidAudio) androidAudio4;
        cVar4.a("cardTakeOut", defaultAndroidAudio4.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "cardTakeOut.mp3", f2411a)));
        c<String, Sound> cVar5 = f2413c;
        AndroidAudio androidAudio5 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio5 = (DefaultAndroidAudio) androidAudio5;
        cVar5.a("cardShuffle", defaultAndroidAudio5.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "cardShuffle.mp3", f2411a)));
        c<String, Sound> cVar6 = f2413c;
        AndroidAudio androidAudio6 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio6 = (DefaultAndroidAudio) androidAudio6;
        cVar6.a("gameWin", defaultAndroidAudio6.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "gameWin.mp3", f2411a)));
        c<String, Sound> cVar7 = f2413c;
        AndroidAudio androidAudio7 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio7 = (DefaultAndroidAudio) androidAudio7;
        cVar7.a("soundEmoji1", defaultAndroidAudio7.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji1.mp3", f2411a)));
        c<String, Sound> cVar8 = f2413c;
        AndroidAudio androidAudio8 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio8 = (DefaultAndroidAudio) androidAudio8;
        cVar8.a("soundEmoji2", defaultAndroidAudio8.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji2.mp3", f2411a)));
        c<String, Sound> cVar9 = f2413c;
        AndroidAudio androidAudio9 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio9 = (DefaultAndroidAudio) androidAudio9;
        cVar9.a("soundEmoji3", defaultAndroidAudio9.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji3.mp3", f2411a)));
        c<String, Sound> cVar10 = f2413c;
        AndroidAudio androidAudio10 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio10 = (DefaultAndroidAudio) androidAudio10;
        cVar10.a("soundEmoji4", defaultAndroidAudio10.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji4.mp3", f2411a)));
        c<String, Sound> cVar11 = f2413c;
        AndroidAudio androidAudio11 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio11 = (DefaultAndroidAudio) androidAudio11;
        cVar11.a("soundEmoji5", defaultAndroidAudio11.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji5.mp3", f2411a)));
        c<String, Sound> cVar12 = f2413c;
        AndroidAudio androidAudio12 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio12 = (DefaultAndroidAudio) androidAudio12;
        cVar12.a("soundEmoji6", defaultAndroidAudio12.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji6.mp3", f2411a)));
        c<String, Sound> cVar13 = f2413c;
        AndroidAudio androidAudio13 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio13 = (DefaultAndroidAudio) androidAudio13;
        cVar13.a("soundEmoji7", defaultAndroidAudio13.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji7.mp3", f2411a)));
        c<String, Sound> cVar14 = f2413c;
        AndroidAudio androidAudio14 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio14 = (DefaultAndroidAudio) androidAudio14;
        cVar14.a("soundEmoji8", defaultAndroidAudio14.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji8.mp3", f2411a)));
        c<String, Sound> cVar15 = f2413c;
        AndroidAudio androidAudio15 = k.audio;
        DefaultAndroidAudio defaultAndroidAudio15 = (DefaultAndroidAudio) androidAudio15;
        cVar15.a("soundEmoji9", defaultAndroidAudio15.newSound(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji9.mp3", f2411a)));
        f2414d = new a.a.c.b<>(30);
        FreeTypeFontGenerator freeTypeFontGenerator = new FreeTypeFontGenerator(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "one_for_all.ttf", f2411a));
        FreeTypeFontParameter freeTypeFontParameter = new FreeTypeFontParameter();
        freeTypeFontParameter.size = 28;
        freeTypeFontParameter.color = Color.BLACK;
        freeTypeFontParameter.incremental = true;
        freeTypeFontParameter.characters = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ ¡₹¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁ ÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽžſƒƠơƯưǰǺǻǼǽǾǿȘșȚțȷʼˆˇˉ˘˙˚˛˜˝˳̣̀́̃̉̏΄΅Ά·ΈΉΊΌΎΏΐΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩΪΫάέήίΰαβγδεζηθικλμνξοπρςστυφχψωϊϋόύώϑϒϖЀЁЂЃЄЅІЇЈЉЊЋЌЍЎЏАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюяѐёђѓєѕіїјљњћќѝўџѠѡѢѣѤѥѦѧѨѩѪѫѬѭѮѯѰѱѲѳѴѵѶѷѸѹѺѻѼѽѾѿҀҁ҂҃҄҅҆҈҉ҊҋҌҍҎҏҐґҒғҔҕҖҗҘҙҚқҜҝҞҟҠҡҢңҤҥҦҧҨҩҪҫҬҭҮүҰұҲҳҴҵҶҷҸҹҺһҼҽҾҿӀӁӂӃӄӅӆӇӈӉӊӋӌӍӎӏӐӑӒӓӔӕӖӗӘәӚӛӜӝӞӟӠӡӢӣӤӥӦӧӨөӪӫӬӭӮӯӰӱӲӳӴӵӶӷӸӹӺӻӼӽӾӿԀԁԂԃԄԅԆԇԈԉԊԋԌԍԎԏԐԑԒԓḀḁḾḿẀẁẂẃẄẅẠạẢảẤấẦầẨẩẪẫẬậẮắẰằẲẳẴẵẶặẸẹẺẻẼẽẾếỀềỂểỄễỆệỈỉỊịỌọỎỏỐốỒồỔổỖỗỘộỚớỜờỞởỠỡỢợỤụỦủỨứỪừỬửỮữỰựỲỳỴỵỶỷỸỹὍ῞  ​–—―‗‘’‚‛“”„†‡•…‰′″‹›‼⁄⁰⁴⁵⁶⁷⁸⁹ⁿ₣₤₧₫€℅ℓ№℠™Ω℮⅛⅜⅝⅞∂∆∏∑−√∞∫≈≠≤≥◊☀☁☂☃☄★☆☇☈☉☊☋☌☍☎☏☐☑☒☓☔☕☖☗☘☙☚☛☜☝☞☟☠☡☢☣☤☥☦☧☨☩☪☫☬☭☮☯☰☱☲☳☴☵☶☷☸☹☺☻☽☾☿♀♁♂♃♄♅♆♇♈♉♊♋♌♍♎♏♐♑♒♓♔♕♖♗♘♙♚♛♜♝♞♟♠♡♢♣♤♥♦♧♨♩♪♫♬♭♮♯♰♱♲♳♴♵♶♷♸♹♺♻♼♽♾♿⚀⚁⚂⚃⚄⚅⚆⚇⚈⚉⚊⚋⚌⚍⚎⚏⚐⚑⚒⚓⚔⚕⚖⚗⚘⚙⚚⚛⚜⚝⚞⚟⚠⚡⚢⚣⚤⚥⚦⚧⚨⚩⚪⚫⚬⚭⚮⚯⚰⚱⚲⚳⚴⚵⚶⚷⚸⚹⚺⚻⚼⚽⚾⚿⛀⛁⛂⛃⛄⛅⛆⛇⛈⛉⛊⛋⛌⛍⛎⛏⛐⛑⛒⛓⛔⛕⛖⛗⛘⛙⛚⛛⛜⛝⛞⛟⛠⛡⛢⛣⛤⛥⛦⛧⛨⛩⛪⛫⛬⛭⛮⛯⛰⛱⛲⛳⛴⛵⛶⛷⛸⛹⛺⛻⛼⛽⛾⛿ﬀﬁﬂﬃﬄ﻿￼�🌀🌁🌂🌃🌄🌅🌆🌇🌈🌉🌊🌋🌌🌍🌎🌏🌐🌑🌒🌓🌔🌕🌖🌗🌘🌙🌚🌛🌜🌝🌞🌟🌠🌰🌱🌲🌳🌴🌵🌷🌸🌹🌺🌻🌼🌽🌾🌿🍀🍁🍂🍃🍄🍅🍆🍇🍈🍉🍊🍋🍌🍍🍎🍏🍐🍑🍒🍓🍔🍕🍖🍗🍘🍙🍚🍛🍜🍝🍞🍟🍠🍡🍢🍣🍤🍥🍦🍧🍨🍩🍪🍫🍬🍭🍮🍯🍰🍱🍲🍳🍴🍵🍶🍷🍸🍹🍺🍻🍼🎀🎁🎂🎃🎄🎅🎆🎇🎈🎉🎊🎋🎌🎍🎎🎏🎐🎑🎒🎓🎠🎡🎢🎣🎤🎥🎦🎧🎨🎩🎪🎫🎬🎭🎮🎯🎰🎱🎲🎳🎴🎵🎶🎷🎸🎹🎺🎻🎼🎽🎾🎿🏀🏁🏂🏃🏄🏆🏇🏈🏉🏊🏠🏡🏢🏣🏤🏥🏦🏧🏨🏩🏪🏫🏬🏭🏮🏯🏰🐀🐁🐂🐃🐄🐅🐆🐇🐈🐉🐊🐋🐌🐍🐎🐏🐐🐑🐒🐓🐔🐕🐖🐗🐘🐙🐚🐛🐜🐝🐞🐟🐠🐡🐢🐣🐤🐥🐦🐧🐨🐩🐪🐫🐬🐭🐮🐯🐰🐱🐲🐳🐴🐵🐶🐷🐸🐹🐺🐻🐼🐽🐾👀👂👃👄👅👆👇👈👉👊👋👌👍👎👏👐👑👒👓👔👕👖👗👘👙👚👛👜👝👞👟👠👡👢👣👤👥👦👧👨👩👪👫👬👭👮👯👰👱👲👳👴👵👶👷👸👹👺👻👼👽👾👿💀💁💂💃💄💅💆💇💈💉💊💋💌💍💎💏💐💑💒💓💔💕💖💗💘💙💚💛💜💝💞💟💠💡💢💣💤💥💦💧💨💩💪💫💬💭💮💯💰💱💲💳💴💵💶💷💸💹💺💻💼💽💾💿📀📁📂📃📄📅📆📇📈📉📊📋📌📍📎📏📐📑📒📓📔📕📖📗📘📙📚📛📜📝📞📟📠📡📢📣📤📥📦📧📨📩📪📫📬📭📮📰📱📲📳📴📵📶📷📹📺📻📼🔀🔁🔂🔃🔄🔅🔆🔇🔈🔉🔊🔋🔌🔍🔎🔏🔐🔑🔒🔓🔔🔕🔖🔗🔘🔙🔚🔛🔜🔝🔞🔟🔠🔡🔢🔣🔤🔥🔦🔧🔨🔩🔪🔫🔬🔭🔮🔯🔰🔱🔲🔳🔴🔵🔶🔷🔸🔹🔺🔻🔼🔽🕀🕁🕂🕃🕐🕑🕒🕓🕔🕕🕖🕗🕘🕙🕚🕛🕜🕝🕞🕟🕠🕡🕢🕣🕤🕥🕦🕧🗻🗼🗽🗾🗿😀😁😂😃😄😅😆😇😈😉😊😋😌😍😎😏😐😑😒😓😔😕😖😗😘😙😚😛😜😝😞😟😠😡😢😣😤😥😦😧😨😩😪😫😬😭😮😯😰😱😲😳😴😵😶😷😸😹😺😻😼😽😾😿🙀🙅🙆🙇🙈🙉🙊🙋🙌🙍🙎🙏🚀🚁🚂🚃🚄🚅🚆🚇🚈🚉🚊🚋🚌🚍🚎🚏🚐🚑🚒🚓🚔🚕🚖🚗🚘🚙🚚🚛🚜🚝🚞🚟🚠🚡🚢🚣🚤🚥🚦🚧🚨🚩🚪🚫🚬🚭🚮🚯🚰🚱🚲🚳🚴🚵🚶🚷🚸🚹🚺🚻🚼🚽🚾🚿🛀🛁🛂🛃🛄🛅";
        BitmapFont generateFont = freeTypeFontGenerator.generateFont(freeTypeFontParameter);
        Texture texture = generateFont.getRegion().getTexture();
        TextureFilter textureFilter = TextureFilter.Linear;
        texture.setFilter(textureFilter, textureFilter);
        FreeTypeFontGenerator freeTypeFontGenerator2 = new FreeTypeFontGenerator(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "Rajdhani-Bold.ttf", f2411a));
        FreeTypeFontParameter freeTypeFontParameter2 = new FreeTypeFontParameter();
        freeTypeFontParameter2.size = 30;
        freeTypeFontParameter2.color = Color.WHITE;
        freeTypeFontParameter2.incremental = true;
        freeTypeFontParameter2.characters = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ ¡₹¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁ ÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿĀāĂăĄąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝĞğĠġĢģĤĥĦħĨĩĪīĬĭĮįİıĲĳĴĵĶķĸĹĺĻļĽľĿŀŁłŃńŅņŇňŉŊŋŌōŎŏŐőŒœŔŕŖŗŘřŚśŜŝŞşŠšŢţŤťŦŧŨũŪūŬŭŮůŰűŲųŴŵŶŷŸŹźŻżŽžſƒƠơƯưǰǺǻǼǽǾǿȘșȚțȷʼˆˇˉ˘˙˚˛˜˝˳̣̀́̃̉̏΄΅Ά·ΈΉΊΌΎΏΐΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩΪΫάέήίΰαβγδεζηθικλμνξοπρςστυφχψωϊϋόύώϑϒϖЀЁЂЃЄЅІЇЈЉЊЋЌЍЎЏАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюяѐёђѓєѕіїјљњћќѝўџѠѡѢѣѤѥѦѧѨѩѪѫѬѭѮѯѰѱѲѳѴѵѶѷѸѹѺѻѼѽѾѿҀҁ҂҃҄҅҆҈҉ҊҋҌҍҎҏҐґҒғҔҕҖҗҘҙҚқҜҝҞҟҠҡҢңҤҥҦҧҨҩҪҫҬҭҮүҰұҲҳҴҵҶҷҸҹҺһҼҽҾҿӀӁӂӃӄӅӆӇӈӉӊӋӌӍӎӏӐӑӒӓӔӕӖӗӘәӚӛӜӝӞӟӠӡӢӣӤӥӦӧӨөӪӫӬӭӮӯӰӱӲӳӴӵӶӷӸӹӺӻӼӽӾӿԀԁԂԃԄԅԆԇԈԉԊԋԌԍԎԏԐԑԒԓḀḁḾḿẀẁẂẃẄẅẠạẢảẤấẦầẨẩẪẫẬậẮắẰằẲẳẴẵẶặẸẹẺẻẼẽẾếỀềỂểỄễỆệỈỉỊịỌọỎỏỐốỒồỔổỖỗỘộỚớỜờỞởỠỡỢợỤụỦủỨứỪừỬửỮữỰựỲỳỴỵỶỷỸỹὍ῞  ​–—―‗‘’‚‛“”„†‡•…‰′″‹›‼⁄⁰⁴⁵⁶⁷⁸⁹ⁿ₣₤₧₫€℅ℓ№℠™Ω℮⅛⅜⅝⅞∂∆∏∑−√∞∫≈≠≤≥◊☀☁☂☃☄★☆☇☈☉☊☋☌☍☎☏☐☑☒☓☔☕☖☗☘☙☚☛☜☝☞☟☠☡☢☣☤☥☦☧☨☩☪☫☬☭☮☯☰☱☲☳☴☵☶☷☸☹☺☻☽☾☿♀♁♂♃♄♅♆♇♈♉♊♋♌♍♎♏♐♑♒♓♔♕♖♗♘♙♚♛♜♝♞♟♠♡♢♣♤♥♦♧♨♩♪♫♬♭♮♯♰♱♲♳♴♵♶♷♸♹♺♻♼♽♾♿⚀⚁⚂⚃⚄⚅⚆⚇⚈⚉⚊⚋⚌⚍⚎⚏⚐⚑⚒⚓⚔⚕⚖⚗⚘⚙⚚⚛⚜⚝⚞⚟⚠⚡⚢⚣⚤⚥⚦⚧⚨⚩⚪⚫⚬⚭⚮⚯⚰⚱⚲⚳⚴⚵⚶⚷⚸⚹⚺⚻⚼⚽⚾⚿⛀⛁⛂⛃⛄⛅⛆⛇⛈⛉⛊⛋⛌⛍⛎⛏⛐⛑⛒⛓⛔⛕⛖⛗⛘⛙⛚⛛⛜⛝⛞⛟⛠⛡⛢⛣⛤⛥⛦⛧⛨⛩⛪⛫⛬⛭⛮⛯⛰⛱⛲⛳⛴⛵⛶⛷⛸⛹⛺⛻⛼⛽⛾⛿ﬀﬁﬂﬃﬄ﻿￼�🌀🌁🌂🌃🌄🌅🌆🌇🌈🌉🌊🌋🌌🌍🌎🌏🌐🌑🌒🌓🌔🌕🌖🌗🌘🌙🌚🌛🌜🌝🌞🌟🌠🌰🌱🌲🌳🌴🌵🌷🌸🌹🌺🌻🌼🌽🌾🌿🍀🍁🍂🍃🍄🍅🍆🍇🍈🍉🍊🍋🍌🍍🍎🍏🍐🍑🍒🍓🍔🍕🍖🍗🍘🍙🍚🍛🍜🍝🍞🍟🍠🍡🍢🍣🍤🍥🍦🍧🍨🍩🍪🍫🍬🍭🍮🍯🍰🍱🍲🍳🍴🍵🍶🍷🍸🍹🍺🍻🍼🎀🎁🎂🎃🎄🎅🎆🎇🎈🎉🎊🎋🎌🎍🎎🎏🎐🎑🎒🎓🎠🎡🎢🎣🎤🎥🎦🎧🎨🎩🎪🎫🎬🎭🎮🎯🎰🎱🎲🎳🎴🎵🎶🎷🎸🎹🎺🎻🎼🎽🎾🎿🏀🏁🏂🏃🏄🏆🏇🏈🏉🏊🏠🏡🏢🏣🏤🏥🏦🏧🏨🏩🏪🏫🏬🏭🏮🏯🏰🐀🐁🐂🐃🐄🐅🐆🐇🐈🐉🐊🐋🐌🐍🐎🐏🐐🐑🐒🐓🐔🐕🐖🐗🐘🐙🐚🐛🐜🐝🐞🐟🐠🐡🐢🐣🐤🐥🐦🐧🐨🐩🐪🐫🐬🐭🐮🐯🐰🐱🐲🐳🐴🐵🐶🐷🐸🐹🐺🐻🐼🐽🐾👀👂👃👄👅👆👇👈👉👊👋👌👍👎👏👐👑👒👓👔👕👖👗👘👙👚👛👜👝👞👟👠👡👢👣👤👥👦👧👨👩👪👫👬👭👮👯👰👱👲👳👴👵👶👷👸👹👺👻👼👽👾👿💀💁💂💃💄💅💆💇💈💉💊💋💌💍💎💏💐💑💒💓💔💕💖💗💘💙💚💛💜💝💞💟💠💡💢💣💤💥💦💧💨💩💪💫💬💭💮💯💰💱💲💳💴💵💶💷💸💹💺💻💼💽💾💿📀📁📂📃📄📅📆📇📈📉📊📋📌📍📎📏📐📑📒📓📔📕📖📗📘📙📚📛📜📝📞📟📠📡📢📣📤📥📦📧📨📩📪📫📬📭📮📰📱📲📳📴📵📶📷📹📺📻📼🔀🔁🔂🔃🔄🔅🔆🔇🔈🔉🔊🔋🔌🔍🔎🔏🔐🔑🔒🔓🔔🔕🔖🔗🔘🔙🔚🔛🔜🔝🔞🔟🔠🔡🔢🔣🔤🔥🔦🔧🔨🔩🔪🔫🔬🔭🔮🔯🔰🔱🔲🔳🔴🔵🔶🔷🔸🔹🔺🔻🔼🔽🕀🕁🕂🕃🕐🕑🕒🕓🕔🕕🕖🕗🕘🕙🕚🕛🕜🕝🕞🕟🕠🕡🕢🕣🕤🕥🕦🕧🗻🗼🗽🗾🗿😀😁😂😃😄😅😆😇😈😉😊😋😌😍😎😏😐😑😒😓😔😕😖😗😘😙😚😛😜😝😞😟😠😡😢😣😤😥😦😧😨😩😪😫😬😭😮😯😰😱😲😳😴😵😶😷😸😹😺😻😼😽😾😿🙀🙅🙆🙇🙈🙉🙊🙋🙌🙍🙎🙏🚀🚁🚂🚃🚄🚅🚆🚇🚈🚉🚊🚋🚌🚍🚎🚏🚐🚑🚒🚓🚔🚕🚖🚗🚘🚙🚚🚛🚜🚝🚞🚟🚠🚡🚢🚣🚤🚥🚦🚧🚨🚩🚪🚫🚬🚭🚮🚯🚰🚱🚲🚳🚴🚵🚶🚷🚸🚹🚺🚻🚼🚽🚾🚿🛀🛁🛂🛃🛄🛅";
        BitmapFont generateFont2 = freeTypeFontGenerator2.generateFont(freeTypeFontParameter2);
        Texture texture2 = generateFont2.getRegion().getTexture();
        TextureFilter textureFilter2 = TextureFilter.Linear;
        texture2.setFilter(textureFilter2, textureFilter2);
        f2414d.a("one_for_all", generateFont);
        f2414d.a("Rajdhani-Bold", generateFont2);
        freeTypeFontGenerator.dispose();
        freeTypeFontGenerator2.dispose();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0208, code lost:
        if (r2.mVerticalChainStyle == 2) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x02e6, code lost:
        if (r5[r16].mTarget.mOwner == r6) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0145, code lost:
        if (r4[r2].mTarget.mOwner == r5) goto L_0x0149;
     */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x04a9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x0514 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x05a9  */
    /* JADX WARNING: Removed duplicated region for block: B:339:0x0622  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x062f  */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x06ff  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x074f  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x0751  */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x075c  */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x075f  */
    /* JADX WARNING: Removed duplicated region for block: B:409:0x0765  */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x0768  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x076c  */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x077b  */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x077e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r36, androidx.constraintlayout.core.LinearSystem r37, java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r38, int r39) {
        /*
            r0 = r36
            r10 = r37
            r11 = r38
            r12 = 2
            if (r39 != 0) goto L_0x0012
            int r1 = r0.mHorizontalChainsSize
            androidx.constraintlayout.core.widgets.ChainHead[] r2 = r0.mHorizontalChainsArray
            r14 = r1
            r15 = r2
            r16 = 0
            goto L_0x001a
        L_0x0012:
            int r1 = r0.mVerticalChainsSize
            androidx.constraintlayout.core.widgets.ChainHead[] r2 = r0.mVerticalChainsArray
            r14 = r1
            r15 = r2
            r16 = 2
        L_0x001a:
            r9 = 0
        L_0x001b:
            if (r9 >= r14) goto L_0x07b0
            r1 = r15[r9]
            boolean r2 = r1.mDefined
            r17 = 0
            r8 = 8
            r4 = 1
            if (r2 != 0) goto L_0x0198
            int r2 = r1.mOrientation
            int r2 = r2 * 2
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r1.mFirst
            r6 = r5
            r7 = 0
        L_0x0030:
            if (r7 != 0) goto L_0x0156
            int r13 = r1.mWidgetsCount
            int r13 = r13 + r4
            r1.mWidgetsCount = r13
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r5.mNextChainWidget
            int r3 = r1.mOrientation
            r13[r3] = r17
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r13 = r5.mListNextMatchConstraintsWidget
            r13[r3] = r17
            int r13 = r5.mVisibility
            if (r13 == r8) goto L_0x0123
            int r13 = r1.mVisibleWidgets
            int r13 = r13 + r4
            r1.mVisibleWidgets = r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r3 = r5.getDimensionBehaviour(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 == r13) goto L_0x0068
            int r3 = r1.mTotalSize
            int r13 = r1.mOrientation
            if (r13 != 0) goto L_0x005d
            int r13 = r5.getWidth()
            goto L_0x0065
        L_0x005d:
            if (r13 != r4) goto L_0x0064
            int r13 = r5.getHeight()
            goto L_0x0065
        L_0x0064:
            r13 = 0
        L_0x0065:
            int r3 = r3 + r13
            r1.mTotalSize = r3
        L_0x0068:
            int r3 = r1.mTotalSize
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r13 = r5.mListAnchors
            r13 = r13[r2]
            int r13 = r13.getMargin()
            int r13 = r13 + r3
            r1.mTotalSize = r13
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r5.mListAnchors
            int r20 = r2 + 1
            r3 = r3[r20]
            int r3 = r3.getMargin()
            int r3 = r3 + r13
            r1.mTotalSize = r3
            int r3 = r1.mTotalMargins
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r13 = r5.mListAnchors
            r13 = r13[r2]
            int r13 = r13.getMargin()
            int r13 = r13 + r3
            r1.mTotalMargins = r13
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r5.mListAnchors
            r3 = r3[r20]
            int r3 = r3.getMargin()
            int r3 = r3 + r13
            r1.mTotalMargins = r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r1.mFirstVisibleWidget
            if (r3 != 0) goto L_0x00a0
            r1.mFirstVisibleWidget = r5
        L_0x00a0:
            r1.mLastVisibleWidget = r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r5.mListDimensionBehaviors
            int r13 = r1.mOrientation
            r3 = r3[r13]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r8) goto L_0x0123
            int[] r3 = r5.mResolvedMatchConstraintDefault
            r8 = r3[r13]
            r4 = 3
            if (r8 == 0) goto L_0x00bb
            r8 = r3[r13]
            if (r8 == r4) goto L_0x00bb
            r3 = r3[r13]
            if (r3 != r12) goto L_0x0121
        L_0x00bb:
            int r3 = r1.mWidgetsMatchCount
            r8 = 1
            int r3 = r3 + r8
            r1.mWidgetsMatchCount = r3
            float[] r3 = r5.mWeight
            int r8 = r1.mOrientation
            r13 = r3[r8]
            r19 = 0
            int r22 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r22 <= 0) goto L_0x00d4
            float r12 = r1.mTotalWeight
            r3 = r3[r8]
            float r12 = r12 + r3
            r1.mTotalWeight = r12
        L_0x00d4:
            int r3 = r1.mOrientation
            int r8 = r5.mVisibility
            r12 = 8
            if (r8 == r12) goto L_0x00f0
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r5.mListDimensionBehaviors
            r8 = r8[r3]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r12) goto L_0x00f0
            int[] r8 = r5.mResolvedMatchConstraintDefault
            r12 = r8[r3]
            if (r12 == 0) goto L_0x00ee
            r3 = r8[r3]
            if (r3 != r4) goto L_0x00f0
        L_0x00ee:
            r3 = 1
            goto L_0x00f1
        L_0x00f0:
            r3 = 0
        L_0x00f1:
            if (r3 == 0) goto L_0x010f
            r3 = 0
            int r4 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r4 >= 0) goto L_0x00fc
            r3 = 1
            r1.mHasUndefinedWeights = r3
            goto L_0x00ff
        L_0x00fc:
            r3 = 1
            r1.mHasDefinedWeights = r3
        L_0x00ff:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r3 = r1.mWeightedMatchConstraintsWidgets
            if (r3 != 0) goto L_0x010a
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r1.mWeightedMatchConstraintsWidgets = r3
        L_0x010a:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r3 = r1.mWeightedMatchConstraintsWidgets
            r3.add(r5)
        L_0x010f:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r1.mFirstMatchConstraintWidget
            if (r3 != 0) goto L_0x0115
            r1.mFirstMatchConstraintWidget = r5
        L_0x0115:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r1.mLastMatchConstraintWidget
            if (r3 == 0) goto L_0x011f
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r3 = r3.mListNextMatchConstraintsWidget
            int r4 = r1.mOrientation
            r3[r4] = r5
        L_0x011f:
            r1.mLastMatchConstraintWidget = r5
        L_0x0121:
            int r3 = r1.mOrientation
        L_0x0123:
            if (r6 == r5) goto L_0x012b
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r3 = r6.mNextChainWidget
            int r4 = r1.mOrientation
            r3[r4] = r5
        L_0x012b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r5.mListAnchors
            int r4 = r2 + 1
            r3 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0147
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.mOwner
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r3.mListAnchors
            r6 = r4[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x0147
            r4 = r4[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.mOwner
            if (r4 == r5) goto L_0x0149
        L_0x0147:
            r3 = r17
        L_0x0149:
            if (r3 == 0) goto L_0x014c
            goto L_0x014e
        L_0x014c:
            r3 = r5
            r7 = 1
        L_0x014e:
            r6 = r5
            r4 = 1
            r8 = 8
            r12 = 2
            r5 = r3
            goto L_0x0030
        L_0x0156:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r1.mFirstVisibleWidget
            if (r3 == 0) goto L_0x0167
            int r4 = r1.mTotalSize
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r3.mListAnchors
            r3 = r3[r2]
            int r3 = r3.getMargin()
            int r4 = r4 - r3
            r1.mTotalSize = r4
        L_0x0167:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r1.mLastVisibleWidget
            if (r3 == 0) goto L_0x017a
            int r4 = r1.mTotalSize
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r3.mListAnchors
            int r2 = r2 + 1
            r2 = r3[r2]
            int r2 = r2.getMargin()
            int r4 = r4 - r2
            r1.mTotalSize = r4
        L_0x017a:
            r1.mLast = r5
            int r2 = r1.mOrientation
            if (r2 != 0) goto L_0x0187
            boolean r2 = r1.mIsRtl
            if (r2 == 0) goto L_0x0187
            r1.mHead = r5
            goto L_0x018b
        L_0x0187:
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r1.mFirst
            r1.mHead = r2
        L_0x018b:
            boolean r2 = r1.mHasDefinedWeights
            if (r2 == 0) goto L_0x0195
            boolean r2 = r1.mHasUndefinedWeights
            if (r2 == 0) goto L_0x0195
            r2 = 1
            goto L_0x0196
        L_0x0195:
            r2 = 0
        L_0x0196:
            r1.mHasComplexMatchWeights = r2
        L_0x0198:
            r2 = 1
            r1.mDefined = r2
            if (r11 == 0) goto L_0x01b0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r1.mFirst
            boolean r2 = r11.contains(r2)
            if (r2 == 0) goto L_0x01a6
            goto L_0x01b0
        L_0x01a6:
            r21 = r9
            r28 = r14
            r30 = r15
            r18 = 0
            goto L_0x07a3
        L_0x01b0:
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r1.mFirst
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = r1.mLast
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r1.mFirstVisibleWidget
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r1.mLastVisibleWidget
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r1.mHead
            float r3 = r1.mTotalWeight
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r39]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != r5) goto L_0x01c6
            r4 = 1
            goto L_0x01c7
        L_0x01c6:
            r4 = 0
        L_0x01c7:
            if (r39 != 0) goto L_0x01ed
            int r5 = r2.mHorizontalChainStyle
            if (r5 != 0) goto L_0x01cf
            r5 = 1
            goto L_0x01d0
        L_0x01cf:
            r5 = 0
        L_0x01d0:
            int r6 = r2.mHorizontalChainStyle
            r23 = r3
            r3 = 1
            if (r6 != r3) goto L_0x01d9
            r3 = 1
            goto L_0x01da
        L_0x01d9:
            r3 = 0
        L_0x01da:
            int r6 = r2.mHorizontalChainStyle
            r24 = r3
            r3 = 2
            if (r6 != r3) goto L_0x01e7
            r3 = r24
            r24 = r9
            r9 = 2
            goto L_0x020a
        L_0x01e7:
            r3 = r24
            r24 = r9
            r9 = 2
            goto L_0x0210
        L_0x01ed:
            r23 = r3
            int r3 = r2.mVerticalChainStyle
            if (r3 != 0) goto L_0x01f5
            r3 = 1
            goto L_0x01f6
        L_0x01f5:
            r3 = 0
        L_0x01f6:
            int r5 = r2.mVerticalChainStyle
            r6 = 1
            if (r5 != r6) goto L_0x01fd
            r5 = 1
            goto L_0x01fe
        L_0x01fd:
            r5 = 0
        L_0x01fe:
            int r6 = r2.mVerticalChainStyle
            r24 = r9
            r9 = 2
            r35 = r5
            r5 = r3
            r3 = r35
            if (r6 != r9) goto L_0x0210
        L_0x020a:
            r22 = r3
            r25 = r5
            r3 = 1
            goto L_0x0215
        L_0x0210:
            r22 = r3
            r25 = r5
            r3 = 0
        L_0x0215:
            r6 = r12
            r5 = 0
        L_0x0217:
            if (r5 != 0) goto L_0x02fb
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r9 = r6.mListAnchors
            r9 = r9[r16]
            if (r3 == 0) goto L_0x0222
            r27 = 1
            goto L_0x0224
        L_0x0222:
            r27 = 4
        L_0x0224:
            int r28 = r9.getMargin()
            r29 = r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r6.mListDimensionBehaviors
            r5 = r5[r39]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r11) goto L_0x023a
            int[] r5 = r6.mResolvedMatchConstraintDefault
            r5 = r5[r39]
            if (r5 != 0) goto L_0x023a
            r5 = 1
            goto L_0x023b
        L_0x023a:
            r5 = 0
        L_0x023b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r9.mTarget
            if (r11 == 0) goto L_0x0247
            if (r6 == r12) goto L_0x0247
            int r11 = r11.getMargin()
            int r28 = r11 + r28
        L_0x0247:
            r11 = r28
            if (r3 == 0) goto L_0x0254
            if (r6 == r12) goto L_0x0254
            if (r6 == r8) goto L_0x0254
            r28 = r14
            r27 = 8
            goto L_0x0256
        L_0x0254:
            r28 = r14
        L_0x0256:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r9.mTarget
            if (r14 == 0) goto L_0x0294
            if (r6 != r8) goto L_0x0269
            r30 = r15
            androidx.constraintlayout.core.SolverVariable r15 = r9.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r14 = r14.mSolverVariable
            r31 = r2
            r2 = 6
            r10.addGreaterThan(r15, r14, r11, r2)
            goto L_0x0276
        L_0x0269:
            r31 = r2
            r30 = r15
            androidx.constraintlayout.core.SolverVariable r2 = r9.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r14 = r14.mSolverVariable
            r15 = 8
            r10.addGreaterThan(r2, r14, r11, r15)
        L_0x0276:
            if (r5 == 0) goto L_0x027c
            if (r3 != 0) goto L_0x027c
            r27 = 5
        L_0x027c:
            if (r6 != r8) goto L_0x0288
            if (r3 == 0) goto L_0x0288
            boolean[] r2 = r6.mIsInBarrier
            boolean r2 = r2[r39]
            if (r2 == 0) goto L_0x0288
            r2 = 5
            goto L_0x028a
        L_0x0288:
            r2 = r27
        L_0x028a:
            androidx.constraintlayout.core.SolverVariable r5 = r9.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.mTarget
            androidx.constraintlayout.core.SolverVariable r9 = r9.mSolverVariable
            r10.addEquality(r5, r9, r11, r2)
            goto L_0x0298
        L_0x0294:
            r31 = r2
            r30 = r15
        L_0x0298:
            if (r4 == 0) goto L_0x02cc
            int r2 = r6.mVisibility
            r5 = 8
            if (r2 == r5) goto L_0x02ba
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r6.mListDimensionBehaviors
            r2 = r2[r39]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r5) goto L_0x02ba
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            int r5 = r16 + 1
            r5 = r2[r5]
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            r2 = r2[r16]
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            r9 = 5
            r11 = 0
            r10.addGreaterThan(r5, r2, r11, r9)
            goto L_0x02bb
        L_0x02ba:
            r11 = 0
        L_0x02bb:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            r2 = r2[r16]
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r0.mListAnchors
            r5 = r5[r16]
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            r9 = 8
            r10.addGreaterThan(r2, r5, r11, r9)
        L_0x02cc:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r6.mListAnchors
            int r5 = r16 + 1
            r2 = r2[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x02e8
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.mOwner
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r2.mListAnchors
            r9 = r5[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r9.mTarget
            if (r9 == 0) goto L_0x02e8
            r5 = r5[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.mOwner
            if (r5 == r6) goto L_0x02ea
        L_0x02e8:
            r2 = r17
        L_0x02ea:
            if (r2 == 0) goto L_0x02f0
            r6 = r2
            r5 = r29
            goto L_0x02f1
        L_0x02f0:
            r5 = 1
        L_0x02f1:
            r11 = r38
            r14 = r28
            r15 = r30
            r2 = r31
            goto L_0x0217
        L_0x02fb:
            r31 = r2
            r28 = r14
            r30 = r15
            if (r7 == 0) goto L_0x0364
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r5 = r16 + 1
            r2 = r2[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0364
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            r2 = r2[r5]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r7.mListDimensionBehaviors
            r6 = r6[r39]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L_0x0321
            int[] r6 = r7.mResolvedMatchConstraintDefault
            r6 = r6[r39]
            if (r6 != 0) goto L_0x0321
            r6 = 1
            goto L_0x0322
        L_0x0321:
            r6 = 0
        L_0x0322:
            if (r6 == 0) goto L_0x033a
            if (r3 != 0) goto L_0x033a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r2.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r6.mOwner
            if (r9 != r0) goto L_0x033a
            androidx.constraintlayout.core.SolverVariable r9 = r2.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            int r11 = r2.getMargin()
            int r11 = -r11
            r14 = 5
            r10.addEquality(r9, r6, r11, r14)
            goto L_0x0350
        L_0x033a:
            r14 = 5
            if (r3 == 0) goto L_0x0350
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r2.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r6.mOwner
            if (r9 != r0) goto L_0x0350
            androidx.constraintlayout.core.SolverVariable r9 = r2.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            int r11 = r2.getMargin()
            int r11 = -r11
            r15 = 4
            r10.addEquality(r9, r6, r11, r15)
        L_0x0350:
            androidx.constraintlayout.core.SolverVariable r6 = r2.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r9 = r13.mListAnchors
            r5 = r9[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            int r2 = r2.getMargin()
            int r2 = -r2
            r9 = 6
            r10.addLowerThan(r6, r5, r2, r9)
            goto L_0x0365
        L_0x0364:
            r14 = 5
        L_0x0365:
            if (r4 == 0) goto L_0x0380
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            int r4 = r16 + 1
            r2 = r2[r4]
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r13.mListAnchors
            r6 = r5[r4]
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            r4 = r5[r4]
            int r4 = r4.getMargin()
            r5 = 8
            r10.addGreaterThan(r2, r6, r4, r5)
        L_0x0380:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.mWeightedMatchConstraintsWidgets
            if (r2 == 0) goto L_0x049f
            int r4 = r2.size()
            r5 = 1
            if (r4 <= r5) goto L_0x049f
            boolean r6 = r1.mHasUndefinedWeights
            if (r6 == 0) goto L_0x0397
            boolean r6 = r1.mHasComplexMatchWeights
            if (r6 != 0) goto L_0x0397
            int r6 = r1.mWidgetsMatchCount
            float r6 = (float) r6
            goto L_0x0399
        L_0x0397:
            r6 = r23
        L_0x0399:
            r15 = r17
            r9 = 0
            r11 = 0
        L_0x039d:
            if (r11 >= r4) goto L_0x049f
            java.lang.Object r21 = r2.get(r11)
            r5 = r21
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            float[] r14 = r5.mWeight
            r14 = r14[r39]
            r19 = 0
            int r21 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r21 >= 0) goto L_0x03d4
            boolean r14 = r1.mHasComplexMatchWeights
            if (r14 == 0) goto L_0x03cc
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r5.mListAnchors
            int r5 = r16 + 1
            r5 = r0[r5]
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            r0 = r0[r16]
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            r21 = r2
            r2 = 0
            r14 = 4
            r10.addEquality(r5, r0, r2, r14)
            r14 = 0
            r26 = 4
            goto L_0x03ef
        L_0x03cc:
            r21 = r2
            r2 = 0
            r14 = 1065353216(0x3f800000, float:1.0)
            r26 = 4
            goto L_0x03d9
        L_0x03d4:
            r21 = r2
            r26 = 4
            r2 = 0
        L_0x03d9:
            int r27 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r27 != 0) goto L_0x03f9
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r5.mListAnchors
            int r2 = r16 + 1
            r2 = r0[r2]
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            r0 = r0[r16]
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            r5 = 8
            r14 = 0
            r10.addEquality(r2, r0, r14, r5)
        L_0x03ef:
            r33 = r1
            r32 = r4
            r19 = r13
            r18 = 0
            goto L_0x048f
        L_0x03f9:
            r18 = 0
            if (r15 == 0) goto L_0x0484
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            r15 = r2[r16]
            androidx.constraintlayout.core.SolverVariable r15 = r15.mSolverVariable
            int r29 = r16 + 1
            r2 = r2[r29]
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r5.mListAnchors
            r32 = r4
            r4 = r0[r16]
            androidx.constraintlayout.core.SolverVariable r4 = r4.mSolverVariable
            r0 = r0[r29]
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            r29 = r5
            androidx.constraintlayout.core.ArrayRow r5 = r37.createRow()
            r33 = r1
            r1 = 0
            r5.constantValue = r1
            r19 = r13
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r34 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r34 == 0) goto L_0x046a
            int r34 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r34 != 0) goto L_0x042d
            goto L_0x046a
        L_0x042d:
            int r34 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r34 != 0) goto L_0x043e
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r0 = r5.variables
            r4 = 1065353216(0x3f800000, float:1.0)
            r0.put(r15, r4)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r0 = r5.variables
            r0.put(r2, r13)
            goto L_0x0480
        L_0x043e:
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r27 != 0) goto L_0x044d
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r2 = r5.variables
            r2.put(r4, r1)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r1 = r5.variables
            r1.put(r0, r13)
            goto L_0x0480
        L_0x044d:
            float r9 = r9 / r6
            float r27 = r14 / r6
            float r9 = r9 / r27
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r13 = r5.variables
            r13.put(r15, r1)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r1 = r5.variables
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.put(r2, r13)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r1 = r5.variables
            r1.put(r0, r9)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r0 = r5.variables
            float r1 = -r9
            r0.put(r4, r1)
            goto L_0x0480
        L_0x046a:
            r1 = 1065353216(0x3f800000, float:1.0)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r9 = r5.variables
            r9.put(r15, r1)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r9 = r5.variables
            r9.put(r2, r13)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r2 = r5.variables
            r2.put(r0, r1)
            androidx.constraintlayout.core.ArrayRow$ArrayRowVariables r0 = r5.variables
            r0.put(r4, r13)
        L_0x0480:
            r10.addConstraint(r5)
            goto L_0x048c
        L_0x0484:
            r33 = r1
            r32 = r4
            r29 = r5
            r19 = r13
        L_0x048c:
            r9 = r14
            r15 = r29
        L_0x048f:
            int r11 = r11 + 1
            r5 = 1
            r14 = 5
            r0 = r36
            r13 = r19
            r2 = r21
            r4 = r32
            r1 = r33
            goto L_0x039d
        L_0x049f:
            r33 = r1
            r19 = r13
            r18 = 0
            r26 = 4
            if (r8 == 0) goto L_0x050b
            if (r8 == r7) goto L_0x04ad
            if (r3 == 0) goto L_0x050b
        L_0x04ad:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r16]
            r11 = r19
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            int r2 = r16 + 1
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x04c1
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            r3 = r0
            goto L_0x04c3
        L_0x04c1:
            r3 = r17
        L_0x04c3:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r1.mTarget
            if (r0 == 0) goto L_0x04cb
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            r6 = r0
            goto L_0x04cd
        L_0x04cb:
            r6 = r17
        L_0x04cd:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r8.mListAnchors
            r0 = r0[r16]
            if (r7 == 0) goto L_0x04d7
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r7.mListAnchors
            r1 = r1[r2]
        L_0x04d7:
            if (r3 == 0) goto L_0x0502
            if (r6 == 0) goto L_0x0502
            if (r39 != 0) goto L_0x04e2
            r2 = r31
            float r2 = r2.mHorizontalBiasPercent
            goto L_0x04e6
        L_0x04e2:
            r2 = r31
            float r2 = r2.mVerticalBiasPercent
        L_0x04e6:
            r5 = r2
            int r4 = r0.getMargin()
            int r9 = r1.getMargin()
            androidx.constraintlayout.core.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r0 = r1.mSolverVariable
            r12 = 7
            r1 = r37
            r13 = r7
            r7 = r0
            r0 = r8
            r8 = r9
            r14 = r24
            r15 = 2
            r9 = r12
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0507
        L_0x0502:
            r13 = r7
            r0 = r8
            r14 = r24
            r15 = 2
        L_0x0507:
            r21 = r14
            goto L_0x0741
        L_0x050b:
            r13 = r7
            r0 = r8
            r11 = r19
            r14 = r24
            r15 = 2
            if (r25 == 0) goto L_0x0613
            if (r0 == 0) goto L_0x0613
            r1 = r33
            int r2 = r1.mWidgetsMatchCount
            if (r2 <= 0) goto L_0x0523
            int r1 = r1.mWidgetsCount
            if (r1 != r2) goto L_0x0523
            r23 = 1
            goto L_0x0525
        L_0x0523:
            r23 = 0
        L_0x0525:
            r8 = r0
            r9 = r8
        L_0x0527:
            if (r9 == 0) goto L_0x0507
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r9.mNextChainWidget
            r1 = r1[r39]
            r7 = r1
        L_0x052e:
            if (r7 == 0) goto L_0x053b
            int r1 = r7.mVisibility
            r6 = 8
            if (r1 != r6) goto L_0x053d
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r7.mNextChainWidget
            r7 = r1[r39]
            goto L_0x052e
        L_0x053b:
            r6 = 8
        L_0x053d:
            if (r7 != 0) goto L_0x054c
            if (r9 != r13) goto L_0x0542
            goto L_0x054c
        L_0x0542:
            r20 = r7
            r19 = r8
            r15 = r9
            r21 = r14
            r14 = 5
            goto L_0x0602
        L_0x054c:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            r1 = r1[r16]
            androidx.constraintlayout.core.SolverVariable r2 = r1.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x0559
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            goto L_0x055b
        L_0x0559:
            r3 = r17
        L_0x055b:
            if (r8 == r9) goto L_0x0566
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r8.mListAnchors
            int r4 = r16 + 1
            r3 = r3[r4]
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0579
        L_0x0566:
            if (r9 != r0) goto L_0x0579
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r12.mListAnchors
            r4 = r3[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x0577
            r3 = r3[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0579
        L_0x0577:
            r3 = r17
        L_0x0579:
            int r1 = r1.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r9.mListAnchors
            int r5 = r16 + 1
            r4 = r4[r5]
            int r4 = r4.getMargin()
            if (r7 == 0) goto L_0x0590
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r7.mListAnchors
            r6 = r6[r16]
            androidx.constraintlayout.core.SolverVariable r15 = r6.mSolverVariable
            goto L_0x059a
        L_0x0590:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r11.mListAnchors
            r6 = r6[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x059d
            androidx.constraintlayout.core.SolverVariable r15 = r6.mSolverVariable
        L_0x059a:
            r19 = r7
            goto L_0x05a1
        L_0x059d:
            r19 = r7
            r15 = r17
        L_0x05a1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r9.mListAnchors
            r7 = r7[r5]
            androidx.constraintlayout.core.SolverVariable r7 = r7.mSolverVariable
            if (r6 == 0) goto L_0x05ae
            int r6 = r6.getMargin()
            int r4 = r4 + r6
        L_0x05ae:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r8.mListAnchors
            r6 = r6[r5]
            int r6 = r6.getMargin()
            int r6 = r6 + r1
            if (r2 == 0) goto L_0x05fa
            if (r3 == 0) goto L_0x05fa
            if (r15 == 0) goto L_0x05fa
            if (r7 == 0) goto L_0x05fa
            if (r9 != r0) goto L_0x05ca
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r0.mListAnchors
            r1 = r1[r16]
            int r1 = r1.getMargin()
            r6 = r1
        L_0x05ca:
            if (r9 != r13) goto L_0x05d7
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            r1 = r1[r5]
            int r1 = r1.getMargin()
            r21 = r1
            goto L_0x05d9
        L_0x05d7:
            r21 = r4
        L_0x05d9:
            if (r23 == 0) goto L_0x05de
            r24 = 8
            goto L_0x05e0
        L_0x05de:
            r24 = 5
        L_0x05e0:
            r5 = 1056964608(0x3f000000, float:0.5)
            r1 = r37
            r4 = r6
            r20 = 8
            r6 = r15
            r15 = r19
            r19 = r8
            r8 = r21
            r21 = r14
            r20 = r15
            r14 = 5
            r15 = r9
            r9 = r24
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0602
        L_0x05fa:
            r15 = r9
            r21 = r14
            r20 = r19
            r14 = 5
            r19 = r8
        L_0x0602:
            int r1 = r15.mVisibility
            r9 = 8
            if (r1 == r9) goto L_0x060a
            r8 = r15
            goto L_0x060c
        L_0x060a:
            r8 = r19
        L_0x060c:
            r9 = r20
            r14 = r21
            r15 = 2
            goto L_0x0527
        L_0x0613:
            r21 = r14
            r1 = r33
            r9 = 8
            r14 = 5
            if (r22 == 0) goto L_0x0741
            if (r0 == 0) goto L_0x0741
            int r2 = r1.mWidgetsMatchCount
            if (r2 <= 0) goto L_0x0629
            int r1 = r1.mWidgetsCount
            if (r1 != r2) goto L_0x0629
            r23 = 1
            goto L_0x062b
        L_0x0629:
            r23 = 0
        L_0x062b:
            r8 = r0
            r15 = r8
        L_0x062d:
            if (r15 == 0) goto L_0x06e7
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r15.mNextChainWidget
            r1 = r1[r39]
        L_0x0633:
            if (r1 == 0) goto L_0x063e
            int r2 = r1.mVisibility
            if (r2 != r9) goto L_0x063e
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r1.mNextChainWidget
            r1 = r1[r39]
            goto L_0x0633
        L_0x063e:
            if (r15 == r0) goto L_0x06cd
            if (r15 == r13) goto L_0x06cd
            if (r1 == 0) goto L_0x06cd
            if (r1 != r13) goto L_0x0649
            r7 = r17
            goto L_0x064a
        L_0x0649:
            r7 = r1
        L_0x064a:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r15.mListAnchors
            r1 = r1[r16]
            androidx.constraintlayout.core.SolverVariable r2 = r1.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r8.mListAnchors
            int r4 = r16 + 1
            r3 = r3[r4]
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            int r1 = r1.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r15.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            if (r7 == 0) goto L_0x0676
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r7.mListAnchors
            r6 = r6[r16]
            androidx.constraintlayout.core.SolverVariable r9 = r6.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r6.mTarget
            if (r14 == 0) goto L_0x0673
            androidx.constraintlayout.core.SolverVariable r14 = r14.mSolverVariable
            goto L_0x0687
        L_0x0673:
            r14 = r17
            goto L_0x0687
        L_0x0676:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r13.mListAnchors
            r6 = r6[r16]
            if (r6 == 0) goto L_0x067f
            androidx.constraintlayout.core.SolverVariable r9 = r6.mSolverVariable
            goto L_0x0681
        L_0x067f:
            r9 = r17
        L_0x0681:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r14 = r15.mListAnchors
            r14 = r14[r4]
            androidx.constraintlayout.core.SolverVariable r14 = r14.mSolverVariable
        L_0x0687:
            if (r6 == 0) goto L_0x0691
            int r6 = r6.getMargin()
            int r6 = r6 + r5
            r19 = r6
            goto L_0x0693
        L_0x0691:
            r19 = r5
        L_0x0693:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r4 = r5[r4]
            int r4 = r4.getMargin()
            int r4 = r4 + r1
            if (r23 == 0) goto L_0x06a1
            r20 = 8
            goto L_0x06a3
        L_0x06a1:
            r20 = 4
        L_0x06a3:
            if (r2 == 0) goto L_0x06c2
            if (r3 == 0) goto L_0x06c2
            if (r9 == 0) goto L_0x06c2
            if (r14 == 0) goto L_0x06c2
            r5 = 1056964608(0x3f000000, float:0.5)
            r1 = r37
            r6 = r9
            r24 = r7
            r7 = r14
            r14 = r8
            r8 = r19
            r26 = r14
            r14 = 8
            r19 = 4
            r9 = r20
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x06ca
        L_0x06c2:
            r24 = r7
            r26 = r8
            r14 = 8
            r19 = 4
        L_0x06ca:
            r8 = r24
            goto L_0x06d4
        L_0x06cd:
            r26 = r8
            r14 = 8
            r19 = 4
            r8 = r1
        L_0x06d4:
            int r1 = r15.mVisibility
            if (r1 == r14) goto L_0x06d9
            goto L_0x06db
        L_0x06d9:
            r15 = r26
        L_0x06db:
            r9 = 8
            r14 = 5
            r26 = 4
            r35 = r15
            r15 = r8
            r8 = r35
            goto L_0x062d
        L_0x06e7:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r0.mListAnchors
            r1 = r1[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            r2 = r2[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            int r4 = r16 + 1
            r12 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r3.mTarget
            if (r2 == 0) goto L_0x0730
            if (r0 == r13) goto L_0x070e
            androidx.constraintlayout.core.SolverVariable r3 = r1.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            int r1 = r1.getMargin()
            r4 = 5
            r10.addEquality(r3, r2, r1, r4)
            goto L_0x0730
        L_0x070e:
            if (r14 == 0) goto L_0x0730
            androidx.constraintlayout.core.SolverVariable r3 = r1.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r4 = r2.mSolverVariable
            int r5 = r1.getMargin()
            r6 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.core.SolverVariable r7 = r12.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r8 = r14.mSolverVariable
            int r9 = r12.getMargin()
            r15 = 5
            r1 = r37
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r15
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0730:
            if (r14 == 0) goto L_0x0741
            if (r0 == r13) goto L_0x0741
            androidx.constraintlayout.core.SolverVariable r1 = r12.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r14.mSolverVariable
            int r3 = r12.getMargin()
            int r3 = -r3
            r4 = 5
            r10.addEquality(r1, r2, r3, r4)
        L_0x0741:
            if (r25 != 0) goto L_0x0745
            if (r22 == 0) goto L_0x07a3
        L_0x0745:
            if (r0 == 0) goto L_0x07a3
            if (r0 == r13) goto L_0x07a3
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r0.mListAnchors
            r1 = r1[r16]
            if (r13 != 0) goto L_0x0751
            r8 = r0
            goto L_0x0752
        L_0x0751:
            r8 = r13
        L_0x0752:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r8.mListAnchors
            int r3 = r16 + 1
            r2 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x075f
            androidx.constraintlayout.core.SolverVariable r4 = r4.mSolverVariable
            goto L_0x0761
        L_0x075f:
            r4 = r17
        L_0x0761:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.mTarget
            if (r5 == 0) goto L_0x0768
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            goto L_0x076a
        L_0x0768:
            r5 = r17
        L_0x076a:
            if (r11 == r8) goto L_0x077b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r11.mListAnchors
            r5 = r5[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0778
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            r17 = r5
        L_0x0778:
            r6 = r17
            goto L_0x077c
        L_0x077b:
            r6 = r5
        L_0x077c:
            if (r0 != r8) goto L_0x0784
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            r1 = r0[r16]
            r2 = r0[r3]
        L_0x0784:
            if (r4 == 0) goto L_0x07a3
            if (r6 == 0) goto L_0x07a3
            r5 = 1056964608(0x3f000000, float:0.5)
            int r0 = r1.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r8.mListAnchors
            r3 = r7[r3]
            int r8 = r3.getMargin()
            androidx.constraintlayout.core.SolverVariable r3 = r1.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r7 = r2.mSolverVariable
            r9 = 5
            r1 = r37
            r2 = r3
            r3 = r4
            r4 = r0
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x07a3:
            int r9 = r21 + 1
            r12 = 2
            r0 = r36
            r11 = r38
            r14 = r28
            r15 = r30
            goto L_0x001b
        L_0x07b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.d.b.applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, java.util.ArrayList, int):void");
    }

    public static void buildShortClassTag(Object obj, StringBuilder sb) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0) {
            simpleName = obj.getClass().getName();
            int lastIndexOf = simpleName.lastIndexOf(46);
            if (lastIndexOf > 0) {
                simpleName = simpleName.substring(lastIndexOf + 1);
            }
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void c(int i) {
        f2412b = new d<>(i);
    }

    public static boolean canMorph(PathParser$PathDataNode[] pathParser$PathDataNodeArr, PathParser$PathDataNode[] pathParser$PathDataNodeArr2) {
        if (pathParser$PathDataNodeArr == null || pathParser$PathDataNodeArr2 == null || pathParser$PathDataNodeArr.length != pathParser$PathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            if (pathParser$PathDataNodeArr[i].mType != pathParser$PathDataNodeArr2[i].mType || pathParser$PathDataNodeArr[i].mParams.length != pathParser$PathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static int checkArgumentNonnegative(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static int checkSelfPermission(Context context, String str) {
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        String permissionToOp = AppOpsManagerCompat.permissionToOp(str);
        if (permissionToOp != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            if (AppOpsManagerCompat.noteProxyOpNoThrow(context, permissionToOp, packageName) != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static float clamp(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static void clearColorFilter(Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            clearColorFilter(((InsetDrawable) drawable).getDrawable());
        } else if (drawable instanceof WrappedDrawable) {
            clearColorFilter(((WrappedDrawable) drawable).getWrappedDrawable());
        } else if (drawable instanceof DrawableContainer) {
            DrawableContainerState drawableContainerState = (DrawableContainerState) ((DrawableContainer) drawable).getConstantState();
            if (drawableContainerState != null) {
                int childCount = drawableContainerState.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    Drawable child = drawableContainerState.getChild(i);
                    if (child != null) {
                        clearColorFilter(child);
                    }
                }
            }
        }
    }

    public static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i <= i2) {
            int length = fArr.length;
            if (i < 0 || i > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            float[] fArr2 = new float[i3];
            System.arraycopy(fArr, i, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0030 A[SYNTHETIC, Splitter:B:24:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0039 A[SYNTHETIC, Splitter:B:30:0x0039] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyToFile(java.io.File r5, java.io.InputStream r6) {
        /*
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskWrites()
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002a }
            r3.<init>(r5, r1)     // Catch:{ IOException -> 0x002a }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
        L_0x000f:
            int r2 = r6.read(r5)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            r4 = -1
            if (r2 == r4) goto L_0x001a
            r3.write(r5, r1, r2)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            goto L_0x000f
        L_0x001a:
            r5 = 1
            r3.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            android.os.StrictMode.setThreadPolicy(r0)
            return r5
        L_0x0022:
            r5 = move-exception
            r2 = r3
            goto L_0x0037
        L_0x0025:
            r5 = move-exception
            r2 = r3
            goto L_0x002b
        L_0x0028:
            r5 = move-exception
            goto L_0x0037
        L_0x002a:
            r5 = move-exception
        L_0x002b:
            r5.getMessage()     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            android.os.StrictMode.setThreadPolicy(r0)
            return r1
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            r2.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            android.os.StrictMode.setThreadPolicy(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.d.b.copyToFile(java.io.File, java.io.InputStream):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008b, code lost:
        if (r13 == false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008d, code lost:
        r11 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0098 A[Catch:{ NumberFormatException -> 0x00ba }, LOOP:3: B:26:0x006d->B:46:0x0098, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0097 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.graphics.PathParser$PathDataNode[] createNodesFromPathData(java.lang.String r16) {
        /*
            r0 = r16
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            r3 = 1
            r4 = 0
        L_0x000e:
            int r5 = r16.length()
            if (r3 >= r5) goto L_0x00df
        L_0x0014:
            int r5 = r16.length()
            r6 = 69
            r7 = 101(0x65, float:1.42E-43)
            if (r3 >= r5) goto L_0x003a
            char r5 = r0.charAt(r3)
            int r8 = r5 + -65
            int r9 = r5 + -90
            int r9 = r9 * r8
            if (r9 <= 0) goto L_0x0032
            int r8 = r5 + -97
            int r9 = r5 + -122
            int r9 = r9 * r8
            if (r9 > 0) goto L_0x0037
        L_0x0032:
            if (r5 == r7) goto L_0x0037
            if (r5 == r6) goto L_0x0037
            goto L_0x003a
        L_0x0037:
            int r3 = r3 + 1
            goto L_0x0014
        L_0x003a:
            java.lang.String r4 = r0.substring(r4, r3)
            java.lang.String r4 = r4.trim()
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x00d7
            char r5 = r4.charAt(r2)
            r8 = 122(0x7a, float:1.71E-43)
            if (r5 == r8) goto L_0x00c9
            char r5 = r4.charAt(r2)
            r8 = 90
            if (r5 != r8) goto L_0x005a
            goto L_0x00c9
        L_0x005a:
            int r5 = r4.length()     // Catch:{ NumberFormatException -> 0x00ba }
            float[] r5 = new float[r5]     // Catch:{ NumberFormatException -> 0x00ba }
            int r8 = r4.length()     // Catch:{ NumberFormatException -> 0x00ba }
            r9 = 1
            r10 = 0
        L_0x0066:
            if (r9 >= r8) goto L_0x00b2
            r2 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = r9
        L_0x006d:
            int r15 = r4.length()     // Catch:{ NumberFormatException -> 0x00ba }
            if (r14 >= r15) goto L_0x009b
            char r15 = r4.charAt(r14)     // Catch:{ NumberFormatException -> 0x00ba }
            r7 = 32
            if (r15 == r7) goto L_0x0091
            r7 = 101(0x65, float:1.42E-43)
            if (r15 == r6) goto L_0x008f
            if (r15 == r7) goto L_0x008f
            switch(r15) {
                case 44: goto L_0x0093;
                case 45: goto L_0x0089;
                case 46: goto L_0x0085;
                default: goto L_0x0084;
            }     // Catch:{ NumberFormatException -> 0x00ba }
        L_0x0084:
            goto L_0x0094
        L_0x0085:
            if (r12 != 0) goto L_0x008d
            r12 = 1
            goto L_0x0094
        L_0x0089:
            if (r14 == r9) goto L_0x0094
            if (r13 != 0) goto L_0x0094
        L_0x008d:
            r11 = 1
            goto L_0x0093
        L_0x008f:
            r13 = 1
            goto L_0x0095
        L_0x0091:
            r7 = 101(0x65, float:1.42E-43)
        L_0x0093:
            r2 = 1
        L_0x0094:
            r13 = 0
        L_0x0095:
            if (r2 == 0) goto L_0x0098
            goto L_0x009b
        L_0x0098:
            int r14 = r14 + 1
            goto L_0x006d
        L_0x009b:
            if (r9 >= r14) goto L_0x00aa
            int r2 = r10 + 1
            java.lang.String r9 = r4.substring(r9, r14)     // Catch:{ NumberFormatException -> 0x00ba }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x00ba }
            r5[r10] = r9     // Catch:{ NumberFormatException -> 0x00ba }
            r10 = r2
        L_0x00aa:
            if (r11 == 0) goto L_0x00ad
            goto L_0x00af
        L_0x00ad:
            int r14 = r14 + 1
        L_0x00af:
            r9 = r14
            r2 = 0
            goto L_0x0066
        L_0x00b2:
            float[] r2 = copyOfRange(r5, r2, r10)     // Catch:{ NumberFormatException -> 0x00ba }
            r5 = 0
            r5 = r2
            r2 = 0
            goto L_0x00cb
        L_0x00ba:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "error in parsing \""
            java.lang.String r3 = "\""
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r2, r4, r3)
            r1.<init>(r2, r0)
            throw r1
        L_0x00c9:
            float[] r5 = new float[r2]
        L_0x00cb:
            char r2 = r4.charAt(r2)
            androidx.core.graphics.PathParser$PathDataNode r4 = new androidx.core.graphics.PathParser$PathDataNode
            r4.<init>(r2, r5)
            r1.add(r4)
        L_0x00d7:
            int r2 = r3 + 1
            r4 = 0
            r4 = r3
            r3 = r2
            r2 = 0
            goto L_0x000e
        L_0x00df:
            int r3 = r3 - r4
            r2 = 1
            if (r3 != r2) goto L_0x00f8
            int r2 = r16.length()
            if (r4 >= r2) goto L_0x00f8
            char r0 = r0.charAt(r4)
            r2 = 0
            float[] r2 = new float[r2]
            androidx.core.graphics.PathParser$PathDataNode r3 = new androidx.core.graphics.PathParser$PathDataNode
            r3.<init>(r0, r2)
            r1.add(r3)
        L_0x00f8:
            int r0 = r1.size()
            androidx.core.graphics.PathParser$PathDataNode[] r0 = new androidx.core.graphics.PathParser$PathDataNode[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            androidx.core.graphics.PathParser$PathDataNode[] r0 = (androidx.core.graphics.PathParser$PathDataNode[]) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.d.b.createNodesFromPathData(java.lang.String):androidx.core.graphics.PathParser$PathDataNode[]");
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathParser$PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData == null) {
            return null;
        }
        try {
            PathParser$PathDataNode.nodesToPath(createNodesFromPathData, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException(GeneratedOutlineSupport.outline50("Error in parsing ", str), e2);
        }
    }

    public static PathParser$PathDataNode[] deepCopyNodes(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
        if (pathParser$PathDataNodeArr == null) {
            return null;
        }
        PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = new PathParser$PathDataNode[pathParser$PathDataNodeArr.length];
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            pathParser$PathDataNodeArr2[i] = new PathParser$PathDataNode(pathParser$PathDataNodeArr[i]);
        }
        return pathParser$PathDataNodeArr2;
    }

    public static void ensureBundleContains(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Bundle must contain ", str));
        }
    }

    public static WidgetGroup findDependents(ConstraintWidget constraintWidget, int i, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        int i2;
        int i3;
        if (i == 0) {
            i2 = constraintWidget.horizontalGroup;
        } else {
            i2 = constraintWidget.verticalGroup;
        }
        int i4 = 0;
        if (i2 != -1 && (widgetGroup == null || i2 != widgetGroup.id)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                WidgetGroup widgetGroup2 = arrayList.get(i5);
                if (widgetGroup2.id == i2) {
                    if (widgetGroup != null) {
                        widgetGroup.moveTo(i, widgetGroup2);
                        arrayList.remove(widgetGroup);
                    }
                    widgetGroup = widgetGroup2;
                } else {
                    i5++;
                }
            }
        } else if (i2 != -1) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            if (constraintWidget instanceof HelperWidget) {
                HelperWidget helperWidget = (HelperWidget) constraintWidget;
                int i6 = 0;
                while (true) {
                    if (i6 >= helperWidget.mWidgetsCount) {
                        i3 = -1;
                        break;
                    }
                    ConstraintWidget constraintWidget2 = helperWidget.mWidgets[i6];
                    if (i == 0) {
                        i3 = constraintWidget2.horizontalGroup;
                        if (i3 != -1) {
                            break;
                        }
                    }
                    if (i == 1) {
                        i3 = constraintWidget2.verticalGroup;
                        if (i3 != -1) {
                            break;
                        }
                    }
                    i6++;
                }
                if (i3 != -1) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= arrayList.size()) {
                            break;
                        }
                        WidgetGroup widgetGroup3 = arrayList.get(i7);
                        if (widgetGroup3.id == i3) {
                            widgetGroup = widgetGroup3;
                            break;
                        }
                        i7++;
                    }
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new WidgetGroup(i);
            }
            arrayList.add(widgetGroup);
        }
        if (widgetGroup.add(constraintWidget)) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                ConstraintAnchor constraintAnchor = guideline.mAnchor;
                if (guideline.mOrientation == 0) {
                    i4 = 1;
                }
                constraintAnchor.findDependents(i4, arrayList, widgetGroup);
            }
            if (i == 0) {
                constraintWidget.horizontalGroup = widgetGroup.id;
                constraintWidget.mLeft.findDependents(i, arrayList, widgetGroup);
                constraintWidget.mRight.findDependents(i, arrayList, widgetGroup);
            } else {
                constraintWidget.verticalGroup = widgetGroup.id;
                constraintWidget.mTop.findDependents(i, arrayList, widgetGroup);
                constraintWidget.mBaseline.findDependents(i, arrayList, widgetGroup);
                constraintWidget.mBottom.findDependents(i, arrayList, widgetGroup);
            }
            constraintWidget.mCenter.findDependents(i, arrayList, widgetGroup);
        }
        return widgetGroup;
    }

    public static WidgetGroup findGroup(ArrayList<WidgetGroup> arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            WidgetGroup widgetGroup = arrayList.get(i2);
            if (i == widgetGroup.id) {
                return widgetGroup;
            }
        }
        return null;
    }

    public static void flushThemedResourcesCache(Object obj) {
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            sThemedResourceCacheClazzFetched = true;
        }
        Class<?> cls = sThemedResourceCacheClazz;
        if (cls != null) {
            if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    sThemedResourceCache_mUnthemedEntriesField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused2) {
                }
                sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
            }
            Field field = sThemedResourceCache_mUnthemedEntriesField;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException unused3) {
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }

    public static void g() {
        c(165);
        Random random = new Random();
        f2415e = random.nextInt(8);
        f2416f = random.nextInt(8);
        f2412b.a("table", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "table3.png", f2411a)));
        f2412b.a("table_background", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "img_theme2.png", f2411a)));
        f2412b.a("message1", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "message1.png", f2411a)));
        f2412b.a("message4", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "message4.png", f2411a)));
        f2412b.a("table_bar", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "table_bar2.png", f2411a)));
        f2412b.a("mtt_selected", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "mtt_selected.png", f2411a)));
        f2412b.a("mtt_unselected", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "mtt_unselected.png", f2411a)));
        f2412b.a("mtt_blink", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "mtt_blink.png", f2411a)));
        f2412b.a("mtt_add_table", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "mtt_add_table.png", f2411a)));
        f2412b.a("round_counter", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "round_counter_trump.png", f2411a)));
        f2412b.a("suit_spade_sprite_sheet", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_spade_sprite_sheet.png", f2411a)));
        f2412b.a("suit_club_sprite_sheet", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_club_sprite_sheet.png", f2411a)));
        f2412b.a("suit_heart_sprite_sheet", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_heart_sprite_sheet.png", f2411a)));
        f2412b.a("suit_diamond_sprite_sheet", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_diamond_sprite_sheet.png", f2411a)));
        f2412b.a("scoreboard_round1", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "scoreboard_round1.png", f2411a)));
        f2412b.a("scoreboard_round_over", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "scoreboard_round_over.png", f2411a)));
        f2412b.a("scoreboard_round3", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "scoreboard_round3.png", f2411a)));
        f2412b.a("scoreboard_round5", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "scoreboard_round5.png", f2411a)));
        f2412b.a("tableinfo", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "tableinfo4.png", f2411a)));
        f2412b.a("close", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "close.png", f2411a)));
        f2412b.a("stars", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "won.png", f2411a)));
        f2412b.a("lose", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "lose.png", f2411a)));
        f2412b.a("winner_ribbon", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "winner_ribbon.png", f2411a)));
        f2412b.a("glow7", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "glow7.png", f2411a)));
        f2412b.a("glow8", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "glow8.png", f2411a)));
        d<String, Texture> dVar = f2412b;
        a aVar = f2411a;
        dVar.a("pp1", new Texture(aVar.a(com.cfg.utilities.d.f2375a + com.cfg.utilities.d.f2376b[f2415e])));
        d<String, Texture> dVar2 = f2412b;
        a aVar2 = f2411a;
        dVar2.a("pp2", new Texture(aVar2.a(com.cfg.utilities.d.f2375a + com.cfg.utilities.d.f2377c[f2415e])));
        d<String, Texture> dVar3 = f2412b;
        a aVar3 = f2411a;
        dVar3.a("pp3", new Texture(aVar3.a(com.cfg.utilities.d.f2375a + com.cfg.utilities.d.f2376b[f2416f])));
        d<String, Texture> dVar4 = f2412b;
        a aVar4 = f2411a;
        dVar4.a("pp4", new Texture(aVar4.a(com.cfg.utilities.d.f2375a + com.cfg.utilities.d.f2377c[f2416f])));
        f2412b.a("open_card_background", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "open_card_background.png", f2411a)));
        f2412b.a("valid_card", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "valid_card7.png", f2411a)));
        f2412b.a("invalid_card", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "invalid_card.png", f2411a)));
        f2412b.a("label_name1", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "name_box1.png", f2411a)));
        f2412b.a("label_name2", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "name_box2.png", f2411a)));
        f2412b.a("label_bid", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "label_bid.png", f2411a)));
        f2412b.a("ic_circle", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "ic_circle.png", f2411a)));
        f2412b.a("label_bidding", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "label_bidding.png", f2411a)));
        f2412b.a("bid_popup_header", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "bid_popup_header3.png", f2411a)));
        f2412b.a("bid_popup_background", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "bid_popup_background2.png", f2411a)));
        f2412b.a("bid_value", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "bid_value.png", f2411a)));
        f2412b.a("bid_value_down", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "bid_value_down.png", f2411a)));
        f2412b.a("leave_table_background", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "leave_table_background3.png", f2411a)));
        f2412b.a("leave_table_header", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "leave_table_header.png", f2411a)));
        f2412b.a("leave_table_leave1", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "leave_table_leave1.png", f2411a)));
        f2412b.a("leave_table_leave1_down", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "leave_table_leave1_down.png", f2411a)));
        f2412b.a("leave_table_cancel", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "leave_table_cancel1.png", f2411a)));
        f2412b.a("leave_table_cancel1_down", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "leave_table_cancel1_down.png", f2411a)));
        f2412b.a("leave_table", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "leave_table.png", f2411a)));
        f2412b.a("leave_table_down", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "leave_table_down.png", f2411a)));
        f2412b.a("info_icon", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "info_icon.png", f2411a)));
        f2412b.a("info_icon_down", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "info_icon_down.png", f2411a)));
        f2412b.a("table_refresh", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "table_refresh5.png", f2411a)));
        f2412b.a("table_refresh_down", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "table_refresh_down5.png", f2411a)));
        f2412b.a("score_icon1", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "score_icon1.png", f2411a)));
        f2412b.a("score_icon_down1", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "score_icon_down1.png", f2411a)));
        f2412b.a("volume_control_on", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "volume_control_on.png", f2411a)));
        f2412b.a("volume_control_off", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "volume_control_off.png", f2411a)));
        f2412b.a("vibration_control_on", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "vibration_control_on.png", f2411a)));
        f2412b.a("vibration_control_off", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "vibration_control_off.png", f2411a)));
        f2412b.a("suit_club", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_club.png", f2411a)));
        f2412b.a("suit_club_green", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_club_green.png", f2411a)));
        f2412b.a("suit_heart", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_heart.png", f2411a)));
        f2412b.a("suit_diamond", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_diamond.png", f2411a)));
        f2412b.a("suit_diamond_blue", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_diamond_blue.png", f2411a)));
        f2412b.a("suit_spade", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_spade.png", f2411a)));
        f2412b.a("spade_enable", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "spade_enable.png", f2411a)));
        f2412b.a("heart_enable", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "heart_enable.png", f2411a)));
        f2412b.a("diamond_enable", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "diamond_enable.png", f2411a)));
        f2412b.a("club_enable", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "club_enable.png", f2411a)));
        f2412b.a("spade_disable", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "spade_disable.png", f2411a)));
        f2412b.a("heart_disable", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "heart_disable.png", f2411a)));
        f2412b.a("diamond_disable", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "diamond_disable.png", f2411a)));
        f2412b.a("club_disable", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "club_disable.png", f2411a)));
        f2412b.a("suit_club_grey", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_club_grey.png", f2411a)));
        f2412b.a("suit_diamond_grey", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_diamond_grey.png", f2411a)));
        f2412b.a("suit_heart_grey", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_heart_grey.png", f2411a)));
        f2412b.a("suit_spade_grey", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_spade_grey.png", f2411a)));
        f2412b.a("suit_club_grey3", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_club_grey3.png", f2411a)));
        f2412b.a("suit_diamond_grey2", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_diamond_grey2.png", f2411a)));
        f2412b.a("suit_heart_grey2", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_heart_grey2.png", f2411a)));
        f2412b.a("suit_spade_grey2", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_spade_grey2.png", f2411a)));
        f2412b.a("suit_club_grey1", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_club_grey1.png", f2411a)));
        f2412b.a("suit_diamond_grey1", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_diamond_grey1.png", f2411a)));
        f2412b.a("suit_heart_grey1", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_heart_grey1.png", f2411a)));
        f2412b.a("suit_spade_grey1", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "suit_spade_grey1.png", f2411a)));
        f2412b.a("rounds_container_green", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "rounds_container_green.png", f2411a)));
        f2412b.a("rounds_container_red", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "rounds_container_red.png", f2411a)));
        f2412b.a("red_2", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_2.png", f2411a)));
        f2412b.a("red_3", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_3.png", f2411a)));
        f2412b.a("red_4", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_4.png", f2411a)));
        f2412b.a("red_5", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_5.png", f2411a)));
        f2412b.a("red_6", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_6.png", f2411a)));
        f2412b.a("red_7", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_7.png", f2411a)));
        f2412b.a("red_8", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_8.png", f2411a)));
        f2412b.a("red_9", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_9.png", f2411a)));
        f2412b.a("red_T", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_T.png", f2411a)));
        f2412b.a("red_J", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_J.png", f2411a)));
        f2412b.a("red_Q", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_Q.png", f2411a)));
        f2412b.a("red_K", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_K.png", f2411a)));
        f2412b.a("red_A", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "red_A.png", f2411a)));
        f2412b.a("green_2", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_2.png", f2411a)));
        f2412b.a("green_3", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_3.png", f2411a)));
        f2412b.a("green_4", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_4.png", f2411a)));
        f2412b.a("green_5", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_5.png", f2411a)));
        f2412b.a("green_6", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_6.png", f2411a)));
        f2412b.a("green_7", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_7.png", f2411a)));
        f2412b.a("green_8", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_8.png", f2411a)));
        f2412b.a("green_9", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_9.png", f2411a)));
        f2412b.a("green_T", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_T.png", f2411a)));
        f2412b.a("green_J", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_J.png", f2411a)));
        f2412b.a("green_Q", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_Q.png", f2411a)));
        f2412b.a("green_K", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_K.png", f2411a)));
        f2412b.a("green_A", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "green_A.png", f2411a)));
        f2412b.a("black_2", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_2.png", f2411a)));
        f2412b.a("black_3", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_3.png", f2411a)));
        f2412b.a("black_4", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_4.png", f2411a)));
        f2412b.a("black_5", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_5.png", f2411a)));
        f2412b.a("black_6", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_6.png", f2411a)));
        f2412b.a("black_7", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_7.png", f2411a)));
        f2412b.a("black_8", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_8.png", f2411a)));
        f2412b.a("black_9", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_9.png", f2411a)));
        f2412b.a("black_T", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_T.png", f2411a)));
        f2412b.a("black_J", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_J.png", f2411a)));
        f2412b.a("black_Q", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_Q.png", f2411a)));
        f2412b.a("black_K", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_K.png", f2411a)));
        f2412b.a("black_A", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "black_A.png", f2411a)));
        f2412b.a("blue_2", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_2.png", f2411a)));
        f2412b.a("blue_3", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_3.png", f2411a)));
        f2412b.a("blue_4", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_4.png", f2411a)));
        f2412b.a("blue_5", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_5.png", f2411a)));
        f2412b.a("blue_6", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_6.png", f2411a)));
        f2412b.a("blue_7", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_7.png", f2411a)));
        f2412b.a("blue_8", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_8.png", f2411a)));
        f2412b.a("blue_9", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_9.png", f2411a)));
        f2412b.a("blue_T", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_T.png", f2411a)));
        f2412b.a("blue_J", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_J.png", f2411a)));
        f2412b.a("blue_Q", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_Q.png", f2411a)));
        f2412b.a("blue_K", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_K.png", f2411a)));
        f2412b.a("blue_A", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "blue_A.png", f2411a)));
        f2412b.a("grey_2", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_2.png", f2411a)));
        f2412b.a("grey_3", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_3.png", f2411a)));
        f2412b.a("grey_4", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_4.png", f2411a)));
        f2412b.a("grey_5", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_5.png", f2411a)));
        f2412b.a("grey_6", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_6.png", f2411a)));
        f2412b.a("grey_7", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_7.png", f2411a)));
        f2412b.a("grey_8", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_8.png", f2411a)));
        f2412b.a("grey_9", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_9.png", f2411a)));
        f2412b.a("grey_T", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_T.png", f2411a)));
        f2412b.a("grey_J", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_J.png", f2411a)));
        f2412b.a("grey_Q", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_Q.png", f2411a)));
        f2412b.a("grey_K", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_K.png", f2411a)));
        f2412b.a("grey_A", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "grey_A.png", f2411a)));
        f2412b.a("emoji_icon_up", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji_icon_up.png", f2411a)));
        f2412b.a("emoji_icon_down", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji_icon_down.png", f2411a)));
        f2412b.a("emoji_popup", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "emoji_popup7.png", f2411a)));
        f2412b.a("emoji1", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "i_emoji1.png", f2411a)));
        f2412b.a("emoji2", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "i_emoji2.png", f2411a)));
        f2412b.a("emoji3", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "i_emoji3.png", f2411a)));
        f2412b.a("emoji4", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "i_emoji4.png", f2411a)));
        f2412b.a("emoji5", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "i_emoji5.png", f2411a)));
        f2412b.a("emoji6", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "i_emoji6.png", f2411a)));
        f2412b.a("emoji7", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "i_emoji7.png", f2411a)));
        f2412b.a("emoji8", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "i_emoji8.png", f2411a)));
        f2412b.a("emoji9", new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), com.cfg.utilities.d.f2375a, "i_emoji9.png", f2411a)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        if ((r7.getApplicationInfo(r4.packageName, 0).flags & 1) != 0) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<android.content.pm.ServiceInfo> getAdvertisingIdProviderServices(android.content.pm.PackageManager r7) {
        /*
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "androidx.ads.identifier.provider.GET_AD_ID"
            r0.<init>(r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 0
            r3 = 24
            if (r1 < r3) goto L_0x0011
            r1 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            java.util.List r0 = r7.queryIntentServices(r0, r1)
            if (r0 == 0) goto L_0x004f
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x001f
            goto L_0x004f
        L_0x001f:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0028:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x004e
            java.lang.Object r4 = r0.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ServiceInfo r4 = r4.serviceInfo
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 >= r3) goto L_0x004a
            java.lang.String r5 = r4.packageName
            r6 = 1
            android.content.pm.ApplicationInfo r5 = r7.getApplicationInfo(r5, r2)     // Catch:{ NameNotFoundException -> 0x0047 }
            int r5 = r5.flags     // Catch:{ NameNotFoundException -> 0x0047 }
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r6 = 0
        L_0x0048:
            if (r6 == 0) goto L_0x0028
        L_0x004a:
            r1.add(r4)
            goto L_0x0028
        L_0x004e:
            return r1
        L_0x004f:
            java.util.List r7 = java.util.Collections.emptyList()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.d.b.getAdvertisingIdProviderServices(android.content.pm.PackageManager):java.util.List");
    }

    public static int getAttr(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? i : i2;
    }

    public static boolean getBoolean(TypedArray typedArray, int i, int i2, boolean z) {
        return typedArray.getBoolean(i, typedArray.getBoolean(i2, z));
    }

    public static int getLayoutDirection(Drawable drawable) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (!sGetLayoutDirectionMethodFetched) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                sGetLayoutDirectionMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            sGetLayoutDirectionMethodFetched = true;
        }
        Method method = sGetLayoutDirectionMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception unused2) {
                sGetLayoutDirectionMethod = null;
            }
        }
        return 0;
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(".(");
        outline73.append(stackTraceElement.getFileName());
        outline73.append(":");
        outline73.append(stackTraceElement.getLineNumber());
        outline73.append(") ");
        outline73.append(stackTraceElement.getMethodName());
        outline73.append("()");
        return outline73.toString();
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(".(");
        outline73.append(stackTraceElement.getFileName());
        outline73.append(":");
        outline73.append(stackTraceElement.getLineNumber());
        outline73.append(")");
        return outline73.toString();
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static boolean getNamedBoolean(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        if (!hasAttribute(xmlPullParser, str)) {
            return z;
        }
        return typedArray.getBoolean(i, z);
    }

    public static int getNamedColor(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getColor(i, i2);
    }

    public static ComplexColorCompat getNamedComplexColor(TypedArray typedArray, XmlPullParser xmlPullParser, Theme theme, String str, int i, int i2) {
        ComplexColorCompat complexColorCompat;
        if (hasAttribute(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i3 = typedValue.type;
            if (i3 >= 28 && i3 <= 31) {
                return new ComplexColorCompat(null, null, typedValue.data);
            }
            try {
                complexColorCompat = ComplexColorCompat.createFromXml(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            } catch (Exception unused) {
                complexColorCompat = null;
            }
            if (complexColorCompat != null) {
                return complexColorCompat;
            }
        }
        return new ComplexColorCompat(null, null, i2);
    }

    public static float getNamedFloat(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f2) {
        if (!hasAttribute(xmlPullParser, str)) {
            return f2;
        }
        return typedArray.getFloat(i, f2);
    }

    public static int getNamedInt(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getInt(i, i2);
    }

    public static int getNamedResourceId(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        if (!hasAttribute(xmlPullParser, str)) {
            return i2;
        }
        return typedArray.getResourceId(i, i2);
    }

    public static String getNamedString(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i);
    }

    public static int getResourceId(TypedArray typedArray, int i, int i2, int i3) {
        return typedArray.getResourceId(i, typedArray.getResourceId(i2, i3));
    }

    public static String getState(MotionLayout motionLayout, int i) {
        if (i == -1) {
            return "UNDEFINED";
        }
        return motionLayout.getContext().getResources().getResourceEntryName(i);
    }

    public static String getString(TypedArray typedArray, int i, int i2) {
        String string = typedArray.getString(i);
        return string == null ? typedArray.getString(i2) : string;
    }

    public static File getTempFile(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(".font");
        outline73.append(Process.myPid());
        outline73.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        outline73.append(Process.myTid());
        outline73.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        String sb = outline73.toString();
        int i = 0;
        while (i < 100) {
            File file = new File(cacheDir, GeneratedOutlineSupport.outline41(sb, i));
            try {
                if (file.createNewFile()) {
                    return file;
                }
                i++;
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public static CharSequence[] getTextArray(TypedArray typedArray, int i, int i2) {
        CharSequence[] textArray = typedArray.getTextArray(i);
        return textArray == null ? typedArray.getTextArray(i2) : textArray;
    }

    public static boolean hasAttribute(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static boolean isChannelEnabled(NotificationManager notificationManager, String str) {
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
        return notificationChannel == null || notificationChannel.getImportance() != 0;
    }

    public static boolean isRequestHighPriority(PackageInfo packageInfo) {
        String[] strArr = packageInfo.requestedPermissions;
        if (strArr == null) {
            return false;
        }
        for (String equals : strArr) {
            if ("androidx.ads.identifier.provider.HIGH_PRIORITY".equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUserUnlocked(Context context) {
        if (VERSION.SDK_INT >= 24) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
        return true;
    }

    public static ByteBuffer mmap(Context context, CancellationSignal cancellationSignal, Uri uri) {
        FileInputStream fileInputStream;
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(MapMode.READ_ONLY, 0, channel.size());
                fileInputStream.close();
                openFileDescriptor.close();
                return map;
            } catch (Throwable th) {
                openFileDescriptor.close();
                throw th;
            }
            throw th;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    public static TypedArray obtainAttributes(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                } else if (parent instanceof WithHint) {
                    editorInfo.hintText = ((WithHint) parent).getHint();
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
        }
        return inputConnection;
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        try {
            return viewParent.onNestedFling(view, f2, f3, z);
        } catch (AbstractMethodError unused) {
            "ViewParent " + viewParent + " does not implement interface method onNestedFling";
            return false;
        }
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f2, float f3) {
        try {
            return viewParent.onNestedPreFling(view, f2, f3);
        } catch (AbstractMethodError unused) {
            "ViewParent " + viewParent + " does not implement interface method onNestedPreFling";
            return false;
        }
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (AbstractMethodError unused) {
                "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll";
            }
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewParent viewParent2 = viewParent;
        if (viewParent2 instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent2).onNestedScroll(view, i, i2, i3, i4, i5, iArr);
            return;
        }
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        if (viewParent2 instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent2).onNestedScroll(view, i, i2, i3, i4, i5);
        } else if (i5 == 0) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (AbstractMethodError unused) {
                "ViewParent " + viewParent + " does not implement interface method onNestedScroll";
            }
        }
    }

    public static FontResourcesParserCompat$FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Resources resources2 = resources;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlPullParser.require(2, null, "font-family");
            if (xmlPullParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources2.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
                String string = obtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
                String string2 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
                String string3 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
                int resourceId = obtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
                int integer = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
                int integer2 = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
                String string4 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderSystemFontFamily);
                obtainAttributes.recycle();
                if (string == null || string2 == null || string3 == null) {
                    ArrayList arrayList = new ArrayList();
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("font")) {
                                TypedArray obtainAttributes2 = resources2.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
                                if (obtainAttributes2.hasValue(R$styleable.FontFamilyFont_fontWeight)) {
                                    i = R$styleable.FontFamilyFont_fontWeight;
                                } else {
                                    i = R$styleable.FontFamilyFont_android_fontWeight;
                                }
                                int i6 = obtainAttributes2.getInt(i, 400);
                                if (obtainAttributes2.hasValue(R$styleable.FontFamilyFont_fontStyle)) {
                                    i2 = R$styleable.FontFamilyFont_fontStyle;
                                } else {
                                    i2 = R$styleable.FontFamilyFont_android_fontStyle;
                                }
                                boolean z = 1 == obtainAttributes2.getInt(i2, 0);
                                if (obtainAttributes2.hasValue(R$styleable.FontFamilyFont_ttcIndex)) {
                                    i3 = R$styleable.FontFamilyFont_ttcIndex;
                                } else {
                                    i3 = R$styleable.FontFamilyFont_android_ttcIndex;
                                }
                                if (obtainAttributes2.hasValue(R$styleable.FontFamilyFont_fontVariationSettings)) {
                                    i4 = R$styleable.FontFamilyFont_fontVariationSettings;
                                } else {
                                    i4 = R$styleable.FontFamilyFont_android_fontVariationSettings;
                                }
                                String string5 = obtainAttributes2.getString(i4);
                                int i7 = obtainAttributes2.getInt(i3, 0);
                                if (obtainAttributes2.hasValue(R$styleable.FontFamilyFont_font)) {
                                    i5 = R$styleable.FontFamilyFont_font;
                                } else {
                                    i5 = R$styleable.FontFamilyFont_android_font;
                                }
                                int resourceId2 = obtainAttributes2.getResourceId(i5, 0);
                                String string6 = obtainAttributes2.getString(i5);
                                obtainAttributes2.recycle();
                                while (xmlPullParser.next() != 3) {
                                    skip(xmlPullParser);
                                }
                                FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry = new FontResourcesParserCompat$FontFileResourceEntry(string6, i6, z, string5, i7, resourceId2);
                                arrayList.add(fontResourcesParserCompat$FontFileResourceEntry);
                            } else {
                                skip(xmlPullParser);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    return new FontResourcesParserCompat$FontFamilyFilesResourceEntry((FontResourcesParserCompat$FontFileResourceEntry[]) arrayList.toArray(new FontResourcesParserCompat$FontFileResourceEntry[arrayList.size()]));
                }
                while (xmlPullParser.next() != 3) {
                    skip(xmlPullParser);
                }
                return new FontResourcesParserCompat$ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts(resources2, resourceId)), integer, integer2, string4);
            }
            skip(xmlPullParser);
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> readCerts(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (obtainTypedArray.getType(0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(toByteArrayList(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(toByteArrayList(resources.getStringArray(i)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static void setDecorFitsSystemWindows1(Window window, boolean z) {
        window.setDecorFitsSystemWindows(z);
    }

    public static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence, int i) {
        editorInfo.setInitialSurroundingSubText(charSequence, i);
    }

    public static boolean setLayoutDirection(Drawable drawable, int i) {
        if (VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (!sSetLayoutDirectionMethodFetched) {
            Class<Drawable> cls = Drawable.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                sSetLayoutDirectionMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            sSetLayoutDirectionMethodFetched = true;
        }
        Method method = sSetLayoutDirectionMethod;
        if (method != null) {
            try {
                method.invoke(drawable, new Object[]{Integer.valueOf(i)});
                return true;
            } catch (Exception unused2) {
                sSetLayoutDirectionMethod = null;
            }
        }
        return false;
    }

    public static void setTint(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void setTintMode(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        if (VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
            return;
        }
        TooltipCompatHandler tooltipCompatHandler = TooltipCompatHandler.sPendingHandler;
        if (tooltipCompatHandler != null && tooltipCompatHandler.mAnchor == view) {
            TooltipCompatHandler.setPendingHandler(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            TooltipCompatHandler tooltipCompatHandler2 = TooltipCompatHandler.sActiveHandler;
            if (tooltipCompatHandler2 != null && tooltipCompatHandler2.mAnchor == view) {
                tooltipCompatHandler2.hide();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new TooltipCompatHandler(view, charSequence);
    }

    public static void skip(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static List<byte[]> toByteArrayList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    public static <T extends Drawable> T unwrap(Drawable drawable) {
        return drawable instanceof WrappedDrawable ? ((WrappedDrawable) drawable).getWrappedDrawable() : drawable;
    }

    public static boolean validInGroup(DimensionBehaviour dimensionBehaviour, DimensionBehaviour dimensionBehaviour2, DimensionBehaviour dimensionBehaviour3, DimensionBehaviour dimensionBehaviour4) {
        return (dimensionBehaviour3 == DimensionBehaviour.FIXED || dimensionBehaviour3 == DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour3 == DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != DimensionBehaviour.WRAP_CONTENT)) || (dimensionBehaviour4 == DimensionBehaviour.FIXED || dimensionBehaviour4 == DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour4 == DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != DimensionBehaviour.WRAP_CONTENT));
    }

    public static Drawable wrap(Drawable drawable) {
        return (VERSION.SDK_INT < 23 && !(drawable instanceof TintAwareDrawable)) ? new WrappedDrawableApi21(drawable) : drawable;
    }

    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String getName(Context context, int i) {
        if (i == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            return GeneratedOutlineSupport.outline41(ColorPropConverter.PREFIX_ATTR, i);
        }
    }

    public static void a(String str, Object... objArr) {
        if (f6a) {
            MLog.d(str, objArr);
        }
    }

    public static void a(Scheduler scheduler, a.a.f.c cVar) {
        f8c = cVar;
        f10d = scheduler;
        if (f7b == null) {
            PublishSubject<a.a.f.a> publishSubject = new PublishSubject<>();
            f7b = publishSubject;
            Observable debounce = publishSubject.debounce(400, TimeUnit.MILLISECONDS);
            Scheduler scheduler2 = Schedulers.NEW_THREAD;
            ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
            ObservableSubscribeOn observableSubscribeOn = new ObservableSubscribeOn(debounce, scheduler2);
            b$a b_a = new b$a();
            ObjectHelper.requireNonNull(b_a, "predicate is null");
            new ObservableFilter(observableSubscribeOn, b_a).observeOn(f10d).subscribe(new b$b());
            return;
        }
        throw new Exception("b is already initialized!!");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0014 A[SYNTHETIC, Splitter:B:13:0x0014] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean copyToFile(java.io.File r0, android.content.res.Resources r1, int r2) {
        /*
            java.io.InputStream r1 = r1.openRawResource(r2)     // Catch:{ all -> 0x0010 }
            boolean r0 = copyToFile(r0, r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x000d
            r1.close()     // Catch:{ IOException -> 0x000d }
        L_0x000d:
            return r0
        L_0x000e:
            r0 = move-exception
            goto L_0x0012
        L_0x0010:
            r0 = move-exception
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x0017
            r1.close()     // Catch:{ IOException -> 0x0017 }
        L_0x0017:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.a.d.b.copyToFile(java.io.File, android.content.res.Resources, int):boolean");
    }

    public static void a(Scheduler scheduler, a.a.h.a aVar) {
        f9c = aVar;
        d1 = scheduler;
        if (b1 == null) {
            PublishSubject<a.a.h.b> publishSubject = new PublishSubject<>();
            b1 = publishSubject;
            Observable debounce = publishSubject.debounce(500, TimeUnit.MILLISECONDS);
            Scheduler scheduler2 = Schedulers.NEW_THREAD;
            ObjectHelper.requireNonNull(scheduler2, "scheduler is null");
            ObservableSubscribeOn observableSubscribeOn = new ObservableSubscribeOn(debounce, scheduler2);
            c$a c_a = new c$a();
            ObjectHelper.requireNonNull(c_a, "predicate is null");
            new ObservableFilter(observableSubscribeOn, c_a).observeOn(d1).subscribe(new c$b());
            return;
        }
        throw new Exception("c is already initialized!!");
    }
}
