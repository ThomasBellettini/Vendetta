package fr.jam.api;

import java.util.HashMap;

public class Chat {

    protected HashMap<Integer, String> chat = new HashMap<>();

    public Chat(HashMap<String, String> chat) {
        if (!chat.isEmpty()) {
            for (int i = 0; i < chat.size(); i++) {
                this.chat.put(i, chat.get("" + i));
            }
        }
    }

    public HashMap<Integer, String> getChat() {
        return chat;
    }
}
