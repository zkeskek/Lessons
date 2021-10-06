import java.util.HashMap;
import java.util.Map;

public class ArrayFrequency {

    // https://app.patika.dev/moduller/java101/odev-array-count
    public static void main(String[] args) {
        int[] array = {20,30,40,30,55,20,60,5,10,10,30,55,60,5};

        Map<Integer,Integer> myMap = new HashMap<Integer,Integer>();

        for (int i = 0; i < array.length; i++) {
            if(myMap.containsKey(array[i])){
                myMap.replace(array[i], myMap.get(array[i]) +1);
            }else{
                myMap.put(array[i], 1);
            }
        }

        for(Map.Entry<Integer,Integer> m: myMap.entrySet()){
            System.out.println(m.getKey()+" sayısı "+ m.getValue()+" kere tekrar edildi");
        }
    }
}
