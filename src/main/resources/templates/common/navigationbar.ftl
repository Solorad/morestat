<!-- Navigation -->

<nav class="navbar navbar-light bg-faded navbar-static-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <a class="navbar-brand" href="#">MORESTAT</a>

        <#if !authorizationUrl??>
            <ul class="nav navbar-nav">
                <li class="nav-item<#if activeTab == 'profile'> active</#if>">
                    <a href="profile"> <@spring.message "morestat.main-page.profile"/></a>
                </li>
                <li class="nav-item<#if activeTab == 'gallery'> active</#if>">
                    <a href="gallery"> <@spring.message "morestat.main-page.gallery"/></a>
                </li>
                <li class="nav-item<#if activeTab == 'popular'> active</#if>">
                    <a href="popular"> <@spring.message "morestat.main-page.popular"/></a>
                </li>
                <li class="nav-item<#if activeTab == 'search'> active</#if>">
                    <a href="search"><@spring.message "morestat.main-page.search"/> </a>
                </li>
                <li class="nav-item<#if activeTab == 'logout'> active</#if>">
                    <a href="logout" class="nav-link"><@spring.message "morestat.main-page.logout"/></a>
                </li>
            </ul>
        </#if>
        <ul class="nav nav-pills pull-xs-right">
            <#if authorizationUrl??>
                <li class="nav-item">
                    <a href="/login" class="updated_padding nav-link">
                        <img src="/images/instagram-512.png" width="32px"/>
                        <span><@spring.message "morestat.main-page.button.login"/></span>
                    </a>
                </li>
            </#if>
            <li class="nav-item">
                <a href="?lang=ru" class="updated_padding nav-link">
                    <div class="header__language_rus"></div>
                </a>
            </li>
            <li class="nav-item">
                <a href="?lang=en" class="updated_padding nav-link">
                    <div class="header__language_eng"></div>
                </a>
            </li>
        </ul>
    </div>
</nav>