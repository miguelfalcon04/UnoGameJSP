package juego;

public class Carta {
    public static final String[] colores={"Amarillo", "Verde", "Azul", "Rojo"};
    public static final String[] numeros={"Cero", "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve"};
    private int id;

    public Carta(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getColores() {
        return Carta.colores[(int)(this.id/10)];
    }

    String getNumeroAsString(){
        return Carta.numeros[(int)(this.id%10)];
    }

    public int getNumeroAsInt(){
        return (int)(this.id%10);
    }

}
