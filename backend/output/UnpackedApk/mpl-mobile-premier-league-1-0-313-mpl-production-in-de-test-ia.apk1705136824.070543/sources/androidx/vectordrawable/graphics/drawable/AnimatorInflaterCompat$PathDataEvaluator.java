package androidx.vectordrawable.graphics.drawable;

import a.a.a.a.d.b;
import android.animation.TypeEvaluator;
import androidx.core.graphics.PathParser$PathDataNode;

public class AnimatorInflaterCompat$PathDataEvaluator implements TypeEvaluator<PathParser$PathDataNode[]> {
    public PathParser$PathDataNode[] mNodeArray;

    public Object evaluate(float f2, Object obj, Object obj2) {
        PathParser$PathDataNode[] pathParser$PathDataNodeArr = (PathParser$PathDataNode[]) obj;
        PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = (PathParser$PathDataNode[]) obj2;
        if (b.canMorph(pathParser$PathDataNodeArr, pathParser$PathDataNodeArr2)) {
            if (!b.canMorph(this.mNodeArray, pathParser$PathDataNodeArr)) {
                this.mNodeArray = b.deepCopyNodes(pathParser$PathDataNodeArr);
            }
            int i = 0;
            while (i < pathParser$PathDataNodeArr.length) {
                PathParser$PathDataNode pathParser$PathDataNode = this.mNodeArray[i];
                PathParser$PathDataNode pathParser$PathDataNode2 = pathParser$PathDataNodeArr[i];
                PathParser$PathDataNode pathParser$PathDataNode3 = pathParser$PathDataNodeArr2[i];
                if (pathParser$PathDataNode != null) {
                    pathParser$PathDataNode.mType = pathParser$PathDataNode2.mType;
                    int i2 = 0;
                    while (true) {
                        float[] fArr = pathParser$PathDataNode2.mParams;
                        if (i2 >= fArr.length) {
                            break;
                        }
                        pathParser$PathDataNode.mParams[i2] = (pathParser$PathDataNode3.mParams[i2] * f2) + ((1.0f - f2) * fArr[i2]);
                        i2++;
                    }
                    i++;
                } else {
                    throw null;
                }
            }
            return this.mNodeArray;
        }
        throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
}
