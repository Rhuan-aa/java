package br.edu.ifsp.list02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class Ex06Test {
    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
        5, 6, 3, 8, 2, 0 | 10, 20, 30, 40, 50, 60 | 5 10 6 20 3 30 8 40 2 50 0 60
        1, 0, 5, 2, 9, 2, 1, 5, 1, 4, 8, 2, 9, 3, 2, 0, 0, 4, 2, 3, 1, 9, 7, 5, 3, 5, 8, 3, 5, 2, 5, 9, 9, 8, 6, 4, 1, 8, 7, 2, 1, 0, 4, 2, 7, 5, 1, 4, 3, 9, 7, 7, 2, 9, 1, 2, 5, 6, 2, 0, 3, 9, 0, 0, 8, 1, 8, 4, 4, 3, 4, 1, 7, 6, 5, 7, 2, 1, 7, 5, 9, 0, 4, 5, 9, 2, 2, 0, 3, 0, 8, 4, 7, 7, 8, 5, 3, 4, 8, 4 | 5, 28, 1, 28, 1, 11, 29, 19, 15, 9, 25, 23, 12, 25, 1, 22, 10, 2, 13, 12, 29, 14, 14, 21, 4, 2, 5, 12, 10, 0, 17, 12, 2, 29, 1, 16, 1, 24, 11, 28, 20, 15, 14, 8, 12, 18, 2, 0, 18, 1, 10, 28, 17, 25, 20, 6, 1, 10, 20, 9, 23, 6, 3, 28, 9, 3, 5, 12, 9, 15, 11, 14, 19, 27, 23, 24, 28, 12, 29, 4, 26, 13, 20, 13, 12, 20, 2, 19, 27, 12, 17, 0, 18, 18, 26, 6, 18, 19, 26, 0 | 1 5 0 28 5 1 2 28 9 1 2 11 1 29 5 19 1 15 4 9 8 25 2 23 9 12 3 25 2 1 0 22 0 10 4 2 2 13 3 12 1 29 9 14 7 14 5 21 3 4 5 2 8 5 3 12 5 10 2 0 5 17 9 12 9 2 8 29 6 1 4 16 1 1 8 24 7 11 2 28 1 20 0 15 4 14 2 8 7 12 5 18 1 2 4 0 3 18 9 1 7 10 7 28 2 17 9 25 1 20 2 6 5 1 6 10 2 20 0 9 3 23 9 6 0 3 0 28 8 9 1 3 8 5 4 12 4 9 3 15 4 11 1 14 7 19 6 27 5 23 7 24 2 28 1 12 7 29 5 4 9 26 0 13 4 20 5 13 9 12 2 20 2 2 0 19 3 27 0 12 8 17 4 0 7 18 7 18 8 26 5 6 3 18 4 19 8 26 4 0
        56, 95, 35, 24, 72, 43, 65, 75, 33, 88, 49, 95, 78, 57, 63, 47, 93, 39, 10, 87, 88, 57, 57, 66, 24, 46, 0, 50, 8, 39, 82, 16, 96, 63, 63, 60, 8, 55, 36, 98, 81, 21, 96, 22, 49, 76, 57, 27, 11, 76, 27, 15, 94, 76, 74, 5, 87, 45, 99, 12, 8, 50, 95, 5, 32, 40, 87, 68, 80, 55, 65, 73, 20, 97, 81, 81, 96, 19, 20, 82, 9, 83, 72, 18, 23, 0, 96, 52, 95, 72, 20, 26, 81, 31, 65, 85, 26, 24, 50, 21 | 28, 39, 37, 39, 14, 6, 43, 38, 15, 3, 6, 42, 29, 34, 43, 41, 22, 17, 45, 43, 49, 3, 35, 24, 9, 30, 30, 41, 36, 19, 12, 11, 9, 18, 31, 20, 49, 48, 30, 29, 46, 25, 49, 33, 31, 38, 34, 49, 22, 19, 37, 33, 38, 44, 3, 40, 30, 45, 12, 12, 41, 38, 13, 6, 12, 45, 27, 27, 48, 11, 2, 29, 21, 28, 6, 33, 44, 48, 12, 7, 41, 36, 1, 19, 45, 18, 25, 26, 13, 9, 11, 49, 30, 32, 31, 31, 47, 24, 21, 11 | 56 28 95 39 35 37 24 39 72 14 43 6 65 43 75 38 33 15 88 3 49 6 95 42 78 29 57 34 63 43 47 41 93 22 39 17 10 45 87 43 88 49 57 3 57 35 66 24 24 9 46 30 0 30 50 41 8 36 39 19 82 12 16 11 96 9 63 18 63 31 60 20 8 49 55 48 36 30 98 29 81 46 21 25 96 49 22 33 49 31 76 38 57 34 27 49 11 22 76 19 27 37 15 33 94 38 76 44 74 3 5 40 87 30 45 45 99 12 12 12 8 41 50 38 95 13 5 6 32 12 40 45 87 27 68 27 80 48 55 11 65 2 73 29 20 21 97 28 81 6 81 33 96 44 19 48 20 12 82 7 9 41 83 36 72 1 18 19 23 45 0 18 96 25 52 26 95 13 72 9 20 11 26 49 81 30 31 32 65 31 85 31 26 47 24 24 50 21 21 11
        3, 1, 4, 2, 8, 2, 0, 2, 10, 3, 9 | 3, -1, 4, -2, 8, -2, 0, -2, 10, -3, -9 | 3 3 1 -1 4 4 2 -2 8 8 2 -2 0 0 2 -2 10 10 3 -3 9 -9
        9, 3, 2, 5, 4, 8, 2, 5, 0, 4 | -9, -3, -2, -5, -4, -8, -2, -5, 0, -4 | 9 -9 3 -3 2 -2 5 -5 4 -4 8 -8 2 -2 5 -5 0 0 4 -4
        10, 9, 8, 7, 6, 5, 4, 3, 2, 1 | 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 | 10 1 9 2 8 3 7 4 6 5 5 6 4 7 3 8 2 9 1 10
        10, 20, 30 | 3, 1, 2 | 10 3 20 1 30 2
        10, 20 | 20, 10 | 10 20 20 10
        10 | 41 | 10 41
        1, 2, 3 | 1, 1, 1 | 1 1 2 1 3 1
    """)
    void testCompute(String arrayA, String arrayB, String expected){
        Ex06 sut = new Ex06();
        final int[] arrayAAsString = stringToArray(arrayA);
        final int[] arrayBAsString = stringToArray(arrayB);
        assertThat(sut.compute(arrayAAsString, arrayBAsString)).isEqualTo(expected);
    }

    private static int[] stringToArray(String arrayString) {
        String[] stringValues = arrayString.split(", ");
        int[] array = new int[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            array[i] = Integer.parseInt(stringValues[i]);
        }
        return array;
    }
}