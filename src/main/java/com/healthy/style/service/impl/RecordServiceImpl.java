package com.healthy.style.service.impl;

import com.healthy.style.entity.Record;
import com.healthy.style.entity.User;
import com.healthy.style.repository.RecordRepository;
import com.healthy.style.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RecordServiceImpl implements RecordService {

    private RecordRepository recordRepository;

    @Autowired
    public void setRecordRepository(final RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public List<Record> getUserRecords(final User user) {
        return recordRepository.findRecordsByUser(user);
    }

    @Override
    public List<Record> getRecordsBetweenRunDate(final LocalDate from, final LocalDate to) {
        return recordRepository.findRecordsByRunDateBetween(from, to);
    }

    @Override
    public List<Record> getSortedRecordsBetweenRunDate(final LocalDate from, final LocalDate to) {
        return recordRepository.findRecordsByRunDateBetweenOrderByRunDate(from, to);
    }

    @Override
    public List<Record> getAll() {
        return recordRepository.findAll();
    }

    @Override
    public Record getById(final Long id) {
        return recordRepository.getOne(id);
    }

    @Override
    public Record save(final Record entity) {
        return recordRepository.saveAndFlush(entity);
    }

    @Override
    public void delete(final Long id) {
        recordRepository.deleteById(id);
    }

}
