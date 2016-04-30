<!-- Navigation -->

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">MORESTAT</a>
        </div>

        <div class="collapse navbar-collapse">
        <#if !authorizationUrl??>
                <ul class="nav navbar-nav">
                    <li <#if activeTab == 'profile'>class="active" </#if>>
                        <a href="profile"> <@spring.message "morestat.main-page.profile"/></a>
                    </li>
                    <li <#if activeTab == 'gallery'>class="active" </#if>>
                        <a href="gallery"> <@spring.message "morestat.main-page.gallery"/></a>
                    </li>
                    <li <#if activeTab == 'popular'>class="active" </#if>>
                        <a href="popular"> <@spring.message "morestat.main-page.popular"/></a>
                    </li>
                    <li <#if activeTab == 'search'>class="active" </#if>>
                        <a href="search"><@spring.message "morestat.main-page.search"/> </a>
                    </li>
                    <li <#if activeTab == 'logout'>class="active" </#if>>
                        <a href="logout"><@spring.message "morestat.main-page.logout"/></a>
                    </li>
                </ul>
            </#if>
            <ul class="nav navbar-nav navbar-right">
                <#if authorizationUrl??>
                    <li>
                        <a href="${authorizationUrl}" class="updated_padding">
                            <img src="resources/images/instagram-512.png" width="32px"/>
                            <span><spring:message code="morestat.main-page.button.login"
                                                  text="Войти в инстаграмм"/></span>
                        </a>
                    </li>
                </#if>
                <li>
                    <a href="?lang=ru" class="updated_padding">
                        <div class="header__language_rus"></div>
                    </a>
                </li>
                <li>
                    <a href="?lang=en" class="updated_padding">
                        <div class="header__language_eng"></div>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>