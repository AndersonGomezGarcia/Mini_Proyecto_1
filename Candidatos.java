import java.util.Scanner;

public class Candidatos extends Ciudadano {
    private boolean orientacion_politica;// Si es positivo es de derecha si es negativo es de izquierda
    private String partido_politico;
    private String lista_promesas;

    public Candidatos(String nombre, String cedula, String ciudad_origen,
             boolean orientacionpolitica, String lista_promesas) {
        super(cedula, ciudad_origen, nombre);
        this.orientacion_politica = orientacionpolitica;
        this.lista_promesas = lista_promesas;

    }

    public boolean getOrientacion_politica() {
        return orientacion_politica;
    }

    public void setOrientacion_politica(boolean orientacion_politica) {
        this.orientacion_politica = orientacion_politica;
    }

    public class Ciudadano {

        String nombre;
        String cedula;
        String ciudad_origen;

        public Ciudadano() {
        }

        public Ciudadano(String nombre, String cedula, String ciudad_origen) {
            this.nombre = nombre;
            this.cedula = cedula;
            this.ciudad_origen = ciudad_origen;

        }

        @Override
        public String toString() {
            return "Ciudadano [nombre=" + nombre + ", cedula=" + cedula + ", ciudad_origen=" + ciudad_origen + "]";
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCedula() {
            return cedula;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }

        public String getCiudad_origen() {
            return ciudad_origen;
        }

        public void setCiudad_origen(String ciudad_origen) {
            this.ciudad_origen = ciudad_origen;
        }

    }


    public String getPartido_politico() {
        return partido_politico;
    }

    public void setPartido_politico(String partido_politico) {
        this.partido_politico = partido_politico;
    }

    public String getLista_promesas() {
        return lista_promesas;
    }

    public void setLista_promesas(String lista_promesas) {
        this.lista_promesas = lista_promesas;
        // ssdasdasdSS
    }
    public static boolean seleccionar_Orientacion_Politica(Scanner scanner) {
        int opcion;

        do {
            System.out.println("Selecciona tu orientación política:");
            System.out.println("1. Derecha");
            System.out.println("2. Izquierda");
            System.out.print("Ingresa el número de la opción (1 o 2): ");
            opcion = scanner.nextInt();

            if (opcion != 1 && opcion != 2) {
                System.out.println("Opción no válida. Por favor, elige 1 o 2.");
            }
        } while (opcion != 1 && opcion != 2);
        boolean esDerecha = (opcion == 1);//comprueba si eligio derecha  y retorna false o true
        return esDerecha;
    }
    public static String seleccionar_Ciudad_Origen(Scanner scanner) {
        enum city {
            Cali,Palmira,Candelaria,Dagua,ElCerrito,
            Florida,Jamundi,LaCumbre,Pradera,Vijes,
            Yumbo,tulua,buga;
        }
        System.out.println("\nPor favor elige una ciudad entre las siguientes");
        for (city city : city.values()) {
            System.out.println(city.ordinal() + ". " + city);
        }
        while (true) {
            int opcion = scanner.nextInt();
            if (opcion >= 0 && opcion < city.values().length) {
                System.out.println("\nHas seleccionado a " + city.values()[opcion] + " como ciudad de origen");
                return (city.values()[opcion]).toString();
            }
            System.out.println("\nOpción no válida. Por favor ingrese una opciona valida");
        }
    }
    public static String crear_Lista_Promesas(Scanner scanner) {
        String promesas = "Promesas funcion faltante:";
        return promesas;
    }

    public static Candidatos crear_Candidatos(Scanner scanner){//Crear candidatos
     scanner.nextLine();
     System.out.print("ingrese el nombre del ciudadano: ");   
     String nombre = scanner.nextLine();
     System.out.print("ingrese la cedula del ciudadano: ");   
     String cedula = scanner.nextLine();
     String ciudad = Candidatos.seleccionar_Ciudad_Origen(scanner);//selecciona la ciudad de origen
     boolean orientacion = Candidatos.seleccionar_Orientacion_Politica(scanner);//selecciona la orientacion politica
     String promesas = Candidatos.crear_Lista_Promesas(scanner);//crea las promesas
     Candidatos candidato = new Candidatos(nombre, cedula, ciudad, orientacion , promesas);//inserta los valores seleccionados para crear un nuevo candidato
     return candidato;
    }
}