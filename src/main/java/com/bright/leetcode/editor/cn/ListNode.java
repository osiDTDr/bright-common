package com.bright.leetcode.editor.cn;

/**
 * Commonly used constant pool
 *
 * @author Mr.z
 * @since 2020/12/2-19:50
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 判断链表中是否存在目标值
     *
     * @param value 目标值
     * @return true-存在 false-不存在
     */
    public boolean contains(int value) {
        ListNode node = this;
        while (node != null && node.val != value) {
            node = node.next;
        }
        return node != null;
    }

    /**
     * 新节点添加到当前节点头部
     *
     * @param head  当前节点的头结点
     * @param value 新节点值
     */
    private void addFirst(ListNode head, int value) {
        new ListNode(value, head);
    }

    /**
     * 新节点添加到当前节点尾部
     *
     * @param head  当前节点的头结点
     * @param value 新节点值
     */
    private void addLast(ListNode head, int value) {
        ListNode node = head, tail = new ListNode(value);
        while (head != null && node.next != null) {
            node = node.next;
        }
        node.next = tail;
    }

    /**
     * 删除当前节点的尾部节点
     *
     * @param head 当前节点的头结点
     */
    private boolean removeLast(ListNode head) {
        ListNode node = head;
        while (head != null && node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        return true;
    }

    /**
     * 删除节点任意目标值
     *
     * @param head        当前节点的头结点
     * @param targetValue 要删除目标值
     */
    private boolean removeTarget(ListNode head, int targetValue) {

        if (head == null) {
            return false;
        }
        ListNode node = head;
        // head node
        if (node.val == targetValue) {
            if (null == head.next) {
                head.val = Integer.MIN_VALUE;
                head.next = null;
            } else {
                head.val = head.next.val;
                head.next = head.next.next;
            }
            return true;
        }
        while (node.next != null && node.next.val != targetValue) {
            node = node.next;
        }
        if (node.next != null) {
            node.next = node.next.next;
            return true;
        }
        return false;
    }

    /**
     * 添加节点，默认添加到尾部
     */
    public void add(int value) {
        addLast(this, value);
    }

    /**
     * 删除当前节点的尾部节点
     */
    public boolean remove() {
        return removeLast(this);
    }

    /**
     * 删除指定节点
     *
     * @param value 节点值
     */
    public boolean remove(int value) {
        return removeTarget(this, value);
    }

}
