package org.zerock.ch4.service;

import org.zerock.ch4.domain.TodoVO;
import org.zerock.ch4.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO todoDTO);

    List<TodoDTO> getAll();
}
