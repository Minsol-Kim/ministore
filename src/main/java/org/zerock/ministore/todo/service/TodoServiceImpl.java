package org.zerock.ministore.todo.service;

import com.querydsl.jpa.JPQLQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.zerock.ministore.todo.dto.TodoDTO;

import org.zerock.ministore.todo.entities.Todo;
import org.zerock.ministore.todo.repository.TodoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@Log4j2
@RequiredArgsConstructor

public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;


    @Override
    public List<TodoDTO> getList(Pageable pageable) {
        List<Todo> entityList = repository.list(pageable);

        return entityList.stream()
                .map(todo -> TodoDTO.builder()
                        .tno(todo.getTno())
                        .title(todo.getTitle())
                        .writer(todo.getWriter())
                        .regDate(todo.getRegDate())
                        .modDate(todo.getModDate())
                        .build())
                .collect(Collectors.toList());
    }
    @Override
    public Long register(TodoDTO todoDTO) {
        Todo todo = Todo.builder()
                .title(todoDTO.getTitle())
                .writer(todoDTO.getWriter())
                .build();

        repository.save(todo);
        return todo.getTno();
    }


    @Override
    public TodoDTO get(Long tno) {
        Todo todo = repository.findById(tno)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        return TodoDTO.builder()
                .tno(todo.getTno())
                .title(todo.getTitle())
                .writer(todo.getWriter())
                .regDate(todo.getRegDate())
                .modDate(todo.getModDate())
                .build();
    }

    }





