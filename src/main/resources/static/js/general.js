var Morestat = Morestat || {};

Morestat.General = (function() {
    function init() {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");

        $.ajaxSetup({
            headers: { "X-CSRF-TOKEN" : token }
        });
    }

    return {
        init: init
    }
})();

$(document).ready(function() {
    Morestat.General.init();
});
