$(document).ready(function () {
    $('.add').click(function(){
        $('#add-form').attr('action', 'add');
        $(document.getElementsByClassName('add-form')).css('display', 'block');
        ($(document.getElementsByClassName('add-form'))).addClass('active');
        ($(document.getElementsByTagName('header'))).addClass('blur');
        ($(document.getElementsByTagName('main'))).addClass('blur');
    })