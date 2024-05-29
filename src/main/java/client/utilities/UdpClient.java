package client.utilities;

import client.console.StandartConsole;
import client.utilities.CommandHandler;
import common.Request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class UdpClient {
    private static DatagramSocket clientSocket;
    private static final StandartConsole console = new StandartConsole();
    private static final ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
    private static byte[] data;
    private static InetAddress IPAddress;
    private static int port;

    UdpClient(String host, int port1) throws IOException {
        IPAddress = InetAddress.getByName(host);
        port = port1;
        clientSocket = new DatagramSocket();
    }

    public void sendRequest(Request request) throws IOException {
        byteStream.reset();
        ObjectOutputStream objStream = new ObjectOutputStream(byteStream);
        objStream.writeObject(request);
        data = byteStream.toByteArray();

        DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, port);
        clientSocket.send(sendPacket);
    }

    public String catchResponse() throws CommandHandler.ServerException {
        int z = 0;
        while (true) {
            try {
                data = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(data, data.length);
                clientSocket.setSoTimeout(3000);
                clientSocket.receive(receivePacket);
                clientSocket.close();
                return new String(receivePacket.getData()).trim();
            } catch (SocketTimeoutException e) {
                z += 1;
                console.printError("Слишком долгое ожидание ответа от сервера");
            } catch (IOException e) {
                z += 1;
                console.printError("Ошибка сетевого подключения!!!");
            }
            if (z > 5) {
                console.printError("Не удалось восстановить подключение к серверу...");
                throw new CommandHandler.ServerException();
            }
        }
    }
}