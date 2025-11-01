package ru.itis.dis403.kontrol_work.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.dis403.kontrol_work.model.BoardGame;
import ru.itis.dis403.kontrol_work.repository.BoardGameRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/showone")
public class ShowOneServlet extends HttpServlet {
    private static final BoardGameRepository boardGameRepository = new BoardGameRepository();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardGame boardGame = boardGameRepository.findById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("boardGame", boardGame);
        req.getRequestDispatcher("/show-one.ftlh").forward(req, resp);
    }
}
