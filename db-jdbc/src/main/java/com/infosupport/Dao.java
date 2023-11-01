package com.infosupport;

import java.util.Set;

public interface Dao<T, Id> {
    T get(Id id);
    Set<T> getAll();
    boolean insert(T type);
    boolean update(T type);
    boolean delete(Id id);
}
