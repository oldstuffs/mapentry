package io.github.portlek.mapentry;

import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * MapEntry as {@link java.util.AbstractMap.Entry}.
 * <p>
 * There is no thread-safety guarantee.
 *
 * @param <K> Key type
 * @param <V> Value type
 */
@RequiredArgsConstructor
@Getter
public final class MapEntry<K, V> implements Map.Entry<K, V> {

    /**
     * The key.
     */
    @NotNull
    private final K key;

    /**
     * The value.
     */
    @NotNull
    private final V value;

    @NotNull
    public static <K, V> Map.Entry<K, V> from(@NotNull final K key, @NotNull final V value) {
        return new MapEntry<>(key, value);
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
