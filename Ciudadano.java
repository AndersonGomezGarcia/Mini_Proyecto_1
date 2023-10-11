import java.util.Scanner;


public class Ciudadano {

    String nombre;
    String cedula;
    String ciudad_origen;
    
    

    public Ciudadano() {
}

public Ciudadano(String nombre, String cedula, String ciudad_origen){
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


//fghjkhgfd

public static String pedir_ciudad(){
     System.out.println("ahora seleccione la ciudad de origen: ");
     String ciudad_digitada = "";
     for (Ciudad_origen ciudad : Ciudad_origen.values()){
          System.out.println("ciudad: " + ciudad);
          
          Scanner elegir = new Scanner(System.in);
          String ciudadDigitada = elegir.nextLine();
          if (ciudadDigitada.equals(ciudad.toString())){
              ciudad_digitada = ciudadDigitada;
               break;
               
          }

     }
     
     return ciudad_digitada;
} 



public static Ciudadano crear_Ciudadano(Scanner scanner, String ciudad_digitada){
     System.out.print("ingrese el nombre del ciudadano: ");   
     String nombre = scanner.nextLine();
     System.out.print("ingrese la cedula del ciudadano: ");   
     String cedula = scanner.nextLine();
     Ciudadano.pedir_ciudad();
     
     Ciudadano ciudadano = new Ciudadano(nombre, cedula, ciudad_digitada);
     return ciudadano;
     }

}



