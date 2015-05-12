package com.exc0502;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ido on 03/05/15.
 */
public class ChatServer {

    private Socket socket;
    private ServerSocket server=null;

    private InputStream is = null;
    private DataInputStream dis = null;

    private OutputStream os = null;
    private DataOutputStream dos = null;



    public static String serverName = "http://localhost/";
    public static int port = 3000;

    public ChatServer() throws IOException {

        try {
            server = new ServerSocket(port);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
        }
        socket = server.accept();
        is = socket.getInputStream();
        dis = new DataInputStream(is);
        os = socket.getOutputStream();
        dos = new DataOutputStream(os);

    }


    public void run() throws IOException {
        while (true) {
            String reply = dis.readUTF();
            System.out.println("Message recived from a client: " + reply);
            dos.writeUTF(reply);
            if (false)
                break;
        }
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (dis != null) {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (dos != null) {
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws IOException {
        ChatServer ls = new ChatServer();
        try {
            ls.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
