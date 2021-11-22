package Intro;

import java.util.*;

abstract class Vehicle {

    private String Colour = "Colour";
    private String Make = "Make";
    private float GPK = 0;
    private float Gas = 0;
    private float TankSize = 0;
    //private int wheels = 0;

    //String by reference?
    public Vehicle(float GPK, String Make, String Colour , float TankSize ){
        this.Colour = Colour;
        this.Make = Make;
        this.GPK = GPK;
        this.Gas = TankSize;
        this.TankSize = TankSize;
    }

    public String toString(){
        String details = this.Colour + " " + this.Make + " " + this.Gas + "/" + this.TankSize;
        return details;
    }

    public boolean drive(float distance){

        if ( this.Gas - distance*this.GPK >= 0){
            this.Gas -= distance*this.GPK;
            return true;
        }

        return false;
    }

    public float fillGas(float price){

        float neededGas = this.TankSize - this.Gas;
        this.Gas = this.TankSize;
        return price * neededGas;

    }

    public abstract int changeTires();





    public static void main(String[] args){




    }





}