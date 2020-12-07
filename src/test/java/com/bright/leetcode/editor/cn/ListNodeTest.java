package com.bright.leetcode.editor.cn;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Commonly used constant pool
 *
 * @author Mr.z
 * @since 2020/12/3-10:44
 */
public class ListNodeTest {

    private static final ListNode HEAD = new ListNode(5);
    private static final ListNode TAIL = new ListNode(10);

    @BeforeAll
    private static void init() {
        ListNode n1 = new ListNode(8);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(7);
        HEAD.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = TAIL;
    }

    @Test
    public void contains() {
        boolean result = HEAD.contains(3);
        assert Boolean.TRUE.equals(result);
    }

    @Test
    void add() {
        HEAD.add(20);
        assert Boolean.TRUE.equals(HEAD.contains(20));
        assert Boolean.FALSE.equals(HEAD.contains(50));
    }

    @Test
    void remove() {
        boolean result = HEAD.remove();
        assert Boolean.TRUE.equals(result);
        assert Boolean.FALSE.equals(HEAD.contains(10));
        assert Boolean.TRUE.equals(HEAD.contains(4));
    }

    @Test
    void testRemove() {
        boolean result = HEAD.remove(4);
        assert Boolean.TRUE.equals(result);
        assert Boolean.FALSE.equals(HEAD.contains(4));

        boolean result2 = HEAD.remove(5);
        assert Boolean.TRUE.equals(result2);
        assert Boolean.FALSE.equals(HEAD.contains(5));

        boolean result3 = HEAD.remove(10);
        assert Boolean.TRUE.equals(result3);
        assert Boolean.FALSE.equals(HEAD.contains(10));
    }
}