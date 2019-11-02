package com.sleepAllDay.buhatBack.repositories;

import com.sleepAllDay.buhatBack.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
