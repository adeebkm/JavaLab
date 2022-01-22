import java.util.Scanner;

public class matrix {
    int rows;
    int columns;
    int[][] array;
    Scanner sc;

    matrix(int rows, int columns) {
        this.sc = new Scanner(System.in);
        this.rows = rows;
        this.columns = columns;
        this.array = new int[rows][columns];
    }

    public void getInput() {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                this.array[i][j] = this.sc.nextInt();
            }
        }

    }

    public int matrixMul(matrix m1, matrix m2) {
        int flag = 0;
        if (m1.columns != m2.rows) {
            int flag = -1;
            return flag;
        } else {
            for (int i = 0; i < m1.rows; ++i) {
                for (int j = 0; j < m2.columns; ++j) {
                    for (int k = 0; k < m1.columns; ++k) {
                        int[] var10000 = this.array[i];
                        var10000[j] += m1.array[i][k] * m2.array[k][j];
                    }
                }
            }

            return flag;
        }
    }

    public void printMatrix() {
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.columns; ++j) {
                System.out.print(this.array[i][j] + " ");
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter no of rows for matrix 1");
        int rows1 = sc.nextInt();
        System.out.println("enter columns");
        int columns1 = sc.nextInt();
        matrix m1 = new matrix(rows1, columns1);
        System.out.println("enter elemnts of matirx");
        m1.getInput();
        System.out.print("enter no of rows for matrix 2");
        int rows2 = sc.nextInt();
        System.out.println("enter columns");
        int columns2 = sc.nextInt();
        matrix m2 = new matrix(rows2, columns2);
        System.out.println("enter elemnts of matirx");
        m2.getInput();
        matrix m3 = new matrix(m1.rows, m2.columns);
        int flag = m3.matrixMul(m1, m2);
        System.out.println("the first matrix is");
        m1.printMatrix();
        System.out.println("the multiplication is");
        m2.printMatrix();
        if (flag == 0) {
            System.out.print("the multiplication of two matrices is");
            m3.printMatrix();
        } else {
            System.out.println("the multiplication is not possible");
        }

    }
}
