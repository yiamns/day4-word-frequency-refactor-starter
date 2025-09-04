import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {

    public static final String ANY_SPACE_SEPARATOR = "\\s+";

    public String getResult(String inputStr){
        String[] words_split = inputStr.split(ANY_SPACE_SEPARATOR);
        if (words_split.length==1) {
            return inputStr + " 1";
        }
        else {
            try {
                List<Input> frequencies = countFrequencies(words_split);

                frequencies.sort((w1, w2) -> w2.count() - w1.count());

                return composeOutput(frequencies);
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private static String composeOutput(List<Input> frequencies) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Input w : frequencies) {
            String s = w.value() + " " +w.count();
            joiner.add(s);
        }
        return joiner.toString();
    }

    private List<Input> countFrequencies(String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        List<Input> frequencies = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            frequencies.add(new Input(entry.getKey(), entry.getValue()));
        }
        return frequencies;
    }
}
