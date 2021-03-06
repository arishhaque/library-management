package librarymanager.backend.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    Optional<T> get(int id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(int id);
}
