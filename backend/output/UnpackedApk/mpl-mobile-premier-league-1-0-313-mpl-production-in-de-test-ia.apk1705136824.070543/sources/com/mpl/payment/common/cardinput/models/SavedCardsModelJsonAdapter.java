package com.mpl.payment.common.cardinput.models;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/mpl/payment/common/cardinput/models/SavedCardsModelJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/mpl/payment/common/cardinput/models/SavedCardsModel;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableListOfSavedCardAdapter", "", "Lcom/mpl/payment/common/cardinput/models/SavedCard;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "mpl-payment_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: SavedCardsModelJsonAdapter.kt */
public final class SavedCardsModelJsonAdapter extends JsonAdapter<SavedCardsModel> {
    public final JsonAdapter<List<SavedCard>> nullableListOfSavedCardAdapter;
    public final Options options;

    public SavedCardsModelJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Options of = Options.of("savedCardsData");
        Intrinsics.checkNotNullExpressionValue(of, "JsonReader.Options.of(\"savedCardsData\")");
        this.options = of;
        JsonAdapter<List<SavedCard>> adapter = moshi.adapter(Types.newParameterizedType(List.class, SavedCard.class), EmptySet.INSTANCE, "savedCardsData");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…,\n      \"savedCardsData\")");
        this.nullableListOfSavedCardAdapter = adapter;
    }

    public String toString() {
        Intrinsics.checkNotNullExpressionValue("GeneratedJsonAdapter(SavedCardsModel)", "StringBuilder(capacity).…builderAction).toString()");
        return "GeneratedJsonAdapter(SavedCardsModel)";
    }

    public SavedCardsModel fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        jsonReader.beginObject();
        List list = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(this.options);
            if (selectName == -1) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else if (selectName == 0) {
                list = (List) this.nullableListOfSavedCardAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.endObject();
        return new SavedCardsModel(list);
    }

    public void toJson(JsonWriter jsonWriter, SavedCardsModel savedCardsModel) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (savedCardsModel != null) {
            jsonWriter.beginObject();
            jsonWriter.name("savedCardsData");
            this.nullableListOfSavedCardAdapter.toJson(jsonWriter, savedCardsModel.getSavedCardsData());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
