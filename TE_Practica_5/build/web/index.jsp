<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p align="right"> Administrador <a href="login.jsp">Salir</a></p>
        <h1 align="center">Blog de Salud</h1>
        
        <p><a href="Inicio?action=add">Nueva Entrada</a></p>
        <br>
        
        <c:forEach var="item" items="${avisos}">
            <p>${item.fechaformato}</p>
            <h3 align="center">${item.titulo}</h3>
            <p>${item.contenido}</p>
            <p align="right"><a href="Inicio?action=edit&id=${item.id}">Editar</a>
                <a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta Seguro?'))">Eliminar</a></p>
            <hr>
        </c:forEach>
    </body>
</html>
