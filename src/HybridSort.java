import java.util.Random;

public class HybridSort implements MyList {
    InsertionSort insert = new InsertionSort();
    Random r = new Random();


    public void sort(double[] list){
        int bot = 0;
        int top = list.length-1;
        hybridSort(list,bot,top);

    }


    public void hybridSort(double[] list, int bot, int top){ //help from https://www.techiedelight.com/hybrid-quicksort/
        int pivot;
        int startInsert = 1000; //insertion sort can do 1000 items instantly
        while(bot<top) {
            pivot = quicksort(list, bot, top);
            if(pivot - bot <= startInsert) {
                insert.quadraticsort(list, bot, pivot - 1);
            }
            else{
                hybridSort(list,bot,pivot-1);
            }
            if(top-pivot <= startInsert) {
                insert.quadraticsort(list, pivot + 1, top);
            }
            else{
                hybridSort(list,pivot+1,top);
            }
                return;

        }
    }

    public int quicksort(double[] list, int bot, int top){
        //System.out.println("Got here");
        return partition(list,bot,top);
    }

    /*last element will be pivot
      will place items less than pivot to the left
      all items greater than pivot to right
      pivot should be close to median
      i++ will come out to be the place for pivot so we swap for its place
      picks pivot randomly then moves it to rightmost place
    */
    private int partition(double[] list, int bot, int top){
        int random = r.nextInt(top+1-bot)+bot;
        //System.out.println(random);
        double pivot = list[random];
        swap(list,top,random);//bring pivot to the end of list
        int i = bot-1;

        for(int j = bot; j <= top - 1;j++){
            if(list[j] < pivot){
                i++;
                swap(list,j,i);
            }
        }
        swap(list, i+1, top);
        //System.out.println("PIVOT: " + i+1);
        return i+1;
    }
}
