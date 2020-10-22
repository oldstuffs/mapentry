/*
 * MIT License
 *
 * Copyright (c) 2020 Hasan Demirtaş
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package io.github.portlek.mapentry;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.llorllale.cactoos.matchers.Assertion;
import org.llorllale.cactoos.matchers.IsTrue;
import org.llorllale.cactoos.matchers.Throws;

final class MapEntryTest {

  @Test
  public void getKey() {
    final String key = "hello";
    final String value = "world";
    new Assertion<>(
      "Can't get key in the map entry",
      MapEntry.from(key, value).getKey(),
      new IsEqual<>(key)
    ).affirm();
  }

  @Test
  public void getValue() {
    final String value = "bar";
    new Assertion<>(
      "Can't get value in the map entry",
      MapEntry.from("foo", value).getValue(),
      new IsEqual<>(value)
    ).affirm();
  }

  @Test
  public void cantSetValue() {
    new Assertion<>(
      "MapEntry class shouldn't be mutable!",
      () ->
        MapEntry.from("elegant", "objects").setValue("test"),
      new Throws<>(UnsupportedOperationException.class)
    ).affirm();
  }

  @Test
  public void equalsTo() {
    final String key = "eo";
    final String value = "book";
    new Assertion<>(
      "MapEntries are not equals",
      MapEntry.from(key, value).equals(MapEntry.from(key, value)),
      new IsTrue()
    ).affirm();
  }

  @Test
  public void compareHash() {
    new Assertion<>(
      "the hash code are not equals",
      MapEntry.from("elegant", "objects").hashCode(),
      new IsEqual<>(32_739_498)
    ).affirm();
  }

  @Test
  public void toStringMethod() {
    new Assertion<>(
      "ToString method returns unexpected value",
      MapEntry.from("somekey", "somevalue").toString(),
      new IsEqual<>("somekey=somevalue")
    ).affirm();
  }
}
