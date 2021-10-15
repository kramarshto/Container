/**
 * This class allows you to work with data by structuring it into a unidirectional list
 *
 * @param <T> type of val stored in the list
 */
public class Container<T> {

    /**
     * Inner class describing list element
     */
    class ListElement {
        private ListElement next;
        private T data;

        {
            next = null;
        }

        /**
         * constructor with data
         *
         * @param data data added to head type T
         */
        public ListElement(T data) {
            this.data = data;
        }
    }

    private ListElement head;
    private ListElement tail;
    private int size;

    /**
     * default constructor
     */
    public Container() {
        head = null;
        tail = head;
        size = 0;
    }

    /**
     * constructor with data
     *
     * @param elem element added to head type T
     */
    public Container(T elem) {
        head = new ListElement(elem);
        tail = head;
        size = 1;
    }

    /**
     * constructor with array
     *
     * @param arr array converted to container type T
     */
    public Container(T[] arr) {
        for (T t : arr) {
            add(t);
        }
    }

    /**
     * check for emptiness
     *
     * @return 1 if empty
     * 0 if not empty
     */
    boolean isEmpty() {
        return head == null;
    }

    /**
     * add element to end
     *
     * @param elem element type T
     */
    void add(T elem) {
        ListElement p = new ListElement(elem);
        if (tail == null) {
            head = p;
            tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
        size++;
    }

    /**
     * add element to head
     *
     * @param elem element type T
     */
    void addToHead(T elem) {
        ListElement p = new ListElement(elem);
        if (isEmpty()) {
            head = p;
            tail = p;
        } else {
            p.next = head;
            head = p;
        }
        size++;
    }

    /**
     * add element after node
     *
     * @param pNode node of element
     * @param elem  element type T
     */
    void addAfterNode(ListElement pNode, T elem) {
        ListElement p = new ListElement(elem);
        p.next = pNode.next;
        pNode.next = p;
        size++;
    }

    /**
     * find place before element
     *
     * @param temp element type T
     * @return ListElement
     * node of element
     */
    ListElement findPlaceBefore(T temp) {
        ListElement p = head;
        while ((p.next != null) && (p.next.data != temp))
            p = p.next;
        return p;
    }

    /**
     * find place of element
     *
     * @param temp element type T
     * @return ListElement
     * node of element
     */
    ListElement findPlace(T temp) {
        ListElement p = head;
        while ((p.next != null) && (p.data != temp))
            p = p.next;
        return p;
    }

    /**
     * get element by index
     *
     * @param i index of element type int
     * @return elem type T
     */
    T get(int i) { //возвращает i-тый элемент
        if (i <= size && i >= 1) {
            if (i == 1)
                return head.data;
            else {
                ListElement p = head.next;
                int k = 2;
                while (k != i) {
                    p = p.next;
                    k++;
                }
                return p.data;
            }
        } else
            throw new NullPointerException("Вы вышли за пределы контейнера");
    }

    /**
     * delete element
     *
     * @param elem deleted element type T
     */
    void delete(T elem) {
        if (head.data == elem)
            deleteFromHead();
        else
            deleteAfterNode(findPlaceBefore(elem));
    }

    /**
     * delete element from head
     *
     * @return deleted elem type T
     */
    T deleteFromHead() {
        ListElement p = head;
        head = head.next;
        T elem = p.data;
        p = null;
        size--;
        return elem;
    }

    /**
     * delete element after node
     *
     * @return deleted elem type T
     */
    T deleteAfterNode(ListElement pNode) {
        ListElement p = pNode.next;
        T elem = p.data;
        pNode.next = p.next;
        p = null;
        size--;
        return elem;
    }

    /**
     * Check containers on equality
     *
     * @param container object of container
     * @return 0 if not equal
     * 1 if equal
     */
    public boolean equals(Container<T> container) {
        if (isEmpty() && container.isEmpty())
            return true;
        else {
            ListElement node = head;
            ListElement node2 = container.head;
            while (node != null && node2 != null) {
                if (!node.data.equals(node2.data))
                    return false;
                node = node.next;
                node2 = node2.next;
            }
            if (node == null && node2 == null)
                return true;
            return false;
        }
    }

    /**
     * Check containers on equality
     *
     * @return string
     */
    @Override
    public String toString() {
        String s = "";
        ListElement p = head;
        while (p != null) {
            if (p.next != null) {
                s += p.data + " -> ";
                p = p.next;
            } else {
                s += p.data;
                p = p.next;
            }
        }
        return s;
    }
}