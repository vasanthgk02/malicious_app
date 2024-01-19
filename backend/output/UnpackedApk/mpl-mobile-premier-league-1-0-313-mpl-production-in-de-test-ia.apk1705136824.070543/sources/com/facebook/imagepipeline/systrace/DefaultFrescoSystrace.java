package com.facebook.imagepipeline.systrace;

import android.os.Trace;
import com.facebook.imagepipeline.systrace.FrescoSystrace.ArgsBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace.Systrace;
import com.smartfoxserver.v2.protocol.serialization.DefaultObjectDumpFormatter;

public class DefaultFrescoSystrace implements Systrace {

    public static final class DefaultArgsBuilder implements ArgsBuilder {
        public final StringBuilder mStringBuilder;

        public DefaultArgsBuilder(String str) {
            this.mStringBuilder = new StringBuilder(str);
        }

        public ArgsBuilder arg(String str, Object obj) {
            String str2;
            StringBuilder sb = this.mStringBuilder;
            sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
            sb.append(str);
            sb.append('=');
            if (obj == null) {
                str2 = "null";
            } else {
                str2 = obj.toString();
            }
            sb.append(str2);
            return this;
        }

        public void flush() {
            if (this.mStringBuilder.length() > 127) {
                this.mStringBuilder.setLength(127);
            }
            Trace.beginSection(this.mStringBuilder.toString());
        }

        public ArgsBuilder arg(String str, int i) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
            sb.append(str);
            sb.append('=');
            sb.append(Integer.toString(i));
            return this;
        }

        public ArgsBuilder arg(String str, long j) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
            sb.append(str);
            sb.append('=');
            sb.append(Long.toString(j));
            return this;
        }

        public ArgsBuilder arg(String str, double d2) {
            StringBuilder sb = this.mStringBuilder;
            sb.append(DefaultObjectDumpFormatter.TOKEN_DIVIDER);
            sb.append(str);
            sb.append('=');
            sb.append(Double.toString(d2));
            return this;
        }
    }

    public void beginSection(String str) {
    }

    public ArgsBuilder beginSectionWithArgs(String str) {
        return FrescoSystrace.NO_OP_ARGS_BUILDER;
    }

    public void endSection() {
    }

    public boolean isTracing() {
        return false;
    }
}
