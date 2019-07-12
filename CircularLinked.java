package app;

/**
 * CircularLinked
 */
public class CircularLinked {

    Node head;
    Node tail;

    public class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
        }
    }

    //add node to the front, not hard. just change head to the new node and the next to the previous head
    public void pushFront(int data)
    {
        //empty list
        if(head == null)
        {
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
            return;
        }

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //add node to the back, tail will now be pointing to this new node, put the tail.next to this new node, new node.next will point to head
    public void pushBack(int data)
    {
        if(head == null)
        {
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
            return;
        }

        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
        tail.next = head;
    }

    public void printList()
    {
        if(head == null)
        {
            return;
        }

        Node current = head;
        while(current.next != head)
        {
            System.out.print(" " + current.data);
            current = current.next;
        }
        System.out.print(" " + current.data);
    }

    public static void main(String[] args) {
        CircularLinked cLink = new CircularLinked();
        cLink.pushFront(5);
        cLink.pushFront(0);
        cLink.pushFront(2);
        cLink.pushFront(3);
        cLink.pushBack(4);
        cLink.pushBack(7);
        cLink.pushBack(9);
        cLink.printList();
    }
}