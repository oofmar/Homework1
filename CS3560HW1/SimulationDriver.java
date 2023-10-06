import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class SimulationDriver {
    private static final Random random = new Random();

    // Randomize the number of students between 20-100
    public static int numStudents = random.nextInt(81)+20;

    public static void main(String[] args){

        System.out.println();

        // Displays single choice results for randomly generated number of students
        System.out.println("Single choice results for " + numStudents + " Students: ");
        System.out.println();
        Question singleQuestion = new SingleChoice(null, 
        new String[]{"A", "B", "C", "D"});

        trialQuestion(singleQuestion);

        System.out.println();

        System.out.println("All invalid votes were removed.");
    
        System.out.println();

        //Displays multiple choice results for randomly generated number of students
        System.out.println("Multiple choice results for " + numStudents + " Students: ");
        
        System.out.println();

        Question multipleChoice = new MultipleChoice(null,
        new String[]{"A", "B", "C", "D"});

        trialQuestion(multipleChoice);

        System.out.println();

        System.out.println("All invalid votes were removed.");

        System.out.println();

    }
    
    private static void trialQuestion(Question question) {

    // Initialize the voting service
    VotingService votingService = new VotingService(question);

    String[] candidateAnswers = question.getCandidateAnswers();

    // Create a list of students to vote and have each student vote
    List<Student> students = createStudents();
    for (Student student: students) {
        String[] answers = createRandomAnswers(candidateAnswers);
        votingService.castVote(student, answers);
    }

    // Display the voting statistics
    votingService.displayStatistics();

    }

    // Creates list of students with a unique ID and returns them
    private static List<Student> createStudents(){
    List<Student> students = new ArrayList<>();
    for (int i=0; i<numStudents;i++){
        students.add(new Student(String.valueOf(i)));
    }
    return students;
    }
    
    // Randomly generates student answers and returns an array of their answers
    private static String[] createRandomAnswers(String[] candidateAnswers){
    int answerCount = random.nextInt(candidateAnswers.length);
    String[] answers = new String[answerCount];
    for (int i=0; i< answerCount; i++){
        answers[i] = candidateAnswers[random.nextInt(candidateAnswers.length)];


    }
        return answers;
    }
}