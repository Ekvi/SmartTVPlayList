<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Video PlayList</title>
</head>
<body>
    <items>
        <%--<next_page_url text="Далее"><![CDATA[http://obovse.ru/smarttv/wwwex.php?id=cat&n=training&c=&p=1]]></next_page_url>--%>
        <c:forEach items="${videos}" var="video">
            <channel><logo_30x30>![CDATA[${video.imageUrl}]]</logo_30x30>
                <title>![CDATA[${video.title}]></title>
                <playlist_url>![CDATA[http://localhost:8080/aboutVideo?name=${video.title}&site=${video.siteName}]</playlist_url>
                <description>![CDATA[${video.description}]></description>
            </channel>
        </c:forEach>
    </items>
</body>
</html>
