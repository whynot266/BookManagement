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
<div class="body-wrapper">
    <jsp:include page="header.jsp" />
    <mvc:form action="process-update" id="update-form" method="post" modelAttribute="book">
        <div class="wrapper-update-form wrapper-form update-form">
            <div class='head-form d-flex' style="display:flex;justify-content:center;">
                <div class='title'>
                    <h2 style='text-align:center;'>Update Book</h2>

                    <mvc:input path='id'
                               style='display:none;'/>
                    <mvc:input class='id-detail' path='bookDetails.id' role='spinbutton' type='text' value=''
                                               style='display:none'/>
                </div>
            </div>
            <div class='main-form'>


                  <div class="form-group row ">
                    <label for="colFormLabel" class="col-sm-2 col-form-label">Name</label>
                    <div class="col-sm-10">
                      <mvc:input class='name form-control' type='text' placeholder='Book Name' path='name'/>
                      <mvc:errors path="name"/>
                    </div>
                  </div>
                  <div class="form-group row">
                      <label for="colFormLabel" class="col-sm-2 col-form-label">Author</label>
                      <div class="col-sm-10">
                         <mvc:input class='author form-control' type='text' placeholder='Book Author' path='author'/>
                         <mvc:errors path="author"/>
                      </div>
                  </div>
                   <div class="form-group row">
                        <label for="colFormLabel" class="col-sm-2 col-form-label">ISBN</label>
                        <div class="col-sm-10">
                             <mvc:input class='isbn form-control' type='text' placeholder='Book Isbn' path='bookDetails.isbn'/>
                        </div>
                    </div>
                   <div class="form-group row">
                         <label for="colFormLabel" class="col-sm-2 col-form-label">Price</label>
                         <div class="col-sm-10">
                            <mvc:input class='price form-control' type='text' placeholder='Book Price' path='bookDetails.price'/>
                         </div>
                     </div>
                   <div class="form-group row">
                          <label for="colFormLabel" class="col-sm-2 col-form-label" >Publish Date</label>
                          <div class="col-sm-10">
                             <mvc:input class='publish-date form-control' type='date'
                                                        path='bookDetails.publishDate'/>
                          </div>
                      </div>
                   <div class="form-group row">
                         <label for="colFormLabel" class="col-sm-2 col-form-label" >Number Of Pages</label>
                         <div class="col-sm-10">
                            <mvc:input class='number-of-pages form-control' type='number' placeholder='Number Of Page'
                                                       path='bookDetails.numberOfPage'/>
                            <mvc:errors path="bookDetails.numberOfPage"/>
                         </div>
                     </div>
                   <div class="form-group row">
                         <label for="colFormLabel" class="col-sm-2 col-form-label" >Category</label>
                         <div class="col-sm-10">
                            <mvc:select path="category.id" class="category form-control" >
                                 <mvc:option value="0" label="----select----"/>
                                 <mvc:options items="${categoryList}"/>
                             </mvc:select>
                             <mvc:errors path="category.id"/>
                         </div>
                     </div>


            </div>
                <div style="display:flex;justify-content: center;"><div><button class="green-text-button" type="submit">Update Book</button></div></div>

        </div>
    </mvc:form>
</div>
</body>
</html>