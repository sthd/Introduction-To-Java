package Intro;

public class ParkingLot {

    protected float price;
    protected float cash;
    protected float expectedCash;
    protected int bikeNumber=0;
    protected SizeableVehicleStorage parking;


    ParkingLot(int size, float price) {
        this.parking = new SizeableVehicleStorage(size);
        this.price = price;

    }

    public boolean enter(Vehicle v, float expectedStay){
        try{
            this.parking.put(v, expectedStay);
            this.expectedCash+=expectedStay*this.price; ///return to here
            if ( v.changeTires() == 2){
                this.bikeNumber++;
            }
        }

        catch (StorageError e){
            System.out.println("There is no space for you");
            return false;
        }
        return true;

    }

    public boolean exit(Vehicle v){
        if(!this.parking.containsKey(v)) return false;
        float value = (float)this.parking.get(v);
        if (this.parking.get(v) != null){
            this.expectedCash-= value*this.price;
            this.cash+=value;
            if ( v.changeTires() == 2){
                this.bikeNumber--;
            }
            this.parking.remove(v);
            return true;
        }
        else{
            return false;
        }

    }

    public float getBalance(){
        return this.cash;
    }

    public float getExpectedRevenue(){
        return this.expectedCash;
    }

    public float countBikes(){
        return this.bikeNumber;
    }


    public static void main(String[] args){
        ParkingLot parkingLot = new ParkingLot(2, 5);
        Car c = new Car(8, "WV", "Orange", 40);
        Motorcycle m = new Motorcycle(5, "AR", "Black", 10);
        Truck t = new Truck(20, "BMW", "Gray", 60);

        parkingLot.enter(c,1); //returns true
        parkingLot.getExpectedRevenue(); // 5
        parkingLot.getBalance(); //

        parkingLot.enter(m, 2);
        parkingLot.enter(t, 3);
        parkingLot.exit(c); // returns true
        parkingLot.getExpectedRevenue(); // 15
        parkingLot.getBalance(); //5
        parkingLot.countBikes();

    }
}
