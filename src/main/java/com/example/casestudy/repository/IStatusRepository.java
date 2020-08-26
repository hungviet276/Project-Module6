package com.example.casestudy.repository;

import com.example.casestudy.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<Status,Long> {
}
