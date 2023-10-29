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
<h1><a href="/" >BUYSELL</a></h1><hr>
<h3>Информация о пользователе</h3>
<b>Имя:</b>             ${user.name}<br>
<b>Номер телефона:</b>  ${user.numberPhone}<br>
<b>Email:</b>           ${user.email}<br>
<h4>Товары пользователя</h4>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.prise} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Пока товаров нет</h3>
</#list>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>