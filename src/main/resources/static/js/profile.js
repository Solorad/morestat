var Morestat = Morestat || {};


Morestat.Profile = (function(){
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    function init() {
        $.post("/retrieveUserSnapshot", function(data) {
            console.log(data);
        })
    }


    return {
        init : init
    }
})();


$(document).ready(function() {
    Morestat.Profile.init();
});
