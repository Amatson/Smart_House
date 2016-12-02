'use strict';

angular.module('smartHouseApp.bedRoom', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/bedRoom', {
    templateUrl: 'bedRoom/bedRoom.html',
    controller: 'BedRoomCtrl'
  });
}])

.controller('BedRoomCtrl',['$scope', 'GlobalVariables', function($scope, GlobalVariables){
  $scope.updateScope = function() {
    $scope.roomTemperature = GlobalVariables.temperatureBedroom;
    $scope.roomHumidity = GlobalVariables.humidityBedroom;

    $scope.roomLights = GlobalVariables.lightBedroom;

    $scope.overrideTemp = GlobalVariables.overrideTemp;
    $scope.temperatureHouse = GlobalVariables.temperatureHouse;
    $scope.roomTemperatureSet = GlobalVariables.temperatureBedroomSet;

    $scope.alerts = GlobalVariables.alerts;
    $scope.overrideLight = GlobalVariables.overrideLight;
  }

  $scope.updateScope();

  $scope.toggleRoomLights = function() {
    GlobalVariables.lightBedroom = (GlobalVariables.lightBedroom) ? (false) : (true);
    $scope.updateScope();
  }

    $scope.heater = function(up) {
      if(up){
        GlobalVariables.temperatureBedroomSet += 1;
      }
      else {
        GlobalVariables.temperatureBedroomSet -= 1;
      }
      $scope.updateScope();
    }

}]);
