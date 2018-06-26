package org.syaku.example1;

import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 문자열에 대한 이진탐색 (정렬이 된 상태에서 탐색한다.)
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 26.
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contacts implements Comparable<Contacts> {
  @Getter
  private String name;
  @Getter
  private String phone;

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  /**
   * name asc 오름차순
   * Collections.sort(result);
   * @param o {@link Contacts}
   * @return int
   */
  @Override
  public int compareTo(Contacts o) {
    return this.name.compareTo(o.name);
  }

  /**
   * name desc 내림차순
   * Collections.sort(result, nameDesc());
   * or
   * Collections.reverse(result);
   * @return Comparator
   */
  public Comparator<Contacts> nameDesc() {
    return (o1, o2) -> o2.name.compareTo(o1.name);
  }

  public static Contacts findByName(List<Contacts> items, String name) {
    int start = 0;
    int end = items.size() - 1;

    while (start <= end) {
      int index = (start + end) / 2;
      Contacts item = items.get(index);
      String target = item.name;

      if (target.equals(name)) {
        return item;
      } else if (target.compareTo(name) > 0) {
        end = index - 1;
      } else {
        start = index + 1;
      }
    }

    return null;
  }
}
