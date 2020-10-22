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

import java.util.Map;
import org.jetbrains.annotations.NotNull;

/**
 * an immutable {@link Map.Entry} implementation.
 * <p>
 * there is no thread-safety guarantee.
 *
 * @param <K> key type.
 * @param <V> value type.
 */
public final class MapEntry<K, V> implements Map.Entry<K, V> {

  /**
   * the key.
   */
  @NotNull
  private final K key;

  /**
   * the value.
   */
  @NotNull
  private final V value;

  /**
   * ctor.
   *
   * @param key the key.
   * @param value the value.
   */
  private MapEntry(@NotNull final K key, @NotNull final V value) {
    this.key = key;
    this.value = value;
  }

  @NotNull
  public static <K, V> Map.Entry<K, V> from(@NotNull final K key, @NotNull final V value) {
    return new MapEntry<>(key, value);
  }

  @Override
  public K getKey() {
    return this.key;
  }

  @Override
  public V getValue() {
    return this.value;
  }

  @Override
  public V setValue(@NotNull final V yvalue) {
    throw new UnsupportedOperationException(this.getClass().getSimpleName() + " is an immutable class, you can't edit it!");
  }

  @Override
  public int hashCode() {
    return this.key.hashCode() ^ this.value.hashCode();
  }

  @Override
  public boolean equals(final Object obj) {
    return obj instanceof Map.Entry
      && ((Map.Entry<?, ?>) obj).getKey().equals(this.key)
      && ((Map.Entry<?, ?>) obj).getValue().equals(this.value);
  }

  @Override
  public String toString() {
    return this.key + "=" + this.value;
  }
}
