package hash_table;

import java.util.*;

public class FirstRecurringChar {

    public Integer getRecurringCh(int[] arr){
        Set<Integer> hashSet = new HashSet<>();
        for(int i : arr){
            if(hashSet.contains(i)){
                return i;
            }else {
                hashSet.add(i);
            }
        }
        return null;
    }

    public Integer getRecurringChFromArray(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            if(list.contains(i)){
                return i;
            }else {
                list.add(i);
            }
        }
        return null;
    }




    public static void main(String[] args) {
        FirstRecurringChar rc = new FirstRecurringChar();

        int[] arr = {2,3,4,5,2,1,1,3};

        int ch = rc.getRecurringChFromArray(arr);
        System.out.println("recurring character " + ch);
    }


}
