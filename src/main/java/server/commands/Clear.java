package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;

public class Clear extends Command {
    private final CollectionManager collectionManager;
    public Clear(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execution(Request request, Response response) {

        collectionManager.clearCollection();
        response.setAnswer("Коллекция очищена");

    }
}