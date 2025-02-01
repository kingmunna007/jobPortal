package com.kingmunna.Jobs.controller;

import com.kingmunna.Jobs.model.JobPost;
import com.kingmunna.Jobs.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin
public class JobsController {
    @Autowired
    private JobsService jobsService;
    @GetMapping("jobposts")
    public List<JobPost> getAll(){
        List<JobPost> jobs = jobsService.getAllJobs();
        System.out.println("Jobs returned from controller: " + jobs);  // Debugging line
        return jobs;
    }


    @GetMapping("jobpost/{id}")
    public JobPost getById(@PathVariable("id") int id){
        return jobsService.getById(id);
    }
    @GetMapping("load")
    public String load(){
        jobsService.load();
        return "Success";
    }

    @GetMapping("jobposts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return jobsService.searchByKeyword(keyword);
    }

    @PostMapping("/addjob")
    public JobPost addJob(@RequestBody JobPost job){
        jobsService.addJob(job);
        return jobsService.getById(job.getPostId());
    }
    @DeleteMapping("/jobpost/{id}")
    public String removeJob(@PathVariable("id") int id){

         jobsService.removeJob(id);
         return "deleted sucessfully";
    }
    @PutMapping("/jobpost")
    public JobPost update(@RequestBody JobPost jobPost){
        return jobsService.update(jobPost);
    }

}
