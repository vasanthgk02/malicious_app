package com.badlogic.gdx.graphics.g3d.decals;

import co.hyperverge.hypersnapsdk.c.k;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Sort;
import com.badlogic.gdx.utils.TimSort;

public class SimpleOrthoGroupStrategy implements GroupStrategy {
    public static final int GROUP_BLEND = 1;
    public static final int GROUP_OPAQUE = 0;
    public Comparator comparator = new Comparator();

    public class Comparator implements java.util.Comparator<Decal> {
        public Comparator() {
        }

        public int compare(Decal decal, Decal decal2) {
            if (decal.getZ() == decal2.getZ()) {
                return 0;
            }
            return decal.getZ() - decal2.getZ() < 0.0f ? -1 : 1;
        }
    }

    public void afterGroup(int i) {
        if (i == 1) {
            k.gl.glDepthMask(true);
            k.gl.glDisable(GL20.GL_BLEND);
        }
    }

    public void afterGroups() {
        k.gl.glDisable(GL20.GL_TEXTURE_2D);
    }

    public void beforeGroup(int i, Array<Decal> array) {
        if (i == 1) {
            Sort instance = Sort.instance();
            Comparator comparator2 = this.comparator;
            if (instance.timSort == null) {
                instance.timSort = new TimSort();
            }
            instance.timSort.doSort(array.items, comparator2, 0, array.size);
            k.gl.glEnable(GL20.GL_BLEND);
            k.gl.glDepthMask(false);
        }
    }

    public void beforeGroups() {
        k.gl.glEnable(GL20.GL_TEXTURE_2D);
    }

    public int decideGroup(Decal decal) {
        return decal.getMaterial().isOpaque() ^ true ? 1 : 0;
    }

    public ShaderProgram getGroupShader(int i) {
        return null;
    }
}
