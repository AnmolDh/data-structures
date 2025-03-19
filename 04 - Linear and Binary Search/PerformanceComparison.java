import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1000000;
        String testString = "hello";

        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(testString);
        }
        long endTime = System.nanoTime();
        long timeTakenSB = endTime - startTime;
        System.out.println("Time taken by StringBuilder: " + timeTakenSB + " ns");

        startTime = System.nanoTime();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sBuffer.append(testString);
        }
        endTime = System.nanoTime();
        long timeTakenSBuffer = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + timeTakenSBuffer + " ns");

        String filePath = "largefile.txt";

        int wordCountFR = 0;
        startTime = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountFR++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        long timeTakenFR = endTime - startTime;
        System.out.println("FileReader: Word Count = " + wordCountFR);
        System.out.println("Time taken by FileReader: " + timeTakenFR + " ns");

        int wordCountISR = 0;
        startTime = System.nanoTime();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountISR++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        long timeTakenISR = endTime - startTime;
        System.out.println("InputStreamReader: Word Count = " + wordCountISR);
        System.out.println("Time taken by InputStreamReader: " + timeTakenISR + " ns");
    }
}