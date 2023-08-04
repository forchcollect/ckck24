package org.zerock.ch3.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.ch3.dto.TodoDTO;
import org.zerock.ch3.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", value = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long tno = Long.parseLong(req.getParameter("tno"));

        TodoDTO todoDTO = null;
        try {
            todoDTO = todoService.get(tno);

            log.info(todoDTO);

        //데이터 담기
        req.setAttribute("dto", todoDTO);

        req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("read error");
        }

    }
}
