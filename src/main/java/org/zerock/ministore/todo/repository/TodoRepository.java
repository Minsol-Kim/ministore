package org.zerock.ministore.todo.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.zerock.ministore.todo.dto.TodoDTO;
import org.zerock.ministore.todo.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo,Long>,TodoSearch {

    //Long tno, String title, String writer, LocalDateTime regDate, LocalDateTime modDate
    @Query("select new org.zerock.ministore.todo.dto.TodoDTO(t.tno, t.title, t.writer, t.regDate, t.modDate) from Todo  t ")
    java.util.List<TodoDTO> getListDTO(Pageable pageable);


}
