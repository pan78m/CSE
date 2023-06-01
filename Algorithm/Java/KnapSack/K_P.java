package KnapSack;

public class K_P {
    public static void main(String[] args) {
      int  P[]={0,4,3,6,5};
      int w[]={0,3,2,5,4};
      int m=5;
      int n=4;
      int T[][]=new int[n+1][m+1];
      System.out.println("Store the element of table using Table method ");
       Table(n,m,T,w,P);
     
      ///Which object Selected
      Selected(n,m,T,w);
    }

    private static void Table(int n, int m, int[][] T, int[] w,int[] P) {
        int weight=0,object;
        for(object=0;object<=n;object++){
            for(weight=0;weight<=m;weight++){
                if(weight==0|| object==0)
                T[object][weight]=0;
                else if(w[object]<=weight)
                T[object][weight]=Math.max(T[object-1][weight],T[object-1][weight-w[object]]+P[object]);
                else
                T[object][weight]=T[object-1][weight];
    
                System.out.print(T[object][weight]+" ");
            }
            System.out.println();
          }
        
           System.out.print("\nMaximum Profit: "+T[object-1][weight-1]+" ");
    }

    private static void Selected(int n, int m, int[][] T, int[] w) {
        int i=n,j=m;
        System.out.println("\nHere 1 means Selected and 0 means Deselected ");
        while(i>0 && j>=0){
            if(T[i][j]==T[i-1][j]){
                System.out.println("Object:"+i+" =0");
                i--;
            }else{
                System.out.println("Object:"+i+" =1");
               
                j=j-w[i];
                i--;
                
            }
        }
    }
}
