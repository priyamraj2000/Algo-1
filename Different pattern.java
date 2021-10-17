public class Pattern1 {
    public static void main(String[] args) {
        pattern1(4);
        pattern2(4);
        pattern3(4);
        pattern4(5);
    }

    static void pattern1(int n) {
        //run a for loop for printings of row
        for (int row = 1; row <= n; row++) {
            //now,for every row, we have to print column
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            //after every row is printed we have to add a new line
            System.out.println();
        }
    }


    static void pattern2 (int n) {
        //run a for loop for printings of row
        for (int row = 1; row <= n; row++) {
            //now,for every row, we have to print column
            for (int col = n; col >= row ; col--) {
                System.out.print("*");
            }
            //after every row is printed we have to add a new line
            System.out.println();
        }
    }

    static void pattern3(int n) {
        //run a for loop for printings of row
        for (int row = 1; row <= n; row++) {
            //now,for every row, we have to print column
            for (int col = 1; col <= row ; col++) {
                System.out.print(col + " ");
            }
            //after every row is printed we have to add a new line
            System.out.println(" ");
        }
    }

    static void pattern4(int n) {
        //run a for loop for printings of row
        for (int row = 1; row <= 2 * n - 1; row++) {
              int totalColsInRow = row > n ? 2 * n - row : row;
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
