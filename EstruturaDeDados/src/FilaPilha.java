import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class FilaPilha {
    Scanner s = new Scanner(System.in);
    Queue<String> fila = new LinkedList<>();
    Stack<String> pilha = new Stack<>();

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

    public int MenuSecundario(String tipoEstrutura) throws Exception {
        System.out.println("\nMenu Fila - Escolha a opcao desejada");
        System.out.println("1 - Adicionar item à " + tipoEstrutura);
        System.out.println("2 - Revomer item da " + tipoEstrutura);
        System.out.println("3 - Lista itens da " + tipoEstrutura);
        System.out.println("0 - Voltar");
        try{
            return s.nextInt();
        } catch (Exception e){
            throw new Exception("Falha de conversao");
        }
    }

    public void EscolhaMenuSecundario(int opcaoMenuSecundario, int opcaoMenuPrincipal){
        s.nextLine();
        if (opcaoMenuPrincipal == 1 ) {
            this.TratarDadosFila(opcaoMenuSecundario);
        }

        if (opcaoMenuPrincipal == 2) {
            this.TratarDadosPilha(opcaoMenuSecundario);
        }

    }

    public void TratarDadosFila(int opcaoMenuSecundario){
        switch (opcaoMenuSecundario) {
            case 1:
                String valor = s.nextLine();
                fila.add(valor);
                break;

            case 2:
                if (fila.size() > 0) {
                    System.out.println("Item removido com sucesso: " + fila.poll() + "\n");
                } else {
                    System.out.println("Fila vazia\n");
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

    public void TratarDadosPilha(int opcaoMenuSecundario){
        switch (opcaoMenuSecundario) {
            case 1:
                String valor = s.nextLine();
                pilha.push(valor);
                break;

            case 2:
                if (!pilha.isEmpty()) {
                    System.out.println("Item removido com sucesso: " + pilha.pop() + "\n");
                } else {
                    System.out.println("Pìlha Vazia\n");
                }
                break;

            case 3:
                System.out.println("Itens na pilha: " + pilha + "\n");
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
            int opcaoMenuSecundario;
            switch (opcaoMenuPrincipal){
                case 1:
                    opcaoMenuSecundario = filaPilha.MenuSecundario("fila");
                    filaPilha.EscolhaMenuSecundario(opcaoMenuSecundario , opcaoMenuPrincipal);
                    break;

                case 2:
                    opcaoMenuSecundario = filaPilha.MenuSecundario("pilha");
                    filaPilha.EscolhaMenuSecundario(opcaoMenuSecundario , opcaoMenuPrincipal);
                    break;

                case 0:
                    System.out.println("Obrigado por utilizar nosso sitema\n");
                    break;

                default:
                    System.out.println("Por favor escolha uma opção válida\n");
            }
            opcaoMenuPrincipal = filaPilha.MenuPrincipal();
            System.out.println(opcaoMenuPrincipal);
        }
    }
}
