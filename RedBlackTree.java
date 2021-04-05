public class RedBlackTree {
    private RedBlackNode root;
    private RedBlackNode TNULL;

    public RedBlackTree(){
        TNULL = new RedBlackNode();
        TNULL.setColor(0);
        TNULL.setLeft(null);
        TNULL.setRight(null);
        root = TNULL;
    }

    public void insert(int key){
        RedBlackNode newNode = new RedBlackNode();
        newNode.setParent(null);
        newNode.setData(key);
        newNode.setLeft(TNULL);
        newNode.setRight(TNULL);
        newNode.setColor(1);

        RedBlackNode currentNode= this.root;
        RedBlackNode parentNode = null;

        while(currentNode != TNULL){
            parentNode = currentNode;
            if(newNode.getData() < currentNode.getData()){
                currentNode = currentNode.getLeft();
            }
            else{
                currentNode = currentNode.getRight();
            }
        }

        newNode.setParent(parentNode);
        if(parentNode == null){
            root = newNode;
        }
        else if(newNode.getData()<parentNode.getData()){
            parentNode.setLeft(newNode);
        }
        else{
            parentNode.setRight(newNode);
        }

        if(newNode.getParent() == null){
            newNode.setColor(0);
            return;
        }

        if(newNode.getParent().getParent() == null){
            return;
        }

        fixInsert(newNode);
    }

    private void fixInsert(RedBlackNode k){
        RedBlackNode u;
        while (k.getParent().getColor() == 1){
            if(k.getParent() == k.getParent().getParent().getRight()){
                u = k.getParent().getParent().getLeft();
                if(u.getColor() == 1){
                    u.setColor(0);
                    k.getParent().setColor(0);
                    k.getParent().getParent().setColor(1);
                    k = k.getParent().getParent();
                }
                else {
                    if(k == k.getParent().getLeft()){
                        k = k.getParent();
                        rightRotate(k);
                    }
                    k.getParent().setColor(0);
                    k.getParent().getParent().setColor(1);
                    leftRotate(k.getParent().getParent());
                }
            } else {
                u = k.getParent().getParent().getRight();

                if(u.getColor() == 1){
                    u.setColor(0);
                    k.getParent().setColor(0);
                    k.getParent().getParent().setColor(1);
                    k = k.getParent().getParent();
                }
                else {
                    if(k == k.getParent().getRight()){
                        k = k.getParent();
                        leftRotate(k);
                    }
                    k.getParent().setColor(0);
                    k.getParent().getParent().setColor(1);
                    rightRotate(k.getParent().getParent());
                }
            }
            if(k == root){
                break;
            }
        }
        root.setColor(0);
    }

    private void rightRotate(RedBlackNode x){
        RedBlackNode y = x.getLeft();
        x.setLeft(y.getRight());
        if(y.getRight() != TNULL){
            y.getRight().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == null){
            this.root = y;
        }
        else if(x == x.getParent().getRight()){
            x.getParent().setRight(y);
        }
        else {
            x.getParent().setLeft(y);
        }
        y.setRight(x);
        x.setParent(y);
    }

    private void leftRotate(RedBlackNode x){
        RedBlackNode y = x.getRight();
        x.setRight(y.getLeft());
        if(y.getLeft() != TNULL){
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == null){
            this.root = y;
        }
        else if(x == x.getParent().getLeft()){
            x.getParent().setLeft(y);
        }
        else {
            x.getParent().setRight(y);
        }
        y.setLeft(x);
        x.setParent(y);
    }

    public RedBlackNode find(int key){
        return  findHelper(this.root, key);
    }

    private RedBlackNode findHelper(RedBlackNode node, int key){
        if(node == TNULL || key == node.getData()){
            return node;
        }
        if(key < node.getData()){
            return findHelper(node.getLeft(), key);
        }
        return findHelper(node.getRight(), key);
    }

    public void deleteNode(int key){
        deleteNodeHelper(this.root, key);
    }

    private void deleteNodeHelper(RedBlackNode node, int key){
        RedBlackNode z = TNULL;
        RedBlackNode x, y;
        while(node != TNULL){
            if(node.getData() == key){
                z = node;
            }
            if(node.getData() <= key){
                node = node.getRight();
            }
            else{
                node = node.getLeft();
            }
        }

        if(z == TNULL){
            System.out.println("Couldn't find key in the tree");
            return;
        }

        y = z;
        int yOriginalColor = y.getColor();
        if(z.getLeft() == TNULL){
            x = z.getRight();
            rbTransplant(z, z.getRight());
        }
        else if(z.getRight() == TNULL){
            x = z.getLeft();
            rbTransplant(z, z.getLeft());
        }
        else {
            y = minimum(z.getRight());
            yOriginalColor = y.getColor();
            x = y.getRight();
            if(y.getParent() == z){
                x.setParent(y);
            }
            else {
                rbTransplant(y, y.getRight());
                y.setRight(z.getRight());
                y.getRight().setParent(y);
            }

            rbTransplant(z, y);
            y.setLeft(z.getLeft());
            y.getLeft().setParent(y);
            y.setColor(z.getColor());
        }
        if(yOriginalColor == 0){
            fixDelete(x);
        }
    }

    private void rbTransplant(RedBlackNode u, RedBlackNode v){
        if(u.getParent() == null){
            root = v;
        }
        else if(u == u.getParent().getLeft()){
            u.getParent().setLeft(v);
        }
        else{
            u.getParent().setRight(v);
        }
        v.setParent(u.getParent());
    }

    public RedBlackNode minimum(RedBlackNode node){
        while (node.getLeft() != TNULL){
            node = node.getLeft();
        }
        return node;
    }

    private void fixDelete(RedBlackNode x){
        RedBlackNode s;
        while(x != root && x.getColor() == 0){
            if(x == x.getParent().getLeft()){
                s = x.getParent().getRight();
                if(s.getColor() == 1){
                    s.setColor(0);
                    x.getParent().setColor(1);
                    leftRotate(x.getParent());
                    s = x.getParent().getRight();
                }

                if(s.getLeft().getColor() == 0 && s.getRight().getColor() == 0){
                    s.setColor(1);
                    x = x.getParent();
                }
                else {
                    if(s.getRight().getColor() == 0){
                        s.getLeft().setColor(0);
                        s.setColor(1);
                        rightRotate(s);
                        s = x.getParent().getRight();
                    }

                    s.setColor(x.getParent().getColor());
                    x.getParent().setColor(0);
                    s.getRight().setColor(0);
                    leftRotate(x.getParent());
                    x = root;
                }
            }
            else{
                s = x.getParent().getLeft();
                if(s.getColor() == 1){
                    s.setColor(0);
                    x.getParent().setColor(1);
                    rightRotate(x.getParent());
                    s = x.getParent().getLeft();
                }
                if(s.getRight().getColor() == 0 && s.getLeft().getColor() == 0){
                    s.setColor(1);
                    x = x.getParent();
                }
                else {
                    if(s.getLeft().getColor() == 0){
                        s.getRight().setColor(0);
                        s.setColor(1);
                        leftRotate(s);
                        s = x.getParent().getLeft();
                    }

                    s.setColor(x.getParent().getColor());
                    x.getParent().setColor(0);
                    s.getLeft().setColor(0);
                    rightRotate(x.getParent());
                    x = root;
                }
            }
        }
        x.setColor(0);
    }

}
