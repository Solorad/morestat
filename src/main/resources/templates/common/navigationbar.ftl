<!-- Navigation -->

<nav class="navbar navbar-fixed-top bg-inverse navbar-dark">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">MORESTAT</a>
        </div>

        <div>
        <#if !unauthorized??>
            <ul class="nav navbar-nav">
                <li class="nav-item<#if activeTab == 'profile'> active</#if>">
                    <a href="profile" class="nav-link"> <@spring.message "morestat.main-page.profile"/></a>
                </li>
                <li class="nav-item<#if activeTab == 'gallery'> active</#if>">
                    <a href="gallery" class="nav-link"> <@spring.message "morestat.main-page.gallery"/></a>
                </li>
                <li class="nav-item<#if activeTab == 'popular'> active</#if>">
                    <a href="popular" class="nav-link"> <@spring.message "morestat.main-page.popular"/></a>
                </li>
                <li class="nav-item<#if activeTab == 'search'> active</#if>">
                    <a href="search" class="nav-link"><@spring.message "morestat.main-page.search"/> </a>
                </li>
            </ul>
        </#if>
            <ul class="nav nav-pills pull-xs-right">
                <#if unauthorized??>
                    <li class="nav-item">
                        <a href="https://api.instagram.com/oauth/authorize/?client_id=df5cc67d71e04b1b9a89ca9e1572a801&redirect_uri=http://localhost:8080/login&response_type=code&scope=public_content+likes+comments+follower_list+relationships"
                           class="updated_padding nav-link btn-info-outline">
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
                <#if !unauthorized??>
                    <li class="nav-item">
                        <form action="/logout" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button type="submit"
                                    class="btn btn-warning-outline"><@spring.message "morestat.main-page.logout"/></button>
                        </form>
                    </li>
                </#if>
            </ul>
        </div>
    </div>
</nav>