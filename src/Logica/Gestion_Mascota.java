/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Datos.Mascota;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Gestion_Mascota {
    
    private ArrayList<Mascota> Mascotas = new ArrayList<>();
    private String rutaArchivo = "Pets.txt";

    public Gestion_Mascota(){
        
        long tam;
        try {
            // Crear un objeto File que representa el archivo
            File archivo = new File(rutaArchivo);

            // Verificar si el archivo ya existe
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado con éxito: " + archivo.getName());

            } else {
                System.out.println("El archivo ya existe.");

            }

            tam = archivo.length();
            if(tam == 0){
                System.out.println("vacio");
            }else{
                Mascota m;
                String q;
                int[] n = new int[3];
                for(int i = 0; i < contarLineasEnArchivo(rutaArchivo); i ++){
                    q = obtenerLineaDeArchivo(rutaArchivo, i + 1);
                    n[0] = Integer.parseInt(obtenerDato(q, 3));
                    n[1] = Integer.parseInt(obtenerDato(q, 4));
                    n[2] = Integer.parseInt(obtenerDato(q, 5));
                    m = new Mascota(obtenerDato(q, 1), obtenerDato(q, 2), n, Float.parseFloat(obtenerDato(q, 6)), obtenerDato(q, 7), obtenerDato(q, 8));
                    Mascotas.add(m);
                    m = null;
                }
            }
            

        } catch (IOException e) {
            System.out.println("Se produjo un error al crear el archivo: " + e.getMessage());
            e.printStackTrace();
        }

        

    }
    
    public void registroMascota(String name, String breed, int[] services, float cost, String nameHuman, String movilHuman){
    
        Mascota nuevaMascota = new Mascota(name, breed, services, cost, nameHuman, movilHuman);
        this.Mascotas.add(nuevaMascota);

        try{
            FileWriter Archivo = new FileWriter(rutaArchivo);
            BufferedWriter bufferArchivo = new BufferedWriter(Archivo);
            
            Mascota t;
            for(int i = 0; i < Mascotas.size(); i++){
                t = Mascotas.get(i);
                int[] d = new int[3];
                d = t.getService();
                String tem = t.getName() + "|" + t.getBreed() + "|" + d[0] + "|" + d[1] + "|" + d[2] + "|" + t.getPrecio() + "|" + t.getNameHuman() + "|" + t.getMovilHuman(); 
                bufferArchivo.write(tem);
                bufferArchivo.newLine();
                t = null;
            }

            //bufferArchivo.newLine();
            //String wri = name + "|" + breed + "|" + services[0] + "|" + services[1] + "|" + services[2] + "|" + cost + "|" + nameHuman + "|" + movilHuman; 

            //bufferArchivo.write(wri);

            bufferArchivo.close();
        
        }catch(IOException e){

        }

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

    public int contarLineasEnArchivo(String ruta) {
        int numeroDeLineas = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            // Leer el archivo línea por línea y contar las líneas
            while (br.readLine() != null) {
                numeroDeLineas++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return numeroDeLineas;
    }

    public String obtenerLineaDeArchivo(String ruta, int numeroDeFila) {
        String linea = null;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            // Leer el archivo línea por línea hasta alcanzar la fila deseada
            for (int i = 1; i <= numeroDeFila; i++) {
                linea = br.readLine();
                if (linea == null) {
                    // Se alcanzó el final del archivo antes de llegar a la fila deseada
                    System.out.println("La fila especificada no existe en el archivo.");
                    return null;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return linea;
    }

    public String obtenerDato(String cadena, int numeroDato) {
        // Dividir la cadena en partes usando "|" como delimitador
        String[] partes = cadena.split("\\|");

        // Verificar si el número de dato especificado es válido
        if (numeroDato >= 1 && numeroDato <= partes.length) {
            // Restar 1 al índice porque los arrays en Java comienzan desde 0
            return partes[numeroDato - 1];
        } else {
            System.out.println("Número de dato no válido.");
            return null;
        }
    }

    
}