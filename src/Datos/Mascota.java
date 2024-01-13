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

    public String getName(){
        return this.name;
    }
    
    public float getPrecio(){
        return this.cost;
    }

}
