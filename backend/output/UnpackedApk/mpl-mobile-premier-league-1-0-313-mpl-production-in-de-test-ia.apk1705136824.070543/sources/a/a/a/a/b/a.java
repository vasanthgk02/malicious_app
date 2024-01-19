package a.a.a.a.b;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.MLog;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;

public final class a implements Interceptor {
    public Response intercept(Chain chain) {
        Request request = chain.request();
        long nanoTime = System.nanoTime();
        Response proceed = chain.proceed(request);
        long nanoTime2 = System.nanoTime();
        long sentRequestAtMillis = proceed.sentRequestAtMillis();
        long receivedResponseAtMillis = proceed.receivedResponseAtMillis();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("response time : ");
        outline73.append(receivedResponseAtMillis - sentRequestAtMillis);
        outline73.append(" ms");
        MLog.i("NetworkLib: LoggingInterceptor", outline73.toString());
        MLog.i("NetworkLib: LoggingInterceptor", "Process Time: ", Long.valueOf(nanoTime2 - nanoTime), " Nono Second");
        return proceed;
    }
}
