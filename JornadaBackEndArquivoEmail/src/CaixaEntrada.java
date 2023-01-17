import java.time.LocalDate;

public class CaixaEntrada {

    private MailMap caixaEntrada = new MailMap();

    public MailMap getCaixaEntrada() {
        return caixaEntrada;
    }

    public void setCaixaEntrada(MailMap caixaEntrada) {
        this.caixaEntrada = caixaEntrada;
    }

    public void adicionarEmail(Email email){
        caixaEntrada.add(email);
    }

    public void totalCatalogoEndereco(){
        System.out.println(caixaEntrada.getTotal());
    }

    public void totalEmailsPorRemetente(String remetente) throws Exception {
        System.out.println(caixaEntrada.getTotalPorRemetente(remetente));
    }

    public void removerEmailsAntigos(LocalDate localDate){
        caixaEntrada.removerEmailsPorData(localDate);
    }

}
