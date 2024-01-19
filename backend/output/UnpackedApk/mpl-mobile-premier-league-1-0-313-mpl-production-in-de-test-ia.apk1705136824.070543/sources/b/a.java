package b;

import com.amazon.identity.auth.device.api.authorization.Region;
import com.amazon.identity.auth.device.api.authorization.Scope;
import com.amazon.identity.auth.device.api.authorization.ScopeFactory;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Region f2770a = Region.EU;

    /* renamed from: b  reason: collision with root package name */
    public static final Scope[] f2771b;

    static {
        Scope[] scopeArr = {ScopeFactory.scopeNamed("payments::conduct_silentpay"), ScopeFactory.scopeNamed("profile:user_id")};
        f2771b = scopeArr;
        Scope scope = scopeArr[0];
        Scope scope2 = scopeArr[1];
        ScopeFactory.scopeNamed("prime:benefit_status");
    }
}
