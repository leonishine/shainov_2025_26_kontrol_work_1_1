<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Главная страница</title>
    <meta name="description" content="Главная страница">

    <style>
    </style>
</head>

<body>
<h1>Добро пожаловать на сайт по настолкам!</h1>
<form action="/kw/add" method="get">
    <input type="submit" value="Добавить настолку">
</form>

<form action="/kw/show" method="get">
    <input type="submit" value="Показать все настолки">
</form>

<form action="/kw/showone" method="get">
    <div>
        <label>Найти настолку по айди:</label>
        <input type="text" name="id">
    </div>
    <input type="submit" value="Найти">
</form>

</body>
</html>