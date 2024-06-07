import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Student {
    private final UUID studentID;
    private final Set<Answer> answerSelections;

    public Student() {
        this.studentID = UUID.randomUUID();
        this.answerSelections = new HashSet<>();
    }

    public UUID getStudentID() {
        return studentID;
    }

    public Set<Answer> getAnswerSelections() {
        return answerSelections;
    }

    public void addAnswer(Answer answer) {
        answerSelections.add(answer);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID.toString();
    }
}
