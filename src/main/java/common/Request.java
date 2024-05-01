package common;

import common.obj.HumanBeing;
import common.obj.Mood;
import common.obj.WeaponType;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {
    @Serial
    private static final long serialVersionUID = 777L;

    private String commandName = null;
    private HumanBeing person = null;
    private int id = 0;
    private WeaponType weaponType = null;
    private Mood mood = null;

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public void setPerson(HumanBeing person) {
        this.person = person;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public String getCommandName(String clear) {
        return commandName;
    }

    public HumanBeing getPerson() {
        return person;
    }

    public int getId() {
        return id;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public Mood getMood() {
        return mood;
    }
}