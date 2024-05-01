package server.commands;

import client.commands.Command;
import server.managers.CollectionManager;
import client.console.Console;

public class Show extends Command {
    private Console console;
    private CollectionManager collectionManager;
    public Show(Console console, CollectionManager collectionManager) {
        super("Show", "выводит все элементы коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    public boolean execution(String[] args){
        if (args.length != 1){
            console.printError("Неправильное количество аргументов");
            return true;
        }
        console.print(collectionManager.toString());
        return true;
    }
}