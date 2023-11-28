package Model;

public class Carta {
    private Integer numero;
    private Integer valor;
    private Integer valorTantos;
    private Palo palo;

    public Carta(Integer numero, Palo palo){
        if((numero > 0) && (numero < 13)) {
            this.numero = numero;
            this.palo = palo;
        }
    }

    public static String paloToString(Palo palo){
        //Retorna el string correspondiente a cada palo del enumarado, es estatica para poder fuera de instancias.
        String res = "";
        switch (palo){
            case COPA: res = "Copa";
                break;
            case ESPADA: res = "Espada";
                break;
            case ORO: res = "Oro";
                break;
            case BASTO: res = "Basto";
                break;
        }
        return res;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public void setValorTantos(Integer valorTantos) {
        this.valorTantos = valorTantos;
    }

    public Integer getNumero(){
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public Integer getValorTantos() {
        return valorTantos;
    }

    public Boolean esMayor(Carta carta, Palo paloTriunfo){
        //Retorna true si esta carta es mayor que la enviada por parametro
        boolean res = false;
        if (this.palo == carta.palo){
            //Cartas del mismo palo gana la de mayor valor
            res = this.valor > carta.valor;

        }else{
            //Si son de distinto palo gana la que sea del palo del triunfo
            res = this.palo == paloTriunfo;
            res = !(carta.palo == paloTriunfo); //Su carta es del triunfo y la mia no, retorno false porque la suya es mayor.

            if (this.palo != paloTriunfo && carta.palo != paloTriunfo){
                res = this.valor > carta.valor;;
            }
            if(carta.valor == 0){
               res = true;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        res = "| " + numero  + " " + paloToString(palo) + " |";
        return res;
    }
}
