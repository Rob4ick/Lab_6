package server.managers;

import server.commands.Command;


import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private final Map<String, Command> commands = new HashMap<>();

    public void addCommand(Command command){
        commands.put(command.getName(), command);
    }

}
