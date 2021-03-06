"use strict"

$(function () {
    $('[data-toggle="popover"]').popover({
        html : true,
        placement:"bottom",
        title: "Add Entry",
        content: function() {
            return $("#popover-content").html();
        }
    })
});

$('.myPopover').on('shown.bs.popover', function () {
    $('.closePop').click(function(){
        $('.popover').popover('hide')
    })
    $(".saveEntry").click(function (e) {
        $('.popover').popover('hide')
    });
})

$('.addHabitId').click(function () {
    var a = $(this);
    $('#userBadgeId').val(a.attr('data-id'));
});

$(function () {
    $('[data-toggle="popover2"]').popover({
        html : true,
        placement:"bottom",
        title: "Add Clan Entry",
        content: function() {
            return $("#clanPopover-content").html();
        }
    })
});
$('.myClanPopover').on('shown.bs.popover', function () {
    $('.closePop').click(function(){
        $('.popover').popover('hide')
    })
})

$('.addClanHabitId').click(function () {
    var a = $(this);
    $('#clanBadgeId').val(a.attr('data-id'));
});

$(function () {
    $('[data-toggle="popover3"]').popover({
        html : true,
        placement:"bottom",
        title: "Add Clan Entry",
        content: function() {
            return $("#clanProfilePopover-content").html();
        }
    })
});
$('.myClanPopover').on('shown.bs.popover', function () {
    $('.closePop').click(function(){
        $('.popover').popover('hide')
    })
})

$('.addClanHabitId').click(function () {
    var a = $(this);
    $('#clanProfileBadgeId').val(a.attr('data-id'));
});

var delayTime = 300;
var fadeTime = 300;
var growTime = 400;
$(document).ready(function(){
   $('.badgeClass').each(function (i) {
       $(this).hide().css('position','absolute').delay(delayTime*i).fadeIn(fadeTime, function () {
           $(this).animate({fontSize: '75px'},growTime,function () {
               $(this).css('font-size','32px');
               $(this).css('position','initial');
           });
       });
   });

    $('.badgeClassClan').each(function (i) {
        $(this).hide().delay(delayTime*i).fadeIn(fadeTime, function () {
                $(this).css('font-size','51px');
        });
    })
});