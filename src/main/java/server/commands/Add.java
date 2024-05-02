package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;
import common.obj.HumanBeing;

public class Add extends Command{
    private final CollectionManager collectionManager;
    public Add(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execution(Request request, Response response) {

        HumanBeing person = request.getPerson();
        person.setId(collectionManager.getFreeId());
        collectionManager.add(person);

        response.setAnswer("Экземпляр успешно добавлен");
    }
}
