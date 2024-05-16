package juego;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {

    private ArrayList<Carta> mazo;
    
    public Mazo(){
        this.init();
        this.barajar();
    }

    private void init(){
        mazo = new ArrayList<Carta>();
        for (int i = 0; i < 40; i++) {
            mazo.add(new Carta(i));
        }
    }

    public Carta getCarta(){
        return mazo.get(0);
    }

    public ArrayList<Carta> getCartas() {
        return mazo;
    }

    public void barajar(){
        Collections.shuffle(mazo);
    }

    public Carta extrae(){
        return mazo.remove(0);
    }
}
