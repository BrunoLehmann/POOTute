package Model;

import java.util.LinkedList;

public class AdminCantico {


    public Boolean tieneCantico40(LinkedList<Carta> mano, Palo paloTriunfo){
        //Retorna True si el jugador tiene en su mano 11 y 12 del palo del triunfo
        boolean doceTriunfo = false;
        boolean onceTriunfo = false;
        for(Carta carta : mano){
            if ((carta.getNumero() == 12) && (carta.getPalo() == paloTriunfo)){
                doceTriunfo = true;
            }else if((carta.getNumero() == 11) && (carta.getPalo() == paloTriunfo)){
                onceTriunfo = true;
            }
        }

        return (doceTriunfo && onceTriunfo);
    }

    public Boolean tieneCantico20(LinkedList<Carta> mano, Palo paloTriunfo){
        //retorna true si el jugador tiene en su mano 11 y 12 del mismo palo pero distinto del de triunfo
        boolean puede = false;
        for(Carta cartaDoce : mano){
            if ((cartaDoce.getNumero() == 12) && (cartaDoce.getPalo() != paloTriunfo)){
                for(Carta cartaOnce : mano){
                    if ((cartaOnce.getNumero() == 11) && (cartaOnce.getPalo() != cartaDoce.getPalo())){
                        puede = true;
                        break;
                    }
                }
            }
        }
        return ((puede));
    }

    public Boolean tieneTute(LinkedList<Carta> mano){
        //Si tiene todos los doces o todos los onces pude hacer tute
        boolean todosDoces = false;
        Integer cantDoces = 0;
        Integer cantOnces = 0;
        for(Carta carta : mano){
            if (carta.getNumero() == 12){
                cantDoces += 1;
            }else if(carta.getNumero() == 11){
                cantOnces += 1;
            }
        }
        return ((cantDoces == 4 || cantOnces == 4));
    }


}
