package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;
import common.obj.HumanBeing;

public class RemoveGreater extends Command {
    private final CollectionManager collectionManager;
    public RemoveGreater(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public void execution(Request request, Response response){

        HumanBeing person = request.getPerson();
        person.setId(collectionManager.getFreeId());

        int n = collectionManager.getCollection().size();
        collectionManager.getCollection().removeIf(x -> x.getWeaponType().isLessTo(person.getWeaponType()));
        n -= collectionManager.getCollection().size();
        response.setAnswer("Из коллекции было удалено " + n + "элемент(ов)");

    }
}