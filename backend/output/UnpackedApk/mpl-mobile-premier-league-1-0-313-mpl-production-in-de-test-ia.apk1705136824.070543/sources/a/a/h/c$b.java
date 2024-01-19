package a.a.h;

import a.a.l.b;
import com.cfg.mendikot.game.AndroidLauncher;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class c$b implements Observer<b> {
    public void onComplete() {
    }

    public void onError(Throwable th) {
    }

    public void onNext(Object obj) {
        b bVar = (b) obj;
        bVar.toString();
        b bVar2 = ((com.cfg.mendikot.b) a.a.a.a.d.b.f9c).p;
        if (bVar2 != null) {
            try {
                ((AndroidLauncher) bVar2).g.f2243a.get(bVar.f2519a).a();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
    }
}
