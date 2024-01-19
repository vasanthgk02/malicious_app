package a.a.e;

import a.a.a.a.d.b;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.cfg.utilities.d;

public class a extends Actor {
    public Sound A;
    public Sound B;
    public Sound C;
    public Sound D;
    public float E;
    public int F = 0;

    /* renamed from: a  reason: collision with root package name */
    public Animation<TextureRegion> f2493a;

    /* renamed from: b  reason: collision with root package name */
    public Animation<TextureRegion> f2494b;

    /* renamed from: c  reason: collision with root package name */
    public Animation<TextureRegion> f2495c;

    /* renamed from: d  reason: collision with root package name */
    public Animation<TextureRegion> f2496d;

    /* renamed from: e  reason: collision with root package name */
    public Animation<TextureRegion> f2497e;

    /* renamed from: f  reason: collision with root package name */
    public Animation<TextureRegion> f2498f;
    public Animation<TextureRegion> g;
    public Animation<TextureRegion> h;
    public Animation<TextureRegion> i;
    public Texture j;
    public Texture k;
    public Texture l;
    public Texture m;
    public Texture n;
    public Texture o;
    public Texture p;
    public Texture q;
    public Texture r;
    public Sound s;
    public Sound t;
    public Sound u;
    public Sound v;
    public Sound w;
    public Sound z;

    /* renamed from: a.a.e.a$a  reason: collision with other inner class name */
    public class C0039a implements Runnable {
        public C0039a() {
        }

        public void run() {
            a aVar = a.this;
            aVar.visible = false;
            aVar.s.stop();
        }
    }

    public a() {
        int i2 = 0;
        Texture texture = new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), d.f2375a, "a_emoji1.png", b.f2411a));
        this.j = texture;
        TextureFilter textureFilter = TextureFilter.Linear;
        texture.setFilter(textureFilter, textureFilter);
        Texture texture2 = new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), d.f2375a, "a_emoji2.png", b.f2411a));
        this.k = texture2;
        TextureFilter textureFilter2 = TextureFilter.Linear;
        texture2.setFilter(textureFilter2, textureFilter2);
        Texture texture3 = new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), d.f2375a, "a_emoji3.png", b.f2411a));
        this.l = texture3;
        TextureFilter textureFilter3 = TextureFilter.Linear;
        texture3.setFilter(textureFilter3, textureFilter3);
        Texture texture4 = new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), d.f2375a, "a_emoji4.png", b.f2411a));
        this.m = texture4;
        TextureFilter textureFilter4 = TextureFilter.Linear;
        texture4.setFilter(textureFilter4, textureFilter4);
        Texture texture5 = new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), d.f2375a, "a_emoji5.png", b.f2411a));
        this.n = texture5;
        TextureFilter textureFilter5 = TextureFilter.Linear;
        texture5.setFilter(textureFilter5, textureFilter5);
        Texture texture6 = new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), d.f2375a, "a_emoji6.png", b.f2411a));
        this.o = texture6;
        TextureFilter textureFilter6 = TextureFilter.Linear;
        texture6.setFilter(textureFilter6, textureFilter6);
        Texture texture7 = new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), d.f2375a, "a_emoji7.png", b.f2411a));
        this.p = texture7;
        TextureFilter textureFilter7 = TextureFilter.Linear;
        texture7.setFilter(textureFilter7, textureFilter7);
        Texture texture8 = new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), d.f2375a, "a_emoji8.png", b.f2411a));
        this.q = texture8;
        TextureFilter textureFilter8 = TextureFilter.Linear;
        texture8.setFilter(textureFilter8, textureFilter8);
        Texture texture9 = new Texture(GeneratedOutlineSupport.outline21(new StringBuilder(), d.f2375a, "a_emoji9.png", b.f2411a));
        this.r = texture9;
        TextureFilter textureFilter9 = TextureFilter.Linear;
        texture9.setFilter(textureFilter9, textureFilter9);
        this.t = b.f2413c.a("soundEmoji1");
        this.u = b.f2413c.a("soundEmoji2");
        this.v = b.f2413c.a("soundEmoji3");
        this.w = b.f2413c.a("soundEmoji4");
        this.z = b.f2413c.a("soundEmoji5");
        this.A = b.f2413c.a("soundEmoji6");
        this.B = b.f2413c.a("soundEmoji7");
        this.C = b.f2413c.a("soundEmoji8");
        this.D = b.f2413c.a("soundEmoji9");
        Texture texture10 = this.j;
        TextureRegion[][] split = TextureRegion.split(texture10, texture10.getWidth() / 6, this.j.getHeight() / 4);
        TextureRegion[] textureRegionArr = new TextureRegion[24];
        int i3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = 0;
            while (i5 < 6) {
                textureRegionArr[i3] = split[i4][i5];
                i5++;
                i3++;
            }
        }
        Texture texture11 = this.k;
        TextureRegion[][] split2 = TextureRegion.split(texture11, texture11.getWidth() / 5, this.k.getHeight() / 2);
        TextureRegion[] textureRegionArr2 = new TextureRegion[10];
        int i6 = 0;
        for (int i7 = 0; i7 < 2; i7++) {
            int i8 = 0;
            while (i8 < 5) {
                textureRegionArr2[i6] = split2[i7][i8];
                i8++;
                i6++;
            }
        }
        Texture texture12 = this.l;
        TextureRegion[][] split3 = TextureRegion.split(texture12, texture12.getWidth() / 4, this.l.getHeight() / 2);
        TextureRegion[] textureRegionArr3 = new TextureRegion[8];
        int i9 = 0;
        for (int i10 = 0; i10 < 2; i10++) {
            int i11 = 0;
            while (i11 < 4) {
                textureRegionArr3[i9] = split3[i10][i11];
                i11++;
                i9++;
            }
        }
        Texture texture13 = this.m;
        TextureRegion[][] split4 = TextureRegion.split(texture13, texture13.getWidth() / 6, this.m.getHeight() / 4);
        TextureRegion[] textureRegionArr4 = new TextureRegion[24];
        int i12 = 0;
        for (int i13 = 0; i13 < 4; i13++) {
            int i14 = 0;
            while (i14 < 6) {
                textureRegionArr4[i12] = split4[i13][i14];
                i14++;
                i12++;
            }
        }
        Texture texture14 = this.n;
        TextureRegion[][] split5 = TextureRegion.split(texture14, texture14.getWidth() / 4, this.n.getHeight() / 2);
        TextureRegion[] textureRegionArr5 = new TextureRegion[8];
        int i15 = 0;
        for (int i16 = 0; i16 < 2; i16++) {
            int i17 = 0;
            while (i17 < 4) {
                textureRegionArr5[i15] = split5[i16][i17];
                i17++;
                i15++;
            }
        }
        Texture texture15 = this.o;
        TextureRegion[][] split6 = TextureRegion.split(texture15, texture15.getWidth() / 6, this.o.getHeight() / 4);
        TextureRegion[] textureRegionArr6 = new TextureRegion[24];
        int i18 = 0;
        for (int i19 = 0; i19 < 4; i19++) {
            int i20 = 0;
            while (i20 < 6) {
                textureRegionArr6[i18] = split6[i19][i20];
                i20++;
                i18++;
            }
        }
        Texture texture16 = this.p;
        TextureRegion[][] split7 = TextureRegion.split(texture16, texture16.getWidth() / 5, this.p.getHeight() / 4);
        TextureRegion[] textureRegionArr7 = new TextureRegion[20];
        int i21 = 0;
        for (int i22 = 0; i22 < 4; i22++) {
            int i23 = 0;
            while (i23 < 5) {
                textureRegionArr7[i21] = split7[i22][i23];
                i23++;
                i21++;
            }
        }
        Texture texture17 = this.q;
        TextureRegion[][] split8 = TextureRegion.split(texture17, texture17.getWidth() / 9, this.q.getHeight() / 3);
        TextureRegion[] textureRegionArr8 = new TextureRegion[27];
        int i24 = 0;
        for (int i25 = 0; i25 < 3; i25++) {
            int i26 = 0;
            while (i26 < 9) {
                textureRegionArr8[i24] = split8[i25][i26];
                i26++;
                i24++;
            }
        }
        Texture texture18 = this.r;
        TextureRegion[][] split9 = TextureRegion.split(texture18, texture18.getWidth() / 31, this.r.getHeight() / 1);
        TextureRegion[] textureRegionArr9 = new TextureRegion[31];
        int i27 = 0;
        int i28 = 0;
        while (i27 < 1) {
            while (i2 < 31) {
                textureRegionArr9[i28] = split9[i27][i2];
                i2++;
                i28++;
            }
            i27++;
            i2 = 0;
        }
        this.f2493a = new Animation<>(0.025f, (T[]) textureRegionArr);
        this.f2494b = new Animation<>(0.025f, (T[]) textureRegionArr2);
        this.f2495c = new Animation<>(0.025f, (T[]) textureRegionArr3);
        this.f2496d = new Animation<>(0.025f, (T[]) textureRegionArr4);
        this.f2497e = new Animation<>(0.025f, (T[]) textureRegionArr5);
        this.f2498f = new Animation<>(0.025f, (T[]) textureRegionArr6);
        this.g = new Animation<>(0.025f, (T[]) textureRegionArr7);
        this.h = new Animation<>(0.025f, (T[]) textureRegionArr8);
        this.i = new Animation<>(0.025f, (T[]) textureRegionArr9);
        this.E = 0.0f;
    }

    public void draw(Batch batch, float f2) {
        Animation<TextureRegion> animation;
        this.E += ((AndroidGraphics) k.graphics).deltaTime;
        switch (this.F) {
            case 1:
                animation = this.f2494b;
                break;
            case 2:
                animation = this.f2495c;
                break;
            case 3:
                animation = this.f2496d;
                break;
            case 4:
                animation = this.f2497e;
                break;
            case 5:
                animation = this.f2498f;
                break;
            case 6:
                animation = this.g;
                break;
            case 7:
                animation = this.h;
                break;
            case 8:
                animation = this.i;
                break;
            default:
                animation = this.f2493a;
                break;
        }
        batch.draw((TextureRegion) animation.getKeyFrame(this.E, true), this.x, this.y, this.originX, this.originY, this.width, this.height, this.scaleX, this.scaleY, this.rotation);
    }
}
