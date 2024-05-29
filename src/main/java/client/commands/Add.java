package client.commands;

import common.Request;
import common.obj.HumanBeing;
import client.utilities.Ask;
import client.console.Console;

public class Add extends Command {
    private final Console console;

    public Add(Console console) {
        super("add", "добавляет новый элемент в коллекцию");
        this.console = console;
    }

    public boolean execution(String[] args, Request request) {
        if (args.length != 1) {
            console.printError("Неправильное количество аргументов");
            return false;
        }
        console.printMessage("Создание нового экземпляра:");
        HumanBeing person = Ask.askHumanBeing(console);

        request.setCommandName("add");
        request.setPerson(person);

        return true;
    }
}
