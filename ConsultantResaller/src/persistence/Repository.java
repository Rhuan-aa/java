package persistence;

import java.util.Optional;

public interface Repository <K,T> {
    void save(T entity);
    void update(T entity);
    Optional<T> findById(K key);
}
