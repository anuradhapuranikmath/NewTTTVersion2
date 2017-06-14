var app = angular.module("hash", ['ngRoute', 'ngCookies']);
app.run(function($rootScope, $cookieStore, RegistrationService, $location) {
	console.log('entering run method ')
	console.log($rootScope.currentUser)
	if ($rootScope.currentUser == undefined) {
		$rootScope.currentUser = $cookieStore.get("currentUser")
		console.log($rootScope.currentUser)
	}
	$rootScope.logout = function() {
		console.log('logout function')
		delete $rootScope.currentUser;
		$cookieStore.remove('currentUser')
		UserService.logout().then(function(response) {
			console.log("logged out successfully..");
			$rootScope.message = "Loggedout Successfully"
			$location.path('/login')
		}, function(response) {
			console.log(response.status);
		})
	}
});