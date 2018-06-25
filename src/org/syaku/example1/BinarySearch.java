package org.syaku.example1;

/**
 * 이진탐색
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 25.
 */
public class BinarySearch {
  static Integer indexOf(Integer[] items, Integer value) {
    Integer start = 0;
    Integer end = items.length - 1;

    while (start <= end) {
      Integer index = (start + end) / 2;
      Integer item = items[index];

      if (item == value) {
        return index;
      } else if (item > value) {
        end = index - 1;
      } else {
        start = index + 1;
      }
    }

    return null;
  }

  public static void main(String[] args) {
    Integer[] items = new Integer[]{ 1, 3, 5, 7, 9 };

    System.out.println(indexOf(items, 9));
    System.out.println(indexOf(items, -1));
  }
}
