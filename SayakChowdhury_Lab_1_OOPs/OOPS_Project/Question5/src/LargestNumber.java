import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        int n;
        ArrayList customIntList = new ArrayList();
        System.out.print("enter size of array: " );
        Scanner sc = new Scanner(System.in);
        n = sc.nextByte();
        for(int i=0;i<n;i++){
            System.out.print("enter element "+(i+1)+": ");
            String temp = sc.next();
            customIntList.add(new CustomInt(temp));
        }
        Collections.sort(customIntList,new CustomIntComparator().reversed());
        String op = "";
        for(Object ci:customIntList){
            CustomInt temp= (CustomInt)ci;
            op += temp.getVal();
        }
        System.out.println("The largest number possible with the given elements is: "+op);
    }
}
