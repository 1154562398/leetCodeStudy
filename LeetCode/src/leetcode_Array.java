import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_Array {
    public static int lengthOfLongestSubstring(String s) {
        int le = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < le; i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)), j);

            }
            ans = Math.max(ans, i - j + 1);
            map.put(s.charAt(i), i + 1);
        }
        return ans;
    }



    public boolean isPalindrome(int x) {
        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }


    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 示例 1:
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     */

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[n]) {

            } else {
                nums[++n] = nums[i];
            }
        }
        return n + 1;

    }

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */


    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 示例 1:
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * 说明:
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     */
    public void exchange(int a, int b) {
        int c;
        c = a;
        a = b;
        b = c;
    }

    public void rotate(int[] nums, int k) {
        int j = 0;

        for (int i = nums.length - k - 1; i < nums.length; i++) {
            exchange(nums[j], nums[i]);
            j++;
        }


    /**
     * method 1
     *
     *          for(int i=0;i<k;i++)
     *         {
     *             int temp=nums[nums.length-1];
     *             for(int j=nums.length-1;j>=1;j--)
     *             {
     *                 nums[j]=nums[j-1];
     *             }
     *             nums[0]=temp;
     *
     *
     *         }
     *
     */



    }


    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     * 示例 2:
     * 输入: [1,2,3,4]
     * 输出: false
     * 示例 3:
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     */

    public boolean containsDuplicate(int[] nums) {


        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    break;
                else if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;


    /**
     * method 1
     *
     *         if(nums.length<=1)
     *         {
     *             return false;
     *         }
     *
     *         List<Integer> temp=new ArrayList<Integer>();
     *         temp.add(nums[0]);
     *         for(int i=1;i<nums.length;i++)
     *         {
     *             for(int j:temp)
     *             {
     *                 if(j==nums[i])
     *                 {
     *                     return true;
     *                 }
     *
     *             }
     *             temp.add(nums[i]);
     *
     *         }
     *         return false;
     *
     *
     *         Set<Integer> set = new HashSet<>(nums.length);
     *         for (int x: nums) {
     *             if (set.contains(x)) return true;
     *             set.add(x);
     *         }
     *         return false;
     * */

    }



    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     * 示例 2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     */

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                if (nums[i] == nums[i + 2]) {
                    return nums[i + 1];
                } else {
                    return nums[i];
                }
            }
        }
        return 0;

    /**
     * method best
     *
     *      int res=0;
     *      for(int i:nums)
     *      {
     *          res^=i;
     *      }
     *      return res;
     *
     *
     * annotation:
     *
     *      a^a=0
     *      a^b^c^a^b=a^a^b^b^c=c
     *
     *
     * */

    }


    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     * 示例 2:
     * <p>
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [4,9]
     * 说明：
     * <p>
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶:
     * <p>
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     */


    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> resList = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            Integer count = map.get(i);
            if (count == null) {
                map.put(i, 1);
            } else {
                map.put(i, ++count);
            }

        }
        for (int j : nums2) {
            Integer count = map.get(j);
            if (count != null && count > 0) {
                resList.add(j);
                map.put(j, --count);

            }
        }
        int[] res = new int[resList.size()];
        for (int k = 0; k < resList.size(); k++) {
            res[k] = resList.get(k);
        }


        return res;

    /**
     * method 2
     *
     *      Map<Integer,Integer> map = new HashMap<Integer,Integer>();
     *
     *       for(int i = 0; i < nums1.length; i++){
     *           Integer count = map.get(nums1[i]);
     *           if(count == null){
     *               map.put(nums1[i], 1);
     *           }else{
     *               map.put(nums1[i], ++count);
     *           }
     *       }
     *
     *       List<Integer> list = new ArrayList<Integer>();
     *
     *       for(int i = 0; i < nums2.length; i++){
     *           Integer count = map.get(nums2[i]);
     *           if(count != null && count > 0){
     *               list.add(nums2[i]);
     *               map.put(nums2[i], --count);
     *           }
     *       }
     *
     *       int k = 0;
     *       int[] res = new int[list.size()];
     *       for(Integer integer : list){
     *           res[k++] = integer;
     *       }
     *
     *       return res;
     *
     */

    /*********************************************************************************************************/

    /**
     * best method
     *
     *
     * if(nums1==null || nums2==null) return null;
     *       Arrays.sort(nums1);
     *       Arrays.sort(nums2);
     *
     *       int l1 = nums1.length;
     *       int l2 = nums2.length;
     *       int[] arr = new int[l1>l2?l2:l1];
     *
     *       int i=0;
     *       int j=0;
     *       int k = 0;
     *       while(i<l1 && j<l2){
     *           if(nums1[i] < nums2[j]){
     *               i++;
     *           } else if(nums1[i] > nums2[j]){
     *               j++;
     *           } else {
     *               arr[k] = nums1[i];
     *               k++;
     *               i++;
     *               j++;
     *           }
     *       }
     *
     *       int[] temp = new int[k];
     *       for(int q=0;q<k;q++){
     *           temp[q] = arr[q];
     *       }
     *
     *       return temp;
     *   }
     *
     *
     */

    }

    /**
     *
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     *
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     *
     *
     */

    public int[] plusOne(int[] digits) {

        for(int i=digits.length-1;i>=0;i--)
        {
            if(digits[i]<9)
            {
                digits[i]+=1;
                return digits;
            }
            else
            {
                digits[i]=0;
            }
        }
        int res[]=new int[digits.length+1];
        res[0]=1;
        for(int i=1;i<res.length;i++)
        {
            res[i]=digits[i-1];
        }
        return res;

    }


    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     *
     */

    public void moveZeroes(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1){return;}
        int temp;
        int cur=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                temp=nums[i];
                nums[i]=0;
                nums[cur]=temp;
                cur++;
            }

        }
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     */

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {};
        }
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int j=target-nums[i];
            if(map.containsKey(j))
            {
                return new int[] {i,map.get(j)};
            }
            map.put(nums[i],i);
        }
        return new int[]{};

    }

    /**
     *
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     *
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     *
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *   ["5","3",".",".","7",".",".",".","."],
     *   ["6",".",".","1","9","5",".",".","."],
     *   [".","9","8",".",".",".",".","6","."],
     *   ["8",".",".",".","6",".",".",".","3"],
     *   ["4",".",".","8",".","3",".",".","1"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".","6",".",".",".",".","2","8","."],
     *   [".",".",".","4","1","9",".",".","5"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: true
     * 示例 2:
     *
     * 输入:
     * [
     *   ["8","3",".",".","7",".",".",".","."],
     *   ["6",".",".","1","9","5",".",".","."],
     *   [".","9","8",".",".",".",".","6","."],
     *   ["8",".",".",".","6",".",".",".","3"],
     *   ["4",".",".","8",".","3",".",".","1"],
     *   ["7",".",".",".","2",".",".",".","6"],
     *   [".","6",".",".",".",".","2","8","."],
     *   [".",".",".","4","1","9",".",".","5"],
     *   [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: false
     * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     *
     */

    public boolean isValidSudoku(char[][] board) {


        Map<Character,Integer>[] map3=new HashMap[9];
        for(int i=0;i<9;i++)
        {
            map3[i] = new HashMap<Character, Integer>();
        }

        for(int i=0;i<9;i++)
        {
            Map<Character,Integer> map=new HashMap<Character, Integer>();
            Map<Character,Integer> map2=new HashMap<Character, Integer>();

            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {

                    map.put(board[i][j],map.getOrDefault(board[i][j],0)+1);

                    int indx=(i / 3 ) * 3 + j/3;
                    map3[indx].put(board[i][j],map3[indx].getOrDefault(board[i][j],0)+1);

                    if(map3[indx].get(board[i][j])>1||map.get(board[i][j])>1)
                    {
                        return false;
                    }

                }

                if(board[j][i]!='.')
                {
                    map2.put(board[j][i],map2.getOrDefault(board[j][i],0)+1);
                    if(map2.get(board[j][i])>1)
                    {
                        return  false;
                    }
                }



            }

        }

        return true;

        /**
         * ******official method*******
         *
         *
         *  // init data
         *          HashMap<Integer, Integer> [] rows = new HashMap[9];
         *          HashMap<Integer, Integer> [] columns = new HashMap[9];
         *          HashMap<Integer, Integer> [] boxes = new HashMap[9];
         *          for (int i = 0; i < 9; i++) {
         *          rows[i] = new HashMap<Integer, Integer>();
         *          columns[i] = new HashMap<Integer, Integer>();
         *          boxes[i] = new HashMap<Integer, Integer>();
         *          }
         *
         *          // validate a board
         *          for (int i = 0; i < 9; i++) {
         *          for (int j = 0; j < 9; j++) {
         *          char num = board[i][j];
         *          if (num != '.') {
         *          int n = (int)num;
         *          int box_index = (i / 3 ) * 3 + j / 3;
         *
         *          // keep the current cell value
         *          rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
         *          columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
         *          boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
         *
         *          // check if this value has been already seen before
         *          if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
         *          return false;
         *          }
         *          }
         *          }
         *
         *          return true;
         */

    }




    /**
     *
     * 给定一个 n × n 的二维矩阵表示一个图像。
     *
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     *
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 示例 1:
     *
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     * 示例 2:
     *
     * 给定 matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     *
     *
     */


    public void rotate(int[][] matrix) {
        int n=matrix[0].length;
        int temp;
        for(int i=0;i<(n + 1) / 2;i++)
        {
            for(int j=0;j<n/2;j++)
            {
               temp=matrix[i][j];
               matrix[i][j]=matrix[n-1-j][i];
               matrix[n-1-j][i]=matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1]=matrix[j][n - 1 -i];
                matrix[j][n - 1 -i]=temp;


            }

        }
    }



    public static void main(String[] args) {
//        int a=lengthOfLongestSubstring("qweqweww");
//        System.out.println("zjl  "+a);
        int[] nums = {7, 1, 5, 3, 4, 6};

        int a = maxProfit(nums);
        System.out.println("zjl  " + a);
    }
}
