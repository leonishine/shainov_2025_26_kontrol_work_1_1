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

@WebServlet("/show")
public class ShowAllServlet extends HttpServlet {
    private static final BoardGameRepository boardGameRepository = new BoardGameRepository();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BoardGame> boardGames = boardGameRepository.findAll();
        req.setAttribute("boardGames", boardGames);
        req.getRequestDispatcher("/show.ftlh").forward(req, resp);
    }
}
