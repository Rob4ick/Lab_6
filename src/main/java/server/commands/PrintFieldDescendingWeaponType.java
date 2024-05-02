package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;
import common.obj.HumanBeing;

public class PrintFieldDescendingWeaponType implements Executable {
    private final CollectionManager collectionManager;
    public PrintFieldDescendingWeaponType(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execution(Request request, Response response){

        StringBuilder s = new StringBuilder();

        for(HumanBeing hb : collectionManager.getCollection())
            s.append(hb.getWeaponType()).append(" ");

        response.setAnswer(String.valueOf(s));

    }
}