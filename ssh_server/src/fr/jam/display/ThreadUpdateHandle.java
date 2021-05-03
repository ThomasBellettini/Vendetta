package fr.jam.display;

import fr.jam.AnonyChat;
import fr.jam.api.Chat;
import jline.console.ConsoleReader;

import java.io.IOException;

public class ThreadUpdateHandle  extends Thread {
    Display display;

    public ThreadUpdateHandle(Display display) {
        this.display = display;
    }

    public void run() {
        while (!currentThread().isInterrupted()) {
            try {
                Chat c = AnonyChat.getChatRequest.sendRequest();
                int msg_local = display.latestMsg;

                for (int i = msg_local; i < c.getChat().size(); i++, msg_local++) {
                    System.out.println("[Banana] > " + c.getChat().get(i));
                }
                display.setLatestMsg(msg_local);
                Thread.sleep(1000);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}