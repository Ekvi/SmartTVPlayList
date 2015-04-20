<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
    <items>
        <c:forEach items="${categories}" var="category">
            <channel>
                <title><![CDATA[${category.name}]]></title><buffer>20</buffer>
                <playlist_url>![CDATA[http://localhost:8080/video?url=${category.siteName}&category=${category.name}]]</playlist_url>
                <description><![CDATA[<center>${category.name}</center>]]></description>
            </channel>
        </c:forEach>
    </items>
</body>
</html>
