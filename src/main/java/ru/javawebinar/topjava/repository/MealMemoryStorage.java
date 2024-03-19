package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealMemoryStorage implements Storage{
    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<Integer, Meal> map = new ConcurrentHashMap<>();

    {
        for(Meal meal: MealsUtil.getTestMeals()) {
            save(meal);
        }
    }

    @Override
    public Integer save(Meal meal) {
        meal.setId(counter.getAndIncrement());
        map.put(meal.getId(), meal);
        return meal.getId();
    }

    @Override
    public void update(Meal meal) {
        map.put(meal.getId(), meal);
    }

    @Override
    public void delete(Integer id) {
        map.remove(id);
    }

    @Override
    public Meal get(Integer id) {
        return map.get(id);
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(map.values());
    }
}
