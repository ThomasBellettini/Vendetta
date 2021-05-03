package fr.jam;

import fr.jam.display.Display;
import fr.jam.request.Request;
import fr.jam.utils.JSONParser;

public class AnonyChat {

    public static JSONParser getChatParser;
    public static Display getDisplay;
    public static Request getChatRequest;

    public static void main(String[] args) throws Exception {
        System.out.println("Launching SSH Terminal Chat (Be a Hacker) ...");
        getChatParser = new JSONParser();
        getChatRequest = new Request();
        getDisplay = new Display();
        getDisplay.reader.getTerminal().restore();
    }
}
