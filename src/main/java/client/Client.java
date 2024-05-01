package client;

import Common.Request;
import Common.obj.*;
import exeptions.CoordinatesExeption;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Client {
    public static void main(String[] args) throws IOException, CoordinatesExeption {
        int port = 2288;
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", port);
        ByteBuffer buffer = null;

        HumanBeing hb = new HumanBeing(1, "Robert", new Coordinates(1, 3), true, true, 334, WeaponType.RIFLE, Mood.GLOOM, new Car(true));

        Request request = new Request();
        request.setCommandName("add");
        request.setHb(hb);

        datagramChannel.send(buffer, serverAddress);

        buffer.clear();
        buffer = ByteBuffer.allocate(30);
        datagramChannel.receive(buffer);

        buffer.array();

    }
}