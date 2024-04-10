package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.javawebinar.topjava.Profiles;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
@Profile(Profiles.POSTGRES_DB)
public class PostgresTimeAdapter implements TimeAdapter {

    @Override
    public LocalDateTime getTime(LocalDateTime localDateTime) {
        return localDateTime;
    }
}
