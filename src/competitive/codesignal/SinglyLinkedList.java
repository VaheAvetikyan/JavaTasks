package competitive.codesignal;

public class SinglyLinkedList {
    public static void main(String[] args) {
        ListNode<Integer> integerList = new ListNode<>(null);
        Integer[] input = {3, 1, 2, 3, 4, 5};
        integerList.addAll(input);
        integerList.print();
        integerList.removeAllOccupancies(3);
        integerList.print();

        ListNode<Integer> integerList2 = new ListNode<>(null);
        Integer[] input2 = {1, 2, 3, 4, 5, 6, 7, 6, 6, 6};
        integerList2.addAll(input2);
        integerList2.print();
        integerList2.removeAllOccupancies(6);
        integerList2.print();
    }
}

class ListNode<T> {
    ListNode(T x) {
        value = x;
    }

    private T value;
    private ListNode<T> next;

    void print() {
        ListNode<T> temp = this;
        while (temp != null) {
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    private void setHead(ListNode<T> newHead) {
        this.value = newHead.value;
        this.next = newHead.next;
    }

    public void addAll(T[] arr) {
        ListNode<T> newHead = new ListNode<>(null);
        newHead.next = this;
        ListNode<T> listNode = newHead;
        for (T el : arr) {
            listNode.setNext(new ListNode<>(el));
            listNode = listNode.next;
        }
        setHead(newHead.next);
    }

    void removeAllOccupancies(T elementToRemove) {
        ListNode<T> newHead = new ListNode<>(null);
        newHead.next = this;
        ListNode<T> current = this;
        ListNode<T> previous = newHead;
        while (current != null) {
            if (current.value == elementToRemove) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
        setHead(newHead.next);
    }
}
