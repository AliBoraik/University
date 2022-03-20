package handler;

import dis.HTTPRequest;
import dis.HTTPResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FilesHandler implements RequestHandler{
    public FilesHandler(String na) {

    }

    @Override
    public void process(HTTPRequest request, HTTPResponse response) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/main/resources/application/html/long"+request.getPath()));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        String body = contentBuilder.toString();

        response.sendResponse(body,"200 OK");
    }
}
