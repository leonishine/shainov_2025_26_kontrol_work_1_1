package ru.itis.dis403.kontrol_work.repository;

import ru.itis.dis403.kontrol_work.model.BoardGame;
import ru.itis.dis403.kontrol_work.service.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardGameRepository {

    public List<BoardGame> findAll() {
        List<BoardGame> boardGames = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            //language="sql"
            String SQL = "SELECT id, title, category, min_players, max_players, playtime_minutes FROM board_game";
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        BoardGame boardGame = new BoardGame();
                        boardGame.setId(resultSet.getLong("id"));
                        boardGame.setTitle(resultSet.getString("title"));
                        boardGame.setCategory(resultSet.getString("category"));
                        boardGame.setMinPlayers(resultSet.getInt("min_players"));
                        boardGame.setMaxPlayers(resultSet.getInt("max_players"));
                        boardGame.setPlaytimeMinutes(resultSet.getInt("playtime_minutes"));
                        boardGames.add(boardGame);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return boardGames;
    }

    public BoardGame findById(long id) {
        BoardGame boardGame = new BoardGame();
        try (Connection connection = DBConnection.getConnection()) {
            //language="sql"
            String SQL = "SELECT title, category, min_players, max_players, playtime_minutes FROM board_game WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                preparedStatement.setLong(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        boardGame.setId(id);
                        boardGame.setTitle(resultSet.getString("title"));
                        boardGame.setCategory(resultSet.getString("category"));
                        boardGame.setMinPlayers(resultSet.getInt("min_players"));
                        boardGame.setMaxPlayers(resultSet.getInt("max_players"));
                        boardGame.setPlaytimeMinutes(resultSet.getInt("playtime_minutes"));
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return boardGame;
    }

    public void save(BoardGame boardGame) {
        try (Connection connection = DBConnection.getConnection()) {
            String SQLid = "select id from nextval('id_board_game_seq') as id";
            connection.setAutoCommit(false);
            Long id = null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLid)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        id = resultSet.getLong(1);
                    }
                }
            }

            if (id != null) {
                boardGame.setId(id);
            } else {
                throw new RuntimeException();
            }
            //language="sql"
            String SQL = "insert into board_game (id, title, category, min_players, max_players, playtime_minutes) values (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                preparedStatement.setLong(1, id);
                preparedStatement.setString(2, boardGame.getTitle());
                preparedStatement.setString(3, boardGame.getCategory());
                preparedStatement.setInt(4, boardGame.getMinPlayers());
                preparedStatement.setInt(5, boardGame.getMaxPlayers());
                preparedStatement.setInt(6, boardGame.getPlaytimeMinutes());
                preparedStatement.executeUpdate();
            }

            connection.commit();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(BoardGame boardGame) {
        try (Connection connection = DBConnection.getConnection()) {
            connection.setAutoCommit(false);
            long id = boardGame.getId();

            //language="sql"
            String SQL = "update board_game set title = ?, category = ?, min_players = ?, max_players = ?, playtime_minutes = ? where id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
                preparedStatement.setString(1, boardGame.getTitle());
                preparedStatement.setString(2, boardGame.getCategory());
                preparedStatement.setInt(3, boardGame.getMinPlayers());
                preparedStatement.setInt(4, boardGame.getMaxPlayers());
                preparedStatement.setInt(5, boardGame.getPlaytimeMinutes());
                preparedStatement.setLong(6, id);
                preparedStatement.executeUpdate();
            }

            connection.commit();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
