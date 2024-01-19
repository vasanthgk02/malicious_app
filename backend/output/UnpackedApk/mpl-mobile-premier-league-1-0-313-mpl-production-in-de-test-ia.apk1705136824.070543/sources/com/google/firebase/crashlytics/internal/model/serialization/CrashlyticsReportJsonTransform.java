package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload.File;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder.AnonymousClass1;
import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import com.razorpay.AnalyticsConstants;
import com.rudderstack.android.sdk.core.RudderTraits;
import in.juspay.hypersdk.core.PaymentConstants.SubCategory.Action;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.android.service.MqttServiceConstants;

public class CrashlyticsReportJsonTransform {
    public static final DataEncoder CRASHLYTICS_REPORT_JSON_ENCODER;

    public interface ObjectParser<T> {
        T parse(JsonReader jsonReader) throws IOException;
    }

    static {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        AutoCrashlyticsReportEncoder.CONFIG.configure(jsonDataEncoderBuilder);
        jsonDataEncoderBuilder.ignoreNullValues = true;
        CRASHLYTICS_REPORT_JSON_ENCODER = new DataEncoder() {
            /* JADX INFO: used method not loaded: com.google.firebase.encoders.json.JsonValueObjectEncoderContext.add(java.lang.Object, boolean):null, types can be incorrect */
            public void encode(Object obj, Writer writer) throws IOException {
                JsonDataEncoderBuilder jsonDataEncoderBuilder = JsonDataEncoderBuilder.this;
                JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(writer, jsonDataEncoderBuilder.objectEncoders, jsonDataEncoderBuilder.valueEncoders, jsonDataEncoderBuilder.fallbackEncoder, jsonDataEncoderBuilder.ignoreNullValues);
                jsonValueObjectEncoderContext.add(obj, false);
                jsonValueObjectEncoderContext.maybeUnNest();
                jsonValueObjectEncoderContext.jsonWriter.flush();
            }

            public String encode(Object obj) {
                StringWriter stringWriter = new StringWriter();
                try {
                    encode(obj, stringWriter);
                } catch (IOException unused) {
                }
                return stringWriter.toString();
            }
        };
    }

    public static Application parseApp(JsonReader jsonReader) throws IOException {
        Builder builder = Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -519438642:
                    if (nextName.equals("developmentPlatform")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 213652010:
                    if (nextName.equals("developmentPlatformVersion")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                builder.setIdentifier(jsonReader.nextString());
            } else if (c2 == 1) {
                builder.setVersion(jsonReader.nextString());
            } else if (c2 == 2) {
                builder.setDisplayVersion(jsonReader.nextString());
            } else if (c2 == 3) {
                builder.setInstallationUuid(jsonReader.nextString());
            } else if (c2 == 4) {
                builder.setDevelopmentPlatform(jsonReader.nextString());
            } else if (c2 != 5) {
                jsonReader.skipValue();
            } else {
                builder.setDevelopmentPlatformVersion(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static ApplicationExitInfo parseAppExitInfo(JsonReader jsonReader) throws IOException {
        ApplicationExitInfo.Builder builder = ApplicationExitInfo.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 110987:
                    if (nextName.equals("pid")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 111312:
                    if (nextName.equals("pss")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 113234:
                    if (nextName.equals("rss")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 202325402:
                    if (nextName.equals("processName")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 722137681:
                    if (nextName.equals("reasonCode")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 723857505:
                    if (nextName.equals("traceFile")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    builder.setPid(jsonReader.nextInt());
                    break;
                case 1:
                    builder.setProcessName(jsonReader.nextString());
                    break;
                case 2:
                    builder.setReasonCode(jsonReader.nextInt());
                    break;
                case 3:
                    builder.setImportance(jsonReader.nextInt());
                    break;
                case 4:
                    builder.setPss(jsonReader.nextLong());
                    break;
                case 5:
                    builder.setRss(jsonReader.nextLong());
                    break;
                case 6:
                    builder.setTimestamp(jsonReader.nextLong());
                    break;
                case 7:
                    builder.setTraceFile(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static <T> ImmutableList<T> parseArray(JsonReader jsonReader, ObjectParser<T> objectParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(objectParser.parse(jsonReader));
        }
        jsonReader.endArray();
        return ImmutableList.from((List<E>) arrayList);
    }

    public static CustomAttribute parseCustomAttribute(JsonReader jsonReader) throws IOException {
        CustomAttribute.Builder builder = CustomAttribute.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 106079) {
                if (hashCode == 111972721 && nextName.equals(HSLCriteriaBuilder.VALUE)) {
                    c2 = 1;
                }
            } else if (nextName.equals("key")) {
                c2 = 0;
            }
            if (c2 == 0) {
                builder.setKey(jsonReader.nextString());
            } else if (c2 != 1) {
                jsonReader.skipValue();
            } else {
                builder.setValue(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static Device parseDevice(JsonReader jsonReader) throws IOException {
        Device.Builder builder = Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals("model")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals("state")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c2 = 8;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    builder.setArch(jsonReader.nextInt());
                    break;
                case 1:
                    builder.setModel(jsonReader.nextString());
                    break;
                case 2:
                    builder.setCores(jsonReader.nextInt());
                    break;
                case 3:
                    builder.setRam(jsonReader.nextLong());
                    break;
                case 4:
                    builder.setDiskSpace(jsonReader.nextLong());
                    break;
                case 5:
                    builder.setSimulator(jsonReader.nextBoolean());
                    break;
                case 6:
                    builder.setState(jsonReader.nextInt());
                    break;
                case 7:
                    builder.setManufacturer(jsonReader.nextString());
                    break;
                case 8:
                    builder.setModelClass(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static Event parseEvent(JsonReader jsonReader) throws IOException {
        Event.Builder builder = Event.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals(AnalyticsConstants.LOG)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                builder.setTimestamp(jsonReader.nextLong());
            } else if (c2 == 1) {
                builder.setType(jsonReader.nextString());
            } else if (c2 == 2) {
                builder.setApp(parseEventApp(jsonReader));
            } else if (c2 == 3) {
                builder.setDevice(parseEventDevice(jsonReader));
            } else if (c2 != 4) {
                jsonReader.skipValue();
            } else {
                builder.setLog(parseEventLog(jsonReader));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static Event.Application parseEventApp(JsonReader jsonReader) throws IOException {
        Event.Application.Builder builder = Event.Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1332194002:
                    if (nextName.equals("background")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1090974952:
                    if (nextName.equals("execution")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -80231855:
                    if (nextName.equals("internalKeys")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 555169704:
                    if (nextName.equals("customAttributes")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 928737948:
                    if (nextName.equals("uiOrientation")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                builder.setBackground(Boolean.valueOf(jsonReader.nextBoolean()));
            } else if (c2 == 1) {
                builder.setUiOrientation(jsonReader.nextInt());
            } else if (c2 == 2) {
                builder.setExecution(parseEventExecution(jsonReader));
            } else if (c2 == 3) {
                builder.setCustomAttributes(parseArray(jsonReader, $$Lambda$NhzBXeLMMIRDAHryokwvoZKlwo.INSTANCE));
            } else if (c2 != 4) {
                jsonReader.skipValue();
            } else {
                builder.setInternalKeys(parseArray(jsonReader, $$Lambda$NhzBXeLMMIRDAHryokwvoZKlwo.INSTANCE));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static BinaryImage parseEventBinaryImage(JsonReader jsonReader) throws IOException {
        BinaryImage.Builder builder = BinaryImage.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 3373707:
                    if (nextName.equals("name")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals(Response.SIZE)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3601339:
                    if (nextName.equals("uuid")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1153765347:
                    if (nextName.equals("baseAddress")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                builder.setName(jsonReader.nextString());
            } else if (c2 == 1) {
                builder.setBaseAddress(jsonReader.nextLong());
            } else if (c2 == 2) {
                builder.setSize(jsonReader.nextLong());
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                builder.setUuidFromUtf8Bytes(Base64.decode(jsonReader.nextString(), 2));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static Event.Device parseEventDevice(JsonReader jsonReader) throws IOException {
        Event.Device.Builder builder = Event.Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1708606089:
                    if (nextName.equals("batteryLevel")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1455558134:
                    if (nextName.equals("batteryVelocity")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1439500848:
                    if (nextName.equals("orientation")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 279795450:
                    if (nextName.equals("diskUsed")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 976541947:
                    if (nextName.equals("ramUsed")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1516795582:
                    if (nextName.equals("proximityOn")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                builder.setBatteryLevel(Double.valueOf(jsonReader.nextDouble()));
            } else if (c2 == 1) {
                builder.setBatteryVelocity(jsonReader.nextInt());
            } else if (c2 == 2) {
                builder.setDiskUsed(jsonReader.nextLong());
            } else if (c2 == 3) {
                builder.setProximityOn(jsonReader.nextBoolean());
            } else if (c2 == 4) {
                builder.setOrientation(jsonReader.nextInt());
            } else if (c2 != 5) {
                jsonReader.skipValue();
            } else {
                builder.setRamUsed(jsonReader.nextLong());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static Execution parseEventExecution(JsonReader jsonReader) throws IOException {
        Execution.Builder builder = Execution.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1337936983:
                    if (nextName.equals("threads")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -902467928:
                    if (nextName.equals("signal")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 937615455:
                    if (nextName.equals("binaries")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1481625679:
                    if (nextName.equals(MqttServiceConstants.TRACE_EXCEPTION)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                builder.setThreads(parseArray(jsonReader, $$Lambda$NcslUolmMJ2rhykSKHnzkuM2hYY.INSTANCE));
            } else if (c2 == 1) {
                builder.setException(parseEventExecutionException(jsonReader));
            } else if (c2 == 2) {
                builder.setSignal(parseEventSignal(jsonReader));
            } else if (c2 == 3) {
                builder.setBinaries(parseArray(jsonReader, $$Lambda$CDavwmIaUoxPoo5Upyr1hcsJXE.INSTANCE));
            } else if (c2 != 4) {
                jsonReader.skipValue();
            } else {
                builder.setAppExitInfo(parseAppExitInfo(jsonReader));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static Exception parseEventExecutionException(JsonReader jsonReader) throws IOException {
        Exception.Builder builder = Exception.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals("reason")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                builder.setCausedBy(parseEventExecutionException(jsonReader));
            } else if (c2 == 1) {
                builder.setFrames(parseArray(jsonReader, $$Lambda$dIOx2087eNrDPBVbiDN535D2ZNE.INSTANCE));
            } else if (c2 == 2) {
                builder.setOverflowCount(jsonReader.nextInt());
            } else if (c2 == 3) {
                builder.setType(jsonReader.nextString());
            } else if (c2 != 4) {
                jsonReader.skipValue();
            } else {
                builder.setReason(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static Frame parseEventFrame(JsonReader jsonReader) throws IOException {
        Frame.Builder builder = Frame.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals("offset")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals("pc")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals("file")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                builder.setImportance(jsonReader.nextInt());
            } else if (c2 == 1) {
                builder.setFile(jsonReader.nextString());
            } else if (c2 == 2) {
                builder.setOffset(jsonReader.nextLong());
            } else if (c2 == 3) {
                builder.setPc(jsonReader.nextLong());
            } else if (c2 != 4) {
                jsonReader.skipValue();
            } else {
                builder.setSymbol(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static Log parseEventLog(JsonReader jsonReader) throws IOException {
        Log.Builder builder = Log.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            if (nextName.hashCode() == 951530617 && nextName.equals("content")) {
                c2 = 0;
            }
            if (c2 != 0) {
                jsonReader.skipValue();
            } else {
                builder.setContent(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static Signal parseEventSignal(JsonReader jsonReader) throws IOException {
        Signal.Builder builder = Signal.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1147692044) {
                if (hashCode != 3059181) {
                    if (hashCode == 3373707 && nextName.equals("name")) {
                        c2 = 0;
                    }
                } else if (nextName.equals("code")) {
                    c2 = 1;
                }
            } else if (nextName.equals(RudderTraits.ADDRESS_KEY)) {
                c2 = 2;
            }
            if (c2 == 0) {
                builder.setName(jsonReader.nextString());
            } else if (c2 == 1) {
                builder.setCode(jsonReader.nextString());
            } else if (c2 != 2) {
                jsonReader.skipValue();
            } else {
                builder.setAddress(jsonReader.nextLong());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static Thread parseEventThread(JsonReader jsonReader) throws IOException {
        Thread.Builder builder = Thread.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1266514778) {
                if (hashCode != 3373707) {
                    if (hashCode == 2125650548 && nextName.equals("importance")) {
                        c2 = 0;
                    }
                } else if (nextName.equals("name")) {
                    c2 = 1;
                }
            } else if (nextName.equals("frames")) {
                c2 = 2;
            }
            if (c2 == 0) {
                builder.setImportance(jsonReader.nextInt());
            } else if (c2 == 1) {
                builder.setName(jsonReader.nextString());
            } else if (c2 != 2) {
                jsonReader.skipValue();
            } else {
                builder.setFrames(parseArray(jsonReader, $$Lambda$dIOx2087eNrDPBVbiDN535D2ZNE.INSTANCE));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static File parseFile(JsonReader jsonReader) throws IOException {
        File.Builder builder = File.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -734768633) {
                if (hashCode == -567321830 && nextName.equals("contents")) {
                    c2 = 1;
                }
            } else if (nextName.equals("filename")) {
                c2 = 0;
            }
            if (c2 == 0) {
                builder.setFilename(jsonReader.nextString());
            } else if (c2 != 1) {
                jsonReader.skipValue();
            } else {
                builder.setContents(Base64.decode(jsonReader.nextString(), 2));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static FilesPayload parseNdkPayload(JsonReader jsonReader) throws IOException {
        FilesPayload.Builder builder = FilesPayload.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 97434231) {
                if (hashCode == 106008351 && nextName.equals("orgId")) {
                    c2 = 1;
                }
            } else if (nextName.equals("files")) {
                c2 = 0;
            }
            if (c2 == 0) {
                builder.setFiles(parseArray(jsonReader, $$Lambda$PcYtebWm8LLEihGxNBWQex7movQ.INSTANCE));
            } else if (c2 != 1) {
                jsonReader.skipValue();
            } else {
                builder.setOrgId(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static OperatingSystem parseOs(JsonReader jsonReader) throws IOException {
        OperatingSystem.Builder builder = OperatingSystem.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -293026577:
                    if (nextName.equals("jailbroken")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                builder.setPlatform(jsonReader.nextInt());
            } else if (c2 == 1) {
                builder.setVersion(jsonReader.nextString());
            } else if (c2 == 2) {
                builder.setBuildVersion(jsonReader.nextString());
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                builder.setJailbroken(jsonReader.nextBoolean());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static CrashlyticsReport parseReport(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Builder builder = CrashlyticsReport.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    builder.setSdkVersion(jsonReader.nextString());
                    break;
                case 1:
                    builder.setGmpAppId(jsonReader.nextString());
                    break;
                case 2:
                    builder.setPlatform(jsonReader.nextInt());
                    break;
                case 3:
                    builder.setInstallationUuid(jsonReader.nextString());
                    break;
                case 4:
                    builder.setBuildVersion(jsonReader.nextString());
                    break;
                case 5:
                    builder.setDisplayVersion(jsonReader.nextString());
                    break;
                case 6:
                    builder.setSession(parseSession(jsonReader));
                    break;
                case 7:
                    builder.setNdkPayload(parseNdkPayload(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static Session parseSession(JsonReader jsonReader) throws IOException {
        Session.Builder builder = Session.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -2128794476:
                    if (nextName.equals("startedAt")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1606742899:
                    if (nextName.equals("endedAt")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1335157162:
                    if (nextName.equals("device")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals("events")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals(Action.USER)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 286956243:
                    if (nextName.equals("generator")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1025385094:
                    if (nextName.equals("crashed")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 2047016109:
                    if (nextName.equals("generatorType")) {
                        c2 = 10;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    builder.setGenerator(jsonReader.nextString());
                    break;
                case 1:
                    builder.setIdentifierFromUtf8Bytes(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 2:
                    builder.setStartedAt(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setEndedAt(Long.valueOf(jsonReader.nextLong()));
                    break;
                case 4:
                    builder.setCrashed(jsonReader.nextBoolean());
                    break;
                case 5:
                    builder.setUser(parseUser(jsonReader));
                    break;
                case 6:
                    builder.setApp(parseApp(jsonReader));
                    break;
                case 7:
                    builder.setOs(parseOs(jsonReader));
                    break;
                case 8:
                    builder.setDevice(parseDevice(jsonReader));
                    break;
                case 9:
                    builder.setEvents(parseArray(jsonReader, $$Lambda$Ckb34QcYctmy_Q7QdvSnBmK1U98.INSTANCE));
                    break;
                case 10:
                    builder.setGeneratorType(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public static User parseUser(JsonReader jsonReader) throws IOException {
        User.Builder builder = User.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            if (nextName.hashCode() == -1618432855 && nextName.equals("identifier")) {
                c2 = 0;
            }
            if (c2 != 0) {
                jsonReader.skipValue();
            } else {
                builder.setIdentifier(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public ApplicationExitInfo applicationExitInfoFromJson(String str) throws IOException {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new StringReader(str));
            ApplicationExitInfo parseAppExitInfo = parseAppExitInfo(jsonReader);
            jsonReader.close();
            return parseAppExitInfo;
        } catch (IllegalStateException e2) {
            throw new IOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public String applicationExitInfoToJson(ApplicationExitInfo applicationExitInfo) {
        return ((AnonymousClass1) CRASHLYTICS_REPORT_JSON_ENCODER).encode(applicationExitInfo);
    }

    public Event eventFromJson(String str) throws IOException {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new StringReader(str));
            Event parseEvent = parseEvent(jsonReader);
            jsonReader.close();
            return parseEvent;
        } catch (IllegalStateException e2) {
            throw new IOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public String eventToJson(Event event) {
        return ((AnonymousClass1) CRASHLYTICS_REPORT_JSON_ENCODER).encode(event);
    }

    public CrashlyticsReport reportFromJson(String str) throws IOException {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new StringReader(str));
            CrashlyticsReport parseReport = parseReport(jsonReader);
            jsonReader.close();
            return parseReport;
        } catch (IllegalStateException e2) {
            throw new IOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public String reportToJson(CrashlyticsReport crashlyticsReport) {
        return ((AnonymousClass1) CRASHLYTICS_REPORT_JSON_ENCODER).encode(crashlyticsReport);
    }
}
