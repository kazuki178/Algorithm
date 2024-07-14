package test.BinarySerch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinarySerchTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(39, 41, 53, 55, 68, 72, 84, 88, 92, 97));

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int left = 0, right = list.size() - 1;

        int pos = -1;

        while (pos == -1 && left <= right) {
            int middle = (left + right / 2);
            if (list.get(middle) == x) {
                pos = middle;
            } else if (middle > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (pos == -1) {
            System.out.println("not found");
        }else{
            System.out.println("要素が見つかりました。位置は"+pos+"です。");
        }
        sc.close();
    }

}
