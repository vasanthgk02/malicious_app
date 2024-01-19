package kotlin.reflect.jvm.internal.impl.util;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.Checks.AnonymousClass3;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.Member;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck.MemberOrExtension;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsInt;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.AtLeast;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.Equals;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.NoValueParameters;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck.SingleValueParameter;
import kotlin.text.Regex;

/* compiled from: modifierChecks.kt */
public final class OperatorChecks extends AbstractModifierChecks {
    public static final OperatorChecks INSTANCE = new OperatorChecks();
    public static final List<Checks> checks;

    static {
        Name name = OperatorNameConventions.GET;
        Check[] checkArr = {MemberOrExtension.INSTANCE, new AtLeast(1)};
        Name name2 = OperatorNameConventions.SET;
        Check[] checkArr2 = {MemberOrExtension.INSTANCE, new AtLeast(2)};
        Name name3 = OperatorNameConventions.GET_VALUE;
        Check[] checkArr3 = {MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new AtLeast(2), IsKPropertyCheck.INSTANCE};
        Name name4 = OperatorNameConventions.SET_VALUE;
        Check[] checkArr4 = {MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new AtLeast(3), IsKPropertyCheck.INSTANCE};
        Name name5 = OperatorNameConventions.PROVIDE_DELEGATE;
        Check[] checkArr5 = {MemberOrExtension.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, new Equals(2), IsKPropertyCheck.INSTANCE};
        Name name6 = OperatorNameConventions.INVOKE;
        Check[] checkArr6 = {MemberOrExtension.INSTANCE};
        Name name7 = OperatorNameConventions.CONTAINS;
        Check[] checkArr7 = {MemberOrExtension.INSTANCE, SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE, ReturnsBoolean.INSTANCE};
        Name name8 = OperatorNameConventions.ITERATOR;
        Check[] checkArr8 = {MemberOrExtension.INSTANCE, NoValueParameters.INSTANCE};
        Name name9 = OperatorNameConventions.NEXT;
        Check[] checkArr9 = {MemberOrExtension.INSTANCE, NoValueParameters.INSTANCE};
        Name name10 = OperatorNameConventions.HAS_NEXT;
        Check[] checkArr10 = {MemberOrExtension.INSTANCE, NoValueParameters.INSTANCE, ReturnsBoolean.INSTANCE};
        Name name11 = OperatorNameConventions.RANGE_TO;
        Check[] checkArr11 = {MemberOrExtension.INSTANCE, SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE};
        Name name12 = OperatorNameConventions.EQUALS;
        Check[] checkArr12 = {Member.INSTANCE};
        Name name13 = OperatorNameConventions.COMPARE_TO;
        Check[] checkArr13 = {MemberOrExtension.INSTANCE, ReturnsInt.INSTANCE, SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE};
        Set<Name> set = OperatorNameConventions.BINARY_OPERATION_NAMES;
        Check[] checkArr14 = {MemberOrExtension.INSTANCE, SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE};
        Set<Name> set2 = OperatorNameConventions.SIMPLE_UNARY_OPERATION_NAMES;
        Check[] checkArr15 = {MemberOrExtension.INSTANCE, NoValueParameters.INSTANCE};
        List listOf = TweetUtils.listOf((T[]) new Name[]{OperatorNameConventions.INC, OperatorNameConventions.DEC});
        Check[] checkArr16 = {MemberOrExtension.INSTANCE};
        Set<Name> set3 = OperatorNameConventions.ASSIGNMENT_OPERATIONS;
        Check[] checkArr17 = {MemberOrExtension.INSTANCE, ReturnsUnit.INSTANCE, SingleValueParameter.INSTANCE, NoDefaultAndVarargsCheck.INSTANCE};
        Regex regex = OperatorNameConventions.COMPONENT_REGEX;
        Check[] checkArr18 = {MemberOrExtension.INSTANCE, NoValueParameters.INSTANCE};
        AnonymousClass3 r12 = AnonymousClass3.INSTANCE;
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(checkArr18, "checks");
        Intrinsics.checkNotNullParameter(r12, "additionalChecks");
        Check[] checkArr19 = new Check[2];
        System.arraycopy(checkArr18, 0, checkArr19, 0, 2);
        Checks checks2 = new Checks(null, regex, null, r12, checkArr19);
        checks = TweetUtils.listOf((T[]) new Checks[]{new Checks(name, checkArr, (Function1) null, 4), new Checks(name2, checkArr2, (Function1<? super FunctionDescriptor, String>) OperatorChecks$checks$1.INSTANCE), new Checks(name3, checkArr3, (Function1) null, 4), new Checks(name4, checkArr4, (Function1) null, 4), new Checks(name5, checkArr5, (Function1) null, 4), new Checks(name6, checkArr6, (Function1) null, 4), new Checks(name7, checkArr7, (Function1) null, 4), new Checks(name8, checkArr8, (Function1) null, 4), new Checks(name9, checkArr9, (Function1) null, 4), new Checks(name10, checkArr10, (Function1) null, 4), new Checks(name11, checkArr11, (Function1) null, 4), new Checks(name12, checkArr12, (Function1<? super FunctionDescriptor, String>) OperatorChecks$checks$2.INSTANCE), new Checks(name13, checkArr13, (Function1) null, 4), new Checks((Collection) set, checkArr14, (Function1) null, 4), new Checks((Collection) set2, checkArr15, (Function1) null, 4), new Checks((Collection<Name>) listOf, checkArr16, (Function1<? super FunctionDescriptor, String>) OperatorChecks$checks$3.INSTANCE), new Checks((Collection) set3, checkArr17, (Function1) null, 4), checks2});
    }
}
