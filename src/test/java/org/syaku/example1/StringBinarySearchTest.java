package org.syaku.example1;

import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 26.
 * @see Contacts
 */
@Slf4j
public class StringBinarySearchTest {
  List<Contacts> result = new ArrayList<>();

  @Before
  public void setup() {
    result.add(new Contacts("최석균", "010"));
    result.add(new Contacts("가나다", "010"));
    result.add(new Contacts("홍길동", "010"));
    for (int i = 0; i < 1000000; i++) {
      result.add(new Contacts(UUID.randomUUID().toString(), "010"));
    }
  }
  @Test(timeout = 1000)
  public void test() {
    long start = System.currentTimeMillis();
    Collections.sort(result);
    Assert.assertEquals(Contacts.findByName(result, "가나다"), new Contacts("가나다", "010"));
    Assert.assertEquals(Contacts.findByName(result, "홍길동"), new Contacts("홍길동", "010"));
    Assert.assertNull(Contacts.findByName(result, "아무개"));
    log.debug("exit -> {} ms", (System.currentTimeMillis() - start));
  }
}
