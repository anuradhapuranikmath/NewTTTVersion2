var app = angular.module('myApp', [ 'ngRoute' ,'ngCookies']);

app.config(function($routeProvider) {
	console.log(" i am inside app js ");
  $routeProvider

 
  .when('/home', {
    templateUrl : 'collab/home/home.html',
    	controller : 'UserHomeController'
  })

    
  .when('/login', {
    templateUrl : 'collab/loginlogout/Login.html',
    	controller:'LoginController'
    	
  })
  
  .when('/logout', {
    templateUrl : 'collab/loginlogout/logout.html',
    	controller : 'LogoutController' 
    	
  })
  
  .when('/register', {
    templateUrl : 'collab/register/register.html',
    controller : 'RegisterController' 	
    	   
  })
  
  
  .otherwise({redirectTo: '/'});
});