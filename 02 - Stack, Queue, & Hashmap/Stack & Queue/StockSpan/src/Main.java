public class Main {
    public static void main(String[] args) {
        StockSpan stockSpan = new StockSpan();
        stockSpan.add(2);
        stockSpan.add(4);
        stockSpan.add(3);
        stockSpan.add(1);
        stockSpan.add(5);

        for (int i : stockSpan.getSpan()){
            System.out.println(i);
        }
    }
}