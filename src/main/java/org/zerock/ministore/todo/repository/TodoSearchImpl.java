package org.zerock.ministore.todo.repository;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.zerock.ministore.todo.entities.QTodo;
import org.zerock.ministore.todo.entities.Todo;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
public class TodoSearchImpl implements TodoSearch{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Todo> list(Pageable pageable) {

        log.info("list.......................");
        log.info(jpaQueryFactory);

        QTodo todo = QTodo.todo;

        JPQLQuery<Todo> query = jpaQueryFactory.selectFrom(todo);

        int size = pageable.getPageSize();
        int offset = pageable.getPageNumber() * size;

        query.limit(pageable.getPageSize());
        query.offset(offset);
        query.orderBy(new OrderSpecifier<>(Order.DESC, todo.tno));

        List<Todo> list = query.fetch();

        return list;
    }


}
