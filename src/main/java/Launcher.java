import translator.*;
import translator.interfaces.Message;

import java.util.ArrayList;
import java.util.List;

public class Launcher {


    public static void main(String[] args) {

        // data fixtures (based on String couple)
        LangTranslator langTranslator1 = new LangTranslator();
        langTranslator1.setHumanMsgContent("hello");
        langTranslator1.setKlingonMsgContent("kapla");
        List<LangTranslator> langTranslatorList = new ArrayList<>();
        langTranslatorList.add(langTranslator1);
        TranslatorManager.Instance.setTranslators(langTranslatorList);

        // instantiate translation service
        TranslatorService translatorService = new TranslatorService();


        // simulate klingon emission
        KlingonMsg klingonMsg = new KlingonMsg("kapla");

        Message receivedMessage = translatorService.processMessage(klingonMsg);

        if (receivedMessage != null){
            System.out.println(receivedMessage.getOrigin());
            System.out.println(receivedMessage.getContent());
            System.out.println("GOOD Translator");
        }

        // simulate human emission
        HumanMsg humanMsg = new HumanMsg("hello");
        receivedMessage = translatorService.processMessage(humanMsg);

        if (receivedMessage != null){
            System.out.println(receivedMessage.getOrigin());
            System.out.println(receivedMessage.getContent());
            System.out.println("GOOD Translator");
        }

    }
}
