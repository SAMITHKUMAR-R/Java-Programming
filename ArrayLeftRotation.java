import java.util.*;

public class LeftRotationExample {

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        int n = arr.size();
        d = d % n;

        List<Integer> result = new ArrayList<>();

        for (int i = d; i < n; i++) {
            result.add(arr.get(i));
        }

        for (int i = 0; i < d; i++) {
            result.add(arr.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size and rotation count
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.print("Enter number of left rotations: ");
        int d = sc.nextInt();

        // Input array elements
        List<Integer> arr = new ArrayList<>();
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // Call rotation function
        List<Integer> rotated = rotateLeft(d, arr);

        // Output result
        System.out.println("Array after left rotation:");
        for (int num : rotated) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
