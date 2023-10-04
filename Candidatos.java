import java.util.Scanner;
public class Candidatos extends Ciudadano {
    
    
    private String orientacion_politica;
    private Derecha partido_derecha;
    private Izquierda partido_izquierda;
    private String partido_politico;
    private String lista_promesas;

        public Candidatos(String nombre, String cedula, String ciudad_origen, Derecha partidoderecha,Izquierda partidoizquierda,String orientacionpolitica, String lista_promesas ){
            super(cedula, ciudad_origen, nombre);
            this.orientacion_politica = orientacionpolitica;
            this.partido_derecha = partidoderecha;
            this.partido_izquierda = partidoizquierda;
            this.lista_promesas = lista_promesas;
      
    } 


    public String getOrientacion_politica() {
        return orientacion_politica;
    }

    public void setOrientacion_politica(String orientacion_politica) {
        this.orientacion_politica = orientacion_politica;
    }

    public Derecha getPartido_derecha() {
        return partido_derecha;
    }

    public void setPartido_derecha(Derecha partido_derecha) {
        this.partido_derecha = partido_derecha;
    }

    public Izquierda getPartido_izquierda() {
        return partido_izquierda;
    }

    public void setPartido_izquierda(Izquierda partido_izquierda) {
        this.partido_izquierda = partido_izquierda;
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
    //ssdasdasdSS
    }
}

