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
      bulb: "white",
      light: false,
      lockFront: true,
      lockBack: true,
      lockAll: true,
      overrideTemp: true,
      temperatureHouse: 22,
      overrideLight: true,
      alerts: "No alerts",

      temperatureMainroom: 21,
      temperatureMainroomSet: 22,
      humidityMainroom: 42,
      lightMainroom: false,

      temperatureLivingroom: 22,
      temperatureLivingroomSet: 22,
      humidityLivingroom: 40,
      lightLivingroom: false,

      temperatureBedroom: 20,
      temperatureBedroomSet: 23,
      humidityBedroom: 39,
      lightBedroom: false
  };
});
