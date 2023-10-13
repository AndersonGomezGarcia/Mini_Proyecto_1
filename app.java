import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App extends Ciudadano {
    private static List<Candidatos> candidatos = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n--------------------Bienvenido usuario------------------------");
            System.out.println("Qué desea hacer?");
            System.out.println("1. Insertar candidato");
            System.out.println("2. Actualizar candidato");
            System.out.println("3. Eliminar candidato");
            System.out.println("4. Buscar candidato por nombre");
            System.out.println("5. Listas todos los candidatos");
            System.out.println("0. Salir del Crud de candidatos");

            System.out.print("Elija una opcion ingresando el numero correspondiente: ");
            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        Funciones.presionar_para_continuar(scanner);
                        Funciones.crear_candidato(scanner, candidatos);
                        Funciones.presionar_para_continuar(scanner);
                        break;
                    case 2:
                        Funciones.presionar_para_continuar(scanner);
                        Funciones.actualizar_candidato(scanner, candidatos);
                        Funciones.presionar_para_continuar(scanner);
                        break;
                    case 3:
                        Funciones.presionar_para_continuar(scanner);
                        Funciones.eliminar_candidato(scanner, candidatos);
                        Funciones.presionar_para_continuar(scanner);
                        break;
                    case 4:
                        Funciones.presionar_para_continuar(scanner);
                        Funciones.buscar_candidato(scanner, candidatos);
                        Funciones.presionar_para_continuar(scanner);
                        break;
                    case 5:
                        Funciones.presionar_para_continuar(scanner);
                        Funciones.listar_candidatos(scanner, candidatos);
                        Funciones.presionar_para_continuar(scanner);
                        break;
                    case 0:
                        Funciones.presionar_para_continuar(scanner);
                        Funciones.votos_candidatos(scanner, candidatos);
                        Funciones.presionar_para_continuar(scanner);
                        Funciones.candidato_ganador(candidatos);
                        Funciones.presionar_para_continuar(scanner);
                        Funciones.encontrarPartidoConMasCandidatos(candidatos);
                        Funciones.presionar_para_continuar(scanner);
                        Funciones.top3CiudadesConMenosCandidatos(candidatos);
                        Funciones.presionar_para_continuar(scanner);
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\nError: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el búfer del scanner
                opcion = -1; // Establecer una opción inválida para continuar el bucle
                Funciones.presionar_para_continuar(scanner);
            } 

        } while (opcion != 0);
    }
}