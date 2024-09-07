package com.bisa.blog.repository;

import com.bisa.blog.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByBlogId(Long blogId);

}
