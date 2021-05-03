package fr.jam.display;

import fr.jam.AnonyChat;
import jline.console.ConsoleReader;

import java.io.IOException;

class ThreadConsoleHandler extends Thread {

    private final ConsoleReader reader;

    public ThreadConsoleHandler (Display display) {
        this.reader = display.reader;
    }

    public void run()
    {
        while (!currentThread().isInterrupted()) {
            jline.console.ConsoleReader bufferedreader = reader;
            String s;

            try {
                while (true) {
                    s = bufferedreader.readLine("", null);

                    if (s != null && s.trim().length() > 0) {
                        AnonyChat.getChatRequest.sendNewChat(s);
                        continue;
                    }
                }
            } catch (IOException ioexception) {
                System.err.println("Error while parsing console");
            }
        }
    }

}
