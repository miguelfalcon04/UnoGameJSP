package juego;

public class CartaTemplate {
    Carta carta;
    private int opc;
    public CartaTemplate(Carta carta, int opc){
        this.carta = carta;
        this.opc=opc;
    }

    @Override
    public String toString(){
        if(opc==2){
            return String.format("<div class=\"carta\"><img src=\"assets/img/reverso.jpg\"></div>");
        }else if(opc==3){
            return String.format("<div class=\"mesa\"><img src=\"assets/img/reverso.jpg\"></div>");
        }else{
            return String.format("<div class=\"carta\"><img src=\"assets/img/%02d.png\"></div>", this.carta.getId());
        }
    }
}