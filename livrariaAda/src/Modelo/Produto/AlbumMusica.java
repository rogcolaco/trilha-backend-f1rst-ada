package Modelo.Produto;

import Enum.GeneroMusica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlbumMusica extends Produto{
    private List<String> listaMusicosOuBandas;
    private List<String> listaSelos;
    private List<GeneroMusica> listaGenerosMusicas;

    @Override
    public String toString() {
        return "AlbumMusica {" +
                "id=" + this.getId() +
                ", nome='" + this.getNome() +
                ", preco=" + this.getPreco() +
                ", quantidade=" + this.getQuantidade() +
                ", listaMusicosOuBandas=" + listaMusicosOuBandas +
                ", listaSelos=" + listaSelos +
                ", listaGenerosMusicas=" + listaGenerosMusicas +
                '}';
    }
}
