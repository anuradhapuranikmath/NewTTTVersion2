app.factory('RegisterService', function ($http, $q, $location) {
    var fac = {};
    fac.SaveFormData = function (register) {
        var defer = $q.defer();
        console.log(register);
                  
        $http({
            url: 'http://localhost:8080/ApplcationBackEnd/adduser',
            method: 'POST',
            data: register,
            headers: { 'content-type': 'application/json' }
        });
		
        return defer.promise;
		
    }
    return fac; 
});
   