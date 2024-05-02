package server;

import common.Request;
import common.Response;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramChannel server = DatagramChannel.open();
        server.socket().bind(new InetSocketAddress(9999));

        System.out.println("Server started on port 9999");

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (true) {
            buf.clear();
            SocketAddress clientAddress = server.receive(buf);

            if (clientAddress != null) {

                ByteArrayInputStream byteStream = new ByteArrayInputStream(buf.array());
                ObjectInputStream objStream = new ObjectInputStream(byteStream);

                Request request = (Request) objStream.readObject();




                byte[] response = message.getBytes();
                ByteBuffer responseBuffer = ByteBuffer.wrap(response);

                server.send(responseBuffer, clientAddress);
            }
        }
    }
}