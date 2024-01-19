package com.twitter;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMapParser;

public class Extractor {
    public boolean extractURLWithoutProtocol = true;

    public static class Entity {
        public int end;
        public int start;
        public final Type type;
        public final String value;

        public enum Type {
            URL,
            HASHTAG,
            MENTION,
            CASHTAG
        }

        public Entity(int i, int i2, String str, Type type2) {
            this.start = i;
            this.end = i2;
            this.value = str;
            this.type = type2;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entity)) {
                return false;
            }
            Entity entity = (Entity) obj;
            if (!this.type.equals(entity.type) || this.start != entity.start || this.end != entity.end || !this.value.equals(entity.value)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return this.value.hashCode() + this.type.hashCode() + this.start + this.end;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.value);
            sb.append("(");
            sb.append(this.type);
            sb.append(") [");
            sb.append(this.start);
            sb.append(",");
            return GeneratedOutlineSupport.outline57(sb, this.end, CMapParser.MARK_END_OF_ARRAY);
        }
    }
}
