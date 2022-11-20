package Modelo.Caixa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Caixa {
    private double valorTotalCaixa = 0.0;

    public void efetivarCompra(Double valorCompra){
        valorTotalCaixa += valorCompra;
    }
}
