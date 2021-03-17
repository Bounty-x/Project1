import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;

public class Test {

    public long startTime;

    public long startTimer() {
        startTime = System.nanoTime();
        return startTime;
    }
    public long endTimer(){
        long endTime = System.nanoTime();

        long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
        return duration;
    }

    public static void main(String[] args) throws IOException {

        FileWriter file = null;
        try {
            file = new FileWriter("results.txt");

        }catch(IOException e){
            System.out.println("An error occurred with the file");
        }


        Test t = new Test();
        SelectionSort select = new SelectionSort();
        BubbleSort bubble = new BubbleSort();
        InsertionSort insert = new InsertionSort();
        MergeSort merge = new MergeSort();
        QuickSort quick = new QuickSort();
        HybridSort hybrid = new HybridSort();

        Random r = new Random();
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(3);
        //System.out.println(df.format(r.nextDouble()));

        double[][] tests = new double[10][];

        for(int i = 1; i <= 10; i++) {//creating 10 randomized lists
            int size = 50000 * i;
            double [] temp = new double[size];
            //System.out.println(temp.length);
            for(int j = 0; j < temp.length; j++)
                temp[j] = Double.parseDouble(df.format(r.nextDouble())) + r.nextInt(1000 );
            tests[i-1] = temp;
            //System.out.println(Arrays.toString(tests[i-1]));
        }
        //System.out.println(Arrays.toString(tests[0]));



//        double[] test1 = new double[]{2.0,4.4,1.2,5.6,3.2,2.1,3.2,1.4,7.0,8.0,6.9};
//        double[] test2 = new double[]{1.2,2.2,4.4,1.4};
//        double[] test3 = new double[]{2.0,4.4,1.2,5.6,3.2,2.1,3.2,1.4,7.0,8.0,6.9};
//        double[] test4 = new double[]{2.0,4.4,1.2,5.6,3.2,2.1,3.2,1.4,7.0,8.0,6.9,8.1,1.4};
//        double[] test5 = new double[]{54,38,59,25,65,84,39,27};

        //UNCOMMENT FOR TESTING *BELOW*

        file.write("Selection Sort\n");
        for(int i = 0; i < 10; i++){
            double[] temp = new double[tests[i].length];//make a copy so every sort alg can use a fresh unsorted array
            for(int j = 0; j<tests[i].length; j++){
                temp[j] = tests[i][j];
            }
            file.write(temp.length + " Items\n");
            System.out.println("Selection Sort: " + temp.length + " Items");
            //System.out.println("Before Selection Sort: " + Arrays.toString(tests[i]));



            long startTime = System.currentTimeMillis();
            t.startTimer();
            select.sort(temp);
            long duration = t.endTimer();
            long endTime = System.currentTimeMillis() - startTime;

            System.out.println("That took " + (endTime) + " milliseconds");
            file.write(duration + "ms\n\n");
            System.out.println("Time: " + duration + "ms");

            //System.out.println("After Selection Sort: " + Arrays.toString(tests[i]));
            System.out.println("Is Sorted: " + select.checkIfSorted(temp));

            System.out.println("\n---------------------------------------\n");
        }

        file.write("Bubble Sort\n");
        for(int i = 0; i < 10; i++){
            double[] temp = new double[tests[i].length];//make a copy so every sort alg can use a fresh unsorted array
            for(int j = 0; j<tests[i].length; j++){
                temp[j] = tests[i][j];
            }

            //System.out.println(Arrays.toString(temp));

            file.write(temp.length + " Items\n");
            System.out.println("BubbleSort: " + temp.length + " Items");
            //System.out.println("Before Selection Sort: " + Arrays.toString(temp));

            t.startTimer();
            bubble.sort(temp);
            long duration = t.endTimer();

            file.write(duration + "ms\n\n");
            System.out.println("Time: " + duration + "ms");

            //System.out.println("After Selection Sort: " + Arrays.toString(temp));
            System.out.println("Is Sorted: " + bubble.checkIfSorted(temp));

            System.out.println("\n---------------------------------------\n");
        }

        file.write("Insertion Sort\n");
        for(int i = 0; i < 10; i++){
            double[] list = new double[tests[i].length];//make a copy so every sort alg can use a fresh unsorted array
            for(int j = 0; j<tests[i].length; j++){
                list[j] = tests[i][j];
            }
            //System.out.println(Arrays.toString(list));

            //file.write(list.length + " Items\n");
            System.out.println("Insertion Sort: " + list.length + " Items");
            //System.out.println("Before Insertion Sort: " + Arrays.toString(list));

            t.startTimer();
            insert.sort(list);
            long duration = t.endTimer();

            file.write(duration + "\n");
            System.out.println("Time: " + duration + "ms");

            //System.out.println("After Insertion Sort: " + Arrays.toString(list));
            System.out.println("Is Sorted: " + insert.checkIfSorted(list));
            //System.out.println(Arrays.toString(temp));

            System.out.println("\n---------------------------------------\n");

        }

        file.write("Merge Sort\n");
        for(int i = 0; i < 10; i++){
            double[] temp = new double[tests[i].length];//make a copy so every sort alg can use a fresh unsorted array
            for(int j = 0; j<tests[i].length; j++){
                temp[j] = tests[i][j];
            }

            file.write(temp.length + " Items\n");
            System.out.println("Merge Sort: " + temp.length + " Items");
            //System.out.println("Before Selection Sort: " + Arrays.toString(tests[i]));

            t.startTimer();
            merge.sort(temp);
            long duration = t.endTimer();
            file.write(duration + "ms\n\n");
            System.out.println("Time: " + duration + "ms");

            //System.out.println("After Selection Sort: " + Arrays.toString(tests[i]));
            System.out.println("Is Sorted: " + merge.checkIfSorted(temp));

            System.out.println("\n---------------------------------------\n");

        }
//
        file.write("Quick Sort\n");
        for(int i = 0; i < 10; i++){
            double[] temp = new double[tests[i].length];//make a copy so every sort alg can use a fresh unsorted array
            for(int j = 0; j<tests[i].length; j++){
                temp[j] = tests[i][j];
            }

            file.write(temp.length + " Items\n");
            System.out.println("Quick Sort: " + temp.length + " Items");
            //System.out.println("Before Quick Sort: " + Arrays.toString(temp));

            t.startTimer();
            quick.sort(temp);
            long duration = t.endTimer();
            file.write(duration + "ms\n\n");
            System.out.println("Time: " + duration + "ms");

//            System.out.println("After Quick Sort: " + Arrays.toString(temp));
            System.out.println("Is Sorted: " + quick.checkIfSorted(temp));

            System.out.println("\n---------------------------------------\n");

        }
        file.write("Hybrid Sort\n");
        for(int i = 0; i < 10; i++){
            double[] temp = new double[tests[i].length];//make a copy so every sort alg can use a fresh unsorted array
            for(int j = 0; j<tests[i].length; j++){
                temp[j] = tests[i][j];
            }

            double[] test = new double[] {6,2,9,12,7,8,3,5};

            file.write(temp.length + " Items\n");
            System.out.println("Hybrid Sort: " + temp.length + " Items");
            //System.out.println("Before Quick Sort: " + Arrays.toString(temp));

            long startTime = System.currentTimeMillis();
            hybrid.sort(temp);
            long endTime = System.currentTimeMillis() - startTime;

            System.out.println("That took " + (endTime) + " milliseconds");

//            t.startTimer();
//            hybrid.sort(temp);
//            long duration = t.endTimer();
            file.write(endTime + "ms\n\n");
//            System.out.println("Time: " + duration + "ms");

//            System.out.println("After Quick Sort: " + Arrays.toString(temp));
            System.out.println("Is Sorted: " + quick.checkIfSorted(temp));

            System.out.println("\n---------------------------------------\n");

        }
        file.close();

    }
}
