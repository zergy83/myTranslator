package translator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import translator.interfaces.Message;

/**
 * PSVM contraining Class for executable jar
 */
public class Launcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        //Deserialize and add generated Langtranslator to list
        Path workingDir = Paths.get(System.getProperty("user.dir"));
        Path resourceCopyPath = Paths.get(workingDir + "/target/resourcesPath");
            Path translatorFile = Paths.get(resourceCopyPath + "/translators.json");
            if(Files.exists(translatorFile)){
                LOGGER.debug("Translators jsonfile was found");
                ObjectMapper objectMapper = new ObjectMapper();
                try{
                    String out= objectMapper.writeValueAsString(new LangTranslator("test","test","test","test"));
                    System.out.println(out);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }


                try{
                    //[{ "lang1" :"klingon", "lang2" :" chom", "lang1Content" :" human", "lang2Content" :" purr"}]
                    InputStream inputStream = new FileInputStream(translatorFile.toFile());
                        LangTranslator langTranslator = objectMapper.readValue(inputStream, LangTranslator.class);
                        LOGGER.debug("Translator added: {}", langTranslator);
                        TranslatorManager.Instance.addTranslator(langTranslator);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else{
                LOGGER.debug("Translator jsonFile not found");
        }

        // data fixtures (based on String couple)
        LangTranslator langTranslator1 = new LangTranslator(Languages.KLINGONLANG, "kapla", Languages.HUMANLANG, "hello");
        TranslatorManager.Instance.addTranslator(langTranslator1);

        // instantiate translation service
        TranslatorService translatorService = new TranslatorService();

        // simulate klingon emission
        GenericMsg klingonMsg = new GenericMsg(Languages.KLINGONLANG, "kapla");

        Message receivedMessage = translatorService.processMessage(klingonMsg);
        logIt(klingonMsg, receivedMessage);

        // simulate human emission
        GenericMsg genericMsg = new GenericMsg(Languages.HUMANLANG, "hello");
        receivedMessage = translatorService.processMessage(genericMsg);
        logIt(genericMsg, receivedMessage);

    }

    private static void logIt(Message sendMessage, Message receivedMessage){
        if (receivedMessage != null){
            LOGGER.debug("SEND {}, {}", sendMessage.getLang(), sendMessage.getContent());
            LOGGER.debug("RECEIVED {},{}", receivedMessage.getLang(), receivedMessage.getContent());
            LOGGER.debug("GOOD Translator");
        }
    }

}
