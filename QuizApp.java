import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer; 

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    void displayQuestion() {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    boolean isCorrect(int userAnswer) {
        return userAnswer - 1 == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create quiz questions
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question("What is the capital of India?",
                new String[]{"Mumbai", "Delhi", "Chennai", "Kolkata"}, 1));
        quiz.add(new Question("Which language is used for Android development?",
                new String[]{"Swift", "Kotlin", "Python", "Ruby"}, 1));
        quiz.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Mars", "Venus", "Jupiter"}, 1));
        quiz.add(new Question("Who is the founder of Microsoft?",
                new String[]{"Bill Gates", "Elon Musk", "Steve Jobs", "Mark Zuckerberg"}, 0));
        quiz.add(new Question("What is 5 + 3 * 2?",
                new String[]{"16", "11", "13", "10"}, 1));

        int score = 0;

        System.out.println("Welcome to the Online Quiz App!");
        System.out.println("--------------------------------");

        // Run quiz
        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            q.displayQuestion();
            System.out.print("Your answer (1-4): ");
            int userAns;
            try {
                userAns = Integer.parseInt(sc.nextLine());
                if (userAns < 1 || userAns > 4) throw new Exception();
            } catch (Exception e) {
                System.out.println("Invalid input. Skipping question.");
                continue;
            }

            if (q.isCorrect(userAns)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer is: " + (q.correctAnswer + 1));
            }
        }

        // Final score
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + " out of " + quiz.size());

        sc.close();
    }
}
