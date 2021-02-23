package translator;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import translator.interfaces.Message;

/**
 * Service that process input generic message with User defined translators, stored in TranslatorManager
 */
public class TranslatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TranslatorService.class);

    /** Manager that aggregates LangTranslator*/
    TranslatorManager translatorManager;

    /**
     * Constructor that References singleton instance of TranslatorManger to field
     */
    public TranslatorService() {
        this.translatorManager = TranslatorManager.Instance;
    }

    /**
     * Process a GenericMessage, find adequate translator if available and use it to send a populated generic Message back
     * @param msgToProcess Any inherited Message Interface objet
     * @return a Message
     */
    public Message processMessage(Message msgToProcess) {

        GenericMsg genericMsgToReturn = null;

        Set<LangTranslator> langTranslatorToUse = translatorManager.getTranslators();
        if (!langTranslatorToUse.isEmpty()){

            for (LangTranslator langTranslator : langTranslatorToUse) {
                // define lang destination from current translator, emit msg
                String targetLang = null;
                String targetContent = null;
                targetLang = langTranslator.getLang1().equals(msgToProcess.getLang()) ? langTranslator.getLang2() :
                langTranslator.getLang2().equals(msgToProcess.getLang())? langTranslator.getLang1(): null;

                if (targetLang != null) {
                    targetContent = langTranslator.getLang1Content().equals(msgToProcess.getContent()) ? langTranslator.getLang2Content() :
                            langTranslator.getLang2Content().equals(msgToProcess.getContent()) ? langTranslator.getLang1Content() : null;
                }

                if (targetContent != null) {
                    LOGGER.debug("Translator with ID {} was used", langTranslator.getTranslatorID());
                    genericMsgToReturn = new GenericMsg(targetLang, targetContent);
                }
            }
        } else{
            LOGGER.warn("ERROR");
        }
        return genericMsgToReturn;
    }
}
