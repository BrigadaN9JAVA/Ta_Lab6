public class TestTimeRedBlackTree {
    RedBlackTree rbt;

    public TestTimeRedBlackTree(RedBlackTree rbt){
        this.rbt = rbt;
    }

    public long testInsert(int key){
        long end;
        long start = System.nanoTime();
        rbt.insert(key);
        end = System.nanoTime();
        return end-start;
    }

    public long testFind(int key){
        long end;
        long start = System.nanoTime();
        rbt.find(key);
        end = System.nanoTime();
        return end-start;
    }

    public long testRemove(int key){
        long end;
        long start = System.nanoTime();
        rbt.deleteNode(key);
        end = System.nanoTime();
        return end-start;
    }
}
