package P12_6;

import java.util.Scanner;

/**
 * Created by Eason on 11/7/15.
 */
public class Test {
    private int score;
    private int currentLevel;
    private Question curQuestion;
    private boolean finished;

    public Test() {
        this.score = 0;
        this.currentLevel = 1;
        this.curQuestion = new Question(currentLevel);
        this.finished = false;
    }

    public void check(int input) {
        if (curQuestion.check(input)) {
            score++;
            if (score == 5) {
                score = 0;
                currentLevel++;
            }
            if (currentLevel > 3) {
                finished = true;
                return;
            } else {
                curQuestion = new Question(currentLevel);
            }
        } else {
            if (curQuestion.getTrytime() == 0) {
                curQuestion = new Question(currentLevel);
            }
        }
    }

    public Question getQuestion() {
        return curQuestion;
    }

    public void start() {
        Scanner s = new Scanner(System.in);
        while (!finished) {
            System.out.println("Current level: " + currentLevel);
            System.out.println("Current Score: " + score);
            System.out.println("Question: " + curQuestion.getQuestion());
            System.out.println("Remaining Try time: " + curQuestion.getTrytime());
            System.out.print("Enter your anwser: ");
            try {
                int input = Integer.parseInt(s.nextLine().trim());
                check(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        }
        System.out.println("Congratulations. You have finished the test.");
    }
}
