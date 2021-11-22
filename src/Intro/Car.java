package Intro;

import java.util.*;

class Car extends Vehicle {
    Car(float GPK, String Make, String Colour , float TankSize ){
        super(GPK, Make, Colour , TankSize );
    }
    public int changeTires(){
        return 4;
    }

}