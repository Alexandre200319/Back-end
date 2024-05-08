package com.backend.serviceexercise.controllers;

import com.backend.serviceexercise.models.User;
import com.backend.serviceexercise.services.TwitterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    // Serviço para manipular posts

    //Simulação de um service genérico.
    private TwitterService service;

    @PostMapping("/post/{user_id}")
    public ResponseEntity<?> criarPost(@PathVariable("user_id") String userId, @RequestBody Object postRequest) {
        User entity = service.create(postRequest);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/post")
    public ResponseEntity<?> listarPosts() {
        List<User> result = service.findAll();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/post/{user_id}/{post_id}")
    public ResponseEntity<?> excluirPost(@PathVariable("user_id") String userId, @PathVariable("post_id") String postId) {
        User user = service.findByid(userId);
        user.deletePost(postId);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/post/{user_id}/{post_id}")
    public ResponseEntity<?> favoritarPost(@PathVariable("user_id") String userId, @PathVariable("post_id") String postId, @RequestBody String favoritarPostRequest) {
        User entity = service.findByid(userId);
        entity.setPosts(postId, favoritarPostRequest);
        return ResponseEntity.ok(entity);
    }

    // Serviço para manipular seguidores

    @PostMapping("/{user_id}/follower")
    public ResponseEntity<?> adicionarSeguidor(@PathVariable("user_id") String userId, @RequestBody String adicionarSeguidorRequest) {
        User entity = service.findByid(userId);
        return ResponseEntity.ok(entity.addFollower(adicionarSeguidorRequest));
    }

    @GetMapping("/{user_id}/follower")
    public ResponseEntity<?> listarSeguidores(@PathVariable("user_id") String userId) {
        User entity = service.findByid(userId);
        var followers = entity.getFollowers();
        return ResponseEntity.ok(followers);
    }

    @DeleteMapping("/{user_id}/follower/{follower_id}")
    public ResponseEntity<?> deletarSeguidor(@PathVariable("user_id") String userId, @PathVariable("follower_id") String followerId) {
        User user = service.findByid(userId);
        user.deleteFollower(followerId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{user_id}/follower/{follower_id}")
    public ResponseEntity<?> silenciarSeguidor(@PathVariable("user_id") String userId, @PathVariable("follower_id") String followerId, @RequestBody String silenciarSeguidorRequest) {
        User entity = service.findByid(userId);
        var result = entity.updateFollower(followerId, silenciarSeguidorRequest);
        return ResponseEntity.ok(result);
    }
}

