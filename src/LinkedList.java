public class LinkedList {
    //Where all the data is stored
    private ListNode head;

    public LinkedList() {
        head = null;
    }

    //Add to the beginning of the list
    public void addFirst(int data) {
        head = new ListNode(data, head);
    }

    //Add to the end of the list
    public void addLast(int data) {
        if (head == null) {
            addFirst(data);
            return;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(data);
    }

    //Get the number of nodes, used in other methods here.
    public int countNodes() {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //Get data from a specific index.
    public int get(int index) {
        checkIndex(index);
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    //Finds what index a matching data is at
    public int getIndex(int data) {
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            if (cur.data == data) {
                return index;
            }
            cur = cur.next;
            index++;
        }
        return -1;
    }

    //Inserts data at any index instead of just front or back
    public void insertAt(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        checkIndex(index - 1);
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = new ListNode(data, cur.next);
    }

    //Deletes the object immediately after the head, requires special method.
    public void removeFirst() {
        if (head == null) {
            throw new IllegalStateException("Cannot delete the first object of the list as there is no list created!");
        }
        head = head.next;
    }

    //Remove data from any index
    public void remove(int index) {
        index -= 1;
        checkIndex(index);
        if (index == 0) {
            removeFirst();
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }

    //Removes duplicates if there are more than 1 of any number in the list.
    public void removeDuplicates() {
        ListNode cur = head;
        while (cur != null) {
            ListNode ip = cur;
            while (ip.next != null) {
                if (ip.next.data == cur.data) {
                    ip.next = ip.next.next;
                } else {
                    ip = ip.next;
                }
            }
            cur = cur.next;
        }
    }

    //Prints the entire linked list
    public void printList() {
        ListNode cur = head;
        System.out.print("\n[ head -> ");
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.print("null ]\n");
    }

    //Sorts the list by swapping the data fields instead of moving nodes.
    public void sort() {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            ListNode min = cur;
            ListNode ip = cur.next;

            while (ip != null) {
                if (ip.data < min.data) {
                    min = ip;
                }
                ip = ip.next;
            }
            int temp = cur.data;
            cur.data = min.data;
            min.data = temp;
            cur = cur.next;
        }

    }

    //Debug command to check if list object exists, closes program with error if it does not.
    //Basic error checking.
    private void checkIndex(int index) {
        if (index < 0 || index >= countNodes()) {
            System.out.println("FAILED INDEX CHECK! Result of operation would be program crash. See more details below.");
            throw new IndexOutOfBoundsException("Attempted to access Index: " + index + ", But the list is only Size: " + countNodes());
        }
    }
}
