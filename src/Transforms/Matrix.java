package Transforms;

public class Matrix {
    private int rows;
    private int columns;
    private double[][] matrix;

    public Matrix(int rows, int columns) throws IllegalArgumentException {
        if (rows < 1 || columns < 1) throw new IllegalArgumentException("Une matrice ne peut pas avoir une taille négative ou nulle");

        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[this.columns][this.rows];
        for(int r = 0; r < this.rows; r++) {
            for(int c = 0; c < this.columns; c++) {
                this.matrix[c][r] = (c == r ? 1 : 0);
            }
        }
    }

    public Matrix(Matrix m) {
        this.rows = m.rows;
        this.columns = m.columns;
        this.matrix = new double[this.columns][this.rows];
        for(int r = 0; r < this.rows; r++) {
            for(int c = 0; c < this.columns; c++) {
                this.matrix[c][r] = m.matrix[c][r];
            }
        }
    }

    public void Multiply(Matrix B) throws ArithmeticException {
        if (this.columns != B.rows) throw new ArithmeticException("Le produit des matrices n'est pas défini");

        Matrix C = new Matrix(this.rows, B.columns);

        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < B.columns; c++) {
                double result = 0;
                for (int i = 0; i < this.columns; i++) {
                    result += this.matrix[i][r] * B.matrix[c][i];
                }
                C.matrix[c][r] = result;
            }
        }

        this.rows = C.rows;
        this.columns = C.columns;
        this.matrix = C.matrix;
    }

    public void set(int row, int column, double value) throws ArrayIndexOutOfBoundsException {
        if (row >= this.rows) throw new ArrayIndexOutOfBoundsException("Ligne en dehors de la matrice");
        if (column >= this.columns) throw new ArrayIndexOutOfBoundsException("Colonne en dehors de la matrice");

        this.matrix[column][row] = value;
    }

    @Override
    public String toString() {
        String str = "[";
        for(int r = 0; r < this.rows; r++) {
            str += "[";
            for(int c = 0; c < this.columns; c++) {
                str += this.matrix[c][r] + (c < this.columns-1 ? "; " : "");
            }
            str += "]";
        }
        return str + "]";
    }
}
