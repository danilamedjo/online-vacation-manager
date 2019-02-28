vacationApp.config(function ($routeProvider) {
    $routeProvider
    .when('/',{
        templateUrl: '/app/views/home.html'
    })
    .when('/workers',{
        templateUrl: '/app/views/workers.html'
    })
    .when('/workers/edit/:wid',{
        templateUrl: '/app/views/editWorker.html'
    })
    .otherwise({
        redirectTo: '/'
    });
});