/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author user
 */
public class Player {
    private double Money;
    private String ID;
    private ArrayList<Plant> ULPlant;
    private ArrayList<Vehicle> ULVehicle;
    private ArrayList<Fertilizer> ULFertilizer;
    
    public Player(){
        Money=100;
        ID="Player";
        ULPlant=new ArrayList<Plant>();
        ULVehicle=new ArrayList<Vehicle>();
        ULFertilizer=new ArrayList<Fertilizer>();
    }
    public void ChangeID(String nama){
        ID=nama;
    }
    public void beli(Plant P){
        Money=Money-P.hargabibit();
    }
    public void addOb(Plant OB){
       ULPlant.add(OB);
    }
    public void addOb(Vehicle OB){
       ULVehicle.add(OB);
    }
    public void addOb(Fertilizer OB){
       ULFertilizer.add(OB);
    }
}
