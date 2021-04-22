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
            Socket socket = new Socket("172.20.10.2",8080);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        String response = null; // читает ответ сервера
                        try {
                            response = in.readUTF();
                            System.out.println(response);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
            while (true){
                Scanner scanner = new Scanner(System.in);
                String request = scanner.nextLine();
                System.out.println(request);
                out.writeUTF(request);// отправляем сообщение серверу
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
