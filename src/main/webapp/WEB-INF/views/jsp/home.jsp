<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



</head>
<body>
    <div class="body-wrapper">
        <jsp:include page="header.jsp" />

            <h2 style="text-align:center">LIST OF BOOKS</h2>
            <table class="table caption-top">

              <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Name</th>
                 <th scope="col">Author</th>
                 <th scope="col">ISBN</th>
                 <th scope="col">Price</th>
                 <th scope="col">Publish Date</th>
                 <th scope="col">Category</th>
                 <th scope="col">Actions</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${list}" var="book">

                    <tr>
                      <th scope="row">${book.id}</th>
                      <td>${book.name}</td>
                      <td>${book.author}</td>
                      <td>${book.bookDetails.isbn}</td>
                      <td>${book.bookDetails.price}</td>
                      <td>${book.bookDetails.publishDate}</td>
                      <td>${book.category.name}</td>
                      <td>
                        <div style="display:flex;">
                            <div class="green-text-button" style="margin-right:10px; padding: 1px 5px 1px 5px;"><a style="text-decoration:none;color:green;" href="./update/${book.getId()}">Update</a></div>
                            <div class="green-text-button" style="margin-right:30px; padding: 1px 5px 1px 5px;"><a style="text-decoration:none;color:green;" href="./delete/${book.getId()}">Delete</a></div>
                        </div>
                      </td>
                    </tr>
                </c:forEach>

              </tbody>
            </table>



            <script src="<c:url value="resources/js/script.js"/>"></script>
    </div>

</body>
</html>