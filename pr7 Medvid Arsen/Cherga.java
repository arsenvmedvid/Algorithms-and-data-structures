public class Cherga {

    int[] data = new int[100];
    int head = 0;
    int tail = 0;

    void enqueue(int value) {
        data[tail] = value;
        tail = tail + 1;
    }

    int dequeue() {
        int value = data[head];
        head = head + 1;
        return value;
    }

    int count() {
        return tail - head;
    }

    public String toString() {
        String result = "[";
        for (int i = head; i < tail; i++) {
            result = result + data[i];
            if (i < tail - 1) {
                result = result + ", ";
            }
        }
        result = result + "]";
        return result;
    }

    public static void main(String[] args) {
        Cherga q = new Cherga();

        q.enqueue(6);
        q.enqueue(4);
        q.enqueue(6);
        q.enqueue(2);
        q.enqueue(7);
        System.out.println("Черга: " + q.toString());
        System.out.println("count(): " + q.count());

        System.out.println("dequeue(): " + q.dequeue());
        System.out.println("Черга після dequeue(): " + q.toString());
        System.out.println("count(): " + q.count());
    }
}
