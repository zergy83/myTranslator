package translator;

import translator.interfaces.Message;

public class HumanMsg implements Message {

    private String content;

    @Override
    public String getOrigin() {
        return this.getClass().toString();
    }

    @Override
    public String getContent() {
        return content;
    }

    public HumanMsg(String content) {
        this.content = content;
    }
}
