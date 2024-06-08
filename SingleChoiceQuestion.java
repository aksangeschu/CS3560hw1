import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** Represents a single choice question */
public class SingleChoiceQuestion extends Question {
    
    private final List<String> answerList;

    /** Constructor for SingleChoice question */
    public SingleChoiceQuestion(String questionString, String[] studentAnswers, Set<String> correctAnswers) {
        super(questionString, studentAnswers, correctAnswers, false);
        this.answerList = new ArrayList<>(Set.of(studentAnswers));
    }

    /** Displays the single-choice question */
    @Override
    public void displayQuestion() {
        System.out.println("Single Choice Question: ");
        System.out.println(questionString);
        int index = 0;

        for (String answerChoice : answerList) {
            System.out.println((char)('A' + index++) + ", " + answerChoice);
        }
    }

    /** Retrieves the answer correponding to the given letter */
    @Override
    public String getAnswerLetter(char letter) {
        int index = letter - 'A';
        if (index >= 0 && index < answerList.size()) {
            return answerList.get(index);
        }
        throw new IllegalArgumentException("Invalid answer letter: " + letter);
    }

    /** Retrieves the letter corresponding to the given answer */
    @Override
    public char getLetterAnswer(String answer) {
        int index = answerList.indexOf(answer);
        if(index != -1) {
            return (char)('A' + index);
        }
        throw new IllegalArgumentException("Invalid answer: " + answer);
    }
}
