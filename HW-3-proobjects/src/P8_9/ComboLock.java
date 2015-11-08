package P8_9;

/**
 * Created by Eason on 10/15/15.
 */
public class ComboLock {

    boolean[] state;
    //This array has three boolean elements represents the current state of the lock.
    //If all the state[i] is true, the lock can be opened.

    private int secret1;
    private int secret2;
    private int secret3;
    private int curpos;     //Current position of the pointer
    private int curNumOfOperation;      //It presents the number of operation the user have been done.

    public ComboLock(int secret1, int secret2, int secret3) {
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
        this.curpos = 0;
        this.curNumOfOperation = 0;
        state = new boolean[3];
    }

    public void reset() {
        this.curpos = 0;
        this.curNumOfOperation = 0;
        for (int i = 0; i < state.length; i++) {
            state[i] = false;
        }
    }

    public void turnLeft(int ticks) {       //If the ticks <= 0, it is illegal operation.
        if (ticks <= 0) {
            System.out.println("Illegal operation");
            return;
        }
        curpos = (curpos + ticks) % 40;
        curNumOfOperation++;
        if (curNumOfOperation == 2 && curpos == secret2) {
            state[1] = true;
        }
    }

    public void turnRight(int ticks) {
        if (ticks <= 0) {
            System.out.println("Illegal operation");
            return;
        }
        curpos = (curpos + 40 - ticks) % 40;
        curNumOfOperation++;
        if (curNumOfOperation == 1 && curpos == secret1) {
            state[0] = true;
        } else if (curNumOfOperation == 3 && curpos == secret3) {
            state[2] = true;
        }
    }

    public boolean open() {
        if (curNumOfOperation != 3) {   //If the current number if operation is not three, return false;
            return false;
        }
        boolean isOpen = true;
        for (boolean b : state) {
            if (!b) {
                isOpen = false;
                break;
            }
        }
        return isOpen;
    }

}
