import java.util.Scanner;

public class IsPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter string: ");
        String inp = sc.next();
        if(isPalindrome(inp,0,inp.length()-1)){
            System.out.println(inp+" is a palindrome");
        }
        else{
            System.out.println(inp+" is not a palindrome");
        }

    }
    private static boolean isPalindrome(String inp,int i, int j){
        if(i>=j)
            return true;
        if(inp.charAt(i) == inp.charAt(j))
            return isPalindrome(inp,++i,--j);
        else
            return false;
    }
}
