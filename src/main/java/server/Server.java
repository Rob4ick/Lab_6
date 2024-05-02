package server;

import common.Request;
import common.Response;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int port = 2288;
        DatagramChannel datagramChannel = DatagramChannel.open();
        //datagramChannel.configureBlocking(false);

        InetSocketAddress serverAddress = new InetSocketAddress(port);
        datagramChannel.bind(serverAddress);

        ByteBuffer buffer = ByteBuffer.allocate(1024*1024);

        SocketAddress clientAddress = datagramChannel.receive(buffer);

        byte[] bytes = buffer.array();


        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objStream = new ObjectInputStream(byteStream);
        Request request = (Request) objStream.readObject();
        System.out.println(request.getCommandName());
        System.out.println(request.getWeaponType());

        buffer.clear();

        Response response = new Response();
        response.setAnswer("Ошибка!!!");

        buffer = ByteBuffer.wrap("ответ".getBytes());
        datagramChannel.send(buffer, clientAddress);

    }
}
