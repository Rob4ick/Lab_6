package client.commands;

import client.console.Console;
import common.Request;

public class Exit extends Command {
    private final Console console;
    public Exit(Console console) {
        super("exit", "завершает программу");
        this.console = console;
    }

    public boolean execution(String[] args, Request request){
        if (args.length != 1){
            console.printError("Неправильное количество аргументов");
            return false;
        }
        console.printMessage("Завершение программы...");
        return true;
    }
}
