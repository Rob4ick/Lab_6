package client.commands;

import client.Ask;
import client.console.Console;
import common.Request;

public class UpdateById extends Command {
    private final Console console;
    public UpdateById(Console console){
        super("update_by_id", "обновляет значение элемента коллекции, id которого равен заданному");
        this.console = console;
    }

    public boolean execution(String[] args, Request request){
        if (args.length != 2){
            console.printError("Неправильное количество аргументов");
            return true;
        }
        try{

            request.setId(Integer.parseInt(args[1].trim()));
            request.setPerson(Ask.askHumanBeing(console));
            request.setCommandName("update_by_id");

            return true;
        }catch(NumberFormatException e){
            console.printError("ID не распознан");
            return false;
        }
    }
}
