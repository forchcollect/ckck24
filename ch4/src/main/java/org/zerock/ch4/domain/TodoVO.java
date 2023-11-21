package org.zerock.ch4.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoVO {


    private Long tno;
    private String title;
    private LocalDate dueDate;
    private String writer;
    private boolean finished;

}
