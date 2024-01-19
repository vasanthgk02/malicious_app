package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Op;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
public class MergePathsContent implements PathContent, GreedyContent {
    public final Path firstPath = new Path();
    public final MergePaths mergePaths;
    public final String name;
    public final Path path = new Path();
    public final List<PathContent> pathContents = new ArrayList();
    public final Path remainderPath = new Path();

    public MergePathsContent(MergePaths mergePaths2) {
        this.name = mergePaths2.name;
        this.mergePaths = mergePaths2;
    }

    public void absorbContent(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious()) {
            if (listIterator.previous() == this) {
                break;
            }
        }
        while (listIterator.hasPrevious()) {
            Content previous = listIterator.previous();
            if (previous instanceof PathContent) {
                this.pathContents.add((PathContent) previous);
                listIterator.remove();
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        this.path.reset();
        MergePaths mergePaths2 = this.mergePaths;
        if (mergePaths2.hidden) {
            return this.path;
        }
        int ordinal = mergePaths2.mode.ordinal();
        if (ordinal == 0) {
            for (int i = 0; i < this.pathContents.size(); i++) {
                this.path.addPath(this.pathContents.get(i).getPath());
            }
        } else if (ordinal == 1) {
            opFirstPathWithRest(Op.UNION);
        } else if (ordinal == 2) {
            opFirstPathWithRest(Op.REVERSE_DIFFERENCE);
        } else if (ordinal == 3) {
            opFirstPathWithRest(Op.INTERSECT);
        } else if (ordinal == 4) {
            opFirstPathWithRest(Op.XOR);
        }
        return this.path;
    }

    @TargetApi(19)
    public final void opFirstPathWithRest(Op op) {
        Matrix matrix;
        Matrix matrix2;
        this.remainderPath.reset();
        this.firstPath.reset();
        for (int size = this.pathContents.size() - 1; size >= 1; size--) {
            PathContent pathContent = this.pathContents.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                List<PathContent> pathList = contentGroup.getPathList();
                for (int size2 = pathList.size() - 1; size2 >= 0; size2--) {
                    Path path2 = pathList.get(size2).getPath();
                    TransformKeyframeAnimation transformKeyframeAnimation = contentGroup.transformAnimation;
                    if (transformKeyframeAnimation != null) {
                        matrix2 = transformKeyframeAnimation.getMatrix();
                    } else {
                        contentGroup.matrix.reset();
                        matrix2 = contentGroup.matrix;
                    }
                    path2.transform(matrix2);
                    this.remainderPath.addPath(path2);
                }
            } else {
                this.remainderPath.addPath(pathContent.getPath());
            }
        }
        PathContent pathContent2 = this.pathContents.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List<PathContent> pathList2 = contentGroup2.getPathList();
            for (int i = 0; i < pathList2.size(); i++) {
                Path path3 = pathList2.get(i).getPath();
                TransformKeyframeAnimation transformKeyframeAnimation2 = contentGroup2.transformAnimation;
                if (transformKeyframeAnimation2 != null) {
                    matrix = transformKeyframeAnimation2.getMatrix();
                } else {
                    contentGroup2.matrix.reset();
                    matrix = contentGroup2.matrix;
                }
                path3.transform(matrix);
                this.firstPath.addPath(path3);
            }
        } else {
            this.firstPath.set(pathContent2.getPath());
        }
        this.path.op(this.firstPath, this.remainderPath, op);
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i = 0; i < this.pathContents.size(); i++) {
            this.pathContents.get(i).setContents(list, list2);
        }
    }
}
