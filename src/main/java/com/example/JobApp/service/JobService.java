package com.example.JobApp.service;


import com.example.JobApp.model.JobPost;
import com.example.JobApp.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }

    public boolean addJob(JobPost jobPost){
        return repo.addJobs(jobPost);
    }

    public JobPost getJob(int postId) {
        return repo.getJob(postId);
    }

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }

    public boolean deleteJobPost(int postId) {
        return repo.deleteJob(postId);
    }
}
