package ru.javawebinar.topjava.repository.jdbc;

import java.time.LocalDateTime;

public interface TimeAdapter {

    <T> T getTime(LocalDateTime localDateTime);
}
