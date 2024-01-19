package com.badlogic.gdx.graphics.g3d.utils.shapebuilders;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder.VertexInfo;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.FlushablePool;

public class BaseShapeBuilder {
    public static final Matrix4 matTmp1 = new Matrix4();
    public static final FlushablePool<Matrix4> matrices4Pool = new FlushablePool<Matrix4>() {
        public Matrix4 newObject() {
            return new Matrix4();
        }
    };
    public static final Color tmpColor0 = new Color();
    public static final Color tmpColor1 = new Color();
    public static final Color tmpColor2 = new Color();
    public static final Color tmpColor3 = new Color();
    public static final Color tmpColor4 = new Color();
    public static final Vector3 tmpV0 = new Vector3();
    public static final Vector3 tmpV1 = new Vector3();
    public static final Vector3 tmpV2 = new Vector3();
    public static final Vector3 tmpV3 = new Vector3();
    public static final Vector3 tmpV4 = new Vector3();
    public static final Vector3 tmpV5 = new Vector3();
    public static final Vector3 tmpV6 = new Vector3();
    public static final Vector3 tmpV7 = new Vector3();
    public static final FlushablePool<Vector3> vectorPool = new FlushablePool<Vector3>() {
        public Vector3 newObject() {
            return new Vector3();
        }
    };
    public static final VertexInfo vertTmp0 = new VertexInfo();
    public static final VertexInfo vertTmp1 = new VertexInfo();
    public static final VertexInfo vertTmp2 = new VertexInfo();
    public static final VertexInfo vertTmp3 = new VertexInfo();
    public static final VertexInfo vertTmp4 = new VertexInfo();
    public static final VertexInfo vertTmp5 = new VertexInfo();
    public static final VertexInfo vertTmp6 = new VertexInfo();
    public static final VertexInfo vertTmp7 = new VertexInfo();
    public static final VertexInfo vertTmp8 = new VertexInfo();

    public static void freeAll() {
        vectorPool.flush();
        matrices4Pool.flush();
    }

    public static Matrix4 obtainM4() {
        return (Matrix4) matrices4Pool.obtain();
    }

    public static Vector3 obtainV3() {
        return (Vector3) vectorPool.obtain();
    }
}
