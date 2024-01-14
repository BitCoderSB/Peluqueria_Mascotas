/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author Carlos
 */
public class Mascota {
    private String name;
    private String breed;
    private int[] service = new int[3];
    private float cost;
    private String nameHuman;
    private String movilHuman;

    // Constructor
    public Mascota(String name, String breed, int[] service, float cost, String nameHuman, String movilHuman) {
        this.name = name;
        this.breed = breed;
        this.service = service;
        this.cost = cost;
        this.nameHuman = nameHuman;
        this.movilHuman = movilHuman;
    }

    
    
    


    // Métodos get

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int[] getService() {
        return service;
    }

    public float getPrecio(){
        return this.cost;
    }

    public String getNameHuman() {
        return nameHuman;
    }

    public String getMovilHuman() {
        return movilHuman;
    }

    // Métodos set

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setService(int[] service) {
        this.service = service;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setNameHuman(String nameHuman) {
        this.nameHuman = nameHuman;
    }

    public void setMovilHuman(String movilHuman) {
        this.movilHuman = movilHuman;
    }

}
