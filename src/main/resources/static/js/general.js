var Morestat = Morestat || {};

Morestat.Login = (function() {
    function init() {
        $(".language-chooser").on("click", function() {
            $.get(baseUrl + "/rest/locale", {"locale" : $(this).val()}).done(function() {
                location.reload();
            });
        });
    }

    return {
        init: init
    }
})();
