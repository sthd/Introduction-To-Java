package Intro;

//float value = (float)this.parking.get(v);

public class SpacePort extends ParkingLot{
    SpacePort(int size, float price) {
        super(size, price);
    }
    void load(Vehicle v, CargoShip c){
        if (! ( (this.parking.containsKey(v)) && (this.parking.containsKey(c)) ) )
            return;
        float expectedTimeVehicle = (float)this.parking.get(v);

        this.cash -= expectedTimeVehicle*this.price*0.5;
        this.exit(v);

        c.CargoParking.enter(v, expectedTimeVehicle);

    }

    void unload(Vehicle v, CargoShip c){
        if (! (c.CargoParking.parking.containsKey(v) && this.parking.containsKey(c)) )
            return;

        float expectedTimeVehicle = (float)c.CargoParking.parking.get(v);

        c.CargoParking.exit(v);

        this.enter(v, (float)(0.5*expectedTimeVehicle) );

    }


    public float getExpectedRevenue(){

        return this.expectedCash;
    }


    public static void main(String[] args){
        SpacePort spacePort = new SpacePort(3,4);
        Car c = new Car(8,"WV", "Orange",40);
        CargoShip cargoShip = new CargoShip(2,"ET","Purple",1000,3);

        spacePort.enter(c,2);
        spacePort.load(c,cargoShip);//does nothing
        spacePort.enter(cargoShip,10);
        spacePort.load(c,cargoShip);//success

        spacePort.getExpectedRevenue();//4
        spacePort.getBalance();//4

        spacePort.unload(c,cargoShip);
        spacePort.getExpectedRevenue();//8
        spacePort.getBalance();//4
    }


}