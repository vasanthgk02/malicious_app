package io.hansel.actions.configs;

import android.util.Base64;
import com.userexperior.utilities.k;
import io.hansel.core.json.CoreJSONObject;
import io.hansel.core.logger.HSLLogger;
import io.hansel.core.logger.LogGroup;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import org.jboss.netty.channel.ChannelPipelineCoverage;

public class i {
    public static CoreJSONObject a(CoreJSONObject coreJSONObject) {
        CoreJSONObject coreJSONObject2 = new CoreJSONObject();
        if (coreJSONObject != null) {
            try {
                CoreJSONObject optJSONObject = coreJSONObject.optJSONObject("up");
                CoreJSONObject coreJSONObject3 = new CoreJSONObject();
                CoreJSONObject coreJSONObject4 = new CoreJSONObject();
                ArrayList arrayList = new ArrayList(optJSONObject.keySet());
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    String str = (String) arrayList.get(i);
                    CoreJSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
                    if (optJSONObject2 != null) {
                        CoreJSONObject coreJSONObject5 = new CoreJSONObject();
                        coreJSONObject5.put((String) "data_type", (Object) optJSONObject2.optString("dt"));
                        coreJSONObject4.put(str, (Object) coreJSONObject5);
                        coreJSONObject3.put(optJSONObject2.optString(k.f4287a), (Object) str);
                    }
                }
                CoreJSONObject optJSONObject3 = coreJSONObject.optJSONObject("d");
                if (optJSONObject3 == null) {
                    optJSONObject3 = new CoreJSONObject();
                }
                coreJSONObject2.put((String) ChannelPipelineCoverage.ALL, optJSONObject3.optBoolean(ChannelPipelineCoverage.ALL));
                coreJSONObject2.put((String) "configs_to_delete", (Object) optJSONObject3.optJSONArray(k.f4287a));
                coreJSONObject2.put((String) "super_configs", (Object) optJSONObject);
                coreJSONObject2.put((String) "config_id_metadata_map", (Object) coreJSONObject4);
                coreJSONObject2.put((String) "config_name_id_map", (Object) coreJSONObject3);
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
        return coreJSONObject2;
    }

    public static Serializable a(String str) {
        Serializable serializable = null;
        if (str == null) {
            return null;
        }
        try {
            serializable = (Serializable) new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 0))).readObject();
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2, "Exception while deserialize configs", LogGroup.CJ);
        }
        return serializable;
    }

    public static String a(Serializable serializable) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (IOException e2) {
            HSLLogger.printStackTrace(e2);
            return null;
        }
    }
}
