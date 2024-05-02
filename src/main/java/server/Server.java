package server;

import common.Request;
import common.Response;
import server.commands.*;
import server.commands.PrintFieldDescendingWeaponType;
import server.managers.CollectionManager;
import server.managers.CommandProcessor;
import server.managers.DumpManager;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.NoSuchElementException;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            String filePath = System.getenv("javaFile");
            DumpManager dm = new DumpManager(filePath);
            CollectionManager collectionManager = new CollectionManager(dm);

            try {
                collectionManager.loadCollection();
//                console.printMessage("Успешная инициализация коллекции");
            } catch (FileNotFoundException e) {
                //              console.printError("Файла не существует!!!");
            }
            var commandProcessor = new CommandProcessor();

            commandProcessor.addCommand("info", new Info(collectionManager));
            commandProcessor.addCommand("show", new Show(collectionManager));
            commandProcessor.addCommand("add", new Add(collectionManager));
            commandProcessor.addCommand("update_by_id", new UpdateById(collectionManager));
            commandProcessor.addCommand("remove_by_id", new RemoveByID(collectionManager));
            commandProcessor.addCommand("clear", new Clear(collectionManager));
            commandProcessor.addCommand("add_if_max", new AddIfMax(collectionManager));
            commandProcessor.addCommand("remove_greater", new RemoveGreater(collectionManager));
            commandProcessor.addCommand("count_by_mood", new CountByMood(collectionManager));
            commandProcessor.addCommand("filter_less_than_weapon_type", new FilterLessThanWeaponType(collectionManager));
            commandProcessor.addCommand("print_field_descending_weapon_type", new PrintFieldDescendingWeaponType(collectionManager));


            DatagramChannel server = DatagramChannel.open();
            server.configureBlocking(false);
            server.socket().bind(new InetSocketAddress(9999));

            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (true) {
                buf.clear();
                SocketAddress clientAddress = server.receive(buf);

                if (clientAddress != null) {

                    ByteArrayInputStream byteStream = new ByteArrayInputStream(buf.array());
                    ObjectInputStream objStream = new ObjectInputStream(byteStream);

                    Request request = (Request) objStream.readObject();

                    var comm = commandProcessor.getCommands().get(request.getCommandName());

                    Response response = new Response();

                    comm.execution(request, response);


                    byte[] message = response.toString().getBytes();
                    ByteBuffer responseBuffer = ByteBuffer.wrap(message);

                    server.send(responseBuffer, clientAddress);
                }
            }
        }catch(NullPointerException e) {
            System.out.println("Несуществующая переменная окружения!!!\nСоздаёте переменную с именем \"javaFile\" и положите в неё путь к файлу. И запустите программу ещё раз =)");
        }catch (NoSuchElementException ignored){}
    }
}