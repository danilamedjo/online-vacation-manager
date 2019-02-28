function editWorkerCtrl($scope, $routeParams, $location, workerService, departmentService) {

	$scope.oldWorker = {};
	$scope.departments = [];

	console.log($routeParams);

	var id = $routeParams.wid;

	var getOldWorker = () => {
		workerService.getWorker(id, res => {
			$scope.oldWorker = res.data;
		});
	};

	var getDepartments = () => {
		departmentService.getDepartments(res => {
			$scope.departments = res.data;
		});
	};

	getOldWorker();
	getDepartments();


	$scope.editWorker = () => {
		workerService.editWorker($scope.oldWorker.id, $scope.oldWorker, res => {
			$location.path('/workers');
		});
	};

}