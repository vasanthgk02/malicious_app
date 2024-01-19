package a.a.d;

import a.a.l.d;
import a.a.l.g;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.cfg.mendikot.game.AndroidLauncher;
import java.util.ArrayList;
import java.util.HashSet;

public class c implements f {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<h> f2472a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f2473b;

    /* renamed from: c  reason: collision with root package name */
    public Group f2474c;

    /* renamed from: d  reason: collision with root package name */
    public Actor f2475d;

    /* renamed from: e  reason: collision with root package name */
    public int f2476e = 275;

    /* renamed from: f  reason: collision with root package name */
    public e f2477f;
    public Sound g;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f2478a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f2479b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f2480c;

        public a(h hVar, a aVar, int i) {
            this.f2478a = hVar;
            this.f2479b = aVar;
            this.f2480c = i;
        }

        public void run() {
            this.f2478a.touchable = Touchable.disabled;
            try {
                c.this.f2473b.remove(this.f2479b);
                c.this.f2472a.remove(this.f2480c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            c cVar = c.this;
            int i = this.f2480c;
            if (cVar != null) {
                int i2 = 0;
                while (i2 < cVar.f2472a.size()) {
                    try {
                        h hVar = cVar.f2472a.get(i2);
                        hVar.q.f2463f = i2;
                        if (i2 < i) {
                            hVar.moveBy(55.333332f, 0.0f);
                        } else {
                            hVar.moveBy(-55.333332f, 0.0f);
                        }
                        hVar.touchable = Touchable.disabled;
                        hVar.a(false);
                        hVar.setY(0.0f);
                        i2++;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f2482a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f2483b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f2484c;

        public b(h hVar, a aVar, boolean z) {
            this.f2482a = hVar;
            this.f2483b = aVar;
            this.f2484c = z;
        }

        public void run() {
            c.this.f2474c.removeActor(this.f2482a);
            e eVar = c.this.f2477f;
            if (eVar != null) {
                a aVar = this.f2483b;
                boolean z = this.f2484c;
                g gVar = (g) eVar;
                gVar.t.d(aVar);
                if (z) {
                    d dVar = gVar.f2594a;
                    if (dVar != null) {
                        String str = gVar.f2595b.f2678a;
                        a.a.l.b bVar = ((com.cfg.mendikot.b) dVar).p;
                        if (bVar != null) {
                            ((AndroidLauncher) bVar).g.f2243a.get(str).a(str, aVar.f2459a, aVar.f2460b);
                        }
                    }
                }
            }
        }
    }

    public c(Group group, Actor actor, ArrayList<a> arrayList, HashSet<Character> hashSet, e eVar) {
        this.f2473b = arrayList;
        this.f2474c = group;
        this.f2475d = actor;
        this.f2477f = eVar;
        this.g = a.a.a.a.d.b.f2413c.a("cardShuffle");
        for (int i = 0; i < this.f2473b.size(); i++) {
            a aVar = this.f2473b.get(i);
            float f2 = (float) i;
            aVar.f2461c = (110.666664f * f2) + (((float) (13 - this.f2473b.size())) * 55.333332f) + ((float) this.f2476e);
            aVar.f2462d = -50.0f;
            aVar.f2463f = i;
            h hVar = new h(aVar, this);
            this.f2472a.add(i, hVar);
            hVar.setScale(0.75f);
            hVar.addAction(k.delay(f2 * 0.05f, k.scaleTo(1.0f, 1.0f, 0.15f, Interpolation.fastSlow)));
            this.f2474c.addActorBefore(this.f2475d, hVar);
            if (this.f2473b.size() == 13 && this.f2474c.visible && com.cfg.mendikot.a.y) {
                this.g.play();
            }
        }
        a(hashSet, false);
        arrayList.toString();
    }

    public void a(HashSet<Character> hashSet, boolean z) {
        int i = 0;
        while (i < this.f2472a.size()) {
            try {
                h hVar = this.f2472a.get(i);
                if (z) {
                    if (hashSet != null && hashSet.size() > 0) {
                        if (hashSet.contains(Character.valueOf(hVar.q.f2460b))) {
                            hVar.c(z);
                        }
                    }
                    i++;
                }
                hVar.b(z);
                i++;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    public final void b(a aVar, h hVar, boolean z) {
        hVar.clearActions();
        float f2 = ((float) aVar.f2463f) * 110.666664f;
        int indexOf = this.f2473b.indexOf(aVar);
        MoveToAction moveTo = k.moveTo((1027.6848f - (f2 + (((float) (13 - this.f2473b.size())) * 55.333332f))) - 161.0f, 566.6667f, 0.2f);
        RotateByAction rotateBy = k.rotateBy(180.0f, 0.2f, Interpolation.fastSlow);
        ScaleToAction scaleTo = k.scaleTo(0.75f, 0.75f, 0.2f, null);
        RunnableAction run = k.run(new a(hVar, aVar, indexOf));
        ParallelAction parallelAction = (ParallelAction) k.action(ParallelAction.class);
        parallelAction.actions.add(moveTo);
        Actor actor = parallelAction.actor;
        if (actor != null) {
            moveTo.setActor(actor);
        }
        parallelAction.actions.add(rotateBy);
        Actor actor2 = parallelAction.actor;
        if (actor2 != null) {
            rotateBy.setActor(actor2);
        }
        parallelAction.actions.add(scaleTo);
        Actor actor3 = parallelAction.actor;
        if (actor3 != null) {
            scaleTo.setActor(actor3);
        }
        parallelAction.actions.add(run);
        Actor actor4 = parallelAction.actor;
        if (actor4 != null) {
            run.setActor(actor4);
        }
        hVar.addAction(k.sequence(parallelAction, k.run(new b(hVar, aVar, z))));
    }
}
