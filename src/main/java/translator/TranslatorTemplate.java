package translator;

/**
 * Features of a Translator
 */
public class TranslatorTemplate{

    double translatorID;

    public TranslatorTemplate() {
        this.translatorID = Math.random();
    }

    public double getTranslatorID() {
        return translatorID;
    }
}
