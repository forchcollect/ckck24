package org.zerock.jdbcex.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO tOdoDAO;

    @BeforeEach
    public void ready() {
        tOdoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(tOdoDAO.getTime());
    }

    @Test
    public void testInsert() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021,12,31))
                .build();

        tOdoDAO.insert(todoVO);

    }

    @Test
    public void testList() throws Exception {

        List<TodoVO> list = tOdoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));

    }

    @Test
    public void testSelectOne() throws Exception {

        Long tno = 1L;

        TodoVO vo = tOdoDAO.selectOne(tno);

        System.out.println(vo);

    }

    @Test
    public void testDeleteOne() throws Exception {

        Long tno = 6L;

        tOdoDAO.deleteOne(tno);

    }

    @Test
    public void testUpdate() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .tno(1L)
                .title("Update Title...")
                .dueDate(LocalDate.of(2021,12,31))
                .finished(true)
                .build();

        tOdoDAO.updateOne(todoVO);

    }

}
