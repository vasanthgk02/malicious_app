package com.freshchat.consumer.sdk.activity;

public class bm implements Runnable {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ int ss;

    public bm(ConversationDetailActivity conversationDetailActivity, int i) {
        this.be = conversationDetailActivity;
        this.ss = i;
    }

    public void run() {
        if (
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: INVOKE  (r0v1 android.widget.ProgressBar) = (wrap: com.freshchat.consumer.sdk.activity.ConversationDetailActivity
              0x0000: IGET  (r0v0 com.freshchat.consumer.sdk.activity.ConversationDetailActivity) = (r2v0 'this' com.freshchat.consumer.sdk.activity.bm A[THIS]) com.freshchat.consumer.sdk.activity.bm.be com.freshchat.consumer.sdk.activity.ConversationDetailActivity) com.freshchat.consumer.sdk.activity.ConversationDetailActivity.S(com.freshchat.consumer.sdk.activity.ConversationDetailActivity):android.widget.ProgressBar type: STATIC in method: com.freshchat.consumer.sdk.activity.bm.run():void, dex: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:241)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:129)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
            	at jadx.core.codegen.ConditionGen.wrap(ConditionGen.java:84)
            	at jadx.core.codegen.ConditionGen.addAndOr(ConditionGen.java:151)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:70)
            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
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
            Caused by: java.lang.ArrayIndexOutOfBoundsException: arraycopy: length -1 is negative
            	at java.base/java.lang.System.arraycopy(Native Method)
            	at java.base/java.util.ArrayList.shiftTailOverGap(ArrayList.java:746)
            	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1691)
            	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1660)
            	at jadx.core.dex.instructions.args.SSAVar.removeUse(SSAVar.java:86)
            	at jadx.core.dex.instructions.args.SSAVar.use(SSAVar.java:79)
            	at jadx.core.dex.nodes.InsnNode.attachArg(InsnNode.java:76)
            	at jadx.core.dex.nodes.InsnNode.addArg(InsnNode.java:62)
            	at jadx.core.dex.nodes.InsnNode.copyCommonParams(InsnNode.java:333)
            	at jadx.core.dex.instructions.IndexInsnNode.copy(IndexInsnNode.java:24)
            	at jadx.core.dex.instructions.IndexInsnNode.copy(IndexInsnNode.java:9)
            	at jadx.core.dex.nodes.InsnNode.copyCommonParams(InsnNode.java:331)
            	at jadx.core.dex.nodes.InsnNode.copy(InsnNode.java:350)
            	at jadx.core.codegen.InsnGen.inlineMethod(InsnGen.java:884)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:665)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:353)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:216)
            	... 24 more
            */
        /*
            this = this;
            com.freshchat.consumer.sdk.activity.ConversationDetailActivity r0 = r2.be
            android.widget.ProgressBar r0 = r0.aH
            if (r0 == 0) goto L_0x001f
            com.freshchat.consumer.sdk.activity.ConversationDetailActivity r0 = r2.be
            android.widget.ProgressBar r0 = r0.aH
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x001f
            com.freshchat.consumer.sdk.activity.ConversationDetailActivity r0 = r2.be
            android.widget.ProgressBar r0 = r0.aH
            int r1 = r2.ss
            r0.setProgress(r1)
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.activity.bm.run():void");
    }
}
