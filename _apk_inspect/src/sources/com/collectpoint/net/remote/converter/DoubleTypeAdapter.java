package com.collectpoint.net.remote.converter;

import android.text.TextUtils;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes13.dex */
public class DoubleTypeAdapter extends TypeAdapter<Double> {

    /* renamed from: com.collectpoint.net.remote.converter.DoubleTypeAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: read, reason: merged with bridge method [inline-methods] */
    public Double m235read(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenPeek = jsonReader.peek();
        switch (AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[jsonTokenPeek.ordinal()]) {
            case 1:
                return Double.valueOf(jsonReader.nextBoolean() ? 1.0d : 0.0d);
            case 2:
                jsonReader.nextNull();
                return null;
            case 3:
                return Double.valueOf(jsonReader.nextDouble());
            case 4:
                String strNextString = jsonReader.nextString();
                return TextUtils.isEmpty(strNextString) ? Double.valueOf(Double.NaN) : Double.valueOf(Double.parseDouble(strNextString));
            default:
                throw new IllegalStateException("Expected BOOLEAN, NUMBER, STRING but was " + jsonTokenPeek);
        }
    }

    public void write(JsonWriter jsonWriter, Double d) throws IOException {
        if (d == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(d);
        }
    }
}
