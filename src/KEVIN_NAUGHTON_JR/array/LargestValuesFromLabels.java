package KEVIN_NAUGHTON_JR.array;

import java.util.*;

/*

 */
public class LargestValuesFromLabels {

    public static void main(String[] args) {
        int []values = new int[] {5,4,3,2,1};
        int [] labels = new int[] {1,1,2,2,3};

        int res = largestValsFromLabels(values, labels, 3,1);
        System.out.println(" res " + res);

    }

    static int largestValsFromLabels(int[] values, int[] labels, int nums_wanted, int use_limit) {

        List<Item> items = new ArrayList<>();
        for(int i = 0; i <labels.length; i++){
            items.add(new Item(values[i], labels[i]));//populate list
        }
        //max heap to store highest val to label references
        PriorityQueue<Item> max_use_heap = new PriorityQueue<>((Item a, Item b)-> b.value - a.value);
        max_use_heap.addAll(items);//populate max heap

        Map<Integer, Integer> label_counts = new HashMap<>();//map to store usage of vals by allowed limit of labels

        int result = 0;

        while (!max_use_heap.isEmpty() && nums_wanted>0){//while smth in heap and nums exist
            Item current = max_use_heap.remove();//take from heap
            label_counts.put(current.label, label_counts.getOrDefault(current.label,0)+1);//store in MAP according to labels met

            if(label_counts.get(current.label)<= use_limit){//while less label occured than use limit allows
                result += current.value;//store in res
                nums_wanted--;//decrease nums wanted
            }
        }
        return result;
    }


    //just OOP class to store value and label together
    static class Item {
        int value;
        int label;

        public Item(int value, int label) {
            this.value = value;
            this.label = label;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Item{");
            sb.append("value=").append(value);
            sb.append(", label=").append(label);
            sb.append('}');
            return sb.toString();
        }
    }
}
