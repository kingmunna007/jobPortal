package com.kingmunna.Jobs.model;


import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobPost {

    @Id
    private int postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;
    @ElementCollection
    @CollectionTable(name = "job_post_tech_stack", joinColumns = @JoinColumn(name = "post_id"))
    private List<String> postTechStack;

//    public JobPost(int postId, String postProfile, String postDesc, Integer reqExperience, List<String> postTechStack) {
//        this.postId = postId;
//        this.postProfile = postProfile;
//        this.postDesc = postDesc;
//        this.reqExperience = reqExperience;
//        this.postTechStack = postTechStack;
//    }
//    public JobPost(){

//    }
    @Override
    public String toString() {
        return "JobPost{" +
                "postId=" + postId +
                ", postProfile='" + postProfile + '\'' +
                ", postDesc='" + postDesc + '\'' +
                ", reqExperience=" + reqExperience +
                ", postTechStack=" + postTechStack +
                '}';
    }

}