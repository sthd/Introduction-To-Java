package Intro;

public class CargoShip extends SpaceShip {

    //protected SizeableVehicleStorage CargoStorage;
    protected ParkingLot CargoParking;

    protected float price;
    protected int maxSize;



    CargoShip(float GPK, String Make, String Colour , int maxSize, float price) {
        super(GPK, Make, Colour, 0);

        //this.CargoStorage = new  SizeableVehicleStorage(maxSize);
        this.CargoParking = new ParkingLot(maxSize,price);
        //this.price = price;
        this.maxSize = maxSize;

    }


    public String toString(){
        String details = this.Colour + " " + this.Make + " "  + this.CargoParking.parking.size() + "/" + this.maxSize;
        return details;
    }

    boolean enter(Vehicle v, float expectedTime){
        return this.CargoParking.enter(v, expectedTime);
    }

    boolean exit(Vehicle v){
        if (this.CargoParking.exit(v)) return true;
        else{
            throw new VehicleNotPresentException();
        }
    }

    public int changeTires(){
        return 0;
    }

}


