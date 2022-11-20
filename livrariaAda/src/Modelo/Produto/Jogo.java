package Modelo.Produto;

import Enum.GeneroJogo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Jogo extends Produto{
    private String distribuidora;
    private GeneroJogo generoJogo;
    private String estudioJogo;

    @Override
    public String toString() {
        return "Jogo {" +
                "id=" + this.getId() +
                ", nome='" + this.getNome() +
                ", preco=" + this.getPreco() +
                ", quantidade=" + this.getQuantidade() +
                ", distribuidora='" + distribuidora + '\'' +
                ", generoJogo=" + generoJogo +
                ", estudioJogo='" + estudioJogo + '\'' +
                '}';
    }
}
