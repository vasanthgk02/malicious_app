package org.jboss.netty.util;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.IdentityHashMap;
import java.util.Map;
import org.apache.commons.lang.CharEncoding;

public class CharsetUtil {
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset US_ASCII = Charset.forName("US-ASCII");
    public static final Charset UTF_16 = Charset.forName("UTF-16");
    public static final Charset UTF_16BE = Charset.forName(CharEncoding.UTF_16BE);
    public static final Charset UTF_16LE = Charset.forName(CharEncoding.UTF_16LE);
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final ThreadLocal<Map<Charset, CharsetDecoder>> decoders = new ThreadLocal<Map<Charset, CharsetDecoder>>() {
        public Map<Charset, CharsetDecoder> initialValue() {
            return new IdentityHashMap();
        }
    };
    public static final ThreadLocal<Map<Charset, CharsetEncoder>> encoders = new ThreadLocal<Map<Charset, CharsetEncoder>>() {
        public Map<Charset, CharsetEncoder> initialValue() {
            return new IdentityHashMap();
        }
    };

    public static CharsetDecoder getDecoder(Charset charset) {
        if (charset != null) {
            Map map = decoders.get();
            CharsetDecoder charsetDecoder = (CharsetDecoder) map.get(charset);
            if (charsetDecoder != null) {
                charsetDecoder.reset();
                charsetDecoder.onMalformedInput(CodingErrorAction.REPLACE);
                charsetDecoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
                return charsetDecoder;
            }
            CharsetDecoder newDecoder = charset.newDecoder();
            newDecoder.onMalformedInput(CodingErrorAction.REPLACE);
            newDecoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
            map.put(charset, newDecoder);
            return newDecoder;
        }
        throw new NullPointerException("charset");
    }

    public static CharsetEncoder getEncoder(Charset charset) {
        if (charset != null) {
            Map map = encoders.get();
            CharsetEncoder charsetEncoder = (CharsetEncoder) map.get(charset);
            if (charsetEncoder != null) {
                charsetEncoder.reset();
                charsetEncoder.onMalformedInput(CodingErrorAction.REPLACE);
                charsetEncoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
                return charsetEncoder;
            }
            CharsetEncoder newEncoder = charset.newEncoder();
            newEncoder.onMalformedInput(CodingErrorAction.REPLACE);
            newEncoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
            map.put(charset, newEncoder);
            return newEncoder;
        }
        throw new NullPointerException("charset");
    }
}
