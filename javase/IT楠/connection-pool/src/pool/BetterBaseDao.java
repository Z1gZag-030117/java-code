package pool;

import java.util.List;

public interface BetterBaseDao<T> {
    int sava(T t);

    int delete(int id);

    List<T> selectAll(Class clazz);

    T selectOne(int id);

    int update(T t);

}
