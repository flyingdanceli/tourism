$(function () {
  $('[data-toggle="tooltip"]').tooltip();
  $("#navbar ul li:eq("+$("body").data("menu")+")").addClass("active");
})