package kotlin.reflect.jvm.internal.impl.util;

import com.mpl.androidapp.utils.Constant;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;

/* compiled from: OperatorNameConventions.kt */
public final class OperatorNameConventions {
    public static final Set<Name> ASSIGNMENT_OPERATIONS = TweetUtils.setOf((T[]) new Name[]{TIMES_ASSIGN, DIV_ASSIGN, MOD_ASSIGN, REM_ASSIGN, PLUS_ASSIGN, MINUS_ASSIGN});
    public static final Set<Name> BINARY_OPERATION_NAMES = TweetUtils.setOf((T[]) new Name[]{TIMES, PLUS, MINUS, DIV, MOD, REM, RANGE_TO});
    public static final Name COMPARE_TO;
    public static final Regex COMPONENT_REGEX = new Regex((String) "component\\d+");
    public static final Name CONTAINS;
    public static final Name DEC;
    public static final Name DIV;
    public static final Name DIV_ASSIGN;
    public static final Name EQUALS;
    public static final Name GET;
    public static final Name GET_VALUE;
    public static final Name HAS_NEXT;
    public static final Name INC;
    public static final Name INVOKE;
    public static final Name ITERATOR;
    public static final Name MINUS;
    public static final Name MINUS_ASSIGN;
    public static final Name MOD;
    public static final Name MOD_ASSIGN;
    public static final Name NEXT;
    public static final Name NOT;
    public static final Name PLUS;
    public static final Name PLUS_ASSIGN;
    public static final Name PROVIDE_DELEGATE;
    public static final Name RANGE_TO;
    public static final Name REM;
    public static final Name REM_ASSIGN;
    public static final Name SET;
    public static final Name SET_VALUE;
    public static final Set<Name> SIMPLE_UNARY_OPERATION_NAMES = TweetUtils.setOf((T[]) new Name[]{UNARY_PLUS, UNARY_MINUS, NOT});
    public static final Name TIMES;
    public static final Name TIMES_ASSIGN;
    public static final Name UNARY_MINUS;
    public static final Name UNARY_PLUS;

    static {
        Name identifier = Name.identifier("getValue");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"getValue\")");
        GET_VALUE = identifier;
        Name identifier2 = Name.identifier("setValue");
        Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(\"setValue\")");
        SET_VALUE = identifier2;
        Name identifier3 = Name.identifier("provideDelegate");
        Intrinsics.checkNotNullExpressionValue(identifier3, "identifier(\"provideDelegate\")");
        PROVIDE_DELEGATE = identifier3;
        Name identifier4 = Name.identifier("equals");
        Intrinsics.checkNotNullExpressionValue(identifier4, "identifier(\"equals\")");
        EQUALS = identifier4;
        Name identifier5 = Name.identifier("compareTo");
        Intrinsics.checkNotNullExpressionValue(identifier5, "identifier(\"compareTo\")");
        COMPARE_TO = identifier5;
        Name identifier6 = Name.identifier("contains");
        Intrinsics.checkNotNullExpressionValue(identifier6, "identifier(\"contains\")");
        CONTAINS = identifier6;
        Name identifier7 = Name.identifier("invoke");
        Intrinsics.checkNotNullExpressionValue(identifier7, "identifier(\"invoke\")");
        INVOKE = identifier7;
        Name identifier8 = Name.identifier("iterator");
        Intrinsics.checkNotNullExpressionValue(identifier8, "identifier(\"iterator\")");
        ITERATOR = identifier8;
        Name identifier9 = Name.identifier(Constant.GET);
        Intrinsics.checkNotNullExpressionValue(identifier9, "identifier(\"get\")");
        GET = identifier9;
        Name identifier10 = Name.identifier("set");
        Intrinsics.checkNotNullExpressionValue(identifier10, "identifier(\"set\")");
        SET = identifier10;
        Name identifier11 = Name.identifier("next");
        Intrinsics.checkNotNullExpressionValue(identifier11, "identifier(\"next\")");
        NEXT = identifier11;
        Name identifier12 = Name.identifier("hasNext");
        Intrinsics.checkNotNullExpressionValue(identifier12, "identifier(\"hasNext\")");
        HAS_NEXT = identifier12;
        Intrinsics.checkNotNullExpressionValue(Name.identifier("toString"), "identifier(\"toString\")");
        Intrinsics.checkNotNullExpressionValue(Name.identifier("and"), "identifier(\"and\")");
        Intrinsics.checkNotNullExpressionValue(Name.identifier("or"), "identifier(\"or\")");
        Name identifier13 = Name.identifier("inc");
        Intrinsics.checkNotNullExpressionValue(identifier13, "identifier(\"inc\")");
        INC = identifier13;
        Name identifier14 = Name.identifier("dec");
        Intrinsics.checkNotNullExpressionValue(identifier14, "identifier(\"dec\")");
        DEC = identifier14;
        Name identifier15 = Name.identifier("plus");
        Intrinsics.checkNotNullExpressionValue(identifier15, "identifier(\"plus\")");
        PLUS = identifier15;
        Name identifier16 = Name.identifier("minus");
        Intrinsics.checkNotNullExpressionValue(identifier16, "identifier(\"minus\")");
        MINUS = identifier16;
        Name identifier17 = Name.identifier(HSLCriteriaBuilder.NOT);
        Intrinsics.checkNotNullExpressionValue(identifier17, "identifier(\"not\")");
        NOT = identifier17;
        Name identifier18 = Name.identifier("unaryMinus");
        Intrinsics.checkNotNullExpressionValue(identifier18, "identifier(\"unaryMinus\")");
        UNARY_MINUS = identifier18;
        Name identifier19 = Name.identifier("unaryPlus");
        Intrinsics.checkNotNullExpressionValue(identifier19, "identifier(\"unaryPlus\")");
        UNARY_PLUS = identifier19;
        Name identifier20 = Name.identifier("times");
        Intrinsics.checkNotNullExpressionValue(identifier20, "identifier(\"times\")");
        TIMES = identifier20;
        Name identifier21 = Name.identifier("div");
        Intrinsics.checkNotNullExpressionValue(identifier21, "identifier(\"div\")");
        DIV = identifier21;
        Name identifier22 = Name.identifier("mod");
        Intrinsics.checkNotNullExpressionValue(identifier22, "identifier(\"mod\")");
        MOD = identifier22;
        Name identifier23 = Name.identifier("rem");
        Intrinsics.checkNotNullExpressionValue(identifier23, "identifier(\"rem\")");
        REM = identifier23;
        Name identifier24 = Name.identifier("rangeTo");
        Intrinsics.checkNotNullExpressionValue(identifier24, "identifier(\"rangeTo\")");
        RANGE_TO = identifier24;
        Name identifier25 = Name.identifier("timesAssign");
        Intrinsics.checkNotNullExpressionValue(identifier25, "identifier(\"timesAssign\")");
        TIMES_ASSIGN = identifier25;
        Name identifier26 = Name.identifier("divAssign");
        Intrinsics.checkNotNullExpressionValue(identifier26, "identifier(\"divAssign\")");
        DIV_ASSIGN = identifier26;
        Name identifier27 = Name.identifier("modAssign");
        Intrinsics.checkNotNullExpressionValue(identifier27, "identifier(\"modAssign\")");
        MOD_ASSIGN = identifier27;
        Name identifier28 = Name.identifier("remAssign");
        Intrinsics.checkNotNullExpressionValue(identifier28, "identifier(\"remAssign\")");
        REM_ASSIGN = identifier28;
        Name identifier29 = Name.identifier("plusAssign");
        Intrinsics.checkNotNullExpressionValue(identifier29, "identifier(\"plusAssign\")");
        PLUS_ASSIGN = identifier29;
        Name identifier30 = Name.identifier("minusAssign");
        Intrinsics.checkNotNullExpressionValue(identifier30, "identifier(\"minusAssign\")");
        MINUS_ASSIGN = identifier30;
        TweetUtils.setOf((T[]) new Name[]{INC, DEC, UNARY_PLUS, UNARY_MINUS, NOT});
        TweetUtils.setOf((T[]) new Name[]{GET_VALUE, SET_VALUE, PROVIDE_DELEGATE});
    }
}