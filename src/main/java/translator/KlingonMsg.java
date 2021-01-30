package translator;

import translator.interfaces.Message;

public class KlingonMsg implements Message {

    private String content;

    public String getContent() {
        return content;
    }

    @Override
    public String getOrigin() {
        return this.getClass().toString();
    }

    public KlingonMsg(String content) {
        this.content = content;
    }
}
