console.log("Entered the Logoutcontroller");
app.controller('LogoutController', function($scope, $rootScope, $http,$location,
		$cookieStore) {
	

	$rootScope.userhome = false;
	$rootScope.login = true;
	$rootScope.register = true;
	
	$rootScope.home = false;
	
	$rootScope.logout = false;
	
	$scope.logout = function() {
		console.log("logout")
		$rootScope.currentUser = {};
		$cookieStore.remove('currentUser');
		$http.get("http://localhost:8080/ApplcationBackEnd/user/logout")
		.then(
		       function(resposne){
		    	   return response.data;
		       },
		       function(errResponse){
		    	   console.log('Error while logging out');
		    	   return $q.reject(errResponse)
		       }
		);
		$location.path('/');

		}
	
});
