package Model;

import java.util.Collections;
import java.util.LinkedList;

public class Baraja {
    private LinkedList<Carta> mazo;

    public Baraja(){
        //  Creo todas las cartas y las agrego al mazo
        mazo = new LinkedList<Carta>();
        for(Palo palo : Palo.values()){
            for(int i = 1; i < 13;i++){
                Carta carta = new Carta(i, palo);
                mazo.add(carta);
            }
        }
        asignarValoresACartas();
    }

    public void asignarValoresACartas(){
        //Asigno los valores para comparar las cartas y los valores de los tantos que suman.
        for(Carta carta : mazo) {
            switch (carta.getNumero()) {
                case 1:
                    carta.setValor(12);
                    carta.setValorTantos(11);
                    break;
                case 2:
                    carta.setValor(1);
                    carta.setValorTantos(0);
                    break;
                case 3:
                    carta.setValor(11);
                    carta.setValorTantos(10);
                    break;
                case 4:
                    carta.setValor(2);
                    carta.setValorTantos(0);
                    break;
                case 5:
                    carta.setValor(3);
                    carta.setValorTantos(0);
                    break;
                case 6:
                    carta.setValor(4);
                    carta.setValorTantos(0);
                    break;
                case 7:
                    carta.setValor(5);
                    carta.setValorTantos(0);
                    break;
                case 8:
                    carta.setValor(6);
                    carta.setValorTantos(0);
                    break;
                case 9:
                    carta.setValor(7);
                    carta.setValorTantos(0);
                    break;
                case 10:
                    carta.setValor(8);
                    carta.setValorTantos(2);
                    break;
                case 11:
                    carta.setValor(9);
                    carta.setValorTantos(3);
                    break;
                case 12:
                    carta.setValor(10);
                    carta.setValorTantos(4);
                    break;
            }
        }
    }

    public Carta repartirCartas(LinkedList<Jugador> jugadores){
        //Se reparten 10 cartas a cada jugador, especial para el modo 4 jugadores y se retorna la carta del TRIUNFO
        //que es la ultima carta. Por ahora arranca siempre jugador 0
        Carta cartaTriunfo = null;


        for (int i = 1 ; i <= 10; i++){
            for (Jugador jugador : jugadores) {
                cartaTriunfo = mazo.remove();
                jugador.agregarCarta(cartaTriunfo);
            }
        }

        return cartaTriunfo;
    }

    public void mezclar(){
        //Mezclo el mazo
        Collections.shuffle(mazo);
    }


}
