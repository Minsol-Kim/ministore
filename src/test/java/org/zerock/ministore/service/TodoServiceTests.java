package org.zerock.ministore.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.zerock.ministore.todo.repository.TodoRepository;

@SpringBootTest
@Log4j2
public class TodoServiceTests {

    @Autowired
    private TodoRepository repo;

    @Test
    public void test1() {

        Pageable pageable = PageRequest.of(0, 10);

        repo.getListDTO(pageable).forEach(System.out::println);

    }
}
