package com.badlogic.gdx.scenes.scene2d.ui;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Values;

public class Skin implements Disposable {
    public static final Class[] defaultTagClasses = {BitmapFont.class, Color.class, TintedDrawable.class, NinePatchDrawable.class, SpriteDrawable.class, TextureRegionDrawable.class, TiledDrawable.class, ButtonStyle.class, CheckBox$CheckBoxStyle.class, ImageButton$ImageButtonStyle.class, ImageTextButton$ImageTextButtonStyle.class, LabelStyle.class, List$ListStyle.class, ProgressBar$ProgressBarStyle.class, ScrollPaneStyle.class, SelectBox$SelectBoxStyle.class, Slider$SliderStyle.class, SplitPane$SplitPaneStyle.class, TextButtonStyle.class, TextField$TextFieldStyle.class, TextTooltip$TextTooltipStyle.class, Touchpad$TouchpadStyle.class, Tree$TreeStyle.class, Window$WindowStyle.class};
    public final ObjectMap<String, Class> jsonClassTags = new ObjectMap<>(defaultTagClasses.length, 0.8f);
    public ObjectMap<Class, ObjectMap<String, Object>> resources = new ObjectMap<>();
    public float scale = 1.0f;

    public static class TintedDrawable {
    }

    public Skin() {
        for (Class cls : defaultTagClasses) {
            this.jsonClassTags.put(cls.getSimpleName(), cls);
        }
    }

    public void add(String str, Object obj) {
        add(str, obj, obj.getClass());
    }

    public void dispose() {
        Values values = this.resources.values();
        if (values == null) {
            throw null;
        }
        while (values.hasNext()) {
            Values values2 = ((ObjectMap) values.next()).values();
            if (values2 != null) {
                while (values2.hasNext()) {
                    Object next = values2.next();
                    if (next instanceof Disposable) {
                        ((Disposable) next).dispose();
                    }
                }
            } else {
                throw null;
            }
        }
    }

    public Drawable getDrawable(String str) {
        Drawable spriteDrawable;
        Drawable spriteDrawable2;
        Class cls = Drawable.class;
        Drawable drawable = (Drawable) optional(str, cls);
        if (drawable != null) {
            return drawable;
        }
        try {
            TextureRegion region = getRegion(str);
            if (region instanceof AtlasRegion) {
                AtlasRegion atlasRegion = (AtlasRegion) region;
                if (atlasRegion.findValue("split") != null) {
                    spriteDrawable2 = new NinePatchDrawable(getPatch(str));
                } else if (!(!atlasRegion.rotate && atlasRegion.packedWidth == atlasRegion.originalWidth && atlasRegion.packedHeight == atlasRegion.originalHeight)) {
                    spriteDrawable2 = new SpriteDrawable(getSprite(str));
                }
                drawable = spriteDrawable2;
            }
            if (drawable == null) {
                Drawable textureRegionDrawable = new TextureRegionDrawable(region);
                try {
                    if (this.scale != 1.0f) {
                        scale(textureRegionDrawable);
                    }
                } catch (GdxRuntimeException unused) {
                }
                drawable = textureRegionDrawable;
            }
        } catch (GdxRuntimeException unused2) {
        }
        if (drawable == null) {
            NinePatch ninePatch = (NinePatch) optional(str, NinePatch.class);
            if (ninePatch != null) {
                spriteDrawable = new NinePatchDrawable(ninePatch);
            } else {
                Sprite sprite = (Sprite) optional(str, Sprite.class);
                if (sprite != null) {
                    spriteDrawable = new SpriteDrawable(sprite);
                } else {
                    throw new GdxRuntimeException(GeneratedOutlineSupport.outline50("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: ", str));
                }
            }
            drawable = spriteDrawable;
        }
        if (drawable instanceof BaseDrawable) {
            ((BaseDrawable) drawable).name = str;
        }
        add(str, drawable, cls);
        return drawable;
    }

    public BitmapFont getFont(String str) {
        Object obj;
        Class<BitmapFont> cls = BitmapFont.class;
        if (cls == Drawable.class) {
            obj = getDrawable(str);
        } else if (cls == TextureRegion.class) {
            obj = getRegion(str);
        } else if (cls == NinePatch.class) {
            obj = getPatch(str);
        } else if (cls == Sprite.class) {
            obj = getSprite(str);
        } else {
            ObjectMap objectMap = (ObjectMap) this.resources.get(cls);
            if (objectMap != null) {
                Object obj2 = objectMap.get(str);
                if (obj2 != null) {
                    obj = obj2;
                } else {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("No ");
                    outline73.append(cls.getName());
                    outline73.append(" registered with name: ");
                    outline73.append(str);
                    throw new GdxRuntimeException(outline73.toString());
                }
            } else {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("No ");
                outline732.append(cls.getName());
                outline732.append(" registered with name: ");
                outline732.append(str);
                throw new GdxRuntimeException(outline732.toString());
            }
        }
        return (BitmapFont) obj;
    }

    public NinePatch getPatch(String str) {
        Class cls = NinePatch.class;
        NinePatch ninePatch = (NinePatch) optional(str, cls);
        if (ninePatch != null) {
            return ninePatch;
        }
        try {
            TextureRegion region = getRegion(str);
            if (region instanceof AtlasRegion) {
                int[] findValue = ((AtlasRegion) region).findValue("split");
                if (findValue != null) {
                    ninePatch = new NinePatch(region, findValue[0], findValue[1], findValue[2], findValue[3]);
                    int[] findValue2 = ((AtlasRegion) region).findValue("pad");
                    if (findValue2 != null) {
                        ninePatch.setPadding((float) findValue2[0], (float) findValue2[1], (float) findValue2[2], (float) findValue2[3]);
                    }
                }
            }
            if (ninePatch == null) {
                ninePatch = new NinePatch(region);
            }
            if (this.scale != 1.0f) {
                ninePatch.scale(this.scale, this.scale);
            }
            add(str, ninePatch, cls);
            return ninePatch;
        } catch (GdxRuntimeException unused) {
            throw new GdxRuntimeException(GeneratedOutlineSupport.outline50("No NinePatch, TextureRegion, or Texture registered with name: ", str));
        }
    }

    public TextureRegion getRegion(String str) {
        Class cls = TextureRegion.class;
        TextureRegion textureRegion = (TextureRegion) optional(str, cls);
        if (textureRegion != null) {
            return textureRegion;
        }
        Texture texture = (Texture) optional(str, Texture.class);
        if (texture != null) {
            TextureRegion textureRegion2 = new TextureRegion(texture);
            add(str, textureRegion2, cls);
            return textureRegion2;
        }
        throw new GdxRuntimeException(GeneratedOutlineSupport.outline50("No TextureRegion or Texture registered with name: ", str));
    }

    public Sprite getSprite(String str) {
        Class cls = Sprite.class;
        Sprite sprite = (Sprite) optional(str, cls);
        if (sprite != null) {
            return sprite;
        }
        try {
            TextureRegion region = getRegion(str);
            if (region instanceof AtlasRegion) {
                AtlasRegion atlasRegion = (AtlasRegion) region;
                if (!(!atlasRegion.rotate && atlasRegion.packedWidth == atlasRegion.originalWidth && atlasRegion.packedHeight == atlasRegion.originalHeight)) {
                    sprite = new AtlasSprite(atlasRegion);
                }
            }
            if (sprite == null) {
                sprite = new Sprite(region);
            }
            if (this.scale != 1.0f) {
                sprite.setSize(sprite.getWidth() * this.scale, sprite.getHeight() * this.scale);
            }
            add(str, sprite, cls);
            return sprite;
        } catch (GdxRuntimeException unused) {
            throw new GdxRuntimeException(GeneratedOutlineSupport.outline50("No NinePatch, TextureRegion, or Texture registered with name: ", str));
        }
    }

    public <T> T optional(String str, Class<T> cls) {
        if (str != null) {
            ObjectMap objectMap = (ObjectMap) this.resources.get(cls);
            if (objectMap == null) {
                return null;
            }
            return objectMap.get(str);
        }
        throw new IllegalArgumentException("name cannot be null.");
    }

    public void scale(Drawable drawable) {
        drawable.setLeftWidth(drawable.getLeftWidth() * this.scale);
        drawable.setRightWidth(drawable.getRightWidth() * this.scale);
        drawable.setBottomHeight(drawable.getBottomHeight() * this.scale);
        drawable.setTopHeight(drawable.getTopHeight() * this.scale);
        drawable.setMinWidth(drawable.getMinWidth() * this.scale);
        drawable.setMinHeight(drawable.getMinHeight() * this.scale);
    }

    public void add(String str, Object obj, Class cls) {
        if (str == null) {
            throw new IllegalArgumentException("name cannot be null.");
        } else if (obj != null) {
            ObjectMap objectMap = (ObjectMap) this.resources.get(cls);
            if (objectMap == null) {
                objectMap = new ObjectMap((cls == TextureRegion.class || cls == Drawable.class || cls == Sprite.class) ? 256 : 64, 0.8f);
                this.resources.put(cls, objectMap);
            }
            objectMap.put(str, obj);
        } else {
            throw new IllegalArgumentException("resource cannot be null.");
        }
    }
}
