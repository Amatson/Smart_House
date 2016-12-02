'use strict';

angular.module('smartHouseApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'home/home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl',['$scope', function($scope){

  $scope.temperature_out = 16;
  $scope.humidity_out = 70;

  $scope.bulb = "bulb_off.png"
  $scope.light = false;

  $scope.lockFront = true;
  $scope.lockBack = true;
  $scope.lockAll = true;

  $scope.override = true;
  $scope.tempUpClass = "btn btn-default btn-xs disabled";
  $scope.temperature_override = 22;

  $scope.turnLights = function() {
    $scope.light = ($scope.light) ? (false) : (true);
  //  $scope.bulb = ($scope.light) ? ("bulb_on.png") : ("bulb_off.png");
    $scope.bulb = ($scope.light) ? ("#ffcc00") : ("black");
  }

  $scope.lockDoors = function(door) {
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

    $scope.tempOverride = function(up) {
      if(up){
        $scope.temperature_override += 1;
      }
      else {
        $scope.temperature_override -= 1;
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

/*

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
*/
