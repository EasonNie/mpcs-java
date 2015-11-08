package pig;

/**
 * Created by Eason on 10/31/15.
 */
public class Player {
    private String Name;
    private int curPoints;

    public Player(String name) {
        Name = name;
        curPoints = 0;
    }

    public Player(String name, int curPoints) {
        Name = name;
        this.curPoints = curPoints;
    }

    public String getName() {
        return Name;
    }

    public int getCurPoints() {
        return curPoints;
    }

    public void setCurPoints(int curPoints) {
        this.curPoints = curPoints;
    }
}
