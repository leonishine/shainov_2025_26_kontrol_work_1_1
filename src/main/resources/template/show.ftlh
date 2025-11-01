<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Таблица всех настольных игр</title>
    <meta name="description" content="Настольные игры">

    <style>
        body {
            font-family: sans-serif;
        }

        .tablo {
            display: flex;
            flex-direction: column;
            border: 1px solid #000;
            width: fit-content;
            border-collapse: collapse;
        }

        .tablo-row {
            display: flex;
            flex-direction: row;
        }

        .tablo-row > div {
            flex: 1 0 150px;
            padding: 6px 10px;
            border-right: 1px solid #000;
            border-bottom: 1px solid #000;
            box-sizing: border-box;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .tablo-row > div:last-child {
            border-right: none;
        }

        .tablo-row:last-child > div {
            border-bottom: none;
        }

        .tablo-head {
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Настольные игры</h1>

<div class="tablo">
    <div class="tablo-row tablo-head">
        <div>Айди настолки</div>
        <div>Название</div>
        <div>Категория</div>
        <div>Минимум игроков</div>
        <div>Максимум игроков</div>
        <div>Примерное время игры</div>
    </div>

    <#list boardGames as boardGame>
        <div class="tablo-row">
            <div>${boardGame.id}</div>
            <div>${boardGame.title}</div>
            <div>${boardGame.category}</div>
            <div>${boardGame.minPlayers}</div>
            <div>${boardGame.maxPlayers}</div>
            <div>${boardGame.playtimeMinutes}</div>
        </div>
    </#list>
</div>
<form action="/kw/" method="get">
    <input type="submit" value="На главную">
</form>
</body>
</html>
