package a.a.l;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.cfg.mendikot.game.AndroidLauncher;
import com.mpl.androidapp.game.androidgames.cardGame.CardGameFeature;

public class f extends Group {

    /* renamed from: a  reason: collision with root package name */
    public Image f2583a;

    /* renamed from: b  reason: collision with root package name */
    public Image f2584b;

    /* renamed from: c  reason: collision with root package name */
    public Image f2585c;

    /* renamed from: d  reason: collision with root package name */
    public Image f2586d;

    /* renamed from: e  reason: collision with root package name */
    public c f2587e;

    public class a extends InputListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Texture f2588a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Texture f2589b;

        public a(Texture texture, Texture texture2) {
            this.f2588a = texture;
            this.f2589b = texture2;
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            f.this.f2585c.setDrawable(new TextureRegionDrawable(this.f2588a));
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            f.this.f2585c.setDrawable(new TextureRegionDrawable(this.f2589b));
            c cVar = f.this.f2587e;
            if (cVar != null) {
                g gVar = (g) cVar;
                d dVar = gVar.f2594a;
                if (dVar != null) {
                    String str = gVar.f2595b.f2678a;
                    b bVar = ((com.cfg.mendikot.b) dVar).p;
                    if (bVar != null) {
                        ((AndroidLauncher) bVar).a(str, (String) CardGameFeature.KEY_LEAVE_DATA);
                    }
                }
                f.this.visible = false;
            }
        }
    }

    public class b extends InputListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Texture f2591a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Texture f2592b;

        public b(Texture texture, Texture texture2) {
            this.f2591a = texture;
            this.f2592b = texture2;
        }

        public boolean touchDown(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            f.this.f2586d.setDrawable(new TextureRegionDrawable(this.f2591a));
            return true;
        }

        public void touchUp(InputEvent inputEvent, float f2, float f3, int i, int i2) {
            f.this.f2586d.setDrawable(new TextureRegionDrawable(this.f2592b));
            f.this.visible = false;
        }
    }

    public f(c cVar) {
        this.f2587e = cVar;
        Texture a2 = a.a.a.a.d.b.f2412b.a("leave_table_background");
        TextureFilter textureFilter = TextureFilter.Linear;
        Image outline22 = GeneratedOutlineSupport.outline22(a2, textureFilter, textureFilter, a2);
        this.f2583a = outline22;
        outline22.setSize(780.0f, 400.0f);
        this.f2583a.setPosition(690.0f, 290.0f);
        addActor(this.f2583a);
        Texture a3 = a.a.a.a.d.b.f2412b.a("leave_table_header");
        TextureFilter textureFilter2 = TextureFilter.Linear;
        Image outline222 = GeneratedOutlineSupport.outline22(a3, textureFilter2, textureFilter2, a3);
        this.f2584b = outline222;
        outline222.setSize(795.0f, 140.0f);
        this.f2584b.setPosition(682.5f, 655.0f);
        addActor(this.f2584b);
        Texture a4 = a.a.a.a.d.b.f2412b.a("leave_table_leave1");
        Texture a5 = a.a.a.a.d.b.f2412b.a("leave_table_leave1_down");
        TextureFilter textureFilter3 = TextureFilter.Linear;
        a4.setFilter(textureFilter3, textureFilter3);
        TextureFilter textureFilter4 = TextureFilter.Linear;
        Image outline223 = GeneratedOutlineSupport.outline22(a5, textureFilter4, textureFilter4, a4);
        this.f2585c = outline223;
        outline223.setSize(270.0f, 100.0f);
        this.f2585c.setPosition(765.0f, 340.0f);
        Image image = this.f2585c;
        image.touchable = Touchable.enabled;
        image.addListener(new a(a5, a4));
        addActor(this.f2585c);
        Texture a6 = a.a.a.a.d.b.f2412b.a("leave_table_cancel");
        Texture a7 = a.a.a.a.d.b.f2412b.a("leave_table_cancel1_down");
        TextureFilter textureFilter5 = TextureFilter.Linear;
        a6.setFilter(textureFilter5, textureFilter5);
        TextureFilter textureFilter6 = TextureFilter.Linear;
        Image outline224 = GeneratedOutlineSupport.outline22(a7, textureFilter6, textureFilter6, a6);
        this.f2586d = outline224;
        outline224.setSize(270.0f, 100.0f);
        this.f2586d.setPosition(1127.0f, 340.0f);
        Image image2 = this.f2586d;
        image2.touchable = Touchable.enabled;
        image2.addListener(new b(a7, a6));
        addActor(this.f2586d);
        this.visible = false;
        this.touchable = Touchable.enabled;
    }
}
