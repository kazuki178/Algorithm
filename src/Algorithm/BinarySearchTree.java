package Algorithm;

class BST {
    public int data; // 要素のデータ
    public int left; // 左の子へのポインタ
    public int right; // 右の子へのポインタ
}

public class BinarySearchTree {
    // 二分探索木の実態となる配列
    public static BST[] tree = new BST[10];

    // 先頭ポインタ
    public static int rootIdx = 0;

    // 次に格納する要素の添え字
    public static int newIdx = 0;

    // 二分探索木に要素を追加するメソッド
    public static void addBST(int data) {
        int currentIdx;// 現在のノードの添え字
        boolean addFlag;

        // 物理的な位置に要素を格納する
        tree[newIdx].data = data;
        tree[newIdx].left = -1;
        tree[newIdx].right = -1;

        // 根のデータでないなら論理的な位置にポインタを設定する
        if (newIdx != rootIdx) {
            currentIdx = rootIdx;
            addFlag = false;
            do {
                // より小さい場合は左にたどる
                if (data < tree[currentIdx].data) {
                    // 左が末端なら格納する
                    if (tree[currentIdx].left == -1) {
                        tree[currentIdx].left = newIdx;
                        addFlag = true;
                    } else {
                        currentIdx = tree[currentIdx].left;
                    }
                } // より大きい場合は右にたどる
                else {
                    // 右が末端なら格納する
                    if (tree[currentIdx].right == -1) {
                        tree[currentIdx].right = newIdx;
                        addFlag = true;
                    } // 右が末端でないならさらに右に要素をたどる
                    else {
                        currentIdx = tree[currentIdx].right;
                    }
                }
            } while (addFlag == false);
        }
        // 次に格納する要素の添え字を更新する
        newIdx++;
    }

    // 二分探索木の実態配列を物理的な順序で表示するメソッド
    public static void printPhysicalBST() {
        for (int i = 0; i < newIdx; i++) {
            System.out.println("tree[" + i + "] : " + "data = " + tree[i].data + " , " + "left = " + tree[i].left
                    + " , " + "right = " + tree[i].right);
        }
    }

    // 二分探索木の論理的な順序(深さ優先探索)で表示するメソッド
    public static void printLogicalBST(int currentIdx) {
        if (currentIdx != -1) {
            System.out.println("tree[" + currentIdx + "] : " + "data = " + tree[currentIdx].data + " , " + "left = "
                    + tree[currentIdx].left + " , " + "right = " + tree[currentIdx].right);

            // この部分が再帰呼び出し
            printLogicalBST(tree[currentIdx].left);
            printLogicalBST(tree[currentIdx].right);
        }
    }

    // 二分探索木を探索するメソッド
    public static int searchBST(int x) {
        int idx; // 見つかった要素の添え字
        int currentIdx; // 現在たどっているノードの添え字

        idx = -1;
        currentIdx = rootIdx;
        while (currentIdx != -1) {
            if (tree[currentIdx].data == x) {
                idx = currentIdx;
                break;
            } else if (tree[currentIdx].data > x) {
                currentIdx = tree[currentIdx].left;
            } else {
                currentIdx = tree[currentIdx].right;
            }
        }
        return idx;
    }

    // 再帰呼び出しで二分探索木を実装
    public static int serchRecBST(int x, int currentIdx) {
        if (currentIdx == -1) {
            return -1;
        } else {
            if (tree[currentIdx].data == x) {
                return currentIdx;
            } else if (tree[currentIdx].data > x) {
                return serchRecBST(x, tree[currentIdx].left);
            } else {
                return serchRecBST(x, tree[currentIdx].right);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new BST();
        }

        addBST(4);
        addBST(6);
        addBST(5);
        addBST(2);
        addBST(3);
        addBST(7);
        addBST(1);
        printPhysicalBST();

        // 二分探索木の論理的な順序を表示する
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println();
        printLogicalBST(rootIdx);

        // 二分探索木を探索する
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.println("探索の開始");
        System.out.println("5の探索結果 : " + searchBST(5));
        System.out.println("8の探索結果 : " + searchBST(8));

        //再帰呼び出しで二分探索木を実装
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.println("探索の開始");

        System.out.print("5の探索結果 : ");
        System.out.println(serchRecBST(5, rootIdx));
        System.out.print("8の探索結果 : ");
        System.out.println(serchRecBST(8, rootIdx));
    }
}
