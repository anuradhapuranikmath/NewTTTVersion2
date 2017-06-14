
app.factory('RegisterService', function ($http, $q, $location) {
    var fac = {};

    fac.loginUserData = function (userlogin) {
        var defer = $q.defer();
        console.log(userlogin);
        $http({
            url: 'http://localhost:8080/ApplcationBackEnd/login',
            method: 'POST',
            data: userlogin,
            headers: { 'content-type': 'application/json' }
        }).then(function(response){
            $location.path('/home');
        });
        return defer.promise;
    }
    
    return fac;
});