package client.commands;

import client.console.Console;
import common.Request;

public class Show extends Command {
    private Console console;
    public Show(Console console) {
        super("show", "выводит все элементы коллекции");
        this.console = console;
    }

    public boolean execution(String[] args, Request request){
        if (args.length != 1){
            console.printError("Неправильное количество аргументов");
            return true;
        }

        request.setCommandName("show");

        return true;
    }
}
