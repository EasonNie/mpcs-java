import java.util.ArrayList;

/**
 * Created by Eason on 10/8/15.
 */
public class P6_28 {

    public static void main(String[] args) {
        ArrayList<Integer> test2 = new ArrayList<>();
        ArrayList<Integer> test1 = new ArrayList<>();
        test1.add(1);
        test1.add(4);
        test1.add(9);
        test1.add(16);
        test2.add(1);
        test2.add(4);
        test2.add(7);
        test2.add(9);
        test2.add(9);
        test2.add(11);
        ArrayList<Integer> tR = mergeSorted(test1, test2);
        for (int i : tR) {
            System.out.print(i + ", ");
        }

    }

    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<>();
        a.add(Integer.MAX_VALUE);   //Add Integer.MAX_VALUE as a sentinel. It can prevent pointer from moving.
        b.add(Integer.MAX_VALUE);
        int a_index = 0;
        int b_index = 0;
        while (result.size() < a.size() + b.size() - 2) {
            if (a.get(a_index) < b.get(b_index)) {  //If element in a < element in a, copy element from a to result,
                result.add(a.get(a_index));         //Else copy element from b to result.
                a_index++;
            } else {
                result.add(b.get(b_index));
                b_index++;
            }
        }
        return result;
    }
}
