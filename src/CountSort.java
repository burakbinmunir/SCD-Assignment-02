import java.util.ArrayList;
import java.util.Scanner;

public class CountSort {
    private int[] array;
    private int size;
    private Scanner scan;
    CountSort(int size) {
        this.size = size;
        array = new int[size];
        scan = new Scanner(System.in);
    }

    public void inputArray(){
       if (size >0){
           System.out.println("Enter "+ size+" numbers");

           for (int index =0; index < size; index++){
               array[index] = scan.nextInt();
           }
       }
    }

    public void printArray(){
        System.out.println("Printing array");
        for (int number: array){
            System.out.println(number);
        }
    }

    public void countSort(){
        int[] output = new int[size + 1];

        int max = array[0];
        for (int i = 1; i < size; i++) {
            if (array[i] > max)
                max = array[i];
        }
        int[] count = new int[max + 1];


        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }


        for (int i = 0; i < size; i++) {
            count[array[i]]++;
        }


        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }


        for (int i = size - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }


        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }

    public static void main(String[] args){
        System.out.print("How many numbers you want to add: ");
        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();

        CountSort sort = new CountSort(size);
        sort.inputArray();
        sort.countSort();

        sort.printArray();
    }
}

