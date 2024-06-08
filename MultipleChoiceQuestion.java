import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** Represents multiple choice questions */
public class MultipleChoiceQuestion extends Question {
    
    // List used to store answer choices
    private final List<String> answerList;

    /** Constructor for multiple choice question with given parameters */
    public MultipleChoiceQuestion(String questionString, String[] studentAnswers, Set<String> correctAnswers) {
        super(questionString, studentAnswers, correctAnswers, true);
        this.answerList = new ArrayList<>(Set.of(studentAnswers));
    }

    /** Displays the multiple choice question with answer choices */
    @Override
    public void displayQuestion() {
        System.out.println("Multiple Choice Question: ");
        System.out.println(questionString);
        int index = 0;
        for(String answerChoice : answerList){
            System.out.println((char)('A' + index++) + ". " + answerChoice);
        }
    }

    /** Gets answer corresponding to the given letter */
    @Override
    public String getAnswerLetter(char letter) {
        int index = letter - 'A';
        if (index >= 0 && index < answerList.size()) {
            return answerList.get(index);

        }
        throw new IllegalArgumentException("Invalid answer letter: " + letter);
    }

    /** Gets the letter corresponding to the given answer */
    @Override
    public char getLetterAnswer(String answer) {
        int index = answerList.indexOf(answer);
        if(index != -1) {
            return (char)('A' + index);
        }
        throw new IllegalArgumentException("Invalid answer: " + answer);
    }
}
