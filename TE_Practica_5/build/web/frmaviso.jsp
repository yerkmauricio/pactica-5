<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><c:if test="${aviso.id == 0}">Nuevo </c:if>
            <c:if test="${aviso.id != 0}">Editar </c:if>
            Entrada
        </h1>
        <form action="Inicio" method="POST">
            <input type="hidden" name="id" value="${aviso.id}" />
            <table border="1" align="center" cellspacing="0" cellpadding="2">
                <tr>
                    <td>Fecha</td>
                    <td><input type="date" name="fecha" value="${aviso.fechasql}" /></td>
                </tr>
                <tr>
                    <td>Titulo</td>
                    <td><input type="text" name="titulo" value="${aviso.titulo}" size="42"/></td>
                </tr>
                <tr>
                    <td>Contenido</td>
                    <td><textarea name="contenido" rows="5" cols="40">
                        ${aviso.contenido}
                        </textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>
      
    </body>
</html>
