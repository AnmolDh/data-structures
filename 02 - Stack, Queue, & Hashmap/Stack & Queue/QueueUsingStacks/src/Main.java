public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.push(1);
        q.push(2);
        q.push(3);

        q.pop();
        System.out.println(q.peek());
    }
}