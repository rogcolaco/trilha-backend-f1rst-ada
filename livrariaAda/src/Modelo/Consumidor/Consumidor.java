package Modelo.Consumidor;

import Modelo.Estoque.EstoqueGenerico;
import Modelo.Produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Consumidor {
    private String nome;
    private String email;

}
