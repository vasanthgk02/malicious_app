package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.j.bg.a;
import com.freshchat.consumer.sdk.j.bg.b;

public final class bw implements b {
    public final /* synthetic */ long fk;
    public final /* synthetic */ Context iI;
    public final /* synthetic */ boolean kJ;
    public final /* synthetic */ int nW;
    public final /* synthetic */ String nX;

    public bw(Context context, long j, boolean z, int i, String str) {
        this.iI = context;
        this.fk = j;
        this.kJ = z;
        this.nW = i;
        this.nX = str;
    }

    public Event gy() {
        a b2 = bg.a(EventName.FCEventCsatSubmit);
        Channel m = bg.j(this.iI, this.fk);
        if (m != null) {
            
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0020: INVOKE  (wrap: com.freshchat.consumer.sdk.j.bg$a
                  0x0016: INVOKE  (r2v4 com.freshchat.consumer.sdk.j.bg$a) = (r0v1 'b2' com.freshchat.consumer.sdk.j.bg$a), (wrap: com.freshchat.consumer.sdk.Event$Property
                  0x0010: SGET  (r2v3 com.freshchat.consumer.sdk.Event$Property) =  com.freshchat.consumer.sdk.Event.Property.FCPropertyChannelID com.freshchat.consumer.sdk.Event$Property), (wrap: java.lang.String
                  0x0012: INVOKE  (r3v0 java.lang.String) = (r1v1 'm' com.freshchat.consumer.sdk.beans.Channel) com.freshchat.consumer.sdk.beans.Channel.getChannelAlias():java.lang.String type: VIRTUAL) com.freshchat.consumer.sdk.j.bg.a.a(com.freshchat.consumer.sdk.j.bg$a, com.freshchat.consumer.sdk.Event$Property, java.lang.Object):com.freshchat.consumer.sdk.j.bg$a type: STATIC), (wrap: com.freshchat.consumer.sdk.Event$Property
                  0x001a: SGET  (r3v1 com.freshchat.consumer.sdk.Event$Property) =  com.freshchat.consumer.sdk.Event.Property.FCPropertyChannelName com.freshchat.consumer.sdk.Event$Property), (wrap: java.lang.String
                  0x001c: INVOKE  (r4v0 java.lang.String) = (r1v1 'm' com.freshchat.consumer.sdk.beans.Channel) com.freshchat.consumer.sdk.beans.Channel.getName():java.lang.String type: VIRTUAL) com.freshchat.consumer.sdk.j.bg.a.a(com.freshchat.consumer.sdk.j.bg$a, com.freshchat.consumer.sdk.Event$Property, java.lang.Object):com.freshchat.consumer.sdk.j.bg$a type: STATIC in method: com.freshchat.consumer.sdk.j.bw.gy():com.freshchat.consumer.sdk.Event, dex: classes3.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:241)
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
                	at jadx.core.utils.InsnRemover.unbindArgUsage(InsnRemover.java:141)
                	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:119)
                	at jadx.core.dex.nodes.InsnNode.replaceArg(InsnNode.java:123)
                	at jadx.core.codegen.InsnGen.inlineMethod(InsnGen.java:896)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:665)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:353)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:235)
                	... 21 more
                */
            /*
                this = this;
                com.freshchat.consumer.sdk.Event$EventName r0 = com.freshchat.consumer.sdk.Event.EventName.FCEventCsatSubmit
                com.freshchat.consumer.sdk.j.bg$a r0 = com.freshchat.consumer.sdk.j.bg.a(r0)
                android.content.Context r1 = r5.iI
                long r2 = r5.fk
                com.freshchat.consumer.sdk.beans.Channel r1 = com.freshchat.consumer.sdk.j.bg.j(r1, r2)
                if (r1 == 0) goto L_0x0048
                com.freshchat.consumer.sdk.Event$Property r2 = com.freshchat.consumer.sdk.Event.Property.FCPropertyChannelID
                java.lang.String r3 = r1.getChannelAlias()
                com.freshchat.consumer.sdk.j.bg$a r2 = r0.a(r2, r3)
                com.freshchat.consumer.sdk.Event$Property r3 = com.freshchat.consumer.sdk.Event.Property.FCPropertyChannelName
                java.lang.String r4 = r1.getName()
                r2.a(r3, r4)
                android.content.Context r2 = r5.iI
                long r3 = r1.getId()
                com.freshchat.consumer.sdk.beans.Conversation r1 = com.freshchat.consumer.sdk.j.bg.c(r2, r3)
                if (r1 == 0) goto L_0x0048
                com.freshchat.consumer.sdk.Event$Property r2 = com.freshchat.consumer.sdk.Event.Property.FCPropertyConversationID
                long r3 = r1.getConversationId()
                java.lang.Long r1 = java.lang.Long.valueOf(r3)
                com.freshchat.consumer.sdk.j.bg$a r1 = r0.a(r2, r1)
                com.freshchat.consumer.sdk.Event$Property r2 = com.freshchat.consumer.sdk.Event.Property.FCPropertyResolutionStatus
                boolean r3 = r5.kJ
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
                r1.a(r2, r3)
            L_0x0048:
                int r1 = r5.nW
                if (r1 <= 0) goto L_0x0055
                com.freshchat.consumer.sdk.Event$Property r2 = com.freshchat.consumer.sdk.Event.Property.FCPropertyRating
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r0.a(r2, r1)
            L_0x0055:
                java.lang.String r1 = r5.nX
                boolean r1 = com.freshchat.consumer.sdk.j.as.a(r1)
                if (r1 == 0) goto L_0x0064
                com.freshchat.consumer.sdk.Event$Property r1 = com.freshchat.consumer.sdk.Event.Property.FCPropertyComment
                java.lang.String r2 = r5.nX
                r0.a(r1, r2)
            L_0x0064:
                com.freshchat.consumer.sdk.Event r0 = r0.gz()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.bw.gy():com.freshchat.consumer.sdk.Event");
        }
    }
