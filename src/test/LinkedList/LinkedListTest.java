package test.LinkedList;

class linkedListStation {
    public String name;
    public int next;
}

public class LinkedListTest {
    public static linkedListStation[] list = new linkedListStation[10];

    // ポインタ
    public static int pointer;

    public static void initStationList() {
        for (int i = 0; i < list.length; i++) {
            list[i] = new linkedListStation();
        }

        list[0].name = "新大阪";
        list[0].next = -1;
        list[1].name = "名古屋";
        list[1].next = 3;
        list[2].name = "東京";
        list[2].next = 4;
        list[3].name = "京都";
        list[3].next = 0;
        list[4].name = "新横浜";
        list[4].next = 1;

        pointer = 2;
    }

    public static void printStationList() {
        int idx = pointer;
        while (idx != -1) {
            System.out.print("[" + list[idx].name + "]→");
            idx = list[idx].next;
        }
        System.out.println();
    }

    public static void insertStationList(int insIdx, String insName, int PrevIdx) {
        list[insIdx].name = insName;
        list[insIdx].next = list[PrevIdx].next;
        list[PrevIdx].next = insIdx;
    }

    public static void deleteStationList(int delIdx, int PrevIdx) {
        list[PrevIdx].next = list[delIdx].next;
    }

    public static void main(String[] args) {
        initStationList();
        printStationList();

        insertStationList(5, "品川", 1);
        printStationList();

        deleteStationList(5, 1);
        printStationList();
    }
}