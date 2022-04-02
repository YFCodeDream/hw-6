public class BinarySearchTree<T extends Comparable<T>> implements SimpleSSet<T> {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public int size() {
        return getNumNodesByRecursion(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public boolean add(T next) {
        Node addNode = new Node(next);

        if (root == null) {
            root = addNode;
            return true;
        }

        Node currentNode = root;
        Node parentNode = null;
        boolean isLeftInserted = true;

        while (currentNode != null) {
            parentNode = currentNode;
            if (next.compareTo(currentNode.value) < 0) {
                currentNode = currentNode.leftChild;
                isLeftInserted = true;
            } else if (next.compareTo(currentNode.value) > 0) {
                currentNode = currentNode.rightChild;
                isLeftInserted = false;
            } else {
                return false;
            }
        }

        if (isLeftInserted) {
            parentNode.leftChild = addNode;
        } else {
            parentNode.rightChild = addNode;
        }
        addNode.parent = parentNode;

        return true;
    }

    @Override
    public T remove(T x) {
        Node removedNode = findNode(x);
        if (removedNode == null) {
            return null;
        }

        Node removedParentNode = removedNode.parent;

        // 左子树为空
        if (removedNode.leftChild == null) {
            if (removedParentNode != null) {
                if (removedParentNode.leftChild == removedNode) {
                    removedParentNode.leftChild = removedNode.rightChild;
                } else if (removedParentNode.rightChild == removedNode) {
                    removedParentNode.rightChild = removedNode.rightChild;
                }
            } else {
                root = removedNode.rightChild;
            }
        } else if (removedNode.rightChild == null) {
            if (removedParentNode != null) {
                if (removedParentNode.leftChild == removedNode) {
                    removedParentNode.leftChild = removedNode.leftChild;
                } else if (removedParentNode.rightChild == removedNode) {
                    removedParentNode.rightChild = removedNode.leftChild;
                }
            } else {
                root = removedNode.leftChild;
            }
        } else {

        }
    }

    public int height() {
        return getHeightByRecursion(root);
    }

    @Override
    public T find(T x) {
        return findNode(x).value;
    }

    @Override
    public T findMin() {
        Node tempNode = root;
        while (tempNode.leftChild != null) {
            tempNode = tempNode.leftChild;
        }
        return tempNode.value;
    }

    @Override
    public T findMax() {
        Node tempNode = root;
        while (tempNode.rightChild != null) {
            tempNode = tempNode.rightChild;
        }
        return tempNode.value;
    }

    private Node findNode(T x) {
        Node tempNode = root;
        while (tempNode != null && tempNode.value != x) {
            if (x.compareTo(tempNode.value) < 0) {
                tempNode = tempNode.leftChild;
            } else {
                tempNode = tempNode.rightChild;
            }
        }
        return tempNode;
    }

    private int getNumNodesByRecursion(Node node) {
        int numNodes = 0;
        if (node != null) {
            numNodes += 1;
            if (node.leftChild != null) {
                numNodes += getNumNodesByRecursion(node.leftChild);
            }
            if (node.rightChild != null) {
                numNodes += getNumNodesByRecursion(node.rightChild);
            }
        }
        return numNodes;
    }

    private int getHeightByRecursion(Node node) {
        int height = 0;
        if (node != null) {
            height = Math.max(getHeightByRecursion(node.leftChild),
                    getHeightByRecursion(node.rightChild)) + 1;
        }
        return height;
    }

    private class Node {
        Node leftChild;
        Node rightChild;
        Node parent;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
