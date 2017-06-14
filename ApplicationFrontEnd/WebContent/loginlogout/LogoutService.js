app.factory('RegisterService', function ($http, $q, $location) {
    var fac = {};
    
    
    
    
    fac.logoutUser = function (userlogin) {
        var defer = $q.defer();
        $http({
            url: 'http://localhost:8080/AppRestServices/logout',
            method: 'PUT',
            data: userlogin,
            headers: { 'content-type': 'application/json' }
        });
        return defer.promise;
    }
    
    
    
    
    
    
    return fac;
    
});