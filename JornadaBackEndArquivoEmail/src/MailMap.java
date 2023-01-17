import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class MailMap {

    private LinkedHashMap<String, LinkedList<Email>> mapMail;

    public LinkedHashMap<String, LinkedList<Email>> getMapMail() {
        return mapMail;
    }

    public MailMap() {
        this.mapMail = new LinkedHashMap<>();
    }

    public void setMapMail(LinkedHashMap<String, LinkedList<Email>> mapMail) {
        this.mapMail = mapMail;
    }

    public void add (Email mail){
        if(mapMail.containsKey(mail.getEnd_remetente())){
            mapMail.get(mail.getEnd_remetente()).add(mail);
        } else {
            LinkedList novoEmail = new LinkedList();
            novoEmail.add(mail);
            mapMail.put(mail.getEnd_remetente(), novoEmail);
        }
    }

    public int getTotal() {
        return getMapMail().size();
    }

    public int getTotalPorRemetente(String remetente) throws Exception {
        if(!mapMail.containsKey(remetente)){
            throw new Exception("Remetente não existe");
        } else{
            return getMapMail().get(remetente).size();
        }
    }

    public void removerEmailsPorData(LocalDate localDate) {
        ArrayList<String> chavesVazias = new ArrayList();

        mapMail.forEach((key, value) -> {
            value.forEach(element -> {
                if (element.getData_recebimento().isBefore(localDate)){
                    value.remove(element);
                }
            });
            if (value.size() == 0) chavesVazias.add(key);
        });
        chavesVazias.forEach(value -> {
            mapMail.remove(value);
        });
    }
}
