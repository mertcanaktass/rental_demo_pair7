package com.etiya.rentaldemopair7.repositories;


import com.etiya.rentaldemopair7.entities.concreate.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer>{
    @Query("SELECT cm FROM Comment cm")
    List<Comment> findAllComment();

    @Query("SELECT cm.id FROM Comment cm")
    List<Integer> findAllCommentId();

    @Query("SELECT cm FROM Comment cm")
    List<Comment> sortAllComment(Sort sort);
}
