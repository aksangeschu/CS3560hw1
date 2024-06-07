//import java.util.HashSet;
import java.util.Set;

public abstract class Question {
    
    protected String questionString;
    protected boolean isMultipleChoice;
    protected Set<String> studentAnswers;
    protected Set<String> correctAnswers;

    //protected int countCorrectAnswer;

    public Question(String questionString, String[] studentAnswers, Set<String> correctAnswers, boolean isMultipleChoice) {
        
        this.questionString = questionString;
        this.studentAnswers = Set.of(studentAnswers);
        this.correctAnswers = Set.copyOf(correctAnswers);
        this.isMultipleChoice = isMultipleChoice;
        
    }

    public String getQuestionString() {
        return questionString;
    }

    public Set<String> getStudentAnswers() {
        return studentAnswers;
    }

    public Set<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public boolean isMultipleChoice() {
        return isMultipleChoice;
    }

    /*public int getCountAnswerCorrect() {
        return countCorrectAnswer;
    }
    
    /** Increment the correct answer count 
    public void incrementCountAnswerCorrect() {
        countCorrectAnswer++;
    }
    */

    /** Abstract method to display the question */
    public abstract void displayQuestion();

    public abstract String getAnswerLetter(char letter);

    public abstract char getLetterAnswer(String answer);
}
