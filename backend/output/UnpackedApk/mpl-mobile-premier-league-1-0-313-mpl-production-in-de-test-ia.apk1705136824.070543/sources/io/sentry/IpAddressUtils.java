package io.sentry;

import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class IpAddressUtils {
    public static final String DEFAULT_IP_ADDRESS = "{{auto}}";
    public static final List<String> DEFAULT_IP_ADDRESS_VALID_VALUES = Arrays.asList(new String[]{DEFAULT_IP_ADDRESS, "{{ auto }}"});

    public static boolean isDefault(String str) {
        return str != null && DEFAULT_IP_ADDRESS_VALID_VALUES.contains(str);
    }
}
