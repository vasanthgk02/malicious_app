package net.sf.json.regexp;

import com.badlogic.gdx.graphics.GL30;
import org.apache.commons.lang.exception.NestableRuntimeException;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

public class Perl5RegexpMatcher implements RegexpMatcher {
    public static final Perl5Compiler compiler = new Perl5Compiler();
    public Pattern pattern;

    public Perl5RegexpMatcher(String str, boolean z) {
        if (z) {
            try {
                this.pattern = compiler.compile(str, GL30.GL_MAX);
            } catch (MalformedPatternException e2) {
                throw new NestableRuntimeException((Throwable) e2);
            }
        } else {
            this.pattern = compiler.compile(str, 32768);
        }
    }

    public String getGroupIfMatches(String str, int i) {
        Perl5Matcher perl5Matcher = new Perl5Matcher();
        return perl5Matcher.matches(str, this.pattern) ? perl5Matcher.getMatch().group(1) : "";
    }

    public boolean matches(String str) {
        return new Perl5Matcher().matches(str, this.pattern);
    }
}
