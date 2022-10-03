public class Pasta extends Item{
    String description = "Pasta";
    String flavor="", type="";
    Pasta(String flavor, String type){
        this.flavor = flavor;
        this.type = type;
    }
    Pasta(){

    }
    @Override
    public int getPrice(){
        int basePrice;
        if(flavor.equals("White sauce"))
            basePrice = 10;
        else
            basePrice = 20;
        return basePrice;
    }
}
