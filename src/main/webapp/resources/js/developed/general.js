var Morestat = Morestat || {};

Morestat.Login = (function() {
    function init() {
        $("#russianLanguageButton").on("click", function() {
            $.get("/rest/locale", "ru_RU");
        });
        $("#englishLanguageButton").on("click", function() {
            $.get("/rest/locale", "en");
        });
    }

    return {
        init: init
    }
})();

Morestat.Login.init();
