package common.obj;

import common.exeptions.CoordinatesExeption;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HumanBeing implements Validable, Serializable {
    @Serial
    private static final long serialVersionUID = 1337L;
    private final int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final boolean realHero;
    private final boolean hasToothpick;
    private final Integer impactSpeed; //Поле не может быть null
    private final WeaponType weaponType; //Поле не может быть null
    private final Mood mood; //Поле не может быть null
    private final Car car; //Поле не может быть null

    public HumanBeing(int id, String name, Coordinates coordinates, LocalDateTime creationDate, boolean realHero, boolean hasToothpick, Integer impactSpeed, WeaponType weaponType, Mood mood, Car car) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }

    public HumanBeing(int id, String name, Coordinates coordinates, boolean realHero, boolean hasToothpick, Integer
            impactSpeed, WeaponType weaponType, Mood mood, Car car){
        this(id, name, coordinates, LocalDateTime.now(), realHero, hasToothpick, impactSpeed, weaponType, mood, car);
    }

    @Override
    public boolean validate() {
        if(id <= 0 ) return false;
        if (name == null || name.isEmpty()) return false;
        if(coordinates == null || !coordinates.validate())return false;
        if(creationDate == null) return false;
        if(weaponType == null) return false;
        return car != null && car.validate();
    }

    public static HumanBeing fromArray(String[] s) throws CoordinatesExeption {
        int id;
        String name;
        Coordinates coordinates;
        LocalDateTime creationDate;
        boolean realHero;
        boolean hasToothPick;
        Integer impactSpeed;
        WeaponType weaponType;
        Mood mood;
        Car car;

        id = Integer.parseInt(s[0]);
        name = s[1];
        coordinates = new Coordinates(s[2]);
        creationDate = LocalDateTime.parse(s[3]);
        realHero = Boolean.parseBoolean(s[4]);
        hasToothPick = Boolean.parseBoolean(s[5]);
        if(s[6].equals("null"))
            impactSpeed = null;
        else
            impactSpeed = Integer.parseInt(s[6]);
        weaponType = WeaponType.valueOf(s[7].toUpperCase());
        mood = Mood.fromString(s[8]);
        car = new Car(s[9]);
        return new HumanBeing(id, name, coordinates, creationDate, realHero, hasToothPick, impactSpeed, weaponType, mood, car);
    }

    public String toCSV(){
        return  id + ";" + name + ";"
                + coordinates.toCSV() + ";"
                + creationDate.format( DateTimeFormatter.ISO_DATE_TIME) + ";"
                + realHero + ";"
                + hasToothpick + ";"
                + impactSpeed + ";"
                + weaponType + ";"
                + mood + ";"
                + car;
    }

    @Override
    public String toString(){
        return "id = " + id + "\n" + "name = " + name + "\n" +
                "coordinates = " + coordinates + "\n" +
                "creationDate = " + creationDate.format( DateTimeFormatter.ISO_DATE_TIME) + "\n" +
                "realHero = " + realHero + "\n" +
                "hasToothpick = " + hasToothpick + "\n" +
                "impactSpeed = " + impactSpeed + "\n" +
                "weaponType = " + weaponType + "\n" +
                "mood = " + mood +"\n" +
                "car = "  + car;
    }

    public Mood getMood() {
        return mood;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }
    public int getCoordinateY() {
        return coordinates.getY();
    }
    public int getCoordinateX() {
        return coordinates.getX();
    }

    public int getId() {
        return id;
    }
}