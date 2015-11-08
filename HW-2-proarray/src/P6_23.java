/**
 * Created by Eason on 10/5/15.
 */


public class P6_23 {

    final static int MAXIMUM = 40;

    public static void main(String[] args) {
        String[] captions = new String[]{"Egypt", "France", "Japan", "Uruguay", "Switzerland"};
        int[] values = new int[]{5, 9, 7, 6, 3};
        printBarChart(captions, values);
    }

    public static void printBarChart(String[] captions, int[] values) {
        int max = 0;
        int maxLen = 0;     //the longest length of the captions
        String[] captionsStr = new String[captions.length];

        for (int i = 0; i < values.length; i++) {
            max = Math.max(max, values[i]);
            maxLen = Math.max(maxLen, captions[i].length());
        }

        for (int i = 0; i < values.length; i++) {

            System.out.print(buildCaption(captions[i], maxLen) + " ");  //Print Caption

            int k = (int) ((values[i] * 1.0 / max) * MAXIMUM);
            while (k > 0) {
                System.out.print("*");
                k--;
            }
            System.out.println();
        }

    }

    public static String buildCaption(String caption, int length) {     //Given the maxLen, build the caption with some indent
        if (caption.length() == length) {
            return caption;
        }

        StringBuilder result = new StringBuilder(caption);
        for (int i = 0; i < length - caption.length(); i++) {
            result.insert(0, ' ');      //Insert some ' ' at the beginning in order to align.
        }

        return result.toString();
    }
    //Actually, this operation can be done by the printf method.
    //But, I think it will be more flexible when deal with more complicate format.
    //Since you don't know the longest caption before print the chart, you need to set a variable to receive such value.
}
