package client.commands;

import client.CommandProcessor;
import client.console.Console;
import common.Request;

public class History extends Command {
    private final Console console;
    private final CommandProcessor commandProcessor;
    public History(Console console, CommandProcessor commandProcessor){
        super("history", "выводит последние 5 команд (без их аргументов)");
        this.console = console;
        this.commandProcessor = commandProcessor;
    }

    public boolean execution(String[] args, Request request){
        if(args.length != 1){
            console.printError("Неправильное количество аргументов");
            return false;
        }
        else{
            if (commandProcessor.getHistory().isEmpty())
                console.println("Это первая команда");
            else {
                for (int i = Math.max(commandProcessor.getHistory().size() - 5, 0); i < commandProcessor.getHistory().size(); ++i)
                    console.print(commandProcessor.getHistory().get(i) + " ");
                console.print("\n");
            }
            request.setCommandName("history");
            return true;
        }
    }
}