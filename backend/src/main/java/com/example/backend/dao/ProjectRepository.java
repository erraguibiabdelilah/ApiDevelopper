package com.example.backend.dao;
import com.example.backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    Project findProjectById(Long id);
    Project findByIdAndUserId(Long id, Long userId);
    boolean existsByProjectNameAndUserId(String projectName, Long userId);
    List<Project> findByUserId(Long userId);
/*
    @Query("""
        SELECT DISTINCT p 
        FROM Project p 
        LEFT JOIN FETCH p.entitys
        WHERE p.user.id = :userId
        """)
    List<Project> findProjectsWithEntitiesByUserId(@Param("userId") Long userId);

 */

}