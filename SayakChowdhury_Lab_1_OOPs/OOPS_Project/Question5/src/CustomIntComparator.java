import java.util.*;
public class CustomIntComparator implements Comparator{
    public int compare(Object o1, Object o2){
        CustomInt I1 = (CustomInt) o1;
        CustomInt I2 = (CustomInt) o2;
        String IS1 = I1.getVal();
        String IS2 = I2.getVal();
        long comb1 = Long.parseLong(IS1+IS2);
        long comb2 = Long.parseLong(IS2+IS1);
        if(comb1 == comb2)
            return 0;
        else if(comb1 > comb2)
            return 1;
        else
            return -1;
    }
}
