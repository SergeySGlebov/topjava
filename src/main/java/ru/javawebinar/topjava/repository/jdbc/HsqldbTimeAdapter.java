package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.javawebinar.topjava.Profiles;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
@Profile(Profiles.HSQL_DB)
public class HsqldbTimeAdapter implements TimeAdapter {

    @Override
    public Timestamp getTime(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }
}
