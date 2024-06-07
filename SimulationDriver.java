import java.util.Set;

public class SimulationDriver {
    public static void main(String[] args) {
        VotingService votingService = new VotingService();

        String questionString = "What are the 3 primary colors?";
        String[] studentAnswers = {"Red", "Orange", "Yellow", "Green", "Blue", "Purple"};
        Set<String> correctAnswers = Set.of("Red", "Yellow", "Blue");
        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(questionString, studentAnswers, correctAnswers);

        votingService.setQuestion(mcq);

        // Simulate student submissions using letters
        Set<Character> answers1 = Set.of('A', 'C', 'E'); // Red, Yellow, Blue
        Set<Character> answers2 = Set.of('B', 'D', 'F'); // Orange, Green, Purple
        Set<Character> answers3 = Set.of('A', 'D', 'E'); // Red, Green, Blue

        votingService.submitAnswer("student1", answers1);
        votingService.submitAnswer("student2", answers2);
        votingService.submitAnswer("student3", answers3);

        // Display results
        votingService.displayResults();
    }
}
