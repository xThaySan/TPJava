package canvas.transform;

import java.util.Arrays;

public class Matrix {
    private int height;
    private int width;
    private double[][] matrix;

    public Matrix(int height, int width) {
        this.height = height;
        this.width = width;
        this.matrix = new double[this.height][this.width];

        if (this.width == this.height) {
            for (int i = 0; i < this.height; i++) {
                this.matrix[i][i] = 1;
            }
        }
    }

    public Matrix multiply(Matrix B) {
        if(this.width != B.height) throw new ArithmeticException("Les matrices ne peuvent pas être multipliée");

        Matrix R = new Matrix(this.height, B.width);
        for (int row = 0; row < this.height; row++) {
            for (int column = 0; column < B.width; column++) {
                double result = 0;
                for (int i = 0; i < this.width; i++) {
                    result += this.matrix[row][i] * B.matrix[i][column];
                }
                R.matrix[row][column] = result;
            }
        }

        return R;
    }

    public double getValue(int row, int column) {
        if (row < 0 || row >= this.height || column < 0 || column >= this.width) throw new IndexOutOfBoundsException("Tentative d'accès à des cases en dehors de la matrice");
        return this.matrix[row][column];
    }

    public void setValue(int row, int column, double value) {
        if (row < 0 || row >= this.height || column < 0 || column >= this.width) throw new IndexOutOfBoundsException("Tentative d'accès à des cases en dehors de la matrice");
        this.matrix[row][column] = value;
    }

    @Override
    public String toString() {
        String str = "Matrix{";
        for (int row = 0; row < this.height; row++) {
            str += (row != 0 ? "       " : "") + "[ ";
            for (int column = 0; column < this.width; column++) {
                str += this.matrix[row][column] + (column != this.width-1 ? ", " : "");
            }
            str += " ]" + (row != this.height-1 ? "\n" : "");
        }
        return str + "}";
    }
}
