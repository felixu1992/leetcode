package top.felixu.array;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author felixu
 * @since 2020.03.03
 */
public class AddTwoNumbers {

    /**
     * 思路整理
     * 观察规律可得出，从链表头节点开始，一一相加刚好数学上个位相加，存入新链表头节点，
     * 按此规律，可以用程序实现此数学加法
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 预定义头节点，返回其后继即可
        ListNode pre = new ListNode(0);
        // 用来存储最新节点，用以拉链
        ListNode current = pre;
        // 用来存是否需要进位，只能是 0 或 1
        int temp = 0;
        while (null != l1 || null != l2) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + temp;
            temp = sum / 10;
            sum %= 10;
            // 添加当前节点的后续
            current.next = new ListNode(sum);
            // 将后续节点作为下一次的当前节点
            current = current.next;
            if (null != l1)
                l1 = l1.next;
            if (null != l2)
                l2 = l2.next;
        }
        // 当所有位数全部计算完，需要判断进位变量中是否为 1，如果为 1 应该还需要再追加一个节点
        if (1 == temp)
            current.next = new ListNode(temp);
        return pre.next;
    }

   public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
   }
}
