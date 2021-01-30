package translator;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import translator.interfaces.Message;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnitPlatform.class)
public class TranslatorServiceTest {


    /**
     * Test that Service can correctly return the correct type of message from a KlingonMsg
     */
    @Test
    public void TranslatorService2ServiceTest(){
        //Data fixture
        TranslatorService translatorService = new TranslatorService();
        LangTranslator langTranslator1 = new LangTranslator();
        langTranslator1.setHumanMsgContent("hello");
        langTranslator1.setKlingonMsgContent("kapla");
        List<LangTranslator> langTranslatorList = new ArrayList<>();
        langTranslatorList.add(langTranslator1);
        TranslatorManager.Instance.setTranslators(langTranslatorList);

        KlingonMsg klingonMsg = new KlingonMsg("kapla");


        Message receivedMessage = translatorService.processMessage(klingonMsg);

        assert (receivedMessage.getContent().equals("hello"));
        System.out.println(receivedMessage.getOrigin());
        assert receivedMessage.getOrigin().contains("HumanMsg");
    }

    /**
     * Test that Service can correctly return the correct type of message from a HumanMsg
     */
    @Test
    public void TranslatorService2Test(){
        //Data fixture
        TranslatorService translatorService = new TranslatorService();
        LangTranslator langTranslator1 = new LangTranslator();
        langTranslator1.setHumanMsgContent("hello");
        langTranslator1.setKlingonMsgContent("kapla");
        List<LangTranslator> langTranslatorList = new ArrayList<>();
        langTranslatorList.add(langTranslator1);
        TranslatorManager.Instance.setTranslators(langTranslatorList);

        HumanMsg humanMsg = new HumanMsg("hello");


        Message receivedMessage = translatorService.processMessage(humanMsg);

        assert (receivedMessage.getContent().equals("kapla"));
        System.out.println(receivedMessage.getOrigin());
        assert receivedMessage.getOrigin().contains("KlingonMsg");
    }

}