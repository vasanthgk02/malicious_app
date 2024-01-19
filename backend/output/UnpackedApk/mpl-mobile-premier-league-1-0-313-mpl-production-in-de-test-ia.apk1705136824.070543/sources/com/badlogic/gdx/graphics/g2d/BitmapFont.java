package com.badlogic.gdx.graphics.g2d;

import androidx.core.app.FrameMetricsAggregator;
import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import org.apache.pdfbox.filter.ASCII85InputStream;

public class BitmapFont implements Disposable {
    public static final int LOG2_PAGE_SIZE = 9;
    public static final int PAGES = 128;
    public static final int PAGE_SIZE = 512;
    public final BitmapFontCache cache;
    public final BitmapFontData data;
    public boolean flipped;
    public boolean integer;
    public boolean ownsTexture;
    public Array<TextureRegion> regions;

    public static class BitmapFontData {
        public float ascent;
        public float blankLineScale = 1.0f;
        public char[] breakChars;
        public char[] capChars = {'M', 'N', 'B', 'D', 'C', 'E', 'F', 'K', 'A', 'G', 'H', 'I', 'J', 'L', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        public float capHeight = 1.0f;
        public float cursorX;
        public float descent;
        public float down;
        public boolean flipped;
        public FileHandle fontFile;
        public final Glyph[][] glyphs = new Glyph[128][];
        public String[] imagePaths;
        public float lineHeight;
        public boolean markupEnabled;
        public Glyph missingGlyph;
        public String name;
        public float padBottom;
        public float padLeft;
        public float padRight;
        public float padTop;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float spaceXadvance;
        public char[] xChars = {'x', 'e', 'a', 'o', 'n', 's', 'r', 'c', ASCII85InputStream.PADDING_U, 'm', 'v', 'w', 'z'};
        public float xHeight = 1.0f;

        public BitmapFontData() {
        }

        public Glyph getFirstGlyph() {
            for (Glyph[] glyphArr : this.glyphs) {
                if (glyphArr != null) {
                    for (Glyph glyph : glyphArr) {
                        if (glyph != null && glyph.height != 0 && glyph.width != 0) {
                            return glyph;
                        }
                    }
                    continue;
                }
            }
            throw new GdxRuntimeException((String) "No glyphs found.");
        }

        public FileHandle getFontFile() {
            return this.fontFile;
        }

        public Glyph getGlyph(char c2) {
            Glyph[] glyphArr = this.glyphs[c2 / 512];
            if (glyphArr != null) {
                return glyphArr[c2 & 511];
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
            if (r0 == null) goto L_0x002c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void getGlyphs(com.badlogic.gdx.graphics.g2d.GlyphLayout.GlyphRun r7, java.lang.CharSequence r8, int r9, int r10, com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph r11) {
            /*
                r6 = this;
                int r0 = r10 - r9
                if (r0 != 0) goto L_0x0005
                return
            L_0x0005:
                boolean r1 = r6.markupEnabled
                float r2 = r6.scaleX
                com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph> r3 = r7.glyphs
                com.badlogic.gdx.utils.FloatArray r4 = r7.xAdvances
                r3.ensureCapacity(r0)
                com.badlogic.gdx.utils.FloatArray r7 = r7.xAdvances
                int r0 = r0 + 1
                r7.ensureCapacity(r0)
            L_0x0017:
                int r7 = r9 + 1
                char r9 = r8.charAt(r9)
                r0 = 13
                if (r9 != r0) goto L_0x0022
                goto L_0x002c
            L_0x0022:
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r0 = r6.getGlyph(r9)
                if (r0 != 0) goto L_0x002e
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r0 = r6.missingGlyph
                if (r0 != 0) goto L_0x002e
            L_0x002c:
                r9 = r7
                goto L_0x0062
            L_0x002e:
                r3.add(r0)
                if (r11 != 0) goto L_0x0043
                boolean r11 = r0.fixedWidth
                if (r11 == 0) goto L_0x0039
                r11 = 0
                goto L_0x004d
            L_0x0039:
                int r11 = r0.xoffset
                int r11 = -r11
                float r11 = (float) r11
                float r11 = r11 * r2
                float r5 = r6.padLeft
                float r11 = r11 - r5
                goto L_0x004d
            L_0x0043:
                int r5 = r11.xadvance
                int r11 = r11.getKerning(r9)
                int r11 = r11 + r5
                float r11 = (float) r11
                float r11 = r11 * r2
            L_0x004d:
                r4.add(r11)
                if (r1 == 0) goto L_0x0060
                r11 = 91
                if (r9 != r11) goto L_0x0060
                if (r7 >= r10) goto L_0x0060
                char r9 = r8.charAt(r7)
                if (r9 != r11) goto L_0x0060
                int r7 = r7 + 1
            L_0x0060:
                r9 = r7
                r11 = r0
            L_0x0062:
                if (r9 < r10) goto L_0x0017
                if (r11 == 0) goto L_0x007e
                boolean r7 = r11.fixedWidth
                if (r7 == 0) goto L_0x0070
                int r7 = r11.xadvance
                float r7 = (float) r7
                float r7 = r7 * r2
                goto L_0x007b
            L_0x0070:
                int r7 = r11.width
                int r8 = r11.xoffset
                int r7 = r7 + r8
                float r7 = (float) r7
                float r7 = r7 * r2
                float r8 = r6.padRight
                float r7 = r7 - r8
            L_0x007b:
                r4.add(r7)
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData.getGlyphs(com.badlogic.gdx.graphics.g2d.GlyphLayout$GlyphRun, java.lang.CharSequence, int, int, com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph):void");
        }

        public String getImagePath(int i) {
            return this.imagePaths[i];
        }

        public String[] getImagePaths() {
            return this.imagePaths;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
            if (isBreakChar(r0) == false) goto L_0x0018;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
            return r4 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
            return 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
            if (isBreakChar(r0) != false) goto L_0x0018;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
            r4 = r4 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
            if (r4 <= 0) goto L_0x0032;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
            r0 = (char) ((com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph) r3[r4]).id;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
            if (isWhitespace(r0) != false) goto L_0x002f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getWrapIndex(com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph> r3, int r4) {
            /*
                r2 = this;
                int r4 = r4 + -1
                T[] r3 = r3.items
                r0 = r3[r4]
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r0 = (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph) r0
                int r0 = r0.id
                char r0 = (char) r0
                boolean r1 = r2.isWhitespace(r0)
                if (r1 == 0) goto L_0x0012
                return r4
            L_0x0012:
                boolean r0 = r2.isBreakChar(r0)
                if (r0 == 0) goto L_0x001a
            L_0x0018:
                int r4 = r4 + -1
            L_0x001a:
                if (r4 <= 0) goto L_0x0032
                r0 = r3[r4]
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r0 = (com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph) r0
                int r0 = r0.id
                char r0 = (char) r0
                boolean r1 = r2.isWhitespace(r0)
                if (r1 != 0) goto L_0x002f
                boolean r0 = r2.isBreakChar(r0)
                if (r0 == 0) goto L_0x0018
            L_0x002f:
                int r4 = r4 + 1
                return r4
            L_0x0032:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData.getWrapIndex(com.badlogic.gdx.utils.Array, int):int");
        }

        public boolean hasGlyph(char c2) {
            boolean z = true;
            if (this.missingGlyph != null) {
                return true;
            }
            if (getGlyph(c2) == null) {
                z = false;
            }
            return z;
        }

        public boolean isBreakChar(char c2) {
            char[] cArr = this.breakChars;
            if (cArr == null) {
                return false;
            }
            for (char c3 : cArr) {
                if (c2 == c3) {
                    return true;
                }
            }
            return false;
        }

        public boolean isWhitespace(char c2) {
            return c2 == 9 || c2 == 10 || c2 == 13 || c2 == ' ';
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(11:144|(1:146)(1:(1:148)(1:201))|149|(1:151)(1:152)|153|(1:155)|156|(2:158|159)|160|161|(2:165|204)) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:160:0x03fc */
        /* JADX WARNING: Removed duplicated region for block: B:121:0x02d1 A[Catch:{ Exception -> 0x044e }] */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x02e7 A[Catch:{ Exception -> 0x044e }] */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x02ef A[Catch:{ Exception -> 0x044e }] */
        /* JADX WARNING: Removed duplicated region for block: B:199:0x0189 A[EDGE_INSN: B:199:0x0189->B:63:0x0189 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:205:0x0196 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:214:0x025c A[EDGE_INSN: B:214:0x025c->B:89:0x025c ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:215:0x0282 A[EDGE_INSN: B:215:0x0282->B:97:0x0282 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00d8 A[Catch:{ NumberFormatException -> 0x0110, Exception -> 0x0455, all -> 0x0450 }] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x017a  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0197 A[Catch:{ NumberFormatException -> 0x0110, Exception -> 0x0455, all -> 0x0450 }] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x020f A[Catch:{ NumberFormatException -> 0x0110, Exception -> 0x0455, all -> 0x0450 }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x022d A[Catch:{ NumberFormatException -> 0x0110, Exception -> 0x0455, all -> 0x0450 }] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x024c A[Catch:{ NumberFormatException -> 0x0110, Exception -> 0x0455, all -> 0x0450 }] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x025e A[Catch:{ NumberFormatException -> 0x0110, Exception -> 0x0455, all -> 0x0450 }] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0272 A[Catch:{ NumberFormatException -> 0x0110, Exception -> 0x0455, all -> 0x0450 }] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x0286 A[Catch:{ NumberFormatException -> 0x0110, Exception -> 0x0455, all -> 0x0450 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void load(com.badlogic.gdx.files.FileHandle r23, boolean r24) {
            /*
                r22 = this;
                r1 = r22
                java.lang.String[] r2 = r1.imagePaths
                if (r2 != 0) goto L_0x0478
                java.lang.String r2 = r23.nameWithoutExtension()
                r1.name = r2
                java.io.BufferedReader r2 = new java.io.BufferedReader
                java.io.InputStreamReader r3 = new java.io.InputStreamReader
                java.io.InputStream r4 = r23.read()
                r3.<init>(r4)
                r4 = 512(0x200, float:7.17E-43)
                r2.<init>(r3, r4)
                java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r3 == 0) goto L_0x0444
                java.lang.String r4 = "padding="
                int r4 = r3.indexOf(r4)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r4 = r4 + 8
                java.lang.String r3 = r3.substring(r4)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r4 = 32
                int r5 = r3.indexOf(r4)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r6 = 0
                java.lang.String r3 = r3.substring(r6, r5)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r5 = ","
                r7 = 4
                java.lang.String[] r3 = r3.split(r5, r7)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r5 = r3.length     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r5 != r7) goto L_0x043a
                r5 = r3[r6]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r5 = (float) r5     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r1.padTop = r5     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r5 = 1
                r7 = r3[r5]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r7 = (float) r7     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r1.padRight = r7     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r7 = 2
                r8 = r3[r7]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r8 = (float) r8     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r1.padBottom = r8     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8 = 3
                r3 = r3[r8]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r3 = (float) r3     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r1.padLeft = r3     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r3 = r1.padTop     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r9 = r1.padBottom     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r3 = r3 + r9
                java.lang.String r9 = r2.readLine()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r9 == 0) goto L_0x0430
                java.lang.String r10 = " "
                r11 = 9
                java.lang.String[] r9 = r9.split(r10, r11)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r10 = r9.length     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r10 < r8) goto L_0x0426
                r8 = r9[r5]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r10 = "lineHeight="
                boolean r8 = r8.startsWith(r10)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r8 == 0) goto L_0x041c
                r8 = r9[r5]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r10 = 11
                java.lang.String r8 = r8.substring(r10)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r8 = (float) r8     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r1.lineHeight = r8     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8 = r9[r7]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r10 = "base="
                boolean r8 = r8.startsWith(r10)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r8 == 0) goto L_0x0412
                r7 = r9[r7]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8 = 5
                java.lang.String r7 = r7.substring(r8)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r7 = (float) r7     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r10 = r9.length     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r11 = 6
                if (r10 < r11) goto L_0x00d0
                r10 = r9[r8]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r10 == 0) goto L_0x00d0
                r10 = r9[r8]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r12 = "pages="
                boolean r10 = r10.startsWith(r12)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r10 == 0) goto L_0x00d0
                r8 = r9[r8]     // Catch:{ NumberFormatException -> 0x00d0 }
                java.lang.String r8 = r8.substring(r11)     // Catch:{ NumberFormatException -> 0x00d0 }
                int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x00d0 }
                int r8 = java.lang.Math.max(r5, r8)     // Catch:{ NumberFormatException -> 0x00d0 }
                goto L_0x00d1
            L_0x00d0:
                r8 = 1
            L_0x00d1:
                java.lang.String[] r9 = new java.lang.String[r8]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r1.imagePaths = r9     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r9 = 0
            L_0x00d6:
                if (r9 >= r8) goto L_0x0169
                java.lang.String r10 = r2.readLine()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r10 == 0) goto L_0x0161
                java.lang.String r11 = ".*id=(\\d+)"
                java.util.regex.Pattern r11 = java.util.regex.Pattern.compile(r11)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.util.regex.Matcher r11 = r11.matcher(r10)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                boolean r12 = r11.find()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r12 == 0) goto L_0x0129
                java.lang.String r11 = r11.group(r5)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r12 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0110 }
                if (r12 != r9) goto L_0x00f9
                goto L_0x0129
            L_0x00f9:
                com.badlogic.gdx.utils.GdxRuntimeException r3 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ NumberFormatException -> 0x0110 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0110 }
                r4.<init>()     // Catch:{ NumberFormatException -> 0x0110 }
                java.lang.String r5 = "Page IDs must be indices starting at 0: "
                r4.append(r5)     // Catch:{ NumberFormatException -> 0x0110 }
                r4.append(r11)     // Catch:{ NumberFormatException -> 0x0110 }
                java.lang.String r4 = r4.toString()     // Catch:{ NumberFormatException -> 0x0110 }
                r3.<init>(r4)     // Catch:{ NumberFormatException -> 0x0110 }
                throw r3     // Catch:{ NumberFormatException -> 0x0110 }
            L_0x0110:
                r0 = move-exception
                r3 = r0
                com.badlogic.gdx.utils.GdxRuntimeException r4 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r5.<init>()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r6 = "Invalid page id: "
                r5.append(r6)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r5.append(r11)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r4.<init>(r5, r3)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                throw r4     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
            L_0x0129:
                java.lang.String r11 = ".*file=\"?([^\"]+)\"?"
                java.util.regex.Pattern r11 = java.util.regex.Pattern.compile(r11)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.util.regex.Matcher r10 = r11.matcher(r10)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                boolean r11 = r10.find()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r11 == 0) goto L_0x0159
                java.lang.String r10 = r10.group(r5)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String[] r11 = r1.imagePaths     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                com.badlogic.gdx.files.FileHandle r12 = r23.parent()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                com.badlogic.gdx.files.FileHandle r10 = r12.child(r10)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r10 = r10.path()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r12 = "\\\\"
                java.lang.String r13 = "/"
                java.lang.String r10 = r10.replaceAll(r12, r13)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r11[r9] = r10     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r9 = r9 + 1
                goto L_0x00d6
            L_0x0159:
                com.badlogic.gdx.utils.GdxRuntimeException r3 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r4 = "Missing: file"
                r3.<init>(r4)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                throw r3     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
            L_0x0161:
                com.badlogic.gdx.utils.GdxRuntimeException r3 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r4 = "Missing additional page definitions."
                r3.<init>(r4)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                throw r3     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
            L_0x0169:
                r8 = 0
                r1.descent = r8     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
            L_0x016c:
                java.lang.String r9 = r2.readLine()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r10 = "metrics "
                r11 = 65535(0xffff, float:9.1834E-41)
                java.lang.String r12 = " ="
                if (r9 != 0) goto L_0x017a
                goto L_0x0189
            L_0x017a:
                java.lang.String r13 = "kernings "
                boolean r13 = r9.startsWith(r13)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r13 == 0) goto L_0x0183
                goto L_0x0189
            L_0x0183:
                boolean r13 = r9.startsWith(r10)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r13 == 0) goto L_0x0344
            L_0x0189:
                float r9 = r1.descent     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r13 = r1.padBottom     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r9 = r9 + r13
                r1.descent = r9     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
            L_0x0190:
                java.lang.String r9 = r2.readLine()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r9 != 0) goto L_0x0197
                goto L_0x019f
            L_0x0197:
                java.lang.String r13 = "kerning "
                boolean r13 = r9.startsWith(r13)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r13 != 0) goto L_0x0301
            L_0x019f:
                if (r9 == 0) goto L_0x0202
                boolean r10 = r9.startsWith(r10)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r10 == 0) goto L_0x0202
                java.util.StringTokenizer r8 = new java.util.StringTokenizer     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8.<init>(r9, r12)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r9 = r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r10 = r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r10 = java.lang.Float.parseFloat(r10)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r11 = r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r11 = java.lang.Float.parseFloat(r11)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r12 = r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r12 = java.lang.Float.parseFloat(r12)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r13 = r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r13 = java.lang.Float.parseFloat(r13)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r14 = r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r14 = java.lang.Float.parseFloat(r14)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                java.lang.String r8 = r8.nextToken()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r8 = java.lang.Float.parseFloat(r8)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r21 = r9
                r9 = r8
                r8 = r21
                goto L_0x0209
            L_0x0202:
                r5 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
            L_0x0209:
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r15 = r1.getGlyph(r4)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r15 != 0) goto L_0x0229
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r15 = new com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r15.<init>()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r15.id = r4     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r6 = 108(0x6c, float:1.51E-43)
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r6 = r1.getGlyph(r6)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r6 != 0) goto L_0x0222
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r6 = r22.getFirstGlyph()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
            L_0x0222:
                int r6 = r6.xadvance     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r15.xadvance = r6     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r1.setGlyph(r4, r15)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
            L_0x0229:
                int r4 = r15.width     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r4 != 0) goto L_0x023f
                float r4 = r1.padLeft     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r6 = r15.xadvance     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r6 = (float) r6     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r4 = r4 + r6
                float r6 = r1.padRight     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r4 = r4 + r6
                int r4 = (int) r4     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r15.width = r4     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r4 = r1.padLeft     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r4 = -r4
                int r4 = (int) r4     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r15.xoffset = r4     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
            L_0x023f:
                int r4 = r15.xadvance     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r4 = (float) r4     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r1.spaceXadvance = r4     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                char[] r4 = r1.xChars     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r6 = r4.length     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r15 = 0
                r17 = 0
            L_0x024a:
                if (r15 >= r6) goto L_0x025c
                r18 = r6
                char r6 = r4[r15]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r17 = r1.getGlyph(r6)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r17 == 0) goto L_0x0257
                goto L_0x025c
            L_0x0257:
                int r15 = r15 + 1
                r6 = r18
                goto L_0x024a
            L_0x025c:
                if (r17 != 0) goto L_0x0262
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r17 = r22.getFirstGlyph()     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
            L_0x0262:
                r4 = r17
                int r4 = r4.height     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r4 = (float) r4     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                float r4 = r4 - r3
                r1.xHeight = r4     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                char[] r4 = r1.capChars     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r6 = r4.length     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r15 = 0
                r16 = 0
            L_0x0270:
                if (r15 >= r6) goto L_0x0282
                r17 = r6
                char r6 = r4[r15]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r16 = r1.getGlyph(r6)     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r16 == 0) goto L_0x027d
                goto L_0x0282
            L_0x027d:
                int r15 = r15 + 1
                r6 = r17
                goto L_0x0270
            L_0x0282:
                r15 = r16
                if (r15 != 0) goto L_0x02d1
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph[][] r4 = r1.glyphs     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                int r6 = r4.length     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r15 = 0
            L_0x028a:
                if (r15 >= r6) goto L_0x02ce
                r16 = r6
                r6 = r4[r15]     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                if (r6 != 0) goto L_0x0297
                r18 = r2
                r17 = r4
                goto L_0x02c5
            L_0x0297:
                r17 = r4
                int r4 = r6.length     // Catch:{ Exception -> 0x0455, all -> 0x0450 }
                r18 = r2
                r2 = 0
            L_0x029d:
                if (r2 >= r4) goto L_0x02c5
                r19 = r4
                r4 = r6[r2]     // Catch:{ Exception -> 0x044e }
                if (r4 == 0) goto L_0x02bc
                r20 = r6
                int r6 = r4.height     // Catch:{ Exception -> 0x044e }
                if (r6 == 0) goto L_0x02be
                int r6 = r4.width     // Catch:{ Exception -> 0x044e }
                if (r6 != 0) goto L_0x02b0
                goto L_0x02be
            L_0x02b0:
                float r6 = r1.capHeight     // Catch:{ Exception -> 0x044e }
                int r4 = r4.height     // Catch:{ Exception -> 0x044e }
                float r4 = (float) r4     // Catch:{ Exception -> 0x044e }
                float r4 = java.lang.Math.max(r6, r4)     // Catch:{ Exception -> 0x044e }
                r1.capHeight = r4     // Catch:{ Exception -> 0x044e }
                goto L_0x02be
            L_0x02bc:
                r20 = r6
            L_0x02be:
                int r2 = r2 + 1
                r4 = r19
                r6 = r20
                goto L_0x029d
            L_0x02c5:
                int r15 = r15 + 1
                r6 = r16
                r4 = r17
                r2 = r18
                goto L_0x028a
            L_0x02ce:
                r18 = r2
                goto L_0x02d8
            L_0x02d1:
                r18 = r2
                int r2 = r15.height     // Catch:{ Exception -> 0x044e }
                float r2 = (float) r2     // Catch:{ Exception -> 0x044e }
                r1.capHeight = r2     // Catch:{ Exception -> 0x044e }
            L_0x02d8:
                float r2 = r1.capHeight     // Catch:{ Exception -> 0x044e }
                float r2 = r2 - r3
                r1.capHeight = r2     // Catch:{ Exception -> 0x044e }
                float r7 = r7 - r2
                r1.ascent = r7     // Catch:{ Exception -> 0x044e }
                float r2 = r1.lineHeight     // Catch:{ Exception -> 0x044e }
                float r2 = -r2
                r1.down = r2     // Catch:{ Exception -> 0x044e }
                if (r24 == 0) goto L_0x02ed
                float r3 = -r7
                r1.ascent = r3     // Catch:{ Exception -> 0x044e }
                float r2 = -r2
                r1.down = r2     // Catch:{ Exception -> 0x044e }
            L_0x02ed:
                if (r5 == 0) goto L_0x02fd
                r1.ascent = r8     // Catch:{ Exception -> 0x044e }
                r1.descent = r10     // Catch:{ Exception -> 0x044e }
                r1.down = r11     // Catch:{ Exception -> 0x044e }
                r1.capHeight = r12     // Catch:{ Exception -> 0x044e }
                r1.lineHeight = r13     // Catch:{ Exception -> 0x044e }
                r1.spaceXadvance = r14     // Catch:{ Exception -> 0x044e }
                r1.xHeight = r9     // Catch:{ Exception -> 0x044e }
            L_0x02fd:
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(r18)
                return
            L_0x0301:
                r18 = r2
                java.util.StringTokenizer r2 = new java.util.StringTokenizer     // Catch:{ Exception -> 0x044e }
                r2.<init>(r9, r12)     // Catch:{ Exception -> 0x044e }
                r2.nextToken()     // Catch:{ Exception -> 0x044e }
                r2.nextToken()     // Catch:{ Exception -> 0x044e }
                java.lang.String r6 = r2.nextToken()     // Catch:{ Exception -> 0x044e }
                int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x044e }
                r2.nextToken()     // Catch:{ Exception -> 0x044e }
                java.lang.String r9 = r2.nextToken()     // Catch:{ Exception -> 0x044e }
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x044e }
                if (r6 < 0) goto L_0x033f
                if (r6 > r11) goto L_0x033f
                if (r9 < 0) goto L_0x033f
                if (r9 <= r11) goto L_0x032a
                goto L_0x033f
            L_0x032a:
                char r6 = (char) r6     // Catch:{ Exception -> 0x044e }
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r6 = r1.getGlyph(r6)     // Catch:{ Exception -> 0x044e }
                r2.nextToken()     // Catch:{ Exception -> 0x044e }
                java.lang.String r2 = r2.nextToken()     // Catch:{ Exception -> 0x044e }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x044e }
                if (r6 == 0) goto L_0x033f
                r6.setKerning(r9, r2)     // Catch:{ Exception -> 0x044e }
            L_0x033f:
                r2 = r18
                r6 = 0
                goto L_0x0190
            L_0x0344:
                r18 = r2
                java.lang.String r2 = "char "
                boolean r2 = r9.startsWith(r2)     // Catch:{ Exception -> 0x044e }
                if (r2 != 0) goto L_0x0353
            L_0x034e:
                r2 = r18
                r6 = 0
                goto L_0x016c
            L_0x0353:
                com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph r2 = new com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph     // Catch:{ Exception -> 0x044e }
                r2.<init>()     // Catch:{ Exception -> 0x044e }
                java.util.StringTokenizer r6 = new java.util.StringTokenizer     // Catch:{ Exception -> 0x044e }
                r6.<init>(r9, r12)     // Catch:{ Exception -> 0x044e }
                r6.nextToken()     // Catch:{ Exception -> 0x044e }
                r6.nextToken()     // Catch:{ Exception -> 0x044e }
                java.lang.String r9 = r6.nextToken()     // Catch:{ Exception -> 0x044e }
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x044e }
                if (r9 > 0) goto L_0x0370
                r1.missingGlyph = r2     // Catch:{ Exception -> 0x044e }
                goto L_0x0375
            L_0x0370:
                if (r9 > r11) goto L_0x034e
                r1.setGlyph(r9, r2)     // Catch:{ Exception -> 0x044e }
            L_0x0375:
                r2.id = r9     // Catch:{ Exception -> 0x044e }
                r6.nextToken()     // Catch:{ Exception -> 0x044e }
                java.lang.String r9 = r6.nextToken()     // Catch:{ Exception -> 0x044e }
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x044e }
                r2.srcX = r9     // Catch:{ Exception -> 0x044e }
                r6.nextToken()     // Catch:{ Exception -> 0x044e }
                java.lang.String r9 = r6.nextToken()     // Catch:{ Exception -> 0x044e }
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x044e }
                r2.srcY = r9     // Catch:{ Exception -> 0x044e }
                r6.nextToken()     // Catch:{ Exception -> 0x044e }
                java.lang.String r9 = r6.nextToken()     // Catch:{ Exception -> 0x044e }
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x044e }
                r2.width = r9     // Catch:{ Exception -> 0x044e }
                r6.nextToken()     // Catch:{ Exception -> 0x044e }
                java.lang.String r9 = r6.nextToken()     // Catch:{ Exception -> 0x044e }
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x044e }
                r2.height = r9     // Catch:{ Exception -> 0x044e }
                r6.nextToken()     // Catch:{ Exception -> 0x044e }
                java.lang.String r9 = r6.nextToken()     // Catch:{ Exception -> 0x044e }
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x044e }
                r2.xoffset = r9     // Catch:{ Exception -> 0x044e }
                r6.nextToken()     // Catch:{ Exception -> 0x044e }
                if (r24 == 0) goto L_0x03c8
                java.lang.String r9 = r6.nextToken()     // Catch:{ Exception -> 0x044e }
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x044e }
                r2.yoffset = r9     // Catch:{ Exception -> 0x044e }
                goto L_0x03d6
            L_0x03c8:
                int r9 = r2.height     // Catch:{ Exception -> 0x044e }
                java.lang.String r10 = r6.nextToken()     // Catch:{ Exception -> 0x044e }
                int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ Exception -> 0x044e }
                int r9 = r9 + r10
                int r9 = -r9
                r2.yoffset = r9     // Catch:{ Exception -> 0x044e }
            L_0x03d6:
                r6.nextToken()     // Catch:{ Exception -> 0x044e }
                java.lang.String r9 = r6.nextToken()     // Catch:{ Exception -> 0x044e }
                int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x044e }
                r2.xadvance = r9     // Catch:{ Exception -> 0x044e }
                boolean r9 = r6.hasMoreTokens()     // Catch:{ Exception -> 0x044e }
                if (r9 == 0) goto L_0x03ec
                r6.nextToken()     // Catch:{ Exception -> 0x044e }
            L_0x03ec:
                boolean r9 = r6.hasMoreTokens()     // Catch:{ Exception -> 0x044e }
                if (r9 == 0) goto L_0x03fc
                java.lang.String r6 = r6.nextToken()     // Catch:{ NumberFormatException -> 0x03fc }
                int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x03fc }
                r2.page = r6     // Catch:{ NumberFormatException -> 0x03fc }
            L_0x03fc:
                int r6 = r2.width     // Catch:{ Exception -> 0x044e }
                if (r6 <= 0) goto L_0x034e
                int r6 = r2.height     // Catch:{ Exception -> 0x044e }
                if (r6 <= 0) goto L_0x034e
                int r2 = r2.yoffset     // Catch:{ Exception -> 0x044e }
                float r2 = (float) r2     // Catch:{ Exception -> 0x044e }
                float r2 = r2 + r7
                float r6 = r1.descent     // Catch:{ Exception -> 0x044e }
                float r2 = java.lang.Math.min(r2, r6)     // Catch:{ Exception -> 0x044e }
                r1.descent = r2     // Catch:{ Exception -> 0x044e }
                goto L_0x034e
            L_0x0412:
                r18 = r2
                com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ Exception -> 0x044e }
                java.lang.String r3 = "Missing: base"
                r2.<init>(r3)     // Catch:{ Exception -> 0x044e }
                throw r2     // Catch:{ Exception -> 0x044e }
            L_0x041c:
                r18 = r2
                com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ Exception -> 0x044e }
                java.lang.String r3 = "Missing: lineHeight"
                r2.<init>(r3)     // Catch:{ Exception -> 0x044e }
                throw r2     // Catch:{ Exception -> 0x044e }
            L_0x0426:
                r18 = r2
                com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ Exception -> 0x044e }
                java.lang.String r3 = "Invalid common header."
                r2.<init>(r3)     // Catch:{ Exception -> 0x044e }
                throw r2     // Catch:{ Exception -> 0x044e }
            L_0x0430:
                r18 = r2
                com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ Exception -> 0x044e }
                java.lang.String r3 = "Missing common header."
                r2.<init>(r3)     // Catch:{ Exception -> 0x044e }
                throw r2     // Catch:{ Exception -> 0x044e }
            L_0x043a:
                r18 = r2
                com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ Exception -> 0x044e }
                java.lang.String r3 = "Invalid padding."
                r2.<init>(r3)     // Catch:{ Exception -> 0x044e }
                throw r2     // Catch:{ Exception -> 0x044e }
            L_0x0444:
                r18 = r2
                com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ Exception -> 0x044e }
                java.lang.String r3 = "File is empty."
                r2.<init>(r3)     // Catch:{ Exception -> 0x044e }
                throw r2     // Catch:{ Exception -> 0x044e }
            L_0x044e:
                r0 = move-exception
                goto L_0x0458
            L_0x0450:
                r0 = move-exception
                r18 = r2
            L_0x0453:
                r2 = r0
                goto L_0x0474
            L_0x0455:
                r0 = move-exception
                r18 = r2
            L_0x0458:
                r2 = r0
                com.badlogic.gdx.utils.GdxRuntimeException r3 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x0472 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0472 }
                r4.<init>()     // Catch:{ all -> 0x0472 }
                java.lang.String r5 = "Error loading font file: "
                r4.append(r5)     // Catch:{ all -> 0x0472 }
                r5 = r23
                r4.append(r5)     // Catch:{ all -> 0x0472 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0472 }
                r3.<init>(r4, r2)     // Catch:{ all -> 0x0472 }
                throw r3     // Catch:{ all -> 0x0472 }
            L_0x0472:
                r0 = move-exception
                goto L_0x0453
            L_0x0474:
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(r18)
                throw r2
            L_0x0478:
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                java.lang.String r3 = "Already loaded."
                r2.<init>(r3)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData.load(com.badlogic.gdx.files.FileHandle, boolean):void");
        }

        public void scale(float f2) {
            setScale(this.scaleX + f2, this.scaleY + f2);
        }

        public void setGlyph(int i, Glyph glyph) {
            Glyph[][] glyphArr = this.glyphs;
            int i2 = i / 512;
            Glyph[] glyphArr2 = glyphArr[i2];
            if (glyphArr2 == null) {
                glyphArr2 = new Glyph[512];
                glyphArr[i2] = glyphArr2;
            }
            glyphArr2[i & FrameMetricsAggregator.EVERY_DURATION] = glyph;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00b7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setGlyphRegion(com.badlogic.gdx.graphics.g2d.BitmapFont.Glyph r17, com.badlogic.gdx.graphics.g2d.TextureRegion r18) {
            /*
                r16 = this;
                r0 = r17
                r1 = r18
                com.badlogic.gdx.graphics.Texture r2 = r18.getTexture()
                int r3 = r2.getWidth()
                float r3 = (float) r3
                r4 = 1065353216(0x3f800000, float:1.0)
                float r3 = r4 / r3
                int r2 = r2.getHeight()
                float r2 = (float) r2
                float r4 = r4 / r2
                float r2 = r1.u
                float r5 = r1.v
                int r6 = r18.getRegionWidth()
                float r6 = (float) r6
                int r7 = r18.getRegionHeight()
                float r7 = (float) r7
                boolean r8 = r1 instanceof com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion
                r9 = 0
                if (r8 == 0) goto L_0x0038
                com.badlogic.gdx.graphics.g2d.TextureAtlas$AtlasRegion r1 = (com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) r1
                float r8 = r1.offsetX
                int r10 = r1.originalHeight
                int r11 = r1.packedHeight
                int r10 = r10 - r11
                float r10 = (float) r10
                float r1 = r1.offsetY
                float r10 = r10 - r1
                goto L_0x003a
            L_0x0038:
                r8 = 0
                r10 = 0
            L_0x003a:
                int r1 = r0.srcX
                float r11 = (float) r1
                int r12 = r0.width
                int r1 = r1 + r12
                float r1 = (float) r1
                int r13 = r0.srcY
                float r14 = (float) r13
                int r15 = r0.height
                int r13 = r13 + r15
                float r13 = (float) r13
                int r15 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
                if (r15 <= 0) goto L_0x006c
                float r11 = r11 - r8
                int r15 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r15 >= 0) goto L_0x005e
                float r12 = (float) r12
                float r12 = r12 + r11
                int r12 = (int) r12
                r0.width = r12
                int r12 = r0.xoffset
                float r12 = (float) r12
                float r12 = r12 - r11
                int r11 = (int) r12
                r0.xoffset = r11
                r11 = 0
            L_0x005e:
                float r1 = r1 - r8
                int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
                if (r8 <= 0) goto L_0x006c
                int r8 = r0.width
                float r8 = (float) r8
                float r1 = r1 - r6
                float r8 = r8 - r1
                int r1 = (int) r8
                r0.width = r1
                goto L_0x006d
            L_0x006c:
                r6 = r1
            L_0x006d:
                int r1 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
                if (r1 <= 0) goto L_0x009b
                float r14 = r14 - r10
                int r1 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
                if (r1 >= 0) goto L_0x0083
                int r1 = r0.height
                float r1 = (float) r1
                float r1 = r1 + r14
                int r1 = (int) r1
                r0.height = r1
                if (r1 >= 0) goto L_0x0084
                r1 = 0
                r0.height = r1
                goto L_0x0084
            L_0x0083:
                r9 = r14
            L_0x0084:
                float r13 = r13 - r10
                int r1 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
                if (r1 <= 0) goto L_0x009a
                float r13 = r13 - r7
                int r1 = r0.height
                float r1 = (float) r1
                float r1 = r1 - r13
                int r1 = (int) r1
                r0.height = r1
                int r1 = r0.yoffset
                float r1 = (float) r1
                float r1 = r1 + r13
                int r1 = (int) r1
                r0.yoffset = r1
                r14 = r9
                goto L_0x009c
            L_0x009a:
                r14 = r9
            L_0x009b:
                r7 = r13
            L_0x009c:
                float r11 = r11 * r3
                float r11 = r11 + r2
                r0.u = r11
                float r6 = r6 * r3
                float r6 = r6 + r2
                r0.u2 = r6
                r1 = r16
                boolean r2 = r1.flipped
                if (r2 == 0) goto L_0x00b7
                float r14 = r14 * r4
                float r14 = r14 + r5
                r0.v = r14
                float r7 = r7 * r4
                float r7 = r7 + r5
                r0.v2 = r7
                goto L_0x00c1
            L_0x00b7:
                float r14 = r14 * r4
                float r14 = r14 + r5
                r0.v2 = r14
                float r7 = r7 * r4
                float r7 = r7 + r5
                r0.v = r7
            L_0x00c1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData.setGlyphRegion(com.badlogic.gdx.graphics.g2d.BitmapFont$Glyph, com.badlogic.gdx.graphics.g2d.TextureRegion):void");
        }

        public void setLineHeight(float f2) {
            float f3 = f2 * this.scaleY;
            this.lineHeight = f3;
            if (!this.flipped) {
                f3 = -f3;
            }
            this.down = f3;
        }

        public void setScale(float f2, float f3) {
            if (f2 == 0.0f) {
                throw new IllegalArgumentException("scaleX cannot be 0.");
            } else if (f3 != 0.0f) {
                float f4 = f2 / this.scaleX;
                float f5 = f3 / this.scaleY;
                this.lineHeight *= f5;
                this.spaceXadvance *= f4;
                this.xHeight *= f5;
                this.capHeight *= f5;
                this.ascent *= f5;
                this.descent *= f5;
                this.down *= f5;
                this.padLeft *= f4;
                this.padRight *= f4;
                this.padTop *= f5;
                this.padBottom *= f5;
                this.scaleX = f2;
                this.scaleY = f3;
            } else {
                throw new IllegalArgumentException("scaleY cannot be 0.");
            }
        }

        public String toString() {
            String str = this.name;
            return str != null ? str : super.toString();
        }

        public BitmapFontData(FileHandle fileHandle, boolean z) {
            this.fontFile = fileHandle;
            this.flipped = z;
            load(fileHandle, z);
        }

        public void setScale(float f2) {
            setScale(f2, f2);
        }
    }

    public static class Glyph {
        public boolean fixedWidth;
        public int height;
        public int id;
        public byte[][] kerning;
        public int page = 0;
        public int srcX;
        public int srcY;
        public float u;
        public float u2;
        public float v;
        public float v2;
        public int width;
        public int xadvance;
        public int xoffset;
        public int yoffset;

        public int getKerning(char c2) {
            byte[][] bArr = this.kerning;
            if (bArr != null) {
                byte[] bArr2 = bArr[c2 >>> 9];
                if (bArr2 != null) {
                    return bArr2[c2 & 511];
                }
            }
            return 0;
        }

        public void setKerning(int i, int i2) {
            if (this.kerning == null) {
                this.kerning = new byte[128][];
            }
            byte[][] bArr = this.kerning;
            int i3 = i >>> 9;
            byte[] bArr2 = bArr[i3];
            if (bArr2 == null) {
                bArr2 = new byte[512];
                bArr[i3] = bArr2;
            }
            bArr2[i & FrameMetricsAggregator.EVERY_DURATION] = (byte) i2;
        }

        public String toString() {
            return Character.toString((char) this.id);
        }
    }

    public BitmapFont() {
        this(k.files.classpath("com/badlogic/gdx/utils/arial-15.fnt"), k.files.classpath("com/badlogic/gdx/utils/arial-15.png"), false, true);
    }

    public static int indexOf(CharSequence charSequence, char c2, int i) {
        int length = charSequence.length();
        while (i < length) {
            if (charSequence.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return length;
    }

    public void dispose() {
        if (this.ownsTexture) {
            int i = 0;
            while (true) {
                Array<TextureRegion> array = this.regions;
                if (i < array.size) {
                    ((TextureRegion) array.get(i)).getTexture().dispose();
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f2, float f3) {
        this.cache.clear();
        GlyphLayout addText = this.cache.addText(charSequence, f2, f3);
        this.cache.draw(batch);
        return addText;
    }

    public float getAscent() {
        return this.data.ascent;
    }

    public BitmapFontCache getCache() {
        return this.cache;
    }

    public float getCapHeight() {
        return this.data.capHeight;
    }

    public Color getColor() {
        return this.cache.getColor();
    }

    public BitmapFontData getData() {
        return this.data;
    }

    public float getDescent() {
        return this.data.descent;
    }

    public float getLineHeight() {
        return this.data.lineHeight;
    }

    public TextureRegion getRegion() {
        return (TextureRegion) this.regions.first();
    }

    public Array<TextureRegion> getRegions() {
        return this.regions;
    }

    public float getScaleX() {
        return this.data.scaleX;
    }

    public float getScaleY() {
        return this.data.scaleY;
    }

    public float getSpaceXadvance() {
        return this.data.spaceXadvance;
    }

    public float getXHeight() {
        return this.data.xHeight;
    }

    public boolean isFlipped() {
        return this.flipped;
    }

    public void load(BitmapFontData bitmapFontData) {
        for (Glyph[] glyphArr : bitmapFontData.glyphs) {
            if (glyphArr != null) {
                for (Glyph glyph : glyphArr) {
                    if (glyph != null) {
                        bitmapFontData.setGlyphRegion(glyph, (TextureRegion) this.regions.get(glyph.page));
                    }
                }
            }
        }
        Glyph glyph2 = bitmapFontData.missingGlyph;
        if (glyph2 != null) {
            bitmapFontData.setGlyphRegion(glyph2, (TextureRegion) this.regions.get(glyph2.page));
        }
    }

    public BitmapFontCache newFontCache() {
        return new BitmapFontCache(this, this.integer);
    }

    public boolean ownsTexture() {
        return this.ownsTexture;
    }

    public void setColor(Color color) {
        this.cache.getColor().set(color);
    }

    public void setFixedWidthGlyphs(CharSequence charSequence) {
        BitmapFontData bitmapFontData = this.data;
        int length = charSequence.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            Glyph glyph = bitmapFontData.getGlyph(charSequence.charAt(i2));
            if (glyph != null) {
                int i3 = glyph.xadvance;
                if (i3 > i) {
                    i = i3;
                }
            }
        }
        int length2 = charSequence.length();
        for (int i4 = 0; i4 < length2; i4++) {
            Glyph glyph2 = bitmapFontData.getGlyph(charSequence.charAt(i4));
            if (glyph2 != null) {
                glyph2.xoffset = ((i - glyph2.xadvance) / 2) + glyph2.xoffset;
                glyph2.xadvance = i;
                glyph2.kerning = null;
                glyph2.fixedWidth = true;
            }
        }
    }

    public void setOwnsTexture(boolean z) {
        this.ownsTexture = z;
    }

    public void setUseIntegerPositions(boolean z) {
        this.integer = z;
        this.cache.setUseIntegerPositions(z);
    }

    public String toString() {
        String str = this.data.name;
        return str != null ? str : super.toString();
    }

    public boolean usesIntegerPositions() {
        return this.integer;
    }

    public BitmapFont(boolean z) {
        this(k.files.classpath("com/badlogic/gdx/utils/arial-15.fnt"), k.files.classpath("com/badlogic/gdx/utils/arial-15.png"), z, true);
    }

    public TextureRegion getRegion(int i) {
        return (TextureRegion) this.regions.get(i);
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.cache.getColor().set(f2, f3, f4, f5);
    }

    public BitmapFont(FileHandle fileHandle, TextureRegion textureRegion) {
        this(fileHandle, textureRegion, false);
    }

    public BitmapFont(FileHandle fileHandle, TextureRegion textureRegion, boolean z) {
        this(new BitmapFontData(fileHandle, z), textureRegion, true);
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f2, float f3, float f4, int i, boolean z) {
        this.cache.clear();
        GlyphLayout addText = this.cache.addText(charSequence, f2, f3, f4, i, z);
        this.cache.draw(batch);
        return addText;
    }

    public BitmapFont(FileHandle fileHandle) {
        this(fileHandle, false);
    }

    public BitmapFont(FileHandle fileHandle, boolean z) {
        this(new BitmapFontData(fileHandle, z), (TextureRegion) null, true);
    }

    public BitmapFont(FileHandle fileHandle, FileHandle fileHandle2, boolean z) {
        this(fileHandle, fileHandle2, z, true);
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f2, float f3, int i, int i2, float f4, int i3, boolean z) {
        this.cache.clear();
        GlyphLayout addText = this.cache.addText(charSequence, f2, f3, i, i2, f4, i3, z);
        Batch batch2 = batch;
        this.cache.draw(batch);
        return addText;
    }

    public BitmapFont(FileHandle fileHandle, FileHandle fileHandle2, boolean z, boolean z2) {
        this(new BitmapFontData(fileHandle, z), new TextureRegion(new Texture(fileHandle2, false)), z2);
        this.ownsTexture = true;
    }

    public BitmapFont(BitmapFontData bitmapFontData, Array<TextureRegion> array, boolean z) {
        FileHandle fileHandle;
        this.flipped = bitmapFontData.flipped;
        this.data = bitmapFontData;
        this.integer = z;
        if (array == null || array.size == 0) {
            String[] strArr = bitmapFontData.imagePaths;
            if (strArr != null) {
                int length = strArr.length;
                this.regions = new Array<>(true, length);
                for (int i = 0; i < length; i++) {
                    FileHandle fileHandle2 = bitmapFontData.fontFile;
                    if (fileHandle2 == null) {
                        fileHandle = k.files.internal(bitmapFontData.imagePaths[i]);
                    } else {
                        fileHandle = k.files.getFileHandle(bitmapFontData.imagePaths[i], fileHandle2.type);
                    }
                    this.regions.add(new TextureRegion(new Texture(fileHandle, false)));
                }
                this.ownsTexture = true;
            } else {
                throw new IllegalArgumentException("If no regions are specified, the font data must have an images path.");
            }
        } else {
            this.regions = array;
            this.ownsTexture = false;
        }
        this.cache = newFontCache();
        load(bitmapFontData);
    }

    public GlyphLayout draw(Batch batch, CharSequence charSequence, float f2, float f3, int i, int i2, float f4, int i3, boolean z, String str) {
        this.cache.clear();
        GlyphLayout addText = this.cache.addText(charSequence, f2, f3, i, i2, f4, i3, z, str);
        Batch batch2 = batch;
        this.cache.draw(batch);
        return addText;
    }

    public void draw(Batch batch, GlyphLayout glyphLayout, float f2, float f3) {
        this.cache.clear();
        this.cache.addText(glyphLayout, f2, f3);
        this.cache.draw(batch);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BitmapFont(BitmapFontData bitmapFontData, TextureRegion textureRegion, boolean z) {
        Array array;
        // if (textureRegion != null) {
            // array = new Array((T[]) new TextureRegion[]{textureRegion});
        // } else {
            // array = null;
        // }
        this(bitmapFontData, array, z);
    }
}
