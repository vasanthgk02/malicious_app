package com.badlogic.gdx.graphics.g2d;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectSet;
import com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator;
import com.brentvatne.react.ReactVideoViewManager;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.pdfbox.pdfparser.BaseParser;

public class TextureAtlas implements Disposable {
    public final Array<AtlasRegion> regions;
    public final ObjectSet<Texture> textures;

    public static class AtlasRegion extends TextureRegion {
        public int degrees;
        public int index = -1;
        public String name;
        public String[] names;
        public float offsetX;
        public float offsetY;
        public int originalHeight;
        public int originalWidth;
        public int packedHeight;
        public int packedWidth;
        public boolean rotate;
        public int[][] values;

        public AtlasRegion(Texture texture, int i, int i2, int i3, int i4) {
            super(texture, i, i2, i3, i4);
            this.originalWidth = i3;
            this.originalHeight = i4;
            this.packedWidth = i3;
            this.packedHeight = i4;
        }

        public int[] findValue(String str) {
            String[] strArr = this.names;
            if (strArr != null) {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    if (str.equals(this.names[i])) {
                        return this.values[i];
                    }
                }
            }
            return null;
        }

        public void flip(boolean z, boolean z2) {
            super.flip(z, z2);
            if (z) {
                this.offsetX = (((float) this.originalWidth) - this.offsetX) - getRotatedPackedWidth();
            }
            if (z2) {
                this.offsetY = (((float) this.originalHeight) - this.offsetY) - getRotatedPackedHeight();
            }
        }

        public float getRotatedPackedHeight() {
            return (float) (this.rotate ? this.packedWidth : this.packedHeight);
        }

        public float getRotatedPackedWidth() {
            return (float) (this.rotate ? this.packedHeight : this.packedWidth);
        }

        public String toString() {
            return this.name;
        }

        public AtlasRegion(AtlasRegion atlasRegion) {
            setRegion((TextureRegion) atlasRegion);
            this.index = atlasRegion.index;
            this.name = atlasRegion.name;
            this.offsetX = atlasRegion.offsetX;
            this.offsetY = atlasRegion.offsetY;
            this.packedWidth = atlasRegion.packedWidth;
            this.packedHeight = atlasRegion.packedHeight;
            this.originalWidth = atlasRegion.originalWidth;
            this.originalHeight = atlasRegion.originalHeight;
            this.rotate = atlasRegion.rotate;
            this.degrees = atlasRegion.degrees;
            this.names = atlasRegion.names;
            this.values = atlasRegion.values;
        }

        public AtlasRegion(TextureRegion textureRegion) {
            setRegion(textureRegion);
            this.packedWidth = textureRegion.getRegionWidth();
            int regionHeight = textureRegion.getRegionHeight();
            this.packedHeight = regionHeight;
            this.originalWidth = this.packedWidth;
            this.originalHeight = regionHeight;
        }
    }

    public static class AtlasSprite extends Sprite {
        public float originalOffsetX;
        public float originalOffsetY;
        public final AtlasRegion region;

        public AtlasSprite(AtlasRegion atlasRegion) {
            this.region = new AtlasRegion(atlasRegion);
            this.originalOffsetX = atlasRegion.offsetX;
            this.originalOffsetY = atlasRegion.offsetY;
            setRegion((TextureRegion) atlasRegion);
            setOrigin(((float) atlasRegion.originalWidth) / 2.0f, ((float) atlasRegion.originalHeight) / 2.0f);
            int regionWidth = atlasRegion.getRegionWidth();
            int regionHeight = atlasRegion.getRegionHeight();
            if (atlasRegion.rotate) {
                super.rotate90(true);
                super.setBounds(atlasRegion.offsetX, atlasRegion.offsetY, (float) regionHeight, (float) regionWidth);
            } else {
                super.setBounds(atlasRegion.offsetX, atlasRegion.offsetY, (float) regionWidth, (float) regionHeight);
            }
            setColor(1.0f, 1.0f, 1.0f, 1.0f);
        }

        public void flip(boolean z, boolean z2) {
            if (this.region.rotate) {
                super.flip(z2, z);
            } else {
                super.flip(z, z2);
            }
            float originX = getOriginX();
            float originY = getOriginY();
            AtlasRegion atlasRegion = this.region;
            float f2 = atlasRegion.offsetX;
            float f3 = atlasRegion.offsetY;
            float widthRatio = getWidthRatio();
            float heightRatio = getHeightRatio();
            AtlasRegion atlasRegion2 = this.region;
            atlasRegion2.offsetX = this.originalOffsetX;
            atlasRegion2.offsetY = this.originalOffsetY;
            atlasRegion2.flip(z, z2);
            AtlasRegion atlasRegion3 = this.region;
            float f4 = atlasRegion3.offsetX;
            this.originalOffsetX = f4;
            float f5 = atlasRegion3.offsetY;
            this.originalOffsetY = f5;
            float f6 = f4 * widthRatio;
            atlasRegion3.offsetX = f6;
            float f7 = f5 * heightRatio;
            atlasRegion3.offsetY = f7;
            translate(f6 - f2, f7 - f3);
            setOrigin(originX, originY);
        }

        public AtlasRegion getAtlasRegion() {
            return this.region;
        }

        public float getHeight() {
            return (super.getHeight() / this.region.getRotatedPackedHeight()) * ((float) this.region.originalHeight);
        }

        public float getHeightRatio() {
            return super.getHeight() / this.region.getRotatedPackedHeight();
        }

        public float getOriginX() {
            return super.getOriginX() + this.region.offsetX;
        }

        public float getOriginY() {
            return super.getOriginY() + this.region.offsetY;
        }

        public float getWidth() {
            return (super.getWidth() / this.region.getRotatedPackedWidth()) * ((float) this.region.originalWidth);
        }

        public float getWidthRatio() {
            return super.getWidth() / this.region.getRotatedPackedWidth();
        }

        public float getX() {
            return super.getX() - this.region.offsetX;
        }

        public float getY() {
            return super.getY() - this.region.offsetY;
        }

        public void rotate90(boolean z) {
            super.rotate90(z);
            float originX = getOriginX();
            float originY = getOriginY();
            AtlasRegion atlasRegion = this.region;
            float f2 = atlasRegion.offsetX;
            float f3 = atlasRegion.offsetY;
            float widthRatio = getWidthRatio();
            float heightRatio = getHeightRatio();
            if (z) {
                AtlasRegion atlasRegion2 = this.region;
                atlasRegion2.offsetX = f3;
                atlasRegion2.offsetY = ((((float) atlasRegion2.originalHeight) * heightRatio) - f2) - (((float) atlasRegion2.packedWidth) * widthRatio);
            } else {
                AtlasRegion atlasRegion3 = this.region;
                atlasRegion3.offsetX = ((((float) atlasRegion3.originalWidth) * widthRatio) - f3) - (((float) atlasRegion3.packedHeight) * heightRatio);
                atlasRegion3.offsetY = f2;
            }
            AtlasRegion atlasRegion4 = this.region;
            translate(atlasRegion4.offsetX - f2, atlasRegion4.offsetY - f3);
            setOrigin(originX, originY);
        }

        public void setBounds(float f2, float f3, float f4, float f5) {
            AtlasRegion atlasRegion = this.region;
            float f6 = f4 / ((float) atlasRegion.originalWidth);
            float f7 = f5 / ((float) atlasRegion.originalHeight);
            atlasRegion.offsetX = this.originalOffsetX * f6;
            atlasRegion.offsetY = this.originalOffsetY * f7;
            int i = atlasRegion.rotate ? atlasRegion.packedHeight : atlasRegion.packedWidth;
            AtlasRegion atlasRegion2 = this.region;
            int i2 = atlasRegion2.rotate ? atlasRegion2.packedWidth : atlasRegion2.packedHeight;
            AtlasRegion atlasRegion3 = this.region;
            super.setBounds(f2 + atlasRegion3.offsetX, f3 + atlasRegion3.offsetY, ((float) i) * f6, ((float) i2) * f7);
        }

        public void setOrigin(float f2, float f3) {
            AtlasRegion atlasRegion = this.region;
            super.setOrigin(f2 - atlasRegion.offsetX, f3 - atlasRegion.offsetY);
        }

        public void setOriginCenter() {
            AtlasRegion atlasRegion = this.region;
            super.setOrigin((this.width / 2.0f) - atlasRegion.offsetX, (this.height / 2.0f) - atlasRegion.offsetY);
        }

        public void setPosition(float f2, float f3) {
            AtlasRegion atlasRegion = this.region;
            super.setPosition(f2 + atlasRegion.offsetX, f3 + atlasRegion.offsetY);
        }

        public void setSize(float f2, float f3) {
            setBounds(getX(), getY(), f2, f3);
        }

        public void setX(float f2) {
            super.setX(f2 + this.region.offsetX);
        }

        public void setY(float f2) {
            super.setY(f2 + this.region.offsetY);
        }

        public String toString() {
            return this.region.toString();
        }

        public AtlasSprite(AtlasSprite atlasSprite) {
            this.region = atlasSprite.region;
            this.originalOffsetX = atlasSprite.originalOffsetX;
            this.originalOffsetY = atlasSprite.originalOffsetY;
            set(atlasSprite);
        }
    }

    public static class TextureAtlasData {
        public final Array<Page> pages = new Array<>();
        public final Array<Region> regions = new Array<>();

        public interface Field<T> {
            void parse(T t);
        }

        public static class Page {
            public Format format = Format.RGBA8888;
            public float height;
            public TextureFilter magFilter;
            public TextureFilter minFilter;
            public boolean pma;
            public Texture texture;
            public FileHandle textureFile;
            public TextureWrap uWrap;
            public boolean useMipMaps;
            public TextureWrap vWrap;
            public float width;

            public Page() {
                TextureFilter textureFilter = TextureFilter.Nearest;
                this.minFilter = textureFilter;
                this.magFilter = textureFilter;
                TextureWrap textureWrap = TextureWrap.ClampToEdge;
                this.uWrap = textureWrap;
                this.vWrap = textureWrap;
            }
        }

        public static class Region {
            public int degrees;
            public boolean flip;
            public int height;
            public int index = -1;
            public int left;
            public String name;
            public String[] names;
            public float offsetX;
            public float offsetY;
            public int originalHeight;
            public int originalWidth;
            public Page page;
            public boolean rotate;
            public int top;
            public int[][] values;
            public int width;

            public int[] findValue(String str) {
                String[] strArr = this.names;
                if (strArr != null) {
                    int length = strArr.length;
                    for (int i = 0; i < length; i++) {
                        if (str.equals(this.names[i])) {
                            return this.values[i];
                        }
                    }
                }
                return null;
            }
        }

        public TextureAtlasData() {
        }

        public static int readEntry(String[] strArr, String str) throws IOException {
            if (str == null) {
                return 0;
            }
            String trim = str.trim();
            if (trim.length() == 0) {
                return 0;
            }
            int indexOf = trim.indexOf(58);
            if (indexOf == -1) {
                return 0;
            }
            strArr[0] = trim.substring(0, indexOf).trim();
            int i = 1;
            int i2 = indexOf + 1;
            while (true) {
                int indexOf2 = trim.indexOf(44, i2);
                if (indexOf2 == -1) {
                    strArr[i] = trim.substring(i2).trim();
                    return i;
                }
                strArr[i] = trim.substring(i2, indexOf2).trim();
                i2 = indexOf2 + 1;
                if (i == 4) {
                    return 4;
                }
                i++;
            }
        }

        public Array<Page> getPages() {
            return this.pages;
        }

        public Array<Region> getRegions() {
            return this.regions;
        }

        public void load(FileHandle fileHandle, FileHandle fileHandle2, boolean z) {
            String str;
            final String[] strArr = new String[5];
            ObjectMap objectMap = new ObjectMap(15, 0.99f);
            objectMap.put(Response.SIZE, new Field<Page>() {
                public void parse(Page page) {
                    page.width = (float) Integer.parseInt(strArr[1]);
                    page.height = (float) Integer.parseInt(strArr[2]);
                }
            });
            objectMap.put("format", new Field<Page>() {
                public void parse(Page page) {
                    page.format = Format.valueOf(strArr[1]);
                }
            });
            objectMap.put("filter", new Field<Page>() {
                public void parse(Page page) {
                    page.minFilter = TextureFilter.valueOf(strArr[1]);
                    page.magFilter = TextureFilter.valueOf(strArr[2]);
                    page.useMipMaps = page.minFilter.isMipMap();
                }
            });
            objectMap.put(ReactVideoViewManager.PROP_REPEAT, new Field<Page>() {
                public void parse(Page page) {
                    if (strArr[1].indexOf(120) != -1) {
                        page.uWrap = TextureWrap.Repeat;
                    }
                    if (strArr[1].indexOf(121) != -1) {
                        page.vWrap = TextureWrap.Repeat;
                    }
                }
            });
            objectMap.put("pma", new Field<Page>() {
                public void parse(Page page) {
                    page.pma = strArr[1].equals(BaseParser.TRUE);
                }
            });
            boolean z2 = true;
            final boolean[] zArr = {false};
            ObjectMap objectMap2 = new ObjectMap(127, 0.99f);
            objectMap2.put("xy", new Field<Region>() {
                public void parse(Region region) {
                    region.left = Integer.parseInt(strArr[1]);
                    region.top = Integer.parseInt(strArr[2]);
                }
            });
            objectMap2.put(Response.SIZE, new Field<Region>() {
                public void parse(Region region) {
                    region.width = Integer.parseInt(strArr[1]);
                    region.height = Integer.parseInt(strArr[2]);
                }
            });
            objectMap2.put("bounds", new Field<Region>() {
                public void parse(Region region) {
                    region.left = Integer.parseInt(strArr[1]);
                    region.top = Integer.parseInt(strArr[2]);
                    region.width = Integer.parseInt(strArr[3]);
                    region.height = Integer.parseInt(strArr[4]);
                }
            });
            objectMap2.put("offset", new Field<Region>() {
                public void parse(Region region) {
                    region.offsetX = (float) Integer.parseInt(strArr[1]);
                    region.offsetY = (float) Integer.parseInt(strArr[2]);
                }
            });
            objectMap2.put("orig", new Field<Region>() {
                public void parse(Region region) {
                    region.originalWidth = Integer.parseInt(strArr[1]);
                    region.originalHeight = Integer.parseInt(strArr[2]);
                }
            });
            objectMap2.put("offsets", new Field<Region>() {
                public void parse(Region region) {
                    region.offsetX = (float) Integer.parseInt(strArr[1]);
                    region.offsetY = (float) Integer.parseInt(strArr[2]);
                    region.originalWidth = Integer.parseInt(strArr[3]);
                    region.originalHeight = Integer.parseInt(strArr[4]);
                }
            });
            objectMap2.put("rotate", new Field<Region>() {
                public void parse(Region region) {
                    boolean z = true;
                    String str = strArr[1];
                    if (str.equals(BaseParser.TRUE)) {
                        region.degrees = 90;
                    } else if (!str.equals(BaseParser.FALSE)) {
                        region.degrees = Integer.parseInt(str);
                    }
                    if (region.degrees != 90) {
                        z = false;
                    }
                    region.rotate = z;
                }
            });
            objectMap2.put("index", new Field<Region>() {
                public void parse(Region region) {
                    int parseInt = Integer.parseInt(strArr[1]);
                    region.index = parseInt;
                    if (parseInt != -1) {
                        zArr[0] = true;
                    }
                }
            });
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileHandle.read()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                while (readLine != null && readLine.trim().length() == 0) {
                    readLine = bufferedReader.readLine();
                }
                while (true) {
                    if (str == null) {
                        break;
                    } else if (str.trim().length() == 0) {
                        break;
                    } else if (readEntry(strArr, str) == 0) {
                        break;
                    } else {
                        readLine = bufferedReader.readLine();
                    }
                }
                Page page = null;
                Array array = null;
                Array array2 = null;
                while (str != null) {
                    if (str.trim().length() == 0) {
                        str = bufferedReader.readLine();
                        page = null;
                    } else if (page == null) {
                        page = new Page();
                        page.textureFile = fileHandle2.child(str);
                        while (true) {
                            str = bufferedReader.readLine();
                            if (readEntry(strArr, str) == 0) {
                                break;
                            }
                            Field field = (Field) objectMap.get(strArr[0]);
                            if (field != null) {
                                field.parse(page);
                            }
                        }
                        this.pages.add(page);
                    } else {
                        FileHandle fileHandle3 = fileHandle2;
                        Region region = new Region();
                        region.page = page;
                        region.name = str.trim();
                        if (z) {
                            region.flip = z2;
                        }
                        while (true) {
                            str = bufferedReader.readLine();
                            int readEntry = readEntry(strArr, str);
                            if (readEntry == 0) {
                                break;
                            }
                            Field field2 = (Field) objectMap2.get(strArr[0]);
                            if (field2 != null) {
                                field2.parse(region);
                            } else {
                                if (array == null) {
                                    array = new Array(z2, 8);
                                    array2 = new Array(z2, 8);
                                }
                                array.add(strArr[0]);
                                int[] iArr = new int[readEntry];
                                int i = 0;
                                while (i < readEntry) {
                                    int i2 = i + 1;
                                    try {
                                        iArr[i] = Integer.parseInt(strArr[i2]);
                                    } catch (NumberFormatException unused) {
                                    }
                                    i = i2;
                                }
                                array2.add(iArr);
                            }
                            z2 = true;
                        }
                        if (region.originalWidth == 0 && region.originalHeight == 0) {
                            region.originalWidth = region.width;
                            region.originalHeight = region.height;
                        }
                        if (array != null && array.size > 0) {
                            region.names = (String[]) array.toArray(String.class);
                            region.values = (int[][]) array2.toArray(int[].class);
                            array.clear();
                            array2.clear();
                        }
                        this.regions.add(region);
                    }
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused2) {
                }
                if (zArr[0]) {
                    this.regions.sort(new Comparator<Region>() {
                        public int compare(Region region, Region region2) {
                            int i = region.index;
                            int i2 = Integer.MAX_VALUE;
                            if (i == -1) {
                                i = Integer.MAX_VALUE;
                            }
                            int i3 = region2.index;
                            if (i3 != -1) {
                                i2 = i3;
                            }
                            return i - i2;
                        }
                    });
                    return;
                }
                return;
            } catch (Exception e2) {
                throw new GdxRuntimeException("Error reading texture atlas file: " + fileHandle, e2);
            } catch (Throwable unused3) {
            }
            throw th;
        }

        public TextureAtlasData(FileHandle fileHandle, FileHandle fileHandle2, boolean z) {
            load(fileHandle, fileHandle2, z);
        }
    }

    public TextureAtlas() {
        this.textures = new ObjectSet<>(4, 0.8f);
        this.regions = new Array<>();
    }

    private Sprite newSprite(AtlasRegion atlasRegion) {
        if (atlasRegion.packedWidth != atlasRegion.originalWidth || atlasRegion.packedHeight != atlasRegion.originalHeight) {
            return new AtlasSprite(atlasRegion);
        }
        if (!atlasRegion.rotate) {
            return new Sprite((TextureRegion) atlasRegion);
        }
        Sprite sprite = new Sprite((TextureRegion) atlasRegion);
        sprite.setBounds(0.0f, 0.0f, (float) atlasRegion.getRegionHeight(), (float) atlasRegion.getRegionWidth());
        sprite.rotate90(true);
        return sprite;
    }

    public AtlasRegion addRegion(String str, Texture texture, int i, int i2, int i3, int i4) {
        this.textures.add(texture);
        AtlasRegion atlasRegion = new AtlasRegion(texture, i, i2, i3, i4);
        atlasRegion.name = str;
        this.regions.add(atlasRegion);
        return atlasRegion;
    }

    public NinePatch createPatch(String str) {
        int i = this.regions.size;
        for (int i2 = 0; i2 < i; i2++) {
            AtlasRegion atlasRegion = (AtlasRegion) this.regions.get(i2);
            if (atlasRegion.name.equals(str)) {
                int[] findValue = atlasRegion.findValue("split");
                if (findValue != null) {
                    NinePatch ninePatch = new NinePatch((TextureRegion) atlasRegion, findValue[0], findValue[1], findValue[2], findValue[3]);
                    int[] findValue2 = atlasRegion.findValue("pad");
                    if (findValue2 != null) {
                        ninePatch.setPadding((float) findValue2[0], (float) findValue2[1], (float) findValue2[2], (float) findValue2[3]);
                    }
                    return ninePatch;
                }
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("Region does not have ninepatch splits: ", str));
            }
        }
        return null;
    }

    public Sprite createSprite(String str) {
        int i = this.regions.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (((AtlasRegion) this.regions.get(i2)).name.equals(str)) {
                return newSprite((AtlasRegion) this.regions.get(i2));
            }
        }
        return null;
    }

    public Array<Sprite> createSprites() {
        Array<Sprite> array = new Array<>(true, this.regions.size, Sprite.class);
        int i = this.regions.size;
        for (int i2 = 0; i2 < i; i2++) {
            array.add(newSprite((AtlasRegion) this.regions.get(i2)));
        }
        return array;
    }

    public void dispose() {
        ObjectSetIterator it = this.textures.iterator();
        while (it.hasNext()) {
            ((Texture) it.next()).dispose();
        }
        ObjectSet<Texture> objectSet = this.textures;
        int tableSize = ObjectSet.tableSize(0, objectSet.loadFactor);
        T[] tArr = objectSet.keyTable;
        if (tArr.length > tableSize) {
            objectSet.size = 0;
            objectSet.resize(tableSize);
        } else if (objectSet.size != 0) {
            objectSet.size = 0;
            Arrays.fill(tArr, null);
        }
    }

    public AtlasRegion findRegion(String str) {
        int i = this.regions.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (((AtlasRegion) this.regions.get(i2)).name.equals(str)) {
                return (AtlasRegion) this.regions.get(i2);
            }
        }
        return null;
    }

    public Array<AtlasRegion> findRegions(String str) {
        Array<AtlasRegion> array = new Array<>(true, 16, AtlasRegion.class);
        int i = this.regions.size;
        for (int i2 = 0; i2 < i; i2++) {
            AtlasRegion atlasRegion = (AtlasRegion) this.regions.get(i2);
            if (atlasRegion.name.equals(str)) {
                array.add(new AtlasRegion(atlasRegion));
            }
        }
        return array;
    }

    public Array<AtlasRegion> getRegions() {
        return this.regions;
    }

    public ObjectSet<Texture> getTextures() {
        return this.textures;
    }

    public void load(TextureAtlasData textureAtlasData) {
        ObjectSet<Texture> objectSet = this.textures;
        int tableSize = ObjectSet.tableSize(objectSet.size + textureAtlasData.pages.size, objectSet.loadFactor);
        if (objectSet.keyTable.length < tableSize) {
            objectSet.resize(tableSize);
        }
        ArrayIterator it = textureAtlasData.pages.iterator();
        while (it.hasNext()) {
            Page page = (Page) it.next();
            if (page.texture == null) {
                page.texture = new Texture(page.textureFile, page.format, page.useMipMaps);
            }
            page.texture.setFilter(page.minFilter, page.magFilter);
            page.texture.setWrap(page.uWrap, page.vWrap);
            this.textures.add(page.texture);
        }
        this.regions.ensureCapacity(textureAtlasData.regions.size);
        ArrayIterator it2 = textureAtlasData.regions.iterator();
        while (it2.hasNext()) {
            Region region = (Region) it2.next();
            AtlasRegion atlasRegion = new AtlasRegion(region.page.texture, region.left, region.top, region.rotate ? region.height : region.width, region.rotate ? region.width : region.height);
            atlasRegion.index = region.index;
            atlasRegion.name = region.name;
            atlasRegion.offsetX = region.offsetX;
            atlasRegion.offsetY = region.offsetY;
            atlasRegion.originalHeight = region.originalHeight;
            atlasRegion.originalWidth = region.originalWidth;
            atlasRegion.rotate = region.rotate;
            atlasRegion.degrees = region.degrees;
            atlasRegion.names = region.names;
            atlasRegion.values = region.values;
            if (region.flip) {
                atlasRegion.flip(false, true);
            }
            this.regions.add(atlasRegion);
        }
    }

    public Sprite createSprite(String str, int i) {
        int i2 = this.regions.size;
        for (int i3 = 0; i3 < i2; i3++) {
            AtlasRegion atlasRegion = (AtlasRegion) this.regions.get(i3);
            if (atlasRegion.index == i && atlasRegion.name.equals(str)) {
                return newSprite((AtlasRegion) this.regions.get(i3));
            }
        }
        return null;
    }

    public AtlasRegion findRegion(String str, int i) {
        int i2 = this.regions.size;
        for (int i3 = 0; i3 < i2; i3++) {
            AtlasRegion atlasRegion = (AtlasRegion) this.regions.get(i3);
            if (atlasRegion.name.equals(str) && atlasRegion.index == i) {
                return atlasRegion;
            }
        }
        return null;
    }

    public Array<Sprite> createSprites(String str) {
        Array<Sprite> array = new Array<>(true, 16, Sprite.class);
        int i = this.regions.size;
        for (int i2 = 0; i2 < i; i2++) {
            AtlasRegion atlasRegion = (AtlasRegion) this.regions.get(i2);
            if (atlasRegion.name.equals(str)) {
                array.add(newSprite(atlasRegion));
            }
        }
        return array;
    }

    public AtlasRegion addRegion(String str, TextureRegion textureRegion) {
        this.textures.add(textureRegion.texture);
        AtlasRegion atlasRegion = new AtlasRegion(textureRegion);
        atlasRegion.name = str;
        this.regions.add(atlasRegion);
        return atlasRegion;
    }

    public TextureAtlas(String str) {
        this(k.files.internal(str));
    }

    public TextureAtlas(FileHandle fileHandle) {
        this(fileHandle, fileHandle.parent());
    }

    public TextureAtlas(FileHandle fileHandle, boolean z) {
        this(fileHandle, fileHandle.parent(), z);
    }

    public TextureAtlas(FileHandle fileHandle, FileHandle fileHandle2) {
        this(fileHandle, fileHandle2, false);
    }

    public TextureAtlas(FileHandle fileHandle, FileHandle fileHandle2, boolean z) {
        this(new TextureAtlasData(fileHandle, fileHandle2, z));
    }

    public TextureAtlas(TextureAtlasData textureAtlasData) {
        this.textures = new ObjectSet<>(4, 0.8f);
        this.regions = new Array<>();
        load(textureAtlasData);
    }
}
