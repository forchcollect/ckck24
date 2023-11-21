package org.zerock.ch4.mapper;

import org.zerock.ch4.domain.TodoVO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();
}
