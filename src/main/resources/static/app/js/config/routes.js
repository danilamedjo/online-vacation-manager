app.config(function ($routeProvider) {
    $routeProvider
    .when('/',{
        templateUrl: '/app/views/home.html'
    })
    .when('/filmovi',{
        templateUrl: '/app/views/filmovi.html'
    })
    .when('/filmovi/edit/:aid',{
        templateUrl: '/app/views/editFilmovi.html'
    })
    .otherwise({
        redirectTo: '/'
    });
});