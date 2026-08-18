package umariana.bioparquepasto;

import java.util.*;

public class Habitat {

    private int capacidadMax;
    private double temperatura;
    private String nombreHabitat;
    private ArrayList<Animal> animales;

    public Habitat() {
    }

    public Habitat(int capacidadMax, double temperatura, String nombreHabitat) {
        if (capacidadMax <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser superior a 0");
        }
        if (nombreHabitat == null || nombreHabitat.isBlank()) {
            throw new IllegalArgumentException("El nombre del habitat no puede estar vacío");
        }
        this.capacidadMax = capacidadMax;
        this.temperatura = temperatura;
        this.nombreHabitat = nombreHabitat;
        this.animales = new ArrayList<>();
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getNombreHabitat() {
        return nombreHabitat;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    public boolean verificarCapacidad(Animal animal) {
        if (animales.size() < capacidadMax) {
            return true;
        } else {
            return false;
        }
    }

    public void retirarAnimal(Animal animal) {
        animales.remove(animal);
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

}
