import java.util.HashMap;

public class VotingService {
    private final Question submittedQuestion;
    private final HashMap<Student, String[]> studentVotes = new HashMap<>();

    public VotingService(Question submittedQuestion) {
        this.submittedQuestion = submittedQuestion;
    }
    // Method that checks if the student has already voted, then checks if answers are valid
    public void castVote(Student student, String[] answers) {
        if (studentVotes.containsKey(student)) {
            System.out.println("Student with ID: " + student.getId() + " has already voted!");
            return;
        }

        if (answers == null || answers.length == 0) {
            System.out.println("Invalid vote by student with ID: " + student.getId());
            return;
        }
        // Makes sure answers are validated and add it to the studtns vote
        String[] verifiedAnswers = submittedQuestion.validateAnswers(answers);
        studentVotes.put(student, verifiedAnswers);
    }
    
    // Method that displays the answer statistics such as how many times they were voted for
    public void displayStatistics() {

        // Counts the number of times each answer was voted for
        HashMap<String, Integer> numAnswers = new HashMap<>();

        for (String[] answers : studentVotes.values()) {
            for (String answer : answers) {
                numAnswers.put(answer, numAnswers.getOrDefault(answer, 0) +1);
            }
        }

        int totalVoters = studentVotes.size();

        System.out.println();

        //Displays a percenatge next to number of answers to see what most popular answers were
        numAnswers.forEach((answer, count) -> {
            double percentage = (double) count / totalVoters * 100;
            System.out.println(answer + ": " + count + " (" + String.format("%.2f", percentage) + "%)");
        });  
    }

}
