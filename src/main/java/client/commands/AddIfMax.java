package client.commands;

import common.Request;
import common.obj.HumanBeing;
import client.Ask;
import client.console.Console;

public class AddIfMax extends Command {
    private final Console console;;
    public AddIfMax(Console console) {
        super("add_if_max", "добавляет новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        this.console = console;
    }

    public boolean execution(String[] args, Request request){
        if (args.length != 1){
            console.printError("Неправильное количество аргументов");
            return false;
        }

        console.printMessage("Создание нового экземпляра");
        HumanBeing person = Ask.askHumanBeing(console);

        request.setCommandName("add_if_max");
        request.setPerson(person);

        return true;
    }
}