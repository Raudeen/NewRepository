<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>BUYSELL</h1>
<#list products as product >
    <div>
        <p><b>${product.title}</b> ${product.prise} | <a href="/product/${product.id}">Подробнее...</a> </p>
    </div>
</#list>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
    Название обьявления: <input type="text", name="title"><br><br>
    Описание обьявления: <input type="text", name="description"><br><br>
    Цена обьявления: <input type="number", name="prise"><br><br>
    Город обьявления: <input type="text", name="city"><br><br>
    Имя продавца: <input type="text", name="author"><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>