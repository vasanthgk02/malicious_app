package com.badlogic.gdx.graphics.g3d.decals;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Values;
import com.badlogic.gdx.utils.Pool;
import java.util.Comparator;

public class CameraGroupStrategy implements GroupStrategy, Disposable {
    public static final int GROUP_BLEND = 1;
    public static final int GROUP_OPAQUE = 0;
    public Pool<Array<Decal>> arrayPool;
    public Camera camera;
    public final Comparator<Decal> cameraSorter;
    public ObjectMap<DecalMaterial, Array<Decal>> materialGroups;
    public ShaderProgram shader;
    public Array<Array<Decal>> usedArrays;

    public CameraGroupStrategy(final Camera camera2) {
        this(camera2, new Comparator<Decal>() {
            public int compare(Decal decal, Decal decal2) {
                return (int) Math.signum(Camera.this.position.dst(decal2.position) - Camera.this.position.dst(decal.position));
            }
        });
    }

    private void createDefaultShader() {
        ShaderProgram shaderProgram = new ShaderProgram((String) "attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projectionViewMatrix;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main()\n{\n   v_color = a_color;\n   v_color.a = v_color.a * (255.0/254.0);\n   v_texCoords = a_texCoord0;\n   gl_Position =  u_projectionViewMatrix * a_position;\n}\n", (String) "#ifdef GL_ES\nprecision mediump float;\n#endif\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nvoid main()\n{\n  gl_FragColor = v_color * texture2D(u_texture, v_texCoords);\n}");
        this.shader = shaderProgram;
        if (!shaderProgram.isCompiled()) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("couldn't compile shader: ");
            outline73.append(this.shader.getLog());
            throw new IllegalArgumentException(outline73.toString());
        }
    }

    public void afterGroup(int i) {
        if (i == 1) {
            k.gl.glDisable(GL20.GL_BLEND);
        }
    }

    public void afterGroups() {
        k.gl.glDisable(GL20.GL_DEPTH_TEST);
    }

    public void beforeGroup(int i, Array<Decal> array) {
        if (i == 1) {
            k.gl.glEnable(GL20.GL_BLEND);
            array.sort(this.cameraSorter);
            return;
        }
        int i2 = array.size;
        for (int i3 = 0; i3 < i2; i3++) {
            Decal decal = (Decal) array.get(i3);
            Array array2 = (Array) this.materialGroups.get(decal.material);
            if (array2 == null) {
                array2 = (Array) this.arrayPool.obtain();
                array2.clear();
                this.usedArrays.add(array2);
                this.materialGroups.put(decal.material, array2);
            }
            array2.add(decal);
        }
        array.clear();
        Values values = this.materialGroups.values();
        if (values != null) {
            while (values.hasNext()) {
                array.addAll((Array) values.next());
            }
            this.materialGroups.clear();
            this.arrayPool.freeAll(this.usedArrays);
            this.usedArrays.clear();
            return;
        }
        throw null;
    }

    public void beforeGroups() {
        k.gl.glEnable(GL20.GL_DEPTH_TEST);
        this.shader.bind();
        this.shader.setUniformMatrix((String) "u_projectionViewMatrix", this.camera.combined);
        this.shader.setUniformi((String) "u_texture", 0);
    }

    public int decideGroup(Decal decal) {
        return decal.getMaterial().isOpaque() ^ true ? 1 : 0;
    }

    public void dispose() {
        ShaderProgram shaderProgram = this.shader;
        if (shaderProgram != null) {
            shaderProgram.dispose();
        }
    }

    public Camera getCamera() {
        return this.camera;
    }

    public ShaderProgram getGroupShader(int i) {
        return this.shader;
    }

    public void setCamera(Camera camera2) {
        this.camera = camera2;
    }

    public CameraGroupStrategy(Camera camera2, Comparator<Decal> comparator) {
        this.arrayPool = new Pool<Array<Decal>>(16) {
            public Array<Decal> newObject() {
                return new Array<>();
            }
        };
        this.usedArrays = new Array<>();
        this.materialGroups = new ObjectMap<>();
        this.camera = camera2;
        this.cameraSorter = comparator;
        createDefaultShader();
    }
}
