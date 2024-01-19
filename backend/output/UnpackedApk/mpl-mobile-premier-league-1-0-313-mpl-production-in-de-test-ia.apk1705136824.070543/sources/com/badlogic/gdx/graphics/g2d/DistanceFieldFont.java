package com.badlogic.gdx.graphics.g2d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;

public class DistanceFieldFont extends BitmapFont {
    public float distanceFieldSmoothing;

    public static class DistanceFieldFontCache extends BitmapFontCache {
        public DistanceFieldFontCache(DistanceFieldFont distanceFieldFont) {
            super(distanceFieldFont, distanceFieldFont.usesIntegerPositions());
        }

        private float getSmoothingFactor() {
            DistanceFieldFont distanceFieldFont = (DistanceFieldFont) super.getFont();
            return distanceFieldFont.getScaleX() * distanceFieldFont.getDistanceFieldSmoothing();
        }

        private void setSmoothingUniform(Batch batch, float f2) {
            batch.flush();
            batch.getShader().setUniformf((String) "u_smoothing", f2);
        }

        public void draw(Batch batch) {
            setSmoothingUniform(batch, getSmoothingFactor());
            super.draw(batch);
            setSmoothingUniform(batch, 0.0f);
        }

        public DistanceFieldFontCache(DistanceFieldFont distanceFieldFont, boolean z) {
            super(distanceFieldFont, z);
        }

        public void draw(Batch batch, int i, int i2) {
            setSmoothingUniform(batch, getSmoothingFactor());
            super.draw(batch, i, i2);
            setSmoothingUniform(batch, 0.0f);
        }
    }

    public DistanceFieldFont(BitmapFontData bitmapFontData, Array<TextureRegion> array, boolean z) {
        super(bitmapFontData, array, z);
    }

    public static ShaderProgram createDistanceFieldShader() {
        ShaderProgram shaderProgram = new ShaderProgram((String) "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n\tv_color = a_color;\n\tv_color.a = v_color.a * (255.0/254.0);\n\tv_texCoords = a_texCoord0;\n\tgl_Position =  u_projTrans * a_position;\n}\n", (String) "#ifdef GL_ES\n\tprecision mediump float;\n\tprecision mediump int;\n#endif\n\nuniform sampler2D u_texture;\nuniform float u_smoothing;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n\tif (u_smoothing > 0.0) {\n\t\tfloat smoothing = 0.25 / u_smoothing;\n\t\tfloat distance = texture2D(u_texture, v_texCoords).a;\n\t\tfloat alpha = smoothstep(0.5 - smoothing, 0.5 + smoothing, distance);\n\t\tgl_FragColor = vec4(v_color.rgb, alpha * v_color.a);\n\t} else {\n\t\tgl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n\t}\n}\n");
        if (shaderProgram.isCompiled()) {
            return shaderProgram;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error compiling distance field shader: ");
        outline73.append(shaderProgram.getLog());
        throw new IllegalArgumentException(outline73.toString());
    }

    public float getDistanceFieldSmoothing() {
        return this.distanceFieldSmoothing;
    }

    public void load(BitmapFontData bitmapFontData) {
        super.load(bitmapFontData);
        ArrayIterator it = getRegions().iterator();
        while (it.hasNext()) {
            Texture texture = ((TextureRegion) it.next()).getTexture();
            TextureFilter textureFilter = TextureFilter.Linear;
            texture.setFilter(textureFilter, textureFilter);
        }
    }

    public BitmapFontCache newFontCache() {
        return new DistanceFieldFontCache(this, this.integer);
    }

    public void setDistanceFieldSmoothing(float f2) {
        this.distanceFieldSmoothing = f2;
    }

    public DistanceFieldFont(BitmapFontData bitmapFontData, TextureRegion textureRegion, boolean z) {
        super(bitmapFontData, textureRegion, z);
    }

    public DistanceFieldFont(FileHandle fileHandle, boolean z) {
        super(fileHandle, z);
    }

    public DistanceFieldFont(FileHandle fileHandle, FileHandle fileHandle2, boolean z, boolean z2) {
        super(fileHandle, fileHandle2, z, z2);
    }

    public DistanceFieldFont(FileHandle fileHandle, FileHandle fileHandle2, boolean z) {
        super(fileHandle, fileHandle2, z);
    }

    public DistanceFieldFont(FileHandle fileHandle, TextureRegion textureRegion, boolean z) {
        super(fileHandle, textureRegion, z);
    }

    public DistanceFieldFont(FileHandle fileHandle, TextureRegion textureRegion) {
        super(fileHandle, textureRegion);
    }

    public DistanceFieldFont(FileHandle fileHandle) {
        super(fileHandle);
    }
}
