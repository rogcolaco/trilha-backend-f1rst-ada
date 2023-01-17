import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {

        CaixaEntrada ce = new CaixaEntrada();
        Email email1 = new Email();
        email1.setEnd_remetente("manovoutomarbanho@gmail.com");
        email1.setAssunto("Mandem pix");
        email1.setData_envio(LocalDate.of(2022,10,10));
        email1.setData_recebimento(LocalDate.of(2022,10,10));
        email1.setTexto("Bla bla");

        Email email2 = new Email();
        email2.setEnd_remetente("manovoutomarbanho@gmail.com");
        email2.setAssunto("Mandem pix");
        email2.setData_envio(LocalDate.of(2023,01,16));
        email2.setData_recebimento(LocalDate.of(2023,01,16));
        email2.setTexto("Bla bla");

        Email email3 = new Email();
        email3.setEnd_remetente("cotato@patatipatata.com");
        email3.setAssunto("Mandem pix");
        email3.setData_envio(LocalDate.of(2022,06,10));
        email3.setData_recebimento(LocalDate.of(2022,06,10));
        email3.setTexto("Bla bla");

        ce.adicionarEmail(email1);
        ce.adicionarEmail(email2);
        ce.adicionarEmail(email3);
        ce.totalCatalogoEndereco();
        ce.totalEmailsPorRemetente("cotato@patatipatata.com");
        ce.removerEmailsAntigos(LocalDate.of(2022,07,10));
        ce.totalCatalogoEndereco();
        ce.totalEmailsPorRemetente("manovoutomarbanho@gmail.com");
//        ce.totalEmailsPorRemetente("cotato@patatipatata.com");
        ce.listarRemetentesDeHoje();

    }

}
