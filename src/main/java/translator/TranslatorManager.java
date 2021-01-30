package translator;

import translator.interfaces.Message;

import java.util.List;

/**
 * Singleton
 */
public enum TranslatorManager {

    Instance;


    private TranslatorManager() {
    }

    private List<LangTranslator> translators;

    public List<LangTranslator> getTranslators() {
        return translators;
    }

    public void setTranslators(List<LangTranslator> translators) {
        this.translators = translators;
    }

    public LangTranslator findBestTranslator(Message message){
        System.out.println("Finding best translator");
        LangTranslator langTranslatorToReturn = null;

        for (LangTranslator langTranslator : translators){
//            if (message.getOrigin().contains("KlingonMsg") && (message.getContent().equals(langTranslator.getKlingonMsgContent()))){
//                langTranslatorToReturn = langTranslator;
//            } else if (message.getOrigin().contains("HumanMsg") && (message.getContent().equals(langTranslator.getHumanMsgContent()))){
//                langTranslatorToReturn = langTranslator;
//            }

            //other version based on instance of (polymorphism)
            if ((message instanceof KlingonMsg) && (message.getContent().equals(langTranslator.getKlingonMsgContent()))){
                langTranslatorToReturn = langTranslator;
            } else if ((message instanceof HumanMsg) && (message.getContent().equals(langTranslator.getHumanMsgContent()))){
                langTranslatorToReturn = langTranslator;
            }


        }
        return langTranslatorToReturn;
    }
}
