package a.a.f;

import com.cfg.mendikot.b;
import com.cfg.mendikot.b.g;
import com.cfg.mendikot.game.AndroidLauncher;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class b$b implements Observer<a> {
    public void onComplete() {
    }

    public void onError(Throwable th) {
    }

    public void onNext(Object obj) {
        a aVar = (a) obj;
        aVar.toString();
        b bVar = (b) a.a.a.a.d.b.f8c;
        if (bVar != null) {
            b.s = aVar;
            int i = g.f2359a[b.s.ordinal()];
            if (i == 1) {
                ((AndroidLauncher) bVar.p).a();
            } else if (i == 2) {
                ((AndroidLauncher) bVar.p).f();
            } else if (i == 3) {
                ((AndroidLauncher) bVar.p).b();
            }
        } else {
            throw null;
        }
    }

    public void onSubscribe(Disposable disposable) {
    }
}
