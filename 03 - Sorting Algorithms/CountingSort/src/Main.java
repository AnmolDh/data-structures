import Sorting_Algorithms.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        StudentAge[] studentAge=new StudentAge[n];
        int max=0;
        for(int i=0;i<n;i++){
            System.out.println("Enter Student Information : ");
            String student= sc.next();
            //sc.nextLine();
            int age=sc.nextInt();
            max=Math.max(max,age);
            studentAge[i]=new StudentAge(student,age);
        }
        StudentAge[] ageArray=Algorithm.countSort(studentAge,max);

        for(StudentAge stu:ageArray){
            System.out.println(stu);
        }
    }
}