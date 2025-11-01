<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавление настольной игры</title>
    <meta name="description" content="Добавление настольной игры">

    <style>
    </style>
</head>

<body>

<div style="color:darkred"> ${errormessage!}</div>
<h1>Добавить новую настолку</h1>

<form action="/kw/update" method="post">
    <input type="hidden" name="id" value="${boardGame.id}">
    <div>
        <label>Название настолки</label>
        <input type="text" name="title" value="${boardGame.title}">
    </div>
    <div>
        <label>Категория</label>
        <input type="text" name="category" value="${boardGame.category}">
    </div>
    <div>
        <label>Минимальное число игроков</label>
        <input type="text" name="minPlayers" value="${boardGame.minPlayers}">
    </div>
    <div>
        <label>Максимальное число игроков</label>
        <input type="text" name="maxPlayers" value="${boardGame.maxPlayers}">
    </div>
    <div>
        <label>Примерное время игры</label>
        <input type="text" name="playtimeMinutes" value="${boardGame.playtimeMinutes}">
    </div>
    <input type="submit" value="Обновить">
</form>

<form action="/kw/" method="get">
    <input type="submit" value="На главную">
</form>
</body>
</html>