package org.zerock.ministore.todo.service;

import org.springframework.data.domain.Pageable;
import org.zerock.ministore.todo.dto.PageRequestDTO;
import org.zerock.ministore.todo.dto.PageResponseDTO;
import org.zerock.ministore.todo.dto.TodoDTO;
import org.zerock.ministore.todo.entities.Todo;

import java.util.List;

public interface TodoService {


    List<TodoDTO> getList(Pageable pageable);

    Long register(TodoDTO todoDTO);

    TodoDTO get(Long tno);


}
