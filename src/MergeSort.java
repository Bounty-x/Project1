import java.util.Arrays;

public class MergeSort implements MyList {

    private double[] getLeft(double[] a){ //O(n)
        int size = a.length/2;
        double [] left = new double[size];
        for(int i = 0; i < size; i++){
            left[i] = a[i];
        }
        //System.out.println("Left: " + Arrays.toString(left));
        return left;
    }

    private double[] getRight(double[] a){ //O(n)
//        System.out.println(Arrays.toString(a));
//        System.out.println(a.length);
        int start = a.length/2;
        int size = a.length - start;
        int counter = 0;
        double [] right = new double[size];
        for(int i = start; i < a.length; i++){
            right[counter++] = a[i];
        }
        //System.out.println("Right: " + Arrays.toString(right));
        return right;
    }

    private void merge(double [] list, double [] left, double[] right){ //left has n/2 right has n/2
                                                                        // in total we are moving O(n) items
        int leftCount = 0;
        int rightCount = 0;
        int count = 0;
        while(leftCount < left.length && rightCount < right.length){
            if(left[leftCount] <= right[rightCount])
                list[count++] = left[leftCount++];
            else
                list[count++] = right[rightCount++];
        }
        //if either list runs out we fill the remaining one into list
        while(leftCount < left.length)
            list[count++] = left[leftCount++];
        while(rightCount < right.length)
            list[count++] = right[rightCount++];
    }

    public void sort(double[] list){
        if(list.length > 1){
            double [] left = getLeft(list);
            double [] right = getRight(list);
            //System.out.println("List: " + Arrays.toString(list));
            sort(left);
            sort(right);
            merge(list, left, right);
        }
    }



}
