package com.sleepAllDay.buhatBack.repositories;

import com.sleepAllDay.buhatBack.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
