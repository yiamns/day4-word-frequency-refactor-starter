import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class WordFrequencyGame {

    public static final String ANY_SPACE_SEPARATOR = "\\s+";

    public String getResult(String inputStr){
        if (inputStr.split(ANY_SPACE_SEPARATOR).length==1) {
            return inputStr + " 1";
        }
        else {
            try {
                String[] words_split = inputStr.split(ANY_SPACE_SEPARATOR);

                List<Input> frequencies = countFrequencies(words_split);

                frequencies.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (Input w : frequencies) {
                    String s = w.getValue() + " " +w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {
                return "Calculate Error";
            }
        }
    }

    private List<Input> countFrequencies(String[] words) {
        Map<String, List<String>> map = groupSameWords(words);

        List<Input> frequencies = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            Input input = new Input(entry.getKey(), entry.getValue().size());
            frequencies.add(input);
        }
        return frequencies;
    }

    private static Map<String, List<String>> groupSameWords(String[] words) {
        List<String> inputList = new ArrayList<>();
        for (String s : words) {
            inputList.add(s);
        }

        Map<String, List<String>> map1 = new HashMap<>();
        for (String input1 : inputList){
            // map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map1.containsKey(input1)){
                ArrayList arr = new ArrayList<>();
                arr.add(input1);
                map1.put(input1, arr);
            }

            else {
                map1.get(input1).add(input1);
            }
        }
        Map<String, List<String>> map = map1;
        return map;
    }
}
