import org.junit.jupiter.api.Assertions;

class ContainerTest {
    @org.junit.jupiter.api.Test
    void isEmpty() throws Exception {
        Container<Integer> actual = new Container<>();
        Assertions.assertTrue(actual.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void add() throws Exception {
        Container<Integer> expected = new Container<>(new Integer[]{1, 2});
        Container<Integer> actual = new Container<>();
        actual.add(1);
        actual.add(2);
        Assertions.assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void addToHead() throws Exception {
        Container<Integer> expected = new Container<>(new Integer[]{1, 2});
        Container<Integer> actual = new Container<>(2);
        actual.addToHead(1);
        Assertions.assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void addAfterNode() throws Exception {
        Container<Integer> expected = new Container<>(new Integer[]{1, 3, 2});
        Container<Integer> actual = new Container<>(1);
        actual.add(2);
        actual.addAfterNode(actual.findPlace(1), 3);
        Assertions.assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void get() throws Exception {
        Container<Integer> expected = new Container<>(new Integer[]{1, 3, 2});
        Assertions.assertTrue(2 == expected.get(3));
    }

    @org.junit.jupiter.api.Test
    void delete() throws Exception {
        Container<Integer> expected = new Container<>(new Integer[]{1, 2});
        Container<Integer> actual = new Container<>(new Integer[]{1, 3, 2, 4});
        actual.delete(3);
        actual.delete(4);
        Assertions.assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void deleteFromHead() throws Exception {
        Container<Integer> expected = new Container<>(new Integer[]{1, 2});
        Container<Integer> actual = new Container<>(new Integer[]{3, 4, 1, 2});
        actual.deleteFromHead();
        actual.deleteFromHead();
        Assertions.assertTrue(expected.equals(actual));
    }

    @org.junit.jupiter.api.Test
    void deleteAfterNode() throws Exception {
        Container<Integer> expected = new Container<>(new Integer[]{1, 2});
        Container<Integer> actual = new Container<>(new Integer[]{1, 3, 2, 4});
        actual.deleteAfterNode(actual.findPlaceBefore(3));
        actual.deleteAfterNode(actual.findPlaceBefore(4));
        Assertions.assertTrue(expected.equals(actual));
    }
}