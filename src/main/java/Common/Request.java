package Common;

import Common.obj.HumanBeing;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 777L;

    private final String commandName;
    private final HumanBeing person;

    public Request(String commandName, HumanBeing person) {
        this.commandName = commandName;
        this.person = person;
    }

    public String getCommandName() {
        return commandName;
    }
    public HumanBeing getPerson() {
        return person;
    }
}
