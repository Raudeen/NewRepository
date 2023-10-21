<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1>
<h4>Подбробная информация о товаре</h4>
<b>Название товара: </b>${product.title}
<b>Описание товара: </b>${product.description}
<b>Цена товара: </b>${product.prise}
<b>Город товара: </b>${product.city}
<b>Автор товара: </b>${product.author}

<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>

</body>
</html>