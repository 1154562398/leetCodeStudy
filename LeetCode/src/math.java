import java.util.ArrayList;
import java.util.List;

public class math {
    /****************【题目】**************
     *
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     *
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     *
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     *
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     *
     * 示例：
     *
     * n = 15,
     *
     * 返回:
     * [
     *     "1",
     *     "2",
     *     "Fizz",
     *     "4",
     *     "Buzz",
     *     "Fizz",
     *     "7",
     *     "8",
     *     "Fizz",
     *     "Buzz",
     *     "11",
     *     "Fizz",
     *     "13",
     *     "14",
     *     "FizzBuzz"
     * ]
     */

    public List<String> fizzBuzz(int n) {
        List<String> ans=new ArrayList<String>();
        while(n>0)
        {
            ans.add(0,n%3==0?n%5==0?"FizzBuzz":"Fizz":n%5==0?"Buzz":Integer.toString(n--));
        }

        return ans;

        /****************【 fastest method 】**************
         *
         *   List<String> list = new ArrayList<>();
         *         for (int i = 1; i <= n; i++) {
         *             if (i % 15 == 0) {
         *                 list.add("FizzBuzz");
         *                 continue;
         *             }
         *             if (i % 3 == 0) {
         *                 list.add("Fizz");
         *                 continue;
         *             }
         *             if (i % 5 == 0) {
         *                 list.add("Buzz");
         *                 continue;
         *             }
         *             list.add(String.valueOf(i));
         *         }
         *         return list;
         */


    }

    /****************【题目】**************
     *
     * 统计所有小于非负整数 n 的质数的数量。
     *
     * 示例:
     *
     * 输入: 10
     * 输出: 4
     * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     */

    public int countPrimes(int n) {
        int [] arr=new int [n];
        int count=2;
        for(int i=0;i<n;i++)
        {
            arr[i]=1;
        }
        for(int i=2;i<n;i++)
        {
            if (arr[i] == 1) {
                for (int j = 1; i * j < n; j++) {
                    arr[i * j] = 0;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i] == 1)
            {
                res++;
            }
        }
        return res;


        /****************【 method 1 】**************
         *
         *   if (n < 3)
         *             return 0;
         *
         *         boolean[] f = new boolean[n];
         *         //Arrays.fill(f, true); boolean[] are initialed as false by default
         *         int count = n / 2;
         *         for (int i = 3; i * i < n; i += 2) {
         *             if (f[i])
         *                 continue;
         *
         *             for (int j = i * i; j < n; j += 2 * i) {
         *                 if (!f[j]) {
         *                     --count;
         *                     f[j] = true;
         *                 }
         *             }
         *         }
         *         return count;
         */



    }
}
