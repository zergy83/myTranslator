package translator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A two languages generic translator with associated content
 */
public class LangTranslator extends TranslatorTemplate {

    // Lang Duo User defined
    private String lang1;
    private String lang2;

    private String lang1Content;
    private String lang2Content;

    @JsonCreator
    public LangTranslator(
            @JsonProperty("lang1") String lang1,
            @JsonProperty("lang2") String lang1Content,
            @JsonProperty("lang1Content") String lang2,
            @JsonProperty("lang2Content") String lang2Content) {
        this.lang1 = lang1;
        this.lang1Content = lang1Content;
        this.lang2 = lang2;
        this.lang2Content = lang2Content;
    }

    public String getLang1() {
        return lang1;
    }

    public String getLang2() {
        return lang2;
    }

    public String getLang1Content() {
        return lang1Content;
    }

    public String getLang2Content() {
        return lang2Content;
    }
}
