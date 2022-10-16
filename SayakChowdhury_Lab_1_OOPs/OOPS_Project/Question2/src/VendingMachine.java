public class VendingMachine {
    private Item[] items;
    private int[] itemCount;

    public VendingMachine(Item[] items, int[] itemCount) {
        this.items = items;
        this.itemCount = itemCount;
    }

    public Item[] getItems() {
        return items;
    }
    public int[] getItemCount(){
        return itemCount;
    }
    public void purchaseItem(int index, int count){

        if(itemCount[index]<count){
            System.out.println("Quantity not available");
        }
        else{
            System.out.println("Item successfully purchased");
        }
        itemCount[index] -= count;

    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public void setItemCount(int[] itemCount) {
        this.itemCount = itemCount;
    }
}
