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

}
