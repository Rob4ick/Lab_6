package client.commands;

import common.Request;
import common.obj.Mood;
import client.console.Console;

public class CountByMood extends Command {
    private final Console console;
    public CountByMood(Console console){
        super("count_by_mood", "выводит количество элементов, значение поля mood которых равно заданному");
        this.console = console;
    }
    public boolean execution(String[] args, Request request) {
        try {

            if (args.length != 2) {
                console.printError("Неправильное количество аргументов");
            }

            request.setMood(Mood.valueOf(args[1].toUpperCase()));
            request.setCommandName("count_by_mood");

        }catch (IllegalArgumentException e) {

            console.printError("Некорректный ввод!!!");
            return false;

        }
        return true;
    }
}
