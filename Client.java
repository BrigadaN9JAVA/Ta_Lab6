public class Client {
    public static void main(String[] args) {
        TestTimeBinaryTree tm  = new TestTimeBinaryTree(new BinaryTree());
        long time = 0;
        for (int i = 0; i < 1000000; i++) {
            time += tm.testInsert((int) (Math.random()*2000001));
        }
        tm.bt.getRootNode().printNode();
        System.out.println("Test BinaryTree insert => " + time/1000000 + " ns");

        time = 0;
        tm.testInsert(1);
        tm.testInsert(2000000);
        tm.testInsert(1000000);
        tm.testInsert(500000);
        tm.testInsert(1500000);

        time+= tm.testFind(1);
        time+= tm.testFind(2000000);
        time+= tm.testFind(1000000);
        time+= tm.testFind(500000);
        time+= tm.testFind(1500000);
        System.out.println("Test BinaryTree find => " + time/5 + " ns");

        time = 0;
        time += tm.testRemove(1);
        time += tm.testRemove(2000000);
        time += tm.testRemove(1000000);
        time += tm.testRemove(500000);
        time += tm.testRemove(1500000);
        System.out.println("Test BinaryTree remove => " + time/5 + " ns");
        System.out.println("==========================================");

        TestTimeRedBlackTree tmr = new TestTimeRedBlackTree(new RedBlackTree());
        time = 0;
        for (int i = 0; i < 1000000; i++) {
            time += tmr.testInsert((int) (Math.random()*2000001));
        }
        tmr.rbt.getRoot().printNode();
        System.out.println("Test RebBlackTree insert => " + time/1000000 + " ns");
        time = 0;
        tmr.testInsert(1);
        tmr.testInsert(2000000);
        tmr.testInsert(1000000);
        tmr.testInsert(500000);
        tmr.testInsert(1500000);

        time+= tmr.testFind(1);
        time+= tmr.testFind(2000000);
        time+= tmr.testFind(1000000);
        time+= tmr.testFind(500000);
        time+= tmr.testFind(1500000);
        System.out.println("Test RebBlackTree find => " + time/5 + " ns");

        time = 0;
        time += tmr.testRemove(1);
        time += tmr.testRemove(2000000);
        time += tmr.testRemove(1000000);
        time += tmr.testRemove(500000);
        time += tmr.testRemove(1500000);
        System.out.println("Test RebBlackTree remove => " + time/5 + " ns");

        System.out.println("==========================================");

        RedBlackTree rbt = new RedBlackTree();
        time = 0;
        for (int i = 0; i < 1000000; i++) {
            time += rbt.insert((int) (Math.random()*2000001));
        }
        rbt.getRoot().printNode();
        System.out.println("Test RedBlackTree insert => " + time/1000000 + " ns");

        time = 0;
        rbt.insert(1);
        rbt.insert(2000000);
        rbt.insert(1000000);
        rbt.insert(500000);
        rbt.insert(1500000);

        time += rbt.deleteNode(1);
        time += rbt.deleteNode(2000000);
        time += rbt.deleteNode(1000000);
        time += rbt.deleteNode(500000);
        time += rbt.deleteNode(1500000);
        System.out.println("Test RebBlackTree remove => " + time/5 + " ns");

        System.out.println("==========================================");

        tm = new TestTimeBinaryTree(new BinaryTree());
        time = 0;
        for (int i = 0; i < 10000; i++) {
            time += tm.testInsert(i);
        }
        tm.bt.getRootNode().printNode();
        System.out.println("Test BinaryTree insert => " + time/10000 + " ns");

        time = 0;
        tm.testInsert(1);
        tm.testInsert(2000000);
        tm.testInsert(1000000);
        tm.testInsert(500000);
        tm.testInsert(1500000);

        time+= tm.testFind(1);
        time+= tm.testFind(2000000);
        time+= tm.testFind(1000000);
        time+= tm.testFind(500000);
        time+= tm.testFind(1500000);
        System.out.println("Test BinaryTree find => " + time/5 + " ns");

        time = 0;
        time += tm.testRemove(1);
        time += tm.testRemove(2000000);
        time += tm.testRemove(1000000);
        time += tm.testRemove(500000);
        time += tm.testRemove(1500000);
        System.out.println("Test BinaryTree remove => " + time/5 + " ns");
        System.out.println("==========================================");

        tmr = new TestTimeRedBlackTree(new RedBlackTree());
        time = 0;
        for (int i = 0; i < 10000; i++) {
            time += tmr.testInsert(i);
        }
        tmr.rbt.getRoot().printNode();
        System.out.println("Test RebBlackTree insert => " + time/10000 + " ns");
        time = 0;
        tmr.testInsert(1);
        tmr.testInsert(2000000);
        tmr.testInsert(1000000);
        tmr.testInsert(500000);
        tmr.testInsert(1500000);

        time+= tmr.testFind(1);
        time+= tmr.testFind(2000000);
        time+= tmr.testFind(1000000);
        time+= tmr.testFind(500000);
        time+= tmr.testFind(1500000);
        System.out.println("Test RebBlackTree find => " + time/5 + " ns");

        time = 0;
        time += tmr.testRemove(1);
        time += tmr.testRemove(2000000);
        time += tmr.testRemove(1000000);
        time += tmr.testRemove(500000);
        time += tmr.testRemove(1500000);
        System.out.println("Test RebBlackTree remove => " + time/5 + " ns");

        System.out.println("==========================================");
    }
}
