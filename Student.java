import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/** Represents a student participating in the voting process */
public class Student {
    private final UUID studentID;
    private final Set<Answer> answerSelections;

    /** Constructor for Student class */
    public Student() {
        this.studentID = UUID.randomUUID();
        this.answerSelections = new HashSet<>();
    }

    /** Retrieves the ID of the student */
    public UUID getStudentID() {
        return studentID;
    }
    /** Retrieves the set of answer selections made by the student */
    public Set<Answer> getAnswerSelections() {
        return answerSelections;
    }

    /** Adds an answer selection made by the student */
    public void addAnswer(Answer answer) {
        answerSelections.add(answer);
    }

    /** Returns a string representation of the student, including their ID */
    @Override
    public String toString() {
        return "Student ID: " + studentID.toString();
    }
}
