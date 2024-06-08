import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SimulationDriver {
    public static void main(String[] args) {
        // Create the VotingService instance
        VotingService votingService = new VotingService();

        // Create multiple questions with their respective answer choices and correct answers
        Question q1 = new MultipleChoiceQuestion("Which states are located on the West Coast of the contiguous United States?",
                new String[]{"California", "Oregon", "Texas", "Washington", "Arizona", "Ohio"},
                Set.of("California", "Oregon", "Washington"));
        
        Question q2 = new SingleChoiceQuestion("What is the name of the poisonous berries that Katniss and Peeta threaten to eat in the 74th Hunger Games?",
                new String[]{"Tracker Jacker", "Mockingjay Berries", "Everdeen Berries", "Nightlock"},
                Set.of("Nightlock"));
        
        Question q3 = new MultipleChoiceQuestion("What are the names of the two moons of Mars",
                new String[]{"Titan", "Phobos", "Ganymede", "Deimos", "Europa"},
                Set.of("Phobos", "Deimos"));

        // Create an array of questions
        Question[] questions = {q1, q2, q3};

        // Generate a random number of students between 15 and 30
        Random rand = new Random();
        int numStudents = rand.nextInt(16) + 15; // 16 to get a number in the range 0-15, then add 15 to get 15-30
        Student[] students = generateStudents(numStudents);

        // Loop through each question and simulate the voting process
        for (Question question : questions) {
            // Set the current question in the VotingService
            votingService.setQuestion(question);
            question.displayQuestion();

            // Generate and submit answers for each student
            for (Student student : students) {
                Set<Character> answers = generateRandomAnswers(rand, question.getStudentAnswers().size(), question.isMultipleChoice());
                votingService.submitAnswer(student.getStudentID().toString(), answers);
            }

            // Display the results
            votingService.displayResults();
            System.out.println();
        }
    }

    /** Private helper method to generate a number of students */
    private static Student[] generateStudents(int numStudents) {
        Student[] students = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            students[i] = new Student();
        }
        return students;
    }

    /** Private helper method to generate a random set of answers for a question */
    private static Set<Character> generateRandomAnswers(Random rand, int numChoices, boolean isMultipleChoice) {
        Set<Character> answers = new HashSet<>();
        int numAnswers = isMultipleChoice ? rand.nextInt(numChoices) + 1 : 1;
        while (answers.size() < numAnswers) {
            char answer = (char) ('A' + rand.nextInt(numChoices));
            answers.add(answer);
        }
        return answers;
    }
}
