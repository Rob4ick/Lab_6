package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;
import common.obj.HumanBeing;

public class AddIfMax implements Executable{

    private final CollectionManager collectionManager;
    public AddIfMax(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execution(Request request, Response response){

        HumanBeing person = request.getPerson();
        person.setId(collectionManager.getFreeId());

        if(person.getWeaponType().isLessTo(collectionManager.getMax().getWeaponType())) {
            collectionManager.add(person);
            response.setAnswer("Экземпляр успешно добавлен");
        }
        else{
            response.setAnswer("Элемент не является наибольшим в коллекции. Экземпляр не добавлен");
        }
    }
}