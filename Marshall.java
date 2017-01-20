/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Teja
 */

/**
 * Sample RQ
 * 
 * <?xml version="1.0" encoding="UTF-8"?>
<AuthorizationRQ>
   <POS>
      <Source AgentSine="1234" AgentDutyCode="1cb23124yr4536524">
         <RequestorID ID="11810" />
      </Source>
   </POS>
   <request>
      <amount>1234</amount>
      <currency>CHE</currency>
      <aliasCC>4242424242424242</aliasCC>
      <expm>06</expm>
      <expy>18</expy>
   </request>
</AuthorizationRQ>

 */

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.cltz.cs.datatrans.AuthorizationRQ;

public class Marshall {
    public static void main(String args[]) {
        try {
            JAXBContext jaxbcontext = JAXBContext.newInstance(AuthorizationRQ.class);
            Marshaller marshaller = jaxbcontext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
            
            AuthorizationRQ auth = new AuthorizationRQ();
            AuthorizationRQ.POS pos = new AuthorizationRQ.POS();
            AuthorizationRQ.Request request = new AuthorizationRQ.Request();
            AuthorizationRQ.POS.Source source = new AuthorizationRQ.POS.Source();
            AuthorizationRQ.POS.Source.RequestorID requestor = new AuthorizationRQ.POS.Source.RequestorID();
            
            short in = 123;
            
            source.setAgentSine(in);
            source.setAgentDutyCode("123456gfdgvf");
            
            requestor.setID((short)12570);
            
            request.setAmount((short)12345);
            request.setCurrency("EUR");
            request.setAliasCC(42424242424242L);
            request.setExpm((byte)06);
            request.setExpy((byte)18);
           
            source.setRequestorID(requestor);
            pos.setSource(source);
            auth.setPOS(pos);
            auth.setRequest(request);
                        
            marshaller.marshal(auth, new FileOutputStream("/home/mahesh/Auth.xml"));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
