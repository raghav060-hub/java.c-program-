import java.util.Scanner;

class SearchElement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] a = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        System.out.print("Enter element to search: ");
        int n = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                if (a[i][j] == n) {
                    System.out.println("Element found at row = "
                            + i + " and column = " + j);
                    found = true;
                    break;
                }
            }

            if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println("Element not found");
        }

        sc.close();
    }
}
