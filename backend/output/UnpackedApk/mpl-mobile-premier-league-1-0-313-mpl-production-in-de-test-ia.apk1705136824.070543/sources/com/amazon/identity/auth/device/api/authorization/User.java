package com.amazon.identity.auth.device.api.authorization;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.AuthError.ERROR_TYPE;
import com.amazon.identity.auth.device.api.Listener;
import com.amazon.identity.auth.device.api.authorization.AuthorizationManager;
import com.amazon.identity.auth.device.shared.APIListener;
import java.util.HashMap;
import java.util.Map;

public final class User {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3286a = "com.amazon.identity.auth.device.api.authorization.User";

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, String> f110a;

    public enum a {
        NAME("name"),
        EMAIL("email"),
        USER_ID("user_id"),
        POSTAL_CODE("postal_code");
        

        /* renamed from: a  reason: collision with other field name */
        public final String f112a;

        /* access modifiers changed from: public */
        a(String str) {
            this.f112a = str;
        }
    }

    public User(Map<String, String> map) {
        this.f110a = map;
    }

    public static User a(Bundle bundle) {
        HashMap hashMap = new HashMap(bundle.size());
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return new User(hashMap);
    }

    public static void a(Context context, t tVar, final Listener<User, AuthError> listener) {
        String str = f3286a;
        cp.c(str, context.getPackageName() + " calling fetch");
        Bundle bundle = new Bundle();
        bundle.putBoolean(ch$c.FAIL_ON_INSUFFICIENT_SCOPE.f91a, true);
        AnonymousClass1 r1 = new APIListener() {
            public void onError(AuthError authError) {
                listener.onError(authError);
            }

            public void onSuccess(Bundle bundle) {
                listener.onSuccess(User.a(bundle.getBundle(ch$b.PROFILE.f89a)));
            }
        };
        if (tVar != null) {
            cp.c("t", context.getPackageName() + " calling getProfile");
            ca.f81a.execute(new Runnable(context, new bx(r1), bundle) {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ Context f3337a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ Bundle f158a;

                /* renamed from: a  reason: collision with other field name */
                public final /* synthetic */ bx f159a;

                {
                    this.f3337a = r2;
                    this.f159a = r3;
                    this.f158a = r4;
                }

                public void run() {
                    if (!t.this.a(this.f3337a)) {
                        bx bxVar = this.f159a;
                        AuthError authError = new AuthError("APIKey is invalid", ERROR_TYPE.ERROR_ACCESS_DENIED);
                        bxVar.f78a = authError;
                        bxVar.f79a.countDown();
                        bxVar.f76a.onError(authError);
                        return;
                    }
                    Bundle bundle = this.f158a == null ? new Bundle() : new Bundle(this.f158a);
                    if (!bundle.containsKey(ch$b.SANDBOX.f89a)) {
                        bundle.putBoolean(ch$b.SANDBOX.f89a, AuthorizationManager.isSandboxMode(this.f3337a));
                    }
                    Context context = this.f3337a;
                    String packageName = context.getPackageName();
                    AnonymousClass1 r0 = new APIListener() {
                        public void onError(AuthError authError) {
                            bx bxVar = AnonymousClass3.this.f159a;
                            bxVar.f78a = authError;
                            bxVar.f79a.countDown();
                            bxVar.f76a.onError(authError);
                        }

                        public void onSuccess(Bundle bundle) {
                            AnonymousClass3.this.f159a.onSuccess(bundle);
                        }
                    };
                    ag a2 = new j().a(packageName, context);
                    if (a2 == null) {
                        e = new AuthError("App info is null", ERROR_TYPE.ERROR_ACCESS_DENIED);
                    } else {
                        try {
                            ad.a(context, packageName, a2.f2708e, v.a(context, a2), new APIListener(context, bundle, r0, a2) {

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ ag f3342a;

                                /* renamed from: a  reason: collision with other field name */
                                public final /* synthetic */ Context f165a;

                                /* renamed from: a  reason: collision with other field name */
                                public final /* synthetic */ Bundle f166a;

                                /* renamed from: a  reason: collision with other field name */
                                public final /* synthetic */ APIListener f167a;

                                public 
/*
Method generation error in method: v.1.onError(com.amazon.identity.auth.device.AuthError):null, dex: classes.dex
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:315)
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:315)
                                	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:261)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:109)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
                                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                                
*/

                                public 
/*
Method generation error in method: v.1.onError(java.lang.Object):null, dex: classes.dex
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:315)
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:315)
                                	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:261)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:109)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
                                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                                
*/

                                public 
/*
Method generation error in method: v.1.onSuccess(android.os.Bundle):null, dex: classes.dex
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:315)
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:315)
                                	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:261)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:109)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
                                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                                
*/

                                public /* bridge */ /* synthetic */ 
/*
Method generation error in method: v.1.onSuccess(java.lang.Object):null, dex: classes.dex
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:315)
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:210)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:203)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:315)
                                	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:261)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:224)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:109)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
                                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                                
*/
                            }, new j(), bundle);
                        } catch (AuthError e2) {
                            e = e2;
                        }
                    }
                    r0.onError(e);
                }
            });
            return;
        }
        throw null;
    }

    public static void fetch(Context context, Listener<User, AuthError> listener) {
        a(context, t.a(context), listener);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || User.class != obj.getClass()) {
            return false;
        }
        Map<String, String> map = this.f110a;
        Map<String, String> map2 = ((User) obj).f110a;
        if (map == null) {
            if (map2 != null) {
                return false;
            }
        } else if (!map.equals(map2)) {
            return false;
        }
        return true;
    }

    public String getUserEmail() {
        return this.f110a.get(a.EMAIL.f112a);
    }

    public String getUserId() {
        return this.f110a.get(a.USER_ID.f112a);
    }

    public Map<String, String> getUserInfo() {
        return this.f110a;
    }

    public String getUserName() {
        return this.f110a.get(a.NAME.f112a);
    }

    public String getUserPostalCode() {
        return this.f110a.get(a.POSTAL_CODE.f112a);
    }

    public int hashCode() {
        Map<String, String> map = this.f110a;
        return 31 + (map == null ? 0 : map.hashCode());
    }

    public String toString() {
        return String.format("%s={userInfo=%s}", new Object[]{super.toString(), this.f110a});
    }
}
