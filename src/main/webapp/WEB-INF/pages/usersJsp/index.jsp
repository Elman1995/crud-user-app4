<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Manager</title>
</head>
<body>

<div align="center">
    <h2>User Manager</h2>
    <h3><a href="new">New user</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>E-mail</th>
            <th>Action</th>
        </tr>
        <th:block th:each="user : ${users}">
            <tr>
                <td th:text="${{user.getId()}}">user</td>
                <td th:text="${{user.getFirstName()}}">user</td>
                <td th:text="${{user.getLastName()}}">user</td>
                <td th:text="${{user.getEmail()}}">user</td>
                <td>
                    <form th:action="@{/users/{id}/edit(id=${user.getId()})}">
                        <input type="submit" value="Edit"/>
                    </form>
                    <form th:method="DELETE" th:action="@{/users/{id}(id=${user.getId()})}">
                        <input type="submit" value="Delete"/>
                    </form>
                </td>
            </tr>
        </th:block>

    </table>
</div>

</body>
</html>