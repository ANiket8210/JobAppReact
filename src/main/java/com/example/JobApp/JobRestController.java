package com.example.JobApp;


import com.example.JobApp.model.JobPost;
import com.example.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class JobRestController {

    @Autowired
    JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> jobPosts(){
        return service.getAllJobs();
    }

    @GetMapping("jobPosts/{postId}")
    public JobPost getJobPost(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }
}
