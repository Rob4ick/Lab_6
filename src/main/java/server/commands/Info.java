package server.commands;

import common.Request;
import common.Response;
import server.managers.CollectionManager;

import java.time.LocalDateTime;

public class Info extends Command {
    private CollectionManager collectionManager;

    public Info(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void execution(Request request, Response response) {

        StringBuilder s = new StringBuilder();

        String type = collectionManager.getCollection().getClass().toString();
        String size = collectionManager.getSize() + "";
        LocalDateTime lastInitTime = collectionManager.getLastInitTime();
        String lastInitTimeString;
        String lastSaveTimeString;
        if (lastInitTime == null)
            lastInitTimeString = "Коллекцию ещё не инициализировали";
        else
            lastInitTimeString = "Последнее время инициализации: " + lastInitTime;
        LocalDateTime lastSaveTime = collectionManager.getLastSaveTime();
        if (lastSaveTime == null) {
            lastSaveTimeString = "Коллекцию ещё не сохраняли";
        } else {
            lastSaveTimeString = "Последнее время сохранения: " + lastSaveTime;
        }

        s.append("Информация о коллекции:\n");
        s.append("Тип: ").append(type).append('\n');
        s.append("Размер коллекции: ").append(size).append('\n');
        s.append(lastInitTimeString).append('\n');
        s.append(lastSaveTimeString).append('\n');
        response.setAnswer(String.valueOf(s));
    }
}