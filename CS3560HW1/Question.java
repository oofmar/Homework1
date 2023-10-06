import java.util.Arrays;

public class Question {
    private final String question;
    private final String[] candidateAnswers;
    private final boolean isSingleChoice;
    
    // Constructor for question taking in 3 parameters
    Question(String question, String[] candidateAnswers, boolean isSingleChoice) {
        this.question = question;
        this.candidateAnswers = candidateAnswers;
        this.isSingleChoice = isSingleChoice;
    }

    // Returns the question
    public String getQuestion() {
        return question;
    }

    // Returns the array containing student answers for question
    public String[] getCandidateAnswers() {
        return candidateAnswers;
    }
    
    // If single choice, only last answer valid, if multiple choice, filter invalid answers
    public String[] validateAnswers(String[] selectedAnswers) {
        if (isSingleChoice) {
            return new String[]{selectedAnswers[selectedAnswers.length - 1]};
        } else {
            return Arrays.stream(selectedAnswers)
                .filter(answer -> Arrays.asList(candidateAnswers).contains(answer))
                .toArray(String[]::new);
        }
    }
}
