package translator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import translator.interfaces.Message;

public class TranslatorServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TranslatorServiceTest.class);

    /**
     * Test that Service can correctly return the correct type of message from a KlingonMsg
     */
    @Test
    public void processMessageTest(){
        //Data fixture
        TranslatorService translatorService = new TranslatorService();
        LangTranslator langTranslator1 = new LangTranslator(Languages.KLINGONLANG,"Kapla", Languages.HUMANLANG, "Hello");

        List<LangTranslator> langTranslatorList = new ArrayList<>();
        TranslatorManager.Instance.addTranslator(langTranslator1);


        GenericMsg klingonMsg = new GenericMsg(Languages.KLINGONLANG, "Kapla");
        GenericMsg humanMsg = new GenericMsg(Languages.HUMANLANG, "Hello");

        // Test klingon to human
        Message receivedMessage = translatorService.processMessage(klingonMsg);
        Assert.assertTrue(receivedMessage.getContent().equals("Hello"));
        Assert.assertTrue(receivedMessage.getLang().equals(Languages.HUMANLANG));

        //Test human to klingon
        Message receivedMessage2 = translatorService.processMessage(humanMsg);
        Assert.assertTrue(receivedMessage2.getContent().equals("Kapla"));
        Assert.assertTrue(receivedMessage2.getLang().equals(Languages.KLINGONLANG));
    }
}
