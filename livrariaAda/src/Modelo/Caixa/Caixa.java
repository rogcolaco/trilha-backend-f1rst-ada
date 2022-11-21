package Modelo.Caixa;


import Modelo.Estoque.EstoqueGeral;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Caixa {
    private double valorTotalCaixa = 0.0;
    private static Caixa instance;

    public void efetivarCompra(Double valorCompra){
        valorTotalCaixa += valorCompra;
    }

    private Caixa() {
    }


    public static Caixa getInstance() {
        if(instance == null){
            instance = new Caixa();
        }
        return instance;
    }
}
