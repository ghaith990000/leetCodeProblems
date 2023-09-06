public class SelectionSort {
    private long[] a;
    private int nElms;

    public SelectionSort(int max){
        a = new long[max];
        nElms = 0;
    }

    public void insert(long value)
    {
        a[nElms] = value;
        nElms++;
    }


    public void selectionSort(){
        int out, in, min;

        for(out=0; out<nElms-1; out++)
        {
            min=out;
            for(in=out+1; in<nElms; in++)
                if(a[in] < a[min])
                    min = in;
            swap(out, min);
        }
    }
    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
