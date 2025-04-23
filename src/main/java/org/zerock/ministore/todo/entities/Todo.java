package org.zerock.ministore.todo.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name="tbl_todo")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter

public class Todo extends TimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;

    @Column(nullable = false, length = 300)
    private String title;


    private String writer;


}
