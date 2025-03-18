public class CircularTour {
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0, deficit = 0, currentFuel = 0;

        for (int i = 0; i < n; i++) {
            currentFuel += pumps[i].getPetrol() - pumps[i].getDistance();
            if (currentFuel < 0) {
                start = i + 1;
                deficit += currentFuel;
                currentFuel = 0;
            }
        }

        return (currentFuel + deficit >= 0) ? start : -1;
    }
}
