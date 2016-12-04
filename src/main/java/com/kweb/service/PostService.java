package com.kweb.service;

import com.kweb.model.Board;
import com.kweb.model.Post;
import com.kweb.model.Repository.PostRepo;
import com.kweb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Service
public class PostService {
    private PostRepo postRepo;

    private BoardService boardService;
    private UserService userService;

    @Autowired
    public PostService(BoardService boardService, PostRepo postRepo) {
        this.boardService = boardService;
        this.postRepo = postRepo;
    }

    public Post writePost(long boardId, String title, String content) {
        Board board = boardService.getBoardById(boardId);

        if (board == null) {
            return null;
        }

        Post post = new Post();
        post.setAuthor(userService.getCurrentUser());
        post.setBoard(board);
        post.setTitle(title);
        post.setContent(content);

        postRepo.saveAndFlush(post);

        return post;
    }

    public boolean deletePost(long id){
        Post post = postRepo.findById(id);
        User user = userService.getCurrentUser();

        if (post == null || post.getAuthor().equals(user)) {
            return false;
        }

        postRepo.delete(post);
        return true;
    }

    public Set<Post> getPostsByBoardId(long boardId) {
        Board board = boardService.getBoardById(boardId);
        return board.getPosts();
    }

    public Set<Post> sarchPostsByTitle(String title) {
        return postRepo.findByTitleLike(title);
    }
}
