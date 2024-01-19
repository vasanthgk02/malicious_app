package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.facebook.FacebookException;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R@\u0010\u0006\u001a4\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007j\u001e\u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\f`\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher;", "", "()V", "activitiesSet", "", "Landroid/app/Activity;", "activityToListenerMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashMap;", "Lkotlin/collections/HashSet;", "listenerSet", "uiThreadHandler", "Landroid/os/Handler;", "viewMatchers", "Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher;", "add", "", "activity", "destroy", "matchViews", "remove", "startTracking", "Companion", "MatchedView", "ViewMatcher", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CodelessMatcher.kt */
public final class CodelessMatcher {
    public static final Companion Companion = new Companion(null);
    public static CodelessMatcher codelessMatcher;
    public final Set<Activity> activitiesSet;
    public final HashMap<Integer, HashSet<String>> activityToListenerMap;
    public HashSet<String> listenerSet;
    public final Handler uiThreadHandler = new Handler(Looper.getMainLooper());
    public final Set<ViewMatcher> viewMatchers;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\tH\u0007J\"\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$Companion;", "", "()V", "CURRENT_CLASS_NAME", "", "PARENT_CLASS_NAME", "TAG", "kotlin.jvm.PlatformType", "codelessMatcher", "Lcom/facebook/appevents/codeless/CodelessMatcher;", "getInstance", "getParameters", "Landroid/os/Bundle;", "mapping", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "rootView", "Landroid/view/View;", "hostView", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CodelessMatcher.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final synchronized CodelessMatcher getInstance() {
            CodelessMatcher access$getCodelessMatcher$cp;
            if (CodelessMatcher.access$getCodelessMatcher$cp() == null) {
                CodelessMatcher codelessMatcher = new CodelessMatcher(null);
                Class<CodelessMatcher> cls = CodelessMatcher.class;
                if (!CrashShieldHandler.isObjectCrashing(cls)) {
                    try {
                        CodelessMatcher.codelessMatcher = codelessMatcher;
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, cls);
                    }
                }
            }
            access$getCodelessMatcher$cp = CodelessMatcher.access$getCodelessMatcher$cp();
            if (access$getCodelessMatcher$cp == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessMatcher");
            }
            return access$getCodelessMatcher$cp;
        }

        public final Bundle getParameters(EventBinding eventBinding, View view, View view2) {
            List<MatchedView> list;
            Intrinsics.checkNotNullParameter(view, "rootView");
            Intrinsics.checkNotNullParameter(view2, "hostView");
            Bundle bundle = new Bundle();
            List<T> unmodifiableList = Collections.unmodifiableList(eventBinding.parameters);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(parameters)");
            for (T t : unmodifiableList) {
                String str = t.value;
                if (str != null) {
                    if (str.length() > 0) {
                        bundle.putString(t.name, t.value);
                    }
                }
                if (t.path.size() > 0) {
                    if (Intrinsics.areEqual(t.pathType, "relative")) {
                        List<PathComponent> list2 = t.path;
                        String simpleName = view2.getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName, "hostView.javaClass.simpleName");
                        list = ViewMatcher.findViewByPath(eventBinding, view2, list2, 0, -1, simpleName);
                    } else {
                        List<PathComponent> list3 = t.path;
                        String simpleName2 = view.getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName2, "rootView.javaClass.simpleName");
                        list = ViewMatcher.findViewByPath(eventBinding, view, list3, 0, -1, simpleName2);
                    }
                    Iterator<MatchedView> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MatchedView next = it.next();
                        if (next.getView() != null) {
                            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
                            String textOfView = ViewHierarchy.getTextOfView(next.getView());
                            if (textOfView.length() > 0) {
                                bundle.putString(t.name, textOfView);
                                break;
                            }
                        }
                    }
                }
            }
            return bundle;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0003R\u0016\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "", "view", "Landroid/view/View;", "viewMapKey", "", "(Landroid/view/View;Ljava/lang/String;)V", "Ljava/lang/ref/WeakReference;", "getViewMapKey", "()Ljava/lang/String;", "getView", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CodelessMatcher.kt */
    public static final class MatchedView {
        public final WeakReference<View> view;
        public final String viewMapKey;

        public MatchedView(View view2, String str) {
            Intrinsics.checkNotNullParameter(view2, "view");
            Intrinsics.checkNotNullParameter(str, "viewMapKey");
            this.view = new WeakReference<>(view2);
            this.viewMapKey = str;
        }

        public final View getView() {
            WeakReference<View> weakReference = this.view;
            if (weakReference == null) {
                return null;
            }
            return (View) weakReference.get();
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB7\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J \u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J \u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u001c\u0010\u001a\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0002R\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/facebook/appevents/codeless/CodelessMatcher$ViewMatcher;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Ljava/lang/Runnable;", "rootView", "Landroid/view/View;", "handler", "Landroid/os/Handler;", "listenerSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "activityName", "(Landroid/view/View;Landroid/os/Handler;Ljava/util/HashSet;Ljava/lang/String;)V", "eventBindings", "", "Lcom/facebook/appevents/codeless/internal/EventBinding;", "Ljava/lang/ref/WeakReference;", "attachListener", "", "matchedView", "Lcom/facebook/appevents/codeless/CodelessMatcher$MatchedView;", "mapping", "attachOnClickListener", "attachOnItemClickListener", "attachRCTListener", "findView", "onGlobalLayout", "onScrollChanged", "run", "startMatch", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CodelessMatcher.kt */
    public static final class ViewMatcher implements OnGlobalLayoutListener, OnScrollChangedListener, Runnable {
        public final String activityName;
        public List<EventBinding> eventBindings;
        public final Handler handler;
        public final HashSet<String> listenerSet;
        public final WeakReference<View> rootView;

        public ViewMatcher(View view, Handler handler2, HashSet<String> hashSet, String str) {
            Intrinsics.checkNotNullParameter(handler2, "handler");
            Intrinsics.checkNotNullParameter(hashSet, "listenerSet");
            Intrinsics.checkNotNullParameter(str, "activityName");
            this.rootView = new WeakReference<>(view);
            this.handler = handler2;
            this.listenerSet = hashSet;
            this.activityName = str;
            handler2.postDelayed(this, 200);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00db, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r9.getClass().getSimpleName(), (java.lang.String) com.android.tools.r8.GeneratedOutlineSupport.outline29(kotlin.text.CharsKt__CharKt.split$default((java.lang.CharSequence) r1.className, new java.lang.String[]{"."}, false, 0, 6), -1)) == false) goto L_0x01aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x011b, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r12, r4) == false) goto L_0x01aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x014e, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r12, r4) == false) goto L_0x01aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0176, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r12, r4) == false) goto L_0x01aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x01a8, code lost:
            if (kotlin.jvm.internal.Intrinsics.areEqual(r12, r2) == false) goto L_0x01aa;
         */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x01af A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x01b0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final java.util.List<com.facebook.appevents.codeless.CodelessMatcher.MatchedView> findViewByPath(com.facebook.appevents.codeless.internal.EventBinding r8, android.view.View r9, java.util.List<com.facebook.appevents.codeless.internal.PathComponent> r10, int r11, int r12, java.lang.String r13) {
            /*
                java.lang.String r0 = "path"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                java.lang.String r0 = "mapKey"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r13)
                r13 = 46
                r0.append(r13)
                r0.append(r12)
                java.lang.String r13 = r0.toString()
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                if (r9 != 0) goto L_0x0026
                return r0
            L_0x0026:
                int r1 = r10.size()
                r2 = 0
                if (r11 < r1) goto L_0x0037
                com.facebook.appevents.codeless.CodelessMatcher$MatchedView r12 = new com.facebook.appevents.codeless.CodelessMatcher$MatchedView
                r12.<init>(r9, r13)
                r0.add(r12)
                goto L_0x01c0
            L_0x0037:
                java.lang.Object r1 = r10.get(r11)
                com.facebook.appevents.codeless.internal.PathComponent r1 = (com.facebook.appevents.codeless.internal.PathComponent) r1
                java.lang.String r3 = r1.className
                java.lang.String r4 = ".."
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 == 0) goto L_0x007a
                android.view.ViewParent r9 = r9.getParent()
                boolean r12 = r9 instanceof android.view.ViewGroup
                if (r12 == 0) goto L_0x0079
                android.view.ViewGroup r9 = (android.view.ViewGroup) r9
                java.util.List r9 = findVisibleChildren(r9)
                java.util.ArrayList r9 = (java.util.ArrayList) r9
                int r12 = r9.size()
                if (r12 <= 0) goto L_0x0079
                r1 = 0
                r5 = 0
            L_0x005f:
                int r7 = r5 + 1
                java.lang.Object r1 = r9.get(r5)
                r2 = r1
                android.view.View r2 = (android.view.View) r2
                int r4 = r11 + 1
                r1 = r8
                r3 = r10
                r6 = r13
                java.util.List r1 = findViewByPath(r1, r2, r3, r4, r5, r6)
                r0.addAll(r1)
                if (r7 < r12) goto L_0x0077
                goto L_0x0079
            L_0x0077:
                r5 = r7
                goto L_0x005f
            L_0x0079:
                return r0
            L_0x007a:
                java.lang.String r3 = r1.className
                java.lang.String r4 = "."
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 == 0) goto L_0x008d
                com.facebook.appevents.codeless.CodelessMatcher$MatchedView r8 = new com.facebook.appevents.codeless.CodelessMatcher$MatchedView
                r8.<init>(r9, r13)
                r0.add(r8)
                return r0
            L_0x008d:
                int r3 = r1.index
                r5 = -1
                if (r3 == r5) goto L_0x0096
                if (r12 == r3) goto L_0x0096
                goto L_0x01aa
            L_0x0096:
                java.lang.Class r12 = r9.getClass()
                java.lang.String r12 = r12.getCanonicalName()
                java.lang.String r3 = r1.className
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r3)
                if (r12 != 0) goto L_0x00df
                java.lang.String r12 = r1.className
                kotlin.text.Regex r3 = new kotlin.text.Regex
                java.lang.String r5 = ".*android\\..*"
                r3.<init>(r5)
                boolean r12 = r3.matches(r12)
                if (r12 == 0) goto L_0x01aa
                java.lang.String r12 = r1.className
                java.lang.String[] r3 = new java.lang.String[]{r4}
                r4 = 6
                java.util.List r12 = kotlin.text.CharsKt__CharKt.split$default(r12, r3, r2, r2, r4)
                boolean r2 = r12.isEmpty()
                r2 = r2 ^ 1
                if (r2 == 0) goto L_0x01aa
                r2 = -1
                java.lang.Object r12 = com.android.tools.r8.GeneratedOutlineSupport.outline29(r12, r2)
                java.lang.String r12 = (java.lang.String) r12
                java.lang.Class r2 = r9.getClass()
                java.lang.String r2 = r2.getSimpleName()
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r12)
                if (r12 != 0) goto L_0x00df
                goto L_0x01aa
            L_0x00df:
                int r12 = r1.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.ID
                int r2 = r2.getValue()
                r12 = r12 & r2
                if (r12 <= 0) goto L_0x00f4
                int r12 = r1.id
                int r2 = r9.getId()
                if (r12 == r2) goto L_0x00f4
                goto L_0x01aa
            L_0x00f4:
                int r12 = r1.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r2 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TEXT
                int r2 = r2.getValue()
                r12 = r12 & r2
                java.lang.String r2 = ""
                if (r12 <= 0) goto L_0x011f
                java.lang.String r12 = r1.text
                com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE
                java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getTextOfView(r9)
                java.lang.String r4 = com.facebook.internal.Utility.sha256hash(r3)
                java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r2)
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r3)
                if (r3 != 0) goto L_0x011f
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r4)
                if (r12 != 0) goto L_0x011f
                goto L_0x01aa
            L_0x011f:
                int r12 = r1.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.DESCRIPTION
                int r3 = r3.getValue()
                r12 = r12 & r3
                if (r12 <= 0) goto L_0x0151
                java.lang.String r12 = r1.description
                java.lang.CharSequence r3 = r9.getContentDescription()
                if (r3 != 0) goto L_0x0134
                r3 = r2
                goto L_0x013c
            L_0x0134:
                java.lang.CharSequence r3 = r9.getContentDescription()
                java.lang.String r3 = r3.toString()
            L_0x013c:
                java.lang.String r4 = com.facebook.internal.Utility.sha256hash(r3)
                java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r2)
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r3)
                if (r3 != 0) goto L_0x0151
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r4)
                if (r12 != 0) goto L_0x0151
                goto L_0x01aa
            L_0x0151:
                int r12 = r1.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.HINT
                int r3 = r3.getValue()
                r12 = r12 & r3
                if (r12 <= 0) goto L_0x0179
                java.lang.String r12 = r1.hint
                com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE
                java.lang.String r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.getHintOfView(r9)
                java.lang.String r4 = com.facebook.internal.Utility.sha256hash(r3)
                java.lang.String r4 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r4, r2)
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r3)
                if (r3 != 0) goto L_0x0179
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r4)
                if (r12 != 0) goto L_0x0179
                goto L_0x01aa
            L_0x0179:
                int r12 = r1.matchBitmask
                com.facebook.appevents.codeless.internal.PathComponent$MatchBitmaskType r3 = com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType.TAG
                int r3 = r3.getValue()
                r12 = r12 & r3
                if (r12 <= 0) goto L_0x01ac
                java.lang.String r12 = r1.tag
                java.lang.Object r1 = r9.getTag()
                if (r1 != 0) goto L_0x018e
                r1 = r2
                goto L_0x0196
            L_0x018e:
                java.lang.Object r1 = r9.getTag()
                java.lang.String r1 = r1.toString()
            L_0x0196:
                java.lang.String r3 = com.facebook.internal.Utility.sha256hash(r1)
                java.lang.String r2 = com.facebook.internal.Utility.coerceValueIfNullOrEmpty(r3, r2)
                boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r1)
                if (r1 != 0) goto L_0x01ac
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r2)
                if (r12 != 0) goto L_0x01ac
            L_0x01aa:
                r12 = 0
                goto L_0x01ad
            L_0x01ac:
                r12 = 1
            L_0x01ad:
                if (r12 != 0) goto L_0x01b0
                return r0
            L_0x01b0:
                int r12 = r10.size()
                int r12 = r12 + -1
                if (r11 != r12) goto L_0x01c0
                com.facebook.appevents.codeless.CodelessMatcher$MatchedView r12 = new com.facebook.appevents.codeless.CodelessMatcher$MatchedView
                r12.<init>(r9, r13)
                r0.add(r12)
            L_0x01c0:
                boolean r12 = r9 instanceof android.view.ViewGroup
                if (r12 == 0) goto L_0x01ee
                android.view.ViewGroup r9 = (android.view.ViewGroup) r9
                java.util.List r9 = findVisibleChildren(r9)
                java.util.ArrayList r9 = (java.util.ArrayList) r9
                int r12 = r9.size()
                if (r12 <= 0) goto L_0x01ee
                r1 = 0
                r5 = 0
            L_0x01d4:
                int r7 = r5 + 1
                java.lang.Object r1 = r9.get(r5)
                r2 = r1
                android.view.View r2 = (android.view.View) r2
                int r4 = r11 + 1
                r1 = r8
                r3 = r10
                r6 = r13
                java.util.List r1 = findViewByPath(r1, r2, r3, r4, r5, r6)
                r0.addAll(r1)
                if (r7 < r12) goto L_0x01ec
                goto L_0x01ee
            L_0x01ec:
                r5 = r7
                goto L_0x01d4
            L_0x01ee:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.findViewByPath(com.facebook.appevents.codeless.internal.EventBinding, android.view.View, java.util.List, int, int, java.lang.String):java.util.List");
        }

        public static final List<View> findVisibleChildren(ViewGroup viewGroup) {
            ArrayList arrayList = new ArrayList();
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt.getVisibility() == 0) {
                        Intrinsics.checkNotNullExpressionValue(childAt, "child");
                        arrayList.add(childAt);
                    }
                    if (i2 >= childCount) {
                        break;
                    }
                    i = i2;
                }
            }
            return arrayList;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void attachOnClickListener(com.facebook.appevents.codeless.CodelessMatcher.MatchedView r5, android.view.View r6, com.facebook.appevents.codeless.internal.EventBinding r7) {
            /*
                r4 = this;
                android.view.View r0 = r5.getView()
                if (r0 != 0) goto L_0x0007
                return
            L_0x0007:
                java.lang.String r5 = r5.viewMapKey
                com.facebook.appevents.codeless.internal.ViewHierarchy r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE
                android.view.View$OnClickListener r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.getExistingOnClickListener(r0)
                boolean r2 = r1 instanceof com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener
                if (r2 == 0) goto L_0x0025
                if (r1 == 0) goto L_0x001d
                com.facebook.appevents.codeless.CodelessLoggingEventListener$AutoLoggingOnClickListener r1 = (com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener) r1
                boolean r1 = r1.supportCodelessLogging
                if (r1 == 0) goto L_0x0025
                r1 = 1
                goto L_0x0026
            L_0x001d:
                java.lang.NullPointerException r5 = new java.lang.NullPointerException
                java.lang.String r6 = "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener"
                r5.<init>(r6)
                throw r5
            L_0x0025:
                r1 = 0
            L_0x0026:
                java.util.HashSet<java.lang.String> r2 = r4.listenerSet
                boolean r2 = r2.contains(r5)
                if (r2 != 0) goto L_0x005c
                if (r1 != 0) goto L_0x005c
                java.lang.Class<com.facebook.appevents.codeless.CodelessLoggingEventListener> r1 = com.facebook.appevents.codeless.CodelessLoggingEventListener.class
                boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
                r3 = 0
                if (r2 == 0) goto L_0x003a
                goto L_0x0054
            L_0x003a:
                java.lang.String r2 = "mapping"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)     // Catch:{ all -> 0x0050 }
                java.lang.String r2 = "rootView"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)     // Catch:{ all -> 0x0050 }
                java.lang.String r2 = "hostView"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)     // Catch:{ all -> 0x0050 }
                com.facebook.appevents.codeless.CodelessLoggingEventListener$AutoLoggingOnClickListener r2 = new com.facebook.appevents.codeless.CodelessLoggingEventListener$AutoLoggingOnClickListener     // Catch:{ all -> 0x0050 }
                r2.<init>(r7, r6, r0)     // Catch:{ all -> 0x0050 }
                r3 = r2
                goto L_0x0054
            L_0x0050:
                r6 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r6, r1)
            L_0x0054:
                r0.setOnClickListener(r3)
                java.util.HashSet<java.lang.String> r6 = r4.listenerSet
                r6.add(r5)
            L_0x005c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.attachOnClickListener(com.facebook.appevents.codeless.CodelessMatcher$MatchedView, android.view.View, com.facebook.appevents.codeless.internal.EventBinding):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void attachOnItemClickListener(com.facebook.appevents.codeless.CodelessMatcher.MatchedView r5, android.view.View r6, com.facebook.appevents.codeless.internal.EventBinding r7) {
            /*
                r4 = this;
                android.view.View r0 = r5.getView()
                android.widget.AdapterView r0 = (android.widget.AdapterView) r0
                if (r0 != 0) goto L_0x0009
                return
            L_0x0009:
                java.lang.String r5 = r5.viewMapKey
                android.widget.AdapterView$OnItemClickListener r1 = r0.getOnItemClickListener()
                boolean r2 = r1 instanceof com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener
                if (r2 == 0) goto L_0x0025
                if (r1 == 0) goto L_0x001d
                com.facebook.appevents.codeless.CodelessLoggingEventListener$AutoLoggingOnItemClickListener r1 = (com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener) r1
                boolean r1 = r1.supportCodelessLogging
                if (r1 == 0) goto L_0x0025
                r1 = 1
                goto L_0x0026
            L_0x001d:
                java.lang.NullPointerException r5 = new java.lang.NullPointerException
                java.lang.String r6 = "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener"
                r5.<init>(r6)
                throw r5
            L_0x0025:
                r1 = 0
            L_0x0026:
                java.util.HashSet<java.lang.String> r2 = r4.listenerSet
                boolean r2 = r2.contains(r5)
                if (r2 != 0) goto L_0x005c
                if (r1 != 0) goto L_0x005c
                java.lang.Class<com.facebook.appevents.codeless.CodelessLoggingEventListener> r1 = com.facebook.appevents.codeless.CodelessLoggingEventListener.class
                boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
                r3 = 0
                if (r2 == 0) goto L_0x003a
                goto L_0x0054
            L_0x003a:
                java.lang.String r2 = "mapping"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)     // Catch:{ all -> 0x0050 }
                java.lang.String r2 = "rootView"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)     // Catch:{ all -> 0x0050 }
                java.lang.String r2 = "hostView"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)     // Catch:{ all -> 0x0050 }
                com.facebook.appevents.codeless.CodelessLoggingEventListener$AutoLoggingOnItemClickListener r2 = new com.facebook.appevents.codeless.CodelessLoggingEventListener$AutoLoggingOnItemClickListener     // Catch:{ all -> 0x0050 }
                r2.<init>(r7, r6, r0)     // Catch:{ all -> 0x0050 }
                r3 = r2
                goto L_0x0054
            L_0x0050:
                r6 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r6, r1)
            L_0x0054:
                r0.setOnItemClickListener(r3)
                java.util.HashSet<java.lang.String> r6 = r4.listenerSet
                r6.add(r5)
            L_0x005c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.attachOnItemClickListener(com.facebook.appevents.codeless.CodelessMatcher$MatchedView, android.view.View, com.facebook.appevents.codeless.internal.EventBinding):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void attachRCTListener(com.facebook.appevents.codeless.CodelessMatcher.MatchedView r5, android.view.View r6, com.facebook.appevents.codeless.internal.EventBinding r7) {
            /*
                r4 = this;
                android.view.View r0 = r5.getView()
                if (r0 != 0) goto L_0x0007
                return
            L_0x0007:
                java.lang.String r5 = r5.viewMapKey
                com.facebook.appevents.codeless.internal.ViewHierarchy r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE
                android.view.View$OnTouchListener r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.getExistingOnTouchListener(r0)
                boolean r2 = r1 instanceof com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener
                if (r2 == 0) goto L_0x0025
                if (r1 == 0) goto L_0x001d
                com.facebook.appevents.codeless.RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener r1 = (com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) r1
                boolean r1 = r1.supportCodelessLogging
                if (r1 == 0) goto L_0x0025
                r1 = 1
                goto L_0x0026
            L_0x001d:
                java.lang.NullPointerException r5 = new java.lang.NullPointerException
                java.lang.String r6 = "null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener"
                r5.<init>(r6)
                throw r5
            L_0x0025:
                r1 = 0
            L_0x0026:
                java.util.HashSet<java.lang.String> r2 = r4.listenerSet
                boolean r2 = r2.contains(r5)
                if (r2 != 0) goto L_0x005c
                if (r1 != 0) goto L_0x005c
                java.lang.Class<com.facebook.appevents.codeless.RCTCodelessLoggingEventListener> r1 = com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.class
                boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
                r3 = 0
                if (r2 == 0) goto L_0x003a
                goto L_0x0054
            L_0x003a:
                java.lang.String r2 = "mapping"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)     // Catch:{ all -> 0x0050 }
                java.lang.String r2 = "rootView"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)     // Catch:{ all -> 0x0050 }
                java.lang.String r2 = "hostView"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)     // Catch:{ all -> 0x0050 }
                com.facebook.appevents.codeless.RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener r2 = new com.facebook.appevents.codeless.RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener     // Catch:{ all -> 0x0050 }
                r2.<init>(r7, r6, r0)     // Catch:{ all -> 0x0050 }
                r3 = r2
                goto L_0x0054
            L_0x0050:
                r6 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r6, r1)
            L_0x0054:
                r0.setOnTouchListener(r3)
                java.util.HashSet<java.lang.String> r6 = r4.listenerSet
                r6.add(r5)
            L_0x005c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.attachRCTListener(com.facebook.appevents.codeless.CodelessMatcher$MatchedView, android.view.View, com.facebook.appevents.codeless.internal.EventBinding):void");
        }

        public void onGlobalLayout() {
            startMatch();
        }

        public void onScrollChanged() {
            startMatch();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:9|(4:11|12|13|(3:(2:15|(1:17)(0))|19|(2:21|(1:23)(3:24|(1:26)|27)))(0))(0)|18|19|(0)) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0041 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0045 A[Catch:{ all -> 0x0064 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r6)
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0064 }
                java.lang.String r0 = com.facebook.FacebookSdk.getApplicationId()     // Catch:{ all -> 0x0064 }
                com.facebook.internal.FetchedAppSettingsManager r1 = com.facebook.internal.FetchedAppSettingsManager.INSTANCE     // Catch:{ all -> 0x0064 }
                com.facebook.internal.FetchedAppSettings r0 = com.facebook.internal.FetchedAppSettingsManager.getAppSettingsWithoutQuery(r0)     // Catch:{ all -> 0x0064 }
                if (r0 == 0) goto L_0x0063
                boolean r1 = r0.codelessEventsEnabled     // Catch:{ all -> 0x0064 }
                if (r1 != 0) goto L_0x001a
                goto L_0x0063
            L_0x001a:
                org.json.JSONArray r0 = r0.eventBindings     // Catch:{ all -> 0x0064 }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0064 }
                r1.<init>()     // Catch:{ all -> 0x0064 }
                if (r0 == 0) goto L_0x0041
                r2 = 0
                int r3 = r0.length()     // Catch:{ IllegalArgumentException | JSONException -> 0x0041 }
                if (r3 <= 0) goto L_0x0041
            L_0x002a:
                int r4 = r2 + 1
                org.json.JSONObject r2 = r0.getJSONObject(r2)     // Catch:{ IllegalArgumentException | JSONException -> 0x0041 }
                java.lang.String r5 = "array.getJSONObject(i)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch:{ IllegalArgumentException | JSONException -> 0x0041 }
                com.facebook.appevents.codeless.internal.EventBinding r2 = com.facebook.appevents.codeless.internal.EventBinding.getInstanceFromJson(r2)     // Catch:{ IllegalArgumentException | JSONException -> 0x0041 }
                r1.add(r2)     // Catch:{ IllegalArgumentException | JSONException -> 0x0041 }
                if (r4 < r3) goto L_0x003f
                goto L_0x0041
            L_0x003f:
                r2 = r4
                goto L_0x002a
            L_0x0041:
                r6.eventBindings = r1     // Catch:{ all -> 0x0064 }
                if (r1 == 0) goto L_0x0063
                java.lang.ref.WeakReference<android.view.View> r0 = r6.rootView     // Catch:{ all -> 0x0064 }
                java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0064 }
                android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x0064 }
                if (r0 != 0) goto L_0x0050
                return
            L_0x0050:
                android.view.ViewTreeObserver r0 = r0.getViewTreeObserver()     // Catch:{ all -> 0x0064 }
                boolean r1 = r0.isAlive()     // Catch:{ all -> 0x0064 }
                if (r1 == 0) goto L_0x0060
                r0.addOnGlobalLayoutListener(r6)     // Catch:{ all -> 0x0064 }
                r0.addOnScrollChangedListener(r6)     // Catch:{ all -> 0x0064 }
            L_0x0060:
                r6.startMatch()     // Catch:{ all -> 0x0064 }
            L_0x0063:
                return
            L_0x0064:
                r0 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.run():void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:44:0x00b2 A[Catch:{ all -> 0x00aa, all -> 0x00bd }] */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x00b1 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void startMatch() {
            /*
                r15 = this;
                java.util.List<com.facebook.appevents.codeless.internal.EventBinding> r0 = r15.eventBindings
                if (r0 != 0) goto L_0x0006
                goto L_0x0114
            L_0x0006:
                java.lang.ref.WeakReference<android.view.View> r1 = r15.rootView
                java.lang.Object r1 = r1.get()
                if (r1 == 0) goto L_0x0114
                int r1 = r0.size()
                int r1 = r1 + -1
                if (r1 < 0) goto L_0x0114
                r2 = 0
                r3 = 0
            L_0x0018:
                int r4 = r3 + 1
                java.lang.Object r3 = r0.get(r3)
                com.facebook.appevents.codeless.internal.EventBinding r3 = (com.facebook.appevents.codeless.internal.EventBinding) r3
                java.lang.ref.WeakReference<android.view.View> r5 = r15.rootView
                java.lang.Object r5 = r5.get()
                r11 = r5
                android.view.View r11 = (android.view.View) r11
                if (r3 == 0) goto L_0x010e
                if (r11 != 0) goto L_0x002f
                goto L_0x010e
            L_0x002f:
                java.lang.String r5 = r3.activityName
                if (r5 == 0) goto L_0x003c
                int r5 = r5.length()
                if (r5 != 0) goto L_0x003a
                goto L_0x003c
            L_0x003a:
                r5 = 0
                goto L_0x003d
            L_0x003c:
                r5 = 1
            L_0x003d:
                if (r5 != 0) goto L_0x004b
                java.lang.String r5 = r3.activityName
                java.lang.String r6 = r15.activityName
                boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
                if (r5 != 0) goto L_0x004b
                goto L_0x010e
            L_0x004b:
                java.util.List<com.facebook.appevents.codeless.internal.PathComponent> r5 = r3.path
                java.util.List r7 = java.util.Collections.unmodifiableList(r5)
                java.lang.String r5 = "unmodifiableList(path)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
                int r5 = r7.size()
                r6 = 25
                if (r5 <= r6) goto L_0x0060
                goto L_0x010e
            L_0x0060:
                r8 = 0
                r9 = -1
                java.lang.String r10 = r15.activityName
                r5 = r3
                r6 = r11
                java.util.List r5 = findViewByPath(r5, r6, r7, r8, r9, r10)
                java.util.ArrayList r5 = (java.util.ArrayList) r5
                java.util.Iterator r5 = r5.iterator()
            L_0x0070:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto L_0x010e
                java.lang.Object r6 = r5.next()
                com.facebook.appevents.codeless.CodelessMatcher$MatchedView r6 = (com.facebook.appevents.codeless.CodelessMatcher.MatchedView) r6
                r7 = 0
                android.view.View r8 = r6.getView()     // Catch:{ Exception -> 0x00f8 }
                if (r8 != 0) goto L_0x0084
                goto L_0x0070
            L_0x0084:
                com.facebook.appevents.codeless.internal.ViewHierarchy r9 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE     // Catch:{ Exception -> 0x00f8 }
                java.lang.Class<com.facebook.appevents.codeless.internal.ViewHierarchy> r9 = com.facebook.appevents.codeless.internal.ViewHierarchy.class
                boolean r10 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r9)     // Catch:{ Exception -> 0x00f8 }
                if (r10 == 0) goto L_0x008f
                goto L_0x00c1
            L_0x008f:
                r10 = r8
            L_0x0090:
                if (r10 == 0) goto L_0x00c1
                com.facebook.appevents.codeless.internal.ViewHierarchy r12 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE     // Catch:{ all -> 0x00bd }
                boolean r13 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)     // Catch:{ all -> 0x00bd }
                if (r13 == 0) goto L_0x009b
                goto L_0x00ae
            L_0x009b:
                java.lang.Class r13 = r10.getClass()     // Catch:{ all -> 0x00aa }
                java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x00aa }
                java.lang.String r14 = "com.facebook.react.ReactRootView"
                boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)     // Catch:{ all -> 0x00aa }
                goto L_0x00af
            L_0x00aa:
                r13 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)     // Catch:{ all -> 0x00bd }
            L_0x00ae:
                r12 = 0
            L_0x00af:
                if (r12 == 0) goto L_0x00b2
                goto L_0x00c2
            L_0x00b2:
                android.view.ViewParent r10 = r10.getParent()     // Catch:{ all -> 0x00bd }
                boolean r12 = r10 instanceof android.view.View     // Catch:{ all -> 0x00bd }
                if (r12 == 0) goto L_0x00c1
                android.view.View r10 = (android.view.View) r10     // Catch:{ all -> 0x00bd }
                goto L_0x0090
            L_0x00bd:
                r10 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r10, r9)     // Catch:{ Exception -> 0x00f8 }
            L_0x00c1:
                r10 = r7
            L_0x00c2:
                if (r10 == 0) goto L_0x00d0
                com.facebook.appevents.codeless.internal.ViewHierarchy r9 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE     // Catch:{ Exception -> 0x00f8 }
                boolean r9 = r9.isRCTButton(r8, r10)     // Catch:{ Exception -> 0x00f8 }
                if (r9 == 0) goto L_0x00d0
                r15.attachRCTListener(r6, r11, r3)     // Catch:{ Exception -> 0x00f8 }
                goto L_0x0070
            L_0x00d0:
                java.lang.Class r9 = r8.getClass()     // Catch:{ Exception -> 0x00f8 }
                java.lang.String r9 = r9.getName()     // Catch:{ Exception -> 0x00f8 }
                java.lang.String r10 = "view.javaClass.name"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ Exception -> 0x00f8 }
                java.lang.String r10 = "com.facebook.react"
                r12 = 2
                boolean r9 = kotlin.text.CharsKt__CharKt.startsWith$default(r9, r10, r2, r12)     // Catch:{ Exception -> 0x00f8 }
                if (r9 == 0) goto L_0x00e7
                goto L_0x0070
            L_0x00e7:
                boolean r9 = r8 instanceof android.widget.AdapterView     // Catch:{ Exception -> 0x00f8 }
                if (r9 != 0) goto L_0x00ef
                r15.attachOnClickListener(r6, r11, r3)     // Catch:{ Exception -> 0x00f8 }
                goto L_0x0070
            L_0x00ef:
                boolean r8 = r8 instanceof android.widget.ListView     // Catch:{ Exception -> 0x00f8 }
                if (r8 == 0) goto L_0x0070
                r15.attachOnItemClickListener(r6, r11, r3)     // Catch:{ Exception -> 0x00f8 }
                goto L_0x0070
            L_0x00f8:
                r6 = move-exception
                java.lang.Class<com.facebook.appevents.codeless.CodelessMatcher> r8 = com.facebook.appevents.codeless.CodelessMatcher.class
                boolean r9 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r8)
                if (r9 == 0) goto L_0x0102
                goto L_0x0109
            L_0x0102:
                java.lang.String r7 = "com.facebook.appevents.codeless.CodelessMatcher"
                goto L_0x0109
            L_0x0105:
                r9 = move-exception
                com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r9, r8)
            L_0x0109:
                com.facebook.internal.Utility.logd(r7, r6)
                goto L_0x0070
            L_0x010e:
                if (r4 <= r1) goto L_0x0111
                goto L_0x0114
            L_0x0111:
                r3 = r4
                goto L_0x0018
            L_0x0114:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.startMatch():void");
        }
    }

    public CodelessMatcher() {
        Set<Activity> newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(WeakHashMap())");
        this.activitiesSet = newSetFromMap;
        this.viewMatchers = new LinkedHashSet();
        this.listenerSet = new HashSet<>();
        this.activityToListenerMap = new HashMap<>();
    }

    public static final /* synthetic */ CodelessMatcher access$getCodelessMatcher$cp() {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return codelessMatcher;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    /* renamed from: startTracking$lambda-1  reason: not valid java name */
    public static final void m163startTracking$lambda1(CodelessMatcher codelessMatcher2) {
        Class<CodelessMatcher> cls = CodelessMatcher.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(codelessMatcher2, "this$0");
                codelessMatcher2.matchViews();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    public final void add(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!InternalSettings.isUnityApp()) {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        this.activitiesSet.add(activity);
                        this.listenerSet.clear();
                        HashSet<String> hashSet = this.activityToListenerMap.get(Integer.valueOf(activity.hashCode()));
                        if (hashSet != null) {
                            this.listenerSet = hashSet;
                        }
                        if (!CrashShieldHandler.isObjectCrashing(this)) {
                            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                                matchViews();
                            } else {
                                this.uiThreadHandler.post(new Runnable() {
                                    public final void run() {
                                        CodelessMatcher.m163startTracking$lambda1(CodelessMatcher.this);
                                    }
                                });
                            }
                        }
                        return;
                    }
                    throw new FacebookException((String) "Can't add activity to CodelessMatcher on non-UI thread");
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void matchViews() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                for (Activity next : this.activitiesSet) {
                    if (next != null) {
                        View rootView = AppEventUtility.getRootView(next);
                        String simpleName = next.getClass().getSimpleName();
                        Handler handler = this.uiThreadHandler;
                        HashSet<String> hashSet = this.listenerSet;
                        Intrinsics.checkNotNullExpressionValue(simpleName, "activityName");
                        this.viewMatchers.add(new ViewMatcher(rootView, handler, hashSet, simpleName));
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void remove(Activity activity) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (!InternalSettings.isUnityApp()) {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        this.activitiesSet.remove(activity);
                        this.viewMatchers.clear();
                        this.activityToListenerMap.put(Integer.valueOf(activity.hashCode()), (HashSet) this.listenerSet.clone());
                        this.listenerSet.clear();
                        return;
                    }
                    throw new FacebookException((String) "Can't remove activity from CodelessMatcher on non-UI thread");
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public CodelessMatcher(DefaultConstructorMarker defaultConstructorMarker) {
        Set<Activity> newSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(newSetFromMap, "newSetFromMap(WeakHashMap())");
        this.activitiesSet = newSetFromMap;
        this.viewMatchers = new LinkedHashSet();
        this.listenerSet = new HashSet<>();
        this.activityToListenerMap = new HashMap<>();
    }
}
