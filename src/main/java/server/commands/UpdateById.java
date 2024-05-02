package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;

public class UpdateById extends Command {
    private final CollectionManager collectionManager;
    public UpdateById(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    public void execution(Request request, Response response){
        int id = request.getId();
        if(collectionManager.ByID(id) == null){
            response.setAnswer("\u001B[31m" + "Несуществующий ID" + "\u001B[0m");
            return;
        }

        collectionManager.removeByID(id);
        request.getPerson().setId(id);
        collectionManager.add(request.getPerson());
        response.setAnswer("Значения элемента обновлены");

    }
}