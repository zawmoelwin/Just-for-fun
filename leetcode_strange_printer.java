class Solution {
    public
        int strangePrinter(String s) {
            int[][] arrayRecord = new int[8][8];
            int N = s.length();
            if(N <= 1) return N;
            for (int i = 0; i < N; i++) {arrayRecord[i][i] = 1; printArray(arrayRecord[i]);}
            for(int i = N-2; i >= 0; i--){
              System.out.println("printing i..  "+i);
                for(int j = i+1; j < N; j++){
                  System.out.println(s);
                  System.out.println("printing j..  "+j);
                  
                    arrayRecord[i][j] = arrayRecord[i+1][j] + 1;
                    
                    char c = s.charAt(i);
                    System.out.println("comparing..  "+c);
                    for(int k = i; k < j; k++){
                      //System.out.println("printing k+1..  "+k+1);
                      System.out.println("with "+s.charAt(k+1));
                        if(s.charAt(k+1) == c) {arrayRecord[i][j] = Math.min(arrayRecord[i][j], arrayRecord[i][k] + arrayRecord[k+1][j]-1);
                        System.out.println("compare data i to j..  "+arrayRecord[i][j]);
                        System.out.println("compare data i to k plus k to j..  "+( arrayRecord[i][k] + arrayRecord[k+1][j]-1));
                          
                        }
                        //printArray(arrayRecord[i]);
                    }
                    for (int z = 0; z < N; z++) {printArray(arrayRecord[z]);}
                }
            }
            
            //for (int i = 0; i < N; i++) printArray(arrayRecord[i]);
            return arrayRecord[0][N-1];
        }
      private void printArray(int[] anArray) {
          for (int i = 0; i < anArray.length; i++) {
             if (i > 0) {
                System.out.print(", ");
             }
             System.out.print(anArray[i]);
             
          }
          System.out.print("\n");
      }
    };
    
    class Main {
      public static void main(String[] args) {
        Solution sol = new Solution();
        int test = sol.strangePrinter("abbccbca");
        System.out.println(test);
      }
    }
