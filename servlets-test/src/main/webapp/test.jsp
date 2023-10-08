<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sum of Two Numbers</title>
</head>
<body>

<%
    // Checking if parameters are present and not empty
    if (request.getParameter("number1") != null && !request.getParameter("number1").isEmpty()
            && request.getParameter("number2") != null && !request.getParameter("number2").isEmpty()) {
        try {
            double number1 = Double.parseDouble(request.getParameter("number1"));
            double number2 = Double.parseDouble(request.getParameter("number2"));
            double sum = number1 + number2;
%>
<p>The sum of <%= number1 %> and <%= number2 %> is: <%= sum %></p>
<%
} catch (NumberFormatException e) {
%>
<p>Error: Please enter valid numbers!</p>
<%
        }
    }
%>

<form action="" method="post">
    <label for="number1">Number 1:</label>
    <input type="text" id="number1" name="number1"><br><br>

    <label for="number2">Number 2:</label>
    <input type="text" id="number2" name="number2"><br><br>

    <input type="submit" value="Sum">
</form>

</body>
</html>
