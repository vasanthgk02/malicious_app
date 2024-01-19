package com.badlogic.gdx.graphics.g2d.freetype;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph;
import com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun;
import com.badlogic.gdx.graphics.g2d.PixmapPacker;
import com.badlogic.gdx.graphics.g2d.PixmapPacker.GuillotineStrategy;
import com.badlogic.gdx.graphics.g2d.PixmapPacker.PackStrategy;
import com.badlogic.gdx.graphics.g2d.PixmapPacker.SkylineStrategy;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType.Bitmap;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType.Face;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType.GlyphMetrics;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType.GlyphSlot;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType.Library;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType.SizeMetrics;
import com.badlogic.gdx.graphics.g2d.freetype.FreeType.Stroker;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;

public class FreeTypeFontGenerator implements Disposable {
    public static final String DEFAULT_CHARS = "\u0000ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890\"!`?'.,;:()[]{}<>|/@\\^$€-%+=#_&~* ¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõö÷øùúûüýþÿ";
    public static final int NO_MAXIMUM = -1;
    public static int maxTextureSize = 1024;
    public boolean bitmapped;
    public final Face face;
    public final Library library;
    public final String name;
    public int pixelHeight;
    public int pixelWidth;

    /* renamed from: com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$badlogic$gdx$graphics$g2d$freetype$FreeTypeFontGenerator$Hinting;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0032 */
        static {
            /*
                com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator$Hinting[] r0 = com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.Hinting.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$badlogic$gdx$graphics$g2d$freetype$FreeTypeFontGenerator$Hinting = r0
                r1 = 1
                com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator$Hinting r2 = com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.Hinting.None     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$com$badlogic$gdx$graphics$g2d$freetype$FreeTypeFontGenerator$Hinting     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator$Hinting r3 = com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.Hinting.Slight     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                r1 = 3
                int[] r2 = $SwitchMap$com$badlogic$gdx$graphics$g2d$freetype$FreeTypeFontGenerator$Hinting     // Catch:{ NoSuchFieldError -> 0x001d }
                com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator$Hinting r3 = com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.Hinting.Medium     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r0 = 4
                int[] r2 = $SwitchMap$com$badlogic$gdx$graphics$g2d$freetype$FreeTypeFontGenerator$Hinting     // Catch:{ NoSuchFieldError -> 0x0024 }
                com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator$Hinting r3 = com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.Hinting.Full     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                r1 = 5
                int[] r2 = $SwitchMap$com$badlogic$gdx$graphics$g2d$freetype$FreeTypeFontGenerator$Hinting     // Catch:{ NoSuchFieldError -> 0x002b }
                com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator$Hinting r3 = com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.Hinting.AutoSlight     // Catch:{ NoSuchFieldError -> 0x002b }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r0 = 6
                int[] r2 = $SwitchMap$com$badlogic$gdx$graphics$g2d$freetype$FreeTypeFontGenerator$Hinting     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator$Hinting r3 = com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.Hinting.AutoMedium     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r1 = $SwitchMap$com$badlogic$gdx$graphics$g2d$freetype$FreeTypeFontGenerator$Hinting     // Catch:{ NoSuchFieldError -> 0x0039 }
                com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator$Hinting r2 = com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.Hinting.AutoFull     // Catch:{ NoSuchFieldError -> 0x0039 }
                r2 = 7
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.AnonymousClass1.<clinit>():void");
        }
    }

    public static class FreeTypeBitmapFontData extends BitmapFontData implements Disposable {
        public boolean dirty;
        public FreeTypeFontGenerator generator;
        public Array<Glyph> glyphs;
        public PixmapPacker packer;
        public FreeTypeFontParameter parameter;
        public Array<TextureRegion> regions;
        public Stroker stroker;

        public void dispose() {
            Stroker stroker2 = this.stroker;
            if (stroker2 != null) {
                stroker2.dispose();
            }
            PixmapPacker pixmapPacker = this.packer;
            if (pixmapPacker != null) {
                pixmapPacker.dispose();
            }
        }

        public Glyph getGlyph(char c2) {
            Glyph glyph = super.getGlyph(c2);
            if (glyph == null) {
                FreeTypeFontGenerator freeTypeFontGenerator = this.generator;
                if (freeTypeFontGenerator != null) {
                    freeTypeFontGenerator.setPixelSizes(0, this.parameter.size);
                    glyph = this.generator.createGlyph(c2, this, this.parameter, this.stroker, ((this.flipped ? -this.ascent : this.ascent) + this.capHeight) / this.scaleY, this.packer);
                    if (glyph == null) {
                        return this.missingGlyph;
                    }
                    setGlyphRegion(glyph, (TextureRegion) this.regions.get(glyph.page));
                    setGlyph(c2, glyph);
                    this.glyphs.add(glyph);
                    this.dirty = true;
                    Face face = this.generator.face;
                    if (this.parameter.kerning) {
                        int charIndex = face.getCharIndex(c2);
                        int i = this.glyphs.size;
                        for (int i2 = 0; i2 < i; i2++) {
                            Glyph glyph2 = (Glyph) this.glyphs.get(i2);
                            int charIndex2 = face.getCharIndex(glyph2.id);
                            int kerning = face.getKerning(charIndex, charIndex2, 0);
                            if (kerning != 0) {
                                glyph.setKerning(glyph2.id, FreeType.toInt(kerning));
                            }
                            int kerning2 = face.getKerning(charIndex2, charIndex, 0);
                            if (kerning2 != 0) {
                                glyph2.setKerning(c2, FreeType.toInt(kerning2));
                            }
                        }
                    }
                }
            }
            return glyph;
        }

        public void getGlyphs(GlyphRun glyphRun, CharSequence charSequence, int i, int i2, Glyph glyph) {
            PixmapPacker pixmapPacker = this.packer;
            if (pixmapPacker != null) {
                pixmapPacker.setPackToTexture(true);
            }
            super.getGlyphs(glyphRun, charSequence, i, i2, glyph);
            if (this.dirty) {
                this.dirty = false;
                PixmapPacker pixmapPacker2 = this.packer;
                Array<TextureRegion> array = this.regions;
                FreeTypeFontParameter freeTypeFontParameter = this.parameter;
                pixmapPacker2.updateTextureRegions(array, freeTypeFontParameter.minFilter, freeTypeFontParameter.magFilter, freeTypeFontParameter.genMipMaps);
            }
        }
    }

    public static class FreeTypeFontParameter {
        public Color borderColor = Color.BLACK;
        public float borderGamma = 1.8f;
        public boolean borderStraight = false;
        public float borderWidth = 0.0f;
        public String characters = FreeTypeFontGenerator.DEFAULT_CHARS;
        public Color color = Color.WHITE;
        public boolean flip = false;
        public float gamma = 1.8f;
        public boolean genMipMaps = false;
        public Hinting hinting = Hinting.AutoMedium;
        public boolean incremental;
        public boolean kerning = true;
        public TextureFilter magFilter;
        public TextureFilter minFilter;
        public boolean mono;
        public PixmapPacker packer = null;
        public int padBottom;
        public int padLeft;
        public int padRight;
        public int padTop;
        public int renderCount = 2;
        public Color shadowColor = new Color(0.0f, 0.0f, 0.0f, 0.75f);
        public int shadowOffsetX = 0;
        public int shadowOffsetY = 0;
        public int size = 16;
        public int spaceX;
        public int spaceY;

        public FreeTypeFontParameter() {
            TextureFilter textureFilter = TextureFilter.Nearest;
            this.minFilter = textureFilter;
            this.magFilter = textureFilter;
        }
    }

    public class GlyphAndBitmap {
        public Bitmap bitmap;
        public Glyph glyph;

        public GlyphAndBitmap() {
        }
    }

    public enum Hinting {
        None,
        Slight,
        Medium,
        Full,
        AutoSlight,
        AutoMedium,
        AutoFull
    }

    public FreeTypeFontGenerator(FileHandle fileHandle) {
        this(fileHandle, 0);
    }

    private boolean checkForBitmapFont() {
        int faceFlags = this.face.getFaceFlags();
        int i = FreeType.FT_FACE_FLAG_FIXED_SIZES;
        if ((faceFlags & i) == i) {
            int i2 = FreeType.FT_FACE_FLAG_HORIZONTAL;
            if ((faceFlags & i2) == i2 && loadChar(32) && this.face.getGlyph().getFormat() == 1651078259) {
                this.bitmapped = true;
            }
        }
        return this.bitmapped;
    }

    private int getLoadingFlags(FreeTypeFontParameter freeTypeFontParameter) {
        int i;
        int i2;
        int i3;
        int i4 = FreeType.FT_LOAD_DEFAULT;
        switch (freeTypeFontParameter.hinting.ordinal()) {
            case 0:
                i = FreeType.FT_LOAD_NO_HINTING;
                break;
            case 1:
                i = FreeType.FT_LOAD_TARGET_LIGHT;
                break;
            case 2:
                i = FreeType.FT_LOAD_TARGET_NORMAL;
                break;
            case 3:
                i = FreeType.FT_LOAD_TARGET_MONO;
                break;
            case 4:
                i2 = FreeType.FT_LOAD_FORCE_AUTOHINT;
                i3 = FreeType.FT_LOAD_TARGET_LIGHT;
                break;
            case 5:
                i2 = FreeType.FT_LOAD_FORCE_AUTOHINT;
                i3 = FreeType.FT_LOAD_TARGET_NORMAL;
                break;
            case 6:
                i2 = FreeType.FT_LOAD_FORCE_AUTOHINT;
                i3 = FreeType.FT_LOAD_TARGET_MONO;
                break;
            default:
                return i4;
        }
        i = i2 | i3;
        return i4 | i;
    }

    public static int getMaxTextureSize() {
        return maxTextureSize;
    }

    private boolean loadChar(int i) {
        return loadChar(i, FreeType.FT_LOAD_DEFAULT | FreeType.FT_LOAD_FORCE_AUTOHINT);
    }

    public static void setMaxTextureSize(int i) {
        maxTextureSize = i;
    }

    public Glyph createGlyph(char c2, FreeTypeBitmapFontData freeTypeBitmapFontData, FreeTypeFontParameter freeTypeFontParameter, Stroker stroker, float f2, PixmapPacker pixmapPacker) {
        Bitmap bitmap;
        FreeType.Glyph glyph;
        ByteBuffer byteBuffer;
        byte b2;
        char c3 = c2;
        FreeTypeFontParameter freeTypeFontParameter2 = freeTypeFontParameter;
        float f3 = f2;
        PixmapPacker pixmapPacker2 = pixmapPacker;
        if ((this.face.getCharIndex(c3) == 0 && c3 != 0) || !loadChar(c3, getLoadingFlags(freeTypeFontParameter2))) {
            return null;
        }
        GlyphSlot glyph2 = this.face.getGlyph();
        FreeType.Glyph glyph3 = glyph2.getGlyph();
        try {
            glyph3.toBitmap(freeTypeFontParameter2.mono ? FreeType.FT_RENDER_MODE_MONO : FreeType.FT_RENDER_MODE_NORMAL);
            Bitmap bitmap2 = glyph3.getBitmap();
            Pixmap pixmap = bitmap2.getPixmap(Format.RGBA8888, freeTypeFontParameter2.color, freeTypeFontParameter2.gamma);
            if (bitmap2.getWidth() == 0 || bitmap2.getRows() == 0) {
                bitmap = bitmap2;
            } else {
                if (freeTypeFontParameter2.borderWidth > 0.0f) {
                    int top = glyph3.getTop();
                    int left = glyph3.getLeft();
                    FreeType.Glyph glyph4 = glyph2.getGlyph();
                    glyph4.strokeBorder(stroker, false);
                    glyph4.toBitmap(freeTypeFontParameter2.mono ? FreeType.FT_RENDER_MODE_MONO : FreeType.FT_RENDER_MODE_NORMAL);
                    int left2 = left - glyph4.getLeft();
                    int i = -(top - glyph4.getTop());
                    Pixmap pixmap2 = glyph4.getBitmap().getPixmap(Format.RGBA8888, freeTypeFontParameter2.borderColor, freeTypeFontParameter2.borderGamma);
                    int i2 = freeTypeFontParameter2.renderCount;
                    for (int i3 = 0; i3 < i2; i3++) {
                        pixmap2.drawPixmap(pixmap, left2, i);
                    }
                    pixmap.dispose();
                    glyph3.dispose();
                    pixmap = pixmap2;
                    glyph3 = glyph4;
                }
                if (freeTypeFontParameter2.shadowOffsetX == 0 && freeTypeFontParameter2.shadowOffsetY == 0) {
                    if (freeTypeFontParameter2.borderWidth == 0.0f) {
                        int i4 = freeTypeFontParameter2.renderCount - 1;
                        for (int i5 = 0; i5 < i4; i5++) {
                            pixmap.drawPixmap(pixmap, 0, 0);
                        }
                    }
                    bitmap = bitmap2;
                    glyph = glyph3;
                } else {
                    int width = pixmap.getWidth();
                    int height = pixmap.getHeight();
                    int max = Math.max(freeTypeFontParameter2.shadowOffsetX, 0);
                    int max2 = Math.max(freeTypeFontParameter2.shadowOffsetY, 0);
                    int abs = Math.abs(freeTypeFontParameter2.shadowOffsetX) + width;
                    glyph = glyph3;
                    Pixmap pixmap3 = new Pixmap(abs, Math.abs(freeTypeFontParameter2.shadowOffsetY) + height, pixmap.getFormat());
                    Color color = freeTypeFontParameter2.shadowColor;
                    float f4 = color.f3306a;
                    if (f4 != 0.0f) {
                        byte b3 = (byte) ((int) (color.r * 255.0f));
                        bitmap = bitmap2;
                        byte b4 = (byte) ((int) (color.g * 255.0f));
                        byte b5 = (byte) ((int) (color.f3307b * 255.0f));
                        ByteBuffer pixels = pixmap.getPixels();
                        ByteBuffer pixels2 = pixmap3.getPixels();
                        int i6 = 0;
                        while (i6 < height) {
                            int i7 = ((i6 + max2) * abs) + max;
                            int i8 = height;
                            int i9 = 0;
                            while (i9 < width) {
                                int i10 = width;
                                byte b6 = pixels.get((((width * i6) + i9) * 4) + 3);
                                if (b6 == 0) {
                                    byteBuffer = pixels;
                                    b2 = b3;
                                } else {
                                    byteBuffer = pixels;
                                    int i11 = (i7 + i9) * 4;
                                    pixels2.put(i11, b3);
                                    b2 = b3;
                                    pixels2.put(i11 + 1, b4);
                                    pixels2.put(i11 + 2, b5);
                                    pixels2.put(i11 + 3, (byte) ((int) (((float) (b6 & 255)) * f4)));
                                }
                                i9++;
                                b3 = b2;
                                width = i10;
                                pixels = byteBuffer;
                            }
                            ByteBuffer byteBuffer2 = pixels;
                            byte b7 = b3;
                            int i12 = width;
                            i6++;
                            height = i8;
                        }
                    } else {
                        bitmap = bitmap2;
                    }
                    int i13 = freeTypeFontParameter2.renderCount;
                    for (int i14 = 0; i14 < i13; i14++) {
                        pixmap3.drawPixmap(pixmap, Math.max(-freeTypeFontParameter2.shadowOffsetX, 0), Math.max(-freeTypeFontParameter2.shadowOffsetY, 0));
                    }
                    pixmap.dispose();
                    pixmap = pixmap3;
                }
                if (freeTypeFontParameter2.padTop > 0 || freeTypeFontParameter2.padLeft > 0 || freeTypeFontParameter2.padBottom > 0 || freeTypeFontParameter2.padRight > 0) {
                    Pixmap pixmap4 = new Pixmap(pixmap.getWidth() + freeTypeFontParameter2.padLeft + freeTypeFontParameter2.padRight, pixmap.getHeight() + freeTypeFontParameter2.padTop + freeTypeFontParameter2.padBottom, pixmap.getFormat());
                    pixmap4.setBlending(Blending.None);
                    pixmap4.drawPixmap(pixmap, freeTypeFontParameter2.padLeft, freeTypeFontParameter2.padTop);
                    pixmap.dispose();
                    glyph3 = glyph;
                    pixmap = pixmap4;
                } else {
                    glyph3 = glyph;
                }
            }
            GlyphMetrics metrics = glyph2.getMetrics();
            Glyph glyph5 = new Glyph();
            glyph5.id = c2;
            glyph5.width = pixmap.getWidth();
            glyph5.height = pixmap.getHeight();
            glyph5.xoffset = glyph3.getLeft();
            if (freeTypeFontParameter2.flip) {
                glyph5.yoffset = (-glyph3.getTop()) + ((int) f2);
            } else {
                glyph5.yoffset = (-(glyph5.height - glyph3.getTop())) - ((int) f2);
            }
            glyph5.xadvance = FreeType.toInt(metrics.getHoriAdvance()) + ((int) freeTypeFontParameter2.borderWidth) + freeTypeFontParameter2.spaceX;
            if (this.bitmapped) {
                pixmap.setColor(Color.CLEAR);
                pixmap.fill();
                ByteBuffer buffer = bitmap.getBuffer();
                int intBits = Color.WHITE.toIntBits();
                int intBits2 = Color.CLEAR.toIntBits();
                for (int i15 = 0; i15 < glyph5.height; i15++) {
                    int pitch = bitmap.getPitch() * i15;
                    for (int i16 = 0; i16 < glyph5.width + glyph5.xoffset; i16++) {
                        pixmap.drawPixel(i16, i15, ((buffer.get((i16 / 8) + pitch) >>> (7 - (i16 % 8))) & 1) == 1 ? intBits : intBits2);
                    }
                }
            }
            PixmapPacker pixmapPacker3 = pixmapPacker;
            Rectangle pack = pixmapPacker3.pack(pixmap);
            int i17 = pixmapPacker.getPages().size - 1;
            glyph5.page = i17;
            glyph5.srcX = (int) pack.x;
            glyph5.srcY = (int) pack.y;
            if (freeTypeFontParameter2.incremental) {
                Array<TextureRegion> array = freeTypeBitmapFontData.regions;
                if (array != null && array.size <= i17) {
                    pixmapPacker3.updateTextureRegions(array, freeTypeFontParameter2.minFilter, freeTypeFontParameter2.magFilter, freeTypeFontParameter2.genMipMaps);
                }
            }
            pixmap.dispose();
            glyph3.dispose();
            return glyph5;
        } catch (GdxRuntimeException unused) {
            char c4 = c3;
            glyph3.dispose();
            Application application = k.app;
            application.log("FreeTypeFontGenerator", "Couldn't render char: " + c4);
            return null;
        }
    }

    public void dispose() {
        this.face.dispose();
        this.library.dispose();
    }

    public FreeTypeBitmapFontData generateData(int i) {
        FreeTypeFontParameter freeTypeFontParameter = new FreeTypeFontParameter();
        freeTypeFontParameter.size = i;
        return generateData(freeTypeFontParameter);
    }

    public BitmapFont generateFont(FreeTypeFontParameter freeTypeFontParameter) {
        return generateFont(freeTypeFontParameter, new FreeTypeBitmapFontData());
    }

    public GlyphAndBitmap generateGlyphAndBitmap(int i, int i2, boolean z) {
        setPixelSizes(0, i2);
        int i3 = FreeType.toInt(this.face.getSize().getMetrics().getAscender());
        Bitmap bitmap = null;
        if (this.face.getCharIndex(i) == 0) {
            return null;
        }
        if (loadChar(i)) {
            GlyphSlot glyph = this.face.getGlyph();
            if (this.bitmapped) {
                bitmap = glyph.getBitmap();
            } else if (glyph.renderGlyph(FreeType.FT_RENDER_MODE_NORMAL)) {
                bitmap = glyph.getBitmap();
            }
            GlyphMetrics metrics = glyph.getMetrics();
            Glyph glyph2 = new Glyph();
            if (bitmap != null) {
                glyph2.width = bitmap.getWidth();
                glyph2.height = bitmap.getRows();
            } else {
                glyph2.width = 0;
                glyph2.height = 0;
            }
            glyph2.xoffset = glyph.getBitmapLeft();
            glyph2.yoffset = z ? (-glyph.getBitmapTop()) + i3 : (-(glyph2.height - glyph.getBitmapTop())) - i3;
            glyph2.xadvance = FreeType.toInt(metrics.getHoriAdvance());
            glyph2.srcX = 0;
            glyph2.srcY = 0;
            glyph2.id = i;
            GlyphAndBitmap glyphAndBitmap = new GlyphAndBitmap();
            glyphAndBitmap.glyph = glyph2;
            glyphAndBitmap.bitmap = bitmap;
            return glyphAndBitmap;
        }
        throw new GdxRuntimeException((String) "Unable to load character!");
    }

    public BitmapFont newBitmapFont(BitmapFontData bitmapFontData, Array<TextureRegion> array, boolean z) {
        return new BitmapFont(bitmapFontData, array, z);
    }

    public int scaleForPixelHeight(int i) {
        setPixelSizes(0, i);
        SizeMetrics metrics = this.face.getSize().getMetrics();
        return (i * i) / (FreeType.toInt(metrics.getAscender()) - FreeType.toInt(metrics.getDescender()));
    }

    public int scaleForPixelWidth(int i, int i2) {
        SizeMetrics metrics = this.face.getSize().getMetrics();
        int i3 = ((FreeType.toInt(metrics.getAscender()) - FreeType.toInt(metrics.getDescender())) * i) / (FreeType.toInt(metrics.getMaxAdvance()) * i2);
        setPixelSizes(0, i3);
        return i3;
    }

    public int scaleToFitSquare(int i, int i2, int i3) {
        return Math.min(scaleForPixelHeight(i2), scaleForPixelWidth(i, i3));
    }

    public void setPixelSizes(int i, int i2) {
        this.pixelWidth = i;
        this.pixelHeight = i2;
        if (!this.bitmapped && !this.face.setPixelSizes(i, i2)) {
            throw new GdxRuntimeException((String) "Couldn't set size for font");
        }
    }

    public String toString() {
        return this.name;
    }

    public FreeTypeFontGenerator(FileHandle fileHandle, int i) {
        this.bitmapped = false;
        this.name = fileHandle.nameWithoutExtension();
        Library initFreeType = FreeType.initFreeType();
        this.library = initFreeType;
        this.face = initFreeType.newFace(fileHandle, i);
        if (!checkForBitmapFont()) {
            setPixelSizes(0, 15);
        }
    }

    private boolean loadChar(int i, int i2) {
        return this.face.loadChar(i, i2);
    }

    public BitmapFont generateFont(FreeTypeFontParameter freeTypeFontParameter, FreeTypeBitmapFontData freeTypeBitmapFontData) {
        boolean z = false;
        boolean z2 = freeTypeBitmapFontData.regions == null && freeTypeFontParameter.packer != null;
        if (z2) {
            freeTypeBitmapFontData.regions = new Array<>();
        }
        generateData(freeTypeFontParameter, freeTypeBitmapFontData);
        if (z2) {
            freeTypeFontParameter.packer.updateTextureRegions(freeTypeBitmapFontData.regions, freeTypeFontParameter.minFilter, freeTypeFontParameter.magFilter, freeTypeFontParameter.genMipMaps);
        }
        if (!(freeTypeBitmapFontData.regions.size == 0)) {
            BitmapFont newBitmapFont = newBitmapFont(freeTypeBitmapFontData, freeTypeBitmapFontData.regions, true);
            if (freeTypeFontParameter.packer == null) {
                z = true;
            }
            newBitmapFont.setOwnsTexture(z);
            return newBitmapFont;
        }
        throw new GdxRuntimeException((String) "Unable to create a font with no texture regions.");
    }

    public FreeTypeBitmapFontData generateData(FreeTypeFontParameter freeTypeFontParameter) {
        return generateData(freeTypeFontParameter, new FreeTypeBitmapFontData());
    }

    public FreeTypeBitmapFontData generateData(FreeTypeFontParameter freeTypeFontParameter, FreeTypeBitmapFontData freeTypeBitmapFontData) {
        boolean z;
        PixmapPacker pixmapPacker;
        PixmapPacker pixmapPacker2;
        Stroker stroker;
        PixmapPacker pixmapPacker3;
        int[] iArr;
        int i;
        int nextPowerOfTwo;
        PackStrategy skylineStrategy;
        FreeTypeFontParameter freeTypeFontParameter2 = freeTypeFontParameter;
        FreeTypeBitmapFontData freeTypeBitmapFontData2 = freeTypeBitmapFontData;
        freeTypeBitmapFontData2.name = this.name + Constants.ACCEPT_TIME_SEPARATOR_SERVER + freeTypeFontParameter2.size;
        char[] charArray = freeTypeFontParameter2.characters.toCharArray();
        int length = charArray.length;
        boolean z2 = freeTypeFontParameter2.incremental;
        int loadingFlags = getLoadingFlags(freeTypeFontParameter);
        char c2 = 0;
        setPixelSizes(0, freeTypeFontParameter2.size);
        SizeMetrics metrics = this.face.getSize().getMetrics();
        freeTypeBitmapFontData2.flipped = freeTypeFontParameter2.flip;
        freeTypeBitmapFontData2.ascent = (float) FreeType.toInt(metrics.getAscender());
        freeTypeBitmapFontData2.descent = (float) FreeType.toInt(metrics.getDescender());
        float f2 = (float) FreeType.toInt(metrics.getHeight());
        freeTypeBitmapFontData2.lineHeight = f2;
        float f3 = freeTypeBitmapFontData2.ascent;
        if (this.bitmapped && f2 == 0.0f) {
            for (int i2 = 32; i2 < this.face.getNumGlyphs() + 32; i2++) {
                if (loadChar(i2, loadingFlags)) {
                    float f4 = (float) FreeType.toInt(this.face.getGlyph().getMetrics().getHeight());
                    float f5 = freeTypeBitmapFontData2.lineHeight;
                    if (f4 <= f5) {
                        f4 = f5;
                    }
                    freeTypeBitmapFontData2.lineHeight = f4;
                }
            }
        }
        freeTypeBitmapFontData2.lineHeight += (float) freeTypeFontParameter2.spaceY;
        if (loadChar(32, loadingFlags) || loadChar(108, loadingFlags)) {
            freeTypeBitmapFontData2.spaceXadvance = (float) FreeType.toInt(this.face.getGlyph().getMetrics().getHoriAdvance());
        } else {
            freeTypeBitmapFontData2.spaceXadvance = (float) this.face.getMaxAdvanceWidth();
        }
        char[] cArr = freeTypeBitmapFontData2.xChars;
        int length2 = cArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length2) {
                if (loadChar(cArr[i3], loadingFlags)) {
                    freeTypeBitmapFontData2.xHeight = (float) FreeType.toInt(this.face.getGlyph().getMetrics().getHeight());
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        if (freeTypeBitmapFontData2.xHeight != 0.0f) {
            char[] cArr2 = freeTypeBitmapFontData2.capChars;
            int length3 = cArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 < length3) {
                    if (loadChar(cArr2[i4], loadingFlags)) {
                        freeTypeBitmapFontData2.capHeight = (float) (Math.abs(freeTypeFontParameter2.shadowOffsetY) + FreeType.toInt(this.face.getGlyph().getMetrics().getHeight()));
                        break;
                    }
                    i4++;
                } else {
                    break;
                }
            }
            if (this.bitmapped || freeTypeBitmapFontData2.capHeight != 1.0f) {
                float f6 = freeTypeBitmapFontData2.ascent - freeTypeBitmapFontData2.capHeight;
                freeTypeBitmapFontData2.ascent = f6;
                float f7 = -freeTypeBitmapFontData2.lineHeight;
                freeTypeBitmapFontData2.down = f7;
                if (freeTypeFontParameter2.flip) {
                    freeTypeBitmapFontData2.ascent = -f6;
                    freeTypeBitmapFontData2.down = -f7;
                }
                PixmapPacker pixmapPacker4 = freeTypeFontParameter2.packer;
                if (pixmapPacker4 == null) {
                    if (z2) {
                        nextPowerOfTwo = maxTextureSize;
                        skylineStrategy = new GuillotineStrategy();
                    } else {
                        int ceil = (int) Math.ceil((double) freeTypeBitmapFontData2.lineHeight);
                        nextPowerOfTwo = MathUtils.nextPowerOfTwo((int) Math.sqrt((double) (ceil * ceil * length)));
                        int i5 = maxTextureSize;
                        if (i5 > 0) {
                            nextPowerOfTwo = Math.min(nextPowerOfTwo, i5);
                        }
                        skylineStrategy = new SkylineStrategy();
                    }
                    int i6 = nextPowerOfTwo;
                    PixmapPacker pixmapPacker5 = new PixmapPacker(i6, i6, Format.RGBA8888, 1, false, skylineStrategy);
                    pixmapPacker5.setTransparentColor(freeTypeFontParameter2.color);
                    pixmapPacker5.getTransparentColor().f3306a = 0.0f;
                    if (freeTypeFontParameter2.borderWidth > 0.0f) {
                        pixmapPacker5.setTransparentColor(freeTypeFontParameter2.borderColor);
                        pixmapPacker5.getTransparentColor().f3306a = 0.0f;
                    }
                    pixmapPacker = pixmapPacker5;
                    z = true;
                } else {
                    pixmapPacker = pixmapPacker4;
                    z = false;
                }
                if (z2) {
                    freeTypeBitmapFontData2.glyphs = new Array<>(true, length + 32);
                }
                Stroker stroker2 = null;
                if (freeTypeFontParameter2.borderWidth > 0.0f) {
                    stroker2 = this.library.createStroker();
                    stroker2.set((int) (freeTypeFontParameter2.borderWidth * 64.0f), freeTypeFontParameter2.borderStraight ? FreeType.FT_STROKER_LINECAP_BUTT : FreeType.FT_STROKER_LINECAP_ROUND, freeTypeFontParameter2.borderStraight ? FreeType.FT_STROKER_LINEJOIN_MITER_FIXED : FreeType.FT_STROKER_LINEJOIN_ROUND, 0);
                }
                Stroker stroker3 = stroker2;
                int[] iArr2 = new int[length];
                int i7 = 0;
                while (i7 < length) {
                    char c3 = charArray[i7];
                    iArr2[i7] = loadChar(c3, loadingFlags) ? FreeType.toInt(this.face.getGlyph().getMetrics().getHeight()) : 0;
                    if (c3 == 0) {
                        i = i7;
                        iArr = iArr2;
                        Stroker stroker4 = stroker3;
                        pixmapPacker3 = pixmapPacker;
                        stroker = stroker4;
                        Glyph createGlyph = createGlyph(0, freeTypeBitmapFontData, freeTypeFontParameter, stroker4, f3, pixmapPacker3);
                        if (!(createGlyph == null || createGlyph.width == 0 || createGlyph.height == 0)) {
                            freeTypeBitmapFontData2.setGlyph(0, createGlyph);
                            freeTypeBitmapFontData2.missingGlyph = createGlyph;
                            if (z2) {
                                freeTypeBitmapFontData2.glyphs.add(createGlyph);
                            }
                        }
                    } else {
                        i = i7;
                        iArr = iArr2;
                        stroker = stroker3;
                        pixmapPacker3 = pixmapPacker;
                    }
                    i7 = i + 1;
                    iArr2 = iArr;
                    pixmapPacker = pixmapPacker3;
                    stroker3 = stroker;
                }
                int[] iArr3 = iArr2;
                Stroker stroker5 = stroker3;
                PixmapPacker pixmapPacker6 = pixmapPacker;
                int i8 = length;
                while (i8 > 0) {
                    int i9 = iArr3[c2];
                    int i10 = 0;
                    for (int i11 = 1; i11 < i8; i11++) {
                        int i12 = iArr3[i11];
                        if (i12 > i9) {
                            i9 = i12;
                            i10 = i11;
                        }
                    }
                    char c4 = charArray[i10];
                    if (freeTypeBitmapFontData2.getGlyph(c4) == null) {
                        char c5 = c4;
                        Glyph createGlyph2 = createGlyph(c4, freeTypeBitmapFontData, freeTypeFontParameter, stroker5, f3, pixmapPacker6);
                        if (createGlyph2 != null) {
                            freeTypeBitmapFontData2.setGlyph(c5, createGlyph2);
                            if (z2) {
                                freeTypeBitmapFontData2.glyphs.add(createGlyph2);
                            }
                        }
                    }
                    i8--;
                    iArr3[i10] = iArr3[i8];
                    char c6 = charArray[i10];
                    charArray[i10] = charArray[i8];
                    charArray[i8] = c6;
                    c2 = 0;
                }
                Stroker stroker6 = stroker5;
                if (stroker6 != null && !z2) {
                    stroker6.dispose();
                }
                if (z2) {
                    freeTypeBitmapFontData2.generator = this;
                    freeTypeBitmapFontData2.parameter = freeTypeFontParameter2;
                    freeTypeBitmapFontData2.stroker = stroker6;
                    pixmapPacker2 = pixmapPacker6;
                    freeTypeBitmapFontData2.packer = pixmapPacker2;
                } else {
                    pixmapPacker2 = pixmapPacker6;
                }
                boolean hasKerning = freeTypeFontParameter2.kerning & this.face.hasKerning();
                freeTypeFontParameter2.kerning = hasKerning;
                if (hasKerning) {
                    for (int i13 = 0; i13 < length; i13++) {
                        char c7 = charArray[i13];
                        Glyph glyph = freeTypeBitmapFontData2.getGlyph(c7);
                        if (glyph != null) {
                            int charIndex = this.face.getCharIndex(c7);
                            for (int i14 = i13; i14 < length; i14++) {
                                char c8 = charArray[i14];
                                Glyph glyph2 = freeTypeBitmapFontData2.getGlyph(c8);
                                if (glyph2 != null) {
                                    int charIndex2 = this.face.getCharIndex(c8);
                                    int kerning = this.face.getKerning(charIndex, charIndex2, 0);
                                    if (kerning != 0) {
                                        glyph.setKerning(c8, FreeType.toInt(kerning));
                                    }
                                    int kerning2 = this.face.getKerning(charIndex2, charIndex, 0);
                                    if (kerning2 != 0) {
                                        glyph2.setKerning(c7, FreeType.toInt(kerning2));
                                    }
                                }
                            }
                        }
                    }
                }
                if (z) {
                    Array<TextureRegion> array = new Array<>();
                    freeTypeBitmapFontData2.regions = array;
                    pixmapPacker2.updateTextureRegions(array, freeTypeFontParameter2.minFilter, freeTypeFontParameter2.magFilter, freeTypeFontParameter2.genMipMaps);
                }
                Glyph glyph3 = freeTypeBitmapFontData2.getGlyph(' ');
                if (glyph3 == null) {
                    glyph3 = new Glyph();
                    glyph3.xadvance = ((int) freeTypeBitmapFontData2.spaceXadvance) + freeTypeFontParameter2.spaceX;
                    glyph3.id = 32;
                    freeTypeBitmapFontData2.setGlyph(32, glyph3);
                }
                if (glyph3.width == 0) {
                    glyph3.width = (int) (((float) glyph3.xadvance) + freeTypeBitmapFontData2.padRight);
                }
                return freeTypeBitmapFontData2;
            }
            throw new GdxRuntimeException((String) "No cap character found in font");
        }
        throw new GdxRuntimeException((String) "No x-height character found in font");
    }
}
