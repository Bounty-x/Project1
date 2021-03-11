public class BubbleSort implements MyList {

    public void sort(double[] list){//O(n^2) time       O(1) space
        boolean swapped = true;
        for(int i = 0; swapped && i < list.length; i++){ //worst case loops n times
            swapped = false;
            for(int j = 0; j < list.length-1; j++){//O(n-1)
                if(list[j+1] < list[j]) {
                    swap(list, j + 1, j);//O(1)
                    swapped = true;
                }
            }
        }
    }

}
