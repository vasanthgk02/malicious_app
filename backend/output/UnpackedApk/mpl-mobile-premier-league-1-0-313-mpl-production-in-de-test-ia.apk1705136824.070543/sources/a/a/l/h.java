package a.a.l;

import a.a.a.a.d.b;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class h extends Group {

    /* renamed from: a  reason: collision with root package name */
    public Label f2676a;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            h.this.f2676a.visible = false;
        }
    }

    public h() {
        Texture a2 = b.f2412b.a("message1");
        TextureFilter textureFilter = TextureFilter.Linear;
        a2.setFilter(textureFilter, textureFilter);
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle.fontColor = Color.WHITE;
        labelStyle.background = new TextureRegionDrawable(new TextureRegion(a2));
        Label label = new Label(" System can broadcast message to all the game tables which will be shown here ", labelStyle);
        this.f2676a = label;
        label.setAlignment(1);
        Label label2 = this.f2676a;
        label2.wrap = true;
        label2.invalidateHierarchy();
        Label label3 = this.f2676a;
        float f2 = com.cfg.mendikot.a.h;
        float f3 = com.cfg.mendikot.a.i;
        label3.setSize(1760.0f, 100.0f);
        Label label4 = this.f2676a;
        float f4 = com.cfg.mendikot.a.j;
        label4.setPosition(200.0f, com.cfg.mendikot.a.k);
        this.f2676a.setFontScale(1.3f);
        Label label5 = this.f2676a;
        label5.visible = false;
        addActor(label5);
    }

    public void a(String str, int i) {
        this.f2676a.clearActions();
        this.f2676a.setText((CharSequence) str);
        Label label = this.f2676a;
        label.visible = true;
        label.addAction(k.delay((float) i, k.run(new a())));
    }
}
