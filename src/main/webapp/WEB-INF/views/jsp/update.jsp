<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



</head>
<body>
    <jsp:include page="header.jsp" />
    <mvc:form action="process-update" id="add-form" method="post" modelAttribute="book">
        <div class="wrapper-update-form wrapper-form add-form">
            <div class='head-form d-flex'>
                <div class='title d-flex'>
                    <div style='flex-shrink: 0; margin-right: 10px;'>Update Book</div>
                    <label for="id">Id:</label>
                    <mvc:input class='id-input' path='id' type='text' role='spinbutton' value='${updatedBook.getId()}'
                               style='background-color: #fff; display:none; border: none; width: 20px;'/>

                </div>
            </div>
            <div class='main-form'>
                <label for="name">Name:</label>
                <mvc:input class='name' type='text' placeholder='Book Name' value='${updatedBook.getName()}' path='name'/>
                <form:errors path="name"/>
                <div class='padding-bottom'></div>

                <label for="author">Author:</label>
                <mvc:input class='author' type='text' placeholder='Book Author' value='${updatedBook.getAuthor()}' path='author'/>
                <form:errors path="author"/>
                <div class='padding-bottom'></div>

                <label for="isbn">Isbn:</label>
                <mvc:input class='isbn' type='text' placeholder='Book Isbn' value='${updatedBook.getBookDetails().getIsbn()}' path='bookDetails.isbn'/>

                <div class='padding-bottom'></div>

                <label for="price">Price:</label>
                <mvc:input class='price' type='text' placeholder='Book Price' value='${updatedBook.getBookDetails().getPrice()}' path='bookDetails.price'/>


                <div class='padding-bottom'></div>

                 <label for="publish-date">Publish Date:</label>
                <mvc:input class='publish-date' type='date' placeholder='Publish Date' value='${updatedBook.getBookDetails().getPublishDate()}'
                           path='bookDetails.publishDate'/>
                <div class='padding-bottom'></div>
                <label for="number-of-pages">Number of pages:</label>
                <mvc:input class='number-of-pages' type='number' placeholder='Number Of Page' value='${updatedBook.getBookDetails().getNumberOfPage()}'
                           path='bookDetails.numberOfPage'/>

                <div class='padding-bottom'></div>
                <label for="category">Category:</label>
                <mvc:select path="category.id" class="category">
                    <mvc:option value="0" label="${updatedBook.getCategory().getName()}"/>
                    <mvc:options items="${categoryList}"/>
                </mvc:select>
                <mvc:errors path="category.id" cssClass="error"/>
                <div class='padding-bottom'></div>
                <button class='update-btn'> Update</button>
            </div>
        </div>
    </mvc:form>

</body>
</html>