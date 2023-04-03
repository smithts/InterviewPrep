package leetcode;

import java.util.*;

class RandomizedSet {

    private List<Integer> storage = new ArrayList<>();
    private Map<Integer,Integer> map = new HashMap<>();
    private Random rand = new Random();

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            storage.add(val);
            map.put(val, storage.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {

            int size = storage.size();
            int indexToRemove = map.get(val);
            int lastIndex = size - 1;
            if (indexToRemove == lastIndex) {
                storage.remove(indexToRemove);
                map.remove(val);
                return true;
            } else {
                int swappedValue = storage.get(lastIndex);
                storage.set(indexToRemove, swappedValue);
                storage.set(lastIndex, val);

                storage.remove(lastIndex);

                map.remove(val);
                map.put(swappedValue, indexToRemove);

                return true;
            }
        } else {
            return false;
        }
    }

    public int getRandom() {
        int random = rand.nextInt(storage.size());
        return storage.get(random);
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
