package com.shield.android.f;

import android.content.SharedPreferences;
import android.util.Pair;
import com.shield.android.ShieldCallback;
import com.shield.android.ShieldException;
import com.shield.android.e.f;
import com.shield.android.e.g;
import com.shield.android.e.g.C0020g;
import com.shield.android.e.j;
import org.jboss.netty.channel.socket.http.HttpTunnelingServlet;

public class c implements f {

    /* renamed from: a  reason: collision with root package name */
    public final j f1620a;

    /* renamed from: b  reason: collision with root package name */
    public final g f1621b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedPreferences f1622c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1623d = false;

    public c(j jVar, g gVar, SharedPreferences sharedPreferences, boolean z) {
        this.f1620a = jVar;
        this.f1621b = gVar;
        this.f1622c = sharedPreferences;
        this.f1623d = z;
    }

    public void a(ShieldCallback<Pair<String, String>> shieldCallback) {
        this.f1621b.a(this.f1620a, new f(shieldCallback) {
            public final /* synthetic */ ShieldCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void a(C0020g gVar) {
                
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: INVOKE  (wrap: com.shield.android.f.c
                      0x0000: IGET  (r0v0 com.shield.android.f.c) = (r2v0 'this' com.shield.android.f.-$$Lambda$c$kamc5pH-pWNez5vhtvPUjXQPFTo A[THIS]) com.shield.android.f.-$$Lambda$c$kamc5pH-pWNez5vhtvPUjXQPFTo.f$0 com.shield.android.f.c), (wrap: com.shield.android.ShieldCallback
                      0x0002: IGET  (r1v0 com.shield.android.ShieldCallback) = (r2v0 'this' com.shield.android.f.-$$Lambda$c$kamc5pH-pWNez5vhtvPUjXQPFTo A[THIS]) com.shield.android.f.-$$Lambda$c$kamc5pH-pWNez5vhtvPUjXQPFTo.f$1 com.shield.android.ShieldCallback), (r3v0 'gVar' com.shield.android.e.g$g) com.shield.android.f.c.lambda$kamc5pH-pWNez5vhtvPUjXQPFTo(com.shield.android.f.c, com.shield.android.ShieldCallback, com.shield.android.e.g$g):void type: STATIC in method: com.shield.android.f.-$$Lambda$c$kamc5pH-pWNez5vhtvPUjXQPFTo.a(com.shield.android.e.g$g):void, dex: classes4.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:241)
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
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
                    	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                    Caused by: java.util.ConcurrentModificationException
                    	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1685)
                    	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1660)
                    	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:86)
                    	at jadx.core.dex.instructions.args.SSAVar.use(SSAVar.java:79)
                    	at jadx.core.dex.nodes.InsnNode.attachArg(InsnNode.java:76)
                    	at jadx.core.dex.nodes.InsnNode.addArg(InsnNode.java:62)
                    	at jadx.core.dex.nodes.InsnNode.copyCommonParams(InsnNode.java:333)
                    	at jadx.core.dex.instructions.InvokeNode.copy(InvokeNode.java:56)
                    	at jadx.core.codegen.InsnGen.inlineMethod(InsnGen.java:884)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:665)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:353)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:235)
                    	... 35 more
                    */
                /*
                    this = this;
                    com.shield.android.f.c r0 = com.shield.android.f.c.this
                    com.shield.android.ShieldCallback r1 = r2.f$1
                    r0.a(r1, r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shield.android.f.$$Lambda$c$kamc5pHpWNez5vhtvPUjXQPFTo.a(com.shield.android.e.g$g):void");
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ShieldCallback shieldCallback, C0020g gVar) {
        try {
            if (gVar == C0020g.FINISHED) {
                j jVar = this.f1620a;
                ShieldException shieldException = jVar.f1611f;
                if (shieldException == null) {
                    boolean z = this.f1623d;
                    String str = z ? "fallback_endpoint" : HttpTunnelingServlet.ENDPOINT;
                    String str2 = z ? "fallback_version" : "version";
                    String string = jVar.f1609d.getString(HttpTunnelingServlet.ENDPOINT);
                    int optInt = this.f1620a.f1609d.optInt("version", 1);
                    if (!this.f1623d) {
                        this.f1622c.edit().putString(str, string).apply();
                        this.f1622c.edit().putString(str2, String.valueOf(optInt)).apply();
                    }
                    shieldCallback.onSuccess(new Pair(string, String.valueOf(optInt)));
                    return;
                }
                shieldCallback.onFailure(shieldException);
            }
        } catch (Exception e2) {
            shieldCallback.onFailure(ShieldException.unexpectedError(e2));
        }
    }
}
