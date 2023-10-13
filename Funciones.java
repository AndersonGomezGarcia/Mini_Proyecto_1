
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Funciones {

    public static void limpiar_pantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void presionar_para_continuar(Scanner scanner) {
        System.out.println("\n\nPor favor pulsa [Enter] para continuar...");
        try {
            System.in.read();
            scanner.nextLine();
        } catch (Exception e) {
            try {
                System.in.read();
                scanner.nextLine();
            } catch (Exception o) {

            }
        }
        limpiar_pantalla();
    }

    public static void crear_candidato(Scanner scanner, List<Candidatos> candidatos) {
        Candidatos candidato = Candidatos.datos_Candidatos(scanner);//crea un candidato
        candidatos.add(candidato);//lo añade a la lsita tipo candidatos

    }

    public static void actualizar_candidato(Scanner scanner, List<Candidatos> candidatos) {
        System.out.print("Ingrese el nombre del candidato que desea actualizar: ");
        String nombreABuscar = scanner.next();
        for (Candidatos candidato : candidatos) {
            System.out.println(candidato.getNombre());
            if (candidato.getNombre().equalsIgnoreCase(nombreABuscar)) {
                System.out.println("Ingrese los nuevos datos del candidato:\n");
                candidato = Candidatos.datos_Candidatos(scanner);//actualiza un candidato
                return;
            }
        }
        System.out.print("No se encontro un candidato con el nombre: " + nombreABuscar);
    }

    public static void buscar_candidato(Scanner scanner, List<Candidatos> candidatos) {
        System.out.print("Ingrese el nombre del candidato que desea buscar: ");
        String nombreBuscado = scanner.next();
        for (Candidatos candidato : candidatos) {
            if (candidato.getNombre().equalsIgnoreCase(nombreBuscado)) {
                Candidatos.print_candidato(candidato.getNombre(), candidato.getCedula(), candidato.getCiudad_origen(),
                        candidato.getOrientacion_politica(), candidato.getPartido_politico(),
                        candidato.getLista_promesas());
                break;
                //Devuelve el candidato si se encuentra
            }

        }
        System.out.println("Candidato " + nombreBuscado + " no encontrado en la lista.");
    }

    public static void listar_candidatos(Scanner scanner, List<Candidatos> candidatos) {
        System.out.print("||||    Candidatos:    ||||\n ");
        for (Candidatos candidato : candidatos) {
            Candidatos.print_candidato(candidato.getNombre(), candidato.getCedula(), candidato.getCiudad_origen(),
                    candidato.getOrientacion_politica(), candidato.getPartido_politico(),
                    candidato.getLista_promesas());
            //Devuelve el candidato por cada candidato
        }
    }

    public static void votos_candidatos(Scanner scanner, List<Candidatos> candidatos) {
        System.out.print("||||    Candidatos:    ||||\n ");
        for (Candidatos candidato : candidatos) {
            Candidatos.print_candidato(candidato.getNombre(), candidato.getCedula(), candidato.getCiudad_origen(),
                    candidato.getOrientacion_politica(), candidato.getPartido_politico(),
                    candidato.getLista_promesas()); //Devuelve el candidato por cada candidato
            candidato.setNumero_votos(candidato.Votos(scanner, candidato.getNombre(), candidato.getCedula()));

        }
    }

    public static Candidatos encontrarGanador(List<Candidatos> candidatos) {
        if (candidatos.isEmpty()) {
            return null; //Devuelve null si no hay candidatos en la lista
        }

        Candidatos ganador = candidatos.get(0); //Supongamos que el primer candidato es el ganador inicialmente

        for (Candidatos candidato : candidatos) {
            if (candidato.getNumero_votos() > ganador.getNumero_votos()) {
                ganador = candidato; //Actualiza el ganador si el candidato actual tiene más votos
            }
        }
        return ganador;
    }

    public static void candidato_ganador(List<Candidatos> candidatos) {
        Candidatos candidato = encontrarGanador(candidatos);
        System.out.print("||| El candidato ganador ha sido:   |||\n");
        Candidatos.print_candidato(candidato.getNombre(), candidato.getCedula(), candidato.getCiudad_origen(),
                candidato.getOrientacion_politica(), candidato.getPartido_politico(), candidato.getLista_promesas());
    }

    public static List<String> encontrarPartidoConMasCandidatos(List<Candidatos> candidatos) {
        //Crear un mapa para mantener la cuenta de candidatos por partido
        Map<String, Integer> conteoPartidos = new HashMap();

        
        for (Candidatos candidato : candidatos) {//Iterar a traves de la lista de candidatos
            String partido = candidato.getPartido_politico();
            conteoPartidos.put(partido, conteoPartidos.getOrDefault(partido, 0) + 1);
        }

        
        int cantidadMaxima = 0;//Encontrar la cantidad maxima de candidatos inscritos
        for (Map.Entry<String, Integer> entry : conteoPartidos.entrySet()) {
            cantidadMaxima = Math.max(cantidadMaxima, entry.getValue());
        }

        
        List<String> partidosGanadores = new ArrayList<>();//Encontrar todos los partidos con la cantidad maxima de candidatos inscritos
        for (Map.Entry<String, Integer> entry : conteoPartidos.entrySet()) {
            if (entry.getValue() == cantidadMaxima) {
                partidosGanadores.add(entry.getKey());
            }
        }

        System.out.println("\n|||Los partidos con más candidatos inscritos son: " + partidosGanadores + " con un total de "+ cantidadMaxima + " candidatos inscritos |||");
        return partidosGanadores;

    }

    public static List<String> top3CiudadesConMenosCandidatos(List<Candidatos> candidatos) {

        Map<String, Integer> conteoCiudades = new HashMap<>();//Crear un mapa para mantener el conteo de candidatos por
                                                              //ciudad de origen

        for (Candidatos candidato : candidatos) {//Iterar a traves de la lista de candidatos
            String ciudadOrigen = candidato.getCiudad_origen();
            conteoCiudades.put(ciudadOrigen, conteoCiudades.getOrDefault(ciudadOrigen, 0) + 1);
        }

        List<Map.Entry<String, Integer>> listaCiudadesOrdenada = new ArrayList<>(conteoCiudades.entrySet());//Crear unalista de   ciudades   ordenada    por la    cantidad    de   candidatos   (ascendente)
        listaCiudadesOrdenada.sort(Map.Entry.comparingByValue());

        List<String> top3Ciudades = new ArrayList<>();//Obtener las tres ciudades con menos candidatos
        int contador = 0;

        for (Map.Entry<String, Integer> entrada : listaCiudadesOrdenada) {
            if (contador < 3) {
                top3Ciudades.add(entrada.getKey());
                contador++;
            } else {
                break;
            }
        }
        System.out.print("\n||| Las ciudades top 3 con menos candidatos de menor a mayor han sido   |||\n" + top3Ciudades);
        return top3Ciudades;
    }

    public static void eliminar_candidato(Scanner scanner, List<Candidatos> candidatos) {

        System.out.print("Ingrese el nombre del candidato que desea eliminar: ");
        String nombre = scanner.next();
        
        Iterator<Candidatos> iterator = candidatos.iterator();//Itera sobre la lista de candidatos y busca el candidato por su nombre
        while (iterator.hasNext()) {
            Candidatos candidato = iterator.next();
            if (candidato.getNombre().equalsIgnoreCase(nombre)) {
                iterator.remove(); //Elimina el candidato encontrado de la lista
                System.out.println("Candidato " + nombre + " eliminado con éxito.");
                return; //Sal del bucle si el candidato fue encontrado y eliminado
            }
        }
        System.out.println("Candidato " + nombre + " no encontrado en la lista.");
    }
}
