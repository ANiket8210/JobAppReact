package com.example.JobApp;


import com.example.JobApp.model.JobPost;
import com.example.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "localhost:3000")
public class JobRestController {

    @Autowired
    JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> jobPosts(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJobPost(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping("/jobPost")
    public JobPost addJobPost(@RequestBody JobPost jobPost) {//here frontend returns JSON, but we need to convert that to JobPost object, so we use @RequestBody
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());// here we should return with getjob as a proof that the jobpost was successfully added to the DB
    }

    @PutMapping("/jobPost")
    public JobPost updateJobPost(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("/jobPost")
    public boolean deleteJobPost(@RequestParam("postId") int postId) {
        return service.deleteJobPost(postId);
    }

    @GetMapping("/load")
    public boolean load(){
        return service.load();
    }

    @GetMapping("/jobPostProfileLike")
    public List<JobPost> getJobPostLikeName(@RequestParam("name") String name){
        return service.getJobPostProfileLike(name);
    }

    @PostMapping("/JobPostsByTechStack")
    public List<JobPost> findAllJobPostsByTechStack(@RequestBody List<String> techStack){
        return service.findallByPostTechStack(techStack);
    }
}
