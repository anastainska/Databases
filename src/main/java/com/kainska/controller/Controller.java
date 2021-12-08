package com.kainska.controller;

import com.kainska.dao.*;
import com.kainska.model.*;
import com.kainska.service.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private UserService userService;
    private CommentService commentService;
    private LikeCommentService likeCommentService;
    private LikePostService likePostService;
    private MessageService messageService;
    private PhotoService photoService;
    private PostService postService;
    private SecurityService securityService;
    private StoryService storyService;

    public Controller() {
        userService = new UserService();
        commentService = new CommentService();
        likeCommentService = new LikeCommentService();
        likePostService = new LikePostService();
        messageService = new MessageService();
        photoService = new PhotoService();
        postService = new PostService();
        securityService = new SecurityService();
        storyService = new StoryService();
    }

    public User findUserById(Integer id) { return userService.findUserById(id); }
    public List<User> findAllUser() { return userService.findAllUser(); }
    public void createUser(User user) { userService.createUser(user); }
    public void updateUser(User user) { userService.updateUser(user); }
    public void deleteUser(User user) { userService.deleteUser(user); }

    public LikeComment findLikeCommentById(Integer id) { return likeCommentService.findLikeCommentById(id); }
    public List<LikeComment> findAllLikeComment() { return likeCommentService.findAllLikeComment(); }
    public void createLikeComment(LikeComment likeComment) { likeCommentService.createLikeComment(likeComment); }
    public void updateLikeComment(LikeComment likeComment) { likeCommentService.updateLikeComment(likeComment); }
    public void deleteLikeComment(LikeComment likeComment) { likeCommentService.deleteLikeComment(likeComment); }

    public Comment findCommentById(Integer id) { return commentService.findCommentById(id); }
    public ArrayList<String[]> findAllComment() throws SQLException { return commentService.findAllComment(); }
    public void createComment(Comment comment) { commentService.createComment(comment); }
    public void updateComment(Comment comment) { commentService.updateComment(comment); }
    public void deleteComment(Comment comment) { commentService.deleteComment(comment); }

    public LikePost findLikePostById(Integer id) { return likePostService.findLikePostById(id); }
    public List<LikePost> findAllLikePost() { return likePostService.findAllLikePost(); }
    public void createLikePost(LikePost likePost) { likePostService.createLikePost(likePost); }
    public void updateLikePost(LikePost likePost) { likePostService.updateLikePost(likePost); }
    public void deleteLikePost(LikePost likePost) { likePostService.deleteLikePost(likePost); }

    public Message findMessageById(Integer id) { return messageService.findMessageById(id); }
    public List<Message> findAllMessage() { return messageService.findAllMessage(); }
    public void createMessage(Message message) { messageService.createMessage(message); }
    public void updateMessage(Message message) { messageService.updateMessage(message); }
    public void deleteMessage(Message message) { messageService.deleteMessage(message); }

    public Photo findPhotoById(Integer id) { return photoService.findPhotoById(id); }
    public List<Photo> findAllPhoto() { return photoService.findAllPhoto(); }
    public void createPhoto(Photo photo) { photoService.createPhoto(photo); }
    public void updatePhoto(Photo photo) { photoService.updatePhoto(photo); }
    public void deletePhoto(Photo photo) { photoService.deletePhoto(photo); }

    public Post findPostById(Integer id) { return postService.findPostById(id); }
    public List<Post> findAllPost() { return postService.findAllPost(); }
    public void createPost(Post post) { postService.createPost(post); }
    public void updatePost(Post post) { postService.updatePost(post); }
    public void deletePost(Post post) { postService.deletePost(post); }

    public Security findSecurityById(Integer id) { return securityService.findSecurityById(id); }
    public List<Security> findAllSecurity() { return securityService.findAllSecurity(); }
    public void createSecurity(Security security) { securityService.createSecurity(security); }
    public void updateSecurity(Security security) { securityService.updateSecurity(security); }
    public void deleteSecurity(Security security) { securityService.deleteSecurity(security); }

    public Story findStoryById(Integer id) { return storyService.findStoryById(id); }
    public List<Story> findAllStory() { return storyService.findAllStory(); }
    public void createStory(Story story) { storyService.createStory(story); }
    public void updateStory(Story story) { storyService.updateStory(story); }
    public void deleteStory(Story story) { storyService.deleteStory(story); }

}
