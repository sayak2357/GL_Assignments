import java.sql.SQLOutput;
import java.util.Scanner;

public class OrderBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            showMenu();
            System.out.print("Order Menu\n1. Buy Pizza\n2. Buy Pasta\n3. Exit\nenter choice: ");
            int choice = sc.nextInt();
            if(choice == 1) {
                Pizza p = makePizza(sc);
                System.out.println("Please pay " + p.getPrice() + " to get the pizza");
                System.out.print("Do you want to continue (Y/N): ");
                String ch = sc.next();
                if(ch.equals("N"))
                    return;
            }
            if(choice == 2){
                Pasta p = makePasta(sc);
                System.out.println("Please pay " + p.getPrice() + " to get the pasta");
                System.out.print("Do you want to continue (Y/N): ");
                String ch = sc.next();
                if(ch.equals("N"))
                    return;
            }
            if(choice == 3)
                return;

        }
    }
    private static void showMenu(){
        System.out.println("Sizes of pizza: SMALL, MEDIUM, LARGE");
        System.out.println("Two types of crust(no extra chanrge): THIN, THICK");
        System.out.println("1. Vegetarian (20 USD SMALL, 40 USD MEDIUM, 60 USD LARGE).\n" +
                "2. Non-veg (25 USD SMALL, 50 USD MEDIUM, 75 USD LARGE)\n" +
                "3. Vegan (15 USD SMALL, 30 USD MEDIUM, 45 USD LARGE)");
        System.out.println("Toppings available: \n1. Cheese (1.00 USD)\n" +
                "2. Mushroom (1.00 USD)\n" +
                "3. Tomato (1.00 USD)\n" +
                "4. Jalapeno (1.00 USD)\n" +
                "5. Spinach (1.00 USD)");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Pasta available with 2 types of sauces: White sauce & Red sauce");
        System.out.println("1. White sauce (10 USD)\n" +
                "2. Red sauce (20 USD)");
        System.out.println("Pasta comes in 2 types (Any type can be chosen with no change in cost.)\n" +
                "1. Penne\n" +
                "2. Ditalini");
    }
    private static Pizza makePizza(Scanner sc){

        //return new Pizza();
        String size = null,crust=null,flavor=null;
        String[] sizeOpts = {"Large","Medium","Small"};
        String[] crustOpts = {"Thin","Thick"};
        String[] flavorOpts = {"Vegetarian","Non-veg","Vegan"};
        String[] topingsOpts = {"Cheese","Mushroom","Tomato","Jalapeno","Spinach"};
        String[] toppings = new String[5];
        int topingsSize = 0;
        boolean status = true;
        while(status){
            System.out.print("Select size:\n1. Large\n2. Medium\n3. Small\ngive choice (1/2/3): ");
            int choice = sc.nextInt();
            if(choice == 1 || choice == 2 || choice == 3) {
                status = false;
                size = sizeOpts[choice-1];
            }
        }
        status = true;
        while(status){
            System.out.print("Select crust:\n1. Thin\n2. Thick\ngive choice (1/2): ");
            int choice = sc.nextInt();
            if(choice == 1 || choice == 2) {
                status = false;
                crust = crustOpts[choice-1];
            }
        }
        status = true;
        while(status){
            System.out.print("Select flavor:\n1. Vegetarian\n2. Non-veg\n3. Vegan\ngive choice (1/2/3): ");
            int choice = sc.nextInt();
            if(choice == 1 || choice == 2 || choice == 3) {
                status = false;
                flavor = flavorOpts[choice-1];
            }
        }

        boolean[] arr = {false,false,false,false,false};
        System.out.println("Select toppings:\n1. Cheese(USD 1.0)\n2. Mushroom(USD 1.0)\n3. Tomato(USD 1.0)\n4. Jalapeno(USD 1.0)\n5. Spinach(USD 1.0) ");
        //String choices = sc.next();

            //String[] tokens = choices.split(" ");
            for (int i = 0; i < 5; i++) {
                System.out.print("Want "+topingsOpts[i]+" topping ? (0 - no 1 - yes)\n enter choice: ");
                int choice = sc.nextInt();
                if (choice == 1) {
                    arr[i] = true;
                }
            }
        for(int i=0;i<5;i++){
            if(arr[i])
                toppings[topingsSize++] = topingsOpts[i];
        }
        return new Pizza(size,flavor,crust,toppings);

    }
    private static Pasta makePasta(Scanner sc){
        String flavor = null,type = null;
        String[] flavorOpts = {"White sauce","Red sauce"};
        String[] typeOpts = {"Penne","Ditalini"};
        boolean status = true;
        while(status){
            System.out.println("Select flavor:\n1. White sauce\n2. Red sauce\nenter choice: ");
            int choice = sc.nextInt();
            if(choice == 1 || choice == 2) {
                status = false;
                flavor = flavorOpts[choice-1];
            }
        }
        status = true;
        while(status){
            System.out.println("Select type:\n1. Penne\n2. Ditalini\nenter choice: ");
            int choice = sc.nextInt();
            if(choice == 1 || choice == 2) {
                status = false;
                type = typeOpts[choice-1];
            }
        }
        return new Pasta(flavor,type);
    }
}
