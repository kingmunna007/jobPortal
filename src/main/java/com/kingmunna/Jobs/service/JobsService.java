package com.kingmunna.Jobs.service;

import com.kingmunna.Jobs.model.JobPost;
import com.kingmunna.Jobs.repo.JobsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JobsService {
    @Autowired
    private JobsRepo repo;

    public List<JobPost> getAllJobs() {
        List<JobPost> jobs = repo.findAll();
        System.out.println("Retrieved jobs: " + jobs); // Debugging line
        return jobs;
    }

    public JobPost getById(int id) {
        return repo.findById(id).orElse(new JobPost());
    }

    public void load() {
        List<JobPost> jobs = List.of(
                new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL", "API")),
                new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow", "API")),
                new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS", "API")),
                new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))
        );
        System.out.println(jobs);

        repo.saveAll(jobs);
    }


    public List<JobPost> searchByKeyword(String keyword) {
//        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
        return repo.searchByKeyword(keyword);
    }

    public void addJob(JobPost job) {
         repo.save(job);
    }
    @Transactional
    public JobPost removeJob(int id) {
        JobPost job =  repo.findById(id).orElseThrow(() -> new RuntimeException("Id not found!"));

        repo.deleteById(id);
        log.info("deleted job: {}",job);

        return job;
    }

    public JobPost update(JobPost jobPost) {
        JobPost job =  repo.findById(jobPost.getPostId()).orElseThrow(() -> new RuntimeException("Id not found!"));

        job.setPostProfile(jobPost.getPostProfile());
        job.setPostDesc(jobPost.getPostDesc());
        job.setReqExperience(jobPost.getReqExperience());
        job.setPostTechStack(jobPost.getPostTechStack());

        return repo.save(job);

    }
}
