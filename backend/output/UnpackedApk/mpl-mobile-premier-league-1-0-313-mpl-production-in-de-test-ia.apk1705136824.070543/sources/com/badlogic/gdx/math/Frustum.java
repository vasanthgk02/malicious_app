package com.badlogic.gdx.math;

public class Frustum {
    public static final Vector3[] clipSpacePlanePoints;
    public static final float[] clipSpacePlanePointsArray = new float[24];
    public final Vector3[] planePoints;
    public final float[] planePointsArray;
    public final Plane[] planes = new Plane[6];

    static {
        int i = 0;
        Vector3[] vector3Arr = {new Vector3(-1.0f, -1.0f, -1.0f), new Vector3(1.0f, -1.0f, -1.0f), new Vector3(1.0f, 1.0f, -1.0f), new Vector3(-1.0f, 1.0f, -1.0f), new Vector3(-1.0f, -1.0f, 1.0f), new Vector3(1.0f, -1.0f, 1.0f), new Vector3(1.0f, 1.0f, 1.0f), new Vector3(-1.0f, 1.0f, 1.0f)};
        clipSpacePlanePoints = vector3Arr;
        int length = vector3Arr.length;
        int i2 = 0;
        while (i < length) {
            Vector3 vector3 = vector3Arr[i];
            float[] fArr = clipSpacePlanePointsArray;
            int i3 = i2 + 1;
            fArr[i2] = vector3.x;
            int i4 = i3 + 1;
            fArr[i3] = vector3.y;
            fArr[i4] = vector3.z;
            i++;
            i2 = i4 + 1;
        }
    }

    public Frustum() {
        this.planePoints = new Vector3[]{new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3(), new Vector3()};
        this.planePointsArray = new float[24];
        for (int i = 0; i < 6; i++) {
            this.planes[i] = new Plane(new Vector3(), 0.0f);
        }
    }

    public void update(Matrix4 matrix4) {
        float[] fArr = clipSpacePlanePointsArray;
        System.arraycopy(fArr, 0, this.planePointsArray, 0, fArr.length);
        Matrix4.prj(matrix4.val, this.planePointsArray, 0, 8, 3);
        int i = 0;
        int i2 = 0;
        while (i < 8) {
            Vector3 vector3 = this.planePoints[i];
            float[] fArr2 = this.planePointsArray;
            int i3 = i2 + 1;
            vector3.x = fArr2[i2];
            int i4 = i3 + 1;
            vector3.y = fArr2[i3];
            vector3.z = fArr2[i4];
            i++;
            i2 = i4 + 1;
        }
        Plane plane = this.planes[0];
        Vector3[] vector3Arr = this.planePoints;
        plane.set(vector3Arr[1], vector3Arr[0], vector3Arr[2]);
        Plane plane2 = this.planes[1];
        Vector3[] vector3Arr2 = this.planePoints;
        plane2.set(vector3Arr2[4], vector3Arr2[5], vector3Arr2[7]);
        Plane plane3 = this.planes[2];
        Vector3[] vector3Arr3 = this.planePoints;
        plane3.set(vector3Arr3[0], vector3Arr3[4], vector3Arr3[3]);
        Plane plane4 = this.planes[3];
        Vector3[] vector3Arr4 = this.planePoints;
        plane4.set(vector3Arr4[5], vector3Arr4[1], vector3Arr4[6]);
        Plane plane5 = this.planes[4];
        Vector3[] vector3Arr5 = this.planePoints;
        plane5.set(vector3Arr5[2], vector3Arr5[3], vector3Arr5[6]);
        Plane plane6 = this.planes[5];
        Vector3[] vector3Arr6 = this.planePoints;
        plane6.set(vector3Arr6[4], vector3Arr6[0], vector3Arr6[1]);
    }
}
