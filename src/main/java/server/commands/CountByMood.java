package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;
import common.obj.HumanBeing;
import common.obj.Mood;

public class CountByMood extends Command {
    private final CollectionManager collectionManager;
    public CountByMood(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    public void execution(Request request, Response response){

            Mood mood = request.getMood();

            int counter = 0;
            for (HumanBeing hb : collectionManager.getCollection()) {
                if (hb.getMood().equals(mood))
                    counter++;
            }

            response.setAnswer(String.valueOf(counter));

    }
}
