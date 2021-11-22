package Intro;

import java.util.*;


public class SizeableVehicleStorage<K,V> extends HashMap<K,V> {


    protected int maxSize;

    SizeableVehicleStorage(int maxSize) {
        //super();
        this.maxSize = maxSize;
    }


    public V put(K key, V value){
        if (this.maxSize > this.size() || (this.maxSize == this.size() && super.get(key) != null)){
            super.put(key,value);
            return value;
        }

        throw new StorageError();

    }
    public V putIfAbsent(K key, V value){
        if (this.maxSize > this.size()){
            super.putIfAbsent(key,value);
        }

        throw new StorageError();

    }
    public void putAll(Map<? extends K,? extends V> m){


        if (this.maxSize - this.size() >= m.size()){
            super.putAll(m);
        }

        throw new StorageError();

    }



    public static void main(String[] args){

        SizeableVehicleStorage<Integer, Vehicle> svs = new SizeableVehicleStorage<Integer, Vehicle>(2);
        Car c = new Car(8, "WV", "Orange", 40);
        Motorcycle m = new Motorcycle(5, "AR", "Black", 10);
        Truck t = new Truck(20, "BMW", "Gray", 60);

        svs.put(1, c);
        svs.put(4, m);
        svs.put(42, t); //storage error
    }
}
