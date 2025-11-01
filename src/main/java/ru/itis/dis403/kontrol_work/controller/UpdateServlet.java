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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final BoardGameRepository boardGameRepository = new BoardGameRepository();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardGame boardGame = new BoardGame();
        boardGame.setId(Long.parseLong(req.getParameter("id")));
        boardGame.setTitle(req.getParameter("title"));
        boardGame.setCategory(req.getParameter("category"));
        boardGame.setMinPlayers(Integer.parseInt(req.getParameter("minPlayers")));
        boardGame.setMaxPlayers(Integer.parseInt(req.getParameter("maxPlayers")));
        boardGame.setPlaytimeMinutes(Integer.parseInt(req.getParameter("playtimeMinutes")));

        boardGameRepository.update(boardGame);
        resp.sendRedirect(req.getContextPath() + "/show");
    }
}
