package ru.job4j.array;
import java.util.*;

/**
 * В этой программе демонстриуется обращение с массивами
 * @version 1.20
 * @author Popov Mikhail (m.popov83@gmail.com)
 */

public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Сколько номеров вам нужно отобразить?");
        int k = in.nextInt();
        System.out.print("Какое максимальное значение чисел?");
        int n = in.nextInt();
        //заполнить массив числами 1 2 3 ... n
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        //выбрать k номеров и поместить их во второй массив
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            // получить случайный индекс в пределах от 0 до n - 1
            int r = (int) (Math.random() * n);
            //выбрать елемент из произвольного места
            result[i] = numbers[r];
            //переместить последний элемент в произвольное место
            numbers[r] = numbers[n - 1];
            n--;
        }
        //вывести отсортированный массив
        Arrays.sort(result);
        System.out.println("Bet the following combination. It'll make you rich!");
        for (int r : result) {
            System.out.println(r);
        }
        //System.out.println(Arrays.toString(numbers));
    }
}
