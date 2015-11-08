package P12_6;

/**
 * Created by Eason on 11/7/15.
 */
public class Question {
    private int level;
    private int a;
    private int b;
    private int answer;
    private int trytime;

    public Question(int level) {
        this.level = level;
        this.trytime = 2;
        createQuestion();
    }

    public int getLevel() {
        return level;
    }

    public String getQuestion() {
        return toString();
    }

    public int getTrytime() {
        return trytime;
    }

    public boolean check(int input) {
        if (this.answer == input) {
            trytime -= 1;
            return true;
        } else {
            trytime -= 1;
            return false;
        }
    }

    private void createQuestion() {
        if (this.level == 1) {
            this.answer = RandomGenerator.getRandomInt(0, 10);
            this.a = RandomGenerator.getRandomInt(0, answer + 1);
            this.b = answer - a;
        } else if (this.level == 2) {
            this.a = RandomGenerator.getRandomInt(0, 10);
            this.b = RandomGenerator.getRandomInt(0, 10);
            this.answer = a + b;
        } else if (this.level == 3) {
            this.a = RandomGenerator.getRandomInt(0, 10);
            this.b = RandomGenerator.getRandomInt(0, a + 1);
            this.answer = a - b;
        } else {
            System.out.println("Illegal test level.");
        }
    }

    @Override
    public String toString() {
        if (this.level == 1 || this.level == 2) {
            return a + "+" + b + "=?";
        } else if (this.level == 3) {
            return a + "-" + b + "=?";
        } else {
            System.out.println("Illegal test level.");
            return null;
        }
    }
}
