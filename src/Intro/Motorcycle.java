package Intro;

import java.util.*;

class Motorcycle extends Vehicle {
    Motorcycle(float GPK, String Make, String Colour , float TankSize ) {
        super(GPK, Make, Colour, TankSize);
    }

    public int changeTires(){
        return 2;
    }


}
