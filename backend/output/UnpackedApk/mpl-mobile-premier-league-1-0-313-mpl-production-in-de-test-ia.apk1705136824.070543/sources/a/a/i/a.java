package a.a.i;

import a.a.a.a.d.b;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.xiaomi.mipush.sdk.Constants;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;

public class a extends Group {

    /* renamed from: a  reason: collision with root package name */
    public Image f2520a;

    /* renamed from: b  reason: collision with root package name */
    public Label f2521b;

    /* renamed from: c  reason: collision with root package name */
    public Label f2522c;

    /* renamed from: d  reason: collision with root package name */
    public Label f2523d;

    /* renamed from: e  reason: collision with root package name */
    public Label f2524e;

    /* renamed from: f  reason: collision with root package name */
    public a.a.b.a f2525f;

    public a(int i, int i2, char c2) {
        Texture a2 = b.f2412b.a("round_counter");
        TextureFilter textureFilter = TextureFilter.Linear;
        Image outline22 = GeneratedOutlineSupport.outline22(a2, textureFilter, textureFilter, a2);
        this.f2520a = outline22;
        outline22.setSize(240.0f, 300.0f);
        this.f2520a.setPosition(-4.0f, -5.0f);
        addActor(this.f2520a);
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle.fontColor = Color.WHITE;
        Label label = new Label("R", labelStyle);
        this.f2524e = label;
        label.setAlignment(1);
        Label label2 = this.f2524e;
        label2.wrap = true;
        label2.invalidateHierarchy();
        this.f2524e.setFontScale(2.0f);
        this.f2524e.setSize(60.0f, 60.0f);
        this.f2524e.setPosition(30.0f, 150.0f);
        LabelStyle labelStyle2 = new LabelStyle();
        labelStyle2.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle2.fontColor = Color.WHITE;
        Label label3 = new Label(StandardStructureTypes.H, labelStyle2);
        this.f2522c = label3;
        label3.setAlignment(1);
        Label label4 = this.f2522c;
        label4.wrap = true;
        label4.invalidateHierarchy();
        this.f2522c.setFontScale(2.0f);
        this.f2522c.setSize(60.0f, 60.0f);
        this.f2522c.setPosition(130.0f, 150.0f);
        LabelStyle labelStyle3 = new LabelStyle();
        labelStyle3.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle3.fontColor = Color.WHITE;
        Label label5 = new Label(Constants.ACCEPT_TIME_SEPARATOR_SERVER, labelStyle3);
        this.f2523d = label5;
        label5.setAlignment(2);
        Label label6 = this.f2523d;
        label6.wrap = true;
        label6.invalidateHierarchy();
        this.f2523d.setFontScale(2.5f);
        this.f2523d.setSize(80.0f, 80.0f);
        this.f2523d.setPosition(22.0f, 35.0f);
        addActor(this.f2523d);
        LabelStyle labelStyle4 = new LabelStyle();
        labelStyle4.font = b.f2414d.a("Rajdhani-Bold");
        labelStyle4.fontColor = Color.WHITE;
        Label label7 = new Label(Constants.ACCEPT_TIME_SEPARATOR_SERVER, labelStyle4);
        this.f2521b = label7;
        label7.setAlignment(2);
        Label label8 = this.f2521b;
        label8.wrap = true;
        label8.invalidateHierarchy();
        this.f2521b.setFontScale(2.5f);
        this.f2521b.setSize(80.0f, 80.0f);
        this.f2521b.setPosition(127.0f, 35.0f);
        addActor(this.f2521b);
        a.a.b.a aVar = new a.a.b.a("suit_spade_sprite_sheet", 5, 13);
        this.f2525f = aVar;
        aVar.setPosition(126.0f, 190.0f);
        this.f2525f.setSize(90.0f, 90.0f);
        a.a.b.a aVar2 = this.f2525f;
        aVar2.visible = false;
        addActor(aVar2);
        a(i2);
        b(i);
        a(c2);
        setScale(0.9f);
        setPosition(10.0f, 10.0f);
    }

    public void a(char c2) {
        a.a.b.a aVar;
        String str;
        if (c2 == 'C') {
            aVar = this.f2525f;
            str = "suit_club_sprite_sheet";
        } else if (c2 == 'D') {
            aVar = this.f2525f;
            str = "suit_diamond_sprite_sheet";
        } else if (c2 == 'H') {
            aVar = this.f2525f;
            str = "suit_heart_sprite_sheet";
        } else if (c2 != 'S') {
            this.f2525f.visible = false;
            return;
        } else {
            aVar = this.f2525f;
            str = "suit_spade_sprite_sheet";
        }
        aVar.a(str, 5, 13);
        a.a.b.a aVar2 = this.f2525f;
        aVar2.visible = true;
        aVar2.visible = true;
        aVar2.i = 0;
        Sound sound = aVar2.f2439e;
        if (sound != null) {
            sound.stop();
        }
        aVar2.f2439e = null;
        aVar2.clearActions();
    }

    public void a(int i) {
        float f2;
        Label label;
        if (i < 1 || i > 13) {
            this.f2521b.setText((CharSequence) Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            return;
        }
        if (i / 10 == 0) {
            label = this.f2521b;
            f2 = 129.0f;
        } else {
            label = this.f2521b;
            f2 = 126.0f;
        }
        label.setPosition(f2, 35.0f);
        Label label2 = this.f2521b;
        label2.setText((CharSequence) "" + i);
    }

    public void b(int i) {
        if (i == -1) {
            this.f2523d.setText((CharSequence) Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            return;
        }
        Label label = this.f2523d;
        label.setText((CharSequence) "" + i);
    }
}
