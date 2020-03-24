package deg1;

import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;
import org.ujmp.core.SparseMatrix;

public class GaussSeidel {

    SparseMatrix A;
    Matrix b;

    public GaussSeidel(SparseMatrix A, Matrix b) {
        if (A == null || b == null) {
            throw new NullPointerException();
        }
        if (A.getRowCount() != b.getRowCount()) {
            throw new IllegalArgumentException();
        }
        this.A = A;
        this.b = b;
    }

    public boolean converges() {
        for (int i = 0; i < A.getRowCount(); i++) {
            double diagonal = Math.abs(A.getAsDouble(i, i));
            double tmpSum = 0;
            for (int j = 0; j < A.getRowCount(); j++) {
                if (i != j) {
                    tmpSum += Math.abs(A.getAsDouble(i, j));
                }
            }
            if (tmpSum >= diagonal) {
                return false;
            }
        }
        return true;
    }

    public Matrix solveSystem(int precision) {
        /*
        if (!converges()) {
            System.err.println("Non convergence");
        }
        */
        Matrix x = DenseMatrix.Factory.zeros(A.getRowCount(), 1);
        for (int k = 0; k < precision; k++) {
            for (int i = 0; i < A.getRowCount(); i++) {
                double x0 = 0;
                for (int j = 0; j < A.getRowCount(); j++) {
                    if (i != j) {
                        x0 += A.getAsDouble(i, j) * x.getAsDouble(j, 0);
                    }
                }
                x.setAsDouble(((b.getAsDouble(i, 0) - x0) / A.getAsDouble(i, i)), i, 0);
            }
        }
        return x;
    }

}
