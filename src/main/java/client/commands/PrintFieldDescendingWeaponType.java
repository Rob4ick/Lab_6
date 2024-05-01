package client.commands;

import common.Request;
import common.obj.HumanBeing;
import client.Console;

public class PrintFieldDescendingWeaponType extends Command {
    private final Console console;
    public PrintFieldDescendingWeaponType(Console console) {
        super("print_field_descending_weapon_type", "выводит значение поля weaponType всех элементов в порядке убывания id");
        this.console = console;
    }

    public boolean execution(String[] args, Request request){
        if (args.length != 1){
            console.printError("Неправильное количество аргументов");
            return false;
        }

        request.setCommandName("print_field_descending_weapon_type");

        return true;
    }
}
