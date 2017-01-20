import java.io.StringReader;
import java.sql.SQLException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import com.cltz.cs.datatrans.AuthorizationRQ;

public class JAXBExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

     try {
String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
"<AuthorizationRQ>\n" +
"   <POS>\n" +
"      <Source AgentSine=\"1234\" AgentDutyCode=\"1cb23124yr4536524\">\n" +
"         <RequestorID ID=\"11810\" />\n" +
"      </Source>\n" +
"   </POS>\n" +
"   <request>\n" +
"      <amount>1234</amount>\n" +
"      <currency>CHE</currency>\n" +
"      <aliasCC>4242424242424242</aliasCC>\n" +
"      <expm>06</expm>\n" +
"      <expy>18</expy>\n" +
"   </request>\n" +
"</AuthorizationRQ>";
        //File file = new File("abc.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(AuthorizationRQ.class); 
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        //Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
        AuthorizationRQ auth = (AuthorizationRQ) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        AuthorizationRQ.Request request = auth.getRequest();
        AuthorizationRQ.POS pos = auth.getPOS();
        AuthorizationRQ.POS.Source source = pos.getSource();
        AuthorizationRQ.POS.Source.RequestorID id = source.getRequestorID();
        System.out.println(""+auth);
        System.out.println("Amount :"+request.getAmount() + "\n Currency :"+request.getCurrency() + "\n AliasCC: "+request.getAliasCC());
        System.out.println("Agentsine :" +source.getAgentSine() + "\nRequestorID :"+id.getID());
                          
                
              //  Database data = new Database(customer);
      } catch (JAXBException e) {
        e.printStackTrace();
      }

    }
}
