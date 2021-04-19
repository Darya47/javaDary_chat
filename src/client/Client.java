package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("188.190.255.14",8188);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true){
                String response = in.readUTF();
                System.out.println(response);
                Scanner scanner = new Scanner(System.in);
                String request = scanner.next();
                out.writeUTF(request); // отправляем сообщение серверу
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
