package Model;

import java.util.LinkedList;

public class Modelo {
    private final static int puntosVictoria = 101;
    private final static int puntosTute = 101;
    private final static int puntosCantico40= 40;
    private final static int puntosCantico20 = 20;

    private LinkedList<Jugador> jugadores;
    private Baraja baraja;
    private Palo paloTriunfo;
    private Integer turno = 0;
    private Integer tantosAcumuladosBaza = 0;
    private Carta cartaGanadoraBaza; // Exclusivamente para mantener la carta mas alta
    private Integer turnoGanadorBaza;


    public Modelo(){
        jugadores = new LinkedList<>();
        baraja = new Baraja();
        cartaGanadoraBaza = new Carta(0, Palo.COPA);
        cartaGanadoraBaza.setValor(0);
        cartaGanadoraBaza.setValorTantos(0);
    }

    public void agregarjugador(String nombre){
        jugadores.add(new Jugador(nombre));
    }

    public void repartirCartas(){
        baraja = new Baraja();
        baraja.mezclar();
        Carta cartaTriunfo = baraja.repartirCartas(jugadores);
        paloTriunfo = cartaTriunfo.getPalo();
    }

    public void jugarCarta(Integer nro){
        Carta cartaJugada = jugadores.get(turno).jugarCarta(nro);
        tantosAcumuladosBaza += cartaJugada.getValorTantos();
        Boolean CartaJugadaEsMayor = cartaJugada.esMayor(cartaGanadoraBaza, paloTriunfo);
        if(cartaJugada.esMayor(cartaGanadoraBaza, paloTriunfo) || cartaGanadoraBaza == null){
            cartaGanadoraBaza = cartaJugada;
            turnoGanadorBaza = turno;
        }
    }

    public Integer esPareja(Integer turno){
        int pareja = -1;
        switch (turno){
            case 0:
                pareja = 2;
                break;
            case 1:
                pareja = 3;
                break;
            case 2:
                pareja = 0;
                break;
            case 3:
                pareja = 1;
                break;
        }
        return pareja;
    }

    public Boolean existeCanticoPosible(){
        Boolean cantico40 = (jugadores.get(turnoGanadorBaza).puedeHacerCantico40(paloTriunfo) || (jugadores.get(esPareja(turnoGanadorBaza)).puedeHacerCantico40(paloTriunfo)));
        Boolean cantico20 = (jugadores.get(turnoGanadorBaza).puedeHacerCantico20(paloTriunfo) || jugadores.get(esPareja(turnoGanadorBaza)).puedeHacerCantico20(paloTriunfo));
        Boolean tute = (jugadores.get(turnoGanadorBaza).puedeHacerTute() || jugadores.get(esPareja(turnoGanadorBaza)).puedeHacerTute());

        return (cantico40 || cantico20 || tute);
    }

    public Boolean jugarCantico40(){
        //Si el ganador o su pareja pueden hacer este canntico retorna true y asigna los puntos
        Boolean res = false;
        if(jugadores.get(turnoGanadorBaza).puedeHacerCantico40(paloTriunfo) || (jugadores.get(esPareja(turnoGanadorBaza)).puedeHacerCantico40(paloTriunfo))) {
            jugadores.get(turnoGanadorBaza).agregarPuntos(puntosCantico40);
            res = true;
        }
        return res;
    }
    public Boolean jugarCantico20(){
        //Si el ganador o su pareja pueden hacer este canntico retorna true y asigna los puntos
        Boolean res = false;
        if(jugadores.get(turnoGanadorBaza).puedeHacerCantico20(paloTriunfo) || jugadores.get(esPareja(turnoGanadorBaza)).puedeHacerCantico20(paloTriunfo)){
            jugadores.get(turnoGanadorBaza).agregarPuntos(puntosCantico20);
            res = true;
        }
        return res;
    }
    public Boolean jugarTute(){
        //Si el ganador o su pareja pueden hacer este canntico retorna true y asigna los puntos
        Boolean res = false;
        if(jugadores.get(turnoGanadorBaza).puedeHacerTute() || jugadores.get(esPareja(turnoGanadorBaza)).puedeHacerTute()){
            jugadores.get(turnoGanadorBaza).agregarPuntos(puntosTute);
            res = true;
        }
        return res;
    }

    public Integer getTurnoGanadorBaza() {
        return turnoGanadorBaza;
    }

    public String mostrarCartasJugadorActual(){
        return jugadores.get(turno).mostrarCartas();
    }

    public String getPaloTriunfo() {
        return Carta.paloToString(paloTriunfo);
    }

    public Integer hayGanador(){
        //Si hay un ganador retorna el numero de la pareja ganadora
        Integer parejaGanadora = 0;
        if((jugadores.get(0).getPuntos() + jugadores.get(2).getPuntos() == puntosVictoria)){
            //controlador.hayGanador("El equipo numero 1 de " + jugadores.get(0) + jugadores.get(1));
            parejaGanadora = 1;
        }else if((jugadores.get(1).getPuntos() + jugadores.get(3).getPuntos() == puntosVictoria)){
            //controlador.hayGanador("El equipo numero 2 de " + jugadores.get(2) + jugadores.get(3));
            parejaGanadora = 2;
        }

        return parejaGanadora;
    }

    public String getNombreJugadorEnTurno(){
        return jugadores.get(turno).getNombre();
    }

    public String getNombreJugador(Integer nroJugador){
        return jugadores.get(nroJugador).getNombre();
    }

    public Integer getTantosAcumuladosBaza() {
        return tantosAcumuladosBaza;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public boolean bazaTerminada(){
        if(turno == 4) {
            jugadores.get(turnoGanadorBaza).agregarPuntos(tantosAcumuladosBaza);
        }

        return turno == 4;
    }
    public void siguienteTurno(){
        if(turno == 4){
            turno = 0;
        }else{
            turno += 1;
        }
    }

    public Boolean jugadoresSinCartas(){
        return jugadores.get(0).manoVacia() ||  jugadores.get(1).manoVacia() ||  jugadores.get(2).manoVacia() ||  jugadores.get(3).manoVacia();
    }


}
