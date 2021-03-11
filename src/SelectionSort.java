public class SelectionSort implements MyList {

    public void sort(double[] list){//total time is O(n^2)
        int count = 0; //starting place of unsorted portion of array
         //index of smallest item
        while(count < list.length) { //O(n) loops
            int smallest = count;
            for (int i = count+1; i <list.length;i++){ //O(n) operations
                if(list[smallest] > list[i])
                    smallest = i;
            }
            swap(list,smallest, count++);
        }
    }
}
