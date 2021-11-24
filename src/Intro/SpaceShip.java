package Intro;
import java.util.*;

abstract class SpaceShip extends Vehicle{
    SpaceShip(float GPK, String Make, String Colour , float TankSize ) {
        super(GPK, Make, Colour, TankSize);

    }

    public String toString(){
        String details = this.Colour + " " + this.Make;
        return details;
    }

    boolean liftoff(float distance){
        super.drive(distance);
    }

    void shoot(){
        System.out.println("Buck!");
    }


}
