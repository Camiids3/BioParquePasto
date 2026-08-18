package umariana.bioparquepasto;

public class Animal {

    private int codigo;
    private String especie;
    private String nombre;
    private int edad;
    private String sexo;
    private double peso;
    private Habitat habitat;
    private EstadoSalud estadoSalud;
    private EstadoInventario estadoInventario;
    private String tipoAnimal;
    private String fechaRegistro;

    public Animal() {

    }

    public Animal(int codigo, String especie, String nombre, int edad, String sexo, double peso, Habitat habitat, EstadoSalud estadoSalud, EstadoInventario estadoInventario, String tipoAnimal, String fechaRegistro) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puebe ser menor que 0.");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor o igual que 0");
        }
        if (codigo <= 0) {
            throw new IllegalArgumentException("El código debe ser mayor que 0");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (especie == null || especie.isBlank()) {
            throw new IllegalArgumentException("La especie no puede estar vacia");
        }
        if (tipoAnimal == null || tipoAnimal.isBlank()) {
            throw new IllegalArgumentException("El tipo de animal no puede estar vacío");
        }
        if (habitat == null) {
            throw new IllegalArgumentException("El animal debe tener un habitat asignado");
        }
        if (estadoSalud == null) {
            throw new IllegalArgumentException("El estado de salud es obligatorio.");
        }

        if (estadoInventario == null) {
            throw new IllegalArgumentException("El estado de inventario es obligatorio.");
        }

        if (estadoSalud == EstadoSalud.FALLECIDO && estadoInventario == EstadoInventario.ACTIVO) {
            throw new IllegalArgumentException("Un animal fallecido no puede estar activo.");
        }
        this.codigo = codigo;
        this.especie = especie;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.habitat = habitat;
        this.estadoSalud = estadoSalud;
        this.estadoInventario = estadoInventario;
        this.tipoAnimal = tipoAnimal;
        this.fechaRegistro = fechaRegistro;

    }

    public int getCodigo() {
        return codigo;
    }

    public String getEspecie() {
        return especie;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public EstadoSalud getEstadoSalud() {
        return estadoSalud;
    }

    public EstadoInventario getEstadoInventario() {
        return estadoInventario;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void datosEspecificos() {

    }

    public void actualizarEspecie(String nuevaEspecie) {
        if (nuevaEspecie == null || nuevaEspecie.isBlank()) {
            throw new IllegalArgumentException("La especie no puede estar vacía");
        } else {
            this.especie = nuevaEspecie;
        }

    }

    public void actualizarNombre(String nuevoNombre) {
        if (nuevoNombre == null || nuevoNombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        } else {
            this.nombre = nuevoNombre;
        }
    }

    public void actualizarPeso(double nuevoPeso) {
        if (nuevoPeso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que 0");
        } else {
            this.peso = nuevoPeso;
        }
    }

    public void actualizarEdad(int nuevaEdad) {
        if (nuevaEdad < 0) {
            throw new IllegalArgumentException("La edad debe ser mayor que o igual que 0");
        } else {
            this.edad = nuevaEdad;
        }
    }

    public void actualizarSexo(String nuevoSexo) {
        if (nuevoSexo == null || nuevoSexo.isBlank()) {
            throw new IllegalArgumentException("El sexo no puede estar vacío");
        } else {
            this.sexo = nuevoSexo;
        }
    }

    public void trasladarHabitat(Habitat nuevoHabitat) {
        if (nuevoHabitat == null) {
            throw new IllegalArgumentException("El habitat no puede estar vaciío");
        }
        if (this.habitat == nuevoHabitat) {
            throw new IllegalArgumentException("El animal ya se encuentra en este habitat");
        }
        if (nuevoHabitat.verificarCapacidad(this)) {
            this.habitat.retirarAnimal(this);
            this.habitat = nuevoHabitat;
            nuevoHabitat.agregarAnimal(this);
        } else {
            throw new IllegalArgumentException("El habitat seleccionado está lleno");
        }
    }

    public void ponerEnObservacion() {
        if (estadoInventario == EstadoInventario.RETIRADO) {
            throw new IllegalArgumentException("Un animal retirado no puede colocarse en observación");
        } else {
            estadoInventario = EstadoInventario.EN_OBSERVACION;
        }

    }

    public void retirar() {
        estadoInventario = EstadoInventario.RETIRADO;
    }

    public void registrarFallecimiento() {
        estadoSalud = EstadoSalud.FALLECIDO;
        estadoInventario = EstadoInventario.RETIRADO;
    }

    public void activar() {
        if (estadoInventario == EstadoInventario.RETIRADO) {
            throw new IllegalArgumentException("Un animal retirado no puede volver a estar activo");
        }
        if (estadoSalud == EstadoSalud.FALLECIDO) {
            throw new IllegalArgumentException("Un animal fallecido no puede estar activo");
        }
        estadoInventario = EstadoInventario.ACTIVO;
    }

    public void registrarEnfermedad() {
        estadoSalud = EstadoSalud.ENFERMO;
        estadoInventario = EstadoInventario.EN_OBSERVACION;

    }

    public void registrarRecuperacion() {
        if (estadoSalud == EstadoSalud.FALLECIDO) {
            throw new IllegalArgumentException("Un animal fallecido no puede recuperarse.");
        } else {
            estadoSalud = EstadoSalud.SANO;
            estadoInventario = EstadoInventario.ACTIVO;
        }
    }


}
