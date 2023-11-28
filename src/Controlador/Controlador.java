package Controlador;
import Model.Modelo;
import Vista.VistaConsola;

public class Controlador {
    private VistaConsola vista;
    private Modelo modelo;

    public Controlador(VistaConsola vista){
        this.modelo = new Modelo();
        this.vista = vista;
    }

    public void iniciar(){
        Integer opcion = 0;
        while (opcion != 3) {
            vista.mostrarMenuInicio();
            opcion = vista.pedirOpcionNumero();
            switch (opcion) {
                case 1:
                    iniciarJuego();
                    break;
                case 2:
                    agregarJugadores();
                    break;
                case 3:
                    vista.mostrarSalidaJuego();
                    break;
            }
        }
    }

    public void agregarJugadores(){
        for(int i = 0; i < 4; i++){
            String nombre = vista.agregarJugador();
            modelo.agregarjugador(nombre);
        }
    }

    public void iniciarJuego(){
        Integer hayGanador = 0;
        modelo.repartirCartas();
        while(hayGanador == 0){
            if(modelo.jugadoresSinCartas()){
                modelo.repartirCartas();
            }
            hayGanador = modelo.hayGanador();
            jugarBaza();
            modelo.setTurno(0);
        }
        vista.mostrarGanador(hayGanador);
        iniciar();
    }

    public void jugarBaza(){
        while(!modelo.bazaTerminada()) {
            //Podria mejorarse haciendo funcion jugarTurno
            String cartasJugadorActual = modelo.mostrarCartasJugadorActual();
            vista.mostrarNombreJugadorEnTurno(modelo.getNombreJugadorEnTurno());
            vista.mostrarPaloDelTriunfo(modelo.getPaloTriunfo());
            vista.mostrarCartasJugador(cartasJugadorActual);
            modelo.jugarCarta(vista.pedirCartaAJugar());
            modelo.siguienteTurno();
        }
        vista.mostrarGanadorBaza(modelo.getNombreJugador(modelo.getTurnoGanadorBaza()), modelo.getTantosAcumuladosBaza());
        // Una vez terminada la baza, la pareja ganadora puede hacer los canticos

        if (modelo.existeCanticoPosible()){
            Integer opcionCanticos = vista.ganadorPuedeHacerCanticos();
            switch (opcionCanticos){
                case 1:
                    vista.mostrarIntentoCantico(modelo.jugarCantico40());
                    break;
                case 2:
                    vista.mostrarIntentoCantico(modelo.jugarCantico20());
                    break;
                case 3:
                    vista.mostrarIntentoCantico(modelo.jugarTute());
                    break;
            }
        }
    }

}
