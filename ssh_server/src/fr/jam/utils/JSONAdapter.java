package fr.jam.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fr.jam.api.Chat;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class JSONAdapter extends TypeAdapter<Chat> {

    private static final Type seriTypes = new TypeToken<HashMap<String, String>>() {}.getType();

    @Override
    public void write(JsonWriter writer, Chat scooter) throws IOException {

    }

    @Override
    public Chat read(JsonReader reader) throws IOException {
        Gson gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        reader.beginObject();
        HashMap<String, String> map = new HashMap<>();
        while (reader.hasNext()) {
            String read = reader.nextName();
            switch (read) {
                case "chatLog":
                    map = gson.fromJson(reader.nextString(), seriTypes);
                    break;
            }
        }
        reader.endObject();
        return new Chat(map);
    }
}
