package kotlin.text;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: StringNumberConversionsJVM.kt */
public final class ScreenFloatValueRegEx {
    public static final Regex value;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append("(\\p{Digit}+)");
        sb.append("(\\.)?(");
        sb.append("(\\p{Digit}+)");
        sb.append("?)(");
        GeneratedOutlineSupport.outline103(sb, "[eE][+-]?(\\p{Digit}+)", ")?)|(\\.(", "(\\p{Digit}+)", ")(");
        GeneratedOutlineSupport.outline103(sb, "[eE][+-]?(\\p{Digit}+)", ")?)|((", "(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))", ")[pP][+-]?");
        value = new Regex(GeneratedOutlineSupport.outline52("[\\x00-\\x20]*[+-]?(NaN|Infinity|((", GeneratedOutlineSupport.outline59(sb, "(\\p{Digit}+)", ')'), ")[fFdD]?))[\\x00-\\x20]*"));
    }
}
