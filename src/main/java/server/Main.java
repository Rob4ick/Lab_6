/*package server;

import server.commands.*;
import server.managers.CollectionManager;
import server.managers.DumpManager;
import client.CommandProcessor;
import client.console.StandartConsole;
import client.СommandHandler;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        var console = new StandartConsole();

        try {
            String filePath = System.getenv("javaFile");
            DumpManager dm = new DumpManager(filePath);
            CollectionManager collectionManager = new CollectionManager(dm);

            try {
                collectionManager.loadCollection();
                console.printMessage("Успешная инициализация коллекции");
            }catch (FileNotFoundException e) {
                console.printError("Файла не существует!!!");
            }
            var commandProcessor = new CommandProcessor();

            commandProcessor.addCommand("info", new Info(collectionManager));
            commandProcessor.addCommand("show", new Show(collectionManager));
            commandProcessor.addCommand("add", new Add(collectionManager));
            commandProcessor.addCommand("update", new UpdateById(collectionManager));
            commandProcessor.addCommand("remove_by_id", new RemoveByID(collectionManager));
            commandProcessor.addCommand("clear", new Clear(collectionManager));
            commandProcessor.addCommand("save", new Save(collectionManager));
           commandProcessor.addCommand("add_if_max", new AddIfMax(console, collectionManager));
            commandProcessor.addCommand("remove_greater", new RemoveGreater(collectionManager));
            commandProcessor.addCommand("count_by_mood", new CountByMood(collectionManager));
            commandProcessor.addCommand("filter_less_than_weapon_type", new FilterLessThanWeaponType(collectionManager));
            commandProcessor.addCommand("print_field_descending_weapon_type", new PrintFieldDescendingWeaponType(collectionManager));

            new СommandHandler(console, commandProcessor).manualMode();
        }catch(NullPointerException e) {
            console.printError("Несуществующая переменная окружения!!!\nСоздаёте переменную с именем \"javaFile\" и положите в неё путь к файлу. И запустите программу ещё раз =)");
        }catch (NoSuchElementException ignored){}
    }
}
*/