package umariana.bioparquepasto;

import java.util.*;

public class Inventario {

    int contadorCodigo = 1;

    Scanner lector = new Scanner(System.in);
    ArrayList<Animal> misAnimales = new ArrayList<>();
    ArrayList<Habitat> misHabitats = new ArrayList<>();

    public Inventario() {
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {

        misHabitats.add(new Habitat(9, 23.5, "Selva"));
        misHabitats.add(new Habitat(6, 45.9, "Desierto"));
        misHabitats.add(new Habitat(3, 12.4, "Laguna"));
        misHabitats.add(new Habitat(4, 22.4, "Bosque"));
        misHabitats.add(new Habitat(7, 15.8, "Establo"));
        misHabitats.add(new Habitat(6, 22.9, "Sabana"));
        misHabitats.add(new Habitat(8, 30.9, "Humedal"));
        misHabitats.add(new Habitat(6, 5.9, "Montañas"));
        misHabitats.add(new Habitat(5, 22.9, "Enfermeria"));

    }

    public void registrarAnimal() {
        double peso;
        int edad;
        String nombre;
        String especie;
        int opTipo;
        int opSexo;
        Habitat habitat = null;
        String sexo = "";
        String fechaRegistro = "";
        String tipoAnimal = "";
        EstadoInventario estadoInventario = null;
        EstadoSalud estadoSalud = null;
        double envergadura = 0;
        boolean puedeVolar = false;
        String TipoEscamas = "";
        String TipoPelaje = "";
        do {
            System.out.println("Ingrese la especie del animal (Ejemplo: Condor andino)");
            especie = lector.nextLine();

            if (especie.isBlank()) {
                System.out.println("La especie no puede estar vacía.");
            }

        } while (especie.isBlank());

        do {
            System.out.println("Ingrese el nombre del animal (Ejemplo: Caliche)");
            nombre = lector.nextLine();

            if (nombre.isBlank()) {
                System.out.println("El nombre no puede estar vacío.");
            }

        } while (nombre.isBlank());

        try {
            System.out.println("Ingrese la edad del animal:");
            edad = lector.nextInt();
            lector.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un número entero.");
            lector.nextLine();
            return;
        }
        do {
            System.out.println("Ingrese el sexo del animal: \n1.Macho \n2.Hembra");
            opSexo = lector.nextInt();
            lector.nextLine();

            switch (opSexo) {
                case 1:
                    sexo = "Macho";
                    break;
                case 2:
                    sexo = "Hembra";
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }

        } while (opSexo != 1 && opSexo != 2);
        try {
            System.out.println("Ingrese el peso del animal (Kg):");
            peso = lector.nextDouble();
            lector.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un número válido.");
            lector.nextLine();
            return;
        }

        do {
            System.out.println("Ingrese el tipo de animal:");
            System.out.println("1. Ave");
            System.out.println("2. Reptil");
            System.out.println("3. Mamifero");

            opTipo = lector.nextInt();
            lector.nextLine();

            if (opTipo < 1 || opTipo > 3) {
                System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opTipo < 1 || opTipo > 3);

        switch (opTipo) {

            case 1:
                System.out.println("Ingrese la envergadura del Ave: (En metros)");
                envergadura = lector.nextDouble();
                lector.nextLine();

                int opPuedeVolar;

                do {
                    System.out.println("¿El ave puede volar?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");

                    opPuedeVolar = lector.nextInt();
                    lector.nextLine();

                    if (opPuedeVolar != 1 && opPuedeVolar != 2) {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    }

                } while (opPuedeVolar != 1 && opPuedeVolar != 2);

                if (opPuedeVolar == 1) {
                    puedeVolar = true;
                } else {
                    puedeVolar = false;
                }

                break;

            case 2:
                int opTipoEscamas;

                do {
                    System.out.println("Ingrese el tipo de escamas del reptil:");
                    System.out.println("1. Lisas");
                    System.out.println("2. Quilladas");
                    System.out.println("3. Granulares");

                    opTipoEscamas = lector.nextInt();
                    lector.nextLine();

                    if (opTipoEscamas < 1 || opTipoEscamas > 3) {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    }

                } while (opTipoEscamas < 1 || opTipoEscamas > 3);

                switch (opTipoEscamas) {
                    case 1:
                        TipoEscamas = "Lisas";
                        break;

                    case 2:
                        TipoEscamas = "Quilladas";
                        break;

                    case 3:
                        TipoEscamas = "Granulares";
                        break;
                }

                break;

            case 3:
                int opTipoPelaje;

                do {
                    System.out.println("Ingrese el tipo de pelaje del mamifero:");
                    System.out.println("1. Liso");
                    System.out.println("2. Rizado");
                    System.out.println("3. Denso");
                    System.out.println("4. Sin pelo");

                    opTipoPelaje = lector.nextInt();
                    lector.nextLine();

                    if (opTipoPelaje < 1 || opTipoPelaje > 4) {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    }

                } while (opTipoPelaje < 1 || opTipoPelaje > 4);

                switch (opTipoPelaje) {
                    case 1:
                        TipoPelaje = "Liso";
                        break;

                    case 2:
                        TipoPelaje = "Rizado";
                        break;

                    case 3:
                        TipoPelaje = "Denso";
                        break;

                    case 4:
                        TipoPelaje = "Sin pelo";
                        break;
                }

                break;
        }
        int opEstadoSalud;

        do {
            System.out.println("Ingrese un estado de salud:");
            System.out.println("1. Sano");
            System.out.println("2. Enfermo");

            opEstadoSalud = lector.nextInt();
            lector.nextLine();

            if (opEstadoSalud != 1 && opEstadoSalud != 2) {
                System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opEstadoSalud != 1 && opEstadoSalud != 2);

        switch (opEstadoSalud) {

            case 1:
                estadoSalud = EstadoSalud.SANO;
                estadoInventario = EstadoInventario.ACTIVO;

                System.out.println("Ingrese el habitat del animal:");
                System.out.println("------ Lista de Habitats ------");

                for (int i = 0; i < misHabitats.size() - 1; i++) {
                    System.out.println((i + 1) + ". " + misHabitats.get(i).getNombreHabitat());
                }

                int opHabitat;

                do {
                    System.out.println("Seleccionar un habitat:");
                    opHabitat = lector.nextInt();
                    lector.nextLine();

                    if (opHabitat < 1 || opHabitat > misHabitats.size() - 1) {
                        System.out.println("Opción de habitat no válida. Intente nuevamente.");
                    }

                } while (opHabitat < 1 || opHabitat > misHabitats.size() - 1);

                habitat = misHabitats.get(opHabitat - 1);

                break;

            case 2:
                estadoSalud = EstadoSalud.ENFERMO;
                estadoInventario = EstadoInventario.EN_OBSERVACION;

                for (Habitat a : misHabitats) {
                    if (a.getNombreHabitat().equalsIgnoreCase("Enfermeria")) {
                        habitat = a;
                    }
                }

                break;
        }

        System.out.println("Ingrese la fecha de registro: (DD/MM/AA)");
        fechaRegistro = lector.nextLine();
        switch (opTipo) {
            case 1:
                try {
                    tipoAnimal = "Ave";
                    Ave miAve = new Ave(contadorCodigo, especie, nombre, edad, sexo, peso, habitat, estadoSalud, estadoInventario, tipoAnimal, fechaRegistro, envergadura, puedeVolar);
                    if (habitat.verificarCapacidad(miAve)) {
                        habitat.agregarAnimal(miAve);
                        misAnimales.add(miAve);
                        contadorCodigo++;
                        System.out.println("Animal registrado correctamente.");
                    } else {
                        System.out.println("Habitat lleno.");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());

                }

                break;
            case 2:
                try {
                    tipoAnimal = "Reptil";
                    Reptil miReptil = new Reptil(contadorCodigo, especie, nombre, edad, sexo, peso, habitat, estadoSalud, estadoInventario, tipoAnimal, fechaRegistro, TipoEscamas);
                    if (habitat.verificarCapacidad(miReptil)) {
                        habitat.agregarAnimal(miReptil);
                        misAnimales.add(miReptil);
                        contadorCodigo++;
                        System.out.println("Animal registrado correctamente.");

                    } else {
                        System.out.println("Habitat lleno.");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());

                }

                break;
            case 3:
                try {
                    tipoAnimal = "Mamifero";
                    Mamifero miMamifero = new Mamifero(contadorCodigo, especie, nombre, edad, sexo, peso, habitat, estadoSalud, estadoInventario, tipoAnimal, fechaRegistro, TipoPelaje);
                    if (habitat.verificarCapacidad(miMamifero)) {
                        habitat.agregarAnimal(miMamifero);
                        misAnimales.add(miMamifero);
                        contadorCodigo++;
                        System.out.println("Animal registrado correctamente.");
                    } else {
                        System.out.println("Habitat lleno");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                break;
        }

    }

    public void listarAnimales() {
        if (misAnimales.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;

        } else {
            System.out.println("Lista de animales: ");
            System.out.println("---------------------------------------------------");
            for (Animal a : misAnimales) {
                System.out.println("Código: " + a.getCodigo());
                System.out.println("Especie: " + a.getEspecie());
                System.out.println("Nombre: " + a.getNombre());
                System.out.println("Edad: " + a.getEdad() + " años");
                System.out.println("Sexo: " + a.getSexo());
                System.out.println("Tipo: " + a.getTipoAnimal());
                a.datosEspecificos();
                System.out.println("Peso: " + a.getPeso() + "Kg");
                System.out.println("Habitat: " + a.getHabitat().getNombreHabitat());
                System.out.println("Estado de salud: " + a.getEstadoSalud());
                System.out.println("Estado de inventario: " + a.getEstadoInventario());
                System.out.println("Fecha de registro: " + a.getFechaRegistro());
                System.out.println("=======================================================");

            }

        }
    }

    public void buscarAnimalporCodigo() {
        if (misAnimales.isEmpty()) {
            System.out.println("No hay animales registrados.");
            return;
        } else {
            System.out.println("Por favor ingrese el código del animal que desea buscar: ");
            int busqueda = lector.nextInt();
            lector.nextLine();

            for (Animal a : misAnimales) {
                if (a.getCodigo() == busqueda) {
                    System.out.println("Animal encontrado: ");
                    System.out.println("Especie: " + a.getEspecie());
                    System.out.println("Código: " + a.getCodigo());
                    System.out.println("Nombre: " + a.getNombre());
                    System.out.println("Edad: " + a.getEdad());
                    System.out.println("Sexo: " + a.getSexo());
                    System.out.println("Tipo: " + a.getTipoAnimal());
                    a.datosEspecificos();
                    System.out.println("Peso: " + a.getPeso() + "Kg");
                    System.out.println("Habitat: " + a.getHabitat().getNombreHabitat());
                    System.out.println("Estado de salud: " + a.getEstadoSalud());
                    System.out.println("Estado de inventario: " + a.getEstadoInventario());
                    System.out.println("Fecha de registro:" + a.getFechaRegistro());
                    System.out.println("=====================================================================");
                    return;
                }

            }
            System.out.println("No existe un animal con el código: " + busqueda);
        }
    }

    public void actualizarAnimal() {
        if (misAnimales.isEmpty()) {
            System.out.println("No hay animales registrados. ");
            return;
        } else {
            System.out.println("Ingresar el codigo del animal que desea actualizar: ");
            int codigoBusqueda = lector.nextInt();
            lector.nextLine();
            for (Animal a : misAnimales) {
                if (a.getCodigo() == codigoBusqueda) {
                    System.out.println("Ingrese el elemento que desea cambiar: ");
                    System.out.println("1. Especie\n2.Nombre\n3.Edad\n4.Sexo\n5.Peso\n6.Habitat\n7.Estado del inventario\n8. Estado de salud");
                    int opcion = lector.nextInt();
                    lector.nextLine();
                    switch (opcion) {
                        case 1:
                            try {
                                System.out.println("Ingrese la nueva especie: ");
                                String nuevaEspecie = lector.nextLine();
                                a.actualizarEspecie(nuevaEspecie);
                                System.out.println("Especie actualizada correctamente.");

                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                            break;

                        case 2:
                            try {
                                System.out.println("Ingrese el nuevo nombre: ");
                                String nuevoNombre = lector.nextLine();
                                a.actualizarNombre(nuevoNombre);
                                System.out.println("Nombre actualizado correctamente.");

                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }

                            break;
                        case 3:
                            try {
                                System.out.println("Ingrese la nueva edad: ");
                                int nuevaEdad = lector.nextInt();
                                lector.nextLine();
                                a.actualizarEdad(nuevaEdad);
                                System.out.println("Edad actualizada correctamente.");

                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }

                            break;
                        case 4:
                            try {
                                System.out.println("Ingrese el nuevo sexo:");
                                System.out.println("1. Macho");
                                System.out.println("2. Hembra");

                                int opSexo = lector.nextInt();
                                lector.nextLine();

                                switch (opSexo) {
                                    case 1:
                                        a.actualizarSexo("Macho");
                                        System.out.println("Sexo actualizado correctamente.");
                                        break;

                                    case 2:
                                        a.actualizarSexo("Hembra");
                                        System.out.println("Sexo actualizado correctamente.");
                                        break;

                                    default:
                                        System.out.println("Opción inválida.");
                                }

                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }

                            break;
                        case 5:
                            try {
                                System.out.println("Ingrese el nuevo peso: ");
                                double nuevoPeso = lector.nextDouble();
                                lector.nextLine();
                                a.actualizarPeso(nuevoPeso);
                                System.out.println("Peso actualizado correctamente.");

                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }

                            break;
                        case 6:
                            try {
                                System.out.println("Seleccione el nuevo habitat:");

                                for (int i = 0; i < misHabitats.size() - 1; i++) {
                                    System.out.println((i + 1) + ". " + misHabitats.get(i).getNombreHabitat());
                                }

                                int opHabitat = lector.nextInt();
                                lector.nextLine();

                                if (opHabitat >= 1 && opHabitat <= misHabitats.size() - 1) {
                                    Habitat nuevoHabitat = misHabitats.get(opHabitat - 1);
                                    a.trasladarHabitat(nuevoHabitat);
                                    System.out.println("Habitat actualizado correctamente.");
                                } else {
                                    System.out.println("Opción de habitat inválida.");
                                }

                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }

                            break;
                        case 7:
                            try {
                                System.out.println("Seleccione el nuevo estado de inventario:");
                                System.out.println("1. Activo");
                                System.out.println("2. Retirado");
                                System.out.println("3. En observación");

                                int opcionEstado = lector.nextInt();
                                lector.nextLine();

                                switch (opcionEstado) {
                                    case 1:
                                        a.activar();
                                        System.out.println("Estado actualizado correctamente.");
                                        break;

                                    case 2:
                                        a.retirar();
                                        System.out.println("Estado actualizado correctamente.");
                                        break;

                                    case 3:
                                        a.ponerEnObservacion();
                                        System.out.println("Estado actualizado correctamente.");
                                        break;

                                    default:
                                        System.out.println("Opción inválida.");
                                }

                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }

                            break;
                        case 8:
                            try {
                                System.out.println("Seleccione el nuevo estado de salud:");
                                System.out.println("1. Sano");
                                System.out.println("2. Enfermo");
                                System.out.println("3. Fallecido");

                                int opcionSalud = lector.nextInt();
                                lector.nextLine();

                                switch (opcionSalud) {
                                    case 1:
                                        a.registrarRecuperacion();
                                        System.out.println("El animal se ha registrado exitosamente :D.");
                                        break;

                                    case 2:
                                        Habitat habitat = null;
                                        a.registrarEnfermedad();
                                        System.out.println("Animal enfermo!!!");
                                        for (Habitat h : misHabitats) {
                                            if (h.getNombreHabitat().equalsIgnoreCase("Enfermeria")) {
                                                habitat = h;
                                                a.trasladarHabitat(habitat);
                                            }
                                        }
                                        break;

                                    case 3:
                                        Habitat habitatActual = a.getHabitat();
                                        habitatActual.retirarAnimal(a);
                                        a.registrarFallecimiento();
                                        System.out.println("Animal fallecido.");
                                        break;

                                    default:
                                        System.out.println("Opción inválida.");
                                        break;
                                }

                            } catch (IllegalArgumentException e) {
                                System.out.println("Error: " + e.getMessage());
                            }

                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                    return;

                }

            }
            System.out.println("Animal con el codigo: " + codigoBusqueda + " no econtrado");

        }

    }

    public void retirarAnimal() {
        if (misAnimales.isEmpty()) {
            System.out.println("No hay animales registrados");
            return;
        } else {
            System.out.println("Ingrese el código del animal que desea retirar: ");
            int codigoBusqueda = lector.nextInt();
            lector.nextLine();
            for (Animal a : misAnimales) {
                if (a.getCodigo() == codigoBusqueda) {
                    Habitat habitatActual = a.getHabitat();
                    habitatActual.retirarAnimal(a);
                    a.retirar();
                    System.out.println("Animal retirado");
                    return;
                }
            }
            System.out.println("Animal con el codigo: " + codigoBusqueda + " no encontrado");

        }

    }

}
