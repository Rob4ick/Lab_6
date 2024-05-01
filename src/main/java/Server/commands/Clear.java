package Server.commands;

import Common.Command;
import Server.managers.CollectionManager;
import client.Console;

public class Clear extends Command {
    private final Console console;
    private final CollectionManager collectionManager;
    public Clear(Console console, CollectionManager collectionManager) {
        super("name", "description");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    public boolean execution(String[] args) {
        if (args.length != 1){
            console.printError("Неправильное количество аргументов");
            return false;
        }

        collectionManager.clearCollection();
        console.println("Коллекция очищена");
        return true;
    }
}
