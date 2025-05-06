package persistence;

import java.util.Optional;

public interface Repository <T, K>{
    void save(T entity);
    void update(T entity);
    Optional<T> findById(K id);
}
