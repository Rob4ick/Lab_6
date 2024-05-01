package Server.commands;

import Common.Command;
import Server.managers.CollectionManager;
import client.Console;

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
