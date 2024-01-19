package lib.android.paypal.com.magnessdk;

public enum c$h$c {
    GET_REQUEST_STARTED(50),
    GET_REQUEST_ERROR(51),
    GET_REQUEST_SUCCEEDED(52),
    POST_REQUEST_STARTED(53),
    POST_REQUEST_ERROR(54),
    POST_REQUEST_SUCCEEDED(55),
    HTTP_STATUS_FAILED(-1),
    HTTP_STATUS_200(200);
    
    public final int i;

    /* access modifiers changed from: public */
    c$h$c(int i2) {
        this.i = i2;
    }

    public static c$h$c a(int i2) {
        if (i2 == GET_REQUEST_STARTED.a()) {
            return GET_REQUEST_STARTED;
        }
        if (i2 == GET_REQUEST_ERROR.a()) {
            return GET_REQUEST_ERROR;
        }
        if (i2 == GET_REQUEST_SUCCEEDED.a()) {
            return GET_REQUEST_SUCCEEDED;
        }
        if (i2 == POST_REQUEST_STARTED.a()) {
            return POST_REQUEST_STARTED;
        }
        if (i2 == POST_REQUEST_ERROR.a()) {
            return POST_REQUEST_ERROR;
        }
        if (i2 == POST_REQUEST_SUCCEEDED.a()) {
            return POST_REQUEST_SUCCEEDED;
        }
        if (i2 == HTTP_STATUS_FAILED.a()) {
            return HTTP_STATUS_FAILED;
        }
        if (i2 == HTTP_STATUS_200.a()) {
            return HTTP_STATUS_200;
        }
        return null;
    }

    public int a() {
        return this.i;
    }
}
