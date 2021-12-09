package com.kainska.view;

import com.kainska.controller.Controller;
import com.kainska.model.*;

import java.sql.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;

public class View {
    private Controller controller = new Controller();

    public void interactMenu() throws SQLException, ParseException {
        showMenu();
        System.out.println("\n");
        int point = new Scanner(System.in).nextInt();
        switch (point) {
            case 1:
                userSubMenu();
                break;
            case 2:
                commentSubMenu();
                break;
            case 3:
                likeCommentSubMenu();
                break;
            case 4:
                likePostSubMenu();
                break;
            case 5:
                messageSubMenu();
                break;
            case 6:
                photoSubMenu();
                break;
            case 7:
                postSubMenu();
                break;
            case 8:
                securitySubMenu();
                break;
            case 9:
                storySubMenu();
                break;
            default:
                System.out.println("Exiting");
        }
    }

    public void showMenu() {
        System.out.println("\n");
        System.out.println("Choose what to edit: ");
        System.out.println("1: User");
        System.out.println("2: Comment");
        System.out.println("3: Like Comment");
        System.out.println("4: Like Post");
        System.out.println("5: Message");
        System.out.println("6: Photo");
        System.out.println("7: Post");
        System.out.println("8: Security");
        System.out.println("9: Story");
        System.out.println("0: Exit");
    }

    public void userSubMenu() throws SQLException, ParseException {
        System.out.println("Enter next action:");
        System.out.println("1:  Find all users:");
        System.out.println("2:  Find user by ID:");
        System.out.println("3:  Create new user:");
        System.out.println("4:  Update user:");
        System.out.println("5:  Delete user by ID:");
        System.out.println("0:  Go back to main menu:");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                System.out.println("All users:");
                for (String[] user : controller.findAllUser()) {
                    System.out.println(Arrays.toString(user));
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter user id:");
                System.out.println(controller.findUserById(new Scanner(System.in).nextInt()));
                interactMenu();
                break;
            case 3:
                User user = new User();
                System.out.println("Enter followers count: ");
                user.setFollowers(new Scanner(System.in).nextInt());
                System.out.println("Enter followings count: ");
                user.setFollowings(new Scanner(System.in).nextInt());
                System.out.println("Enter description: ");
                user.setDescription(new Scanner(System.in).nextLine());
                System.out.println("Enter email: ");
                user.setEmail(new Scanner(System.in).nextLine());
                System.out.println("Enter phone number: ");
                user.setPhoneNumber(new Scanner(System.in).nextLine());
                System.out.println("Enter mention: ");
                user.setMention(new Scanner(System.in).nextLine());

                controller.createUser(user);
                interactMenu();
                break;
            case 4:
                user = new User();
                System.out.print("Enter id: ");
                user.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter followers count: ");
                user.setFollowers(new Scanner(System.in).nextInt());
                System.out.println("Enter followings count: ");
                user.setFollowings(new Scanner(System.in).nextInt());
                System.out.println("Enter description: ");
                user.setDescription(new Scanner(System.in).nextLine());
                System.out.println("Enter email: ");
                user.setEmail(new Scanner(System.in).nextLine());
                System.out.println("Enter phone number: ");
                user.setPhoneNumber(new Scanner(System.in).nextLine());
                System.out.println("Enter mention: ");
                user.setMention(new Scanner(System.in).nextLine());

                controller.updateUser(user);
                interactMenu();
                break;
            case 5:
                user = new User();
                System.out.print("Enter id: ");
                user.setId(new Scanner(System.in).nextInt());
                controller.deleteUser(user.getId());
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    public void commentSubMenu() throws SQLException, ParseException {
        System.out.println("Enter next action:");
        System.out.println("1:  Find all comments:");
        System.out.println("2:  Find comment by ID:");
        System.out.println("3:  Create new comment:");
        System.out.println("4:  Update comment:");
        System.out.println("5:  Delete comment by ID:");
        System.out.println("0:  Go back to main menu:");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                System.out.println("All comments:");
                for (String[] comment : controller.findAllComment()) {
                    System.out.println(Arrays.toString(comment));
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter comment id:");
                System.out.println(controller.findCommentById(new Scanner(System.in).nextInt()));
                interactMenu();
                break;
            case 3:
                Comment comment = new Comment();
                System.out.println("Enter comment text: ");
                comment.setText(new Scanner(System.in).nextLine());
                System.out.println("Enter post id: ");
                comment.setPostId(new Scanner(System.in).nextInt());
                System.out.println("Enter date of comment: ");
                comment.setDateComment(java.sql.Timestamp.valueOf(new Scanner(System.in).nextLine()));

                controller.createComment(comment);
                interactMenu();
                break;
            case 4:
                comment = new Comment();
                System.out.println("Enter comment text: ");
                comment.setText(new Scanner(System.in).nextLine());
                System.out.println("Enter post id: ");
                comment.setPostId(new Scanner(System.in).nextInt());
                System.out.println("Enter date of comment: ");
                comment.setDateComment(java.sql.Timestamp.valueOf(new Scanner(System.in).nextLine()));

                controller.updateComment(comment);
                interactMenu();
                break;
            case 5:
                comment = new Comment();
                System.out.print("Enter id: ");
                comment.setId(new Scanner(System.in).nextInt());
                controller.deleteComment(comment.getId());
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
    public void likeCommentSubMenu() throws SQLException, ParseException {
        System.out.println("Enter next action:");
        System.out.println("1:  Find all like for comment:");
        System.out.println("2:  Find like for comment by ID:");
        System.out.println("3:  Create new like for comment:");
        System.out.println("4:  Update like for comment:");
        System.out.println("5:  Delete like for comment by ID:");
        System.out.println("0:  Go back to main menu:");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                System.out.println("All likes of comments:");
                for (String[] likeComment : controller.findAllLikeComment()) {
                    System.out.println(Arrays.toString(likeComment));
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter like for comment id:");
                System.out.println(controller.findLikeCommentById(new Scanner(System.in).nextInt()));
                interactMenu();
                break;
            case 3:
                LikeComment likeComment = new LikeComment();
                System.out.println("Enter like for comment id: ");
                likeComment.setCommentId(new Scanner(System.in).nextInt());
                controller.createLikeComment(likeComment);
                interactMenu();
                break;
            case 4:
                likeComment = new LikeComment();
                System.out.println("Enter like for comment id: ");
                likeComment.setCommentId(new Scanner(System.in).nextInt());
                controller.updateLikeComment(likeComment);
                interactMenu();
                break;
            case 5:
                likeComment = new LikeComment();
                System.out.print("Enter id: ");
                likeComment.setId(new Scanner(System.in).nextInt());
                controller.deleteLikeComment(likeComment.getId());
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
    public void likePostSubMenu() throws SQLException, ParseException {
        System.out.println("Enter next action:");
        System.out.println("1:  Find all like for post:");
        System.out.println("2:  Find like for post by ID:");
        System.out.println("3:  Create new like for post:");
        System.out.println("4:  Update like for post:");
        System.out.println("5:  Delete like for post by ID:");
        System.out.println("0:  Go back to main menu:");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                System.out.println("All likes for post:");
                for (String[] likePost : controller.findAllLikePost()) {
                    System.out.println(Arrays.toString(likePost));
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter like for post id:");
                System.out.println(controller.findLikePostById(new Scanner(System.in).nextInt()));
                interactMenu();
                break;
            case 3:
                LikePost likePost = new LikePost();
                System.out.println("Enter post id: ");
                likePost.setPostId(new Scanner(System.in).nextInt());
                System.out.println("Enter date of like for post: ");
                likePost.setTimeCreationLike(java.sql.Timestamp.valueOf(new Scanner(System.in).nextLine()));

                controller.createLikePost(likePost);
                interactMenu();
                break;
            case 4:
                likePost = new LikePost();
                System.out.println("Enter post id: ");
                likePost.setPostId(new Scanner(System.in).nextInt());
                System.out.println("Enter date of like for post: ");
                likePost.setTimeCreationLike(java.sql.Timestamp.valueOf(new Scanner(System.in).nextLine()));

                controller.updateLikePost(likePost);
                interactMenu();
                break;
            case 5:
                likePost = new LikePost();
                System.out.print("Enter id: ");
                likePost.setId(new Scanner(System.in).nextInt());
                controller.deleteLikePost(likePost.getId());
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
    public void messageSubMenu() throws SQLException, ParseException {
        System.out.println("Enter next action:");
        System.out.println("1:  Find all messages:");
        System.out.println("2:  Find message by ID:");
        System.out.println("3:  Create new message:");
        System.out.println("4:  Update message:");
        System.out.println("5:  Delete message by ID:");
        System.out.println("0:  Go back to main menu:");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                System.out.println("All messages:");
                for (String[] message : controller.findAllMessage()) {
                    System.out.println(Arrays.toString(message));
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter message id:");
                System.out.println(controller.findMessageById(new Scanner(System.in).nextInt()));
                interactMenu();
                break;
            case 3:
                Message message = new Message();
                System.out.println("Enter message id: ");
                message.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter text of message: ");
                message.setTextMessage(new Scanner(System.in).nextLine());
                System.out.println("Enter date of message: ");
                message.setTimeCreation(java.sql.Timestamp.valueOf(new Scanner(System.in).nextLine()));
                System.out.println("Enter time seen of message: ");
                message.setTimeSeen(java.sql.Timestamp.valueOf(new Scanner(System.in).nextLine()));

                controller.createMessage(message);
                interactMenu();
                break;
            case 4:
                message = new Message();
                System.out.println("Enter message id: ");
                message.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter text of message: ");
                message.setTextMessage(new Scanner(System.in).nextLine());
                System.out.println("Enter date of message: ");
                message.setTimeCreation(java.sql.Timestamp.valueOf(new Scanner(System.in).nextLine()));
                System.out.println("Enter time seen of message: ");
                message.setTimeSeen(java.sql.Timestamp.valueOf(new Scanner(System.in).nextLine()));

                controller.updateMessage(message);
                interactMenu();
                break;
            case 5:
                message = new Message();
                System.out.print("Enter id: ");
                message.setId(new Scanner(System.in).nextInt());
                controller.deleteMessage(message.getId());
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
    public void photoSubMenu() throws SQLException, ParseException {
        System.out.println("Enter next action:");
        System.out.println("1:  Find all photos:");
        System.out.println("2:  Find photo by ID:");
        System.out.println("3:  Create new photo:");
        System.out.println("4:  Update photo:");
        System.out.println("5:  Delete photo by ID:");
        System.out.println("0:  Go back to main menu:");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                System.out.println("All photos:");
                for (String[] photo : controller.findAllPhoto()) {
                    System.out.println(Arrays.toString(photo));
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter photo id:");
                System.out.println(controller.findPhotoById(new Scanner(System.in).nextInt()));
                interactMenu();
                break;
            case 3:
                Photo photo = new Photo();
                System.out.println("Enter photo id: ");
                photo.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter photo: ");
                photo.setPhoto(new Scanner(System.in).nextByte());
                System.out.println("Enter post id: ");
                photo.setPostId(new Scanner(System.in).nextInt());
                System.out.println("Enter story id: ");
                photo.setStoryId(new Scanner(System.in).nextInt());

                controller.createPhoto(photo);
                interactMenu();
                break;
            case 4:
                photo = new Photo();
                System.out.println("Enter photo id: ");
                photo.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter photo: ");
                photo.setPhoto(new Scanner(System.in).nextByte());
                System.out.println("Enter post id: ");
                photo.setPostId(new Scanner(System.in).nextInt());
                System.out.println("Enter story id: ");
                photo.setStoryId(new Scanner(System.in).nextInt());

                controller.updatePhoto(photo);
                interactMenu();
                break;
            case 5:
                photo = new Photo();
                System.out.print("Enter id: ");
                photo.setId(new Scanner(System.in).nextInt());
                controller.deletePhoto(photo.getId());
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
    public void postSubMenu() throws SQLException, ParseException {
        System.out.println("Enter next action:");
        System.out.println("1:  Find all posts:");
        System.out.println("2:  Find post by ID:");
        System.out.println("3:  Create new post:");
        System.out.println("4:  Update post:");
        System.out.println("5:  Delete post by ID:");
        System.out.println("0:  Go back to main menu:");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                System.out.println("All posts:");
                for (String[] photo : controller.findAllPhoto()) {
                    System.out.println(Arrays.toString(photo));
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter post id:");
                System.out.println(controller.findPostById(new Scanner(System.in).nextInt()));
                interactMenu();
                break;
            case 3:
                Post post = new Post();
                System.out.println("Enter post id: ");
                post.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter user id: ");
                post.setUserId(new Scanner(System.in).nextInt());
                System.out.println("Enter text: ");
                post.setText(new Scanner(System.in).nextLine());
                System.out.println("Enter photo: ");
                post.setPhoto(new Scanner(System.in).nextByte());

                controller.createPost(post);
                interactMenu();
                break;
            case 4:
                post = new Post();
                System.out.println("Enter post id: ");
                post.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter user id: ");
                post.setUserId(new Scanner(System.in).nextInt());
                System.out.println("Enter text: ");
                post.setText(new Scanner(System.in).nextLine());
                System.out.println("Enter photo: ");
                post.setPhoto(new Scanner(System.in).nextByte());

                controller.updatePost(post);
                interactMenu();
                break;
            case 5:
                post = new Post();
                System.out.print("Enter id: ");
                post.setId(new Scanner(System.in).nextInt());
                controller.deletePost(post.getId());
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
    public void securitySubMenu() throws SQLException, ParseException {
        System.out.println("Enter next action:");
        System.out.println("1:  Find all security:");
        System.out.println("2:  Find security by ID:");
        System.out.println("3:  Create new security:");
        System.out.println("4:  Update security:");
        System.out.println("5:  Delete security by ID:");
        System.out.println("0:  Go back to main menu:");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                System.out.println("All security:");
                for (String[] security : controller.findAllSecurity()) {
                    System.out.println(Arrays.toString(security));
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter security id:");
                System.out.println(controller.findSecurityById(new Scanner(System.in).nextInt()));
                interactMenu();
                break;
            case 3:
                Security security = new Security();
                System.out.println("Enter security id: ");
                security.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter user id: ");
                security.setUserId(new Scanner(System.in).nextInt());
                System.out.println("Enter nickname: ");
                security.setNickname(new Scanner(System.in).nextLine());
                System.out.println("Enter password: ");
                security.setPassword(new Scanner(System.in).nextLine());

                controller.createSecurity(security);
                interactMenu();
                break;
            case 4:
                security = new Security();
                System.out.println("Enter security id: ");
                security.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter user id: ");
                security.setUserId(new Scanner(System.in).nextInt());
                System.out.println("Enter nickname: ");
                security.setNickname(new Scanner(System.in).nextLine());
                System.out.println("Enter password: ");
                security.setPassword(new Scanner(System.in).nextLine());

                controller.updateSecurity(security);
                interactMenu();
                break;
            case 5:
                security = new Security();
                System.out.print("Enter id: ");
                security.setId(new Scanner(System.in).nextInt());
                controller.deleteSecurity(security.getId());
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
    public void storySubMenu() throws SQLException, ParseException {
        System.out.println("Enter next action:");
        System.out.println("1:  Find all stories:");
        System.out.println("2:  Find story by ID:");
        System.out.println("3:  Create new story:");
        System.out.println("4:  Update story:");
        System.out.println("5:  Delete story by ID:");
        System.out.println("0:  Go back to main menu:");

        int choice = new Scanner(System.in).nextInt();

        switch (choice) {
            case 1:
                System.out.println("All stories:");
                for (String[] story : controller.findAllStory()) {
                    System.out.println(Arrays.toString(story));
                }
                interactMenu();
                break;
            case 2:
                System.out.println("Enter story id:");
                System.out.println(controller.findStoryById(new Scanner(System.in).nextInt()));
                interactMenu();
                break;
            case 3:
                Story story = new Story();
                System.out.println("Enter story id: ");
                story.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter user id: ");
                story.setUserId(new Scanner(System.in).nextInt());
                System.out.println("Enter nickname: ");
                story.setReactions(new Scanner(System.in).nextLine());

                controller.createStory(story);
                interactMenu();
                break;
            case 4:
                story = new Story();
                System.out.println("Enter story id: ");
                story.setId(new Scanner(System.in).nextInt());
                System.out.println("Enter user id: ");
                story.setUserId(new Scanner(System.in).nextInt());
                System.out.println("Enter nickname: ");
                story.setReactions(new Scanner(System.in).nextLine());

                controller.updateStory(story);
                interactMenu();
                break;
            case 5:
                story = new Story();
                System.out.print("Enter id: ");
                story.setId(new Scanner(System.in).nextInt());
                controller.deleteStory(story.getId());
                interactMenu();
                break;
            case 0:
                interactMenu();
                break;
            default:
                System.out.println("Invalid input!");
        }
    }
}