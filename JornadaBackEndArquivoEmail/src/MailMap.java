import java.util.LinkedHashMap;
import java.util.LinkedList;

public class MailMap {

    private LinkedHashMap<String, LinkedList<MailMap>> mapMail;

    public LinkedHashMap<String, LinkedList<MailMap>> getMapMail() {
        return mapMail;
    }

    public void setMapMail(LinkedHashMap<String, LinkedList<MailMap>> mapMail) {
        this.mapMail = mapMail;
    }
}
