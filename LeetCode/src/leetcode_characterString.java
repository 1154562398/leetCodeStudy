import sun.plugin.javascript.navig.LinkArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class leetcode_characterString {

    /****************【题目】**************
     *
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *
     *
     *
     * 示例 1：
     *
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * 示例 2：
     *
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     */

    public void reverseString(char[] s) {
        char temp;
        int n=s.length;
        for(int i=0;i<n/2;i++)
        {
            temp=s[i];
            s[i]=s[n-1-i];
            s[n-1-i]=temp;
        }

    }


    /****************【题目】**************
     *
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     */
    public int reverse(int x) {

       int ans=0;
       int temp=0;
       while(x!=0)
       {
           temp=x%10;
           x/=10;
           if (ans >Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && temp > 7)) return 0;
           if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && temp < -8)) return 0;
           ans=ans*10+temp;

       }
       return ans;
    }


    /****************【题目】**************
     *
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * 案例:
     *
     * s = "leetcode"
     * 返回 0.
     *
     * s = "loveleetcode",
     * 返回 2.
     *
     *
     * 注意事项：您可以假定该字符串只包含小写字母。
     *
     */

    public int firstUniqChar(String s) {
        int n=s.length();
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<n;i++)
        {
           if(map.containsKey(s.charAt(i)))
           {
               map.put(s.charAt(i),map.get(s.charAt(i)+1));
           }
           else{
               map.put(s.charAt(i),1);
           }
        }

        for(int j=0;j<n;j++)
        {
          if(map.get(s.charAt(j))==1)
          {
              return j;
          }
        }




        return -1;


        /****************【best method】**************
         *
         * int idx=-1;
         * for(char i='a';i<='z';i++)
         * {
         *      int start=s.indexOf(i);
         *      if(start!=-1&&start==s.lastIndexOf(i))
         *      {
         *          idx=(idx == -1 || idx > start) ? start : idx;
         *      }
         * }
         *         return idx;
         *
         */


    }

    /****************【题目】**************
     *
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     *
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     *
     */

    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<n;i++)
        {

            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);


        }

        for(int i=0;i<m;i++)
        {
            if(map.get(t.charAt(i))!=null&&map.get(t.charAt(i))>0)
            {
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
            }
            else
            {
                return false;
            }
        }


        int[] a=new int[26];
        for(int i=0;i<m;i++)
        {
            a[s.charAt(i)-'a']++;
            a[t.charAt(i)-'a']--;
        }
        for(int i:a)
        {
            if(i!=0)
            {
                return false;
            }
        }

        return true;

    /****************【best method】**************
     *
     *         int n=s.length();
     *         int m=t.length();
     *         if(m!=n)
     *         {return false;}
     *          int[] a=new int[26];
     *         for(int i=0;i<m;i++)
     *         {
     *             a[s.charAt(i)-'a']++;
     *             a[t.charAt(i)-'a']--;
     *         }
     *         for(int i:a)
     *         {
     *             if(i!=0)
     *             {
     *                 return false;
     *             }
     *         }
     *         return true;
     */


    }


    /****************【题目】**************
     *
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     *
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 示例 1:
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     *
     * 输入: "race a car"
     * 输出: false
     *
     */

    public boolean isPalindrome(String s) {
        int m=s.length()-1;
        int i=0;
        boolean a,b,c,d;
        while(i<m)
        {
            a=s.charAt(i)>='A'&&s.charAt(i)<='Z'||s.charAt(i)>='a'&&s.charAt(i)<='z';
            b=s.charAt(i)>='0'&&s.charAt(i)<='9';
            c=s.charAt(m)>='A'&&s.charAt(m)<='Z'||s.charAt(m)>='a'&&s.charAt(m)<='z';
            d=s.charAt(m)>='0'&&s.charAt(m)<='9';

            if(a||b)
            {
                if(c||d){
                    if(!a&&c)
                    {
                        return false;
                    }

                    if(s.charAt(i)-s.charAt(m)==0||Math.abs(s.charAt(i)-s.charAt(m))==32)
                    {
                        i++;m--;
                    }
                    else{
                        return false;
                    }
                }
                else {
                    m--;
                }
            }
            else{
                i++;
            }
        }
        return true;



    }

    /****************【题目】**************
     *
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     *
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     *
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     *
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     *
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     *
     * 说明：
     *
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *
     * 示例 1:
     *
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     *
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     *
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     *
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     *      因此无法执行有效的转换。
     * 示例 5:
     *
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     *
     *
     */
    public int myAtoi(String str) {
        str=str.trim();

        if (str == null || str.length() == 0) return 0;
        int n=str.length()-1;
        int res=0;
        int i=0;
        int des=1;
        if(str.charAt(i)=='+'||str.charAt(i)=='-')
        {
            if(str.charAt(i)=='-')
            {
                des=-1;
            }
            i++;
        }
        else if(Character.isDigit(str.charAt(i)))
        {
        }
        else {
            return 0;
        }
        while(i<=n)
        {
            if(Character.isDigit(str.charAt(i)))
            {
                if(str.charAt(0)=='-'&&res>Integer.MAX_VALUE/10)
                {
                    return Integer.MIN_VALUE;
                }
                else if(res>Integer.MAX_VALUE/10){
                    return Integer.MAX_VALUE;
                }
                else if(res==Integer.MAX_VALUE/10 && (Integer.parseInt(String.valueOf(str.charAt(i)))>(Integer.MAX_VALUE%10)))
                {
                    if(des==-1)
                    {
                        return Integer.MIN_VALUE;
                    }
                    else
                    {
                        return Integer.MAX_VALUE;
                    }

                }
                res=res*10+Integer.parseInt(String.valueOf(str.charAt(i)));
                i++;
            }
            else{
                break;
            }
        }
        return str.charAt(0)=='-'?-res:res;
    }


    /****************【题目】**************
     *
     *实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     *
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     *
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     *
     *
     */


    public int strStr(String haystack, String needle) {
        if(needle.length()==0)
        {

            return 0;
        }
        if(needle.length()>haystack.length())
        {
            return -1;
        }


        int l=0;
        while (haystack.indexOf(needle.charAt(0),l)>0)
        {
            int start=haystack.indexOf(needle.charAt(0));
            int n=needle.length();
            int nStart=0;
            for(int i=start;i<start+n;i++)
            {
                if(haystack.charAt(i)==needle.charAt(start))
                {
                    nStart++;
                }
                else{
                    l=start+n-1;
                    break;
                }

            }
            return start;


        }
        return -1;



    }

    /****************【题目】**************
     *
     * 实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * 说明:
     *
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     *
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     *
     *
     */

    public int strStr1(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        if (haystack == null || "".equals(haystack)) {
            return -1;
        }
        return haystack.indexOf(needle);

        /****************【 method 1 】**************
         *
         * KMP算法
         *
         * https://subetter.com/algorithm/kmp-algorithm.html
         *
         *
         * if(needle.length()==0)
         * return 0;
         * int[] next=getNext(needle.toCharArray());
         * int i=0,j=0;
         * while(i<haystack.length()&&j<needle.length()){
         * if(j==-1||haystack.charAt(i)==needle.charAt(j)){
         *     i++;j++;
         *  }else
         *     j=next[j];
         *  }
         *  if(j==needle.length())
         *     return i-j;
         *  else
         *     return -1;
         *
         *
         *
         * public int[] getNext(char[] pstr){
         *    int[] next=new int[pstr.length+1];
         *    int i=0,j=-1;
         *    next[0]=-1;
         *    while(i<pstr.length){
         *    if(j==-1||pstr[i]==pstr[j]){
         *        i++;
         *        j++;
         *     next[i]=j;
         *     }else
         *        j=next[j];
         *    }
         *    return next;
         *
         */
    }


    /****************【题目】**************
     *
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     *
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     *
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     *
     * 注意：整数顺序将表示为一个字符串。
     *
     *
     * 解释：下一个数是对上一个数的描述，比方说 1211 里有 “ 1 个 1 ， 1 个 2 ， 2 个 1 ” ，那么 111221 就是它的下一个数。通常我们把这个数列叫做“外观数列”。
     */

    public String countAndSay(int n) {
        String str="1";
        if(n==1)
        {
            return "1";
        }

        for(int i=1;i<n;i++)
        {
            StringBuilder sb=new StringBuilder();
            char start=str.charAt(0);
            int count=1;
            for(int j=1;j<str.length();j++)
            {
                if(str.charAt(j)==start)
                {
                    count++;
                }
                else{
                    sb.append(count).append(start);
                    count=1;
                    start=str.charAt(j);

                }
            }
            sb.append(count).append(start);
            str=sb.toString();
        }
        return str;

    }

    /****************【题目】**************
     *
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     *
     *
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs[0].equals(""))
        {
            return "";
        }
        else if(strs.length==1)
        {
            return strs[0];
        }


        StringBuilder sb=new StringBuilder();
        for (int i=0;i<strs[0].length();i++)
        {
            for(int j=1;j< strs.length;j++)
            {
                if(strs[j].equals(""))
                {
                    return "";
                }
                if(i>=strs[j].length()||strs[0].charAt(i)!=strs[j].charAt(i))
                {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));

        }
        return  sb.toString();


    /****************【 method 1 】**************
     *
     * if(strs.length==0||strs[0].equals(""))
     * {
     *   return "";
     * }
     * else if(strs.length==1)
     * {
     *   return strs[0];
     * }
     * String str=strs[0];
     * for(int j=1;j< strs.length;j++)
     * {
     *   while(!strs[j].startsWith(str))
     *      {
     *        str=str.substring(0,str.length()-1);
     *      }
     *   if(str.length()==0)
     *      {
     *        return "";
     *      }
     *
     * }
     * return str;
     *
     */




    }

    /****************【题目】**************
     *
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     *
     * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
     *
     *      4->5->1->9
     *
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], node = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     *
     * 输入: head = [4,5,1,9], node = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *
     *
     * 说明:
     *
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。
     *
     */



    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }
    public void deleteNode(ListNode node) {
        if(node.next!=null){

            node.val=node.next.val;

            node.next=node.next.next;

        }


    }


    /****************【题目】**************
     *
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     *
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node=new ListNode(0);
        ListNode node2=new ListNode(0);

        for(int i=0;i<n;i++)
        {
            node=node.next;
        }
        while(node.next!=null)
        {
            node=node.next;
            node2=node2.next
        }
        System.out.println(node.val);

    }


    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
        System.out.println('0'-'P');
    }
}
