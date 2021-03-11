public interface MyList {

    void sort(double[] list);//abstract method to be implemented by classes

    default boolean checkIfSorted(double[] array){//implement here (may want to override for larger arrays?
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    default void swap(double[] list, int i, int j){ //O(1) space and time
        double temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}