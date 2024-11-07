import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class WordFrequencyGameTest {

    @Test
    public void should_get_the_1_when_input_the() {
        //Given
        String inputStr = "the";
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.getResult(inputStr);
        //Then
        assertThat(result).isEqualTo("the 1");
    }

    @Test
    public void should_process_two_words() {
        //Given
        String inputStr = "the is";
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.getResult(inputStr);
        //Then
        assertThat(result).isEqualTo("the 1\nis 1");
    }

    @Test
    public void should_process_two_words_with_special_spaces() {
        //Given
        String inputStr = "the      is";
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.getResult(inputStr);
        //Then
        assertThat(result).isEqualTo("the 1\nis 1");
    }

    @Test
    public void should_process_two_words_with_special_enter() {
        //Given
        String inputStr = "the   \n   is";
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.getResult(inputStr);
        //Then
        assertThat(result).isEqualTo("the 1\nis 1");
    }

    @Test
    public void should_process_two_same_words_with_sorted() {
        //Given
        String inputStr = "the the is";
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.getResult(inputStr);
        //Then
        assertThat(result).isEqualTo("the 2\nis 1");
    }

    @Test
    public void should_process_sorted_with_count_descending() {
        //Given
        String inputStr = "the is is";
        WordFrequencyGame game = new WordFrequencyGame();
        //When
        String result = game.getResult(inputStr);
        //Then
        assertThat(result).isEqualTo("is 2\nthe 1");
    }
}
