package com.jueban.Repository;

import com.jueban.Entity.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BlogRepository extends CrudRepository<Blog,Long>{

    @Query("select b from Blog as b order by b.id desc")
    public List<Blog> findBlogs(Pageable pageable);

    @Query("select count(distinct b.id) from Blog as b")
    public Integer countBlog();
}
