package lesson_5;

public class Main {

    static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }

    static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message) {
            super(message);
        }
    }

    static class ArrayUtils {

        public static int arraySum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
            if (arr.length != 4) {
                throw new MyArraySizeException("Неверное количество строк: " + arr.length);
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4) {
                    throw new MyArraySizeException("Неверное количество столбцов в строке " + i + ": " + arr[i].length);
                }
            }

            int sum = 0;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    try {
                        sum += Integer.parseInt(arr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]: '" + arr[i][j] + "'");
                    }
                }
            }

            return sum;
        }
    }

    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "ы", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2"},
                {"3", "4"}
        };

        try {
            int result = ArrayUtils.arraySum(correctArray);
            System.out.println("Сумма элементов = " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            int result = ArrayUtils.arraySum(wrongDataArray);
            System.out.println("Сумма элементов = " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            int result = ArrayUtils.arraySum(wrongSizeArray);
            System.out.println("Сумма элементов = " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // специально ошибка
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}