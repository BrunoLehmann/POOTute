package Vista;

import java.io.IOException;
import java.util.Scanner;

public class VistaConsola {

    public String agregarJugador(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del jugador: ");
        return sc.nextLine();
    }

    public static Integer pedirNumeroCarta(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique que carta va a jugar: ");
        return sc.nextInt();
    }

    public Integer pedirOpcionNumero(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione una Opcion: ");
        return sc.nextInt();
    }

    public Integer pedirCartaAJugar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona el numero de carta que deseas jugar: ");
        Integer nroCarta = sc.nextInt();
        while(nroCarta > 10 || nroCarta < 1){
            nroCarta = sc.nextInt();
        }


        return nroCarta;
    }

    public void mostrarMenuInicio(){
        System.out.println("Bienvenido al TUTE!");
        System.out.println("1 - Iniciar Juego");
        System.out.println("2 - Agregar Jugadores");
        System.out.println("3 - Salir");
    }

    public void mostrarNombreJugadorEnTurno(String jugador){
        System.out.println("Es el turno de: " + jugador);
    }

    public void mostrarPaloDelTriunfo(String palo){
        System.out.println("El palo el triunfo es: " + palo);
    }

    public void menuCanticos(){
        System.out.println("1 - Cantico 40");
        System.out.println("2 - Cantico 20");
        System.out.println("3 - Cantico Tute");
        System.out.println("4 - No hacer canticos");
        System.out.println("Seleccione un cantico: ");
    }

    public Integer ganadorPuedeHacerCanticos(){
        System.out.println("La pareja ganadora de la baza tiene canticos disponibles.");
        menuCanticos();
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }


    public void mostrarIntentoCantico(Boolean cantico){
        if(cantico){
            System.out.println("Cantico realizado con exito, se han incrementado tus puntos!");
        }else {
            System.out.println("No tienes lo necesario para hacer ese cantico.");
        }
    }

    public void limpiarPantalla() throws IOException {
        Runtime.getRuntime().exec("clear");
    }

    public void mostrarCartasJugador(String cartas){
        System.out.println(cartas);
    }

    public void mostrarGanadorBaza(String jugador, Integer tantosGanados){
        System.out.println("El ganador de la baza es " + jugador + " y gano " + tantosGanados + "puntos!.");
    }


    public void mostrarGanador(Integer parejaGanadora){
        System.out.println("Juego Finalizado!");
        System.out.println("Los ganadores son la pareja: " + parejaGanadora);
        System.out.println("Felicidades!");
    }

    public void mostrarSalidaJuego(){
        System.out.println("Gracias por jugar! Hasta la proxima!");
    }
}
