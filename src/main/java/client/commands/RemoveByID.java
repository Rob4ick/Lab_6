package client.commands;

import client.Ask;
import client.console.Console;
import common.Request;

public class RemoveByID extends Command {
    private final Console console;
    public RemoveByID(Console console) {
        super("remove_by_ID", "удалить элемент из коллекции по его ID");
        this.console = console;
    }
    public boolean execution(String[] args, Request request){
        if (args.length != 2){
            console.printError("Неправильное количество аргументов");
            return false;
        }

        int id = -1;
        try{
            id = Integer.parseInt(args[1].trim());
        }catch(NumberFormatException e){
            console.printError("ID не распознан");
            return false;
        }

        request.setCommandName("remove_by_id");
        request.setId(id);

        return true;
    }
}
