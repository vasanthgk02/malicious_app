package extern.okhttp3.internal.http;

import com.freshchat.consumer.sdk.BuildConfig;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import extern.okhttp3.Address;
import extern.okhttp3.Call;
import extern.okhttp3.CertificatePinner;
import extern.okhttp3.EventListener;
import extern.okhttp3.HttpUrl;
import extern.okhttp3.Interceptor;
import extern.okhttp3.Interceptor.Chain;
import extern.okhttp3.OkHttpClient;
import extern.okhttp3.Request;
import extern.okhttp3.Request.Builder;
import extern.okhttp3.RequestBody;
import extern.okhttp3.Response;
import extern.okhttp3.Route;
import extern.okhttp3.internal.Util;
import extern.okhttp3.internal.connection.RouteException;
import extern.okhttp3.internal.connection.StreamAllocation;
import extern.okhttp3.internal.http2.ConnectionShutdownException;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import org.jboss.netty.handler.codec.http.HttpHeaders.Names;
import sfs2x.client.requests.BaseRequest;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private final boolean forWebSocket;
    private volatile StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.client = okHttpClient;
        this.forWebSocket = z;
    }

    public void cancel() {
        this.canceled = true;
        StreamAllocation streamAllocation2 = this.streamAllocation;
        if (streamAllocation2 != null) {
            streamAllocation2.cancel();
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCallStackTrace(Object obj) {
        this.callStackTrace = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }

    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener eventListener = realInterceptorChain.eventListener();
        StreamAllocation streamAllocation2 = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation2;
        Response response = null;
        int i = 0;
        while (!this.canceled) {
            try {
                Response proceed = realInterceptorChain.proceed(request, streamAllocation2, null, null);
                if (response != null) {
                    proceed = proceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                }
                try {
                    Request followUpRequest = followUpRequest(proceed, streamAllocation2.route());
                    if (followUpRequest == null) {
                        streamAllocation2.release();
                        return proceed;
                    }
                    Util.closeQuietly((Closeable) proceed.body());
                    int i2 = i + 1;
                    if (i2 > 20) {
                        streamAllocation2.release();
                        throw new ProtocolException("Too many follow-up requests: " + i2);
                    } else if (!(followUpRequest.body() instanceof UnrepeatableRequestBody)) {
                        if (!sameConnection(proceed, followUpRequest.url())) {
                            streamAllocation2.release();
                            streamAllocation2 = new StreamAllocation(this.client.connectionPool(), createAddress(followUpRequest.url()), call, eventListener, this.callStackTrace);
                            this.streamAllocation = streamAllocation2;
                        } else if (streamAllocation2.codec() != null) {
                            throw new IllegalStateException("Closing the body of " + proceed + " didn't close its backing stream. Bad interceptor?");
                        }
                        response = proceed;
                        request = followUpRequest;
                        i = i2;
                    } else {
                        streamAllocation2.release();
                        throw new HttpRetryException("Cannot retry streamed HTTP body", proceed.code());
                    }
                } catch (IOException e2) {
                    streamAllocation2.release();
                    throw e2;
                }
            } catch (RouteException e3) {
                if (!recover(e3.getLastConnectException(), streamAllocation2, false, request)) {
                    throw e3.getFirstConnectException();
                }
            } catch (IOException e4) {
                if (!recover(e4, streamAllocation2, !(e4 instanceof ConnectionShutdownException), request)) {
                    throw e4;
                }
            } catch (Throwable th) {
                streamAllocation2.streamFailed(null);
                streamAllocation2.release();
                throw th;
            }
        }
        streamAllocation2.release();
        throw new IOException("Canceled");
    }

    private Address createAddress(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        Address address = new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
        return address;
    }

    private boolean recover(IOException iOException, StreamAllocation streamAllocation2, boolean z, Request request) {
        streamAllocation2.streamFailed(iOException);
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z || !requestIsUnrepeatable(iOException, request)) && isRecoverable(iOException, z) && streamAllocation2.hasMoreRoutes()) {
            return true;
        }
        return false;
    }

    private boolean requestIsUnrepeatable(IOException iOException, Request request) {
        return (request.body() instanceof UnrepeatableRequestBody) || (iOException instanceof FileNotFoundException);
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        boolean z2 = false;
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if ((iOException instanceof SocketTimeoutException) && !z) {
                z2 = true;
            }
            return z2;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private Request followUpRequest(Response response, Route route) throws IOException {
        if (response != null) {
            int code = response.code();
            String method = response.request().method();
            RequestBody requestBody = null;
            if (code == 307 || code == 308) {
                if (!method.equals(HttpGetRequest.METHOD_GET) && !method.equals(BuildConfig.SCM_BRANCH)) {
                    return null;
                }
            } else if (code == 401) {
                return this.client.authenticator().authenticate(route, response);
            } else {
                if (code != 503) {
                    if (code != 407) {
                        if (code != 408) {
                            switch (code) {
                                case 300:
                                case BaseRequest.InvitationReply /*301*/:
                                case BaseRequest.CreateSFSGame /*302*/:
                                case BaseRequest.QuickJoinGame /*303*/:
                                    break;
                                default:
                                    return null;
                            }
                        } else if (!this.client.retryOnConnectionFailure() || (response.request().body() instanceof UnrepeatableRequestBody)) {
                            return null;
                        } else {
                            if ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0) {
                                return response.request();
                            }
                            return null;
                        }
                    } else if (route.proxy().type() == Type.HTTP) {
                        return this.client.proxyAuthenticator().authenticate(route, response);
                    } else {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                } else if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                } else {
                    return null;
                }
            }
            if (!this.client.followRedirects()) {
                return null;
            }
            String header = response.header(Names.LOCATION);
            if (header == null) {
                return null;
            }
            HttpUrl resolve = response.request().url().resolve(header);
            if (resolve == null) {
                return null;
            }
            if (!resolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
                return null;
            }
            Builder newBuilder = response.request().newBuilder();
            if (HttpMethod.permitsRequestBody(method)) {
                boolean redirectsWithBody = HttpMethod.redirectsWithBody(method);
                if (HttpMethod.redirectsToGet(method)) {
                    newBuilder.method(HttpGetRequest.METHOD_GET, null);
                } else {
                    if (redirectsWithBody) {
                        requestBody = response.request().body();
                    }
                    newBuilder.method(method, requestBody);
                }
                if (!redirectsWithBody) {
                    newBuilder.removeHeader(Names.TRANSFER_ENCODING);
                    newBuilder.removeHeader("Content-Length");
                    newBuilder.removeHeader("Content-Type");
                }
            }
            if (!sameConnection(response, resolve)) {
                newBuilder.removeHeader("Authorization");
            }
            return newBuilder.url(resolve).build();
        }
        throw new IllegalStateException();
    }

    private int retryAfter(Response response, int i) {
        String header = response.header("Retry-After");
        if (header == null) {
            return i;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean sameConnection(Response response, HttpUrl httpUrl) {
        HttpUrl url = response.request().url();
        return url.host().equals(httpUrl.host()) && url.port() == httpUrl.port() && url.scheme().equals(httpUrl.scheme());
    }
}
