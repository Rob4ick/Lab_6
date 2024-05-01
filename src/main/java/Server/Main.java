package Server;

import Server.commands.*;
import Server.managers.CollectionManager;
import Server.managers.DumpManager;
import client.CommandProcessor;
import client.StandartConsole;
import client.commandHandler;

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

            commandProcessor.addCommand("help", new Help(console, commandProcessor));
            commandProcessor.addCommand("info", new Info(console, collectionManager));
            commandProcessor.addCommand("show", new Show(console, collectionManager));
            commandProcessor.addCommand("add", new Add(console, collectionManager));
            commandProcessor.addCommand("update", new UpdateID(console, collectionManager));
            commandProcessor.addCommand("remove_by_id", new RemoveByID(console, collectionManager));
            commandProcessor.addCommand("clear", new Clear(console, collectionManager));
            commandProcessor.addCommand("save", new Save(console, collectionManager));
            commandProcessor.addCommand("execute_script", new ExecuteScript(console, collectionManager));
            commandProcessor.addCommand("exit", new Exit(console, collectionManager));
            commandProcessor.addCommand("add_if_max", new AddIfMax(console, collectionManager));
            commandProcessor.addCommand("remove_greater", new RemoveGreater(console, collectionManager));
            commandProcessor.addCommand("history", new History(console, commandProcessor));
            commandProcessor.addCommand("count_by_mood", new CountByMood(console, collectionManager));
            commandProcessor.addCommand("filter_less_than_weapon_type", new FilterLessThanWeaponType(console, collectionManager));
            commandProcessor.addCommand("print_field_descending_weapon_type", new PrintFieldDescendingWeaponType(console, collectionManager));

            new commandHandler(console, commandProcessor).manualMode();
        }catch(NullPointerException e) {
            console.printError("Несуществующая переменная окружения!!!\nСоздаёте переменную с именем \"javaFile\" и положите в неё путь к файлу. И запустите программу ещё раз =)");
        }catch (NoSuchElementException ignored){}
    }
}