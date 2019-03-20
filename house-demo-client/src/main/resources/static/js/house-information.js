$(document).ready(function() {
$(".big-img").hide();
$(".apply").click(function() {
	window.location.href = "/house/session/show/again?houseId="+ $(".houseId").text();
							})
$(".small-img").mouseover(function() {
	$(this).parents("div").children(".big-img").show();
	}).mouseout(function() {
	$(this).parents("div").children(".big-img").hide();
	});
})
