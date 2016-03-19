'use strict';

/**
 * @ngdoc function
 * @name oaseApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the oaseApp
 */
angular.module('oaseApp')
  .controller('MainCtrl', function ($scope) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $scope.reports = [
      {
        "id": 1,
        "timestamp": new Date(),
        "recommendation": "Go to doctor."
      },
      {
        "id": 2,
        "timestamp": new Date(),
        "recommendation": "Go to home."
      }
    ];

    $scope.selectedReport = -1;
    $scope.toggleReport = function (index) {
      if ($scope.selectedReport === index)
        $scope.selectedReport = -1;
      else
        $scope.selectedReport = index;
    };
  });
