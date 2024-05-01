package server.commands;

import server.managers.CollectionManager;
import common.obj.HumanBeing;

public class Add implements Executable {
    private final CollectionManager collectionManager;
    public Add(CollectionManager collectionManager) {
        this.console = console;
        this.collectionManager = collectionManager;
    }

    public boolean execution(String[] args) {
        if (args.length != 1) {
            console.printError("Неправильное количество аргументов");
            return false;
        }
        console.printMessage("Создание нового экземпляра");
        HumanBeing person = Ask.askHumanBeing(console, collectionManager.getFreeId());
        collectionManager.add(person);
        console.printMessage("Экземпляр успешно добавлен");
        return true;
    }
}
