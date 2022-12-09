import lombok.Getter;
import lombok.Setter;


public class ListaEncadeada<T> {

    @Getter
    @Setter
    public class ItemListaEncadeada<K> {
        private K dado;
        private ItemListaEncadeada<K> anterior;
        private ItemListaEncadeada<K> proximo;
    }

    ItemListaEncadeada<T> primeiroItem;
    ItemListaEncadeada<T> ultimoItem;
    int tamanho = 0;

    public ListaEncadeada() {}

    public T add(T dado){
        if(primeiroItem==null){
            this.primeiroItem = new ItemListaEncadeada<>();
            primeiroItem.setDado(dado);
            ultimoItem = primeiroItem;
        } else {
            ItemListaEncadeada<T> item = new ItemListaEncadeada<>();
            item.setDado(dado);
            item.setAnterior(ultimoItem);
            ultimoItem.setProximo(item);
            ultimoItem = item;
        }
        /*System.out.println(primeiroItem.getDado());
        System.out.println(ultimoItem==null?"":ultimoItem.getDado());
        System.out.println(primeiroItem);
        System.out.println(ultimoItem);
        System.out.println();
        System.out.println();*/
        tamanho++;
        return dado;
    }

    public T get(int posicao) throws Exception {
        this.validateRulesList(posicao);

        ItemListaEncadeada<T> item;
        if (posicao < tamanho/2){
            item = primeiroItem;
            for (int i = 0; i < posicao; i++) {
                item = item.getProximo();
            }
        } else {
            item = ultimoItem;
            for (int i = tamanho - 1; i > posicao; i--) {
                item = item.getAnterior();
            }
        }
        return item.getDado();
    }

    private ItemListaEncadeada<T> getItem(int posicao) throws Exception {
        this.validateRulesList(posicao);

        if (posicao == 0) return primeiroItem;

        ItemListaEncadeada<T> item = primeiroItem;

        for (int i = 0; i < posicao; i++) {
            item = item.getProximo();
        }

        return item;
    }

    public T remove(int posicao) throws Exception {

        if (posicao == 0) {
            T dado = primeiroItem.getDado();
            primeiroItem = primeiroItem.getProximo();
            return dado;
        }

        ItemListaEncadeada<T> itemAtual = this.getItem(posicao);
        ItemListaEncadeada<T> itemAnterior = itemAtual.getAnterior();

        if (itemAtual == ultimoItem) {
            ultimoItem = itemAnterior;
            itemAnterior.setProximo(null);
        } else {
            itemAnterior.setProximo(itemAtual.getProximo());
        }

        return itemAtual.getDado();
    }

    public T validateRulesList(int posicao) throws Exception {
        if (posicao < 0) throw new Exception("Posição não pode ser negativa");
        if (posicao >= tamanho) throw new IndexOutOfBoundsException("Posição acima do tamanho da lista");

        return null;
    }

    public void printList() {
        ItemListaEncadeada<T> item = primeiroItem;

        System.out.println("\n");
        System.out.println("primeiroItem: " +  primeiroItem.getDado());
        System.out.println("ultimoItem: "  + ultimoItem.getDado());

        while (item.getProximo() != null) {
            System.out.println(item.getDado());
            item = item.getProximo();
        }

        System.out.println(item.getDado());
    }

    public void printListReverse() {
        ItemListaEncadeada<T> item = ultimoItem;

        System.out.println("\n");
        System.out.println("primeiroItem: " +  ultimoItem.getDado());
        System.out.println("ultimoItem: "  + primeiroItem.getDado());

        while (item.getAnterior() != null) {
            System.out.println(item.getDado());
            item = item.getAnterior();
        }

        System.out.println(item.getDado());
    }

    public static void main(String[] args) throws Exception {
        ListaEncadeada<String> listaEncadeada = new ListaEncadeada<>();

        listaEncadeada.add("Ana");
        listaEncadeada.add("André");
        listaEncadeada.add("Ultimo");
        listaEncadeada.add("Fábio");
        listaEncadeada.add("Tite");
        listaEncadeada.add("Neymar");
        listaEncadeada.add("Cristiano");
        listaEncadeada.add("Messi");

        listaEncadeada.printList();

        listaEncadeada.printListReverse();

        System.out.println("####");
        System.out.println(listaEncadeada.get(3));
        System.out.println(listaEncadeada.get(5));

        //lista.remove(3);

        //lista.printList();
    }

}

