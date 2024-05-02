package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;

public class Show extends Command{
    private CollectionManager collectionManager;
    public Show(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execution(Request request, Response response){

        response.setAnswer(collectionManager.toString());

    }
}