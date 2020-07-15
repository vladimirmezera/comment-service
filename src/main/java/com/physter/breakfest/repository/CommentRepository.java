package com.physter.breakfest.repository;

import com.physter.breakfest.model.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
