package Intro;

class Truck extends Vehicle {
    Truck(float GPK, String Make, String Colour , float TankSize ) {
        super(GPK, Make, Colour, TankSize);
    }

    public int changeTires(){
        return 8;
    }


}