package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface Storage {
    Integer save(Meal meal);

    void update(Meal meal);

    void delete(Integer id);

    Meal get(Integer id);

    List<Meal> getAll();
}
