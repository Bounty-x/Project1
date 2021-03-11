import java.util.Arrays;

public class QuickSort implements MyList{

    public void sort(double[] list){
        int bot = 0;
        int top = list.length-1;
        quicksort(list,bot,top);
    }

    public void quicksort(double[] list, int bot, int top){
        if(bot < top){
            //System.out.println("Got here");
            int p = partition(list,bot,top);
            quicksort(list, bot, p-1);
            quicksort(list,p+1,top);
            //System.out.println(Arrays.toString(list));
        }
    }


    /*last element will be pivot
      will place items less than pivot to the left
      all items greater than pivot to right
      pivot should be close to median
      i++ will come out to be the place for pivot so we swap for its place
    */
    public int partition(double[] list, int bot, int top){
        double pivot = list[top];
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

//    public int partition(double[] list, int left, int right){
////        int bottom = left+1;
////        int pivot = left;
////        int top = right;
////
////        while(bottom<top){
////            while(list[bottom] <= list[pivot] && bottom < right)
////                bottom++;
////            while(list[top] > list[pivot] && bottom > left)
////                top--;
////            if(bottom < top && bottom<=right && list[top] < list[bottom])
////                swap(list, bottom, top);
////        }
////        if(list[top] < list[pivot]) {
////            swap(list, top, pivot);
////            return top;
////        }
////        return left;
////    }


//    public int partition(double[] list, int left, int right){
//        if(left < right){
//            int bot = left;
//            int top = right;
//            int p = top/2 + bot/2;
//            System.out.println("\n#--------------------------------------------------------");
//            System.out.println("bot: " + bot + " [" + list[bot] + "] ");
//            System.out.println("top: " + top + " [" + list[top] + "] ");
//            System.out.println("pivot: " + p + " [" + list[p] + "] ");
//            System.out.println("Size: " + (top-bot));
//            for(int i = left; i <= right; i ++){
//                System.out.print(list[i]+ ", ");
//            }
//            System.out.println("\n" + Arrays.toString(list));
//            //************finding pivot
//            if (list[right] < list[p] && list[right] > list[left]) {//find median of three points
//                p = left;
//                swap(list, left, right);//move pivot out of way then move over bottom by one
//            } else if (list[left] < list[p] && list[left] > list[right]) {//if not this case, then keep p as pivot
//                // but make sure bottom is not on the pivot [pivot,bottom,...,top]
//                p = left;
//            }
//            else
//                swap(list, left, p);//move pivot out of way then move over bottom by one
//            p=left;
//            bot++;
//            //************found pivot
//            System.out.println("\nbot: " + bot + " [" + list[bot] + "] ");
//            System.out.println("top: " + top + " [" + list[top] + "] ");
//            System.out.println("pivot: " + p + " [" + list[p] + "] ");
//            System.out.println("Size: " + (top-bot));
//            for(int i = left; i <= right; i ++){
//                System.out.print(list[i]+ ", ");
//            }
//            System.out.println("\n--------------------------------------------------------#");
//            while(bot < top){
//                while(bot <= right && list[bot] <= list[p])
//                    ++bot;
//                while(top >= left && list[top] > list[p])
//                    --top;
//                if(bot <= right && bot < top)
//                    swap(list,bot,top);
//            }
//            swap(list, p, top);
//            return top;
//        }
//        return left;
//    }

//    public int partition(double[] list, int left, int right){
//        int bot = left;//counters for left bound and right bound
//        int top = right;
//        int p = top/2 + bot/2;//midpoint between bot and top
////        System.out.println("bot: " + bot);
////        System.out.println("top: " + top);
////        System.out.println("Size: " + (top-bot));
////        System.out.println(Arrays.toString(list));
//        if(left < right) {
//            //************finding pivot
//            if (list[top] < list[p] && list[top] > list[bot]) {//find median of three points
//                p = top;
//                swap(list, bot++, top);//move pivot out of way then move over bottom by one
//            } else if (list[bot] < list[p] && list[bot] > list[top])//if not this case, then keep p as pivot
//                // but make sure bottom is not on the pivot [pivot,bottom,...,top]
//                p = bot++;
//            else
//                swap(list, bot++, p);//move pivot out of way then move over bottom by one
//            //************found pivot
//
//            while (bot < top) {
//                while (list[bot] <= list[p] && bot < right)
//                    bot++;
//                while (list[top] > list[p] && top > left)
//                    top--;
//                if (list[bot] > list[top] && bot < top)
//                    swap(list, top, bot);
//            }
//            swap(list, top, p);
//            return top;
//        }
//        return left;
//    }

}
