package Day1;

import java.util.Arrays;

public class solution {
    static void main(String[] args) {


    int[] arr={9};
    System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        int n=digits.length;
        for (int i = n-1; i >=0 ; i--) {
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            else{
                digits[i]=0;
            }

        }
        int [] nd=new int[n+1];
        nd[0]=1;
        return nd;
    }
}
