public class Main {
    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)
        };

        int startPoint = CircularTour.findStartingPoint(pumps);
        if (startPoint == -1) {
            System.out.println("No solution exists. Cannot complete the tour.");
        } else {
            System.out.println("Start at petrol pump: " + startPoint);
        }
    }
}