package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;
import common.obj.HumanBeing;
import common.obj.WeaponType;

public class FilterLessThanWeaponType implements Executable {
    private final CollectionManager collectionManager;
    public FilterLessThanWeaponType(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execution(Request request, Response response){

        StringBuilder s = new StringBuilder();

        WeaponType weaponType = request.getWeaponType();
        for (HumanBeing hb : collectionManager.getCollection()) {
            if (hb.getWeaponType().isLessTo(weaponType))
                s.append(hb);
        }

        if(s.isEmpty())
            response.setAnswer("Нету меньшего WeaponType");
        else
            response.setAnswer(String.valueOf(s));

    }
}
