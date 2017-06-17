console.log("Entered the Logincontroller");

app.controller("LoginController",['$cookieStore','$scope','$http','$location','$rootScope',
						function($cookieStore, $scope, $http, $location,
								$rootScope) {
							console.log("in login controller");
							$scope.login = function() {
								var logi = {
									name : $scope.name,
									password : $scope.password,

								}
								$http.post("http://localhost:1011/SocialMediaBackend/",logi).then(
												function(response) {
													console.log("result data:"
															+ response.data);
													var r = response.data
															.toString();
													console
															.log("response:"
																	+ r);

													if (r == 1) {
														$rootScope.userhome = true;
														
														$rootScope.register = false;
														$rootScope.home = true;
														$rootScope.login = false;
														$rootScope.logout = true;

														console
																.log('logout:'
																		+ $rootScope.logout);
														console
																.log("logged out:"
																		+ response.data);
														$rootScope.uname = $scope.name;
														$http.defaults.headers.common['Authorization'] = 'Basic '
																+ $rootScope.uname;
														$cookieStore
																.put(
																		'uname',
																		$rootScope.uname)

														console
																.log("uname:"
																		+ $rootScope.uname);
														$location.path('/home');
													}
													if (r == 0) {
														$scope.name = "";
														$scope.password = "";
														$scope.message = "You have entered invalid credentials";
														$location.path('/login');
													}
													if (r == 2) {
														$rootScope.uname = $scope.name;
														$rootScope.home = true;
														$rootScope.login = false;
																												$rootScope.register = false;
														$rootScope.jobs = true;
														$rootScope.logout = true;
														$rootScope.blogs = false;
														$location
																.path('/home');
													}
												});
							}
						} ]);


app.run(function($rootScope, $location, $cookieStore, $http) {

	$rootScope.$on('$locationChangeStart', function(event, next, current) {
		console.log("$locationChangeStart")

		// redirect to login page if not logged in and trying to access a
		// restricted page
		var restrictedPage = $.inArray($location.path(), [ '/', '/', '/login',
				'/register' ]) === -1;
		console.log("restrictedPage:" + restrictedPage)
		var loggedIn = $rootScope.uname;
		console.log("loggedIn:" + loggedIn)

		if (!loggedIn) {

			if (restrictedPage) {
				console.log("Navigating to login page:")

				$location.path('/login');
			}
		}

	});

	// keep user logged in after page refresh
	$rootScope.uname = $cookieStore.get('uname') || {};
	if ($rootScope.uname) {
		$http.defaults.headers.common['Authorization'] = 'Basic '
				+ $rootScope.uname;
	}
});