package client.commands;

import common.Request;
import common.obj.HumanBeing;
import client.Ask;
import client.console.Console;

public class RemoveGreater extends Command {
    private final Console console;
    public RemoveGreater(Console console){
        super("remove_greater", "удаляет из коллекции все элементы, превышающий заданный");
        this.console = console;
    }

    public boolean execution(String[] args, Request request){
        if (args.length != 1){
            console.printError("Неправильное количество аргументов");
            return false;
        }

        HumanBeing person = Ask.askHumanBeing(console);

        request.setPerson(person);

        return true;
    }
}