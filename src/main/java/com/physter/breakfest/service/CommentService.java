package com.physter.breakfest.service;

import com.physter.breakfest.dto.CommentDto;
import com.physter.breakfest.model.Comment;
import com.physter.breakfest.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void saveDto(Comment dto) {
        commentRepository.save(dto);
    }

    /**
     * @return
     */
    public Iterable<Comment> getComments() {
        return  commentRepository.findAll();
    }


}
