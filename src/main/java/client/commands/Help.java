package client.commands;

import client.CommandProcessor;
import client.console.Console;
import common.Request;

public class Help extends Command {
    private final Console console;
    private final CommandProcessor commandProcessor;
    public Help(Console console, CommandProcessor commandProcessor) {
        super("help", "выводит справку по доступным командам ");
        this.console = console;
        this.commandProcessor = commandProcessor;
    }

    public boolean execution(String[] args, Request request){
        if (args.length != 1){
            console.printError("Неправильное количество аргументов");
            return true;
        }

        request.setCommandName("help");
        commandProcessor.getCommands().values().forEach(command -> {console.println(command.getName() + " " + command.getDescription());});

        return true;
    }
}
