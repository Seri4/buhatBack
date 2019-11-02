package com.sleepAllDay.buhatBack.repositories;

import com.sleepAllDay.buhatBack.models.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BarRepository extends JpaRepository<Bar, Long> {

    List<Bar> findAll();

    void deleteById(Long id);

    Optional<Bar> findById(Long id);

}
