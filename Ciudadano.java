import java.util.Scanner;


public class Ciudadano {

    String nombre;
    String cedula;
    String ciudad_origen;
    
    Scanner scanner = new Scanner(System.in); 

    public Ciudadano(String nombre, String cedula, String ciudad_origen){
        this.nombre = nombre;
        this.cedula = cedula;
        this.ciudad_origen = ciudad_origen;
 
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


//fghjkhgfd

public static void pedir_ciudad(){
     System.out.println("ahora seleccione la ciudad de origen: ");
     for (Ciudad_origen ciudad : Ciudad_origen.values()){
          System.out.println("ciudad: " + ciudad);
          
     }

} 


public static Ciudadano crear_Ciudadano(Scanner scanner){
     System.out.print("ingrese el nombre del ciudadano: ");   
     String nombre = scanner.nextLine();
     System.out.print("ingrese la cedula del ciudadano: ");   
     String cedula = scanner.nextLine();
     System.out.print("ingrese la ciudad de origen del ciudadano: ");   
     String ciudad_origen = scanner.nextLine();
     
     Ciudadano ciudadano = new Ciudadano(nombre, cedula, ciudad_origen);
     return ciudadano;
     }

}



