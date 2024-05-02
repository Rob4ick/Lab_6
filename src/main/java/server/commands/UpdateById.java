package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;

public class UpdateById implements Executable {
    private final CollectionManager collectionManager;
    public UpdateById(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public void execution(Request request, Response response){
        int id = request.getId();
        if(collectionManager.ByID(id) == null){
            response.setAnswer("Несуществующий ID");
            return;
        }

        collectionManager.removeByID(id);
        request.getPerson().setId(id);
        collectionManager.add(request.getPerson());
        response.setAnswer("Значения элемента обновлены");

    }
}