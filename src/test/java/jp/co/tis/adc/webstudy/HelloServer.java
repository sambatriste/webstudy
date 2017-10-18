package jp.co.tis.adc.webstudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HelloServer {

    public static void main(String[] args) throws IOException {
        HelloServer helloServer = new HelloServer();
        helloServer.hello();
    }

    private void hello() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8088);
             Socket socket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {

            String line;
            do {
                line = in.readLine();
                System.out.println(line);
            } while (!line.isEmpty());

            out.write("HTTP/1.1 200 OK\r\n");
            out.write("Content-Type: text/html; charset=utf-8\r\n");
            out.write("\r\n");
            out.write("<!DOCTYPE html>");
            out.write("<h1>hello!</h1>");
            out.flush();
        }
    }
}
