package Array;

import java.util.*;

class Solution{
    //Function to check if two arrays are equal or not.
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here
        boolean flag=false;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]==B[j]){
                    flag=true;
                }
            }
        }
        return flag;
    }
}
public class T_Arr_Same {
    public static void main(String[] args) {
        long A[]={1,0,2,3};
        long B[]={2,3,0,1};
        int N=4;
       if(Solution.check(A, B, N)){
        System.out.println("Equal");
       }else{
        System.out.println("Not Equal");
       }
    }

    
}
