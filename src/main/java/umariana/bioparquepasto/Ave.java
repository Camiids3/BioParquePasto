package umariana.bioparquepasto;

public class Ave extends Animal {

    private double envergadura;
    private boolean puedeVolar;

    public Ave() {
    }

    public Ave(int codigo, String especie,String nombre, int edad, String sexo, double peso,  Habitat habitat, EstadoSalud estadoSalud, EstadoInventario estadoInventario,String tipoAnimal,String fechaRegistro,double envergadura, boolean puedeVolar) {
        super(codigo, especie,nombre, edad, sexo, peso, habitat, estadoSalud, estadoInventario,tipoAnimal,fechaRegistro);
        this.envergadura = envergadura;
        this.puedeVolar = puedeVolar;
    }

    public Ave(double envergadura, boolean puedeVolar) {
        this.envergadura = envergadura;
        this.puedeVolar = puedeVolar;
    }

    public double getEnvergadura() {
        return envergadura;
    }

    public void setEnvergadura(double envergadura) {
        this.envergadura = envergadura;
    }

    public boolean isPuedeVolar() {
        return puedeVolar;
    }

    public void setPuedeVolar(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }

    @Override
    public void datosEspecificos() {
        System.out.println("Envergadura: "+ envergadura);
        if(puedeVolar == true){
            System.out.println("Puede volar: Sí");
        }else{
            System.out.println("Puede volar: No");
        }
 
        
    }
    
    

}
