package com.google.firebase.messaging;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.regex.Pattern;

public final class TopicOperation {
    public static final Pattern TOPIC_NAME_REGEXP = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    public final String operation;
    public final String serializedString;
    public final String topic;

    public TopicOperation(@TopicOperations String str, String str2) {
        String str3;
        if (str2 == null || !str2.startsWith("/topics/")) {
            str3 = str2;
        } else {
            String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[]{str});
            str3 = str2.substring(8);
        }
        if (str3 == null || !TOPIC_NAME_REGEXP.matcher(str3).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[]{str3, "[a-zA-Z0-9-_.~%]{1,900}"}));
        }
        this.topic = str3;
        this.operation = str;
        this.serializedString = GeneratedOutlineSupport.outline52(str, "!", str2);
    }

    public static TopicOperation from(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new TopicOperation(split[0], split[1]);
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof TopicOperation)) {
            return false;
        }
        TopicOperation topicOperation = (TopicOperation) obj;
        if (this.topic.equals(topicOperation.topic) && this.operation.equals(topicOperation.operation)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.operation, this.topic});
    }
}
