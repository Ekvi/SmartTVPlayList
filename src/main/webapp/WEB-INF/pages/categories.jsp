<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>


    <table class="table table-bordered table-hover table-striped">
        <channel>
            <logo_30x30><![CDATA[http://fs207.www.ex.ua/show/159240487/159240487.jpg?100]]></logo_30x30>
            <title><![CDATA[От всего сердца / All of My Heart (2015) HDTVRip]]></title>
            <playlist_url><![CDATA[http://getlist3.obovse.ru/smarttv/wwwex.php?viewkey=%2F89021220%3Fr%3D2%2C23775%26rv%3D1-0&title=%D0%9E%D1%82+%D0%B2%D1%81%D0%B5%D0%B3%D0%BE+%D1%81%D0%B5%D1%80%D0%B4%D1%86%D0%B0+%2F+All+of+My+Heart+%282015%29+HDTVRip]]></playlist_url>
            <description><![CDATA[<div id="poster" style="float:left;padding:4px;	background-color:#EEEEEE;margin:0px 13px 1px 0px;"><img src="http://fs207.www.ex.ua/show/159240487/159240487.jpg?100" style="width:180px;float:left;" /></div><font color="#3090F0"><b>Название</font>: От всего сердца<br>Оригинальное: All of My Heart<br><font color="#3090F0">Производство</font>: США, Канада, Better Road Productions, Front Street Pictures, The Hallmark Channel<br>Жанр: Мелодрама, Комедия<br>...<br>Отзывов: 1&nbsp;]]></description>
        </channel>
        <c:forEach items="${list}" var="l">
            <tr>
                <td>
                    <channel>
                        <logo_30x30><![CDATA[http://fs207.www.ex.ua/show/159240487/159240487.jpg?100]]></logo_30x30>
                        <title><![CDATA[От всего сердца / All of My Heart (2015) HDTVRip]]></title>
                        <playlist_url><![CDATA[http://getlist3.obovse.ru/smarttv/wwwex.php?viewkey=%2F89021220%3Fr%3D2%2C23775%26rv%3D1-0&title=%D0%9E%D1%82+%D0%B2%D1%81%D0%B5%D0%B3%D0%BE+%D1%81%D0%B5%D1%80%D0%B4%D1%86%D0%B0+%2F+All+of+My+Heart+%282015%29+HDTVRip]]></playlist_url>
                        <description><![CDATA[<div id="poster" style="float:left;padding:4px;	background-color:#EEEEEE;margin:0px 13px 1px 0px;"><img src="http://fs207.www.ex.ua/show/159240487/159240487.jpg?100" style="width:180px;float:left;" /></div><font color="#3090F0"><b>Название</font>: От всего сердца<br>Оригинальное: All of My Heart<br><font color="#3090F0">Производство</font>: США, Канада, Better Road Productions, Front Street Pictures, The Hallmark Channel<br>Жанр: Мелодрама, Комедия<br>...<br>Отзывов: 1&nbsp;]]></description>
                    </channel>
                        ${l}
                    <%--<channel>
                        &lt;%&ndash;<logo_30x30><![CDATA[http://fs207.www.ex.ua/show/159240487/159240487.jpg?100]]></logo_30x30>&ndash;%&gt;
                        <title><![CDATA[${l}]]></title>
                        &lt;%&ndash;<playlist_url><![CDATA[http://getlist3.obovse.ru/smarttv/wwwex.php?viewkey=%2F89021220%3Fr%3D2%2C23775%26rv%3D1-0&title=%D0%9E%D1%82+%D0%B2%D1%81%D0%B5%D0%B3%D0%BE+%D1%81%D0%B5%D1%80%D0%B4%D1%86%D0%B0+%2F+All+of+My+Heart+%282015%29+HDTVRip]]></playlist_url>
                        <description><![CDATA[<div id="poster" style="float:left;padding:4px;	background-color:#EEEEEE;margin:0px 13px 1px 0px;"><img src="http://fs207.www.ex.ua/show/159240487/159240487.jpg?100" style="width:180px;float:left;" /></div><font color="#3090F0"><b>Название</font>: От всего сердца<br>Оригинальное: All of My Heart<br><font color="#3090F0">Производство</font>: США, Канада, Better Road Productions, Front Street Pictures, The Hallmark Channel<br>Жанр: Мелодрама, Комедия<br>...<br>Отзывов: 1&nbsp;]]></description>&ndash;%&gt;
                    </channel>--%>
                </td>
                <%--<td>${user.userName}</td>
                <td>${user.password}</td>
                <td>${user.registrationDate}</td>
                <td><a href="/showUsers/delete/${user.id}">delete</a></td>--%>
            </tr>
        </c:forEach>
    </table>
<c:forEach items="${users}" var="user">
    <channel>
        <logo_30x30><![CDATA[http://fs207.www.ex.ua/show/159240487/159240487.jpg?100]]></logo_30x30>
        <title><![CDATA[От всего сердца / All of My Heart (2015) HDTVRip]]></title>
        <playlist_url><![CDATA[http://getlist3.obovse.ru/smarttv/wwwex.php?viewkey=%2F89021220%3Fr%3D2%2C23775%26rv%3D1-0&title=%D0%9E%D1%82+%D0%B2%D1%81%D0%B5%D0%B3%D0%BE+%D1%81%D0%B5%D1%80%D0%B4%D1%86%D0%B0+%2F+All+of+My+Heart+%282015%29+HDTVRip]]></playlist_url>
        <description><![CDATA[<div id="poster" style="float:left;padding:4px;	background-color:#EEEEEE;margin:0px 13px 1px 0px;"><img src="http://fs207.www.ex.ua/show/159240487/159240487.jpg?100" style="width:180px;float:left;" /></div><font color="#3090F0"><b>Название</font>: От всего сердца<br>Оригинальное: All of My Heart<br><font color="#3090F0">Производство</font>: США, Канада, Better Road Productions, Front Street Pictures, The Hallmark Channel<br>Жанр: Мелодрама, Комедия<br>...<br>Отзывов: 1&nbsp;]]></description>
    </channel>
</c:forEach>
    <%--<channel>
        <logo_30x30><![CDATA[http://fs207.www.ex.ua/show/159240487/159240487.jpg?100]]></logo_30x30>
        <title><![CDATA[От всего сердца / All of My Heart (2015) HDTVRip]]></title>
        <playlist_url><![CDATA[http://getlist3.obovse.ru/smarttv/wwwex.php?viewkey=%2F89021220%3Fr%3D2%2C23775%26rv%3D1-0&title=%D0%9E%D1%82+%D0%B2%D1%81%D0%B5%D0%B3%D0%BE+%D1%81%D0%B5%D1%80%D0%B4%D1%86%D0%B0+%2F+All+of+My+Heart+%282015%29+HDTVRip]]></playlist_url>
        <description><![CDATA[<div id="poster" style="float:left;padding:4px;	background-color:#EEEEEE;margin:0px 13px 1px 0px;"><img src="http://fs207.www.ex.ua/show/159240487/159240487.jpg?100" style="width:180px;float:left;" /></div><font color="#3090F0"><b>Название</font>: От всего сердца<br>Оригинальное: All of My Heart<br><font color="#3090F0">Производство</font>: США, Канада, Better Road Productions, Front Street Pictures, The Hallmark Channel<br>Жанр: Мелодрама, Комедия<br>...<br>Отзывов: 1&nbsp;]]></description>
    </channel>--%>
</body>
</html>
