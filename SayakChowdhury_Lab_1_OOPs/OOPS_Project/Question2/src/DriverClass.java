import java.util.Scanner;

public class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Item[] items = initItems();
        int[] itemCount = {5,5,5,5,5};
        VendingMachine VM = new VendingMachine(items,itemCount);
        int n,q;
        while(true){
            showMenu(VM);
            while(true) {
                System.out.print("Enter the item number you wanna purchase: ");
                n = sc.nextInt();
                if(n>=1 && n<=6)
                    break;
                else
                    System.out.println("Invalid Number!");
            }
            if(n==6)
                return;
            while(true) {
                System.out.print("Enter the quantity you wanna purchase: ");
                q = sc.nextInt();
                if(q>=1 && q<=5)
                    break;
                else
                    System.out.println("Invalid quantity!");
            }
            purchaseItem(n-1,q,VM,sc);
            space();
        }
    }
    private static Item[] initItems(){
        Item[] items = new Item[5];
        items[0] = new Item("Cadbury",100);
        items[1] = new Item("Nestle",110);
        items[2] = new Item("Amul",80);
        items[3] = new Item("Parle",90);
        items[4] = new Item("Ferrero Rocher",300);
        return items;
    }
    private static void showMenu(VendingMachine VM){
        int i;
        Item[] items = VM.getItems();
        int[] itemCount = VM.getItemCount();
        System.out.println("The available menu of items, its price and number of that item available is as follows: ");
        for(i = 0;i<items.length; i++){
            System.out.print((i+1)+") "+items[i].getName()+", ");
            System.out.print("price: "+items[i].getPrice()+", ");
            System.out.println("available quantity: "+itemCount[i]);
        }
        System.out.println((i+1)+") Exit");
    }
    private static void purchaseItem(int index, int quantity, VendingMachine VM, Scanner sc){
        int[] itemCount = VM.getItemCount();

        int paymentMethod;
        long netPay;
        if(quantity> itemCount[index]){
            System.out.println("given quantity is not available");
            return;
        }
        while(true) {
            System.out.print("enter payment method (1 for Cash, 2 for card): ");
            paymentMethod = sc.nextInt();
            if(paymentMethod == 1 || paymentMethod == 2)
                break;
        }

        if(paymentMethod == 1)
            netPay = VM.getItems()[index].getPrice()*quantity;
        else
            netPay = VM.getItems()[index].getPrice()*2*quantity;
        VM.purchaseItem(index,quantity);
        System.out.println("Please pay "+netPay+" and take the item.\nThank you for purchasing");
    }
    private static void space(){
        for(int i=0;i<6;i++)
            System.out.println();
    }
}
