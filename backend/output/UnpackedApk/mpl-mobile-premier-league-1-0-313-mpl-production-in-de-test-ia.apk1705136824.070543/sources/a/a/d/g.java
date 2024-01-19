package a.a.d;

import a.a.a.a.d.b;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class g extends Group {

    /* renamed from: a  reason: collision with root package name */
    public a f2486a;

    /* renamed from: b  reason: collision with root package name */
    public Image f2487b;

    /* renamed from: c  reason: collision with root package name */
    public Image f2488c;

    /* renamed from: d  reason: collision with root package name */
    public Image f2489d;

    /* renamed from: e  reason: collision with root package name */
    public Image f2490e;

    /* renamed from: f  reason: collision with root package name */
    public Texture f2491f;
    public Texture g;
    public Texture h;
    public Texture i;
    public Texture j = b.f2412b.a("open_card_background");
    public Texture k = b.f2412b.a("open_card_background");
    public Texture l = b.f2412b.a("valid_card");
    public Texture m = b.f2412b.a("invalid_card");

    public g(a aVar) {
        this.f2486a = aVar;
        a(aVar, false);
        Image image = this.f2486a.g ? new Image(this.k) : new Image(this.j);
        this.f2487b = image;
        image.setSize(221.33333f, 280.0f);
        Image image2 = this.f2487b;
        a aVar2 = this.f2486a;
        image2.setPosition(aVar2.f2461c, aVar2.f2462d);
        addActor(this.f2487b);
        Image image3 = new Image(this.h);
        this.f2488c = image3;
        image3.setSize(73.77778f, 88.888885f);
        Image image4 = this.f2488c;
        a aVar3 = this.f2486a;
        image4.setPosition(aVar3.f2461c + 20.0f, aVar3.f2462d + 161.0f);
        addActor(this.f2488c);
        Image image5 = new Image(this.f2491f);
        this.f2489d = image5;
        image5.setSize(73.77778f, 85.42373f);
        Image image6 = this.f2489d;
        a aVar4 = this.f2486a;
        image6.setPosition(aVar4.f2461c + 20.0f, aVar4.f2462d + 56.0f);
        addActor(this.f2489d);
        Image image7 = new Image(this.g);
        this.f2490e = image7;
        image7.setSize(158.62224f, 189.8305f);
        Image image8 = this.f2490e;
        a aVar5 = this.f2486a;
        image8.setPosition((aVar5.f2461c - 5.0f) + 110.666664f, aVar5.f2462d - 15.0f);
        addActor(this.f2490e);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d8 A[Catch:{ Exception -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e5 A[Catch:{ Exception -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f6 A[Catch:{ Exception -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x010e A[Catch:{ Exception -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0180 A[Catch:{ Exception -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x018b A[Catch:{ Exception -> 0x0195 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(a.a.d.a r8, boolean r9) {
        /*
            r7 = this;
            char r0 = r8.f2459a     // Catch:{ Exception -> 0x0195 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0195 }
            char r8 = r8.f2460b     // Catch:{ Exception -> 0x0195 }
            r1 = 67
            java.lang.String r2 = "red"
            java.lang.String r3 = "black"
            java.lang.String r4 = "grey"
            java.lang.String r5 = "C"
            java.lang.String r6 = "D"
            if (r8 == r1) goto L_0x00a9
            r1 = 68
            java.lang.String r5 = ""
            if (r8 == r1) goto L_0x007f
            r1 = 72
            if (r8 == r1) goto L_0x0054
            r1 = 83
            if (r8 == r1) goto L_0x0027
            r2 = r5
            goto L_0x00d4
        L_0x0027:
            if (r9 == 0) goto L_0x003d
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_spade_grey"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r7.f2491f = r8     // Catch:{ Exception -> 0x0195 }
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_spade_grey1"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r2 = r4
            goto L_0x0050
        L_0x003d:
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_spade"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r7.f2491f = r8     // Catch:{ Exception -> 0x0195 }
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_spade_grey2"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r2 = r3
        L_0x0050:
            java.lang.String r5 = "S"
            goto L_0x00d2
        L_0x0054:
            if (r9 == 0) goto L_0x006a
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_heart_grey"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r7.f2491f = r8     // Catch:{ Exception -> 0x0195 }
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_heart_grey1"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r2 = r4
            goto L_0x007c
        L_0x006a:
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_heart"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r7.f2491f = r8     // Catch:{ Exception -> 0x0195 }
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_heart_grey2"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
        L_0x007c:
            java.lang.String r5 = "H"
            goto L_0x00d2
        L_0x007f:
            if (r9 == 0) goto L_0x0095
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_diamond_grey"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r7.f2491f = r8     // Catch:{ Exception -> 0x0195 }
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_diamond_grey1"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r2 = r4
            goto L_0x00a7
        L_0x0095:
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_diamond"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r7.f2491f = r8     // Catch:{ Exception -> 0x0195 }
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_diamond_grey2"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
        L_0x00a7:
            r5 = r6
            goto L_0x00d2
        L_0x00a9:
            if (r9 == 0) goto L_0x00bf
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_club_grey"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r7.f2491f = r8     // Catch:{ Exception -> 0x0195 }
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_club_grey1"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r2 = r4
            goto L_0x00d2
        L_0x00bf:
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_club"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r7.f2491f = r8     // Catch:{ Exception -> 0x0195 }
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "suit_club_grey3"
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r2 = r3
        L_0x00d2:
            r7.g = r8     // Catch:{ Exception -> 0x0195 }
        L_0x00d4:
            com.badlogic.gdx.graphics.Texture r8 = r7.f2491f     // Catch:{ Exception -> 0x0195 }
            if (r8 == 0) goto L_0x00e1
            com.badlogic.gdx.graphics.Texture r8 = r7.f2491f     // Catch:{ Exception -> 0x0195 }
            com.badlogic.gdx.graphics.Texture$TextureFilter r9 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear     // Catch:{ Exception -> 0x0195 }
            com.badlogic.gdx.graphics.Texture$TextureFilter r1 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear     // Catch:{ Exception -> 0x0195 }
            r8.setFilter(r9, r1)     // Catch:{ Exception -> 0x0195 }
        L_0x00e1:
            com.badlogic.gdx.graphics.Texture r8 = r7.g     // Catch:{ Exception -> 0x0195 }
            if (r8 == 0) goto L_0x00ee
            com.badlogic.gdx.graphics.Texture r8 = r7.g     // Catch:{ Exception -> 0x0195 }
            com.badlogic.gdx.graphics.Texture$TextureFilter r9 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear     // Catch:{ Exception -> 0x0195 }
            com.badlogic.gdx.graphics.Texture$TextureFilter r1 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear     // Catch:{ Exception -> 0x0195 }
            r8.setFilter(r9, r1)     // Catch:{ Exception -> 0x0195 }
        L_0x00ee:
            java.lang.String r8 = "K"
            boolean r8 = r0.contentEquals(r8)     // Catch:{ Exception -> 0x0195 }
            if (r8 == 0) goto L_0x010e
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0195 }
            r9.<init>()     // Catch:{ Exception -> 0x0195 }
            java.lang.String r1 = "king_"
            r9.append(r1)     // Catch:{ Exception -> 0x0195 }
            java.lang.String r1 = r5.toLowerCase()     // Catch:{ Exception -> 0x0195 }
            r9.append(r1)     // Catch:{ Exception -> 0x0195 }
        L_0x0109:
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0195 }
            goto L_0x0146
        L_0x010e:
            java.lang.String r8 = "J"
            boolean r8 = r0.contentEquals(r8)     // Catch:{ Exception -> 0x0195 }
            if (r8 == 0) goto L_0x012a
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0195 }
            r9.<init>()     // Catch:{ Exception -> 0x0195 }
            java.lang.String r1 = "jack_"
            r9.append(r1)     // Catch:{ Exception -> 0x0195 }
            java.lang.String r1 = r5.toLowerCase()     // Catch:{ Exception -> 0x0195 }
            r9.append(r1)     // Catch:{ Exception -> 0x0195 }
            goto L_0x0109
        L_0x012a:
            java.lang.String r8 = "Q"
            boolean r8 = r0.contentEquals(r8)     // Catch:{ Exception -> 0x0195 }
            if (r8 == 0) goto L_0x014d
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0195 }
            r9.<init>()     // Catch:{ Exception -> 0x0195 }
            java.lang.String r1 = "queen_"
            r9.append(r1)     // Catch:{ Exception -> 0x0195 }
            java.lang.String r1 = r5.toLowerCase()     // Catch:{ Exception -> 0x0195 }
            r9.append(r1)     // Catch:{ Exception -> 0x0195 }
            goto L_0x0109
        L_0x0146:
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r7.i = r8     // Catch:{ Exception -> 0x0195 }
            goto L_0x0150
        L_0x014d:
            r8 = 0
            r7.i = r8     // Catch:{ Exception -> 0x0195 }
        L_0x0150:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0195 }
            r8.<init>()     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = "mCardFaceTexture = "
            r8.append(r9)     // Catch:{ Exception -> 0x0195 }
            com.badlogic.gdx.graphics.Texture r9 = r7.i     // Catch:{ Exception -> 0x0195 }
            r8.append(r9)     // Catch:{ Exception -> 0x0195 }
            r8.toString()     // Catch:{ Exception -> 0x0195 }
            a.a.c.d<java.lang.String, com.badlogic.gdx.graphics.Texture> r8 = a.a.a.a.d.b.f2412b     // Catch:{ Exception -> 0x0195 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0195 }
            r9.<init>()     // Catch:{ Exception -> 0x0195 }
            r9.append(r2)     // Catch:{ Exception -> 0x0195 }
            java.lang.String r1 = "_"
            r9.append(r1)     // Catch:{ Exception -> 0x0195 }
            r9.append(r0)     // Catch:{ Exception -> 0x0195 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0195 }
            com.badlogic.gdx.graphics.Texture r8 = r8.a(r9)     // Catch:{ Exception -> 0x0195 }
            r7.h = r8     // Catch:{ Exception -> 0x0195 }
            if (r8 == 0) goto L_0x0187
            com.badlogic.gdx.graphics.Texture$TextureFilter r9 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear     // Catch:{ Exception -> 0x0195 }
            com.badlogic.gdx.graphics.Texture$TextureFilter r0 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear     // Catch:{ Exception -> 0x0195 }
            r8.setFilter(r9, r0)     // Catch:{ Exception -> 0x0195 }
        L_0x0187:
            com.badlogic.gdx.graphics.Texture r8 = r7.i     // Catch:{ Exception -> 0x0195 }
            if (r8 == 0) goto L_0x0199
            com.badlogic.gdx.graphics.Texture r8 = r7.i     // Catch:{ Exception -> 0x0195 }
            com.badlogic.gdx.graphics.Texture$TextureFilter r9 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear     // Catch:{ Exception -> 0x0195 }
            com.badlogic.gdx.graphics.Texture$TextureFilter r0 = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear     // Catch:{ Exception -> 0x0195 }
            r8.setFilter(r9, r0)     // Catch:{ Exception -> 0x0195 }
            goto L_0x0199
        L_0x0195:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0199:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.d.g.a(a.a.d.a, boolean):void");
    }

    public void a(boolean z, boolean z2) {
        TextureRegionDrawable textureRegionDrawable;
        Image image;
        a aVar = this.f2486a;
        aVar.g = z;
        if (!z2) {
            a(aVar, false);
            image = this.f2487b;
            textureRegionDrawable = new TextureRegionDrawable(this.j);
        } else {
            a(aVar, !z);
            if (z) {
                image = this.f2487b;
                textureRegionDrawable = new TextureRegionDrawable(this.k);
            } else {
                image = this.f2487b;
                textureRegionDrawable = new TextureRegionDrawable(this.m);
            }
        }
        image.setDrawable(textureRegionDrawable);
        this.f2488c.setDrawable(new TextureRegionDrawable(this.h));
        this.f2489d.setDrawable(new TextureRegionDrawable(this.f2491f));
        this.f2490e.setDrawable(new TextureRegionDrawable(this.g));
    }
}
