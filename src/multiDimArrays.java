public class multiDimArrays
{

    //  {|0|1|2|} -> matrix.length
    //   |0|1|2|
    //   |0|1|2|
    //      |
    // matrix[0].length


    enum ArithmeticOperator
    {
        SUM,
        DIFFERENCE,
        PRODUCT,
    }

    public static void main(String[] args)
    {
        try
        {
            System.out.println();

            // Task 1
            int[][] matrix = createMatrix(4, 3);

            // Task 2
            // setMatrixValue(matrix, 0, 0, 99);
            // setMatrixValue(matrix, 0, 1, 99);
            // setMatrixValue(matrix, 0, 2, 99);


            // Task 3
            setRandomMatrix(matrix);


            // Task 4
//            PrintMatrix(matrix, false);


            // Task 5
//             PrintMatrix(matrix, false);
//             PrintMatrix(transposeMatrix(matrix), false);


            // Task 6 - 9
             int[][] randomMatrixB = new int[2][3];
             int[][] randomMatrixA = new int[3][2];

             setRandomMatrix(randomMatrixA);
             setRandomMatrix(randomMatrixB);

             PrintMatrix(randomMatrixA, "Matrix A:");
             PrintMatrix(randomMatrixB, "Matrix B:");
//             PrintMatrix(calculateMatrices(randomMatrixA, randomMatrixB, ArithmeticOperator.SUM), "Sum of A and B:");
//             PrintMatrix(calculateMatrices(randomMatrixA, randomMatrixB, ArithmeticOperator.DIFFERENCE), "Difference of A and B:");
             PrintMatrix(calculateMatrices(randomMatrixA, randomMatrixB, ArithmeticOperator.PRODUCT), "Product of A and B:");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }


    /* 1. Es soll ein Java Programm geschrieben werden, welches eine Matrix anlegt.
     *    Hierfür wird eine Methode angelegt, welche als Eingabeparameter die Anzahl an Zeilen und Spalten erhält.  */
    public static int[][] createMatrix(int rows, int columns) throws Exception
    {
        if (rows < 0 || columns < 0)
            throw new Exception("Invalid Parameters: Rows: " + rows + "\tColumns: " + columns);

        return new int[rows][columns];
    }



    /* 2. Es soll eine Methode erstellt werden, welche die zuvor angelegte Matrix anhand der jeweiligen Koordinaten
     *    als Eingabeparameter mit Werten befüllt. */
    public static void setMatrixValue(int[][] matrix, int row, int column) throws Exception
    {
        setMatrixValue(matrix, row, column, (int) (Math.random() * 100));
    }

    public static void setMatrixValue(int[][] matrix, int row, int column, int value) throws Exception
    {
        if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[0].length)
            throw new Exception("Invalid Parameters: Row: " + row + "\tColumn: " + column);

        matrix[row][column] = value;
    }



    /* 3. Die zuvor angelegten Methoden sollen genutzt werden um so eine Matrix mit
     *    beliebigen (Zahlen-) Werten zu füllen. */
    public static void setRandomMatrix(int[][] matrix) throws Exception
    {
        for (int r = 0; r < matrix.length; r++)
        {
            for (int c = 0; c < matrix[r].length; c++)
            {
                setMatrixValue(matrix, r, c);
            }
        }
    }



    /* 4. Es soll eine Methode geschrieben werden, welche eine vorhandene Matrix transponiert. */
    private static int[][] transposeMatrix(int[][] matrix)
    {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
        {
            for (int k = 0; k < matrix[0].length; k++)
            {
                transposedMatrix[k][i] = matrix[i][k];
            }
        }
        return transposedMatrix;
    }



    /* 6. Es soll eine Methode geschrieben werden, welche zwei Matrizen miteinander summiert.
     *    Als Eingabewert werden Matrix A und B verlangt.
     *    Es soll geprüft werden, ob eine Summierung der Matrizen überhaupt möglich ist.
     * 8. Es soll eine Methode für die Subtraktion geschrieben werden (analog zur Summe).
     *    Auch hier soll eine Ausgabe alle Matrizen erfolgen
     * 9. Es soll eine Methode geschrieben werden, welche zwei Matrizen miteinander multipliziert (Matrixprodukt).
     *    Die Ausgabe soll analog zu den Aufgaben zuvor erfolgen.
     *    Es soll geprüft werden, ob eine Multiplikation der beiden Matrizen überhaupt möglich ist.*/
    private static int[][] calculateMatrices(int[][] matrixA, int[][] matrixB, ArithmeticOperator operator) throws Exception
    {
        if (operator == ArithmeticOperator.PRODUCT)
            return multiplyMatrices(matrixA, matrixB);

        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length)
            throw new Exception("Invalid Matrix, unable to calculate sum, amount of columns and rows have to be equal.");

        int[][] matrixSum = new int[matrixA.length][matrixA[0].length];

        for (int r = 0; r < matrixA.length; r++)
        {
            for (int c = 0; c < matrixA[0].length; c++)
            {
                if (operator == ArithmeticOperator.SUM)
                    matrixSum[r][c] = matrixA[r][c] + matrixB[r][c];
                else if (operator == ArithmeticOperator.DIFFERENCE)
                    matrixSum[r][c] = matrixA[r][c] - matrixB[r][c];
            }
        }
        return matrixSum;
    }


    /* 9. Es soll eine Methode geschrieben werden, welche zwei Matrizen miteinander multipliziert (Matrixprodukt).
     *    Die Ausgabe soll analog zu den Aufgaben zuvor erfolgen.
     *    Es soll geprüft werden, ob eine Multiplikation der beiden Matrizen überhaupt möglich ist.*/
    private static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) throws Exception
    {
        if (matrixA[0].length != matrixB.length)
            throw new Exception("Invalid Matrix, can't operate Multiplication.");

        int rowsOfA = matrixA.length;
        int columnsOfB = matrixB[0].length;
        int columnsOfA = matrixA[0].length;

        int[][] matrixC = new int[rowsOfA][columnsOfB];

        for (int i = 0; i < rowsOfA; i++)
        {
            for (int k = 0; k < columnsOfB; k++)
            {
                matrixC[i][k] = 0;
                for (int m = 0; m < columnsOfA; m++)
                {
                    matrixC[i][k] += matrixA[i][m] * matrixB[m][k];
                }
            }
        }
        return matrixC;
    }




    /* Helper functions */
    private static void PrintMatrix(int[][] matrix)
    {
        PrintMatrix(matrix, false);
    }

    private static void PrintMatrix(int[][] matrix, String title)
    {
        System.out.println("\t"+title);
        PrintMatrix(matrix, false);
    }

    private static void PrintMatrix(int[][] matrix, boolean ANotation)
    {
        boolean printWithPipe = true;

        System.out.println();
        for (int r = 0; r < matrix.length; r++)
        {
            System.out.print(printWithPipe ? "\t| " : "\t ");
            for (int c = 0; c < matrix[r].length; c++)
            {
                if (ANotation)
                    System.out.printf(c + 1 == matrix[r].length ? "a%d%d" : "a%d%4d", r + 1, c + 1);
                else
                    System.out.printf("%2d ", matrix[r][c]);
            }
            System.out.print(printWithPipe ? "|\n" : "\n");
        }
        System.out.println("\n\n");
    }
}
