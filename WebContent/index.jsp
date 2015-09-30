<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Session Attributes</title>
    <link rel="stylesheet" href="assets/bootstrap.min.css">
    <style type="text/css">
        body {
            padding: 1em;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>PoC REDIS</h1>
        <p>Esta aplicación es un ejemplo del uso de Redis para la externalización de sesión. No se utiliza JSESSIONID cookie. Se puede configurar el modo de identificación de la cookie.</p>

        <h1>Haz la prueba!</h1>

        <form class="form-inline" role="form" action="./session" method="post">
            <label for="attributeValue">Nombre Atributo</label>
            <input id="attributeValue" type="text" name="attributeName"/>
            <label for="attributeValue">Valor Atributo</label>
            <input id="attributeValue" type="text" name="attributeValue"/>
            <input type="submit" value="Set Attribute"/>
        </form>

        <hr/>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Nombre Atributo</th>
                <th>Valor</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope}" var="attr">
                <tr>
                    <td><c:out value="${attr.key}"/></td>
                    <td><c:out value="${attr.value}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
