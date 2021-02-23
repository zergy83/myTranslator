package translator;

import translator.interfaces.Message;

/**
 * A generic Message with a String lang and a String Content attributes
 */
public class GenericMsg implements Message {

    private String lang;

    private String content;

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getLang() {
        return lang;
    }

    public GenericMsg(String lang, String content) {
        this.lang = lang;
        this.content = content;
    }
}
