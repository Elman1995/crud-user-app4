<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New User</title>
</head>
<body>

<div align="center">
    <h2>Edit User</h2>
    <form th:method="PATCH" th:action="@{/users/{id} (id=${user.getId()})}" th:object="${user}">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name: </td>
                <td><input type="text" th:field="*{firstName}" id="firstName"></td>
            </tr>
            <tr>
                <td>Surname: </td>
                <td><input type="text" th:field="*{lastName}" id="lastName"></td>
            </tr>
            <tr>
                <td>E-mail: </td>
                <td><input type="text" th:field="*{email}" id="email"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update!"/></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
