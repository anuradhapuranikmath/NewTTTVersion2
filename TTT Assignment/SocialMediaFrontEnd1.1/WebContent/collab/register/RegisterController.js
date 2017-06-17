console.log("Entered Register controller");

app.controller('RegisterController', ['$scope', '$http','$location', function($scope,$http,$location){
    $scope.register = function(){
    	console.log("Inside Register Controller");
    
       var name=$scope.userName;
       var password=$scope.password;
       var mobile=$scope.userEmail;
       
       console.log("name",name);
     
       var uploadUrl = "http://localhost:1011/SocialMediaBackend/addUser";
       $http.post(uploadUrl).then(
				function(response) {
					console.log("result data:"
							+ response.data);
					var r = response.data
							.toString();
					console
							.log("response:"
									+ r);
				});
       $scope.message="You are sucessfully registered!!!!";
       $location.path('/');
      
    };
 }]);



