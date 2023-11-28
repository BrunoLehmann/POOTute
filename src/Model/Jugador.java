package Model;

import java.util.LinkedList;

public class Jugador {
    private String nombre;
    private Integer puntos = 0;
    private LinkedList <Carta> mano;
    private AdminCantico cantico;

    public Jugador(String nombre){
        this.nombre = nombre;
        mano = new LinkedList<Carta>();
        cantico = new AdminCantico();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void agregarCarta(Carta carta){
        mano.add(carta);
    }

    public Boolean manoVacia(){
        return mano.isEmpty();
    }

    public void agregarPuntos(Integer puntos){
        this.puntos += puntos;
    }

    public String mostrarCartas(){
        String res = "";
        int i = 1;
        for (Carta carta : mano){
            res += i + " - " + carta.toString() + "\n";
            i += 1;
        }
        return res;
    }

    public Carta jugarCarta(Integer nroCarta){
        Carta carta = mano.get(nroCarta - 1);
        mano.remove(nroCarta-1);
        return carta;
    }

    public Boolean puedeHacerCantico40(Palo paloTriunfo){
        return cantico.tieneCantico40(mano, paloTriunfo);
    }

    public Boolean puedeHacerCantico20(Palo paloTriunfo){
        return cantico.tieneCantico20(mano, paloTriunfo);
    }

    public Boolean puedeHacerTute(){
        return cantico.tieneTute(mano);
    }

    @Override
    public String toString() {
        return "Jugador: " + nombre + " Puntos: " + puntos;
    }


}
