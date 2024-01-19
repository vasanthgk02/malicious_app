package io.sentry;

import io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForget;
import io.sentry.util.Objects;
import java.io.File;

public final class SendCachedEnvelopeFireAndForgetIntegration implements Integration {
    public final SendFireAndForgetFactory factory;

    public interface SendFireAndForget {
        void send();
    }

    public interface SendFireAndForgetDirPath {
        String getDirPath();
    }

    public interface SendFireAndForgetFactory {

        /* renamed from: io.sentry.SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static boolean $default$hasValidPath(SendFireAndForgetFactory _this, String str, ILogger iLogger) {
                if (str != null && !str.isEmpty()) {
                    return true;
                }
                iLogger.log(SentryLevel.INFO, (String) "No cached dir path is defined in options.", new Object[0]);
                return false;
            }

            public static SendFireAndForget $default$processDir(SendFireAndForgetFactory _this, DirectoryProcessor directoryProcessor, String str, ILogger iLogger) {
                return new SendFireAndForget(iLogger, str, directoryProcessor, new File(str)) {
                    public final /* synthetic */ ILogger f$0;
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ DirectoryProcessor f$2;
                    public final /* synthetic */ File f$3;

                    public final 
/*
Method generation error in method: io.sentry.-$$Lambda$SendCachedEnvelopeFireAndForgetIntegration$SendFireAndForgetFactory$fw_M6vxYehvhSeLyExDmpVukEZU.send():null, dex: classes5.dex
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
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:299)
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
                };
            }

            public static /* synthetic */ void lambda$processDir$0(ILogger iLogger, String str, DirectoryProcessor directoryProcessor, File file) {
                iLogger.log(SentryLevel.DEBUG, (String) "Started processing cached files from %s", str);
                directoryProcessor.processDirectory(file);
                iLogger.log(SentryLevel.DEBUG, (String) "Finished processing cached files from %s", str);
            }
        }

        SendFireAndForget create(IHub iHub, SentryOptions sentryOptions);

        boolean hasValidPath(String str, ILogger iLogger);

        SendFireAndForget processDir(DirectoryProcessor directoryProcessor, String str, ILogger iLogger);
    }

    public SendCachedEnvelopeFireAndForgetIntegration(SendFireAndForgetFactory sendFireAndForgetFactory) {
        this.factory = (SendFireAndForgetFactory) Objects.requireNonNull(sendFireAndForgetFactory, "SendFireAndForgetFactory is required");
    }

    public static /* synthetic */ void lambda$register$0(SendFireAndForget sendFireAndForget, SentryOptions sentryOptions) {
        try {
            sendFireAndForget.send();
        } catch (Exception e2) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, (String) "Failed trying to send cached events.", (Throwable) e2);
        }
    }

    public final void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        if (!this.factory.hasValidPath(sentryOptions.getCacheDirPath(), sentryOptions.getLogger())) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, (String) "No cache dir path is defined in options.", new Object[0]);
            return;
        }
        SendFireAndForget create = this.factory.create(iHub, sentryOptions);
        if (create == null) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, (String) "SendFireAndForget factory is null.", new Object[0]);
            return;
        }
        try {
            sentryOptions.getExecutorService().submit(new Runnable(sentryOptions) {
                public final /* synthetic */ SentryOptions f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    SendCachedEnvelopeFireAndForgetIntegration.lambda$register$0(SendFireAndForget.this, this.f$1);
                }
            });
            sentryOptions.getLogger().log(SentryLevel.DEBUG, (String) "SendCachedEventFireAndForgetIntegration installed.", new Object[0]);
        } catch (Exception e2) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, (String) "Failed to call the executor. Cached events will not be sent", (Throwable) e2);
        }
    }
}
