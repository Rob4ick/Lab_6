package client.commands;

import client.console.Console;
import common.Request;

public class ExecuteScript extends Command {
    private final Console console;
    public ExecuteScript(Console console) {
        super("execute_script", "исполняет скрипт из указанного файла");
        this.console = console;
    }

    public boolean execution(String[] args, Request request){
        if (args.length != 2){
            console.printError("Неправильное количество аргументов");
            return false;

        }

        return true;
    }
}
