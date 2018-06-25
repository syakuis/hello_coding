package org.syaku.example1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 26.
 */
public class BinarySearchTest {
  @Test
  public void test() {
    Integer[] items = new Integer[]{ 1, 3, 5, 7, 9 };
    Assert.assertSame(BinarySearch.indexOf(items, 3), 1);
    Assert.assertNull(BinarySearch.indexOf(items, -1));
  }
}
