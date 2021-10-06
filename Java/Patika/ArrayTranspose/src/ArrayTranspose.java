import java.util.Arrays;

public class ArrayTranspose {

    // https://app.patika.dev/moduller/java101/odev-array-transpose
    public static void main(String[] args) {
        int[][] myArray = {
                {2,3,4},
                {5,6,4}
        };

        int[][] transpose = new int[myArray[0].length][myArray.length];

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < transpose.length; j++) {
                transpose[j][i] = myArray[i][j];
            }
        }

        for (int i = 0; i < transpose.length; i++) {
            System.out.println(Arrays.toString(transpose[i]));
        }

    }
}
