package server.managers;

import server.commands.Command;


import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private final Map<String, Command> commands = new HashMap<>();

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void addCommand(String commandName, Command command){
        commands.put(commandName, command);
    }

}
