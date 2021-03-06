'use strict';

/**
 * @ngdoc function
 * @name oaseApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the oaseApp
 */
angular.module('oaseApp')
  .controller('MainCtrl', function ($scope,$uibModal,$sessionStorage,$log) {
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
    $scope.user = $sessionStorage.user;

    $scope.selectedReport = -1;
    $scope.toggleReport = function (index) {
      if ($scope.selectedReport === index)
        $scope.selectedReport = -1;
      else
        $scope.selectedReport = index;
    };

    $scope.loadImage = function () {
      $scope.openModal('lg');
    };



    $scope.items = ['image_modal'];
    $scope.animationsEnabled = true;

    $scope.openModal = function (size) {

      var modalInstance = $uibModal.open({
        animation: $scope.animationsEnabled,
        templateUrl: 'views/image_modal.html',
        controller: 'ModalInstanceCtrl',
        size: size,
        windowClass: 'gruntapp-modal-window',
        resolve: {
          items: function () {
            return $scope.items;
          }
        }
      });

      modalInstance.result.then(function (selectedItem) {
        $scope.selected = selectedItem;
      }, function () {
        $log.info('Modal dismissed at: ' + new Date());
      });
    };

    $scope.toggleAnimation = function () {
      $scope.animationsEnabled = !$scope.animationsEnabled;
    };

  });

