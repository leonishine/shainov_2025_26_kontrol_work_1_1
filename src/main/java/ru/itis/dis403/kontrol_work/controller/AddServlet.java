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

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private static final BoardGameRepository boardGameRepository = new BoardGameRepository();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add.ftlh").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardGame boardGame = new BoardGame();
        boardGame.setTitle(req.getParameter("title"));
        boardGame.setCategory(req.getParameter("category"));
        boardGame.setMinPlayers(Integer.parseInt(req.getParameter("minPlayers")));
        boardGame.setMaxPlayers(Integer.parseInt(req.getParameter("maxPlayers")));
        boardGame.setPlaytimeMinutes(Integer.parseInt(req.getParameter("playtimeMinutes")));

        boardGameRepository.save(boardGame);
        resp.sendRedirect(req.getContextPath() + "/show");
    }
}
