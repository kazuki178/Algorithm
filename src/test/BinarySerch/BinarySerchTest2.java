package test.BinarySerch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinarySerchTest2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(39, 41, 53, 55, 68, 72, 84, 88, 92, 97));
        int pos = -1, left = 0, right = list.size() - 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("検索する値を入力してください :");
        int x = sc.nextInt();

        while (pos == -1 && left <= right) {
            int middle = (left+right)/2;
            if(list.get(middle)==x){
                pos = middle;
                break;
            }
            if(list.get(middle)>x){
                right = middle-1;
            }else{
                left = middle+1;
            }
        }
        if(pos==-1)
        System.out.println("not found");
        else
        System.out.println("要素が見つかりました。位置は"+pos+"です。");

        sc.close();
    }
}
