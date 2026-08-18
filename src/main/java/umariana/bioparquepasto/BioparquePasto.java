package umariana.bioparquepasto;

import java.util.*;

public class BioparquePasto {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Inventario gestionarInventario = new Inventario();
        boolean activo = true;
        int opc;
        

        do {
            System.out.println("----------Bioparque Pasto-----------");
            System.out.println("______________________________________");
            System.out.println("*_*_*_*_*_*_Menú de Opciones*_*_*_*_*_*_");
            System.out.println("1. Registrar Animal.");
            System.out.println("2. Listar animales.");
            System.out.println("3. Buscar animal por código.");
            System.out.println("4. Actualizar datos de un animal.");
            System.out.println("5. Retirar animal.");
            System.out.println("6. Filtrar por categoría o estado.");
            System.out.println("7. Ejecutar comportamientos.");
            System.out.println("8. Ver resumén del inventario.");
            System.out.println("0. Salir.");
            System.out.println("Seleccionar una opción: ");
            opc = Integer.parseInt(lector.nextLine());
            switch (opc){
                case 1:
                    gestionarInventario.registrarAnimal();                   
                    break;
                case 2:
                    gestionarInventario.listarAnimales();
                    break;
                case 3:
                    gestionarInventario.buscarAnimalporCodigo();
                    break;
                case 4:
                    gestionarInventario.actualizarAnimal();
                    break;
                case 5:
                    gestionarInventario.retirarAnimal();
                    break;
                case 6:
                    System.out.println("Opcion 6");
                    break;
                case 7:
                    System.out.println("Opcion 7");
                    break;
                case 8:
                    System.out.println("Opcion 8");
                    break;
                case 0:
                    activo = false;
                    System.out.println("Cerrando programa....");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
                    
                   
                           
            }
            

        } while (activo);

    }
}
