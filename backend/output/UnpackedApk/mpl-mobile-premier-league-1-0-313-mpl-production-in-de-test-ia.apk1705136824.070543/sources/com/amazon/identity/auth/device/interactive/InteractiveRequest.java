package com.amazon.identity.auth.device.interactive;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.amazon.identity.auth.device.interactive.InteractiveListener;

public abstract class InteractiveRequest<T extends InteractiveListener<S, U, V>, S, U, V> implements InteractiveAPI, InteractiveListener<S, U, V> {

    /* renamed from: a  reason: collision with root package name */
    public RequestContext f3294a;

    public static abstract class Builder<W extends InteractiveRequest<?, ?, ?, ?>> {
        public RequestContext requestContext;

        public Builder(RequestContext requestContext2) {
            if (requestContext2 != null) {
                this.requestContext = requestContext2;
                return;
            }
            throw new IllegalArgumentException("A RequestContext is necessary for making interactive requests");
        }

        public abstract W build();
    }

    public InteractiveRequest(RequestContext requestContext) {
        setRequestContext(requestContext);
    }

    private InteractiveListener<S, U, V> a() {
        return this.f3294a.getAggregateListener(this);
    }

    public void assertListenerPresent() throws i {
        this.f3294a.assertListenerPresent(this);
    }

    public Context getContext() {
        return this.f3294a.getContext();
    }

    public abstract Class<T> getListenerClass();

    public RequestContext getRequestContext() {
        return this.f3294a;
    }

    public Bundle getRequestExtras() {
        return null;
    }

    public void onCancel(U u) {
        a().onCancel(u);
    }

    public void onError(V v) {
        a().onError(v);
    }

    public void onRequestCancel(Context context, InteractiveRequestRecord interactiveRequestRecord, co coVar) {
        a().onRequestCancel(context, interactiveRequestRecord, coVar);
    }

    public void onRequestCompletion(Context context, InteractiveRequestRecord interactiveRequestRecord, Uri uri) {
        a().onRequestCompletion(context, interactiveRequestRecord, uri);
    }

    public void onRequestError(Context context, InteractiveRequestRecord interactiveRequestRecord, Exception exc) {
        a().onRequestError(context, interactiveRequestRecord, exc);
    }

    public void onSuccess(S s) {
        a().onSuccess(s);
    }

    public void setRequestContext(RequestContext requestContext) {
        if (requestContext != null) {
            this.f3294a = requestContext;
            return;
        }
        throw new IllegalArgumentException("requestContext must be non-null");
    }
}
