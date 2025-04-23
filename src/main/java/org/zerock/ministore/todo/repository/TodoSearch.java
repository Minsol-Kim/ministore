package org.zerock.ministore.todo.repository;

import org.springframework.data.domain.Pageable;
import org.zerock.ministore.todo.dto.PageRequestDTO;
import org.zerock.ministore.todo.dto.PageResponseDTO;
import org.zerock.ministore.todo.dto.TodoDTO;
import org.zerock.ministore.todo.entities.Todo;

import java.util.List;

public interface TodoSearch {

    List<Todo> list(Pageable pageable);
}
