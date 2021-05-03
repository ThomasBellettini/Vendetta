package fr.jam.request;

import fr.jam.AnonyChat;
import fr.jam.api.Chat;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class Request {

    public void sendNewChat(String message) {
        String format_url = "http://68.183.208.201:3000/newmsg/" + message.replaceAll(" ", "%20").replaceAll("[^A-Za-z0-9%]","");;
        String url = format_url;
        String in = null;

        try {
            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod(url);

            client.executeMethod(method);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Chat sendRequest() throws IOException {
        String url = "http://68.183.208.201:3000/";
        String in = null;

        try {
            HttpClient client = new HttpClient();
            PostMethod method = new PostMethod(url);

            method.addParameter("p", "apple");

            int statusCode = client.executeMethod(method);

            if (statusCode != -1) {
                in = method.getResponseBodyAsString();
                Chat c = AnonyChat.getChatParser.deserialize(in);
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
