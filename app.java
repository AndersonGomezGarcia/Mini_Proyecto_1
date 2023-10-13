import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App extends Ciudadano {
    private static List<Candidatos> candidatos = new ArrayList<>();

    public static void crear_candidato(Scanner scanner, List<Candidatos> candidatos) {
        Candidatos candidato = Candidatos.datos_Candidatos(scanner);// crea un candidato
        candidatos.add(candidato);// lo añade a la lsita tipo candidatos

    }

    public static void actualizar_candidato(Scanner scanner,List<Candidatos> candidatos) {
        System.out.print("Ingrese el nombre del candidato que desea actualizar: ");
        String nombreABuscar = scanner.next();
        for (Candidatos candidato : candidatos) {
            System.out.println(candidato.getNombre());
            if (candidato.getNombre().equalsIgnoreCase(nombreABuscar)) {
                System.out.println("Ingrese los nuevos datos del candidato:\n");
                candidato = Candidatos.datos_Candidatos(scanner);// actualiza un candidato
            }
        }
    }
    public static void buscar_candidato(Scanner scanner, List<Candidatos> candidatos){
        System.out.print("Ingrese el nombre del candidato que desea buscar: ");
        String nombreBuscado = scanner.next();
        for (Candidatos candidato : candidatos) {
            if (candidato.getNombre().equalsIgnoreCase(nombreBuscado)) {
                Candidatos.print_candidato(candidato.getNombre(), candidato.getCedula(), candidato.getCiudad_origen(), candidato.getOrientacion_politica(), candidato.getPartido_politico(), candidato.getLista_promesas());
                break;
               // Devuelve el candidato si se encuentra
            }

        }
        System.out.println("Candidato " + nombreBuscado + " no encontrado en la lista.");
    }
    public static void listar_candidatos(Scanner scanner, List<Candidatos> candidatos){
        System.out.print("||||    Candidatos:    ||||\n ");
        for (Candidatos candidato : candidatos) {
            Candidatos.print_candidato(candidato.getNombre(), candidato.getCedula(), candidato.getCiudad_origen(), candidato.getOrientacion_politica(), candidato.getPartido_politico(), candidato.getLista_promesas());
               // Devuelve el candidato por cada candidato
        }
    }
    public static void votos_candidatos(Scanner scanner, List<Candidatos> candidatos){
        System.out.print("||||    Candidatos:    ||||\n ");
        for (Candidatos candidato : candidatos) {
            Candidatos.print_candidato(candidato.getNombre(), candidato.getCedula(), candidato.getCiudad_origen(), candidato.getOrientacion_politica(), candidato.getPartido_politico(), candidato.getLista_promesas()); // Devuelve el candidato por cada candidato
            candidato.setNumero_votos(candidato.Votos(scanner, candidato.getNombre(), candidato.getCedula()));

        }
    }
    public static Candidatos encontrarGanador(List<Candidatos> candidatos) {
        if (candidatos.isEmpty()) {
            return null; // Devuelve null si no hay candidatos en la lista
        }
    
        Candidatos ganador = candidatos.get(0); // Supongamos que el primer candidato es el ganador inicialmente
    
        for (Candidatos candidato : candidatos) {
            if (candidato.getNumero_votos() > ganador.getNumero_votos()) {
                ganador = candidato; // Actualiza el ganador si el candidato actual tiene más votos
            }
        }
        return ganador;
    }
    public static void candidato_ganador(List<Candidatos> candidatos){
        Candidatos candidato = encontrarGanador(candidatos);
        System.out.print("||| El candidato ganador ha sido:   |||\n");
        Candidatos.print_candidato(candidato.getNombre(), candidato.getCedula(), candidato.getCiudad_origen(), candidato.getOrientacion_politica(), candidato.getPartido_politico(), candidato.getLista_promesas());
    }

    public static String encontrarPartidoConMasCandidatos(List<Candidatos> candidatos) {
        // Crear un mapa para mantener la cuenta de candidatos por partido
        Map<String, Integer> conteoPartidos = new HashMap<>();

        // Iterar a través de la lista de candidatos
        for (Candidatos candidato : candidatos) {
            String partido = candidato.getPartido_politico();
            conteoPartidos.put(partido, conteoPartidos.getOrDefault(partido, 0) + 1);
        }

        // Encontrar el partido con la mayor cantidad de candidatos inscritos
        String partidoGanador = null;
        int cantidadMaxima = 0;

        for (Map.Entry<String, Integer> entry : conteoPartidos.entrySet()) {
            if (entry.getValue() > cantidadMaxima) {
                partidoGanador = entry.getKey();
                cantidadMaxima = entry.getValue();
            }
        }
        System.out.println("\nEl partido con más candidatos inscritos es: " + partidoGanador);
        return partidoGanador;
        
    }
    public static List<String> top3CiudadesConMenosCandidatos(List<Candidatos> candidatos) {
        
        Map<String, Integer> conteoCiudades = new HashMap<>();// Crear un mapa para mantener el conteo de candidatos por ciudad de orige
        
        for (Candidatos candidato : candidatos) {// Iterar a través de la lista de candidatos
            String ciudadOrigen = candidato.getCiudad_origen();
            conteoCiudades.put(ciudadOrigen, conteoCiudades.getOrDefault(ciudadOrigen, 0) + 1);
        }

        List<Map.Entry<String, Integer>> listaCiudadesOrdenada = new ArrayList<>(conteoCiudades.entrySet());// Crear una lista de ciudades ordenada por la cantidad de candidatos (ascendente)
        listaCiudadesOrdenada.sort(Map.Entry.comparingByValue());

        
        List<String> top3Ciudades = new ArrayList<>();// Obtener las tres ciudades con menos candidatos
        int contador = 0;

        for (Map.Entry<String, Integer> entrada : listaCiudadesOrdenada) {
            if (contador < 3) {
                top3Ciudades.add(entrada.getKey());
                contador++;
            } else {
                break;
            }
        }
        System.out.print("\n||| Las ciudades top 3 con menos candidatos de menor a mayor han sido   |||\n"+ top3Ciudades);
        return top3Ciudades;
    }

    public static void eliminar_candidato(Scanner scanner, List<Candidatos> candidatos) {

        System.out.print("Ingrese el nombre del candidato que desea eliminar: ");
        String nombre =  scanner.next();
        // Itera sobre la lista de candidatos y busca el candidato por su nombre
        Iterator<Candidatos> iterator = candidatos.iterator();
        while (iterator.hasNext()) {
            Candidatos candidato = iterator.next();
            if (candidato.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove(); // Elimina el candidato encontrado de la lista
                System.out.println("Candidato " + nombre + " eliminado con éxito.");
                return; // Sal del bucle si el candidato fue encontrado y eliminado
            }
        }
        System.out.println("Candidato " + nombre + " no encontrado en la lista.");
    }

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

            System.out.print("elija una opcion: ");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    crear_candidato(scanner, candidatos);
                    break;
                case 2:
                    ;
                    actualizar_candidato(scanner, candidatos);
                    break;
                case 3:
                    ;
                    eliminar_candidato(scanner, candidatos);
                    break;
                case 4:
                    ;
                    buscar_candidato(scanner, candidatos);
                    break;
                case 5:
                    ;
                    listar_candidatos(scanner, candidatos);
                    break;
                case 0:
                    votos_candidatos(scanner,  candidatos);
                    candidato_ganador(candidatos);
                    encontrarPartidoConMasCandidatos(candidatos);
                    top3CiudadesConMenosCandidatos(candidatos);
                    break;
            }

        } while (opcion != 0);
    }
}