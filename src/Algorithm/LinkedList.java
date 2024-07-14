package Algorithm;

/**
 * stationList
 */
class stationList {
    public String name;
    public int next; // ポインタ
}

// 連結リストを定義するクラス
public class LinkedList {
    public static stationList[] list = new stationList[10];

    // ポインタ
    public static int pointer;

    // インスタンスの初期化
    public static void initStationList() {
        for (int i = 0; i < list.length; i++) {
            list[i] = new stationList();
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

    public static void printStationList(){
        int idx = pointer;
        while (idx != -1) {
            System.out.print("["+list[idx].name+"]→");
            idx = list[idx].next;
        }
        System.out.println();
    } 


    // 連結リストに要素を挿入する
    public static void insertStationList(int insIdx,String insName ,int prevIdx){
        list[insIdx].name = insName;
        list[insIdx].next = list[prevIdx].next;
        list[prevIdx].next = insIdx;
    }

    // 連結リストの要素を削除する
    public  static void deleteStationList(int preIdx,int delIdx){
        list[preIdx].next = list[delIdx].next;
    }


    public static void main(String[] args) {
        initStationList();
        printStationList();

        // 連結リストに要素を挿入して表示する
        insertStationList(5,"品川",2);
        printStationList();

        // 連結リストの要素を削除して表示する
        deleteStationList(2, 5);
        printStationList();
    }

}
