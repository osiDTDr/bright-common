package com.bright.leetcode.editor.cn;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Commonly used constant pool
 *
 * @author Mr.z
 * @since 2020/12/3-10:44
 */
public class ListNodeTest {

    private static ListNode head = new ListNode(5);
    private static ListNode tail = new ListNode(10);

    @BeforeAll
    private static void init(){
        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(7);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = tail;
    }

    @Test
    public void contains() {
        boolean result = head.contains(3);
        assert Boolean.TRUE.equals(result);
    }

    @Test
    void add() {
        head.add(20);
        assert Boolean.TRUE.equals(head.contains(20));
        assert Boolean.FALSE.equals(head.contains(50));
    }

    @Test
    void remove() {
        boolean result = head.remove();
        assert Boolean.TRUE.equals(result);
        assert Boolean.FALSE.equals(head.contains(10));
        assert Boolean.TRUE.equals(head.contains(4));
    }

    @Test
    void testRemove() {
        boolean result = head.remove(4);
        assert Boolean.TRUE.equals(result);
        assert Boolean.FALSE.equals(head.contains(4));

        boolean result2 = head.remove(5);
        assert Boolean.TRUE.equals(result2);
        assert Boolean.FALSE.equals(head.contains(5));

        boolean result3 = head.remove(10);
        assert Boolean.TRUE.equals(result3);
        assert Boolean.FALSE.equals(head.contains(10));
    }
}