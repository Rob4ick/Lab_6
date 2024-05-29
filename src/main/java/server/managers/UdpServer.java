package server.managers;

import common.Request;
import common.Response;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class UdpServer {

    DatagramChannel server = DatagramChannel.open();
    ByteBuffer buf = ByteBuffer.allocate(1024);
    SocketAddress clientAddress;
    public UdpServer(int port) throws IOException {
        server.configureBlocking(false);
        server.socket().bind(new InetSocketAddress(port));
    }

    public Request catchRequest() throws IOException, ClassNotFoundException {
        while(true) {
            buf.clear();
            clientAddress = server.receive(buf);
            if(clientAddress != null) {
                ByteArrayInputStream byteStream = new ByteArrayInputStream(buf.array());
                ObjectInputStream objStream = new ObjectInputStream(byteStream);
                return (Request) objStream.readObject();
            }
        }
    }

    public void sendResponse(Response response) throws IOException {
        while (true) {
            if (clientAddress != null) {
                byte[] message = response.toString().getBytes();
                ByteBuffer responseBuffer = ByteBuffer.wrap(message);
                server.send(responseBuffer, clientAddress);
                return;
            }
        }
    }
}
