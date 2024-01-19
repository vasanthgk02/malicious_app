package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.CallAdapter.Factory;
import retrofit2.DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1;

public final class DefaultCallAdapterFactory extends Factory {
    public final Executor callbackExecutor;

    public static final class ExecutorCallbackCall<T> implements Call<T> {
        public final Executor callbackExecutor;
        public final Call<T> delegate;

        public ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        public void cancel() {
            this.delegate.cancel();
        }

        public Object clone() throws CloneNotSupportedException {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }

        public void enqueue(final Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.delegate.enqueue(new Callback<T>() {
                public /* synthetic */ void lambda$onFailure$1$DefaultCallAdapterFactory$ExecutorCallbackCall$1(Callback callback, Throwable th) {
                    callback.onFailure(ExecutorCallbackCall.this, th);
                }

                public /* synthetic */ void lambda$onResponse$0$DefaultCallAdapterFactory$ExecutorCallbackCall$1(Callback callback, Response response) {
                    if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                        callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                    } else {
                        callback.onResponse(ExecutorCallbackCall.this, response);
                    }
                }

                public void onFailure(Call<T> call, Throwable th) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable(this, callback, th) {
                        public final /* synthetic */ AnonymousClass1 f$0;
                        public final /* synthetic */ Callback f$1;
                        public final /* synthetic */ Throwable f$2;

                        public final 
/*
Method generation error in method: retrofit2.-$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$7JZMXmGMmuA6QMd5UmiN1rIhtW0.run():null, dex: classes5.dex
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
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
                        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                        
*/
                    });
                }

                public void onResponse(Call<T> call, Response<T> response) {
                    ExecutorCallbackCall.this.callbackExecutor.execute(new Runnable(this, callback, response) {
                        public final /* synthetic */ AnonymousClass1 f$0;
                        public final /* synthetic */ Callback f$1;
                        public final /* synthetic */ Response f$2;

                        public final 
/*
Method generation error in method: retrofit2.-$$Lambda$DefaultCallAdapterFactory$ExecutorCallbackCall$1$3wC8FyV4pyjrzrYL5U0mlYiviZw.run():null, dex: classes5.dex
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
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:32)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:20)
                        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                        
*/
                    });
                }
            });
        }

        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        public Request request() {
            return this.delegate.request();
        }

        /* renamed from: clone  reason: collision with other method in class */
        public Call<T> m1145clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }
    }

    public DefaultCallAdapterFactory(Executor executor) {
        this.callbackExecutor = executor;
    }

    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        final Executor executor = null;
        if (Utils.getRawType(type) != Call.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            final Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
            if (!Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class)) {
                executor = this.callbackExecutor;
            }
            return new CallAdapter<Object, Call<?>>(this) {
                public Object adapt(Call call) {
                    Executor executor = executor;
                    return executor == null ? call : new ExecutorCallbackCall(executor, call);
                }

                public Type responseType() {
                    return parameterUpperBound;
                }
            };
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
