package net.danlew.android.joda;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.paho.client.mqttv3.MqttTopic;

public class ResUtils {
    public static Map<Class<?>, Map<String, Integer>> sIdentifierCache = new ConcurrentHashMap();

    public static String getTzResource(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("joda_");
        File file = new File(str);
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(file.getName());
            file = file.getParentFile();
        } while (file != null);
        StringBuffer stringBuffer = new StringBuffer();
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("_");
                }
                stringBuffer.append((String) arrayList.get(size));
            } else {
                outline73.append(stringBuffer.toString().replace('-', '_').replace(MqttTopic.SINGLE_LEVEL_WILDCARD, "plus").toLowerCase(Locale.US));
                return outline73.toString();
            }
        }
    }
}
