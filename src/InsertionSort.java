public class InsertionSort implements MyList {

    public void sort(double[] list){
        for(int i = 1; i<list.length; i++){
            double temp = list[i];//copy
            int j = i -1;
            while(j >= 0 && list[j] > temp){//move
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = temp; //copy back
        }
    }

    public void quadraticsort(double[] list,int bot, int top){
        for(int i = bot; i<=top; i++){
            double temp = list[i];//copy
            int j = i -1;
            while(j >= 0 && list[j] > temp){//move
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = temp; //copy back
        }
    }

}