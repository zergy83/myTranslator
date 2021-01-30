package translator;

import translator.interfaces.TranslatorTool;

/**
 * human/klingon translator
 */
public class LangTranslator extends TranslatorTemplate implements TranslatorTool {

    private String klingonMsgContent;
    private String humanMsgContent;


    public LangTranslator() {
    }

    @Override
    public HumanMsg toHuman(KlingonMsg klingonMsg) {
        HumanMsg humanMsg = new HumanMsg(this.humanMsgContent);
        return humanMsg;
    }

    @Override
    public KlingonMsg toKlingon(HumanMsg message) {
        KlingonMsg klingonMsg = new KlingonMsg(this.klingonMsgContent);
        return klingonMsg;
    }

    public String getKlingonMsgContent() {
        return klingonMsgContent;
    }

    public void setKlingonMsgContent(String klingonMsgContent) {
        this.klingonMsgContent = klingonMsgContent;
    }

    public String getHumanMsgContent() {
        return humanMsgContent;
    }

    public void setHumanMsgContent(String humanMsgContent) {
        this.humanMsgContent = humanMsgContent;
    }
}
