import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VotingService {
    private Question currentQuestion;
    private final Map<String, Set<String>> studentSubmission;

    /** Constructor for voting service object */
    public VotingService() {
        studentSubmission = new HashMap<>();
    }

    /** Sets the current question for the voting service */
    public void setQuestion(Question question) {
        this.currentQuestion = question;
        studentSubmission.clear(); // clear all previous submissions when a new question is set
    }

    /** Retrieves the current question being processed */
    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    /** Submits an answer for student */
    public void submitAnswer(String studentID, Set<Character> answerLetters) {
        if (currentQuestion == null) {
            throw new IllegalStateException("No question has been set.");
        }

        Set<String> answers = new HashSet<>();
        for (char letter : answerLetters) {
            answers.add(currentQuestion.getAnswerLetter(letter));
        }

        // Check if the question is single choice and student submitted more than one answer
        if (!currentQuestion.isMultipleChoice() && answers.size() > 1) {
            throw new IllegalArgumentException("Only one answer allowed for single choice questions.");
        }

        // store the student's answer
        studentSubmission.put(studentID, answers);
    }

    /** Displays the voting results including student answers and correctness */
    public void displayResults() {
        if (currentQuestion == null) {
            throw new IllegalStateException("No question has been set.");
        }

        Map<String, Integer> answerCounts = new HashMap<>();
        for (String answer : currentQuestion.getStudentAnswers()) {
            answerCounts.put(answer, 0);
        }

        int correctCount = 0;
        int wrongCount = 0;

        for (Set<String> answers : studentSubmission.values()) {
            if (answers.equals(currentQuestion.getCorrectAnswers())) {
                correctCount++;
            } else {
                wrongCount++;
            }
            for (String answer : answers) {
                answerCounts.put(answer, answerCounts.get(answer) + 1);
            }
        }

        // Display Results
        System.out.println("Results for: " + currentQuestion.getQuestionString());
        char letter = 'A';

        for (String answer : currentQuestion.getStudentAnswers()) {
            System.out.println(letter + ": " + answer);
            letter++;
        }

        System.out.print("The correct answer is: [");
        int correctSize = currentQuestion.getCorrectAnswers().size();
        int count = 0;
        for (String correctAnswer : currentQuestion.getCorrectAnswers()) {
            System.out.print(currentQuestion.getLetterAnswer(correctAnswer));
            if (count < correctSize - 1) {
                System.out.print(", ");
            }
            count++;
        }
        System.out.println("]");

        System.out.println("right: " + correctCount + " wrong: " + wrongCount);
    }
}
