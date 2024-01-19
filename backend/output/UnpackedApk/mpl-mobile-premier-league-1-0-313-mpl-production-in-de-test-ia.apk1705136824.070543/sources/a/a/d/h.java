package a.a.d;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class h extends g {
    public f o;
    public float p = 0.0f;
    public a q;

    public class a extends InputListener {
        public a() {
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            h hVar = h.this;
            if (!hVar.q.h) {
                hVar.a(true);
                h hVar2 = h.this;
                f fVar = hVar2.o;
                if (fVar != null) {
                    a aVar = hVar2.q;
                    c cVar = (c) fVar;
                    for (int i3 = 0; i3 < cVar.f2472a.size(); i3++) {
                        h hVar3 = cVar.f2472a.get(i3);
                        if (aVar == null || i3 != aVar.f2463f) {
                            hVar3.a(false);
                        } else {
                            hVar3.a(true);
                        }
                        hVar3.setY(0.0f);
                    }
                }
            }
            h.this.q.i = false;
            return true;
        }

        public void touchDragged(InputEvent inputEvent, float f2, float f3, int i) {
            h hVar = h.this;
            if (hVar.q.h) {
                if (hVar.p == 0.0f) {
                    hVar.p = f3;
                }
                h hVar2 = h.this;
                hVar2.moveBy(0.0f, f3 - hVar2.p);
                h.this.q.i = true;
            }
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            h hVar = h.this;
            a aVar = hVar.q;
            float f4 = aVar.f2461c;
            if (aVar.h) {
                hVar.a(false);
                h hVar2 = h.this;
                f fVar = hVar2.o;
                if (fVar != null) {
                    ((c) fVar).b(hVar2.q, hVar2, true);
                }
            }
            h.this.q.i = false;
        }
    }

    public h(a aVar, f fVar) {
        super(aVar);
        this.q = aVar;
        this.o = fVar;
        float f2 = aVar.f2461c;
        float f3 = aVar.f2462d;
        this.originX = f2;
        this.originY = f3;
        addListener(new a());
    }

    public void a(boolean z) {
        Image image;
        TextureRegionDrawable textureRegionDrawable;
        this.q.h = z;
        this.f2486a.h = z;
        if (z) {
            image = this.f2487b;
            textureRegionDrawable = new TextureRegionDrawable(this.l);
        } else {
            image = this.f2487b;
            textureRegionDrawable = new TextureRegionDrawable(this.k);
        }
        image.setDrawable(textureRegionDrawable);
    }

    public void b(boolean z) {
        this.touchable = Touchable.disabled;
        super.a(false, z);
    }

    public void c(boolean z) {
        this.touchable = Touchable.enabled;
        super.a(true, z);
    }

    public void scaleChanged() {
    }

    public void setPosition(float f2, float f3) {
        int i = this.q.f2463f;
        super.setPosition(f2, f3);
    }
}
