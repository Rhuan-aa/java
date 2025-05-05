public interface Repository <ID, T> {
    void save(T entity);
    T findById(ID id);
}
