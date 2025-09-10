package org.example;

public class Lesson2 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

        boolean result = isSumWithinRange(10, 20);
        System.out.println(result);

        printNumberSign(0);

        boolean printResult = isNegative(-1);
        if (printResult) {
            System.out.println("Отрицательное");
        } else {
            System.out.println("Положительное");
        }

        printMessage("Hello", 3);

        boolean leapResult = isLeapYear(400);
        if (leapResult) {
            System.out.println("високосный");
        } else {
            System.out.println("не високосный");
        }

        invertArray(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 0, 1});

        fillArrayOneToHundred();

        doubleIfLessThanSix(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});

        fillDiagonalArray(5);

        int[] arr = createArray(5, 7);
        System.out.print("Созданный массив: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printThreeWords() {
        System.out.println("orange");
        System.out.println("banana");
        System.out.println("apple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = -20;
        if (a + b >= 0) {
            System.out.println("сумма положительная");
        } else {
            System.out.println("сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = -100;
        if (value <= 0) {
            System.out.println("красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("желтый");
        } else {
            System.out.println("зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 12;
        int b = 13;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean isSumWithinRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void printNumberSign(int a) {
        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean isNegative(int a) {
        return a < 0;
    }

    public static void printMessage(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static void invertArray(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            mass[i] = (mass[i] == 0) ? 1 : 0;
        }
        System.out.print("Измененный массив: ");
        for (int num : mass) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void fillArrayOneToHundred() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.print("Массив 1..100: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void doubleIfLessThanSix(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.print("Измененный массив: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void fillDiagonalArray(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
        }
        System.out.println("Диагональный массив:");
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}