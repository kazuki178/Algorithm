package test.InsertSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSortTest {
    public static void printArray(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + list.get(i) + "]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(90, 34, 78, 12, 56));
        printArray(list);
        int cmp;

        for (int ins = 1; ins < list.size(); ins++) {
            int tmp = list.get(ins);

            for ( cmp = ins - 1;  cmp >= 0&& list.get(cmp) > tmp ; cmp--) {
                if(list.get(cmp) > tmp){
                    list.set(cmp+1, list.get(cmp));
                }
            }

            list.set(cmp+1,tmp);
        }

        printArray(list);
    }
}
