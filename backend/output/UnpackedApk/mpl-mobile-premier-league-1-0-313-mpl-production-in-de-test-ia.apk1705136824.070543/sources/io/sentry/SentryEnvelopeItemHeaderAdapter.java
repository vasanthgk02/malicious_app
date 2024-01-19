package io.sentry;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import io.sentry.util.StringUtils;
import java.io.IOException;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryEnvelopeItemHeaderAdapter extends TypeAdapter<SentryEnvelopeItemHeader> {
    public SentryEnvelopeItemHeader read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        SentryItemType sentryItemType = SentryItemType.Unknown;
        jsonReader.beginObject();
        SentryItemType sentryItemType2 = sentryItemType;
        String str = null;
        String str2 = null;
        String str3 = null;
        int i = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1106363674:
                    if (nextName.equals("length")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -734768633:
                    if (nextName.equals("filename")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -672977706:
                    if (nextName.equals("attachment_type")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 831846208:
                    if (nextName.equals("content_type")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                str2 = jsonReader.nextString();
            } else if (c2 == 2) {
                try {
                    String capitalize = StringUtils.capitalize(jsonReader.nextString());
                    if (capitalize != null) {
                        sentryItemType2 = SentryItemType.valueOf(capitalize);
                    }
                } catch (IllegalArgumentException unused) {
                }
            } else if (c2 == 3) {
                i = jsonReader.nextInt();
            } else if (c2 != 4) {
                jsonReader.skipValue();
            } else {
                str3 = jsonReader.nextString();
            }
        }
        jsonReader.endObject();
        SentryEnvelopeItemHeader sentryEnvelopeItemHeader = new SentryEnvelopeItemHeader(sentryItemType2, i, str, str2, str3);
        return sentryEnvelopeItemHeader;
    }

    public void write(JsonWriter jsonWriter, SentryEnvelopeItemHeader sentryEnvelopeItemHeader) throws IOException {
        if (sentryEnvelopeItemHeader == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        if (sentryEnvelopeItemHeader.getContentType() != null) {
            jsonWriter.name("content_type");
            jsonWriter.value(sentryEnvelopeItemHeader.getContentType());
        }
        if (sentryEnvelopeItemHeader.getFileName() != null) {
            jsonWriter.name("filename");
            jsonWriter.value(sentryEnvelopeItemHeader.getFileName());
        }
        if (!SentryItemType.Unknown.equals(sentryEnvelopeItemHeader.getType())) {
            jsonWriter.name("type");
            jsonWriter.value(sentryEnvelopeItemHeader.getType().getItemType().toLowerCase(Locale.ROOT));
        }
        if (sentryEnvelopeItemHeader.getAttachmentType() != null) {
            jsonWriter.name("attachment_type");
            jsonWriter.value(sentryEnvelopeItemHeader.getAttachmentType());
        }
        jsonWriter.name("length");
        jsonWriter.value((long) sentryEnvelopeItemHeader.getLength());
        jsonWriter.endObject();
    }
}
