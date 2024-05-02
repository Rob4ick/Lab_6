package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;

public class RemoveByID extends Command {
    private final CollectionManager collectionManager;

    public RemoveByID(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    public void execution(Request request, Response response){

        int id = request.getId();

        if(collectionManager.ByID(id) == null){
            response.setAnswer("Несуществующий ID");
            return;
        }
        collectionManager.removeByID(id);
        response.setAnswer("Экземпляр удалён");
    }
}
