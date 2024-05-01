package server.commands;

import client.commands.Command;
import server.managers.CollectionManager;
import client.console.Console;

public class Exit extends Command {
    private final Console console;
    private final CollectionManager collectionManager;
    public Exit(Console console, CollectionManager collectionManager) {
        super("exit", "завершает программу");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    public boolean execution(String[] args){
        if (args.length != 1){
            console.printError("Неправильное количество аргументов");
            return false;
        }
        console.printMessage("Завершение программы...");
        return true;
    }
}
