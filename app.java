import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
    
    
    Scanner scanner = new Scanner(System.in);   
    int opcion = 0;
    do{
        System.out.println("--------------------Bienvenido usuario------------------------");
        System.out.println("Qué desea hacer?");
        System.out.println("1. Insertar candidato");
    
        System.out.print("elija una opcion: ");
        try (Scanner pedir = new Scanner(System.in)) {
            opcion = pedir.nextInt();
        }
        switch (opcion){
            case 1: Ciudadano.crear_Ciudadano(scanner, null);
                break;
            case 0: break;
            case 2: Ciudadano.pedir_ciudad();
        }
    
    
    } while (opcion != 0);

    
}
}