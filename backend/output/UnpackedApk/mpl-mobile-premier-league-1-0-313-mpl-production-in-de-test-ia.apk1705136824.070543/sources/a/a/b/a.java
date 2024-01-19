package a.a.b;

import a.a.a.a.d.b;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class a extends Actor {

    /* renamed from: a  reason: collision with root package name */
    public int f2435a = 5;

    /* renamed from: b  reason: collision with root package name */
    public int f2436b = 5;

    /* renamed from: c  reason: collision with root package name */
    public Animation<TextureRegion> f2437c;

    /* renamed from: d  reason: collision with root package name */
    public Texture f2438d;

    /* renamed from: e  reason: collision with root package name */
    public Sound f2439e;

    /* renamed from: f  reason: collision with root package name */
    public TextureRegion[][] f2440f;
    public TextureRegion[] g;
    public float h;
    public int i = 0;

    public a(String str, int i2, int i3) {
        a(str, i2, i3);
    }

    public void a(String str, int i2, int i3) {
        this.f2436b = i2;
        this.f2435a = i3;
        Texture a2 = b.f2412b.a(str);
        this.f2438d = a2;
        TextureFilter textureFilter = TextureFilter.Linear;
        a2.setFilter(textureFilter, textureFilter);
        Texture texture = this.f2438d;
        this.f2440f = TextureRegion.split(texture, texture.getWidth() / this.f2435a, this.f2438d.getHeight() / this.f2436b);
        this.g = new TextureRegion[(this.f2435a * this.f2436b)];
        int i4 = 0;
        for (int i5 = 0; i5 < this.f2436b; i5++) {
            int i6 = 0;
            while (i6 < this.f2435a) {
                this.g[i4] = this.f2440f[i5][i6];
                i6++;
                i4++;
            }
        }
        this.f2437c = new Animation<>(0.025f, (T[]) this.g);
        this.h = 0.0f;
    }

    public void draw(Batch batch, float f2) {
        float f3 = this.h + ((AndroidGraphics) k.graphics).deltaTime;
        this.h = f3;
        batch.draw((TextureRegion) this.f2437c.getKeyFrame(f3, true), this.x, this.y, this.originX, this.originY, this.width, this.height, this.scaleX, this.scaleY, this.rotation);
    }
}
