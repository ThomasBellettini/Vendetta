package fr.jam.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.jam.api.Chat;

public class JSONParser {

    private final Gson gson;

    public JSONParser() {
        gson = new GsonBuilder()
                .registerTypeAdapter(Chat.class, new JSONAdapter())
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .serializeNulls().create();
    }

    public Chat deserialize(String file)
    {
        return gson.fromJson(file, Chat.class);
    }

}
