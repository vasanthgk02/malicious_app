package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;

public class MemberComparator$NameAndTypeMemberComparator implements Comparator<DeclarationDescriptor> {
    public static final MemberComparator$NameAndTypeMemberComparator INSTANCE = new MemberComparator$NameAndTypeMemberComparator();

    public static int getDeclarationPriority(DeclarationDescriptor declarationDescriptor) {
        if (DescriptorUtils.isEnumEntry(declarationDescriptor)) {
            return 8;
        }
        if (declarationDescriptor instanceof ConstructorDescriptor) {
            return 7;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            return ((PropertyDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 6 : 5;
        }
        if (declarationDescriptor instanceof FunctionDescriptor) {
            return ((FunctionDescriptor) declarationDescriptor).getExtensionReceiverParameter() == null ? 4 : 3;
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            return 2;
        }
        return declarationDescriptor instanceof TypeAliasDescriptor ? 1 : 0;
    }

    public int compare(Object obj, Object obj2) {
        Integer num;
        DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
        DeclarationDescriptor declarationDescriptor2 = (DeclarationDescriptor) obj2;
        int declarationPriority = getDeclarationPriority(declarationDescriptor2) - getDeclarationPriority(declarationDescriptor);
        if (declarationPriority != 0) {
            num = Integer.valueOf(declarationPriority);
        } else if (!DescriptorUtils.isEnumEntry(declarationDescriptor) || !DescriptorUtils.isEnumEntry(declarationDescriptor2)) {
            int compareTo = declarationDescriptor.getName().name.compareTo(declarationDescriptor2.getName().name);
            num = compareTo != 0 ? Integer.valueOf(compareTo) : null;
        } else {
            num = Integer.valueOf(0);
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
