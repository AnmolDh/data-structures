public class Main {
    public static void main(String[] args) {
        Window window = new Window();
        window.add(2);
        window.add(1);
        window.add(4);
        window.add(2);
        window.add(3);
        window.add(5);
        window.add(6);

        for (int i : window.getWindowMaximum(3)){
            System.out.println(i);
        }
    }
}