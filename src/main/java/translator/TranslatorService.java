package translator;

import translator.interfaces.Message;

/**
 * Service that user TranslatorManager to store translators
 */
public class TranslatorService {

    TranslatorManager translatorManager;


    public TranslatorService() {
        this.translatorManager = TranslatorManager.Instance;
    }

    public Message processMessage(Message msgToProcess) {

        Message messageToReturn = null;

        if (msgToProcess instanceof KlingonMsg) {
            messageToReturn = (Message) processKMessage((KlingonMsg) msgToProcess);
        } else if(msgToProcess instanceof HumanMsg){
            messageToReturn = (Message) processHMsg((HumanMsg) msgToProcess);
        }

        return messageToReturn;
    }

    private Object processKMessage(KlingonMsg msg){
        HumanMsg humanMsgToReturn = null;


        LangTranslator langTranslatorToUse = translatorManager.findBestTranslator(msg);
        if (langTranslatorToUse != null){
            humanMsgToReturn = langTranslatorToUse.toHuman(msg);
        } else{
            System.out.println("ERROR");
        }

        return humanMsgToReturn;
    }

    private Object processHMsg(HumanMsg msg){
        LangTranslator langTranslatorToUse = translatorManager.findBestTranslator(msg);
        KlingonMsg klingonMsgToReturn= langTranslatorToUse.toKlingon(msg);
        return klingonMsgToReturn;
    }
}
