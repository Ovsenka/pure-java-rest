package org.ovsenka.api;

import java.io.IOException;
import java.io.OutputStream;

import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;


public class Main {
    public static void main(String[] args) throws IOException{
        int serverPort = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        server.createContext("/api/hello", exchange -> {
            if ("GET".equals(exchange.getRequestMethod())){
                String respText = "Hello!";
                exchange.sendResponseHeaders(200, respText.getBytes().length);
                OutputStream out = exchange.getResponseBody();
                out.write(respText.getBytes());
                out.flush();
            } else {
                exchange.sendResponseHeaders(405, -1); // Method not allowed
            }
            exchange.close();
        });
        server.start();
        System.out.println("Server started!");

    }
}