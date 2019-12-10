package com.healthy.style.repository;

import com.healthy.style.entity.Record;
import com.healthy.style.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    List<Record> findRecordsByRunDateBetween(LocalDate from, LocalDate to);

    List<Record> findRecordsByRunDateBetweenOrderByRunDate(LocalDate from, LocalDate to);

    List<Record> findRecordsByUser(User user);

}
