package umariana.bioparquepasto;

public class Mamifero extends Animal {

    private String tipoPelaje;

    public Mamifero() {
    }

    public Mamifero(int codigo, String especie,String nombre, int edad, String sexo, double peso, Habitat habitat, EstadoSalud estadoSalud, EstadoInventario estadoInventario,String tipoAnimal,String fechaRegistro,String tipoPelaje) {
        super(codigo, especie,nombre, edad, sexo, peso, habitat, estadoSalud, estadoInventario,tipoAnimal,fechaRegistro);
        this.tipoPelaje = tipoPelaje;
    }

    public String getTipoPelaje() {
        return tipoPelaje;
    }

    public void setTipoPelaje(String tipoPelaje) {
        this.tipoPelaje = tipoPelaje;
    }

    @Override
    public void datosEspecificos() {
        System.out.println("Tipo de pelaje: "+ tipoPelaje);
        
    }
    

}
