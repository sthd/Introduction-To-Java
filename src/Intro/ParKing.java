package Intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParKing {

    ParKing(){
        this.parkingLotList = new ArrayList<>();
    }

    List<ParkingLot> parkingLotList;

    void addLot(ParkingLot p) {
        this.parkingLotList.add(p);
    }

    float getBalancex() {
       return this.parkingLotList.stream().map(x -> x.getBalance() ).reduce((float)0, (a, b) -> a + b);
    }
    float getRevenue() {
        return this.parkingLotList.stream().map(x -> x.getExpectedRevenue() ).reduce((float)0, (a, b) -> a + b);
    }

    long countVehicles(){
        //all parkinglots/ all vehicles in them.
        return this.parkingLotList.stream().map(x -> x.countVehicles()).reduce(Long.valueOf(0), (a, b) -> a + b);
    }

    public static void main (String[] args){

        ParKing park = new ParKing() ;

        SpacePort spacePort = new SpacePort(4, 4) ;

        Car car = new Car(8,"WV", "Orange", 40);
        Motorcycle motor = new Motorcycle(5, "AR", "Black", 10) ;
        CargoShip cargoShip = new CargoShip(2, "ET" ,"Purple",1000,3);
        DeathStar deathStar= new DeathStar(2, "TE","Green", 1000) ;

        spacePort.enter (car,1);//true
        spacePort.enter (motor,1);// true
        spacePort.enter (cargoShip,1); // true
        spacePort.enter (deathStar,1); // true

        park.addLot(spacePort);
        //park.countSpaceship() ;// 2
        System.out.println(park.countVehicles() );//2

        ParkingLot parkinglot = new ParkingLot(3,5);
        Truck truck = new Truck(20, "BMW", "Gray", 60) ;
        parkinglot.enter(car,1); // false
        parkinglot.enter(truck,1); // true
        parkinglot.enter(deathStar, 1); // false


        park.addLot(parkinglot) ;
        //park.countSpaceShip(); // 2
        park.countVehicles() ;//3
    }

}
