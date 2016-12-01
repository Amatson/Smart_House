'use strict';

angular.module('smartHouseApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'home/home.html',
    controller: 'HomeCtrl'
  });
}])

/*
.controller('HomeCtrl', [function() {

}]);
*/



.controller('HomeCtrl',['$scope', function($scope){

  //$scope.bool = true;
  $scope.lockFront = true;
  $scope.lockBack = true;
  $scope.lockAll = true;

  $scope.testDoors = function(door) {
    if(door == "allDoors") {
        $scope.lockFront = !$scope.lockAll;
        $scope.lockBack = !$scope.lockAll;
    }
    else if(door == "frontDoor") {
      $scope.lockFront = !$scope.lockFront;
    }
    else if(door == "backDoor") {
      $scope.lockBack = !$scope.lockBack;
      }
    $scope.lockAll = $scope.lockBack && $scope.lockFront;
    }

}]);




function lockDoors(state) {
  // State value changes AFTER this script is run so we are looking at previous state here
  if (state == "open") {
    document.getElementById('lockAllDoors').name = "locked"
    //alert("Locking all the doors");
  }
  else {
    document.getElementById('lockAllDoors').name = "open"
    //alert("Unlocking all the doors")
  }
}


function turnLights(button) {
  if(button == "turnLightsOn") {
    document.getElementById("turnLightsOn").className="btn btn-default disabled"
    document.getElementById("turnLightsOn").childNodes[0].nodeValue="Lights are on"
    document.getElementById("turnLightsOff").className="btn btn-warning"
    document.getElementById("turnLightsOff").childNodes[0].nodeValue="Turn lights off"
  }
  else {
    document.getElementById("turnLightsOn").className="btn btn-primary"
    document.getElementById("turnLightsOn").childNodes[0].nodeValue="Turn lights on"
    document.getElementById("turnLightsOff").className="btn btn-default disabled"
    document.getElementById("turnLightsOff").childNodes[0].nodeValue="Lights are off"
  }
}
