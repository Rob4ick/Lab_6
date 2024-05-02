package client;

import client.commands.Add;
import client.console.StandartConsole;
import common.Request;
import common.exeptions.CoordinatesExeption;


import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Client {
    public static void main(String[] args) throws IOException, CoordinatesExeption {
        StandartConsole console = new StandartConsole();

        int port = 2288; //порт
        DatagramChannel datagramChannel = DatagramChannel.open();
        //datagramChannel.configureBlocking(false); //неблокирующий режим
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", port);

        ByteBuffer buffer = null;

        Request request = new Request();

        Add add = new Add(console);
        add.execution(new String[]{"add"}, request);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(request);
        buffer = ByteBuffer.wrap(bos.toByteArray());

        datagramChannel.send(buffer, serverAddress);

        buffer.clear();
        buffer = ByteBuffer.allocate(30);
        datagramChannel.receive(buffer);

        System.out.println(new String(buffer.array()));

    }
}