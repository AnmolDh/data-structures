public class BuilderBufferComparison {
    public static void main(String[] args) {
        int iterations = 1000000;
        long startTime, endTime, timeTakenSB, timeTakenSBD;

        startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }
        endTime = System.nanoTime();
        timeTakenSB = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + timeTakenSB + " ns");

        startTime = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbd.append("hello");
        }
        endTime = System.nanoTime();
        timeTakenSBD = endTime - startTime;
        System.out.println("Time taken by StringBuilder: " + timeTakenSBD + " ns");
    }
}
