package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.OrderedMap;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.fontbox.cmap.CMap;
import sfs2x.client.entities.invitation.InvitationReply;

public class PixmapPacker implements Disposable {
    public static Pattern indexPattern = Pattern.compile("(.+)_(\\d+)$");
    public int alphaThreshold;

    /* renamed from: c  reason: collision with root package name */
    public Color f3308c;
    public boolean disposed;
    public boolean duplicateBorder;
    public PackStrategy packStrategy;
    public boolean packToTexture;
    public int padding;
    public Format pageFormat;
    public int pageHeight;
    public int pageWidth;
    public final Array<Page> pages;
    public boolean stripWhitespaceX;
    public boolean stripWhitespaceY;
    public Color transparentColor;

    public static class GuillotineStrategy implements PackStrategy {
        public Comparator<Pixmap> comparator;

        public static class GuillotinePage extends Page {
            public Node root;

            public GuillotinePage(PixmapPacker pixmapPacker) {
                super(pixmapPacker);
                Node node = new Node();
                this.root = node;
                Rectangle rectangle = node.rect;
                int i = pixmapPacker.padding;
                rectangle.x = (float) i;
                rectangle.y = (float) i;
                rectangle.width = (float) (pixmapPacker.pageWidth - (i * 2));
                rectangle.height = (float) (pixmapPacker.pageHeight - (i * 2));
            }
        }

        public static final class Node {
            public boolean full;
            public Node leftChild;
            public final Rectangle rect = new Rectangle();
            public Node rightChild;
        }

        private Node insert(Node node, Rectangle rectangle) {
            if (!node.full) {
                Node node2 = node.leftChild;
                if (!(node2 == null || node.rightChild == null)) {
                    Node insert = insert(node2, rectangle);
                    if (insert == null) {
                        insert = insert(node.rightChild, rectangle);
                    }
                    return insert;
                }
            }
            if (node.full) {
                return null;
            }
            Rectangle rectangle2 = node.rect;
            if (rectangle2.width == rectangle.width && rectangle2.height == rectangle.height) {
                return node;
            }
            Rectangle rectangle3 = node.rect;
            if (rectangle3.width < rectangle.width || rectangle3.height < rectangle.height) {
                return null;
            }
            node.leftChild = new Node();
            Node node3 = new Node();
            node.rightChild = node3;
            Rectangle rectangle4 = node.rect;
            float f2 = rectangle4.width;
            float f3 = rectangle.width;
            int i = ((int) f2) - ((int) f3);
            float f4 = rectangle4.height;
            float f5 = rectangle.height;
            if (i > ((int) f4) - ((int) f5)) {
                Rectangle rectangle5 = node.leftChild.rect;
                rectangle5.x = rectangle4.x;
                rectangle5.y = rectangle4.y;
                rectangle5.width = f3;
                rectangle5.height = f4;
                Rectangle rectangle6 = node3.rect;
                float f6 = rectangle4.x;
                float f7 = rectangle.width;
                rectangle6.x = f6 + f7;
                rectangle6.y = rectangle4.y;
                rectangle6.width = rectangle4.width - f7;
                rectangle6.height = rectangle4.height;
            } else {
                Rectangle rectangle7 = node.leftChild.rect;
                rectangle7.x = rectangle4.x;
                rectangle7.y = rectangle4.y;
                rectangle7.width = f2;
                rectangle7.height = f5;
                Rectangle rectangle8 = node3.rect;
                rectangle8.x = rectangle4.x;
                float f8 = rectangle4.y;
                float f9 = rectangle.height;
                rectangle8.y = f8 + f9;
                rectangle8.width = rectangle4.width;
                rectangle8.height = rectangle4.height - f9;
            }
            return insert(node.leftChild, rectangle);
        }

        public Page pack(PixmapPacker pixmapPacker, String str, Rectangle rectangle) {
            GuillotinePage guillotinePage;
            Array<Page> array = pixmapPacker.pages;
            if (array.size == 0) {
                guillotinePage = new GuillotinePage(pixmapPacker);
                pixmapPacker.pages.add(guillotinePage);
            } else {
                guillotinePage = (GuillotinePage) array.peek();
            }
            float f2 = (float) pixmapPacker.padding;
            rectangle.width += f2;
            rectangle.height += f2;
            Node insert = insert(guillotinePage.root, rectangle);
            if (insert == null) {
                guillotinePage = new GuillotinePage(pixmapPacker);
                pixmapPacker.pages.add(guillotinePage);
                insert = insert(guillotinePage.root, rectangle);
            }
            insert.full = true;
            Rectangle rectangle2 = insert.rect;
            rectangle.set(rectangle2.x, rectangle2.y, rectangle2.width - f2, rectangle2.height - f2);
            return guillotinePage;
        }

        public void sort(Array<Pixmap> array) {
            if (this.comparator == null) {
                this.comparator = new Comparator<Pixmap>() {
                    public int compare(Pixmap pixmap, Pixmap pixmap2) {
                        return Math.max(pixmap.getWidth(), pixmap.getHeight()) - Math.max(pixmap2.getWidth(), pixmap2.getHeight());
                    }
                };
            }
            array.sort(this.comparator);
        }
    }

    public interface PackStrategy {
        Page pack(PixmapPacker pixmapPacker, String str, Rectangle rectangle);

        void sort(Array<Pixmap> array);
    }

    public static class Page {
        public final Array<String> addedRects = new Array<>();
        public boolean dirty;
        public Pixmap image;
        public OrderedMap<String, PixmapPackerRectangle> rects = new OrderedMap<>();
        public Texture texture;

        public Page(PixmapPacker pixmapPacker) {
            Pixmap pixmap = new Pixmap(pixmapPacker.pageWidth, pixmapPacker.pageHeight, pixmapPacker.pageFormat);
            this.image = pixmap;
            pixmap.setBlending(Blending.None);
            this.image.setColor(pixmapPacker.getTransparentColor());
            this.image.fill();
        }

        public Pixmap getPixmap() {
            return this.image;
        }

        public OrderedMap<String, PixmapPackerRectangle> getRects() {
            return this.rects;
        }

        public Texture getTexture() {
            return this.texture;
        }

        public boolean updateTexture(TextureFilter textureFilter, TextureFilter textureFilter2, boolean z) {
            Texture texture2 = this.texture;
            if (texture2 == null) {
                Pixmap pixmap = this.image;
                PixmapTextureData pixmapTextureData = new PixmapTextureData(pixmap, pixmap.getFormat(), z, false, true);
                AnonymousClass1 r0 = new Texture(pixmapTextureData) {
                    public void dispose() {
                        super.dispose();
                        Page.this.image.dispose();
                    }
                };
                this.texture = r0;
                r0.setFilter(textureFilter, textureFilter2);
            } else if (!this.dirty) {
                return false;
            } else {
                texture2.load(texture2.getTextureData());
            }
            this.dirty = false;
            return true;
        }
    }

    public static class PixmapPackerRectangle extends Rectangle {
        public int offsetX;
        public int offsetY;
        public int originalHeight;
        public int originalWidth;
        public int[] pads;
        public int[] splits;

        public PixmapPackerRectangle(int i, int i2, int i3, int i4) {
            super((float) i, (float) i2, (float) i3, (float) i4);
            this.offsetX = 0;
            this.offsetY = 0;
            this.originalWidth = i3;
            this.originalHeight = i4;
        }

        public PixmapPackerRectangle(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            super((float) i, (float) i2, (float) i3, (float) i4);
            this.offsetX = i5;
            this.offsetY = i6;
            this.originalWidth = i7;
            this.originalHeight = i8;
        }
    }

    public static class SkylineStrategy implements PackStrategy {
        public Comparator<Pixmap> comparator;

        public static class SkylinePage extends Page {
            public Array<Row> rows = new Array<>();

            public static class Row {
                public int height;
                public int x;
                public int y;
            }

            public SkylinePage(PixmapPacker pixmapPacker) {
                super(pixmapPacker);
            }
        }

        public Page pack(PixmapPacker pixmapPacker, String str, Rectangle rectangle) {
            PixmapPacker pixmapPacker2 = pixmapPacker;
            Rectangle rectangle2 = rectangle;
            int i = pixmapPacker2.padding;
            int i2 = i * 2;
            int i3 = pixmapPacker2.pageWidth - i2;
            int i4 = pixmapPacker2.pageHeight - i2;
            int i5 = ((int) rectangle2.width) + i;
            int i6 = ((int) rectangle2.height) + i;
            int i7 = pixmapPacker2.pages.size;
            for (int i8 = 0; i8 < i7; i8++) {
                SkylinePage skylinePage = (SkylinePage) pixmapPacker2.pages.get(i8);
                Row row = null;
                int i9 = skylinePage.rows.size - 1;
                for (int i10 = 0; i10 < i9; i10++) {
                    Row row2 = (Row) skylinePage.rows.get(i10);
                    if (row2.x + i5 < i3 && row2.y + i6 < i4) {
                        int i11 = row2.height;
                        if (i6 <= i11 && (row == null || i11 < row.height)) {
                            row = row2;
                        }
                    }
                }
                if (row == null) {
                    Row row3 = (Row) skylinePage.rows.peek();
                    int i12 = row3.y;
                    if (i12 + i6 >= i4) {
                        continue;
                    } else if (row3.x + i5 < i3) {
                        row3.height = Math.max(row3.height, i6);
                        row = row3;
                    } else if (i12 + row3.height + i6 < i4) {
                        row = new Row();
                        row.y = row3.y + row3.height;
                        row.height = i6;
                        skylinePage.rows.add(row);
                    }
                }
                if (row != null) {
                    int i13 = row.x;
                    rectangle2.x = (float) i13;
                    rectangle2.y = (float) row.y;
                    row.x = i13 + i5;
                    return skylinePage;
                }
            }
            SkylinePage skylinePage2 = new SkylinePage(pixmapPacker2);
            pixmapPacker2.pages.add(skylinePage2);
            Row row4 = new Row();
            row4.x = i5 + i;
            row4.y = i;
            row4.height = i6;
            skylinePage2.rows.add(row4);
            float f2 = (float) i;
            rectangle2.x = f2;
            rectangle2.y = f2;
            return skylinePage2;
        }

        public void sort(Array<Pixmap> array) {
            if (this.comparator == null) {
                this.comparator = new Comparator<Pixmap>() {
                    public int compare(Pixmap pixmap, Pixmap pixmap2) {
                        return pixmap.getHeight() - pixmap2.getHeight();
                    }
                };
            }
            array.sort(this.comparator);
        }
    }

    public PixmapPacker(int i, int i2, Format format, int i3, boolean z) {
        this(i, i2, format, i3, z, false, false, new GuillotineStrategy());
    }

    private int[] getPads(Pixmap pixmap, int[] iArr) {
        int i;
        int i2;
        int i3;
        int[] iArr2 = iArr;
        int height = pixmap.getHeight() - 1;
        int width = pixmap.getWidth() - 1;
        int splitPoint = getSplitPoint(pixmap, 1, height, true, true);
        int splitPoint2 = getSplitPoint(pixmap, width, 1, true, false);
        if (splitPoint != 0) {
            i = getSplitPoint(pixmap, splitPoint + 1, height, false, true);
        } else {
            i = 0;
        }
        if (splitPoint2 != 0) {
            i2 = getSplitPoint(pixmap, width, splitPoint2 + 1, false, false);
        } else {
            i2 = 0;
        }
        getSplitPoint(pixmap, i + 1, height, true, true);
        getSplitPoint(pixmap, width, i2 + 1, true, false);
        if (splitPoint == 0 && i == 0 && splitPoint2 == 0 && i2 == 0) {
            return null;
        }
        int i4 = -1;
        if (splitPoint == 0 && i == 0) {
            i3 = -1;
            splitPoint = -1;
        } else if (splitPoint > 0) {
            splitPoint--;
            i3 = (pixmap.getWidth() - 2) - (i - 1);
        } else {
            i3 = pixmap.getWidth() - 2;
        }
        if (splitPoint2 == 0 && i2 == 0) {
            splitPoint2 = -1;
        } else if (splitPoint2 > 0) {
            splitPoint2--;
            i4 = (pixmap.getHeight() - 2) - (i2 - 1);
        } else {
            i4 = pixmap.getHeight() - 2;
        }
        int[] iArr3 = {splitPoint, i3, splitPoint2, i4};
        if (iArr2 == null || !Arrays.equals(iArr3, iArr2)) {
            return iArr3;
        }
        return null;
    }

    private int getSplitPoint(Pixmap pixmap, int i, int i2, boolean z, boolean z2) {
        Pixmap pixmap2;
        int[] iArr = new int[4];
        int i3 = z2 ? i : i2;
        int width = z2 ? pixmap.getWidth() : pixmap.getHeight();
        int i4 = z ? InvitationReply.EXPIRED : 0;
        int i5 = i2;
        int i6 = i;
        for (int i7 = i3; i7 != width; i7++) {
            if (z2) {
                pixmap2 = pixmap;
                i6 = i7;
            } else {
                pixmap2 = pixmap;
                i5 = i7;
            }
            this.f3308c.set(pixmap2.getPixel(i6, i5));
            Color color = this.f3308c;
            iArr[0] = (int) (color.r * 255.0f);
            iArr[1] = (int) (color.g * 255.0f);
            iArr[2] = (int) (color.f3307b * 255.0f);
            iArr[3] = (int) (color.f3306a * 255.0f);
            if (iArr[3] == i4) {
                return i7;
            }
            if (!z && !(iArr[0] == 0 && iArr[1] == 0 && iArr[2] == 0 && iArr[3] == 255)) {
                PrintStream printStream = System.out;
                printStream.println(i6 + "  " + i5 + CMap.SPACE + iArr + CMap.SPACE);
            }
        }
        return 0;
    }

    private int[] getSplits(Pixmap pixmap) {
        int i;
        int i2;
        int splitPoint = getSplitPoint(pixmap, 1, 0, true, true);
        int splitPoint2 = getSplitPoint(pixmap, splitPoint, 0, false, true);
        int splitPoint3 = getSplitPoint(pixmap, 0, 1, true, false);
        int splitPoint4 = getSplitPoint(pixmap, 0, splitPoint3, false, false);
        getSplitPoint(pixmap, splitPoint2 + 1, 0, true, true);
        getSplitPoint(pixmap, 0, splitPoint4 + 1, true, false);
        if (splitPoint == 0 && splitPoint2 == 0 && splitPoint3 == 0 && splitPoint4 == 0) {
            return null;
        }
        if (splitPoint != 0) {
            splitPoint--;
            i = (pixmap.getWidth() - 2) - (splitPoint2 - 1);
        } else {
            i = pixmap.getWidth() - 2;
        }
        if (splitPoint3 != 0) {
            splitPoint3--;
            i2 = (pixmap.getHeight() - 2) - (splitPoint4 - 1);
        } else {
            i2 = pixmap.getHeight() - 2;
        }
        return new int[]{splitPoint, i, splitPoint3, i2};
    }

    public synchronized void dispose() {
        ArrayIterator it = this.pages.iterator();
        while (it.hasNext()) {
            Page page = (Page) it.next();
            if (page.texture == null) {
                page.image.dispose();
            }
        }
        this.disposed = true;
    }

    public synchronized TextureAtlas generateTextureAtlas(TextureFilter textureFilter, TextureFilter textureFilter2, boolean z) {
        TextureAtlas textureAtlas;
        textureAtlas = new TextureAtlas();
        updateTextureAtlas(textureAtlas, textureFilter, textureFilter2, z);
        return textureAtlas;
    }

    public boolean getDuplicateBorder() {
        return this.duplicateBorder;
    }

    public boolean getPackToTexture() {
        return this.packToTexture;
    }

    public int getPadding() {
        return this.padding;
    }

    public synchronized Page getPage(String str) {
        ArrayIterator it = this.pages.iterator();
        while (it.hasNext()) {
            Page page = (Page) it.next();
            if (((Rectangle) page.rects.get(str)) != null) {
                return page;
            }
        }
        return null;
    }

    public Format getPageFormat() {
        return this.pageFormat;
    }

    public int getPageHeight() {
        return this.pageHeight;
    }

    public synchronized int getPageIndex(String str) {
        for (int i = 0; i < this.pages.size; i++) {
            if (((Rectangle) ((Page) this.pages.get(i)).rects.get(str)) != null) {
                return i;
            }
        }
        return -1;
    }

    public int getPageWidth() {
        return this.pageWidth;
    }

    public Array<Page> getPages() {
        return this.pages;
    }

    public synchronized Rectangle getRect(String str) {
        ArrayIterator it = this.pages.iterator();
        while (it.hasNext()) {
            Rectangle rectangle = (Rectangle) ((Page) it.next()).rects.get(str);
            if (rectangle != null) {
                return rectangle;
            }
        }
        return null;
    }

    public Color getTransparentColor() {
        return this.transparentColor;
    }

    public synchronized Rectangle pack(Pixmap pixmap) {
        try {
        }
        return pack(null, pixmap);
    }

    public void setDuplicateBorder(boolean z) {
        this.duplicateBorder = z;
    }

    public void setPackToTexture(boolean z) {
        this.packToTexture = z;
    }

    public void setPadding(int i) {
        this.padding = i;
    }

    public void setPageFormat(Format format) {
        this.pageFormat = format;
    }

    public void setPageHeight(int i) {
        this.pageHeight = i;
    }

    public void setPageWidth(int i) {
        this.pageWidth = i;
    }

    public void setTransparentColor(Color color) {
        this.transparentColor.set(color);
    }

    public void sort(Array<Pixmap> array) {
        this.packStrategy.sort(array);
    }

    public synchronized void updatePageTextures(TextureFilter textureFilter, TextureFilter textureFilter2, boolean z) {
        ArrayIterator it = this.pages.iterator();
        while (it.hasNext()) {
            ((Page) it.next()).updateTexture(textureFilter, textureFilter2, z);
        }
    }

    public synchronized void updateTextureAtlas(TextureAtlas textureAtlas, TextureFilter textureFilter, TextureFilter textureFilter2, boolean z) {
        updateTextureAtlas(textureAtlas, textureFilter, textureFilter2, z, true);
    }

    public synchronized void updateTextureRegions(Array<TextureRegion> array, TextureFilter textureFilter, TextureFilter textureFilter2, boolean z) {
        updatePageTextures(textureFilter, textureFilter2, z);
        while (array.size < this.pages.size) {
            array.add(new TextureRegion(((Page) this.pages.get(array.size)).texture));
        }
    }

    public PixmapPacker(int i, int i2, Format format, int i3, boolean z, PackStrategy packStrategy2) {
        this(i, i2, format, i3, z, false, false, packStrategy2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02af, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.badlogic.gdx.math.Rectangle pack(java.lang.String r28, com.badlogic.gdx.graphics.Pixmap r29) {
        /*
            r27 = this;
            r1 = r27
            r0 = r28
            r3 = r29
            monitor-enter(r27)
            boolean r2 = r1.disposed     // Catch:{ all -> 0x02d1 }
            r4 = 0
            if (r2 == 0) goto L_0x000e
            monitor-exit(r27)
            return r4
        L_0x000e:
            if (r0 == 0) goto L_0x002e
            com.badlogic.gdx.math.Rectangle r2 = r27.getRect(r28)     // Catch:{ all -> 0x02d1 }
            if (r2 != 0) goto L_0x0017
            goto L_0x002e
        L_0x0017:
            com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x02d1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d1 }
            r3.<init>()     // Catch:{ all -> 0x02d1 }
            java.lang.String r4 = "Pixmap has already been packed with name: "
            r3.append(r4)     // Catch:{ all -> 0x02d1 }
            r3.append(r0)     // Catch:{ all -> 0x02d1 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x02d1 }
            r2.<init>(r0)     // Catch:{ all -> 0x02d1 }
            throw r2     // Catch:{ all -> 0x02d1 }
        L_0x002e:
            r10 = 0
            r11 = 1
            if (r0 == 0) goto L_0x0094
            java.lang.String r2 = ".9"
            boolean r2 = r0.endsWith(r2)     // Catch:{ all -> 0x02d1 }
            if (r2 == 0) goto L_0x0094
            com.badlogic.gdx.graphics.g2d.PixmapPacker$PixmapPackerRectangle r12 = new com.badlogic.gdx.graphics.g2d.PixmapPacker$PixmapPackerRectangle     // Catch:{ all -> 0x02d1 }
            int r2 = r29.getWidth()     // Catch:{ all -> 0x02d1 }
            int r2 = r2 + -2
            int r4 = r29.getHeight()     // Catch:{ all -> 0x02d1 }
            int r4 = r4 + -2
            r12.<init>(r10, r10, r2, r4)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap r13 = new com.badlogic.gdx.graphics.Pixmap     // Catch:{ all -> 0x02d1 }
            int r2 = r29.getWidth()     // Catch:{ all -> 0x02d1 }
            int r2 = r2 + -2
            int r4 = r29.getHeight()     // Catch:{ all -> 0x02d1 }
            int r4 = r4 + -2
            com.badlogic.gdx.graphics.Pixmap$Format r5 = r29.getFormat()     // Catch:{ all -> 0x02d1 }
            r13.<init>(r2, r4, r5)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap$Blending r2 = com.badlogic.gdx.graphics.Pixmap.Blending.None     // Catch:{ all -> 0x02d1 }
            r13.setBlending(r2)     // Catch:{ all -> 0x02d1 }
            int[] r2 = r1.getSplits(r3)     // Catch:{ all -> 0x02d1 }
            r12.splits = r2     // Catch:{ all -> 0x02d1 }
            int[] r2 = r1.getPads(r3, r2)     // Catch:{ all -> 0x02d1 }
            r12.pads = r2     // Catch:{ all -> 0x02d1 }
            r4 = 0
            r5 = 0
            r6 = 1
            r7 = 1
            int r2 = r29.getWidth()     // Catch:{ all -> 0x02d1 }
            int r8 = r2 + -1
            int r2 = r29.getHeight()     // Catch:{ all -> 0x02d1 }
            int r9 = r2 + -1
            r2 = r13
            r3 = r29
            r2.drawPixmap(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x02d1 }
            java.lang.String r2 = "\\."
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ all -> 0x02d1 }
            r0 = r0[r10]     // Catch:{ all -> 0x02d1 }
            r2 = r12
            r3 = r13
            r4 = r3
            goto L_0x017b
        L_0x0094:
            boolean r2 = r1.stripWhitespaceX     // Catch:{ all -> 0x02d1 }
            if (r2 != 0) goto L_0x00ad
            boolean r2 = r1.stripWhitespaceY     // Catch:{ all -> 0x02d1 }
            if (r2 == 0) goto L_0x009d
            goto L_0x00ad
        L_0x009d:
            com.badlogic.gdx.graphics.g2d.PixmapPacker$PixmapPackerRectangle r12 = new com.badlogic.gdx.graphics.g2d.PixmapPacker$PixmapPackerRectangle     // Catch:{ all -> 0x02d1 }
            int r2 = r29.getWidth()     // Catch:{ all -> 0x02d1 }
            int r5 = r29.getHeight()     // Catch:{ all -> 0x02d1 }
            r12.<init>(r10, r10, r2, r5)     // Catch:{ all -> 0x02d1 }
            r2 = r12
            goto L_0x017b
        L_0x00ad:
            int r20 = r29.getWidth()     // Catch:{ all -> 0x02d1 }
            int r21 = r29.getHeight()     // Catch:{ all -> 0x02d1 }
            int r2 = r29.getHeight()     // Catch:{ all -> 0x02d1 }
            boolean r4 = r1.stripWhitespaceY     // Catch:{ all -> 0x02d1 }
            if (r4 == 0) goto L_0x0102
            r4 = 0
            r5 = 0
        L_0x00bf:
            int r6 = r29.getHeight()     // Catch:{ all -> 0x02d1 }
            if (r4 >= r6) goto L_0x00df
            r6 = 0
        L_0x00c6:
            int r7 = r29.getWidth()     // Catch:{ all -> 0x02d1 }
            if (r6 >= r7) goto L_0x00da
            int r7 = r3.getPixel(r6, r4)     // Catch:{ all -> 0x02d1 }
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r8 = r1.alphaThreshold     // Catch:{ all -> 0x02d1 }
            if (r7 <= r8) goto L_0x00d7
            goto L_0x00df
        L_0x00d7:
            int r6 = r6 + 1
            goto L_0x00c6
        L_0x00da:
            int r5 = r5 + 1
            int r4 = r4 + 1
            goto L_0x00bf
        L_0x00df:
            int r4 = r29.getHeight()     // Catch:{ all -> 0x02d1 }
        L_0x00e3:
            int r4 = r4 + -1
            if (r4 < r5) goto L_0x00ff
            r6 = 0
        L_0x00e8:
            int r7 = r29.getWidth()     // Catch:{ all -> 0x02d1 }
            if (r6 >= r7) goto L_0x00fc
            int r7 = r3.getPixel(r6, r4)     // Catch:{ all -> 0x02d1 }
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r8 = r1.alphaThreshold     // Catch:{ all -> 0x02d1 }
            if (r7 <= r8) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            int r6 = r6 + 1
            goto L_0x00e8
        L_0x00fc:
            int r2 = r2 + -1
            goto L_0x00e3
        L_0x00ff:
            r19 = r5
            goto L_0x0104
        L_0x0102:
            r19 = 0
        L_0x0104:
            int r4 = r29.getWidth()     // Catch:{ all -> 0x02d1 }
            boolean r5 = r1.stripWhitespaceX     // Catch:{ all -> 0x02d1 }
            if (r5 == 0) goto L_0x014a
            r5 = 0
        L_0x010d:
            int r6 = r29.getWidth()     // Catch:{ all -> 0x02d1 }
            if (r10 >= r6) goto L_0x012a
            r6 = r19
        L_0x0115:
            if (r6 >= r2) goto L_0x0125
            int r7 = r3.getPixel(r10, r6)     // Catch:{ all -> 0x02d1 }
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r8 = r1.alphaThreshold     // Catch:{ all -> 0x02d1 }
            if (r7 <= r8) goto L_0x0122
            goto L_0x012a
        L_0x0122:
            int r6 = r6 + 1
            goto L_0x0115
        L_0x0125:
            int r5 = r5 + 1
            int r10 = r10 + 1
            goto L_0x010d
        L_0x012a:
            int r6 = r29.getWidth()     // Catch:{ all -> 0x02d1 }
        L_0x012e:
            int r6 = r6 + -1
            if (r6 < r5) goto L_0x0147
            r7 = r19
        L_0x0134:
            if (r7 >= r2) goto L_0x0144
            int r8 = r3.getPixel(r6, r7)     // Catch:{ all -> 0x02d1 }
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r9 = r1.alphaThreshold     // Catch:{ all -> 0x02d1 }
            if (r8 <= r9) goto L_0x0141
            goto L_0x0147
        L_0x0141:
            int r7 = r7 + 1
            goto L_0x0134
        L_0x0144:
            int r4 = r4 + -1
            goto L_0x012e
        L_0x0147:
            r18 = r5
            goto L_0x014c
        L_0x014a:
            r18 = 0
        L_0x014c:
            int r10 = r4 - r18
            int r12 = r2 - r19
            com.badlogic.gdx.graphics.Pixmap r15 = new com.badlogic.gdx.graphics.Pixmap     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap$Format r2 = r29.getFormat()     // Catch:{ all -> 0x02d1 }
            r15.<init>(r10, r12, r2)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap$Blending r2 = com.badlogic.gdx.graphics.Pixmap.Blending.None     // Catch:{ all -> 0x02d1 }
            r15.setBlending(r2)     // Catch:{ all -> 0x02d1 }
            r4 = 0
            r5 = 0
            r2 = r15
            r3 = r29
            r6 = r18
            r7 = r19
            r8 = r10
            r9 = r12
            r2.drawPixmap(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.g2d.PixmapPacker$PixmapPackerRectangle r2 = new com.badlogic.gdx.graphics.g2d.PixmapPacker$PixmapPackerRectangle     // Catch:{ all -> 0x02d1 }
            r14 = 0
            r3 = 0
            r13 = r2
            r4 = r15
            r15 = r3
            r16 = r10
            r17 = r12
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02d1 }
            r3 = r4
        L_0x017b:
            float r5 = r2.getWidth()     // Catch:{ all -> 0x02d1 }
            int r6 = r1.pageWidth     // Catch:{ all -> 0x02d1 }
            float r6 = (float) r6     // Catch:{ all -> 0x02d1 }
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x02b0
            float r5 = r2.getHeight()     // Catch:{ all -> 0x02d1 }
            int r6 = r1.pageHeight     // Catch:{ all -> 0x02d1 }
            float r6 = (float) r6     // Catch:{ all -> 0x02d1 }
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0193
            goto L_0x02b0
        L_0x0193:
            com.badlogic.gdx.graphics.g2d.PixmapPacker$PackStrategy r5 = r1.packStrategy     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.g2d.PixmapPacker$Page r5 = r5.pack(r1, r0, r2)     // Catch:{ all -> 0x02d1 }
            if (r0 == 0) goto L_0x01a5
            com.badlogic.gdx.utils.OrderedMap<java.lang.String, com.badlogic.gdx.graphics.g2d.PixmapPacker$PixmapPackerRectangle> r6 = r5.rects     // Catch:{ all -> 0x02d1 }
            r6.put(r0, r2)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.utils.Array<java.lang.String> r6 = r5.addedRects     // Catch:{ all -> 0x02d1 }
            r6.add(r0)     // Catch:{ all -> 0x02d1 }
        L_0x01a5:
            float r0 = r2.x     // Catch:{ all -> 0x02d1 }
            int r0 = (int) r0     // Catch:{ all -> 0x02d1 }
            float r6 = r2.y     // Catch:{ all -> 0x02d1 }
            int r6 = (int) r6     // Catch:{ all -> 0x02d1 }
            float r7 = r2.width     // Catch:{ all -> 0x02d1 }
            int r7 = (int) r7     // Catch:{ all -> 0x02d1 }
            float r8 = r2.height     // Catch:{ all -> 0x02d1 }
            int r8 = (int) r8     // Catch:{ all -> 0x02d1 }
            boolean r9 = r1.packToTexture     // Catch:{ all -> 0x02d1 }
            if (r9 == 0) goto L_0x01e4
            boolean r9 = r1.duplicateBorder     // Catch:{ all -> 0x02d1 }
            if (r9 != 0) goto L_0x01e4
            com.badlogic.gdx.graphics.Texture r9 = r5.texture     // Catch:{ all -> 0x02d1 }
            if (r9 == 0) goto L_0x01e4
            boolean r9 = r5.dirty     // Catch:{ all -> 0x02d1 }
            if (r9 != 0) goto L_0x01e4
            com.badlogic.gdx.graphics.Texture r9 = r5.texture     // Catch:{ all -> 0x02d1 }
            r9.bind()     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.GL20 r12 = co.hyperverge.hypersnapsdk.c.k.gl     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Texture r9 = r5.texture     // Catch:{ all -> 0x02d1 }
            int r13 = r9.glTarget     // Catch:{ all -> 0x02d1 }
            r14 = 0
            int r19 = r3.getGLFormat()     // Catch:{ all -> 0x02d1 }
            int r20 = r3.getGLType()     // Catch:{ all -> 0x02d1 }
            java.nio.ByteBuffer r21 = r3.getPixels()     // Catch:{ all -> 0x02d1 }
            r15 = r0
            r16 = r6
            r17 = r7
            r18 = r8
            r12.glTexSubImage2D(r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02d1 }
            goto L_0x01e6
        L_0x01e4:
            r5.dirty = r11     // Catch:{ all -> 0x02d1 }
        L_0x01e6:
            com.badlogic.gdx.graphics.Pixmap r9 = r5.image     // Catch:{ all -> 0x02d1 }
            r9.drawPixmap(r3, r0, r6)     // Catch:{ all -> 0x02d1 }
            boolean r9 = r1.duplicateBorder     // Catch:{ all -> 0x02d1 }
            if (r9 == 0) goto L_0x02a9
            int r9 = r3.getWidth()     // Catch:{ all -> 0x02d1 }
            int r10 = r3.getHeight()     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap r12 = r5.image     // Catch:{ all -> 0x02d1 }
            r14 = 0
            r15 = 0
            r16 = 1
            r17 = 1
            int r11 = r0 + -1
            int r22 = r6 + -1
            r20 = 1
            r21 = 1
            r13 = r3
            r18 = r11
            r19 = r22
            r12.drawPixmap(r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap r12 = r5.image     // Catch:{ all -> 0x02d1 }
            int r23 = r9 + -1
            r15 = 0
            r16 = 1
            r17 = 1
            int r24 = r0 + r7
            r20 = 1
            r21 = 1
            r13 = r3
            r14 = r23
            r18 = r24
            r19 = r22
            r12.drawPixmap(r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap r12 = r5.image     // Catch:{ all -> 0x02d1 }
            r14 = 0
            int r25 = r10 + -1
            r16 = 1
            r17 = 1
            int r26 = r6 + r8
            r20 = 1
            r21 = 1
            r13 = r3
            r15 = r25
            r18 = r11
            r19 = r26
            r12.drawPixmap(r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap r12 = r5.image     // Catch:{ all -> 0x02d1 }
            r16 = 1
            r17 = 1
            r20 = 1
            r21 = 1
            r13 = r3
            r14 = r23
            r15 = r25
            r18 = r24
            r19 = r26
            r12.drawPixmap(r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap r12 = r5.image     // Catch:{ all -> 0x02d1 }
            r14 = 0
            r15 = 0
            r17 = 1
            r21 = 1
            r13 = r3
            r16 = r9
            r18 = r0
            r19 = r22
            r20 = r7
            r12.drawPixmap(r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap r12 = r5.image     // Catch:{ all -> 0x02d1 }
            r14 = 0
            r17 = 1
            r21 = 1
            r13 = r3
            r15 = r25
            r16 = r9
            r18 = r0
            r19 = r26
            r20 = r7
            r12.drawPixmap(r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap r12 = r5.image     // Catch:{ all -> 0x02d1 }
            r14 = 0
            r15 = 0
            r16 = 1
            r20 = 1
            r13 = r3
            r17 = r10
            r18 = r11
            r19 = r6
            r21 = r8
            r12.drawPixmap(r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02d1 }
            com.badlogic.gdx.graphics.Pixmap r12 = r5.image     // Catch:{ all -> 0x02d1 }
            r15 = 0
            r16 = 1
            r20 = 1
            r13 = r3
            r14 = r23
            r17 = r10
            r18 = r24
            r19 = r6
            r21 = r8
            r12.drawPixmap(r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02d1 }
        L_0x02a9:
            if (r4 == 0) goto L_0x02ae
            r4.dispose()     // Catch:{ all -> 0x02d1 }
        L_0x02ae:
            monitor-exit(r27)
            return r2
        L_0x02b0:
            if (r0 != 0) goto L_0x02ba
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x02d1 }
            java.lang.String r2 = "Page size too small for pixmap."
            r0.<init>(r2)     // Catch:{ all -> 0x02d1 }
            throw r0     // Catch:{ all -> 0x02d1 }
        L_0x02ba:
            com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x02d1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d1 }
            r3.<init>()     // Catch:{ all -> 0x02d1 }
            java.lang.String r4 = "Page size too small for pixmap: "
            r3.append(r4)     // Catch:{ all -> 0x02d1 }
            r3.append(r0)     // Catch:{ all -> 0x02d1 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x02d1 }
            r2.<init>(r0)     // Catch:{ all -> 0x02d1 }
            throw r2     // Catch:{ all -> 0x02d1 }
        L_0x02d1:
            r0 = move-exception
            monitor-exit(r27)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.g2d.PixmapPacker.pack(java.lang.String, com.badlogic.gdx.graphics.Pixmap):com.badlogic.gdx.math.Rectangle");
    }

    public PixmapPacker(int i, int i2, Format format, int i3, boolean z, boolean z2, boolean z3, PackStrategy packStrategy2) {
        this.transparentColor = new Color(0.0f, 0.0f, 0.0f, 0.0f);
        this.pages = new Array<>();
        this.f3308c = new Color();
        this.pageWidth = i;
        this.pageHeight = i2;
        this.pageFormat = format;
        this.padding = i3;
        this.duplicateBorder = z;
        this.stripWhitespaceX = z2;
        this.stripWhitespaceY = z3;
        this.packStrategy = packStrategy2;
    }

    public synchronized void updateTextureAtlas(TextureAtlas textureAtlas, TextureFilter textureFilter, TextureFilter textureFilter2, boolean z, boolean z2) {
        updatePageTextures(textureFilter, textureFilter2, z);
        ArrayIterator it = this.pages.iterator();
        while (it.hasNext()) {
            Page page = (Page) it.next();
            if (page.addedRects.size > 0) {
                ArrayIterator it2 = page.addedRects.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    PixmapPackerRectangle pixmapPackerRectangle = (PixmapPackerRectangle) page.rects.get(str);
                    AtlasRegion atlasRegion = new AtlasRegion(page.texture, (int) pixmapPackerRectangle.x, (int) pixmapPackerRectangle.y, (int) pixmapPackerRectangle.width, (int) pixmapPackerRectangle.height);
                    if (pixmapPackerRectangle.splits != null) {
                        atlasRegion.names = new String[]{"split", "pad"};
                        atlasRegion.values = new int[][]{pixmapPackerRectangle.splits, pixmapPackerRectangle.pads};
                    }
                    int i = -1;
                    if (z2) {
                        Matcher matcher = indexPattern.matcher(str);
                        if (matcher.matches()) {
                            str = matcher.group(1);
                            i = Integer.parseInt(matcher.group(2));
                        }
                    }
                    atlasRegion.name = str;
                    atlasRegion.index = i;
                    atlasRegion.offsetX = (float) pixmapPackerRectangle.offsetX;
                    atlasRegion.offsetY = (float) ((int) ((((float) pixmapPackerRectangle.originalHeight) - pixmapPackerRectangle.height) - ((float) pixmapPackerRectangle.offsetY)));
                    atlasRegion.originalWidth = pixmapPackerRectangle.originalWidth;
                    atlasRegion.originalHeight = pixmapPackerRectangle.originalHeight;
                    textureAtlas.getRegions().add(atlasRegion);
                }
                page.addedRects.clear();
                textureAtlas.getTextures().add(page.texture);
            }
        }
    }
}
