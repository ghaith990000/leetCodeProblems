public class BubbleSort {
    private long[] a;
    private int nElms;

    public BubbleSort(int max)
    {
        a = new long[max];
        nElms = 0;
    }

    public void insert(long value)
    {
        a[nElms] = value;
        nElms++;
    }

    public void display()
    {
        for(int j = 0; j< nElms; j++)
            System.out.print(a[j] + " ");
        System.out.println("\n");

    }

    public void bubbleSort(){
        int out, in;

        for(out= nElms; out>1; out--)
            for(in=0; in<out; in++)
                if(a[in] > a[in+1])
                    swap(in, in+1);
    }

    private void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
