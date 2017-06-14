app.controller('LoginController', function($scope,RegisterService, $location, $rootScope, $cookieStore){
  $scope.loginUser = function () {
                 RegistrationService.loginUserData($scope.userlogin)
                 .then(function (response) {
                   console.log(response);
                  $scope.userlogin= response.data;
                   console.log($scope.userlogin);
                   $rootScope.currentUser=response.data;
                   $cookieStore.put("currentUser",response.data);
                 });
  
     }
     $scope.logoutUser = function () {
       console.log("logout");
                    RegistrationService.logoutUser($scope.userlogin).then(function (response) {
                    });

        }
});