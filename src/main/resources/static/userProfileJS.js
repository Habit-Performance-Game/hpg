"use strict"

$(function () {
    $('[data-toggle="popover"]').popover({
        html : true,
        title: "Add Entry",
        content: function() {
            return $("#popover-content").html();
        }
    })
});
$('.myPopover').on('shown.bs.popover', function () {
    $('.btn-danger').click(function(){
        $('.popover').popover('hide')
    })
})

$('.addHabitId').click(function () {
    var a = $(this);
    $('#userBadgeId').val(a.attr('data-id'));
});

$(function () {
    $('[data-toggle="popover2"]').popover({
        html : true,
        title: "Add Clan Entry",
        content: function() {
            return $("#clanPopover-content").html();
        }
    })
});
$('.myClanPopover').on('shown.bs.popover', function () {
    $('.btn-danger').click(function(){
        $('.popover').popover('hide')
    })
})

$('.addClanHabitId').click(function () {
    var a = $(this);
    $('#clanBadgeId').val(a.attr('data-id'));
});