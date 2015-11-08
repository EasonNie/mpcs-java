/**
 * Created by Eason on 10/5/15.
 */
public class P6_12 {

    final static int[] RESULTSET = new int[]{1, 2, 3, 4, 5, 6};
    static int c = 0;

    public static void main(String[] args) {
        int[] dies = new int[20];
        for (int i = 0; i < dies.length; i++) {
            dies[i] = RESULTSET[(int) (Math.random() * 6)];
            //System.out.println(dies[i]);
            //System.out.println(dies.length);

        }
        show(dies);

        //DistributeTester.test();
    }

    public static void show(int[] arr) {
        boolean isRun = false;
        for (int i = 0; i < arr.length; i++) {
            if (isRun) {
                if (i >= 1 && arr[i] != arr[i - 1]) {
                    System.out.print(')');
                    System.out.print(" ");
                    isRun = false;
                }
            } else {
                if (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                    System.out.print("( ");
                    isRun = true;
                }
            }
            System.out.print(arr[i] + " ");
        }
        if (isRun) {
            System.out.print(')');
        }
    }
}

class DistributeTester {    //This is a distribute tester for testing the probability of each dies.
    static int[] count = new int[7];

    public static void test() {
        int t = 0;
        while (t < 60000000) {
            int cur = P6_12.RESULTSET[(int) (Math.random() * 6)];
            count[cur]++;
            t++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(i + ":" + count[i]);
        }
    }
}   //You can run this test. It will tell you the total count of numbers that occur.
