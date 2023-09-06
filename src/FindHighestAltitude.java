public class FindHighestAltitude {

    public void findHighestAltitude(int[] gain){
        int n = gain.length + 1;
        int[] altitudes = new int[n];
        int max = Integer.MIN_VALUE;
        altitudes[0] = 0;
        int currentValue = 0;
        for(int i=0; i<gain.length; i++){

            currentValue += gain[i];
            altitudes[i+1] = currentValue;
        }

        for (int altitude : altitudes) {
            if (max < altitude) {
                max = altitude;
            }
        }



        for(int i=0; i<altitudes.length; i++){
            System.out.print(altitudes[i] + " ");
        }
        System.out.println("Max is " + max);
    }




}
