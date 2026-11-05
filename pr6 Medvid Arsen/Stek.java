public class Stek {

    int[] data = new int[100];
    int top = -1;

    void push(int value) {
        top = top + 1;
        data[top] = value;
    }

    int pop() {
        int value = data[top];
        top = top - 1;
        return value;
    }

    int peek() {
        return data[top];
    }

    void clear() {
        top = -1;
    }

    int count() {
        return top + 1;
    }

    int size() {
        return top + 1;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i <= top; i++) {
            result = result + data[i];
            if (i < top) {
                result = result + ", ";
            }
        }
        result = result + "]";
        return result;
    }

    public static void main(String[] args) {
        Stek s = new Stek();

        s.push(11);
        s.push(22);
        s.push(33);
        System.out.println("Стек: " + s.toString());

        System.out.println("peek(): " + s.peek());
        System.out.println("size(): " + s.size());

        System.out.println("pop(): " + s.pop());
        System.out.println("Стек після pop(): " + s.toString());
        System.out.println("count(): " + s.count());

        s.clear();
        System.out.println("Стек після clear(): " + s.toString());
    }
}
