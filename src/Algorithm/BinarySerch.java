package Algorithm;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinarySerch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = sc.nextInt();

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(39, 41, 53, 55, 68, 72, 84, 88, 92, 97));
        int pos = -1, left = 0, right = list.size() - 1,middle;
        System.out.println("ループ前 :x = "+x );
        System.out.println("ループの前 :pos ="+pos + "  lift ="+left +"  middle ="+ "?" + "  right " +right);


        while (pos == -1 && left <= right) {
            middle = (left + right) / 2;
            if (list.get(middle) == x) {
                pos = middle;
            } else if (list.get(middle) > x) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            System.out.println("ループの中 :pos ="+pos + "  lift ="+left +"  middle ="+ middle + "  right " +right);
        }

        if (pos == -1) {
            System.out.println("not found");
        } else {
            System.out.println("pos :" + pos);
        }

        System.out.println("serch complete");
        sc.close();
    }

}
