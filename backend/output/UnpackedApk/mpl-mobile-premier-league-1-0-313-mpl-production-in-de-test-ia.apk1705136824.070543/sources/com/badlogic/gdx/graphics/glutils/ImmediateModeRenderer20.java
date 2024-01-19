package com.badlogic.gdx.graphics.glutils;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class ImmediateModeRenderer20 implements ImmediateModeRenderer {
    public final int colorOffset;
    public final int maxVertices;
    public final Mesh mesh;
    public final int normalOffset;
    public int numSetTexCoords;
    public final int numTexCoords;
    public int numVertices;
    public boolean ownsShader;
    public int primitiveType;
    public final Matrix4 projModelView;
    public ShaderProgram shader;
    public final String[] shaderUniformNames;
    public final int texCoordOffset;
    public int vertexIdx;
    public final int vertexSize;
    public final float[] vertices;

    public ImmediateModeRenderer20(boolean z, boolean z2, int i) {
        this(5000, z, z2, i, createDefaultShader(z, z2, i));
        this.ownsShader = true;
    }

    private VertexAttribute[] buildVertexAttributes(boolean z, boolean z2, int i) {
        Array array = new Array();
        array.add(new VertexAttribute(1, 3, ShaderProgram.POSITION_ATTRIBUTE));
        if (z) {
            array.add(new VertexAttribute(8, 3, ShaderProgram.NORMAL_ATTRIBUTE));
        }
        if (z2) {
            array.add(new VertexAttribute(4, 4, ShaderProgram.COLOR_ATTRIBUTE));
        }
        for (int i2 = 0; i2 < i; i2++) {
            array.add(new VertexAttribute(16, 2, GeneratedOutlineSupport.outline41(ShaderProgram.TEXCOORD_ATTRIBUTE, i2)));
        }
        VertexAttribute[] vertexAttributeArr = new VertexAttribute[array.size];
        for (int i3 = 0; i3 < array.size; i3++) {
            vertexAttributeArr[i3] = (VertexAttribute) array.get(i3);
        }
        return vertexAttributeArr;
    }

    public static ShaderProgram createDefaultShader(boolean z, boolean z2, int i) {
        ShaderProgram shaderProgram = new ShaderProgram(createVertexShader(z, z2, i), createFragmentShader(z, z2, i));
        if (shaderProgram.isCompiled()) {
            return shaderProgram;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error compiling shader: ");
        outline73.append(shaderProgram.getLog());
        throw new GdxRuntimeException(outline73.toString());
    }

    public static String createFragmentShader(boolean z, boolean z2, int i) {
        String str;
        String str2 = "#ifdef GL_ES\nprecision mediump float;\n#endif\n";
        if (z2) {
            str2 = GeneratedOutlineSupport.outline50(str2, "varying vec4 v_col;\n");
        }
        for (int i2 = 0; i2 < i; i2++) {
            String str3 = str2 + "varying vec2 v_tex" + i2 + ";\n";
            str2 = str3 + "uniform sampler2D u_sampler" + i2 + ";\n";
        }
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(str2, "void main() {\n   gl_FragColor = ");
        outline78.append(z2 ? "v_col" : "vec4(1, 1, 1, 1)");
        String sb = outline78.toString();
        if (i > 0) {
            sb = GeneratedOutlineSupport.outline50(sb, " * ");
        }
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 == i - 1) {
                str = str + " texture2D(u_sampler" + i3 + ",  v_tex" + i3 + ")";
            } else {
                str = str + " texture2D(u_sampler" + i3 + ",  v_tex" + i3 + ") *";
            }
        }
        return GeneratedOutlineSupport.outline50(str, ";\n}");
    }

    public static String createVertexShader(boolean z, boolean z2, int i) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("attribute vec4 a_position;\n");
        String str = "";
        outline73.append(z ? "attribute vec3 a_normal;\n" : str);
        outline73.append(z2 ? "attribute vec4 a_color;\n" : str);
        String sb = outline73.toString();
        for (int i2 = 0; i2 < i; i2++) {
            sb = sb + "attribute vec2 a_texCoord" + i2 + ";\n";
        }
        StringBuilder outline78 = GeneratedOutlineSupport.outline78(sb, "uniform mat4 u_projModelView;\n");
        if (z2) {
            str = "varying vec4 v_col;\n";
        }
        outline78.append(str);
        String sb2 = outline78.toString();
        for (int i3 = 0; i3 < i; i3++) {
            sb2 = sb2 + "varying vec2 v_tex" + i3 + ";\n";
        }
        String outline50 = GeneratedOutlineSupport.outline50(sb2, "void main() {\n   gl_Position = u_projModelView * a_position;\n");
        if (z2) {
            outline50 = GeneratedOutlineSupport.outline50(outline50, "   v_col = a_color;\n   v_col.a *= 255.0 / 254.0;\n");
        }
        for (int i4 = 0; i4 < i; i4++) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(outline50);
            sb3.append("   v_tex");
            sb3.append(i4);
            sb3.append(" = ");
            sb3.append(ShaderProgram.TEXCOORD_ATTRIBUTE);
            outline50 = GeneratedOutlineSupport.outline57(sb3, i4, ";\n");
        }
        return GeneratedOutlineSupport.outline50(outline50, "   gl_PointSize = 1.0;\n}\n");
    }

    public void begin(Matrix4 matrix4, int i) {
        this.projModelView.set(matrix4);
        this.primitiveType = i;
    }

    public void color(Color color) {
        this.vertices[this.vertexIdx + this.colorOffset] = color.toFloatBits();
    }

    public void dispose() {
        if (this.ownsShader) {
            ShaderProgram shaderProgram = this.shader;
            if (shaderProgram != null) {
                shaderProgram.dispose();
            }
        }
        this.mesh.dispose();
    }

    public void end() {
        flush();
    }

    public void flush() {
        if (this.numVertices != 0) {
            this.shader.bind();
            this.shader.setUniformMatrix((String) "u_projModelView", this.projModelView);
            for (int i = 0; i < this.numTexCoords; i++) {
                this.shader.setUniformi(this.shaderUniformNames[i], i);
            }
            this.mesh.setVertices(this.vertices, 0, this.vertexIdx);
            this.mesh.render(this.shader, this.primitiveType);
            this.numSetTexCoords = 0;
            this.vertexIdx = 0;
            this.numVertices = 0;
        }
    }

    public int getMaxVertices() {
        return this.maxVertices;
    }

    public int getNumVertices() {
        return this.numVertices;
    }

    public ShaderProgram getShader() {
        return this.shader;
    }

    public void normal(float f2, float f3, float f4) {
        int i = this.vertexIdx + this.normalOffset;
        float[] fArr = this.vertices;
        fArr[i] = f2;
        fArr[i + 1] = f3;
        fArr[i + 2] = f4;
    }

    public void setShader(ShaderProgram shaderProgram) {
        if (this.ownsShader) {
            this.shader.dispose();
        }
        this.shader = shaderProgram;
        this.ownsShader = false;
    }

    public void texCoord(float f2, float f3) {
        int i = this.vertexIdx + this.texCoordOffset;
        float[] fArr = this.vertices;
        int i2 = this.numSetTexCoords;
        fArr[i + i2] = f2;
        fArr[i + i2 + 1] = f3;
        this.numSetTexCoords = i2 + 2;
    }

    public void vertex(float f2, float f3, float f4) {
        int i = this.vertexIdx;
        float[] fArr = this.vertices;
        fArr[i] = f2;
        fArr[i + 1] = f3;
        fArr[i + 2] = f4;
        this.numSetTexCoords = 0;
        this.vertexIdx = i + this.vertexSize;
        this.numVertices++;
    }

    public void color(float f2, float f3, float f4, float f5) {
        this.vertices[this.vertexIdx + this.colorOffset] = Color.toFloatBits(f2, f3, f4, f5);
    }

    public ImmediateModeRenderer20(int i, boolean z, boolean z2, int i2) {
        this(i, z, z2, i2, createDefaultShader(z, z2, i2));
        this.ownsShader = true;
    }

    public void color(float f2) {
        this.vertices[this.vertexIdx + this.colorOffset] = f2;
    }

    public ImmediateModeRenderer20(int i, boolean z, boolean z2, int i2, ShaderProgram shaderProgram) {
        this.projModelView = new Matrix4();
        this.maxVertices = i;
        this.numTexCoords = i2;
        this.shader = shaderProgram;
        Mesh mesh2 = new Mesh(false, i, 0, buildVertexAttributes(z, z2, i2));
        this.mesh = mesh2;
        this.vertices = new float[((mesh2.getVertexAttributes().vertexSize / 4) * i)];
        this.vertexSize = this.mesh.getVertexAttributes().vertexSize / 4;
        this.normalOffset = this.mesh.getVertexAttribute(8) != null ? this.mesh.getVertexAttribute(8).offset / 4 : 0;
        this.colorOffset = this.mesh.getVertexAttribute(4) != null ? this.mesh.getVertexAttribute(4).offset / 4 : 0;
        this.texCoordOffset = this.mesh.getVertexAttribute(16) != null ? this.mesh.getVertexAttribute(16).offset / 4 : 0;
        this.shaderUniformNames = new String[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            this.shaderUniformNames[i3] = GeneratedOutlineSupport.outline41("u_sampler", i3);
        }
    }
}
