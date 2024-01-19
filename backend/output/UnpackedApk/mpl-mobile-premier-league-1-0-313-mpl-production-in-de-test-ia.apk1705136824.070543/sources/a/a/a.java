package a.a;

import a.a.a.a.d.b;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.cfg.utilities.d;
import com.netcore.android.utility.f;
import java.util.Arrays;

public class a extends Image {

    /* renamed from: a  reason: collision with root package name */
    public ShaderProgram f2380a;

    /* renamed from: b  reason: collision with root package name */
    public float f2381b;

    /* renamed from: c  reason: collision with root package name */
    public float f2382c;

    /* renamed from: d  reason: collision with root package name */
    public float f2383d;

    /* renamed from: e  reason: collision with root package name */
    public float f2384e;

    /* renamed from: f  reason: collision with root package name */
    public float f2385f;
    public float g;
    public float h;
    public int i = 0;
    public float j = 0.0f;

    public a(Texture texture) {
        super(texture);
        ShaderProgram shaderProgram = new ShaderProgram(GeneratedOutlineSupport.outline21(new StringBuilder(), d.f2375a, "1-1.vsh", b.f2411a), GeneratedOutlineSupport.outline21(new StringBuilder(), d.f2375a, "1-1.fsh", b.f2411a));
        this.f2380a = shaderProgram;
        ShaderProgram.pedantic = false;
        if (!shaderProgram.isCompiled()) {
            this.f2380a.getLog();
        }
        Arrays.toString(this.f2380a.getUniforms());
        this.f2380a.getLog();
        this.g = 260.0f;
        this.h = 260.0f;
        setSize(260.0f, 260.0f);
        float f2 = com.cfg.mendikot.a.f2235a;
        this.f2381b = f2;
        float f3 = com.cfg.mendikot.a.f2236b;
        this.f2382c = f3;
        float f4 = f2 / f3;
        if (2.0f > f4) {
            float f5 = f2 / 2.0f;
            this.f2384e = f3 - f5;
            this.f2382c = f5;
        } else if (2.0f < f4) {
            float f6 = 2.0f * f3;
            this.f2383d = f2 - f6;
            this.f2381b = f6;
            this.f2385f = f3 / 1080.0f;
            return;
        } else {
            this.f2383d = 0.0f;
            this.f2384e = 0.0f;
        }
        this.f2385f = f2 / 2160.0f;
    }

    public void act(float f2) {
        this.i++;
        this.j += f2;
        float f3 = 0.0f;
        float f4 = 0.0f;
        Actor actor = this;
        do {
            float f5 = -actor.rotation;
            float f6 = actor.scaleX;
            float f7 = actor.scaleY;
            float f8 = actor.x;
            float f9 = actor.y;
            if (f5 == 0.0f) {
                if (f6 == 1.0f && f7 == 1.0f) {
                    f3 += f8;
                } else {
                    float f10 = actor.originX;
                    float f11 = actor.originY;
                    f3 = ((f3 - f10) * f6) + f10 + f8;
                    f4 = ((f4 - f11) * f7) + f11;
                }
                f4 += f9;
            } else {
                double d2 = (double) (f5 * 0.017453292f);
                float cos = (float) Math.cos(d2);
                float sin = (float) Math.sin(d2);
                float f12 = actor.originX;
                float f13 = actor.originY;
                float f14 = (f3 - f12) * f6;
                float f15 = (f4 - f13) * f7;
                float f16 = f15 * sin;
                f4 = (f15 * cos) + (f14 * (-sin)) + f13 + f9;
                f3 = f16 + (f14 * cos) + f12 + f8;
            }
            actor = actor.parent;
        } while (actor != 0);
        float f17 = this.width;
        float f18 = this.f2385f;
        float f19 = f17 * f18;
        float f20 = this.height * f18;
        float f21 = (this.f2383d / 2.0f) + (f3 * f18);
        float f22 = (this.f2384e / 2.0f) + (f4 * f18);
        if (this.i % 100 == 0) {
            String.valueOf(f21 / this.f2381b);
            String.valueOf(f22 / this.f2382c);
        }
        this.f2380a.begin();
        this.f2380a.setUniformf((String) "a", this.f2381b, this.f2382c);
        this.f2380a.setUniformf((String) "b", f21 / this.f2381b, f22 / this.f2382c);
        this.f2380a.setUniformf((String) "c", this.j);
        this.f2380a.setUniformf((String) "d", f20 / this.f2382c);
        this.f2380a.setUniformf((String) "e", f19 / this.f2381b);
        this.f2380a.setUniformf((String) f.f1288a, f20, f19);
        this.f2380a.end();
        super.act(f2);
    }

    public void draw(Batch batch, float f2) {
        batch.setShader(this.f2380a);
        super.draw(batch, f2);
        batch.setShader(null);
    }
}
