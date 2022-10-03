public class Pizza extends Item{
    String description  = "Pizza";
    String size="", flavor="",crust="";
    String[] toppings = {};
    Pizza(String size, String flavor, String crust,String[] toppings){
        this.size = size;
        this.flavor = flavor;
        this.crust = crust;
        this.toppings = toppings;
    }
    Pizza(){

    }
    @Override
    public int getPrice(){
        int basePrice;
        if(flavor.equals("Vegetarian"))
            basePrice = 20;
        else if(flavor.equals("Non-veg"))
            basePrice = 15;
        else
            basePrice = 15;
        if(size.equals("Medium"))
            basePrice*=2;
        else if(size.equals("Large"))
            basePrice*=4;
        return basePrice+toppings.length;
    }
}
