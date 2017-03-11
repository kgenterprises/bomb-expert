package cs.uwf.edu.bomb.expert;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by KGraham on 2/2/17.
 */
public class VoiceRecognizer {

    private static final String ACOUSTIC_MODEL = "resource:/en-us-adapt";
    private static final String DICTIONARY_PATH = "resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict";
    private static final String LANGUAGE_MODEL_PATH = "resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin";

    // might need a grammar ?
    //private static final String GRAMMAR_PATH =
    //  "resource:/edu/cmu/sphinx/demo/dialog/";

    private static final Map<String, Integer> DIGITS = new HashMap<String, Integer>();

    static {
        DIGITS.put("oh", 0);
        DIGITS.put("zero", 0);
        DIGITS.put("one", 1);
        DIGITS.put("two", 2);
        DIGITS.put("three", 3);
        DIGITS.put("four", 4);
        DIGITS.put("five", 5);
        DIGITS.put("six", 6);
        DIGITS.put("seven", 7);
        DIGITS.put("eight", 8);
        DIGITS.put("nine", 9);
    }

    private static void recognizeDigits(LiveSpeechRecognizer recognizer) {
        System.out.println("Voice Recognition Started");
        System.out.println("--------------------------------");
        System.out.println("Say \"Stop\" to exit");
        System.out.println("--------------------------------");

        recognizer.startRecognition(true);
        while (true) {
            String utterance = recognizer.getResult().getHypothesis();
            if (utterance.equals("Stop"))
                break;
            else
                System.out.println(utterance);
        }
        recognizer.stopRecognition();
        System.out.println("Voice Recognition Stopped");
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath(ACOUSTIC_MODEL);
        configuration.setDictionaryPath(DICTIONARY_PATH);
        configuration.setLanguageModelPath(LANGUAGE_MODEL_PATH);

        // TODO might need to create a grammar dialog and include in the resources of the project
        // see example at https://github.com/cmusphinx/sphinx4/blob/master/sphinx4-samples/src/main/resources/edu/cmu/sphinx/demo/dialog/dialog.gram
        // configuration.setGrammarName("dialog");
        // configuration.setGrammarPath(GRAMMAR_PATH);
        // configuration.setUseGrammar(true);

        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);

        recognizeDigits(recognizer);

    }

}
