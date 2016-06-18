var Morestat = Morestat || {};

Morestat.General = (function() {
    function init() {
        $("#logout").on("click", function() {
            console.log("logout");
            $.post("logout");
        });
    }

    return {
        init: init
    }
})();

$(document).ready(function() {
    Morestat.General.init();
});
