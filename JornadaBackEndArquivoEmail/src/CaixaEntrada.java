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

}
