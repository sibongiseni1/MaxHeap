import java.util.ArrayList;
import java.util.List;
import java.util.*;
/**
 * Write a description of class MaxHeap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MaxHeap
{
   private List<Integer> heap;
   private int expo;
   
   public MaxHeap(int expo)
   {
       this.expo = expo;
       this.heap = new ArrayList<>();
} 

    public void insert(int value) {
        heap.add(value);
        shiftUp(heap.size() -1);
    }

    public int popMax() {
        if(heap.isEmpty())
        {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap.get(0);
        int lastVal = heap.remove(heap.size() -1);
        if(!heap.isEmpty()){
            heap.set(0, lastVal);
            shiftDown(0);
        }
        return max;
    }

    private void shiftUp(int index) {
        int parent = (index - 1) / expo;
        while (index > 0 && heap.get(index) > heap.get(parent)) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / expo;
        }
    }

    private void shiftDown(int index) {
        int maxIndex = index;
        for (int i = 1; i <= expo; i++) {
            int childIndex = expo * index + i;
            if (childIndex < heap.size() && heap.get(childIndex) > heap.get(maxIndex)) {
                maxIndex = childIndex;
            }
        }
        if (maxIndex != index) {
            swap(index, maxIndex);
            shiftDown(maxIndex);
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j,temp);
    }
    
    public static void main(String[] args)
    {
        MaxHeap heap = new MaxHeap(1);
        heap.insert(8);
        heap.insert(4);
        heap.insert(2);
        heap.insert(6);
        heap.insert(10);
        System.out.println(heap.popMax());
        System.out.println(heap.popMax());
    }
}
