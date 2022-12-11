import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaPilha {
    Scanner s = new Scanner(System.in);
    Queue<String> fila = new LinkedList<>();

    public int MenuPrincipal () throws Exception {
        System.out.println("Menu Pricipal - Escolha a estrutura que deseja alterar");
        System.out.println("1 - Fila");
        System.out.println("2 - Pilha");
        System.out.println("0 - Sair");
        try{
            return s.nextInt();
        } catch (Exception e){
            throw new Exception("Falha de conversao");
        }
    }

    public int MenuFila() throws Exception {
        System.out.println("\nMenu Fila - Escolha a opcao desejada");
        System.out.println("1 - Adicionar item à fila");
        System.out.println("2 - Revomer item da fila");
        System.out.println("3 - Lista itens da Fila");
        System.out.println("0 - Voltar");
        try{
            return s.nextInt();
        } catch (Exception e){
            throw new Exception("Falha de conversao");
        }
    }

    public void EscolhaFila(int opcaoMenuFila){
        s.nextLine();
        switch (opcaoMenuFila) {
            case 1:
                String valor = s.nextLine();
                fila.add(valor);
                break;

            case 2:
                if (fila.size() > 0) {
                    System.out.println("Item removido com sucesso: " + fila.poll() + "\n");
                } else {
                    System.out.println("lista Vazia\n");
                }
                break;

            case 3:
                System.out.println("Itens na Fila: " + fila + "\n");
                break;

            case 0:
                System.out.println("Retornando ao menu principal\n");

            default:
                System.out.println("Por favor escolha uma opção válida\n");
        }
    }

    public static void main(String[] args) throws Exception {
        FilaPilha filaPilha = new FilaPilha();
        int opcaoMenuPrincipal = filaPilha.MenuPrincipal();
        while (opcaoMenuPrincipal != 0 ){
            switch (opcaoMenuPrincipal){
                case 1:
                    int opcaoMenuFila = filaPilha.MenuFila();
                    filaPilha.EscolhaFila(opcaoMenuFila);
                    break;

                case 2:
                    break;

                case 0:
                    System.out.println("Obrigado por utilizar nosso sitema\n");
                    break;

                default:
                    System.out.println("Por favor escolha uma opção válida\n");
            }
            opcaoMenuPrincipal = filaPilha.MenuPrincipal();
        }
    }
}
