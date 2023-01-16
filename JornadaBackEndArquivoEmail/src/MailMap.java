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
}
