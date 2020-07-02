package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/post")
public class PostController {

    @RequestMapping(method = RequestMethod.GET)
    public String getPost(@RequestParam(value = "id", required = false) Integer id ) {
        return "post number" + id;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<String> getAllPosts() {
        List<String> response = new ArrayList<String>();

        response.add("Post 1");
        response.add("Post 2");
        response.add("Post 3");
        response.add("Post 4");

        return response;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPost(@RequestParam("title") String title) {
        return "created post with title " + title;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePost(@RequestParam("id") Integer id) {
        return "deleted post " + id;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePost(@RequestParam("id") Integer id) {
        return "updated post " + id;
    }
    
}