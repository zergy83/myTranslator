package translator.interfaces;

import translator.HumanMsg;
import translator.KlingonMsg;

public interface TranslatorTool {


    HumanMsg toHuman(KlingonMsg klingonMsg);

    KlingonMsg toKlingon(HumanMsg message);

}
