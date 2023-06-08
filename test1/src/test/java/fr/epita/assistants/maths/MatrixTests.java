package fr.epita.assistants.maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTests {
    @Test
    void testMatrixMultiplication() {
        int[][] mat2 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
        };
        int[][] mat1 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int[][] expected = new int[][] {
            { 30, 36, 42 },
            { 66, 81, 96 },
        };

        Matrix m1 = new Matrix(mat1);
        Matrix m2 = new Matrix(mat2);
        Matrix result = m1.multiply(m2);

        assertArrayEquals(expected, result.getMatrix());
    }

    @Test
    void testMatrixEquality() {
        int[][] mat1 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int[][] mat2 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 10 }
        };

        Matrix m1 = new Matrix(mat1);
        Matrix m2 = new Matrix(mat2);

        assertFalse(m1.equals(m2));
    }

    @Test
    void testMatrixMultiplication2() {
        int[][] mat1 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
        };
        int[][] mat2 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int[][] expected = new int[][] {
            { 30, 36, 42 },
            { 66, 81, 96 },
        };

        Matrix m1 = new Matrix(mat1);
        Matrix m2 = new Matrix(mat2);
        Matrix result = m1.multiply(m2);

        assertArrayEquals(expected, result.getMatrix());
    }

    @Test 
    void testMatrixEquality2() {
        int[][] mat1 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int[][] mat2 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        Matrix m1 = new Matrix(mat1);
        Matrix m2 = new Matrix(mat2);

        assertTrue(m1.equals(m2));
    }

    @Test
    void testMatrixEquality3() {
        int[][] mat1 = new int[][] {
            { 1, 2},
            { 4, 5},
        };
        int[][] mat2 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
        };

        Matrix m1 = new Matrix(mat1);
        Matrix m2 = new Matrix(mat2);

        assertFalse(m1.equals(m2));
    }

    @Test
    void testMatrixEquality4() {
        int[][] mat1 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
        };
        int[][] mat2 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        Matrix m1 = new Matrix(mat1);
        Matrix m2 = new Matrix(mat2);

        assertFalse(m1.equals(m2));
    }

    @Test
    void testMatrixConstructor() {
        int[][] mat1 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
        };
        int[][] mat2 = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
        };

        Matrix m1 = new Matrix(mat1);

        assertArrayEquals( mat2 , m1.getMatrix());
    }

    @Test
    void testMatrixConstructor2() {
        int[][] mat1 = new int[][] {
            { 1, 2 },
            { 4, 5 },
        };
        int[][] mat2 = new int[][] {
            { 1, 2},
            { 4, 5 },
        };

        Matrix m1 = new Matrix(mat1);

        assertEquals(m1.getMatrix().length, 2);
        assertEquals(m1.getMatrix()[0].length, 2);
    }

    @Test
    void testMatrixConstructor3() {
        int[][] mat1 = new int[][] {
            { 7, 2, 3 },
            { 4, 5, 12 },
            { 7, 14, 9 }
        };

        Matrix m1 = new Matrix(mat1);

        assertEquals(m1.getMatrix()[0][0], 7);
        assertEquals(m1.getMatrix()[1][2], 12);
        assertEquals(m1.getMatrix()[2][1], 14);
    }

    @Test
    void testMatrixConstructor4() {
        int[][] mat1 = new int[][] {
            { 1, 2 },
            { 4, 5 },
            { 7, 8 },
            { 10, 11 },
        };

        Matrix m1 = new Matrix(mat1);

        assertEquals(m1.getMatrix().length, 4);
        assertEquals(m1.getMatrix()[0].length, 2);
    }
        @Test
    public void constructor_givenMatrix_shouldCreateMatrix() {
        int[][] matrix = {
            {1, 2},
            {3, 4}
        };
        
        Matrix m = new Matrix(matrix);
        
        assertArrayEquals(matrix, m.getMatrix());
    }
    
    @Test
    public void constructor_givenNullMatrix_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Matrix(null);
        });
    }
    
    @Test
    public void constructor_givenEmptyMatrix_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Matrix(new int[][] {});
        });
    }
    
    @Test
    public void equals_givenEqualMatrices_shouldReturnTrue() {
        int[][] matrix1 = {
            {1, 2},
            {3, 4}
        };
        
        int[][] matrix2 = {
            {1, 2},
            {3, 4}
        };
        
        Matrix m1 = new Matrix(matrix1);
        Matrix m2 = new Matrix(matrix2);
        
        assertEquals(m1, m2);
    }
    
    @Test
    public void equals_givenNonEqualMatrices_shouldReturnFalse() {
        int[][] matrix1 = {
            {1, 2},
            {3, 4}
        };
        
        int[][] matrix2 = {
            {4, 3},
            {2, 1}
        };
        
        Matrix m1 = new Matrix(matrix1);
        Matrix m2 = new Matrix(matrix2);
        
        assertNotEquals(m1, m2);
    }
    
    @Test
    public void equals_givenNonMatrixObject_shouldReturnFalse() {
        int[][] matrix = {
            {1, 2},
            {3, 4}
        };
        
        Matrix m = new Matrix(matrix);
        assertFalse(m.equals(new Object()));
    }
    
    @Test
    public void multiply_givenValidMatrices_shouldReturnMultipliedMatrix() {
        int[][] matrix1 = {
            {1, 2},
            {3, 4}
        };
        
        int[][] matrix2 = {
            {4, 3},
            {2, 1}
        };
        
        int[][] expectedMatrix = {
            {8, 5},
            {20, 13}
        };
        
        Matrix m1 = new Matrix(matrix1);
        Matrix m2 = new Matrix(matrix2);
        
        assertArrayEquals(expectedMatrix, m1.multiply(m2).getMatrix());
    }
    
    @Test
    public void multiply_givenIncompatibleMatrices_shouldThrowIllegalArgumentException() {
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        int[][] matrix2 = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        
        Matrix m1 = new Matrix(matrix1);
        Matrix m2 = new Matrix(matrix2);
        
        assertThrows(IllegalArgumentException.class, () -> {
            m1.multiply(m2);
        });
    }

    void testConstructor() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix mat = new Matrix(matrix);

        assertEquals(matrix, mat.getMatrix());
    }
    
    @Test
    void testConstructorDifferentSize() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Matrix mat = new Matrix(matrix);

        assertEquals(matrix, mat.getMatrix());
    }
    
    @Test
    void testConstructorNegativeValues() {
        int[][] matrix = {{-1, -2, -3}, {-4, -5, -6}, {-7, -8, -9}};
        Matrix mat = new Matrix(matrix);

        assertEquals(matrix, mat.getMatrix());
    }
    
    @Test
    void testConstructorEmptyMatrix() {
        int[][] matrix = {};
        Matrix mat = new Matrix(matrix);

        assertEquals(matrix, mat.getMatrix());
    }
    
    @Test
    void testConstructorSingleValue() {
        int[][] matrix = {{1}};
        Matrix mat = new Matrix(matrix);

        assertEquals(matrix, mat.getMatrix());
    }
    
    @Test
    void testConstructorNullMatrix() {
        int[][] matrix = null;
        Matrix mat = new Matrix(matrix);

        assertEquals(matrix, mat.getMatrix());
    }
    @Test
    public void constructorTest() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix mat = new Matrix(matrix);
        assertArrayEquals(matrix, mat.getMatrix());
    }

    @Test
    public void constructorTest_EmptyMatrix() {
        int[][] matrix = {};
        Matrix mat = new Matrix(matrix);
        assertArrayEquals(matrix, mat.getMatrix());
    }

    @Test
    public void constructorTest_NullMatrix() {
        int[][] matrix = null;
        assertThrows(IllegalArgumentException.class, () -> new Matrix(matrix));
    }

    @Test
    public void constructorTest_InvalidMatrix() {
        int[][] matrix = {{1, 2, 3}, {4, 5}};
        assertThrows(IllegalArgumentException.class, () -> new Matrix(matrix));
    }
    
}
    

