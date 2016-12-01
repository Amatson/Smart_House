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
  $scope.lockAll = true;
  $scope.lockFront = true;
  $scope.lockBack = true;

  $scope.testDoors = function(door) {
    if(door == "allDoors") {
      if($scope.lockAll){
        $scope.lockAll = false;
        $scope.lockFront = false;
        $scope.lockBack = false;
      }
      else {
        $scope.lockAll = true;
        $scope.lockFront = true;
        $scope.lockBack = true;
      }
    }
    else if(door == "frontDoor") {
      if($scope.lockFront){
        $scope.lockAll = false;
        $scope.lockFront = false;
      }
      else {
        $scope.lockAll = true;
        $scope.lockFront = true;
      }
    }
    else if(door == "backDoor") {
      if($scope.lockBack){
        $scope.lockAll = false;
        $scope.lockBack = false;
      }
      else {
        $scope.lockAll = true;
        $scope.lockBack = true;
      }
    }
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
