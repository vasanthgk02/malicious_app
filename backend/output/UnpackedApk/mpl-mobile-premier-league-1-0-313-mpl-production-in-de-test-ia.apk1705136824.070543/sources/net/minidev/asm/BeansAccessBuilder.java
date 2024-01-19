package net.minidev.asm;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public class BeansAccessBuilder {
    public static String METHOD_ACCESS_NAME = BeansAccess.class.getName().replace('.', '/');
    public final String accessClassName;
    public final String accessClassNameInternal;
    public final Accessor[] accs;
    public final String className;
    public final String classNameInternal;
    public final HashMap<Class<?>, Method> convMtds = new HashMap<>();
    public Class<? extends Exception> exeptionClass = NoSuchFieldException.class;
    public final DynamicClassLoader loader;

    public BeansAccessBuilder(Class<?> cls, Accessor[] accessorArr, DynamicClassLoader dynamicClassLoader) {
        this.accs = accessorArr;
        this.loader = dynamicClassLoader;
        String name = cls.getName();
        this.className = name;
        if (name.startsWith("java.")) {
            this.accessClassName = GeneratedOutlineSupport.outline62(new StringBuilder("net.minidev.asm."), this.className, "AccAccess");
        } else {
            this.accessClassName = this.className.concat("AccAccess");
        }
        this.accessClassNameInternal = this.accessClassName.replace('.', '/');
        this.classNameInternal = this.className.replace('.', '/');
    }

    public final void ifNotEqJmp(MethodVisitor methodVisitor, int i, int i2, Label label) {
        methodVisitor.visitVarInsn(21, i);
        if (i2 == 0) {
            methodVisitor.visitJumpInsn(154, label);
        } else if (i2 == 1) {
            methodVisitor.visitInsn(4);
            methodVisitor.visitJumpInsn(160, label);
        } else if (i2 == 2) {
            methodVisitor.visitInsn(5);
            methodVisitor.visitJumpInsn(160, label);
        } else if (i2 == 3) {
            methodVisitor.visitInsn(6);
            methodVisitor.visitJumpInsn(160, label);
        } else if (i2 == 4) {
            methodVisitor.visitInsn(7);
            methodVisitor.visitJumpInsn(160, label);
        } else if (i2 == 5) {
            methodVisitor.visitInsn(8);
            methodVisitor.visitJumpInsn(160, label);
        } else if (i2 >= 6) {
            methodVisitor.visitIntInsn(16, i2);
            methodVisitor.visitJumpInsn(160, label);
        } else {
            throw new RuntimeException("non supported negative values");
        }
    }

    public final void internalSetFiled(MethodVisitor methodVisitor, Accessor accessor) {
        MethodVisitor methodVisitor2 = methodVisitor;
        Accessor accessor2 = accessor;
        methodVisitor2.visitVarInsn(25, 1);
        methodVisitor2.visitTypeInsn(192, this.classNameInternal);
        methodVisitor2.visitVarInsn(25, 3);
        Type type = Type.getType(accessor2.type);
        Class<?> cls = accessor2.type;
        String internalName = Type.getInternalName(cls);
        Method method = this.convMtds.get(cls);
        if (method != null) {
            methodVisitor2.visitMethodInsn(184, Type.getInternalName(method.getDeclaringClass()), method.getName(), Type.getMethodDescriptor(method));
        } else if (accessor2.type.isEnum()) {
            Label label = new Label();
            methodVisitor2.visitJumpInsn(198, label);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitMethodInsn(182, "java/lang/Object", "toString", "()Ljava/lang/String;");
            methodVisitor2.visitMethodInsn(184, internalName, "valueOf", GeneratedOutlineSupport.outline51("(Ljava/lang/String;)L", internalName, ";"));
            methodVisitor2.visitVarInsn(58, 3);
            methodVisitor2.visitLabel(label);
            methodVisitor.visitFrame(3, 0, null, 0, null);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitTypeInsn(192, this.classNameInternal);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitTypeInsn(192, internalName);
        } else if (cls.equals(String.class)) {
            Label label2 = new Label();
            methodVisitor2.visitJumpInsn(198, label2);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitMethodInsn(182, "java/lang/Object", "toString", "()Ljava/lang/String;");
            methodVisitor2.visitVarInsn(58, 3);
            methodVisitor2.visitLabel(label2);
            methodVisitor.visitFrame(3, 0, null, 0, null);
            methodVisitor2.visitVarInsn(25, 1);
            methodVisitor2.visitTypeInsn(192, this.classNameInternal);
            methodVisitor2.visitVarInsn(25, 3);
            methodVisitor2.visitTypeInsn(192, internalName);
        } else {
            methodVisitor2.visitTypeInsn(192, internalName);
        }
        if (accessor.isPublic()) {
            methodVisitor2.visitFieldInsn(181, this.classNameInternal, accessor2.fieldName, type.getDescriptor());
        } else {
            methodVisitor2.visitMethodInsn(182, this.classNameInternal, accessor2.setter.getName(), Type.getMethodDescriptor(accessor2.setter));
        }
        methodVisitor2.visitInsn(177);
    }

    public final void throwExIntParam(MethodVisitor methodVisitor, Class<?> cls) {
        String replace = cls.getName().replace('.', '/');
        methodVisitor.visitTypeInsn(187, replace);
        methodVisitor.visitInsn(89);
        methodVisitor.visitLdcInsn("mapping " + this.className + " failed to map field:");
        methodVisitor.visitVarInsn(21, 2);
        methodVisitor.visitMethodInsn(184, "java/lang/Integer", "toString", "(I)Ljava/lang/String;");
        methodVisitor.visitMethodInsn(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        methodVisitor.visitMethodInsn(183, replace, "<init>", "(Ljava/lang/String;)V");
        methodVisitor.visitInsn(191);
    }

    public final void throwExStrParam(MethodVisitor methodVisitor, Class<?> cls) {
        String replace = cls.getName().replace('.', '/');
        methodVisitor.visitTypeInsn(187, replace);
        methodVisitor.visitInsn(89);
        methodVisitor.visitLdcInsn("mapping " + this.className + " failed to map field:");
        methodVisitor.visitVarInsn(25, 2);
        methodVisitor.visitMethodInsn(182, "java/lang/String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        methodVisitor.visitMethodInsn(183, replace, "<init>", "(Ljava/lang/String;)V");
        methodVisitor.visitInsn(191);
    }
}
