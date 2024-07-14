package test.InsertSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSortTest2 {

    public static void showList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + list.get(i) + "]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(90, 34, 78, 12, 56));
        showList(list);
        int cmp;

        for (int ins = 1; ins <= list.size() - 1; ins++) {
            int tmp = list.get(ins);
            for (cmp = ins - 1; cmp >= 0 && list.get(cmp) > tmp; cmp--) {
                list.set(cmp + 1, list.get(cmp));
            }
            list.set(++cmp, tmp);
        }
        showList(list);
    }
}
