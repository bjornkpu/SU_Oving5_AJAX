<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  Cookie[] cookies = request.getCookies();
  Cookie cookie = null;
  for(Cookie c : cookies) {
      if(c.getName().equals("search")) {
          cookie = c;
      }
  }
  String s = cookie==null?"":cookie.getValue();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        S�k:
        <form action="s�k.jsp">
            <input name="search" type="text" value="<%= s %>">
            <input type="submit" value="S�k">
        </form>
    </body>
</html>