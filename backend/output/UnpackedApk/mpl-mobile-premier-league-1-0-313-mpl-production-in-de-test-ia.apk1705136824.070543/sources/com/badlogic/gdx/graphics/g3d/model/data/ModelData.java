package com.badlogic.gdx.graphics.g3d.model.data;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ModelData {
    public final Array<ModelAnimation> animations = new Array<>();
    public String id;
    public final Array<ModelMaterial> materials = new Array<>();
    public final Array<ModelMesh> meshes = new Array<>();
    public final Array<ModelNode> nodes = new Array<>();
    public final short[] version = new short[2];

    public void addMesh(ModelMesh modelMesh) {
        ArrayIterator it = this.meshes.iterator();
        while (it.hasNext()) {
            ModelMesh modelMesh2 = (ModelMesh) it.next();
            if (modelMesh2.id.equals(modelMesh.id)) {
                throw new GdxRuntimeException(GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("Mesh with id '"), modelMesh2.id, "' already in model"));
            }
        }
        this.meshes.add(modelMesh);
    }
}
