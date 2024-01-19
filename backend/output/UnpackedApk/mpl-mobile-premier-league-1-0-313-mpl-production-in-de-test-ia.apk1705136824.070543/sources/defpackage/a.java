package defpackage;

import com.amazon.identity.auth.device.interactive.InteractiveRequest;
import java.util.UUID;

/* renamed from: a  reason: default package */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public int f2378a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final InteractiveRequest<?, ?, ?, ?> f4a;

    /* renamed from: a  reason: collision with other field name */
    public final String f5a = UUID.randomUUID().toString();

    public a(InteractiveRequest<?, ?, ?, ?> interactiveRequest) {
        this.f4a = interactiveRequest;
    }
}
