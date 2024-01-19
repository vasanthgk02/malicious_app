package retrofit2;

public abstract class ServiceMethod<T> {
    /* JADX WARNING: type inference failed for: r6v14, types: [retrofit2.ParameterHandler<?>[]] */
    /* JADX WARNING: type inference failed for: r17v0 */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r17v3 */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r17v5 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r17v7 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r3v17 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r3v20 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r3v21 */
    /* JADX WARNING: type inference failed for: r3v22 */
    /* JADX WARNING: type inference failed for: r3v27, types: [retrofit2.ParameterHandler$Body] */
    /* JADX WARNING: type inference failed for: r3v38, types: [retrofit2.ParameterHandler$PartMap] */
    /* JADX WARNING: type inference failed for: r4v31, types: [retrofit2.ParameterHandler$Part] */
    /* JADX WARNING: type inference failed for: r3v52, types: [retrofit2.ParameterHandler$2] */
    /* JADX WARNING: type inference failed for: r3v58, types: [retrofit2.ParameterHandler$1] */
    /* JADX WARNING: type inference failed for: r4v40, types: [retrofit2.ParameterHandler$RawPart] */
    /* JADX WARNING: type inference failed for: r8v27, types: [retrofit2.ParameterHandler$2] */
    /* JADX WARNING: type inference failed for: r8v28, types: [retrofit2.ParameterHandler$1] */
    /* JADX WARNING: type inference failed for: r9v9, types: [retrofit2.ParameterHandler$FieldMap] */
    /* JADX WARNING: type inference failed for: r10v16, types: [retrofit2.ParameterHandler$Field] */
    /* JADX WARNING: type inference failed for: r4v59, types: [retrofit2.ParameterHandler$2] */
    /* JADX WARNING: type inference failed for: r4v60, types: [retrofit2.ParameterHandler$1] */
    /* JADX WARNING: type inference failed for: r8v41, types: [retrofit2.ParameterHandler$HeaderMap] */
    /* JADX WARNING: type inference failed for: r4v67, types: [retrofit2.ParameterHandler$Headers] */
    /* JADX WARNING: type inference failed for: r9v25, types: [retrofit2.ParameterHandler$Header] */
    /* JADX WARNING: type inference failed for: r4v69, types: [retrofit2.ParameterHandler$2] */
    /* JADX WARNING: type inference failed for: r4v70, types: [retrofit2.ParameterHandler$1] */
    /* JADX WARNING: type inference failed for: r9v33, types: [retrofit2.ParameterHandler$QueryMap] */
    /* JADX WARNING: type inference failed for: r9v34 */
    /* JADX WARNING: type inference failed for: r3v59 */
    /* JADX WARNING: type inference failed for: r9v39, types: [retrofit2.ParameterHandler$QueryName] */
    /* JADX WARNING: type inference failed for: r4v77, types: [retrofit2.ParameterHandler$2] */
    /* JADX WARNING: type inference failed for: r4v78, types: [retrofit2.ParameterHandler$1] */
    /* JADX WARNING: type inference failed for: r10v29, types: [retrofit2.ParameterHandler$Query] */
    /* JADX WARNING: type inference failed for: r4v80, types: [retrofit2.ParameterHandler$2] */
    /* JADX WARNING: type inference failed for: r4v81, types: [retrofit2.ParameterHandler$1] */
    /* JADX WARNING: type inference failed for: r8v70, types: [retrofit2.ParameterHandler$Path] */
    /* JADX WARNING: type inference failed for: r3v80, types: [retrofit2.ParameterHandler$RelativeUrl] */
    /* JADX WARNING: type inference failed for: r17v8 */
    /* JADX WARNING: type inference failed for: r17v9 */
    /* JADX WARNING: type inference failed for: r17v10 */
    /* JADX WARNING: type inference failed for: r17v11 */
    /* JADX WARNING: type inference failed for: r17v12 */
    /* JADX WARNING: type inference failed for: r17v13 */
    /* JADX WARNING: type inference failed for: r4v85 */
    /* JADX WARNING: type inference failed for: r3v89 */
    /* JADX WARNING: type inference failed for: r3v90 */
    /* JADX WARNING: type inference failed for: r3v91 */
    /* JADX WARNING: type inference failed for: r4v86 */
    /* JADX WARNING: type inference failed for: r3v92 */
    /* JADX WARNING: type inference failed for: r3v93 */
    /* JADX WARNING: type inference failed for: r4v87 */
    /* JADX WARNING: type inference failed for: r8v80 */
    /* JADX WARNING: type inference failed for: r8v81 */
    /* JADX WARNING: type inference failed for: r9v77 */
    /* JADX WARNING: type inference failed for: r10v42 */
    /* JADX WARNING: type inference failed for: r4v88 */
    /* JADX WARNING: type inference failed for: r4v89 */
    /* JADX WARNING: type inference failed for: r8v82 */
    /* JADX WARNING: type inference failed for: r4v90 */
    /* JADX WARNING: type inference failed for: r9v78 */
    /* JADX WARNING: type inference failed for: r4v91 */
    /* JADX WARNING: type inference failed for: r4v92 */
    /* JADX WARNING: type inference failed for: r9v79 */
    /* JADX WARNING: type inference failed for: r9v80 */
    /* JADX WARNING: type inference failed for: r4v93 */
    /* JADX WARNING: type inference failed for: r4v94 */
    /* JADX WARNING: type inference failed for: r10v43 */
    /* JADX WARNING: type inference failed for: r4v95 */
    /* JADX WARNING: type inference failed for: r4v96 */
    /* JADX WARNING: type inference failed for: r8v83, types: [retrofit2.ParameterHandler$Path] */
    /* JADX WARNING: type inference failed for: r3v94 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r17v6
      assigns: []
      uses: []
      mth insns count: 983
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 12 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> retrofit2.ServiceMethod<T> parseAnnotations(retrofit2.Retrofit r23, java.lang.reflect.Method r24) {
        /*
            r0 = r23
            r1 = r24
            retrofit2.RequestFactory$Builder r2 = new retrofit2.RequestFactory$Builder
            r2.<init>(r0, r1)
            java.lang.annotation.Annotation[] r3 = r2.methodAnnotations
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L_0x000e:
            java.lang.String r7 = "HEAD"
            r8 = 1
            if (r6 >= r4) goto L_0x0149
            r9 = r3[r6]
            boolean r10 = r9 instanceof retrofit2.http.DELETE
            if (r10 == 0) goto L_0x0026
            retrofit2.http.DELETE r9 = (retrofit2.http.DELETE) r9
            java.lang.String r7 = r9.value()
            java.lang.String r8 = "DELETE"
            r2.parseHttpMethodAndPath(r8, r7, r5)
            goto L_0x0145
        L_0x0026:
            boolean r10 = r9 instanceof retrofit2.http.GET
            if (r10 == 0) goto L_0x0037
            retrofit2.http.GET r9 = (retrofit2.http.GET) r9
            java.lang.String r7 = r9.value()
            java.lang.String r8 = "GET"
            r2.parseHttpMethodAndPath(r8, r7, r5)
            goto L_0x0145
        L_0x0037:
            boolean r10 = r9 instanceof retrofit2.http.HEAD
            if (r10 == 0) goto L_0x0046
            retrofit2.http.HEAD r9 = (retrofit2.http.HEAD) r9
            java.lang.String r8 = r9.value()
            r2.parseHttpMethodAndPath(r7, r8, r5)
            goto L_0x0145
        L_0x0046:
            boolean r7 = r9 instanceof retrofit2.http.PATCH
            if (r7 == 0) goto L_0x0057
            retrofit2.http.PATCH r9 = (retrofit2.http.PATCH) r9
            java.lang.String r7 = r9.value()
            java.lang.String r9 = "PATCH"
            r2.parseHttpMethodAndPath(r9, r7, r8)
            goto L_0x0145
        L_0x0057:
            boolean r7 = r9 instanceof retrofit2.http.POST
            if (r7 == 0) goto L_0x0068
            retrofit2.http.POST r9 = (retrofit2.http.POST) r9
            java.lang.String r7 = r9.value()
            java.lang.String r9 = "POST"
            r2.parseHttpMethodAndPath(r9, r7, r8)
            goto L_0x0145
        L_0x0068:
            boolean r7 = r9 instanceof retrofit2.http.PUT
            if (r7 == 0) goto L_0x0079
            retrofit2.http.PUT r9 = (retrofit2.http.PUT) r9
            java.lang.String r7 = r9.value()
            java.lang.String r9 = "PUT"
            r2.parseHttpMethodAndPath(r9, r7, r8)
            goto L_0x0145
        L_0x0079:
            boolean r7 = r9 instanceof retrofit2.http.OPTIONS
            if (r7 == 0) goto L_0x008a
            retrofit2.http.OPTIONS r9 = (retrofit2.http.OPTIONS) r9
            java.lang.String r7 = r9.value()
            java.lang.String r8 = "OPTIONS"
            r2.parseHttpMethodAndPath(r8, r7, r5)
            goto L_0x0145
        L_0x008a:
            boolean r7 = r9 instanceof retrofit2.http.HTTP
            if (r7 == 0) goto L_0x00a1
            retrofit2.http.HTTP r9 = (retrofit2.http.HTTP) r9
            java.lang.String r7 = r9.method()
            java.lang.String r8 = r9.path()
            boolean r9 = r9.hasBody()
            r2.parseHttpMethodAndPath(r7, r8, r9)
            goto L_0x0145
        L_0x00a1:
            boolean r7 = r9 instanceof retrofit2.http.Headers
            if (r7 == 0) goto L_0x011b
            retrofit2.http.Headers r9 = (retrofit2.http.Headers) r9
            java.lang.String[] r7 = r9.value()
            int r9 = r7.length
            if (r9 == 0) goto L_0x0110
            okhttp3.Headers$Builder r9 = new okhttp3.Headers$Builder
            r9.<init>()
            int r10 = r7.length
            r11 = 0
        L_0x00b5:
            if (r11 >= r10) goto L_0x0109
            r12 = r7[r11]
            r13 = 58
            int r13 = r12.indexOf(r13)
            r14 = -1
            if (r13 == r14) goto L_0x00fc
            if (r13 == 0) goto L_0x00fc
            int r14 = r12.length()
            int r14 = r14 - r8
            if (r13 == r14) goto L_0x00fc
            java.lang.String r14 = r12.substring(r5, r13)
            int r13 = r13 + 1
            java.lang.String r12 = r12.substring(r13)
            java.lang.String r12 = r12.trim()
            java.lang.String r13 = "Content-Type"
            boolean r13 = r13.equalsIgnoreCase(r14)
            if (r13 == 0) goto L_0x00f6
            okhttp3.MediaType r13 = okhttp3.MediaType.get(r12)     // Catch:{ IllegalArgumentException -> 0x00e8 }
            r2.contentType = r13     // Catch:{ IllegalArgumentException -> 0x00e8 }
            goto L_0x00f9
        L_0x00e8:
            r0 = move-exception
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r2 = new java.lang.Object[r8]
            r2[r5] = r12
            java.lang.String r3 = "Malformed content type: %s"
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r1, r0, r3, r2)
            throw r0
        L_0x00f6:
            r9.add(r14, r12)
        L_0x00f9:
            int r11 = r11 + 1
            goto L_0x00b5
        L_0x00fc:
            java.lang.reflect.Method r0 = r2.method
            java.lang.Object[] r1 = new java.lang.Object[r8]
            r1[r5] = r12
            java.lang.String r2 = "@Headers value must be in the form \"Name: Value\". Found: \"%s\""
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r0, r2, r1)
            throw r0
        L_0x0109:
            okhttp3.Headers r7 = r9.build()
            r2.headers = r7
            goto L_0x0145
        L_0x0110:
            java.lang.reflect.Method r0 = r2.method
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "@Headers annotation is empty."
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r0, r2, r1)
            throw r0
        L_0x011b:
            boolean r7 = r9 instanceof retrofit2.http.Multipart
            java.lang.String r10 = "Only one encoding annotation is allowed."
            if (r7 == 0) goto L_0x0131
            boolean r7 = r2.isFormEncoded
            if (r7 != 0) goto L_0x0128
            r2.isMultipart = r8
            goto L_0x0145
        L_0x0128:
            java.lang.reflect.Method r0 = r2.method
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r0, r10, r1)
            throw r0
        L_0x0131:
            boolean r7 = r9 instanceof retrofit2.http.FormUrlEncoded
            if (r7 == 0) goto L_0x0145
            boolean r7 = r2.isMultipart
            if (r7 != 0) goto L_0x013c
            r2.isFormEncoded = r8
            goto L_0x0145
        L_0x013c:
            java.lang.reflect.Method r0 = r2.method
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r0, r10, r1)
            throw r0
        L_0x0145:
            int r6 = r6 + 1
            goto L_0x000e
        L_0x0149:
            java.lang.String r3 = r2.httpMethod
            if (r3 == 0) goto L_0x0aa3
            boolean r3 = r2.hasBody
            if (r3 != 0) goto L_0x0170
            boolean r3 = r2.isMultipart
            if (r3 != 0) goto L_0x0165
            boolean r3 = r2.isFormEncoded
            if (r3 != 0) goto L_0x015a
            goto L_0x0170
        L_0x015a:
            java.lang.reflect.Method r0 = r2.method
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST)."
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r0, r2, r1)
            throw r0
        L_0x0165:
            java.lang.reflect.Method r0 = r2.method
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "Multipart can only be specified on HTTP methods with request body (e.g., @POST)."
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r0, r2, r1)
            throw r0
        L_0x0170:
            java.lang.annotation.Annotation[][] r3 = r2.parameterAnnotationsArray
            int r3 = r3.length
            retrofit2.ParameterHandler[] r4 = new retrofit2.ParameterHandler[r3]
            r2.parameterHandlers = r4
            int r4 = r3 + -1
            r5 = 0
        L_0x017a:
            if (r5 >= r3) goto L_0x090f
            retrofit2.ParameterHandler<?>[] r6 = r2.parameterHandlers
            java.lang.reflect.Type[] r8 = r2.parameterTypes
            r14 = r8[r5]
            java.lang.annotation.Annotation[][] r8 = r2.parameterAnnotationsArray
            r15 = r8[r5]
            if (r5 != r4) goto L_0x018c
            r8 = 1
            r16 = 1
            goto L_0x018f
        L_0x018c:
            r8 = 0
            r16 = 0
        L_0x018f:
            if (r15 == 0) goto L_0x08df
            int r13 = r15.length
            r8 = 0
            r9 = 0
            r17 = r9
            r12 = 0
        L_0x0197:
            if (r12 >= r13) goto L_0x08da
            r8 = r15[r12]
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            java.lang.Class<okhttp3.MultipartBody$Part> r10 = okhttp3.MultipartBody.Part.class
            boolean r11 = r8 instanceof retrofit2.http.Url
            r18 = r3
            java.lang.String r3 = "@Path parameters may not be used with @Url."
            if (r11 == 0) goto L_0x0249
            r2.validateResolvableType(r5, r14)
            boolean r8 = r2.gotUrl
            if (r8 != 0) goto L_0x023d
            boolean r8 = r2.gotPath
            if (r8 != 0) goto L_0x0233
            boolean r3 = r2.gotQuery
            if (r3 != 0) goto L_0x0227
            boolean r3 = r2.gotQueryName
            if (r3 != 0) goto L_0x021b
            boolean r3 = r2.gotQueryMap
            if (r3 != 0) goto L_0x020f
            java.lang.String r3 = r2.relativeUrl
            if (r3 != 0) goto L_0x01fe
            r3 = 1
            r2.gotUrl = r3
            java.lang.Class<okhttp3.HttpUrl> r3 = okhttp3.HttpUrl.class
            if (r14 == r3) goto L_0x01ef
            if (r14 == r9) goto L_0x01ef
            java.lang.Class<java.net.URI> r3 = java.net.URI.class
            if (r14 == r3) goto L_0x01ef
            boolean r3 = r14 instanceof java.lang.Class
            if (r3 == 0) goto L_0x01e3
            r3 = r14
            java.lang.Class r3 = (java.lang.Class) r3
            java.lang.String r3 = r3.getName()
            java.lang.String r8 = "android.net.Uri"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x01e3
            goto L_0x01ef
        L_0x01e3:
            java.lang.reflect.Method r0 = r2.method
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r2, r1)
            throw r0
        L_0x01ef:
            retrofit2.ParameterHandler$RelativeUrl r3 = new retrofit2.ParameterHandler$RelativeUrl
            java.lang.reflect.Method r8 = r2.method
            r3.<init>(r8, r5)
            r19 = r4
            r21 = r12
            r20 = r13
            goto L_0x08bb
        L_0x01fe:
            java.lang.reflect.Method r0 = r2.method
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r2.httpMethod
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "@Url cannot be used with @%s URL"
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r2, r1)
            throw r0
        L_0x020f:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "A @Url parameter must not come after a @QueryMap."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x021b:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "A @Url parameter must not come after a @QueryName."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x0227:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "A @Url parameter must not come after a @Query."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x0233:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r3, r0)
            throw r0
        L_0x023d:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "Multiple @Url method annotations found."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x0249:
            boolean r11 = r8 instanceof retrofit2.http.Path
            r19 = r4
            r4 = 2
            if (r11 == 0) goto L_0x0308
            r2.validateResolvableType(r5, r14)
            boolean r9 = r2.gotQuery
            if (r9 != 0) goto L_0x02fc
            boolean r9 = r2.gotQueryName
            if (r9 != 0) goto L_0x02f0
            boolean r9 = r2.gotQueryMap
            if (r9 != 0) goto L_0x02e4
            boolean r9 = r2.gotUrl
            if (r9 != 0) goto L_0x02da
            java.lang.String r3 = r2.relativeUrl
            if (r3 == 0) goto L_0x02c9
            r3 = 1
            r2.gotPath = r3
            retrofit2.http.Path r8 = (retrofit2.http.Path) r8
            java.lang.String r11 = r8.value()
            java.util.regex.Pattern r3 = retrofit2.RequestFactory.Builder.PARAM_NAME_REGEX
            java.util.regex.Matcher r3 = r3.matcher(r11)
            boolean r3 = r3.matches()
            if (r3 == 0) goto L_0x02b2
            java.util.Set<java.lang.String> r3 = r2.relativeUrlParamNames
            boolean r3 = r3.contains(r11)
            if (r3 == 0) goto L_0x029f
            retrofit2.Retrofit r3 = r2.retrofit
            retrofit2.Converter r3 = r3.stringConverter(r14, r15)
            retrofit2.ParameterHandler$Path r4 = new retrofit2.ParameterHandler$Path
            java.lang.reflect.Method r9 = r2.method
            boolean r20 = r8.encoded()
            r8 = r4
            r10 = r5
            r21 = r12
            r12 = r3
            r3 = r13
            r13 = r20
            r8.<init>(r9, r10, r11, r12, r13)
            goto L_0x06f1
        L_0x029f:
            java.lang.reflect.Method r0 = r2.method
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r2 = r2.relativeUrl
            r3 = 0
            r1[r3] = r2
            r2 = 1
            r1[r2] = r11
            java.lang.String r2 = "URL \"%s\" does not contain \"{%s}\"."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r2, r1)
            throw r0
        L_0x02b2:
            r0 = 0
            r1 = 1
            java.lang.reflect.Method r2 = r2.method
            java.lang.Object[] r3 = new java.lang.Object[r4]
            java.util.regex.Pattern r4 = retrofit2.RequestFactory.Builder.PARAM_URL_REGEX
            java.lang.String r4 = r4.pattern()
            r3[r0] = r4
            r3[r1] = r11
            java.lang.String r0 = "@Path parameter name must match %s. Found: %s"
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r2, r5, r0, r3)
            throw r0
        L_0x02c9:
            r0 = 0
            r1 = 1
            java.lang.reflect.Method r3 = r2.method
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r2.httpMethod
            r1[r0] = r2
            java.lang.String r0 = "@Path can only be used with relative url on @%s"
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r3, r5, r0, r1)
            throw r0
        L_0x02da:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r3, r0)
            throw r0
        L_0x02e4:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "A @Path parameter must not come after a @QueryMap."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x02f0:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "A @Path parameter must not come after a @QueryName."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x02fc:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "A @Path parameter must not come after a @Query."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x0308:
            r21 = r12
            r3 = r13
            boolean r4 = r8 instanceof retrofit2.http.Query
            java.lang.String r11 = "<String>)"
            java.lang.String r12 = " must include generic type (e.g., "
            if (r4 == 0) goto L_0x038d
            r2.validateResolvableType(r5, r14)
            retrofit2.http.Query r8 = (retrofit2.http.Query) r8
            java.lang.String r4 = r8.value()
            boolean r8 = r8.encoded()
            java.lang.Class r9 = retrofit2.Utils.getRawType(r14)
            r10 = 1
            r2.gotQuery = r10
            java.lang.Class<java.lang.Iterable> r10 = java.lang.Iterable.class
            boolean r10 = r10.isAssignableFrom(r9)
            if (r10 == 0) goto L_0x0360
            boolean r10 = r14 instanceof java.lang.reflect.ParameterizedType
            if (r10 == 0) goto L_0x034d
            r9 = r14
            java.lang.reflect.ParameterizedType r9 = (java.lang.reflect.ParameterizedType) r9
            r10 = 0
            java.lang.reflect.Type r9 = retrofit2.Utils.getParameterUpperBound(r10, r9)
            retrofit2.Retrofit r10 = r2.retrofit
            retrofit2.Converter r9 = r10.stringConverter(r9, r15)
            retrofit2.ParameterHandler$Query r10 = new retrofit2.ParameterHandler$Query
            r10.<init>(r4, r9, r8)
            retrofit2.ParameterHandler$1 r4 = new retrofit2.ParameterHandler$1
            r4.<init>()
            goto L_0x06f1
        L_0x034d:
            java.lang.reflect.Method r0 = r2.method
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline37(r9, r1, r12, r11)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r1, r2)
            throw r0
        L_0x0360:
            boolean r10 = r9.isArray()
            if (r10 == 0) goto L_0x0380
            java.lang.Class r9 = r9.getComponentType()
            java.lang.Class r9 = retrofit2.RequestFactory.Builder.boxIfPrimitive(r9)
            retrofit2.Retrofit r10 = r2.retrofit
            retrofit2.Converter r9 = r10.stringConverter(r9, r15)
            retrofit2.ParameterHandler$Query r10 = new retrofit2.ParameterHandler$Query
            r10.<init>(r4, r9, r8)
            retrofit2.ParameterHandler$2 r4 = new retrofit2.ParameterHandler$2
            r4.<init>()
            goto L_0x06f1
        L_0x0380:
            retrofit2.Retrofit r9 = r2.retrofit
            retrofit2.Converter r9 = r9.stringConverter(r14, r15)
            retrofit2.ParameterHandler$Query r10 = new retrofit2.ParameterHandler$Query
            r10.<init>(r4, r9, r8)
            goto L_0x05d7
        L_0x038d:
            boolean r4 = r8 instanceof retrofit2.http.QueryName
            if (r4 == 0) goto L_0x040a
            r2.validateResolvableType(r5, r14)
            retrofit2.http.QueryName r8 = (retrofit2.http.QueryName) r8
            boolean r4 = r8.encoded()
            java.lang.Class r8 = retrofit2.Utils.getRawType(r14)
            r9 = 1
            r2.gotQueryName = r9
            java.lang.Class<java.lang.Iterable> r9 = java.lang.Iterable.class
            boolean r9 = r9.isAssignableFrom(r8)
            if (r9 == 0) goto L_0x03da
            boolean r9 = r14 instanceof java.lang.reflect.ParameterizedType
            if (r9 == 0) goto L_0x03c7
            r8 = r14
            java.lang.reflect.ParameterizedType r8 = (java.lang.reflect.ParameterizedType) r8
            r9 = 0
            java.lang.reflect.Type r8 = retrofit2.Utils.getParameterUpperBound(r9, r8)
            retrofit2.Retrofit r9 = r2.retrofit
            retrofit2.Converter r8 = r9.stringConverter(r8, r15)
            retrofit2.ParameterHandler$QueryName r9 = new retrofit2.ParameterHandler$QueryName
            r9.<init>(r8, r4)
            retrofit2.ParameterHandler$1 r4 = new retrofit2.ParameterHandler$1
            r4.<init>()
            goto L_0x06f1
        L_0x03c7:
            java.lang.reflect.Method r0 = r2.method
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline37(r8, r1, r12, r11)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r1, r2)
            throw r0
        L_0x03da:
            boolean r9 = r8.isArray()
            if (r9 == 0) goto L_0x03fa
            java.lang.Class r8 = r8.getComponentType()
            java.lang.Class r8 = retrofit2.RequestFactory.Builder.boxIfPrimitive(r8)
            retrofit2.Retrofit r9 = r2.retrofit
            retrofit2.Converter r8 = r9.stringConverter(r8, r15)
            retrofit2.ParameterHandler$QueryName r9 = new retrofit2.ParameterHandler$QueryName
            r9.<init>(r8, r4)
            retrofit2.ParameterHandler$2 r4 = new retrofit2.ParameterHandler$2
            r4.<init>()
            goto L_0x06f1
        L_0x03fa:
            retrofit2.Retrofit r8 = r2.retrofit
            retrofit2.Converter r8 = r8.stringConverter(r14, r15)
            retrofit2.ParameterHandler$QueryName r9 = new retrofit2.ParameterHandler$QueryName
            r9.<init>(r8, r4)
        L_0x0405:
            r20 = r3
            r3 = r9
            goto L_0x08bb
        L_0x040a:
            boolean r4 = r8 instanceof retrofit2.http.QueryMap
            java.lang.String r13 = "Map must include generic types (e.g., Map<String, String>)"
            if (r4 == 0) goto L_0x0473
            r2.validateResolvableType(r5, r14)
            java.lang.Class r4 = retrofit2.Utils.getRawType(r14)
            r10 = 1
            r2.gotQueryMap = r10
            java.lang.Class<java.util.Map> r11 = java.util.Map.class
            boolean r11 = r11.isAssignableFrom(r4)
            if (r11 == 0) goto L_0x0467
            java.lang.Class<java.util.Map> r11 = java.util.Map.class
            java.lang.reflect.Type r4 = retrofit2.Utils.getSupertype(r14, r4, r11)
            boolean r11 = r4 instanceof java.lang.reflect.ParameterizedType
            if (r11 == 0) goto L_0x045d
            java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
            r11 = 0
            java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r11, r4)
            if (r9 != r11) goto L_0x044d
            java.lang.reflect.Type r4 = retrofit2.Utils.getParameterUpperBound(r10, r4)
            retrofit2.Retrofit r9 = r2.retrofit
            retrofit2.Converter r4 = r9.stringConverter(r4, r15)
            retrofit2.ParameterHandler$QueryMap r9 = new retrofit2.ParameterHandler$QueryMap
            java.lang.reflect.Method r10 = r2.method
            retrofit2.http.QueryMap r8 = (retrofit2.http.QueryMap) r8
            boolean r8 = r8.encoded()
            r9.<init>(r10, r5, r4, r8)
            goto L_0x0405
        L_0x044d:
            java.lang.reflect.Method r0 = r2.method
            java.lang.String r1 = "@QueryMap keys must be of type String: "
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline55(r1, r11)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r1, r2)
            throw r0
        L_0x045d:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r13, r0)
            throw r0
        L_0x0467:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "@QueryMap parameter type must be Map."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x0473:
            boolean r4 = r8 instanceof retrofit2.http.Header
            if (r4 == 0) goto L_0x04ea
            r2.validateResolvableType(r5, r14)
            retrofit2.http.Header r8 = (retrofit2.http.Header) r8
            java.lang.String r4 = r8.value()
            java.lang.Class r8 = retrofit2.Utils.getRawType(r14)
            java.lang.Class<java.lang.Iterable> r9 = java.lang.Iterable.class
            boolean r9 = r9.isAssignableFrom(r8)
            if (r9 == 0) goto L_0x04bd
            boolean r9 = r14 instanceof java.lang.reflect.ParameterizedType
            if (r9 == 0) goto L_0x04aa
            r8 = r14
            java.lang.reflect.ParameterizedType r8 = (java.lang.reflect.ParameterizedType) r8
            r9 = 0
            java.lang.reflect.Type r8 = retrofit2.Utils.getParameterUpperBound(r9, r8)
            retrofit2.Retrofit r9 = r2.retrofit
            retrofit2.Converter r8 = r9.stringConverter(r8, r15)
            retrofit2.ParameterHandler$Header r9 = new retrofit2.ParameterHandler$Header
            r9.<init>(r4, r8)
            retrofit2.ParameterHandler$1 r4 = new retrofit2.ParameterHandler$1
            r4.<init>()
            goto L_0x06f1
        L_0x04aa:
            java.lang.reflect.Method r0 = r2.method
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline37(r8, r1, r12, r11)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r1, r2)
            throw r0
        L_0x04bd:
            boolean r9 = r8.isArray()
            if (r9 == 0) goto L_0x04dd
            java.lang.Class r8 = r8.getComponentType()
            java.lang.Class r8 = retrofit2.RequestFactory.Builder.boxIfPrimitive(r8)
            retrofit2.Retrofit r9 = r2.retrofit
            retrofit2.Converter r8 = r9.stringConverter(r8, r15)
            retrofit2.ParameterHandler$Header r9 = new retrofit2.ParameterHandler$Header
            r9.<init>(r4, r8)
            retrofit2.ParameterHandler$2 r4 = new retrofit2.ParameterHandler$2
            r4.<init>()
            goto L_0x06f1
        L_0x04dd:
            retrofit2.Retrofit r8 = r2.retrofit
            retrofit2.Converter r8 = r8.stringConverter(r14, r15)
            retrofit2.ParameterHandler$Header r9 = new retrofit2.ParameterHandler$Header
            r9.<init>(r4, r8)
            goto L_0x0405
        L_0x04ea:
            boolean r4 = r8 instanceof retrofit2.http.HeaderMap
            if (r4 == 0) goto L_0x0557
            java.lang.Class<okhttp3.Headers> r4 = okhttp3.Headers.class
            if (r14 != r4) goto L_0x04fb
            retrofit2.ParameterHandler$Headers r4 = new retrofit2.ParameterHandler$Headers
            java.lang.reflect.Method r8 = r2.method
            r4.<init>(r8, r5)
            goto L_0x06f1
        L_0x04fb:
            r2.validateResolvableType(r5, r14)
            java.lang.Class r4 = retrofit2.Utils.getRawType(r14)
            java.lang.Class<java.util.Map> r8 = java.util.Map.class
            boolean r8 = r8.isAssignableFrom(r4)
            if (r8 == 0) goto L_0x054b
            java.lang.Class<java.util.Map> r8 = java.util.Map.class
            java.lang.reflect.Type r4 = retrofit2.Utils.getSupertype(r14, r4, r8)
            boolean r8 = r4 instanceof java.lang.reflect.ParameterizedType
            if (r8 == 0) goto L_0x0541
            java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
            r8 = 0
            java.lang.reflect.Type r8 = retrofit2.Utils.getParameterUpperBound(r8, r4)
            if (r9 != r8) goto L_0x0531
            r8 = 1
            java.lang.reflect.Type r4 = retrofit2.Utils.getParameterUpperBound(r8, r4)
            retrofit2.Retrofit r8 = r2.retrofit
            retrofit2.Converter r4 = r8.stringConverter(r4, r15)
            retrofit2.ParameterHandler$HeaderMap r8 = new retrofit2.ParameterHandler$HeaderMap
            java.lang.reflect.Method r9 = r2.method
            r8.<init>(r9, r5, r4)
            goto L_0x06a5
        L_0x0531:
            java.lang.reflect.Method r0 = r2.method
            java.lang.String r1 = "@HeaderMap keys must be of type String: "
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline55(r1, r8)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r1, r2)
            throw r0
        L_0x0541:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r13, r0)
            throw r0
        L_0x054b:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "@HeaderMap parameter type must be Map."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x0557:
            boolean r4 = r8 instanceof retrofit2.http.Field
            if (r4 == 0) goto L_0x05e8
            r2.validateResolvableType(r5, r14)
            boolean r4 = r2.isFormEncoded
            if (r4 == 0) goto L_0x05dc
            retrofit2.http.Field r8 = (retrofit2.http.Field) r8
            java.lang.String r4 = r8.value()
            boolean r8 = r8.encoded()
            r9 = 1
            r2.gotField = r9
            java.lang.Class r9 = retrofit2.Utils.getRawType(r14)
            java.lang.Class<java.lang.Iterable> r10 = java.lang.Iterable.class
            boolean r10 = r10.isAssignableFrom(r9)
            if (r10 == 0) goto L_0x05ac
            boolean r10 = r14 instanceof java.lang.reflect.ParameterizedType
            if (r10 == 0) goto L_0x0599
            r9 = r14
            java.lang.reflect.ParameterizedType r9 = (java.lang.reflect.ParameterizedType) r9
            r10 = 0
            java.lang.reflect.Type r9 = retrofit2.Utils.getParameterUpperBound(r10, r9)
            retrofit2.Retrofit r10 = r2.retrofit
            retrofit2.Converter r9 = r10.stringConverter(r9, r15)
            retrofit2.ParameterHandler$Field r10 = new retrofit2.ParameterHandler$Field
            r10.<init>(r4, r9, r8)
            retrofit2.ParameterHandler$1 r4 = new retrofit2.ParameterHandler$1
            r4.<init>()
            goto L_0x06f1
        L_0x0599:
            java.lang.reflect.Method r0 = r2.method
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline37(r9, r1, r12, r11)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r1, r2)
            throw r0
        L_0x05ac:
            boolean r10 = r9.isArray()
            if (r10 == 0) goto L_0x05cc
            java.lang.Class r9 = r9.getComponentType()
            java.lang.Class r9 = retrofit2.RequestFactory.Builder.boxIfPrimitive(r9)
            retrofit2.Retrofit r10 = r2.retrofit
            retrofit2.Converter r9 = r10.stringConverter(r9, r15)
            retrofit2.ParameterHandler$Field r10 = new retrofit2.ParameterHandler$Field
            r10.<init>(r4, r9, r8)
            retrofit2.ParameterHandler$2 r4 = new retrofit2.ParameterHandler$2
            r4.<init>()
            goto L_0x06f1
        L_0x05cc:
            retrofit2.Retrofit r9 = r2.retrofit
            retrofit2.Converter r9 = r9.stringConverter(r14, r15)
            retrofit2.ParameterHandler$Field r10 = new retrofit2.ParameterHandler$Field
            r10.<init>(r4, r9, r8)
        L_0x05d7:
            r20 = r3
            r3 = r10
            goto L_0x08bb
        L_0x05dc:
            java.lang.reflect.Method r0 = r2.method
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "@Field parameters can only be used with form encoding."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r2, r1)
            throw r0
        L_0x05e8:
            boolean r4 = r8 instanceof retrofit2.http.FieldMap
            if (r4 == 0) goto L_0x0660
            r2.validateResolvableType(r5, r14)
            boolean r4 = r2.isFormEncoded
            if (r4 == 0) goto L_0x0654
            java.lang.Class r4 = retrofit2.Utils.getRawType(r14)
            java.lang.Class<java.util.Map> r10 = java.util.Map.class
            boolean r10 = r10.isAssignableFrom(r4)
            if (r10 == 0) goto L_0x0648
            java.lang.Class<java.util.Map> r10 = java.util.Map.class
            java.lang.reflect.Type r4 = retrofit2.Utils.getSupertype(r14, r4, r10)
            boolean r10 = r4 instanceof java.lang.reflect.ParameterizedType
            if (r10 == 0) goto L_0x063e
            java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
            r10 = 0
            java.lang.reflect.Type r10 = retrofit2.Utils.getParameterUpperBound(r10, r4)
            if (r9 != r10) goto L_0x062e
            r9 = 1
            java.lang.reflect.Type r4 = retrofit2.Utils.getParameterUpperBound(r9, r4)
            retrofit2.Retrofit r10 = r2.retrofit
            retrofit2.Converter r4 = r10.stringConverter(r4, r15)
            r2.gotField = r9
            retrofit2.ParameterHandler$FieldMap r9 = new retrofit2.ParameterHandler$FieldMap
            java.lang.reflect.Method r10 = r2.method
            retrofit2.http.FieldMap r8 = (retrofit2.http.FieldMap) r8
            boolean r8 = r8.encoded()
            r9.<init>(r10, r5, r4, r8)
            goto L_0x0405
        L_0x062e:
            java.lang.reflect.Method r0 = r2.method
            java.lang.String r1 = "@FieldMap keys must be of type String: "
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline55(r1, r10)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r1, r2)
            throw r0
        L_0x063e:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r13, r0)
            throw r0
        L_0x0648:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "@FieldMap parameter type must be Map."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x0654:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "@FieldMap parameters can only be used with form encoding."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x0660:
            boolean r4 = r8 instanceof retrofit2.http.Part
            if (r4 == 0) goto L_0x07d9
            r2.validateResolvableType(r5, r14)
            boolean r4 = r2.isMultipart
            if (r4 == 0) goto L_0x07cd
            retrofit2.http.Part r8 = (retrofit2.http.Part) r8
            r4 = 1
            r2.gotPart = r4
            java.lang.String r4 = r8.value()
            java.lang.Class r9 = retrofit2.Utils.getRawType(r14)
            boolean r13 = r4.isEmpty()
            if (r13 == 0) goto L_0x06ff
            java.lang.Class<java.lang.Iterable> r4 = java.lang.Iterable.class
            boolean r4 = r4.isAssignableFrom(r9)
            java.lang.String r8 = "@Part annotation must supply a name or use MultipartBody.Part parameter type."
            if (r4 == 0) goto L_0x06c6
            boolean r4 = r14 instanceof java.lang.reflect.ParameterizedType
            if (r4 == 0) goto L_0x06b3
            r4 = r14
            java.lang.reflect.ParameterizedType r4 = (java.lang.reflect.ParameterizedType) r4
            r9 = 0
            java.lang.reflect.Type r4 = retrofit2.Utils.getParameterUpperBound(r9, r4)
            java.lang.Class r4 = retrofit2.Utils.getRawType(r4)
            boolean r4 = r10.isAssignableFrom(r4)
            if (r4 == 0) goto L_0x06aa
            retrofit2.ParameterHandler$RawPart r4 = retrofit2.ParameterHandler.RawPart.INSTANCE
            retrofit2.ParameterHandler$1 r8 = new retrofit2.ParameterHandler$1
            r8.<init>()
        L_0x06a5:
            r20 = r3
            r3 = r8
            goto L_0x08bb
        L_0x06aa:
            java.lang.reflect.Method r0 = r2.method
            java.lang.Object[] r1 = new java.lang.Object[r9]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r8, r1)
            throw r0
        L_0x06b3:
            java.lang.reflect.Method r0 = r2.method
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline37(r9, r1, r12, r11)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r1, r2)
            throw r0
        L_0x06c6:
            boolean r4 = r9.isArray()
            if (r4 == 0) goto L_0x06e8
            java.lang.Class r4 = r9.getComponentType()
            boolean r4 = r10.isAssignableFrom(r4)
            if (r4 == 0) goto L_0x06de
            retrofit2.ParameterHandler$RawPart r4 = retrofit2.ParameterHandler.RawPart.INSTANCE
            retrofit2.ParameterHandler$2 r8 = new retrofit2.ParameterHandler$2
            r8.<init>()
            goto L_0x06a5
        L_0x06de:
            java.lang.reflect.Method r0 = r2.method
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r8, r1)
            throw r0
        L_0x06e8:
            r4 = 0
            boolean r9 = r10.isAssignableFrom(r9)
            if (r9 == 0) goto L_0x06f6
            retrofit2.ParameterHandler$RawPart r4 = retrofit2.ParameterHandler.RawPart.INSTANCE
        L_0x06f1:
            r20 = r3
        L_0x06f3:
            r3 = r4
            goto L_0x08bb
        L_0x06f6:
            java.lang.reflect.Method r0 = r2.method
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r8, r1)
            throw r0
        L_0x06ff:
            r13 = 4
            java.lang.String[] r13 = new java.lang.String[r13]
            java.lang.String r22 = "Content-Disposition"
            r20 = 0
            r13[r20] = r22
            r20 = r3
            java.lang.String r3 = "form-data; name=\""
            java.lang.String r1 = "\""
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline52(r3, r4, r1)
            r3 = 1
            r13[r3] = r1
            java.lang.String r1 = "Content-Transfer-Encoding"
            r3 = 2
            r13[r3] = r1
            r1 = 3
            java.lang.String r3 = r8.encoding()
            r13[r1] = r3
            okhttp3.Headers r1 = okhttp3.Headers.of(r13)
            java.lang.Class<java.lang.Iterable> r3 = java.lang.Iterable.class
            boolean r3 = r3.isAssignableFrom(r9)
            java.lang.String r4 = "@Part parameters using the MultipartBody.Part must not include a part name in the annotation."
            if (r3 == 0) goto L_0x0778
            boolean r3 = r14 instanceof java.lang.reflect.ParameterizedType
            if (r3 == 0) goto L_0x0765
            r3 = r14
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            r8 = 0
            java.lang.reflect.Type r3 = retrofit2.Utils.getParameterUpperBound(r8, r3)
            java.lang.Class r8 = retrofit2.Utils.getRawType(r3)
            boolean r8 = r10.isAssignableFrom(r8)
            if (r8 != 0) goto L_0x075b
            retrofit2.Retrofit r4 = r2.retrofit
            java.lang.annotation.Annotation[] r8 = r2.methodAnnotations
            retrofit2.Converter r3 = r4.requestBodyConverter(r3, r15, r8)
            retrofit2.ParameterHandler$Part r4 = new retrofit2.ParameterHandler$Part
            java.lang.reflect.Method r8 = r2.method
            r4.<init>(r8, r5, r1, r3)
            retrofit2.ParameterHandler$1 r3 = new retrofit2.ParameterHandler$1
            r3.<init>()
            goto L_0x08bb
        L_0x075b:
            java.lang.reflect.Method r0 = r2.method
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r4, r1)
            throw r0
        L_0x0765:
            java.lang.reflect.Method r0 = r2.method
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline37(r9, r1, r12, r11)
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r1, r2)
            throw r0
        L_0x0778:
            boolean r3 = r9.isArray()
            if (r3 == 0) goto L_0x07ac
            java.lang.Class r3 = r9.getComponentType()
            java.lang.Class r3 = retrofit2.RequestFactory.Builder.boxIfPrimitive(r3)
            boolean r8 = r10.isAssignableFrom(r3)
            if (r8 != 0) goto L_0x07a2
            retrofit2.Retrofit r4 = r2.retrofit
            java.lang.annotation.Annotation[] r8 = r2.methodAnnotations
            retrofit2.Converter r3 = r4.requestBodyConverter(r3, r15, r8)
            retrofit2.ParameterHandler$Part r4 = new retrofit2.ParameterHandler$Part
            java.lang.reflect.Method r8 = r2.method
            r4.<init>(r8, r5, r1, r3)
            retrofit2.ParameterHandler$2 r3 = new retrofit2.ParameterHandler$2
            r3.<init>()
            goto L_0x08bb
        L_0x07a2:
            java.lang.reflect.Method r0 = r2.method
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r4, r1)
            throw r0
        L_0x07ac:
            boolean r3 = r10.isAssignableFrom(r9)
            if (r3 != 0) goto L_0x07c3
            retrofit2.Retrofit r3 = r2.retrofit
            java.lang.annotation.Annotation[] r4 = r2.methodAnnotations
            retrofit2.Converter r3 = r3.requestBodyConverter(r14, r15, r4)
            retrofit2.ParameterHandler$Part r4 = new retrofit2.ParameterHandler$Part
            java.lang.reflect.Method r8 = r2.method
            r4.<init>(r8, r5, r1, r3)
            goto L_0x06f3
        L_0x07c3:
            java.lang.reflect.Method r0 = r2.method
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r4, r1)
            throw r0
        L_0x07cd:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "@Part parameters can only be used with multipart encoding."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x07d9:
            r20 = r3
            boolean r1 = r8 instanceof retrofit2.http.PartMap
            if (r1 == 0) goto L_0x086c
            r2.validateResolvableType(r5, r14)
            boolean r1 = r2.isMultipart
            if (r1 == 0) goto L_0x0860
            r1 = 1
            r2.gotPart = r1
            java.lang.Class r1 = retrofit2.Utils.getRawType(r14)
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r1)
            if (r3 == 0) goto L_0x0854
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            java.lang.reflect.Type r1 = retrofit2.Utils.getSupertype(r14, r1, r3)
            boolean r3 = r1 instanceof java.lang.reflect.ParameterizedType
            if (r3 == 0) goto L_0x084a
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
            r3 = 0
            java.lang.reflect.Type r3 = retrofit2.Utils.getParameterUpperBound(r3, r1)
            if (r9 != r3) goto L_0x083a
            r3 = 1
            java.lang.reflect.Type r1 = retrofit2.Utils.getParameterUpperBound(r3, r1)
            java.lang.Class r3 = retrofit2.Utils.getRawType(r1)
            boolean r3 = r10.isAssignableFrom(r3)
            if (r3 != 0) goto L_0x082e
            retrofit2.Retrofit r3 = r2.retrofit
            java.lang.annotation.Annotation[] r4 = r2.methodAnnotations
            retrofit2.Converter r1 = r3.requestBodyConverter(r1, r15, r4)
            retrofit2.http.PartMap r8 = (retrofit2.http.PartMap) r8
            retrofit2.ParameterHandler$PartMap r3 = new retrofit2.ParameterHandler$PartMap
            java.lang.reflect.Method r4 = r2.method
            java.lang.String r8 = r8.encoding()
            r3.<init>(r4, r5, r1, r8)
            goto L_0x08bb
        L_0x082e:
            java.lang.reflect.Method r0 = r2.method
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r2, r1)
            throw r0
        L_0x083a:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.String r2 = "@PartMap keys must be of type String: "
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline55(r2, r3)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x084a:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r13, r0)
            throw r0
        L_0x0854:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "@PartMap parameter type must be Map."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x0860:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "@PartMap parameters can only be used with multipart encoding."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x086c:
            boolean r1 = r8 instanceof retrofit2.http.Body
            if (r1 == 0) goto L_0x08ba
            r2.validateResolvableType(r5, r14)
            boolean r1 = r2.isFormEncoded
            if (r1 != 0) goto L_0x08ae
            boolean r1 = r2.isMultipart
            if (r1 != 0) goto L_0x08ae
            boolean r1 = r2.gotBody
            if (r1 != 0) goto L_0x08a2
            retrofit2.Retrofit r1 = r2.retrofit     // Catch:{ RuntimeException -> 0x0892 }
            java.lang.annotation.Annotation[] r3 = r2.methodAnnotations     // Catch:{ RuntimeException -> 0x0892 }
            retrofit2.Converter r1 = r1.requestBodyConverter(r14, r15, r3)     // Catch:{ RuntimeException -> 0x0892 }
            r3 = 1
            r2.gotBody = r3
            retrofit2.ParameterHandler$Body r3 = new retrofit2.ParameterHandler$Body
            java.lang.reflect.Method r4 = r2.method
            r3.<init>(r4, r5, r1)
            goto L_0x08bb
        L_0x0892:
            r0 = move-exception
            java.lang.reflect.Method r1 = r2.method
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r14
            java.lang.String r3 = "Unable to create @Body converter for %s"
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r0, r5, r3, r2)
            throw r0
        L_0x08a2:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "Multiple @Body method annotations found."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x08ae:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "@Body parameters cannot be used with form or multi-part encoding."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r1, r5, r2, r0)
            throw r0
        L_0x08ba:
            r3 = 0
        L_0x08bb:
            if (r3 != 0) goto L_0x08be
            goto L_0x08c2
        L_0x08be:
            if (r17 != 0) goto L_0x08ce
            r17 = r3
        L_0x08c2:
            int r12 = r21 + 1
            r1 = r24
            r3 = r18
            r4 = r19
            r13 = r20
            goto L_0x0197
        L_0x08ce:
            java.lang.reflect.Method r0 = r2.method
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Multiple Retrofit annotations found, only one allowed."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r2, r1)
            throw r0
        L_0x08da:
            r18 = r3
            r19 = r4
            goto L_0x08e5
        L_0x08df:
            r18 = r3
            r19 = r4
            r17 = 0
        L_0x08e5:
            if (r17 != 0) goto L_0x0903
            if (r16 == 0) goto L_0x08f7
            java.lang.Class r1 = retrofit2.Utils.getRawType(r14)     // Catch:{ NoClassDefFoundError -> 0x08f7 }
            java.lang.Class<kotlin.coroutines.Continuation> r3 = kotlin.coroutines.Continuation.class
            if (r1 != r3) goto L_0x08f7
            r1 = 1
            r2.isKotlinSuspendFunction = r1     // Catch:{ NoClassDefFoundError -> 0x08f7 }
            r17 = 0
            goto L_0x0903
        L_0x08f7:
            java.lang.reflect.Method r0 = r2.method
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "No Retrofit annotation found."
            java.lang.RuntimeException r0 = retrofit2.Utils.parameterError(r0, r5, r2, r1)
            throw r0
        L_0x0903:
            r6[r5] = r17
            int r5 = r5 + 1
            r1 = r24
            r3 = r18
            r4 = r19
            goto L_0x017a
        L_0x090f:
            java.lang.String r1 = r2.relativeUrl
            if (r1 != 0) goto L_0x0929
            boolean r1 = r2.gotUrl
            if (r1 == 0) goto L_0x0918
            goto L_0x0929
        L_0x0918:
            java.lang.reflect.Method r0 = r2.method
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r2.httpMethod
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "Missing either @%s URL or @Url parameter."
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r0, r2, r1)
            throw r0
        L_0x0929:
            boolean r1 = r2.isFormEncoded
            if (r1 != 0) goto L_0x0946
            boolean r1 = r2.isMultipart
            if (r1 != 0) goto L_0x0946
            boolean r1 = r2.hasBody
            if (r1 != 0) goto L_0x0946
            boolean r1 = r2.gotBody
            if (r1 != 0) goto L_0x093a
            goto L_0x0946
        L_0x093a:
            java.lang.reflect.Method r0 = r2.method
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Non-body HTTP method cannot contain @Body."
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r0, r2, r1)
            throw r0
        L_0x0946:
            boolean r1 = r2.isFormEncoded
            if (r1 == 0) goto L_0x095b
            boolean r1 = r2.gotField
            if (r1 == 0) goto L_0x094f
            goto L_0x095b
        L_0x094f:
            java.lang.reflect.Method r0 = r2.method
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Form-encoded method must contain at least one @Field."
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r0, r2, r1)
            throw r0
        L_0x095b:
            r1 = 0
            boolean r3 = r2.isMultipart
            if (r3 == 0) goto L_0x0970
            boolean r3 = r2.gotPart
            if (r3 == 0) goto L_0x0965
            goto L_0x0970
        L_0x0965:
            java.lang.reflect.Method r0 = r2.method
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "Multipart method must contain at least one @Part."
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r0, r2, r1)
            throw r0
        L_0x0970:
            retrofit2.RequestFactory r3 = new retrofit2.RequestFactory
            r3.<init>(r2)
            java.lang.reflect.Type r1 = r24.getGenericReturnType()
            boolean r2 = retrofit2.Utils.hasUnresolvableType(r1)
            if (r2 != 0) goto L_0x0a94
            java.lang.Class r2 = java.lang.Void.TYPE
            if (r1 == r2) goto L_0x0a88
            java.lang.Class<retrofit2.Response> r1 = retrofit2.Response.class
            boolean r2 = r3.isKotlinSuspendFunction
            java.lang.annotation.Annotation[] r4 = r24.getAnnotations()
            if (r2 == 0) goto L_0x09e2
            java.lang.reflect.Type[] r5 = r24.getGenericParameterTypes()
            int r6 = r5.length
            int r6 = r6 + -1
            r5 = r5[r6]
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
            java.lang.reflect.Type[] r5 = r5.getActualTypeArguments()
            r6 = 0
            r5 = r5[r6]
            boolean r8 = r5 instanceof java.lang.reflect.WildcardType
            if (r8 == 0) goto L_0x09ab
            java.lang.reflect.WildcardType r5 = (java.lang.reflect.WildcardType) r5
            java.lang.reflect.Type[] r5 = r5.getLowerBounds()
            r5 = r5[r6]
        L_0x09ab:
            java.lang.Class r8 = retrofit2.Utils.getRawType(r5)
            if (r8 != r1) goto L_0x09bd
            boolean r8 = r5 instanceof java.lang.reflect.ParameterizedType
            if (r8 == 0) goto L_0x09bd
            java.lang.reflect.ParameterizedType r5 = (java.lang.reflect.ParameterizedType) r5
            java.lang.reflect.Type r5 = retrofit2.Utils.getParameterUpperBound(r6, r5)
            r8 = 1
            goto L_0x09be
        L_0x09bd:
            r8 = 0
        L_0x09be:
            retrofit2.Utils$ParameterizedTypeImpl r9 = new retrofit2.Utils$ParameterizedTypeImpl
            java.lang.Class<retrofit2.Call> r10 = retrofit2.Call.class
            r11 = 1
            java.lang.reflect.Type[] r12 = new java.lang.reflect.Type[r11]
            r12[r6] = r5
            r5 = 0
            r9.<init>(r5, r10, r12)
            java.lang.Class<retrofit2.SkipCallbackExecutor> r5 = retrofit2.SkipCallbackExecutor.class
            boolean r5 = retrofit2.Utils.isAnnotationPresent(r4, r5)
            if (r5 == 0) goto L_0x09d4
            goto L_0x09e7
        L_0x09d4:
            int r5 = r4.length
            int r5 = r5 + r11
            java.lang.annotation.Annotation[] r5 = new java.lang.annotation.Annotation[r5]
            retrofit2.SkipCallbackExecutor r10 = retrofit2.SkipCallbackExecutorImpl.INSTANCE
            r5[r6] = r10
            int r10 = r4.length
            java.lang.System.arraycopy(r4, r6, r5, r11, r10)
            r4 = r5
            goto L_0x09e7
        L_0x09e2:
            java.lang.reflect.Type r9 = r24.getGenericReturnType()
            r8 = 0
        L_0x09e7:
            retrofit2.CallAdapter r5 = r0.callAdapter(r9, r4)     // Catch:{ RuntimeException -> 0x0a77 }
            java.lang.reflect.Type r4 = r5.responseType()
            java.lang.Class<okhttp3.Response> r6 = okhttp3.Response.class
            if (r4 == r6) goto L_0x0a53
            if (r4 == r1) goto L_0x0a47
            java.lang.String r1 = r3.httpMethod
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x0a12
            java.lang.Class<java.lang.Void> r1 = java.lang.Void.class
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0a06
            goto L_0x0a12
        L_0x0a06:
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "HEAD method must use Void as response type."
            r6 = r24
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r6, r1, r0)
            throw r0
        L_0x0a12:
            r6 = r24
            java.lang.annotation.Annotation[] r1 = r24.getAnnotations()
            retrofit2.Converter r4 = r0.responseBodyConverter(r4, r1)     // Catch:{ RuntimeException -> 0x0a38 }
            okhttp3.Call$Factory r0 = r0.callFactory
            if (r2 != 0) goto L_0x0a26
            retrofit2.HttpServiceMethod$CallAdapted r1 = new retrofit2.HttpServiceMethod$CallAdapted
            r1.<init>(r3, r0, r4, r5)
            goto L_0x0a37
        L_0x0a26:
            if (r8 == 0) goto L_0x0a2e
            retrofit2.HttpServiceMethod$SuspendForResponse r1 = new retrofit2.HttpServiceMethod$SuspendForResponse
            r1.<init>(r3, r0, r4, r5)
            goto L_0x0a37
        L_0x0a2e:
            retrofit2.HttpServiceMethod$SuspendForBody r7 = new retrofit2.HttpServiceMethod$SuspendForBody
            r6 = 0
            r1 = r7
            r2 = r3
            r3 = r0
            r1.<init>(r2, r3, r4, r5, r6)
        L_0x0a37:
            return r1
        L_0x0a38:
            r0 = move-exception
            r1 = r0
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            r0[r2] = r4
            java.lang.String r2 = "Unable to create converter for %s"
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r6, r1, r2, r0)
            throw r0
        L_0x0a47:
            r6 = r24
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "Response must include generic type (e.g., Response<String>)"
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r6, r1, r0)
            throw r0
        L_0x0a53:
            r6 = r24
            java.lang.String r0 = "'"
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.Class r1 = retrofit2.Utils.getRawType(r4)
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r1 = "' is not a valid response body type. Did you mean ResponseBody?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r6, r0, r1)
            throw r0
        L_0x0a77:
            r0 = move-exception
            r6 = r24
            r1 = r0
            r0 = 0
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r0] = r9
            java.lang.String r0 = "Unable to create call adapter for %s"
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r6, r1, r0, r2)
            throw r0
        L_0x0a88:
            r6 = r24
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "Service methods cannot return void."
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r6, r1, r0)
            throw r0
        L_0x0a94:
            r6 = r24
            r0 = 0
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r0] = r1
            java.lang.String r0 = "Method return type must not include a type variable or wildcard: %s"
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r6, r0, r2)
            throw r0
        L_0x0aa3:
            r0 = 0
            java.lang.reflect.Method r1 = r2.method
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "HTTP method annotation is required (e.g., @GET, @POST, etc.)."
            java.lang.RuntimeException r0 = retrofit2.Utils.methodError(r1, r2, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.ServiceMethod.parseAnnotations(retrofit2.Retrofit, java.lang.reflect.Method):retrofit2.ServiceMethod");
    }
}
