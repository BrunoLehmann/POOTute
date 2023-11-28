import Controlador.Controlador;
import Model.Modelo;
import Vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        Controlador controlador;
        VistaConsola vista;

        vista = new VistaConsola();
        controlador = new Controlador(vista);
        controlador.iniciar();


    }
}