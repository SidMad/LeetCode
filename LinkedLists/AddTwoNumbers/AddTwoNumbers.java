/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode() {}
*     ListNode(int val) { this.val = val; }
*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
* }
*/
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode head = null;
    ListNode currentNode = null;

    while ((l1 != null) || (l2 != null)) { // While either list has elements
      if ((l1 != null) && (l2 != null)) { // If both lists have values left
        int sum = l1.val + l2.val + carry;
        if (sum > 9) { // If the sum of the 2 digits is > 9 then we need to carry the 1
          carry = 1;
          sum = sum - 10; // Convert the sum back to a single digit
        } else {
          carry = 0;
        }
        ListNode node = new ListNode(sum);
        if (head == null) { // Save the head to return it later
          head = node;
          currentNode = node;
        }
        else {
          currentNode.next = node;
          currentNode = node;
        }
        l1 = l1.next;
        l2 = l2.next;
      }
      else if (l1 != null) {
        int sum = l1.val + carry;
        if (sum > 9) {
          carry = 1;
          sum = sum - 10;
        } else {
          carry = 0;
        }
        ListNode node = new ListNode(sum);
        currentNode.next = node;
        currentNode = node;
        l1 = l1.next;
      } else {
        int sum = l2.val + carry;
        if (sum > 9) {
          carry = 1;
          sum = sum - 10;
        } else {
          carry = 0;
        }
        ListNode node = new ListNode(sum);
        currentNode.next = node;
        l2 = l2.next;
        currentNode = node;
      }
    }
    if (carry == 1) {
      currentNode.next = new ListNode(1);
    }
    return head;
  }

}
