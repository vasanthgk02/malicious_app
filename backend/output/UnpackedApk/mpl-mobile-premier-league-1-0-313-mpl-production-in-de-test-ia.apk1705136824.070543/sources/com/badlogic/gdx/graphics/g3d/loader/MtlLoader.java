package com.badlogic.gdx.graphics.g3d.loader;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.graphics.g3d.model.data.ModelTexture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Array.ArrayIterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: ObjLoader */
public class MtlLoader {
    public Array<ModelMaterial> materials = new Array<>();

    public ModelMaterial getMaterial(String str) {
        ArrayIterator it = this.materials.iterator();
        while (it.hasNext()) {
            ModelMaterial modelMaterial = (ModelMaterial) it.next();
            if (modelMaterial.id.equals(str)) {
                return modelMaterial;
            }
        }
        ModelMaterial modelMaterial2 = new ModelMaterial();
        modelMaterial2.id = str;
        modelMaterial2.diffuse = new Color(Color.WHITE);
        this.materials.add(modelMaterial2);
        return modelMaterial2;
    }

    public void load(FileHandle fileHandle) {
        String str;
        Color color = Color.WHITE;
        if (fileHandle != null && fileHandle.exists()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileHandle.read()), 4096);
            String str2 = "default";
            String str3 = null;
            float f2 = 1.0f;
            float f3 = 0.0f;
            Color color2 = color;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.length() > 0 && readLine.charAt(0) == 9) {
                        readLine = readLine.substring(1).trim();
                    }
                    String[] split = readLine.split("\\s+");
                    if (split[0].length() != 0) {
                        if (split[0].charAt(0) != '#') {
                            String lowerCase = split[0].toLowerCase();
                            if (lowerCase.equals("newmtl")) {
                                ModelMaterial modelMaterial = new ModelMaterial();
                                modelMaterial.id = str2;
                                modelMaterial.diffuse = new Color(color);
                                modelMaterial.specular = new Color(color2);
                                modelMaterial.opacity = f2;
                                modelMaterial.shininess = f3;
                                if (str3 != null) {
                                    ModelTexture modelTexture = new ModelTexture();
                                    modelTexture.usage = 2;
                                    modelTexture.fileName = new String(str3);
                                    if (modelMaterial.textures == null) {
                                        modelMaterial.textures = new Array<>(true, 1);
                                    }
                                    modelMaterial.textures.add(modelTexture);
                                }
                                this.materials.add(modelMaterial);
                                if (split.length > 1) {
                                    str = split[1].replace('.', '_');
                                } else {
                                    str = "default";
                                }
                                str2 = str;
                                color = Color.WHITE;
                                color2 = Color.WHITE;
                                f2 = 1.0f;
                                f3 = 0.0f;
                            } else {
                                if (!lowerCase.equals("kd")) {
                                    if (!lowerCase.equals("ks")) {
                                        if (!lowerCase.equals("tr")) {
                                            if (!lowerCase.equals("d")) {
                                                if (lowerCase.equals("ns")) {
                                                    f3 = Float.parseFloat(split[1]);
                                                } else if (lowerCase.equals("map_kd")) {
                                                    str3 = fileHandle.parent().child(split[1]).path();
                                                }
                                            }
                                        }
                                        f2 = Float.parseFloat(split[1]);
                                    }
                                }
                                float parseFloat = Float.parseFloat(split[1]);
                                float parseFloat2 = Float.parseFloat(split[2]);
                                float parseFloat3 = Float.parseFloat(split[3]);
                                float parseFloat4 = split.length > 4 ? Float.parseFloat(split[4]) : 1.0f;
                                if (split[0].toLowerCase().equals("kd")) {
                                    color = new Color();
                                    color.set(parseFloat, parseFloat2, parseFloat3, parseFloat4);
                                } else {
                                    color2 = new Color();
                                    color2.set(parseFloat, parseFloat2, parseFloat3, parseFloat4);
                                }
                            }
                        }
                    }
                } catch (IOException unused) {
                    return;
                }
            }
            bufferedReader.close();
            ModelMaterial modelMaterial2 = new ModelMaterial();
            modelMaterial2.id = str2;
            modelMaterial2.diffuse = new Color(color);
            modelMaterial2.specular = new Color(color2);
            modelMaterial2.opacity = f2;
            modelMaterial2.shininess = f3;
            if (str3 != null) {
                ModelTexture modelTexture2 = new ModelTexture();
                modelTexture2.usage = 2;
                modelTexture2.fileName = new String(str3);
                if (modelMaterial2.textures == null) {
                    modelMaterial2.textures = new Array<>(true, 1);
                }
                modelMaterial2.textures.add(modelTexture2);
            }
            this.materials.add(modelMaterial2);
        }
    }
}
