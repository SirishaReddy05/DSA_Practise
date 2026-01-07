    public static class PrefixSum{
        
     public static int calculateMaxAfterUpdates(int n, int[][] queries, int[] arr) {
            int[] ua = new int[n + 1];
             for (int[] q : queries) {
                 ua[q[0]] += q[2];
                 if (q[1] + 1 < n)
                     ua[q[1] + 1] -= q[2];
             }
            // find prefix sum for updated array
            int[] pre = new int[n];
            pre[0] = ua[0];
            for (int i = 1; i < n; i++)
                pre[i] = pre[i - 1] + ua[i];
            //finding max of all elements
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++)
                max = Math.max(max, pre[i] + arr[i]);
   
            return max;
        }
   
        public static void printStaticSumRangeQueries(int n, int[] arr, int[][] queries) {
            int[] pre = new int[n];
            pre[0] = arr[0];
            for (int i = 1; i < n; i++)
                pre[i] = pre[i - 1] + arr[i];
   
            for (int[] q : queries) {
                int x = q[0];
                int y = q[1];
                int sum;
                if (x == 0)
                    sum = pre[y];
                else
                    sum = pre[y] - pre[x - 1];
                System.out.println(sum);
            }
        }
    }
