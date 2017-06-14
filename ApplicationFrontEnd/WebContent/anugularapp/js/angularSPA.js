app.config(['$locationProvider', function($locationProvider) {
  $locationProvider.hashPrefix('');

}]);
app.config(['$routeProvider',function($routeProvider){
  $routeProvider.when('/home',{
    templateUrl:'home/home.html',
    controller:'UserHomeController'
  }).when('/register',{
    templateUrl:'register/register.html',
    controller:'registerController'
  }).when('/login',{
    templateUrl:'loginlogout/login.html',
    controller:'LoginController'
  }).otherwise({ redirectTo: '/login' });
}]);