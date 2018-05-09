'use strict';

$('.form-group>p').css('color','red');

$('#repeatPassword').keyup(function () {
    if($('#password').val() != $(this).val()){
        $('#repeatPasswordError').removeClass('hiddenElement');
    }else {
        $('#repeatPasswordError').addClass('hiddenElement');
    }
});

$('#submitRegistration').click(function (event) {
    if ($.trim($('#email').val())=="" || $.trim($('#username').val())=="" || $.trim($('#password').val())=="" || $.trim($('#repeatPassword').val())=="") {
        event.preventDefault();
        if($.trim($('#email').val())==""){
            $('#emailError').removeClass('hiddenElement')
        }else{
            $('#emailError').addClass('hiddenElement')
        }
        if($.trim($('#username').val())==""){
            $('#usernameError').removeClass('hiddenElement')
        }else{
            $('#usernameError').addClass('hiddenElement')
        }
        if($.trim($('#password').val())==""){
            $('#passwordError').removeClass('hiddenElement')
        }else{
            $('#passwordError').addClass('hiddenElement')
        }
        return;
    }
})