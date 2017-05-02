<#ftl strip_whitespace = true>
<!DOCTYPE html>
<html>
    <head>
        <title>Товар</title>
        <meta charset="UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div style="padding: 10px">
            <h1>Печать</h1>
            <form action="/save" method="post">
                <#if (product.id)??>
                    <input name="id" type="hidden" value="${product.id}" />
                </#if>

                <div class="form-group">
                    <label for="sku">Адрес сайта</label>
                    <input id="sku" name="sku" type="text" class="form-control" value="${(product.sku)!}" />
                </div>
                <button type="submit" class="btn btn-primary">Распечатать</button>
                <a href="/" class="btn btn-default">Отмена</a>
            </form>
        </div>
    </body>
</html>
