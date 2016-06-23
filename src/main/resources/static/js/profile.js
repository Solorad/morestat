var Morestat = Morestat || {};


Morestat.Profile = (function(){
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
