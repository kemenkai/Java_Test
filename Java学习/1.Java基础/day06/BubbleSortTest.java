/**
 * @author ke
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = {43, 45, 432, 656, 3, 2, 6, 64};
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}