package app;

/**
 * LinkedList
 */
public class LinkedList {
    
    Node head = null;

    public class Node 
    {
        Node next;
        int data;
    
        //constructor
        public Node(int data) 
        {
            this.data = data;
            this.next = null;
        }
    }
    
    
    public void append(int data)
    {
        if (head == null)
        {
            head = new Node(data);
            return;
        }

        Node current = head;

        //traverse to the end of the list to append
        while (current.next != null)
        {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data)
    {
        Node newHead = new Node(data);
        
        //assign the previous head to the tail of new node, assign head to the new head
        //essentially creating a new head
        newHead.next = head;
        head = newHead;
    }

    public int deleteWithValue(int data)
    {
        //if there isn't a head, there isn't anything to delete
        if (head == null) return 1;

        //if the data we want to delete is in the head, we need a special case
        if (head.data == data)
        {
            head = head.next;
            return 1;
        }

        //now we traverse the linked list until we find the data we want to remove
        //we need to create a head dummy to traverse the list, so we don't actually manipulate the head.
        Node current = head;
        while (current.next != null) //travel while next node exists
        {
            //we're gonna check if our next node has the data we are lookign for
            if (current.next.data == data)
            {
                //if so, we're going to completely skip over it and take it out the linked list
                current.next = current.next.next;
                return 1;
            }
            //if not we continue on to the next node of the list
            current = current.next;
        }
        return 0;
    }

    public void deleteAllWithValue(int data)
    {

        while (deleteWithValue(data) == 1)
        {
            System.out.println("deleted one " + data);
        }
    }

    public void printData()
    {
        if(head == null)
        {
            System.out.println("There is no list");
            return;
        }

        Node current = head;
        // do
        // {
        //     System.out.print(current.data);
        //     if(current.next != null)
        //     {
        //         current = current.next;
        //     }
        // } while (current.next != null);

        while(current.next != null)
        {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = list.new Node(5);

        list.append(6);
        list.append(7);
        list.append(7);
        list.prepend(4);
        list.prepend(4);
        list.printData();

        list.deleteAllWithValue(7);
        list.printData();
    }
}