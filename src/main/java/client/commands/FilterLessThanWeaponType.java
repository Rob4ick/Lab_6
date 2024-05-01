package client.commands;

import common.Request;
import common.obj.HumanBeing;
import common.obj.WeaponType;
import client.Console;

public class FilterLessThanWeaponType extends Command {
    private final Console console;
    public FilterLessThanWeaponType(Console console) {
        super("filter_less_than_weapon_type", "выводит элементы, значение поля weaponType которых меньше заданного");
        this.console = console;
    }

    public boolean execution(String[] args, Request request){
        if (args.length != 2){
            console.printError("Неправильное количество аргументов");
            return false;
        }
        try {

            request.setWeaponType(WeaponType.valueOf(args[1].toUpperCase()));
            request.setCommandName("filter_less_than_weapon_type");

        }catch (IllegalArgumentException e){
            console.printError("Некорректный тип оружия!!!!");
            return false;
        }
        return true;
    }
}
