package client.commands;

import client.Console;
import common.Request;

import java.io.IOException;

public class Save extends Command {
    private final Console console;
    public Save(Console console) {
        super("save", "сохраняет коллекцию в файл");
        this.console = console;
    }
    public boolean execution(String[] args, Request request){
        if (args.length != 1){
            console.printError("Неправильное количество аргументов");
            return false;
        }
        request.setCommandName("save");
        return true;
    }
}
