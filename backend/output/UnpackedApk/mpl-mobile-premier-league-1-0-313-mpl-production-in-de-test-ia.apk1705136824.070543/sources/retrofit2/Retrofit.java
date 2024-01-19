package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.BuiltInConverters.ToStringConverter;
import retrofit2.CallAdapter.Factory;

public final class Retrofit {
    public final HttpUrl baseUrl;
    public final List<Factory> callAdapterFactories;
    public final Call.Factory callFactory;
    public final List<Converter.Factory> converterFactories;
    public final Map<Method, ServiceMethod<?>> serviceMethodCache = new ConcurrentHashMap();
    public final boolean validateEagerly;

    public static final class Builder {
        public HttpUrl baseUrl;
        public final List<Factory> callAdapterFactories = new ArrayList();
        public Call.Factory callFactory;
        public final List<Converter.Factory> converterFactories = new ArrayList();
        public final Platform platform;

        public Builder() {
            Platform platform2 = Platform.PLATFORM;
            this.platform = platform2;
        }

        public Builder addConverterFactory(Converter.Factory factory) {
            this.converterFactories.add((Converter.Factory) Objects.requireNonNull(factory, "factory == null"));
            return this;
        }

        public Builder baseUrl(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            HttpUrl httpUrl = HttpUrl.get(str);
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            List<String> pathSegments = httpUrl.pathSegments();
            if ("".equals(pathSegments.get(pathSegments.size() - 1))) {
                this.baseUrl = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public Retrofit build() {
            List list;
            if (this.baseUrl != null) {
                Call.Factory factory = this.callFactory;
                if (factory == null) {
                    factory = new OkHttpClient();
                }
                Call.Factory factory2 = factory;
                Executor defaultCallbackExecutor = this.platform.defaultCallbackExecutor();
                ArrayList arrayList = new ArrayList(this.callAdapterFactories);
                Platform platform2 = this.platform;
                DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(defaultCallbackExecutor);
                if (platform2.hasJava8Types) {
                    list = Arrays.asList(new Factory[]{CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory});
                } else {
                    list = Collections.singletonList(defaultCallAdapterFactory);
                }
                arrayList.addAll(list);
                ArrayList arrayList2 = new ArrayList(this.converterFactories.size() + 1 + (this.platform.hasJava8Types ? 1 : 0));
                arrayList2.add(new BuiltInConverters());
                arrayList2.addAll(this.converterFactories);
                arrayList2.addAll(this.platform.hasJava8Types ? Collections.singletonList(OptionalConverterFactory.INSTANCE) : Collections.emptyList());
                Retrofit retrofit = new Retrofit(factory2, this.baseUrl, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), defaultCallbackExecutor, false);
                return retrofit;
            }
            throw new IllegalStateException("Base URL required.");
        }

        public Builder client(OkHttpClient okHttpClient) {
            this.callFactory = (Call.Factory) Objects.requireNonNull((Call.Factory) Objects.requireNonNull(okHttpClient, "client == null"), "factory == null");
            return this;
        }
    }

    public Retrofit(Call.Factory factory, HttpUrl httpUrl, List<Converter.Factory> list, List<Factory> list2, Executor executor, boolean z) {
        this.callFactory = factory;
        this.baseUrl = httpUrl;
        this.converterFactories = list;
        this.callAdapterFactories = list2;
        this.validateEagerly = z;
    }

    public CallAdapter<?, ?> callAdapter(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.callAdapterFactories.indexOf(null) + 1;
        int size = this.callAdapterFactories.size();
        for (int i = indexOf; i < size; i++) {
            CallAdapter<?, ?> callAdapter = this.callAdapterFactories.get(i).get(type, annotationArr, this);
            if (callAdapter != null) {
                return callAdapter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.callAdapterFactories.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.callAdapterFactories.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> T create(final Class<T> cls) {
        if (cls.isInterface()) {
            ArrayDeque arrayDeque = new ArrayDeque(1);
            arrayDeque.add(cls);
            while (!arrayDeque.isEmpty()) {
                Class<T> cls2 = (Class) arrayDeque.removeFirst();
                if (cls2.getTypeParameters().length != 0) {
                    StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                    sb.append(cls2.getName());
                    if (cls2 != cls) {
                        sb.append(" which is an interface of ");
                        sb.append(cls.getName());
                    }
                    throw new IllegalArgumentException(sb.toString());
                }
                Collections.addAll(arrayDeque, cls2.getInterfaces());
            }
            if (this.validateEagerly) {
                Platform platform = Platform.PLATFORM;
                for (Method method : cls.getDeclaredMethods()) {
                    if (!(platform.hasJava8Types && method.isDefault()) && !Modifier.isStatic(method.getModifiers())) {
                        loadServiceMethod(method);
                    }
                }
            }
            return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                public final Object[] emptyArgs = new Object[0];
                public final Platform platform = Platform.PLATFORM;

                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    Object obj2;
                    if (method.getDeclaringClass() == Object.class) {
                        return method.invoke(this, objArr);
                    }
                    if (objArr == null) {
                        objArr = this.emptyArgs;
                    }
                    if (this.platform.hasJava8Types && method.isDefault()) {
                        obj2 = this.platform.invokeDefaultMethod(method, cls, obj, objArr);
                    } else {
                        HttpServiceMethod httpServiceMethod = (HttpServiceMethod) Retrofit.this.loadServiceMethod(method);
                        obj2 = httpServiceMethod.adapt(new OkHttpCall(httpServiceMethod.requestFactory, objArr, httpServiceMethod.callFactory, httpServiceMethod.responseConverter), objArr);
                    }
                    return obj2;
                }
            });
        }
        throw new IllegalArgumentException("API declarations must be interfaces.");
    }

    public ServiceMethod<?> loadServiceMethod(Method method) {
        ServiceMethod<?> serviceMethod;
        ServiceMethod<?> serviceMethod2 = this.serviceMethodCache.get(method);
        if (serviceMethod2 != null) {
            return serviceMethod2;
        }
        synchronized (this.serviceMethodCache) {
            serviceMethod = this.serviceMethodCache.get(method);
            if (serviceMethod == null) {
                serviceMethod = ServiceMethod.parseAnnotations(this, method);
                this.serviceMethodCache.put(method, serviceMethod);
            }
        }
        return serviceMethod;
    }

    public <T> Converter<T, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.converterFactories.indexOf(null) + 1;
        int size = this.converterFactories.size();
        for (int i = indexOf; i < size; i++) {
            Converter<?, RequestBody> requestBodyConverter = this.converterFactories.get(i).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (requestBodyConverter != null) {
                return requestBodyConverter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.converterFactories.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.converterFactories.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> Converter<ResponseBody, T> responseBodyConverter(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.converterFactories.indexOf(null) + 1;
        int size = this.converterFactories.size();
        for (int i = indexOf; i < size; i++) {
            Converter<ResponseBody, ?> responseBodyConverter = this.converterFactories.get(i).responseBodyConverter(type, annotationArr, this);
            if (responseBodyConverter != null) {
                return responseBodyConverter;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.converterFactories.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.converterFactories.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> Converter<T, String> stringConverter(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.converterFactories.size();
        int i = 0;
        while (i < size) {
            if (this.converterFactories.get(i) != null) {
                i++;
            } else {
                throw null;
            }
        }
        return ToStringConverter.INSTANCE;
    }
}
