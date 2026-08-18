package umariana.bioparquepasto;

public class Reptil extends Animal {

    private String TipoEscamas;

    public Reptil() {
    }

    public Reptil(int codigo, String especie,String nombre, int edad, String sexo, double peso, Habitat habitat, 
            EstadoSalud estadoSalud, EstadoInventario estadoInventario,String tipoAnimal,String fechaRegistro,
            String TipoEscamas) {
        super(codigo, especie,nombre, edad, sexo, peso, habitat, estadoSalud, estadoInventario,tipoAnimal,fechaRegistro);
        this.TipoEscamas = TipoEscamas;
    }

    public Reptil(String TipoEscamas) {
        this.TipoEscamas = TipoEscamas;
    }

    public String getTipoEscamas() {
        return TipoEscamas;
    }

    public void setTipoEscamas(String TipoEscamas) {
        this.TipoEscamas = TipoEscamas;
    }

    @Override
    public void datosEspecificos() {
        System.out.println("Tipo de escamas: "+ TipoEscamas );
        
    }
    

}
