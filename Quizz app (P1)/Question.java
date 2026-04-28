import java.util.Arrays;

public class Question {
    private final int id;
    private final String prompt;
    private final String[] options;
    private final String answer;
    private final String difficulty;
    private final String category;

    public Question(int id, String prompt, String[] options, String answer, String difficulty, String category) {
        if (options == null || options.length != 4) {
            throw new IllegalArgumentException("Each question must have exactly 4 options.");
        }

        this.id = id;
        this.prompt = prompt;
        this.options = Arrays.copyOf(options, options.length);
        this.answer = answer.trim().toLowerCase();
        this.difficulty = difficulty;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getPrompt() {
        return prompt;
    }

    public String[] getOptions() {
        return Arrays.copyOf(options, options.length);
    }

    public String getAnswer() {
        return answer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCategory() {
        return category;
    }

    public boolean isCorrect(String userAnswer) {
        return answer.equalsIgnoreCase(userAnswer == null ? "" : userAnswer.trim());
    }
}
