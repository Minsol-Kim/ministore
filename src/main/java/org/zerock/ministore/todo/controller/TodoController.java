package org.zerock.ministore.todo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.ministore.todo.dto.PageRequestDTO;
import org.zerock.ministore.todo.dto.PageResponseDTO;
import org.zerock.ministore.todo.dto.TodoDTO;
import org.zerock.ministore.todo.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")

public class TodoController {

    private final TodoService todoService;

    @GetMapping("/list")
    public ResponseEntity<List<TodoDTO>> getList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        List<TodoDTO> list = todoService.getList(pageable);

        return ResponseEntity.ok(list);
    }

    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody TodoDTO todoDTO) {
        Long tno = todoService.register(todoDTO);
        return ResponseEntity.ok(tno); // 등록된 ID 반환
    }

    @GetMapping("list/{tno}")
    public ResponseEntity<TodoDTO> get(@PathVariable("tno") Long tno) {
        TodoDTO dto = todoService.get(tno);
        return ResponseEntity.ok(dto);
    }

}


