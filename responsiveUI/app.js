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
}]);
