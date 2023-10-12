import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App extends Ciudadano{
    private static List<Candidatos> candidatos = new ArrayList<>();

    public static void crear_candidato(Scanner scanner){
        Candidatos candidato = Candidatos.datos_Candidatos(scanner);//crea un candidato
        candidatos.add(candidato);//lo añade a la lsita tipo candidatos
        
    }
    public static void actualizar_candidato(Scanner scanner){
        System.out.print("Ingrese el nombre del candidato que desea actualizar: ");
        String nombreABuscar = scanner.next();
        for (Candidatos candidato : candidatos) {
            if (candidato.getNombre().equalsIgnoreCase(nombreABuscar)) {
                candidato = Candidatos.datos_Candidatos(scanner);//actualiza un candidato
            }
        }
        System.out.println("Candidato no encontrado.");
        
        
    }
    public static void main(String[] args) throws Exception {
    
    
    
    Scanner scanner = new Scanner(System.in);   
    int opcion = 0;
    do{
        System.out.println("\n\n--------------------Bienvenido usuario------------------------");
        System.out.println("Qué desea hacer?");
        System.out.println("1. Insertar candidato");
        System.out.println("2. Actualizar candidato");
        System.out.println("3. Eliminar candidato");
        System.out.println("4. Buscar candidato por nombre");
        System.out.println("5. Listas todos los candidatos");
    
        System.out.print("elija una opcion: ");

        opcion = scanner.nextInt();
        switch (opcion){
            case 1: 
                crear_candidato(scanner);
                break;
            case 2: ;
                actualizar_candidato(scanner);
                break;
            case 0: break;
        }
    
    
    } while (opcion != 0);
}
}