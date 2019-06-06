package com.physter.breakfest.service;

import com.physter.breakfest.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private List<CommentDto> commentList = new ArrayList<>();

    public void saveDto(CommentDto dto) {
        commentList.add(dto);
    }

    public List<CommentDto> getCommentList() {
        return  commentList;
    }


}
