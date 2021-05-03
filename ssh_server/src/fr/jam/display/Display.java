package fr.jam.display;

import jline.console.ConsoleReader;

import java.io.IOException;

public class Display {

    public int latestMsg = 0;
    public ConsoleReader reader;

    public Display()
    {
        try {
            execute();
        }catch (IOException e) {

        }
    }

    public void setLatestMsg(int latestMsg) {
        this.latestMsg = latestMsg;
    }

    public void execute() throws IOException {
        System.setProperty("jline.terminal", "jline.UnsupportedTerminal");
        reader = new ConsoleReader(System.in, System.out);
        reader.setExpandEvents(false);

        ThreadConsoleHandler consoleHandler = new ThreadConsoleHandler(this);
        ThreadUpdateHandle threadConsoleHandler = new ThreadUpdateHandle(this);
        consoleHandler.setDaemon(true);

        consoleHandler.start();
        threadConsoleHandler.start();
        while (true);

    }

}
