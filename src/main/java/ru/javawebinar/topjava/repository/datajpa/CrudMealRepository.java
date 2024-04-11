package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Transactional
    @Modifying
    @Query(name = Meal.DELETE)
    int delete(@Param("id") int id, @Param("userId") int userId);

    List<Meal> getMealsByUser_Id(int userId, Sort sortDatetimeDesc);

    Meal getMealByIdAndUser_Id(int id, int userId);

    @Query("SELECT m FROM Meal m LEFT JOIN FETCH m.user WHERE m.id = ?1 AND m.user.id = ?2")
    Meal getWithUser(int id, int userId);

    List<Meal> getMealsByDateTimeAfterAndDateTimeBeforeAndUser_Id(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId, Sort sortDatetimeDesc);
}
