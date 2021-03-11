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
        while(bot<top){
            if(top - bot < 10){
                insert.sort(list,bot,top);
                break;
            }
            else{
                int pivot = quicksort(list, bot, top);

                if(pivot - bot < top - pivot){
                    hybridSort(list,bot,pivot-1);
                    bot = pivot + 1;
                }
                else{
                    hybridSort(list,pivot+1, top);
                    top = pivot -1;
                }
            }
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
        return i+1;
    }
}
