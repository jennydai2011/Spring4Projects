package com.jdai.SpringBootBLog.dao;

import com.jdai.SpringBootBLog.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);
}
