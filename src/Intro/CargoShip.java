package Intro;

public class CargoShip extends SpaceShip {

    protected float price;
    protected SizeableVehicleStorage CargoStorage;

    CargoShip(float GPK, String Make, String Colour , float TankSize , float price, int maxSize) {
        super(GPK, Make, Colour, TankSize);
        this.CargoStorage = new  SizeableVehicleStorage(maxSize);
        this.price = price;


    }



    public String toString(){
        String details = this.Colour + " " + this.Make + " " + this.Gas + "/" + this.CargoStorage.;
        return details;
    }


}


