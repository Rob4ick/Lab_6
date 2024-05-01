package Server.commands;

import client.commands.Command;
import Server.managers.CollectionManager;
import common.obj.HumanBeing;
import client.Ask;
import client.Console;

public class AddIfMax extends Command {
    private final Console console;
    private final CollectionManager collectionManager;
    public AddIfMax(Console console, CollectionManager collectionManager) {
        super("add_if_max", "добавляет новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    public boolean execution(String[] args){
        if (args.length != 1){
            console.printError("Неправильное количество аргументов");
            return false;
        }
        console.printMessage("Создание нового экземпляра");
        HumanBeing person = Ask.askHumanBeing(console, collectionManager.getFreeId());
        if(person.getWeaponType().isLessTo(collectionManager.getMax().getWeaponType())) {
            collectionManager.add(person);
            console.printMessage("Экземпляр успешно добавлен");
        }
        else{
            console.printMessage("Элемент не является наибольшим в коллекции. Экземпляр не добавлен");
        }
        return true;
    }
}
