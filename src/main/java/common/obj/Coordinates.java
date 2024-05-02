package common.obj;

import common.exeptions.CoordinatesExeption;

import java.io.Serializable;

public class Coordinates implements Validable, Serializable {
    private int x;
    private int y; //Максимальное значение поля: 943

    public Coordinates(int x, int y) throws CoordinatesExeption {
        this.x = x;
        if(y >= 944)
            throw new CoordinatesExeption();
        this.y = y;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    public Coordinates(String s) throws CoordinatesExeption {
        this(Integer.parseInt(s.split("::")[0]), Integer.parseInt(s.split("::")[1]));
    }

    public String toCSV(){
        return x + "::" + y;
    }

    @Override
    public String toString() {
        return x + ";" + y;
    }

    @Override
    public boolean validate() {
        return y < 977;
    }
}