public class FirstNegative{

  public static int FirstNegative(int[] arr){
    for (int i = 0; i < arr.length; i++){
      if (arr[i] < 0) return arr[i];
    }

    return -1;
  }

  public static void main(String[] args){
    int[] arr = {29, 324, 525, 661, -33, 313};

    System.out.println(FirstNegative(arr));
  }
}