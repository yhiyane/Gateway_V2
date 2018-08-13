app.service('userServices', function ($http) {
    this.chercherAll = function (motCle, pageCourante, size) {
        return $http.get("http://localhost:8080/users/all");
    }
    this.searchU = function (motCle, pageCourante, size) {
        return $http.get("http://localhost:8080/users/search?mc=" + motCle + "&page=" + pageCourante + "&size=" + size);
    }
    this.getStudents = function () {
        return $http.get("http://localhost:8080/users/allUsers");

    }
    this.getUser = function (url,id) {
        return $http.get(url+id);
    }
    this.saveObject = function (url,object) {
        alert('accès saveObjects service');
        return $http.post(url,object);
    }
    this.updateObject = function (url,object,roles) {
        alert('accès update service');

        return $http.put(url,object,roles);
    }
    this.goToRouter = function (state, $state) {
        return $state.go(state, {}, {reload: true});
    }
});
