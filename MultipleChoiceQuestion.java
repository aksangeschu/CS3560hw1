import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultipleChoiceQuestion extends Question {

    private final List<String> answerList;

    public MultipleChoiceQuestion(String questionString, String[] studentAnswers, Set<String> correctAnswers) {
        super(questionString, studentAnswers, correctAnswers, true);
        this.answerList = new ArrayList<>(Set.of(studentAnswers));
    }

    @Override
    public void displayQuestion() {
        System.out.println("Multiple Choice Question: ");
        System.out.println(questionString);
        int index = 0;
        for(String answerChoice : answerList){
            System.out.println((char)('A' + index++) + ". " + answerChoice);
        }
    }

    @Override
    public String getAnswerLetter(char letter) {
        int index = letter - 'A';
        if (index >= 0 && index < answerList.size()) {
            return answerList.get(index);

        }
        throw new IllegalArgumentException("Invalid answer letter: " + letter);
    }

    @Override
    public char getLetterAnswer(String answer) {
        int index = answerList.indexOf(answer);
        if(index != -1) {
            return (char)('A' + index);
        }
        throw new IllegalArgumentException("Invalid answer: " + answer);
    }
}
