package lib.android.paypal.com.magnessdk.network.base;

public abstract class c implements Runnable {
    public void d() {
        d dVar;
        synchronized (d.f6135a) {
            if (d.f6136b == null) {
                d.f6136b = new d();
            }
            dVar = d.f6136b;
        }
        dVar.f6137c.execute(this);
    }
}
