'use strict';

// Declare app level module which depends on views, and components
angular.module('smartHouseApp', [
  'ngRoute',
  'smartHouseApp.home',
  'smartHouseApp.mainRoom',
  'smartHouseApp.bedRoom',
  'smartHouseApp.livingRoom'
])
.config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/home'});
}])
.factory('GlobalVariables', function() {
  return {
      temperatureOut: 16,
      humidityOut: 60,
      bulb: "black",
      light: false,
      lockFront: true,
      lockBack: true,
      lockAll: true,
      overrideTemp: true,
      temperatureHouse: 22
  };
});
