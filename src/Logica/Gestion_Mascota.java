/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Mascota;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Gestion_Mascota {
    
    private ArrayList<Mascota> Mascotas = new ArrayList<>();
    
    public Gestion_Mascota(){
        
    }
    
    public void registroMascota(String name, String breed, int[] services, float cost, String nameHuman, String movilHuman){
    
        Mascota nuevaMascota = new Mascota(name, breed, services, cost, nameHuman, movilHuman);
        this.Mascotas.add(nuevaMascota);
    }
    
    public ArrayList<Mascota> listadoMascota(){

        return this.Mascotas;
        
    }
    
    public Mascota buscarMascota(String name){
        int i;
        for(i = 0; i < this.Mascotas.size(); i++){

            if(this.Mascotas.get(i).getName().equals(name)){
                return this.Mascotas.get(i);
            }

        }
        
        return null;
    }
    
    public float gananciaDia(){
        int i;
        float precio = 0;
        for(i = 0; i < this.Mascotas.size(); i++ ){
            precio += this.Mascotas.get(i).getPrecio();
        }

        return precio;
    }
}