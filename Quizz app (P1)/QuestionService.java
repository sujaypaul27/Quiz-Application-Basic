import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuestionService {
    private static final int MARKS_PER_QUESTION = 10;

    private final List<Question> questionBank = new ArrayList<>();
    private final List<String> userAnswers = new ArrayList<>();
    private int score = 0;

    public QuestionService() {
        questionBank.add(new Question(
                1,
                "Which keyword is used to inherit a class in Java?",
                new String[] { "a) implements", "b) extends", "c) inherits", "d) instanceOf" },
                "b",
                "Easy",
                "OOP"));

        questionBank.add(new Question(
                2,
                "What is the default value of an int field in Java?",
                new String[] { "a) null", "b) 1", "c) 0", "d) undefined" },
                "c",
                "Easy",
                "Core Java"));

        questionBank.add(new Question(
                3,
                "Which collection does NOT allow duplicate elements?",
                new String[] { "a) List", "b) Set", "c) Queue", "d) ArrayList" },
                "b",
                "Medium",
                "Collections"));

        questionBank.add(new Question(
                4,
                "Which exception is unchecked?",
                new String[] { "a) IOException", "b) SQLException", "c) ClassNotFoundException", "d) NullPointerException" },
                "d",
                "Medium",
                "Exceptions"));

        questionBank.add(new Question(
                5,
                "What does JVM stand for?",
                new String[] { "a) Java Variable Machine", "b) Java Virtual Machine", "c) Joint Virtual Module", "d) Java Verified Machine" },
                "b",
                "Easy",
                "Runtime"));

        questionBank.add(new Question(
                6,
                "Which stream class is typically used for reading binary data?",
                new String[] { "a) BufferedReader", "b) FileReader", "c) FileInputStream", "d) Scanner" },
                "c",
                "Hard",
                "I/O"));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Advanced Java Quiz ===");
        System.out.println("Rules: Enter only a, b, c, or d.\n");

        Collections.shuffle(questionBank);

        int questionNumber = 1;
        for (Question question : questionBank) {
            System.out.println("Q" + questionNumber + " [" + question.getCategory() + " | " + question.getDifficulty() + "]");
            System.out.println(question.getPrompt());

            for (String option : question.getOptions()) {
                System.out.println("  " + option);
            }

            String answer = readValidOption(scanner);
            userAnswers.add(answer);
            System.out.println();
            questionNumber++;
        }

        calculateScore();
        printAnswerConfirmation();
    }

    private String readValidOption(Scanner scanner) {
        while (true) {
            System.out.print("Your answer: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.matches("[abcd]")) {
                return input;
            }

            System.out.println("Invalid input. Please enter only a, b, c, or d.");
        }
    }

    private void calculateScore() {
        score = 0;
        for (int i = 0; i < questionBank.size(); i++) {
            if (questionBank.get(i).isCorrect(userAnswers.get(i))) {
                score += MARKS_PER_QUESTION;
            }
        }
    }

    private void printAnswerConfirmation() {
        System.out.println("Your submitted answers:");
        for (int i = 0; i < userAnswers.size(); i++) {
            System.out.println((i + 1) + ") " + userAnswers.get(i));
        }
        System.out.println();
    }

    public void displayResult() {
        int totalQuestions = questionBank.size();
        int maxScore = totalQuestions * MARKS_PER_QUESTION;
        double percentage = (score * 100.0) / maxScore;

        System.out.println("=== Result Summary ===");
        System.out.println("Score: " + score + " / " + maxScore);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Status: " + (percentage >= 60 ? "PASS" : "NEEDS IMPROVEMENT"));
        System.out.println();

        System.out.println("Detailed Review:");
        for (int i = 0; i < questionBank.size(); i++) {
            Question question = questionBank.get(i);
            String userAnswer = userAnswers.get(i);
            boolean correct = question.isCorrect(userAnswer);

            System.out.println("Q" + (i + 1) + ": " + question.getPrompt());
            System.out.println("  Your answer: " + userAnswer);
            System.out.println("  Correct answer: " + question.getAnswer());
            System.out.println("  Result: " + (correct ? "Correct" : "Wrong"));
            System.out.println();
        }
    }
}
