package client;

import client.commands.*;
import client.console.StandartConsole;
import client.utilities.CommandHandler;
import client.utilities.CommandProcessor;

public class Client {
    public static void main(String[] args) {

        var console = new StandartConsole();

        var commandProcessor = new CommandProcessor();

        commandProcessor.addCommand(new Help(console, commandProcessor));
        commandProcessor.addCommand(new Info(console));
        commandProcessor.addCommand(new Show(console));
        commandProcessor.addCommand(new Add(console));
        commandProcessor.addCommand(new UpdateById(console));
        commandProcessor.addCommand(new RemoveByID(console));
        commandProcessor.addCommand(new Clear(console));
        commandProcessor.addCommand(new ExecuteScript(console));
        commandProcessor.addCommand(new Exit(console));
        commandProcessor.addCommand(new AddIfMax(console));
        commandProcessor.addCommand(new RemoveGreater(console));
        commandProcessor.addCommand(new History(console, commandProcessor));
        commandProcessor.addCommand(new CountByMood(console));
        commandProcessor.addCommand(new FilterLessThanWeaponType(console));
        commandProcessor.addCommand(new PrintFieldDescendingWeaponType(console));

        try{new CommandHandler(console, commandProcessor).manualMode();}catch (CommandHandler.ServerException ignored){}
    }
}

