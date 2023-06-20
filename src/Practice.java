import java.util.*;

public class Practice {

    public static void main(String[] args) {
        int index = 0;
        int key = 1;
        int value = 1;
        Integer obj = 1;

        List<Integer> arrayList = new ArrayList<>();
        //ArrayList<E>
        //  extends AbstractList<E>
        //  implements List<E>, RandomAccess, Cloneable, java.io.Serializable


            arrayList.add(value);
            arrayList.add(value);
            arrayList.remove(index);
            arrayList.size();
            arrayList.get(index);
            arrayList.isEmpty();
            arrayList.set(index, value);


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Set<Integer> hashSet = new HashSet<>();

            hashSet.add(value);
            hashSet.remove(value);
            hashSet.size();
            hashSet.contains(value);
            hashSet.isEmpty();

        Set<Integer> treeSet = new TreeSet<>();

            // all same as above, but maintains inserted order

        Map<Integer, Integer> hashMap = new HashMap<>();

            hashMap.get(key);
            hashMap.containsKey(key);
            hashMap.put(key, value);
            hashMap.remove(key, value);
            hashMap.remove(key);
            hashMap.keySet();
            hashMap.size();

            for (Map.Entry entry : hashMap.entrySet()) {
                entry.getKey();
                entry.getValue();
                entry.setValue(value);
                entry.hashCode();
            }

        Hashtable<Integer, Integer> hashTable = new Hashtable<>();

            hashTable.contains(value);
            hashTable.get(key);
            hashTable.put(key, value);
            hashTable.size();
            hashTable.remove(key);
            hashTable.remove(key, value);
            hashTable.entrySet();

            for (Map.Entry entry : hashTable.entrySet()) {
                entry.getKey();
                entry.getValue();
                entry.setValue(value);
                entry.hashCode();
            }


        int[] array = new int[10];
        String string = "";

        int arrayLength = array.length;
        int stringLength = string.length();




//        String s = "cbadef";
//        System.out.println(s);
//
//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        System.out.println(new String(chars));

        assert(Character.valueOf('a') == 'a'); // a
        assert(Character.getNumericValue('3') == 12); //3
        assert(Character.isDigit('2') == true); //true
        assert(Character.isDigit('a') == false); //false
        assert(Character.isLetterOrDigit('1') == true); //true
        assert(Character.isLetter('1') == true); //false
    }
}
