/**
 * Represents an answer option for questions
 */

public class Answer {

    private String answerText;
    private boolean isCorrect;

    /** Constructs an Answer object with text and correctness */
    public Answer(String answerText, boolean isCorrect) {
        this.answerText = answerText;
        this.isCorrect = isCorrect;

    }

    /** Gets text of the answer */
    public String getAnswerText() {
        return answerText;
    }

    /** Sets text of the answer */
    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    /** Checks if the answer is correct */
    public boolean isCorrect() {
        return isCorrect;
    }
    
    /** Sets whether the answer is correct or not*/
    public void setCorrect(boolean correct){
        isCorrect = correct;
    }

    /** Returns String representation of answers */
    @Override
    public String toString() {
        return "Answer: " + answerText + ", Correct?" + isCorrect;
    }

}
