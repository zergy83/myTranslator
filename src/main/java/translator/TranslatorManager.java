package translator;

import java.util.HashSet;
import java.util.Set;

/**
 * Singleton Manager
 */
public enum TranslatorManager {

    Instance;

    /** Set of Translators */
    private Set<LangTranslator> translators = new HashSet<>();

    public Set<LangTranslator> getTranslators() {
        return translators;
    }

    /**
     * aggregates LangTranslator
     * @param langTranslator object to aggregate into Set
     */
    public void addTranslator(LangTranslator langTranslator){
        translators.add(langTranslator);
    }
}
