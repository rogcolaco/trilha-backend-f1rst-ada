package Modelo.Produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private int id;
    private String nome;
    private double preco;
    private int quantidade;
    private Boolean produtoParaAdulto = Boolean.FALSE;

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", rótulo=" + produtoParaAdulto +
                '}';
    }
}
