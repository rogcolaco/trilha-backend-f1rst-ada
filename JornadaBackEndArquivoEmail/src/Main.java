public class Main {

    public static void main(String[] args) {

        CaixaEntrada ce = new CaixaEntrada();
        Email email1 = new Email();
        email1.setEnd_remetente("manovoutomarbanho@gmail.com");
        email1.setAssunto("Mandem pix");
        email1.setData_envio("10/05/2022");
        email1.setData_recebimento("10/05/2022");
        email1.setTexto("Bla bla");

        ce.adicionarEmail(email1);
        

    }

}
