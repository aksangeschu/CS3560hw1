import java.util.Set;

/** Represents a generic question. */
public abstract class Question {
    
    protected String questionString;
    protected boolean isMultipleChoice;
    protected Set<String> studentAnswers;
    protected Set<String> correctAnswers;

    /** Constructor for question with the given parameters */
    public Question(String questionString, String[] studentAnswers, Set<String> correctAnswers, boolean isMultipleChoice) {
        
        this.questionString = questionString;
        this.studentAnswers = Set.of(studentAnswers);
        this.correctAnswers = Set.copyOf(correctAnswers);
        this.isMultipleChoice = isMultipleChoice;
        
    }

    /** Gets the text of the question */
    public String getQuestionString() {
        return questionString;
    }

    /** Gets the set of student answers */
    public Set<String> getStudentAnswers() {
        return studentAnswers;
    }

    /** Gets the set of correct answers */
    public Set<String> getCorrectAnswers() {
        return correctAnswers;
    }

    /** Check if the question is multiple choice */
    public boolean isMultipleChoice() {
        return isMultipleChoice;
    }

    /** Abstract method to display the question */
    public abstract void displayQuestion();

    /** Abstrect method to get the answer corresponding to the given letter */
    public abstract String getAnswerLetter(char letter);

    /** Abstract method to get the letter corresponding to the given answer */
    public abstract char getLetterAnswer(String answer);
}
