package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import java.io.IOException;

public class PixmapPackerIO {

    /* renamed from: com.badlogic.gdx.graphics.g2d.PixmapPackerIO$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$badlogic$gdx$graphics$g2d$PixmapPackerIO$ImageFormat;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        static {
            /*
                com.badlogic.gdx.graphics.g2d.PixmapPackerIO$ImageFormat[] r0 = com.badlogic.gdx.graphics.g2d.PixmapPackerIO.ImageFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$badlogic$gdx$graphics$g2d$PixmapPackerIO$ImageFormat = r0
                r1 = 1
                com.badlogic.gdx.graphics.g2d.PixmapPackerIO$ImageFormat r2 = com.badlogic.gdx.graphics.g2d.PixmapPackerIO.ImageFormat.CIM     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                int[] r0 = $SwitchMap$com$badlogic$gdx$graphics$g2d$PixmapPackerIO$ImageFormat     // Catch:{ NoSuchFieldError -> 0x0016 }
                com.badlogic.gdx.graphics.g2d.PixmapPackerIO$ImageFormat r2 = com.badlogic.gdx.graphics.g2d.PixmapPackerIO.ImageFormat.PNG     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.PixmapPackerIO.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ImageFormat {
        CIM(".cim"),
        PNG(".png");
        
        public final String extension;

        /* access modifiers changed from: public */
        ImageFormat(String str) {
            this.extension = str;
        }

        public String getExtension() {
            return this.extension;
        }
    }

    public static class SaveParameters {
        public ImageFormat format = ImageFormat.PNG;
        public TextureFilter magFilter;
        public TextureFilter minFilter;
        public boolean useIndexes;

        public SaveParameters() {
            TextureFilter textureFilter = TextureFilter.Nearest;
            this.minFilter = textureFilter;
            this.magFilter = textureFilter;
        }
    }

    public void save(FileHandle fileHandle, PixmapPacker pixmapPacker) throws IOException {
        save(fileHandle, pixmapPacker, new SaveParameters());
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x020b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void save(com.badlogic.gdx.files.FileHandle r19, com.badlogic.gdx.graphics.g2d.PixmapPacker r20, com.badlogic.gdx.graphics.g2d.PixmapPackerIO.SaveParameters r21) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = 0
            r4 = 0
            java.io.Writer r5 = r0.writer(r3, r4)
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.PixmapPacker$Page> r6 = r1.pages
            com.badlogic.gdx.utils.Array$ArrayIterator r6 = r6.iterator()
            r7 = 0
        L_0x0013:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x026e
            java.lang.Object r8 = r6.next()
            com.badlogic.gdx.graphics.g2d.PixmapPacker$Page r8 = (com.badlogic.gdx.graphics.g2d.PixmapPacker.Page) r8
            com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.graphics.g2d.PixmapPacker$PixmapPackerRectangle> r9 = r8.rects
            int r9 = r9.size
            if (r9 <= 0) goto L_0x0013
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r19.nameWithoutExtension()
            r9.append(r10)
            java.lang.String r10 = "_"
            r9.append(r10)
            int r7 = r7 + 1
            r9.append(r7)
            com.badlogic.gdx.graphics.g2d.PixmapPackerIO$ImageFormat r10 = r2.format
            java.lang.String r10 = r10.getExtension()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            com.badlogic.gdx.files.FileHandle r9 = r0.sibling(r9)
            com.badlogic.gdx.graphics.g2d.PixmapPackerIO$ImageFormat r10 = r2.format
            int r10 = r10.ordinal()
            r11 = 1
            if (r10 == 0) goto L_0x005e
            if (r10 == r11) goto L_0x0058
            goto L_0x0063
        L_0x0058:
            com.badlogic.gdx.graphics.Pixmap r10 = r8.image
            com.badlogic.gdx.graphics.PixmapIO.writePNG(r9, r10)
            goto L_0x0063
        L_0x005e:
            com.badlogic.gdx.graphics.Pixmap r10 = r8.image
            com.badlogic.gdx.graphics.PixmapIO.writeCIM(r9, r10)
        L_0x0063:
            java.lang.String r10 = "\n"
            r5.write(r10)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r9 = r9.name()
            r12.append(r9)
            r12.append(r10)
            java.lang.String r9 = r12.toString()
            r5.write(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r12 = "size: "
            r9.append(r12)
            com.badlogic.gdx.graphics.Pixmap r12 = r8.image
            int r12 = r12.getWidth()
            r9.append(r12)
            java.lang.String r12 = ","
            r9.append(r12)
            com.badlogic.gdx.graphics.Pixmap r13 = r8.image
            int r13 = r13.getHeight()
            r9.append(r13)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r5.write(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r13 = "format: "
            r9.append(r13)
            com.badlogic.gdx.graphics.Pixmap$Format r13 = r1.pageFormat
            java.lang.String r13 = r13.name()
            r9.append(r13)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r5.write(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r13 = "filter: "
            r9.append(r13)
            com.badlogic.gdx.graphics.Texture$TextureFilter r13 = r2.minFilter
            java.lang.String r13 = r13.name()
            r9.append(r13)
            r9.append(r12)
            com.badlogic.gdx.graphics.Texture$TextureFilter r13 = r2.magFilter
            java.lang.String r13 = r13.name()
            r9.append(r13)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r5.write(r9)
            java.lang.String r9 = "repeat: none\n"
            r5.write(r9)
            com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.graphics.g2d.PixmapPacker$PixmapPackerRectangle> r9 = r8.rects
            com.badlogic.gdx.utils.ObjectMap$Keys r9 = r9.keys()
            if (r9 == 0) goto L_0x026d
        L_0x00fc:
            boolean r13 = r9.hasNext()
            if (r13 == 0) goto L_0x0013
            java.lang.Object r4 = r9.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r13 = r2.useIndexes
            r14 = 2
            if (r13 == 0) goto L_0x0126
            java.util.regex.Pattern r13 = com.badlogic.gdx.graphics.g2d.PixmapPacker.indexPattern
            java.util.regex.Matcher r13 = r13.matcher(r4)
            boolean r15 = r13.matches()
            if (r15 == 0) goto L_0x0126
            java.lang.String r11 = r13.group(r11)
            java.lang.String r13 = r13.group(r14)
            int r13 = java.lang.Integer.parseInt(r13)
            goto L_0x0128
        L_0x0126:
            r13 = -1
            r11 = r4
        L_0x0128:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r11)
            r14.append(r10)
            java.lang.String r11 = r14.toString()
            r5.write(r11)
            com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.graphics.g2d.PixmapPacker$PixmapPackerRectangle> r11 = r8.rects
            java.lang.Object r4 = r11.get(r4)
            com.badlogic.gdx.graphics.g2d.PixmapPacker$PixmapPackerRectangle r4 = (com.badlogic.gdx.graphics.g2d.PixmapPacker.PixmapPackerRectangle) r4
            java.lang.String r11 = "  rotate: false\n"
            r5.write(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r14 = "  xy: "
            r11.append(r14)
            float r14 = r4.x
            int r14 = (int) r14
            r11.append(r14)
            r11.append(r12)
            float r14 = r4.y
            int r14 = (int) r14
            r11.append(r14)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r5.write(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r14 = "  size: "
            r11.append(r14)
            float r14 = r4.width
            int r14 = (int) r14
            r11.append(r14)
            r11.append(r12)
            float r14 = r4.height
            int r14 = (int) r14
            r11.append(r14)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r5.write(r11)
            int[] r11 = r4.splits
            java.lang.String r14 = ", "
            if (r11 == 0) goto L_0x020b
            java.lang.String r11 = "  split: "
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            int[] r15 = r4.splits
            r15 = r15[r3]
            r11.append(r15)
            r11.append(r14)
            int[] r15 = r4.splits
            r16 = 1
            r15 = r15[r16]
            r11.append(r15)
            r11.append(r14)
            int[] r15 = r4.splits
            r16 = 2
            r15 = r15[r16]
            r11.append(r15)
            r11.append(r14)
            int[] r15 = r4.splits
            r16 = 3
            r15 = r15[r16]
            r11.append(r15)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r5.write(r11)
            int[] r11 = r4.pads
            if (r11 == 0) goto L_0x020b
            java.lang.String r11 = "  pad: "
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            int[] r15 = r4.pads
            r15 = r15[r3]
            r11.append(r15)
            r11.append(r14)
            int[] r15 = r4.pads
            r17 = 1
            r15 = r15[r17]
            r11.append(r15)
            r11.append(r14)
            int[] r15 = r4.pads
            r17 = 2
            r15 = r15[r17]
            r11.append(r15)
            r11.append(r14)
            int[] r15 = r4.pads
            r15 = r15[r16]
            r11.append(r15)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r5.write(r11)
        L_0x020b:
            java.lang.String r11 = "  orig: "
            java.lang.StringBuilder r11 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r11)
            int r15 = r4.originalWidth
            r11.append(r15)
            r11.append(r14)
            int r15 = r4.originalHeight
            r11.append(r15)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            r5.write(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r15 = "  offset: "
            r11.append(r15)
            int r15 = r4.offsetX
            r11.append(r15)
            r11.append(r14)
            int r14 = r4.originalHeight
            float r14 = (float) r14
            float r15 = r4.height
            float r14 = r14 - r15
            int r4 = r4.offsetY
            float r4 = (float) r4
            float r14 = r14 - r4
            int r4 = (int) r14
            r11.append(r4)
            r11.append(r10)
            java.lang.String r4 = r11.toString()
            r5.write(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r11 = "  index: "
            r4.append(r11)
            r4.append(r13)
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            r5.write(r4)
            r4 = 0
            r11 = 1
            goto L_0x00fc
        L_0x026d:
            throw r4
        L_0x026e:
            r5.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.PixmapPackerIO.save(com.badlogic.gdx.files.FileHandle, com.badlogic.gdx.graphics.g2d.PixmapPacker, com.badlogic.gdx.graphics.g2d.PixmapPackerIO$SaveParameters):void");
    }
}
