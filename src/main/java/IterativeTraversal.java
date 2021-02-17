import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IterativeTraversal {
    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;

        Node child1 = new Node();
        child1.val = 4;
        Node child2 = new Node();
        child2.val = 7;
        Node child3 = new Node();
        child3.val = 9;

        List<Node> children1 = Arrays.asList(child1, child2, child3);
        root.children = children1;

        Node child11 = new Node();
        child11.val = 2;
        Node child12 = new Node();
        child12.val = 3;
        Node child13 = new Node();
        child13.val = 0;

        List<Node> children11 = Arrays.asList(child11, child12, child13);
        child1.children = children11;

        Node child21 = new Node();
        child21.val = 8;
        Node child22 = new Node();
        child22.val = 6;

        List<Node> children21 = Arrays.asList(child21, child22);
        child3.children = children21;

        Node child31 = new Node();
        child31.val = 11;
        Node child32 = new Node();
        child32.val = 10;
        Node child33 = new Node();
        child33.val = 12;

        List<Node> children31 = Arrays.asList(child31, child32, child33);
        child22.children = children31;

        new IterativeTraversal().traverse(root);
    }

    public void traverse(Node root) {
        List<Node> allT = new ArrayList<>();
        Stack<NodeInStack> s = new Stack<>();
        s.push(new NodeInStack(root, -1));
        allT.add(root);

        while (!s.isEmpty()) {
            NodeInStack ns = s.peek();
            Node current = ns.node;

            for (int i = ns.childIndex + 1; i < current.children.size(); i++) {
                Node child = current.children.get(i);
                if (child.children == null || child.children.size() == 0) {
                    allT.add(child);

                    ns.childIndex = i;
                } else {
                    allT.add(child);
                    s.push(new NodeInStack(child, -1));

                    ns.childIndex = i;
                    break;
                }
            }

            if (ns.childIndex == s.peek().node.children.size() - 1) {
                s.pop();
            }
        }

        for (Node n : allT) {
            System.out.println(n.val);
        }
    }
}

class NodeInStack {
    Node node;
    int childIndex;

    public NodeInStack(Node node, int childIndex) {
        this.node = node;
        this.childIndex = childIndex;
    }
}

class Node {
    int val;
    List<Node> children;
}
