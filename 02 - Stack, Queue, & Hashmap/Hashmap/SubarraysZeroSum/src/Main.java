public class Main {
    public static void main(String[] args) {
        SubarrayZeroSum ss = new SubarrayZeroSum();
        ss.addToList(1);
        ss.addToList(1);
        ss.addToList(1);

        System.out.println(ss.subarrayZeroSum(2));
    }
}