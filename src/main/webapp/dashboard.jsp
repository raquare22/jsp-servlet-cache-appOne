<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Dashboard</title>
</head>
<body>

<h2>Welcome, ${sessionScope.user}</h2>

<h3>Available Roles (From Cache)</h3>

<ul>
    <c:forEach var="entry" items="${roles}">
        <li>${entry.key} - ${entry.value}</li>
    </c:forEach>
</ul>

</body>
</html>
