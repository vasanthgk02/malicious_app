package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectIntMap;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Keys;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.apache.fontbox.cmap.CMap;

public class ShaderProgram implements Disposable {
    public static final String BINORMAL_ATTRIBUTE = "a_binormal";
    public static final String BONEWEIGHT_ATTRIBUTE = "a_boneWeight";
    public static final String COLOR_ATTRIBUTE = "a_color";
    public static final String NORMAL_ATTRIBUTE = "a_normal";
    public static final String POSITION_ATTRIBUTE = "a_position";
    public static final String TANGENT_ATTRIBUTE = "a_tangent";
    public static final String TEXCOORD_ATTRIBUTE = "a_texCoord";
    public static final IntBuffer intbuf = BufferUtils.newIntBuffer(1);
    public static boolean pedantic = true;
    public static String prependFragmentCode = "";
    public static String prependVertexCode = "";
    public static final ObjectMap<Application, Array<ShaderProgram>> shaders = new ObjectMap<>();
    public String[] attributeNames;
    public final ObjectIntMap<String> attributeSizes;
    public final ObjectIntMap<String> attributeTypes;
    public final ObjectIntMap<String> attributes;
    public int fragmentShaderHandle;
    public final String fragmentShaderSource;
    public boolean invalidated;
    public boolean isCompiled;
    public String log;
    public final FloatBuffer matrix;
    public IntBuffer params;
    public int program;
    public int refCount;
    public IntBuffer type;
    public String[] uniformNames;
    public final ObjectIntMap<String> uniformSizes;
    public final ObjectIntMap<String> uniformTypes;
    public final ObjectIntMap<String> uniforms;
    public int vertexShaderHandle;
    public final String vertexShaderSource;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0064, code lost:
        r4 = com.android.tools.r8.GeneratedOutlineSupport.outline62(new java.lang.StringBuilder(), prependFragmentCode, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004f, code lost:
        r3 = com.android.tools.r8.GeneratedOutlineSupport.outline62(new java.lang.StringBuilder(), prependVertexCode, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShaderProgram(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.String r0 = ""
            r2.log = r0
            com.badlogic.gdx.utils.ObjectIntMap r0 = new com.badlogic.gdx.utils.ObjectIntMap
            r0.<init>()
            r2.uniforms = r0
            com.badlogic.gdx.utils.ObjectIntMap r0 = new com.badlogic.gdx.utils.ObjectIntMap
            r0.<init>()
            r2.uniformTypes = r0
            com.badlogic.gdx.utils.ObjectIntMap r0 = new com.badlogic.gdx.utils.ObjectIntMap
            r0.<init>()
            r2.uniformSizes = r0
            com.badlogic.gdx.utils.ObjectIntMap r0 = new com.badlogic.gdx.utils.ObjectIntMap
            r0.<init>()
            r2.attributes = r0
            com.badlogic.gdx.utils.ObjectIntMap r0 = new com.badlogic.gdx.utils.ObjectIntMap
            r0.<init>()
            r2.attributeTypes = r0
            com.badlogic.gdx.utils.ObjectIntMap r0 = new com.badlogic.gdx.utils.ObjectIntMap
            r0.<init>()
            r2.attributeSizes = r0
            r0 = 0
            r2.refCount = r0
            r0 = 1
            java.nio.IntBuffer r1 = com.badlogic.gdx.utils.BufferUtils.newIntBuffer(r0)
            r2.params = r1
            java.nio.IntBuffer r0 = com.badlogic.gdx.utils.BufferUtils.newIntBuffer(r0)
            r2.type = r0
            if (r3 == 0) goto L_0x0098
            if (r4 == 0) goto L_0x0090
            java.lang.String r0 = prependVertexCode
            if (r0 == 0) goto L_0x005a
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x005a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = prependVertexCode
            java.lang.String r3 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r0, r1, r3)
        L_0x005a:
            java.lang.String r0 = prependFragmentCode
            if (r0 == 0) goto L_0x006f
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x006f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = prependFragmentCode
            java.lang.String r4 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r0, r1, r4)
        L_0x006f:
            r2.vertexShaderSource = r3
            r2.fragmentShaderSource = r4
            r0 = 16
            java.nio.FloatBuffer r0 = com.badlogic.gdx.utils.BufferUtils.newFloatBuffer(r0)
            r2.matrix = r0
            r2.compileShaders(r3, r4)
            boolean r3 = r2.isCompiled()
            if (r3 == 0) goto L_0x008f
            r2.fetchAttributes()
            r2.fetchUniforms()
            com.badlogic.gdx.Application r3 = co.hyperverge.hypersnapsdk.c.k.app
            r2.addManagedShader(r3, r2)
        L_0x008f:
            return
        L_0x0090:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "fragment shader must not be null"
            r3.<init>(r4)
            throw r3
        L_0x0098:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "vertex shader must not be null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.glutils.ShaderProgram.<init>(java.lang.String, java.lang.String):void");
    }

    private void addManagedShader(Application application, ShaderProgram shaderProgram) {
        Array array = (Array) shaders.get(application);
        if (array == null) {
            array = new Array();
        }
        array.add(shaderProgram);
        shaders.put(application, array);
    }

    private void checkManaged() {
        if (this.invalidated) {
            compileShaders(this.vertexShaderSource, this.fragmentShaderSource);
            this.invalidated = false;
        }
    }

    public static void clearAllShaderPrograms(Application application) {
        shaders.remove(application);
    }

    private void compileShaders(String str, String str2) {
        this.vertexShaderHandle = loadShader(GL20.GL_VERTEX_SHADER, str);
        int loadShader = loadShader(GL20.GL_FRAGMENT_SHADER, str2);
        this.fragmentShaderHandle = loadShader;
        if (this.vertexShaderHandle == -1 || loadShader == -1) {
            this.isCompiled = false;
            return;
        }
        int linkProgram = linkProgram(createProgram());
        this.program = linkProgram;
        if (linkProgram == -1) {
            this.isCompiled = false;
        } else {
            this.isCompiled = true;
        }
    }

    private int fetchAttributeLocation(String str) {
        int i;
        GL20 gl20 = k.gl20;
        ObjectIntMap<String> objectIntMap = this.attributes;
        int locateKey = objectIntMap.locateKey(str);
        if (locateKey < 0) {
            i = -2;
        } else {
            i = objectIntMap.valueTable[locateKey];
        }
        if (i != -2) {
            return i;
        }
        int glGetAttribLocation = gl20.glGetAttribLocation(this.program, str);
        this.attributes.put(str, glGetAttribLocation);
        return glGetAttribLocation;
    }

    private void fetchAttributes() {
        this.params.clear();
        k.gl20.glGetProgramiv(this.program, GL20.GL_ACTIVE_ATTRIBUTES, this.params);
        int i = this.params.get(0);
        this.attributeNames = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.params.clear();
            this.params.put(0, 1);
            this.type.clear();
            String glGetActiveAttrib = k.gl20.glGetActiveAttrib(this.program, i2, this.params, this.type);
            this.attributes.put(glGetActiveAttrib, k.gl20.glGetAttribLocation(this.program, glGetActiveAttrib));
            this.attributeTypes.put(glGetActiveAttrib, this.type.get(0));
            this.attributeSizes.put(glGetActiveAttrib, this.params.get(0));
            this.attributeNames[i2] = glGetActiveAttrib;
        }
    }

    private int fetchUniformLocation(String str) {
        return fetchUniformLocation(str, pedantic);
    }

    private void fetchUniforms() {
        this.params.clear();
        k.gl20.glGetProgramiv(this.program, GL20.GL_ACTIVE_UNIFORMS, this.params);
        int i = this.params.get(0);
        this.uniformNames = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.params.clear();
            this.params.put(0, 1);
            this.type.clear();
            String glGetActiveUniform = k.gl20.glGetActiveUniform(this.program, i2, this.params, this.type);
            this.uniforms.put(glGetActiveUniform, k.gl20.glGetUniformLocation(this.program, glGetActiveUniform));
            this.uniformTypes.put(glGetActiveUniform, this.type.get(0));
            this.uniformSizes.put(glGetActiveUniform, this.params.get(0));
            this.uniformNames[i2] = glGetActiveUniform;
        }
    }

    public static String getManagedStatus() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Managed shaders/app: { ");
        Keys keys = shaders.keys();
        if (keys != null) {
            while (keys.hasNext()) {
                outline73.append(((Array) shaders.get((Application) keys.next())).size);
                outline73.append(CMap.SPACE);
            }
            outline73.append("}");
            return outline73.toString();
        }
        throw null;
    }

    public static int getNumManagedShaderPrograms() {
        return ((Array) shaders.get(k.app)).size;
    }

    public static void invalidateAllShaderPrograms(Application application) {
        if (k.gl20 != null) {
            Array array = (Array) shaders.get(application);
            if (array != null) {
                for (int i = 0; i < array.size; i++) {
                    ((ShaderProgram) array.get(i)).invalidated = true;
                    ((ShaderProgram) array.get(i)).checkManaged();
                }
            }
        }
    }

    private int linkProgram(int i) {
        GL20 gl20 = k.gl20;
        if (i == -1) {
            return -1;
        }
        gl20.glAttachShader(i, this.vertexShaderHandle);
        gl20.glAttachShader(i, this.fragmentShaderHandle);
        gl20.glLinkProgram(i);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4);
        allocateDirect.order(ByteOrder.nativeOrder());
        IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
        gl20.glGetProgramiv(i, GL20.GL_LINK_STATUS, asIntBuffer);
        if (asIntBuffer.get(0) != 0) {
            return i;
        }
        this.log = k.gl20.glGetProgramInfoLog(i);
        return -1;
    }

    private int loadShader(int i, String str) {
        GL20 gl20 = k.gl20;
        IntBuffer newIntBuffer = BufferUtils.newIntBuffer(1);
        int glCreateShader = gl20.glCreateShader(i);
        if (glCreateShader == 0) {
            return -1;
        }
        gl20.glShaderSource(glCreateShader, str);
        gl20.glCompileShader(glCreateShader);
        gl20.glGetShaderiv(glCreateShader, GL20.GL_COMPILE_STATUS, newIntBuffer);
        if (newIntBuffer.get(0) != 0) {
            return glCreateShader;
        }
        String glGetShaderInfoLog = gl20.glGetShaderInfoLog(glCreateShader);
        StringBuilder sb = new StringBuilder();
        sb.append(this.log);
        sb.append(i == 35633 ? "Vertex shader\n" : "Fragment shader:\n");
        this.log = sb.toString();
        this.log = GeneratedOutlineSupport.outline62(new StringBuilder(), this.log, glGetShaderInfoLog);
        return -1;
    }

    @Deprecated
    public void begin() {
        bind();
    }

    public void bind() {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUseProgram(this.program);
    }

    public int createProgram() {
        int glCreateProgram = k.gl20.glCreateProgram();
        if (glCreateProgram != 0) {
            return glCreateProgram;
        }
        return -1;
    }

    public void disableVertexAttribute(String str) {
        GL20 gl20 = k.gl20;
        checkManaged();
        int fetchAttributeLocation = fetchAttributeLocation(str);
        if (fetchAttributeLocation != -1) {
            gl20.glDisableVertexAttribArray(fetchAttributeLocation);
        }
    }

    public void dispose() {
        GL20 gl20 = k.gl20;
        gl20.glUseProgram(0);
        gl20.glDeleteShader(this.vertexShaderHandle);
        gl20.glDeleteShader(this.fragmentShaderHandle);
        gl20.glDeleteProgram(this.program);
        if (shaders.get(k.app) != null) {
            ((Array) shaders.get(k.app)).removeValue(this, true);
        }
    }

    public void enableVertexAttribute(String str) {
        GL20 gl20 = k.gl20;
        checkManaged();
        int fetchAttributeLocation = fetchAttributeLocation(str);
        if (fetchAttributeLocation != -1) {
            gl20.glEnableVertexAttribArray(fetchAttributeLocation);
        }
    }

    @Deprecated
    public void end() {
    }

    public int getAttributeLocation(String str) {
        ObjectIntMap<String> objectIntMap = this.attributes;
        int locateKey = objectIntMap.locateKey(str);
        if (locateKey < 0) {
            return -1;
        }
        return objectIntMap.valueTable[locateKey];
    }

    public int getAttributeSize(String str) {
        ObjectIntMap<String> objectIntMap = this.attributeSizes;
        int locateKey = objectIntMap.locateKey(str);
        if (locateKey < 0) {
            return 0;
        }
        return objectIntMap.valueTable[locateKey];
    }

    public int getAttributeType(String str) {
        ObjectIntMap<String> objectIntMap = this.attributeTypes;
        int locateKey = objectIntMap.locateKey(str);
        if (locateKey < 0) {
            return 0;
        }
        return objectIntMap.valueTable[locateKey];
    }

    public String[] getAttributes() {
        return this.attributeNames;
    }

    public String getFragmentShaderSource() {
        return this.fragmentShaderSource;
    }

    public int getHandle() {
        return this.program;
    }

    public String getLog() {
        if (!this.isCompiled) {
            return this.log;
        }
        String glGetProgramInfoLog = k.gl20.glGetProgramInfoLog(this.program);
        this.log = glGetProgramInfoLog;
        return glGetProgramInfoLog;
    }

    public int getUniformLocation(String str) {
        ObjectIntMap<String> objectIntMap = this.uniforms;
        int locateKey = objectIntMap.locateKey(str);
        if (locateKey < 0) {
            return -1;
        }
        return objectIntMap.valueTable[locateKey];
    }

    public int getUniformSize(String str) {
        ObjectIntMap<String> objectIntMap = this.uniformSizes;
        int locateKey = objectIntMap.locateKey(str);
        if (locateKey < 0) {
            return 0;
        }
        return objectIntMap.valueTable[locateKey];
    }

    public int getUniformType(String str) {
        ObjectIntMap<String> objectIntMap = this.uniformTypes;
        int locateKey = objectIntMap.locateKey(str);
        if (locateKey < 0) {
            return 0;
        }
        return objectIntMap.valueTable[locateKey];
    }

    public String[] getUniforms() {
        return this.uniformNames;
    }

    public String getVertexShaderSource() {
        return this.vertexShaderSource;
    }

    public boolean hasAttribute(String str) {
        return this.attributes.locateKey(str) >= 0;
    }

    public boolean hasUniform(String str) {
        return this.uniforms.locateKey(str) >= 0;
    }

    public boolean isCompiled() {
        return this.isCompiled;
    }

    public void setAttributef(String str, float f2, float f3, float f4, float f5) {
        k.gl20.glVertexAttrib4f(fetchAttributeLocation(str), f2, f3, f4, f5);
    }

    public void setUniform1fv(String str, float[] fArr, int i, int i2) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform1fv(fetchUniformLocation(str), i2, fArr, i);
    }

    public void setUniform2fv(String str, float[] fArr, int i, int i2) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform2fv(fetchUniformLocation(str), i2 / 2, fArr, i);
    }

    public void setUniform3fv(String str, float[] fArr, int i, int i2) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform3fv(fetchUniformLocation(str), i2 / 3, fArr, i);
    }

    public void setUniform4fv(String str, float[] fArr, int i, int i2) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform4fv(fetchUniformLocation(str), i2 / 4, fArr, i);
    }

    public void setUniformMatrix(String str, Matrix4 matrix4) {
        setUniformMatrix(str, matrix4, false);
    }

    public void setUniformMatrix3fv(String str, FloatBuffer floatBuffer, int i, boolean z) {
        GL20 gl20 = k.gl20;
        checkManaged();
        floatBuffer.position(0);
        gl20.glUniformMatrix3fv(fetchUniformLocation(str), i, z, floatBuffer);
    }

    public void setUniformMatrix4fv(String str, FloatBuffer floatBuffer, int i, boolean z) {
        GL20 gl20 = k.gl20;
        checkManaged();
        floatBuffer.position(0);
        gl20.glUniformMatrix4fv(fetchUniformLocation(str), i, z, floatBuffer);
    }

    public void setUniformf(String str, float f2) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform1f(fetchUniformLocation(str), f2);
    }

    public void setUniformi(String str, int i) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform1i(fetchUniformLocation(str), i);
    }

    public void setVertexAttribute(String str, int i, int i2, boolean z, int i3, Buffer buffer) {
        GL20 gl20 = k.gl20;
        checkManaged();
        int fetchAttributeLocation = fetchAttributeLocation(str);
        if (fetchAttributeLocation != -1) {
            gl20.glVertexAttribPointer(fetchAttributeLocation, i, i2, z, i3, buffer);
        }
    }

    public int fetchUniformLocation(String str, boolean z) {
        int i;
        ObjectIntMap<String> objectIntMap = this.uniforms;
        int locateKey = objectIntMap.locateKey(str);
        if (locateKey < 0) {
            i = -2;
        } else {
            i = objectIntMap.valueTable[locateKey];
        }
        if (i == -2) {
            i = k.gl20.glGetUniformLocation(this.program, str);
            if (i != -1 || !z) {
                this.uniforms.put(str, i);
            } else if (this.isCompiled) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("No uniform with name '", str, "' in shader"));
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("An attempted fetch uniform from uncompiled shader \n");
                outline73.append(getLog());
                throw new IllegalStateException(outline73.toString());
            }
        }
        return i;
    }

    public void setUniformMatrix(String str, Matrix4 matrix4, boolean z) {
        setUniformMatrix(fetchUniformLocation(str), matrix4, z);
    }

    public void setUniformMatrix(int i, Matrix4 matrix4) {
        setUniformMatrix(i, matrix4, false);
    }

    public void setUniformMatrix(int i, Matrix4 matrix4, boolean z) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniformMatrix4fv(i, 1, z, matrix4.val, 0);
    }

    public void disableVertexAttribute(int i) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glDisableVertexAttribArray(i);
    }

    public void enableVertexAttribute(int i) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glEnableVertexAttribArray(i);
    }

    public void setUniform1fv(int i, float[] fArr, int i2, int i3) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform1fv(i, i3, fArr, i2);
    }

    public void setUniform2fv(int i, float[] fArr, int i2, int i3) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform2fv(i, i3 / 2, fArr, i2);
    }

    public void setUniform3fv(int i, float[] fArr, int i2, int i3) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform3fv(i, i3 / 3, fArr, i2);
    }

    public void setUniform4fv(int i, float[] fArr, int i2, int i3) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform4fv(i, i3 / 4, fArr, i2);
    }

    public void setUniformf(int i, float f2) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform1f(i, f2);
    }

    public void setUniformi(int i, int i2) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform1i(i, i2);
    }

    public void setVertexAttribute(int i, int i2, int i3, boolean z, int i4, Buffer buffer) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glVertexAttribPointer(i, i2, i3, z, i4, buffer);
    }

    public void setUniformMatrix4fv(int i, float[] fArr, int i2, int i3) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniformMatrix4fv(i, i3 / 16, false, fArr, i2);
    }

    public void setUniformMatrix(String str, Matrix3 matrix3) {
        setUniformMatrix(str, matrix3, false);
    }

    public void setUniformMatrix(String str, Matrix3 matrix3, boolean z) {
        setUniformMatrix(fetchUniformLocation(str), matrix3, z);
    }

    public void setUniformf(String str, float f2, float f3) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform2f(fetchUniformLocation(str), f2, f3);
    }

    public void setUniformi(String str, int i, int i2) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform2i(fetchUniformLocation(str), i, i2);
    }

    public void setVertexAttribute(String str, int i, int i2, boolean z, int i3, int i4) {
        GL20 gl20 = k.gl20;
        checkManaged();
        int fetchAttributeLocation = fetchAttributeLocation(str);
        if (fetchAttributeLocation != -1) {
            gl20.glVertexAttribPointer(fetchAttributeLocation, i, i2, z, i3, i4);
        }
    }

    public void setUniformMatrix(int i, Matrix3 matrix3) {
        setUniformMatrix(i, matrix3, false);
    }

    public void setUniformMatrix4fv(String str, float[] fArr, int i, int i2) {
        setUniformMatrix4fv(fetchUniformLocation(str), fArr, i, i2);
    }

    public void setUniformMatrix(int i, Matrix3 matrix3, boolean z) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniformMatrix3fv(i, 1, z, matrix3.val, 0);
    }

    public void setUniformf(int i, float f2, float f3) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform2f(i, f2, f3);
    }

    public void setUniformi(int i, int i2, int i3) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform2i(i, i2, i3);
    }

    public void setVertexAttribute(int i, int i2, int i3, boolean z, int i4, int i5) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glVertexAttribPointer(i, i2, i3, z, i4, i5);
    }

    public void setUniformf(String str, float f2, float f3, float f4) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform3f(fetchUniformLocation(str), f2, f3, f4);
    }

    public void setUniformi(String str, int i, int i2, int i3) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform3i(fetchUniformLocation(str), i, i2, i3);
    }

    public void setUniformf(int i, float f2, float f3, float f4) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform3f(i, f2, f3, f4);
    }

    public void setUniformi(int i, int i2, int i3, int i4) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform3i(i, i2, i3, i4);
    }

    public void setUniformf(String str, float f2, float f3, float f4, float f5) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform4f(fetchUniformLocation(str), f2, f3, f4, f5);
    }

    public void setUniformi(String str, int i, int i2, int i3, int i4) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform4i(fetchUniformLocation(str), i, i2, i3, i4);
    }

    public ShaderProgram(FileHandle fileHandle, FileHandle fileHandle2) {
        this(fileHandle.readString(), fileHandle2.readString());
    }

    public void setUniformf(int i, float f2, float f3, float f4, float f5) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform4f(i, f2, f3, f4, f5);
    }

    public void setUniformi(int i, int i2, int i3, int i4, int i5) {
        GL20 gl20 = k.gl20;
        checkManaged();
        gl20.glUniform4i(i, i2, i3, i4, i5);
    }

    public void setUniformf(String str, Vector2 vector2) {
        setUniformf(str, vector2.x, vector2.y);
    }

    public void setUniformf(int i, Vector2 vector2) {
        setUniformf(i, vector2.x, vector2.y);
    }

    public void setUniformf(String str, Vector3 vector3) {
        setUniformf(str, vector3.x, vector3.y, vector3.z);
    }

    public void setUniformf(int i, Vector3 vector3) {
        setUniformf(i, vector3.x, vector3.y, vector3.z);
    }

    public void setUniformf(String str, Color color) {
        setUniformf(str, color.r, color.g, color.f3307b, color.f3306a);
    }

    public void setUniformf(int i, Color color) {
        setUniformf(i, color.r, color.g, color.f3307b, color.f3306a);
    }
}
