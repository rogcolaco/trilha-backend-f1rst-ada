public class Email {

    private String end_remetente;
    private String data_envio;
    private String data_recebimento;
    private String assunto;
    private String texto;

    public String getEnd_remetente() {
        return end_remetente;
    }

    public void setEnd_remetente(String end_remetente) {
        this.end_remetente = end_remetente;
    }

    public String getData_envio() {
        return data_envio;
    }

    public void setData_envio(String data_envio) {
        this.data_envio = data_envio;
    }

    public String getData_recebimento() {
        return data_recebimento;
    }

    public void setData_recebimento(String data_recebimento) {
        this.data_recebimento = data_recebimento;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
