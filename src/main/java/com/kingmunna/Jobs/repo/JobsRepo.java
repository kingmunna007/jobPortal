package com.kingmunna.Jobs.repo;

import com.kingmunna.Jobs.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobsRepo extends JpaRepository<JobPost,Integer> {

    @Query("SELECT j FROM JobPost j WHERE " +
            "LOWER(j.postProfile) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR :keyword MEMBER OF j.postTechStack")
    List<JobPost> searchByKeyword(@Param("keyword") String keyword);
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile, String postTech);
}
