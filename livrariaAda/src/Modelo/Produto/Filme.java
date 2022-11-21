package Modelo.Produto;

import Enum.GeneroFilme;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Filme extends Produto{
    private String estudioFilme;
    private List<String> listaDiretores;
    private List<String> listaProdutores;
    private List<GeneroFilme> listaGenerosFilme;

    @Override
    public String toString() {
        return "Categoria Filme {" +
                "id=" + this.getId() +
                ", nome='" + this.getNome() +
                ", preco=" + this.getPreco() +
                ", quantidade=" + this.getQuantidade() +
                ", estudioFilme='" + estudioFilme + '\'' +
                ", listaDiretores=" + listaDiretores +
                ", listaProdutores=" + listaProdutores +
                ", listaGenerosFilme=" + listaGenerosFilme +
                '}';
    }
}
